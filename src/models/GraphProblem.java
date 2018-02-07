package models;

import models.agents.Agent;
import models.agents.Goal;
import models.agents.Problem;
import models.graphs.Graph;
import models.graphs.Node;
import models.trees.Tree;
import models.trees.TreeNode;
import services.TreeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 */
public class GraphProblem extends Problem{


    private Agent agent;
    private Tree tree;

    public GraphProblem(GraphState initialState, Agent agent) {
        super(initialState);
        this.agent = agent;
        addAction(new MoveToAction(null));
    }

    private void buildTree(){
        Graph graph = ((GraphState) initialEnvironmentState).getGraph();
        List<Node> ancestors = new ArrayList<>();
        ancestors.add(((GraphState) initialEnvironmentState).getAgentLocation(agent));
        TreeNode root = TreeService.generateTreeFromGraph(graph,
                ((GraphState) initialEnvironmentState).getAgentLocation(agent),
                ancestors,
                0,
                0);
        tree = new Tree(root);
    }

    @Override
    public Object Successors(Object o) {
        return super.Successors(o);
    }

    @Override
    public boolean testGoal(Goal goal) {
        return ((GraphState) initialEnvironmentState).getAgentLocation(agent).equals(goal.getGoal());
    }
}
