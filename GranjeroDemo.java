/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.gui.demo.search;

import aima.core.agent.Action;
import aima.core.environment.granjero.GranjeroBoard;
import aima.core.environment.granjero.GranjeroFunctionFactory;
import aima.core.environment.granjero.GranjeroGoalTest;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.uninformed.BreadthFirstSearch;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author josftm
 */
public class GranjeroDemo {
    
    static GranjeroBoard boardInicial = new GranjeroBoard(new int[]{1,1,1});
    
    public static void main(String args[]) {
        searchBreathDemo();
    }
    
    private static void searchBreathDemo() {
        System.out.println("\nGranjero Breath -->");
        try {
            Problem problem = new Problem(boardInicial, GranjeroFunctionFactory.getActionsFunction(), GranjeroFunctionFactory.getResultFunction(), new GranjeroGoalTest());
            Search search = new BreadthFirstSearch();
            SearchAgent agent = new SearchAgent(problem, search);
            printActions(agent.getActions());
            System.out.println("\t-----");
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     private static void printActions(List<Action> actions) {
        for (int i = 0; i < actions.size(); i++) {
            String action = actions.get(i).toString();
            System.out.println("\t"+action);
        }
    }

    private static void printInstrumentation(Properties properties) {
        Iterator<Object> keys = properties.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            System.out.println("\t"+key + " : " + property);
        }
    }
}
