package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.some_example_name.GraphLoader.Edge;
import io.github.some_example_name.GraphLoader.Node;

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

    private int clicksQtyty = 0; // (0 first click), (1 second click)

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

                float lon = (worldCoords.x - offsetX) / scale + minLon;
                float lat = (worldCoords.y - offsetY) / scale + minLat;
                System.out.println(lon + " | " + lat + " |");

                long selectedNodeId = 1;
                boolean hit = false;
                for (Node n : nodes) {
                    if (lon > n.lon - 0.0005 && lon < n.lon + 0.0005) {
                        if (lat > n.lat - 0.0005 && lat < n.lat + 0.0005) {
                            // System.out.println("NUM: " + n.id + "\n\n-------HIT---------\n\n");
                            hit = true;
                            selectedNodeId = n.id;
                            break;
                        }
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
                        long startTime = System.currentTimeMillis();
                        startAlgorithm(new AStar(edges, nodes), start, end);
                        long endTime = System.currentTimeMillis();
                        System.out.println("Прошло " + (endTime - startTime) + "");

                        //

                        startTime = System.currentTimeMillis();
                        startAlgorithm(new Dijkstra(edges), start, end);
                        endTime = System.currentTimeMillis();
                        System.out.println("Прошло " + (endTime - startTime) + "");
                    }
                }
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                if (drag) {
                    int margin;
                    if (startScreenX != screenX) {
                        margin = startScreenX - screenX;
                        offsetX += margin;
                    }
                    if (startScreenY != screenY) {
                        margin = startScreenY - screenY;
                        offsetY -= margin;
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
                float zoomFactor = 1.1f;
                if (amountY < 0) {
                    scale *= zoomFactor;
                } else {
                    scale /= zoomFactor;
                }
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
            shapeRenderer.end();
        }
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
