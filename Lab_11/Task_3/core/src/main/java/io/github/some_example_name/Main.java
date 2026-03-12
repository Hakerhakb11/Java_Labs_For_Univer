package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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

    private double minLon, maxLon, minLat, maxLat;
    private float scale, offsetX, offsetY;

    private int clicksQtyty = 0; // (0 first click), (1 second click)

    public void startAlgorithm(long start, long end) {
        AStar astar = new AStar(edges, nodes);
        astar.computePaths(start, end);
        double dist = astar.getDistance(end);
        if (dist == Double.MAX_VALUE) {
            System.out.println("Путь не найден.");
            path = null;
        } else {
            System.out.println("Кратчайшее расстояние = " + dist);
            path = astar.getPath(end);
            // System.out.print("Путь: ");
            // for (long id : path) {
            // System.out.print(id + " ");
            // }
            System.out.println();
        }
    }

    @Override
    public void create() {

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                System.out.println("Клик на экране: (" + screenX + ", " + screenY + ")");

                Vector3 worldCoords = new Vector3(screenX, screenY, 0);
                camera.unproject(worldCoords);
                System.out.println("Клик на карте (" + worldCoords.x + ", " + worldCoords.y + ")");
                long start = 178263732;
                long end = 1246523904;

                if (clicksQtyty == 0) {
                    clicksQtyty = 1;

                    startAlgorithm(start, end);
                } else {
                    clicksQtyty = 0;

                }
                return true;
            }
        });

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
            Gdx.app.error("AStar", "Ошибка загрузки файлов");
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
            if (n.lon < minLon)
                minLon = n.lon;
            if (n.lon > maxLon)
                maxLon = n.lon;
            if (n.lat < minLat)
                minLat = n.lat;
            if (n.lat > maxLat)
                maxLat = n.lat;
        }

        scale = -6000;

        offsetX = 1650;
        offsetY = 1000;
    }

    @Override
    public void render() {
        float maxx = 0;
        float maxy = 0;
        float minx = 11111;
        float miny = 11111;
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
        // 73.3647597,54.9948633

        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        for (Node n : nodes) {
            float x = (float) ((n.lon - minLon) * scale) + offsetX;
            float y = (float) ((n.lat - minLat) * scale) + offsetY;
            shapeRenderer.circle(x, y, 2);
            if (maxx < x)
                maxx = x;
            if (maxy < y)
                maxy = y;
            if (minx > x)
                minx = x;
            if (miny > y)
                miny = y;
            // System.out.println(maxx + " |andMAX| " + maxy + " .");
            // System.out.println(minx + " |andMIN| " + miny + " .");
            // 159.47571 |andMIN| 62.316895 .
            // 1650.0 |andMAX| 1000.0 .
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