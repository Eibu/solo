package models.strategies;

import models.agents.Problem;

/**
 * Created by Florian on 06/02/2018.
 * Default template for the strategies classes like breadth-first, ...
 * /!\MUST OVERRIDE "compareToBest" and "applyStrategy"/!\
 */
public class Strategy {








    //To override in extension
    protected void compareToBest(Problem problem, SearchAlgorithm algorithm){

    }

    //To override in extension
    protected void applyStrategy(Problem problem, SearchAlgorithm algorithm){

    }
}
