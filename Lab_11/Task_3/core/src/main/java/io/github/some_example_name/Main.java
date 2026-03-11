package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;
// import com.badlogic.gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.some_example_name.GraphLoader.Edge;
import io.github.some_example_name.GraphLoader.Node;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    // private SpriteBatch batch;
    // private Texture image;
    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
    private List<Node> nodes;
    private List<Edge> edges;

    private Node findNode(long id) {
    for (Node node : nodes) {
        if (node.id == id) {
            return node;
        }
    }
    return null;
}

    @Override
    public void create() {
        // batch = new SpriteBatch();
        // image = new Texture("libgdx.png");

        shapeRenderer = new ShapeRenderer();
        camera = new OrthographicCamera();
        // camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, 1920, 1080);
        GraphLoader loader = new GraphLoader();

        try {
            // nodes = loader.readNodes("assets/simple/nodes.csv");
            // edges = loader.readEdges("assets/simple/edges.csv");

            nodes = loader.readNodes("assets/omsk/nodes.csv");
            edges = loader.readEdges("assets/omsk/edges.csv");
        } catch (Exception e) {
            System.out.println("Eror!!\n");
            e.printStackTrace();
            Gdx.app.error("AStar", "Ошибка загрузки файлов");
            return;
        }

        Map<Long, Node> nodeMap = new HashMap<>();
        for (Node node : nodes) {
            nodeMap.put(node.id, node);
        }

        // System.out.println("\nNodes:");
        // for (Node node : nodes) {
        //     System.out.println(node.id + " " + node.lon + " " + node.lat);
        // }

        // System.out.println("\nEdges:");
        for (Edge edge : edges) {
            // System.out.println(edge.u + " " + edge.v);
            Node u = nodeMap.get(edge.u);
            Node v = nodeMap.get(edge.v);
            edge.dist = loader.eucledeanDist(u, v);
        }

        AStar astar = new AStar(edges, nodes);
        
        long start = 178263732;
        long end = 210321469;

        astar.computePaths(start, end);
        double dist = astar.getDistance(end);
        if (dist == Double.MAX_VALUE) {
            System.out.println("Путь не найден.");
        } else {
            System.out.println("Кратчайшее расстояние = " + dist);
            List<Long> path = astar.getPath(end);
            System.out.print("Путь: ");
            for (long i : path) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        // batch.begin();
        // batch.draw(image, 140, 210);
        // batch.end();

        float scale = 3f;
        float offsetX = 200f;
        float offsetY = 200f;
        // float screenX = (float)node.lon * scale + offsetX;
        // float screenY = (float)node.lat * scale + offsetY;

        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);

        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(Color.GRAY);
        for (Edge e : edges) {
            Node u = findNode(e.u);
            Node v = findNode(e.v);
            shapeRenderer.line(u.lon * scale + offsetX, u.lat * scale + offsetY,
                            v.lon * scale + offsetX, v.lat * scale + offsetY);
        }
        shapeRenderer.end();

        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        for (Node n : nodes) {
            shapeRenderer.circle(n.lon * scale + offsetX, n.lat * scale + offsetY, 3);
        }
        shapeRenderer.end();


        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.line(100, 100, 300, 300);
        shapeRenderer.end();

            
    }

    @Override
    public void dispose() {
        // batch.dispose();
        // image.dispose();
    
    
    }
}
