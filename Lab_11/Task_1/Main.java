package Lab_11.Task_1;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Start Lab_11 \n");

        GraphLoader loader = new GraphLoader();

        var nodes = loader.readNodes("Lab_11/simple/nodes.csv");
        var edges = loader.readEdges("Lab_11/simple/edges.csv");
        
        System.out.println("\nNodes:");
        for (var i : nodes) {
            System.out.print(i.id + " ");
            System.out.print(i.lon + " ");
            System.out.println(i.lat);
        }

        System.out.println("\nEdges:");
        for (var i : edges) {
            System.out.print(i.u + " ");
            System.out.println(i.v);
        }

        System.out.println("End Lab_11 \n");
    }
}
