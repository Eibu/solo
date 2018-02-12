import models.GraphEnvironment;
import models.TravelerAgent;
import models.agents.Goal;
import models.agents.State;
import models.graphs.Graph;
import models.strategies.UniformCostStrategy;
import models.strategies.Strategy;
import populators.GraphPopulator;

/**
 * Created by Florian on 06/02/2018.
 */
public class Main {

    public static void main(String[] args){
        Graph graph = GraphPopulator.populate();
        GraphEnvironment env = GraphEnvironment.getInstance(graph);

        String goal_name = "Bucharest";
        State start = graph.getNode("Arad").getState();
        State goal = graph.getNode(goal_name).getState();

        Strategy strategy = new UniformCostStrategy();
        TravelerAgent agent = new TravelerAgent("Guinea pig",start,strategy,new Goal(goal_name,goal));

        env.addAgent(agent);
        env.setAgentLocation(agent,start);

        agent.run();

    }
}
