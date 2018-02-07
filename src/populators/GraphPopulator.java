package populators;

import models.graphs.Graph;
import models.graphs.Node;

/**
 * Created by Florian on 06/02/2018.
 */
public class GraphPopulator {

    public static Graph populate(){
        Graph graph = new Graph("Voyage à Bucharest");
        Node Arad = (new Node("Arad"));
        Node Zerind = (new Node("Zerind"));
        Node Oradea = (new Node("Oradea"));
        Node Sibiu = (new Node("Sibiu"));
        Node Fagaras = (new Node("Fagaras"));
        Node Timisoara = (new Node("Timisoara"));
        Node Lugoj = (new Node("Lugoj"));
        Node Mehadia = (new Node("Mehadia"));
        Node Dobreta = (new Node("Dobreta"));
        Node Craiova = (new Node("Craiova"));
        Node Rimnicu_Vilcea = (new Node("Rimnicu Vilcea"));
        Node Pitesti = (new Node("Pitesti"));
        Node Bucharest = (new Node("Bucharest"));
        Node Giurgiu = (new Node("Giurgiu"));
        Node Urziceni = (new Node("Urziceni"));
        Node Hirsova = (new Node("Hirsova"));
        Node Eforie = (new Node("Eforie"));
        Node Vaslui = (new Node("Vaslui"));
        Node Iasi = (new Node("Iasi"));
        Node Neamt = (new Node("Neamt"));

        graph.addNode(Arad);
        graph.addNode(Zerind);
        graph.addNode(Oradea);
        graph.addNode(Sibiu);
        graph.addNode(Fagaras);
        graph.addNode(Timisoara);
        graph.addNode(Lugoj);
        graph.addNode(Mehadia);
        graph.addNode(Dobreta);
        graph.addNode(Craiova);
        graph.addNode(Rimnicu_Vilcea);
        graph.addNode(Pitesti);
        graph.addNode(Bucharest);
        graph.addNode(Giurgiu);
        graph.addNode(Urziceni);
        graph.addNode(Hirsova);
        graph.addNode(Eforie);
        graph.addNode(Vaslui);
        graph.addNode(Iasi);
        graph.addNode(Neamt);

        graph.addPath(Arad,Zerind,75);
        graph.addPath(Arad,Timisoara,118);
        graph.addPath(Lugoj,Timisoara,111);
        graph.addPath(Lugoj,Mehadia,70);
        graph.addPath(Dobreta,Mehadia,75);
        graph.addPath(Dobreta,Craiova,120);
        graph.addPath(Arad,Sibiu,140);
        graph.addPath(Zerind,Oradea,71);
        graph.addPath(Sibiu,Oradea,151);
        graph.addPath(Sibiu,Fagaras,99);
        graph.addPath(Bucharest,Fagaras,211);
        graph.addPath(Sibiu,Rimnicu_Vilcea,80);
        graph.addPath(Craiova,Rimnicu_Vilcea,146);
        graph.addPath(Pitesti,Rimnicu_Vilcea,97);
        graph.addPath(Pitesti,Craiova,138);
        graph.addPath(Pitesti,Bucharest,101);
        graph.addPath(Giurgiu,Bucharest,90);
        graph.addPath(Urziceni,Bucharest,85);
        graph.addPath(Urziceni,Hirsova,98);
        graph.addPath(Eforie,Hirsova,86);
        graph.addPath(Urziceni,Vaslui,142);
        graph.addPath(Iasi,Vaslui,92);
        graph.addPath(Iasi,Neamt,87);

        return graph;
    }
}
