import models.GraphEnvironment;
import models.TravelerAgent;
import models.agents.Goal;
import models.agents.State;
import models.graphs.Graph;
import models.strategies.Breadth_firstStrategy;
import models.strategies.Strategy;
import populators.GraphPopulator;

/**
 * Created by Florian on 06/02/2018.
 */
public class Main {

    public static void main(String[] args){
        Graph graph = GraphPopulator.populate();
        GraphEnvironment env = GraphEnvironment.getInstance(graph);
        State arad = graph.getNode("Arad").getState();
        State bucharest = graph.getNode("Bucharest").getState();
        Strategy strategy = new Breadth_firstStrategy();
        TravelerAgent agent = new TravelerAgent("Guinea pig",arad,strategy,new Goal("Bucharest",bucharest));
        env.addAgent(agent);
        env.setAgentLocation(agent,arad);
        agent.run();
        //Node start = graph.getNode("Arad");
        //List<Node> ancestors = new ArrayList<>();
        //ancestors.add(start);
        //TreeNode tree = TreeService.generateTreeFromGraph(graph,start,ancestors,0,0);
    }
}
