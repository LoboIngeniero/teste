/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.granjero;

import aima.core.search.framework.GoalTest;

/**
 *
 * @author josftm
 */
public class GranjeroGoalTest implements GoalTest{
    GranjeroBoard goal = new GranjeroBoard(new int[]{0,0,0});
    
    @Override
    public boolean isGoalState(Object state) {
        GranjeroBoard board = (GranjeroBoard) state;
        return board.equals(goal);
    }
}
