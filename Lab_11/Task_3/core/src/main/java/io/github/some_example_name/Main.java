package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
    private List<Node> nodes;
    private List<Edge> edges;
    private Map<Long, Node> nodeMap;
    private List<Long> path;

    private float minLon, maxLon, minLat, maxLat;
    private float scale, offsetX, offsetY;
    private long start, end;

    private SpriteBatch batch;
    private BitmapFont font;
    private String currentAlgorithmName = "Algorithm A*";
    private String currentControlLevel = "Difficulty: Eazy";
    
    private int clicksQtyty = 0; // (0 first click), (1 second click)
    private int selectedAlgorithm = 0; // (0 A*), (1 Dijkstra)
    private int selectedControlMode = 0; // (0 Eazy for Junior), (1 Hard for SSS Senior+)
    private final int[] SECRET_COMBINATION = {Input.Keys.Q, Input.Keys.W, Input.Keys.E, Input.Keys.R};
    private int combinationCount = 0;

    public void startAlgorithm(PathSearching algorithm, long start, long end) {
        algorithm.computePaths(start, end);
        double dist = algorithm.getDistance(end);
        if (dist == Double.MAX_VALUE) {
            System.out.println("Путь не найден.");
            path = null;
        } else {
            System.out.println("Кратчайшее расстояние = " + dist);
            path = algorithm.getPath(end);
            System.out.println();
        }
    }

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);

        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(3.0f);

        GraphLoader loader = new GraphLoader();
        try {
            nodes = loader.readNodes("assets/omsk/nodes.csv");
            edges = loader.readEdges("assets/omsk/edges.csv");
        } catch (Exception e) {
            System.out.println("Ошибка загрузки файлов!");
            e.printStackTrace();
            Gdx.app.error("FILE EROR", "Ошибка загрузки файлов");
            return;
        }

        nodeMap = new HashMap<>();
        for (Node node : nodes) {
            nodeMap.put(node.id, node);
        }

        for (Edge edge : edges) {
            Node u = nodeMap.get(edge.u);
            Node v = nodeMap.get(edge.v);
            edge.dist = loader.eucledeanDist(u, v);
        }

        minLon = nodes.get(0).lon;
        maxLon = nodes.get(0).lon;
        minLat = nodes.get(0).lat;
        maxLat = nodes.get(0).lat;
        for (Node n : nodes) {
            if (n.lon < minLon) {
                minLon = n.lon;
            } else if (n.lon > maxLon)
                maxLon = n.lon;

            if (n.lat < minLat) {
                minLat = n.lat;
            } else if (n.lat > maxLat)
                maxLat = n.lat;
        }

        scale = 6500;
        offsetX = 150;
        offsetY = 40;

        Gdx.input.setInputProcessor(new InputAdapter() {
            boolean drag = false;
            int startScreenX;
            int startScreenY;

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                if (button != Input.Buttons.LEFT) {
                    drag = true;
                    startScreenX = screenX;
                    startScreenY = screenY;
                    return true;
                }
                Vector3 worldCoords = new Vector3(screenX, screenY, 0);
                camera.unproject(worldCoords);
                System.out.println("Клик (" + worldCoords.x + ", " + worldCoords.y + ")");

                long selectedNodeId = -1;
                boolean hit = false;
                float maxClickRadiusInPixels = 30f;
                float minDistanceSq = maxClickRadiusInPixels * maxClickRadiusInPixels;

                for (Node n : nodes) {
                    float nodeX = (float) ((n.lon - minLon) * scale) + offsetX;
                    float nodeY = (float) ((n.lat - minLat) * scale) + offsetY;
                    float dx = worldCoords.x - nodeX;
                    float dy = worldCoords.y - nodeY;
                    float distSq = dx * dx + dy * dy;

                    if (distSq < minDistanceSq) {
                        minDistanceSq = distSq;
                        selectedNodeId = n.id;
                        hit = true;
                    }
                }

                if (clicksQtyty == 0) {
                    if (hit) {
                        clicksQtyty = 1;
                        start = selectedNodeId;
                    }
                } else {
                    if (hit) {
                        clicksQtyty = 0;
                        end = selectedNodeId;

                        // --------------- SELECT ALGORITHM -----------------------

                        if (selectedAlgorithm == 0) {
                            System.out.println("Алгоритм A*");
                            long startTime = System.currentTimeMillis();
                            startAlgorithm(new AStar(edges, nodes), start, end);
                            long endTime = System.currentTimeMillis();
                            System.out.println("Прошло " + (endTime - startTime) + "");
                        } else {
                            System.out.println("Алгоритм Дейкстры");
                            long startTime = System.currentTimeMillis();
                            startAlgorithm(new Dijkstra(edges), start, end);
                            long endTime = System.currentTimeMillis();
                            System.out.println("Прошло " + (endTime - startTime) + "");
                        }
                    }
                }
                return true;
            }

            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.B) {
                    if (selectedAlgorithm == 0) {
                        selectedAlgorithm = 1;
                        currentAlgorithmName = "Algorithm Dijkstra";
                        System.out.println("Выбран Алгоритм Дейкстры");
                        return true;
                    } else {
                        selectedAlgorithm = 0;
                        currentAlgorithmName = "Algorithm A*";
                        System.out.println("Выбран Алгоритм A*");
                        return true;
                    }
                }

                if (keycode == SECRET_COMBINATION[combinationCount]) {
                    combinationCount++;
                    if (combinationCount == 4) {
                        if (selectedControlMode == 0) {
                            combinationCount = 0;
                            selectedControlMode = 1;
                            currentControlLevel = "Difficulty: Hard";
                            return true;
                        } else {
                            combinationCount = 0;
                            selectedControlMode = 0;
                            currentControlLevel = "Difficulty: Eazy";
                            return true;
                        }
                    }
                    return true;
                } else if (keycode == SECRET_COMBINATION[0]) {
                    combinationCount = 1;
                    return true;
                } else {
                    combinationCount = 0;
                }
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                if (drag) {
                    int margin;
                    if (startScreenX != screenX) {
                        margin = startScreenX - screenX;
                        if (selectedControlMode == 0) {
                            startScreenX = screenX;
                        }
                        offsetX -= margin;
                    }
                    if (startScreenY != screenY) {
                        margin = startScreenY - screenY;
                        if (selectedControlMode == 0) {
                            startScreenY = screenY;
                        }
                        offsetY += margin;
                    }
                    return true;
                }
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                drag = false;
                return false;
            }

            @Override
            public boolean scrolled(float amountX, float amountY) {
                Vector3 mouseCoords = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
                camera.unproject(mouseCoords);
                float mouseX = mouseCoords.x;
                float mouseY = mouseCoords.y;

                float oldScale = scale;
                float zoomFactor = 1.1f;

                if (amountY < 0) {
                    scale *= zoomFactor;
                } else {
                    scale /= zoomFactor;
                }

                float scaleRatio = scale / oldScale;
                offsetX = mouseX - (mouseX - offsetX) * scaleRatio;
                offsetY = mouseY - (mouseY - offsetY) * scaleRatio;

                return true;
            }
        });
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);

        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(Color.GRAY);
        for (Edge e : edges) {
            Node u = nodeMap.get(e.u);
            Node v = nodeMap.get(e.v);
            if (u == null || v == null) {
                continue;
            }
            float ux = (float) ((u.lon - minLon) * scale) + offsetX;
            float uy = (float) ((u.lat - minLat) * scale) + offsetY;
            float vx = (float) ((v.lon - minLon) * scale) + offsetX;
            float vy = (float) ((v.lat - minLat) * scale) + offsetY;
            shapeRenderer.line(ux, uy, vx, vy);
        }
        shapeRenderer.end();

        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        for (Node n : nodes) {
            float x = (float) ((n.lon - minLon) * scale) + offsetX;
            float y = (float) ((n.lat - minLat) * scale) + offsetY;
            shapeRenderer.circle(x, y, 2);
        }
        shapeRenderer.end();

        if (path != null && path.size() > 1) {
            shapeRenderer.begin(ShapeType.Line);
            shapeRenderer.setColor(Color.GREEN);
            for (int i = 0; i < path.size() - 1; i++) {
                Node u = nodeMap.get(path.get(i));
                Node v = nodeMap.get(path.get(i + 1));
                if (u == null || v == null)
                    continue;
                float ux = (float) ((u.lon - minLon) * scale) + offsetX;
                float uy = (float) ((u.lat - minLat) * scale) + offsetY;
                float vx = (float) ((v.lon - minLon) * scale) + offsetX;
                float vy = (float) ((v.lat - minLat) * scale) + offsetY;
                shapeRenderer.line(ux, uy, vx, vy);
            }
        }
        shapeRenderer.end();
        batch.begin();
        font.draw(batch, currentAlgorithmName, 20, Gdx.graphics.getHeight() - 20);
        font.draw(batch, currentControlLevel, 20, Gdx.graphics.getHeight() - 70);
        batch.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        batch.dispose();
        font.dispose();
    }
}
