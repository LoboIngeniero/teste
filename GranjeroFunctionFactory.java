/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.granjero;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author josftm
 */
public class GranjeroFunctionFactory {
    private static ActionsFunction _actionsFunction = null;
    private static ResultFunction _resultFunction = null;

    public static ActionsFunction getActionsFunction() {
        if (null == _actionsFunction) {
            _actionsFunction = new GranjeroFunctionFactory.GActionsFunction();
        }
        return _actionsFunction;
    }

    public static ResultFunction getResultFunction() {
        if (null == _resultFunction) {
            _resultFunction = new GranjeroFunctionFactory.GResultFunction();
        }
        return _resultFunction;
    }
    
    private static class GActionsFunction implements ActionsFunction {
        public Set<Action> actions(Object state) {
            GranjeroBoard board = (GranjeroBoard) state;
            Set<Action> actions = new LinkedHashSet<Action>();

            if (board.canMove(GranjeroBoard.CABRA)) {
                actions.add(GranjeroBoard.CABRA);
            }
            if (board.canMove(GranjeroBoard.LOBO)) {
                actions.add(GranjeroBoard.LOBO);
            }
            if (board.canMove(GranjeroBoard.COL)) {
                actions.add(GranjeroBoard.COL);
            }
            return actions;
        }
    }
    
    private static class GResultFunction implements ResultFunction {

        public Object result(Object s, Action a) {
            GranjeroBoard board = (GranjeroBoard) s;

            if (GranjeroBoard.CABRA.equals(a) && board.canMove(GranjeroBoard.CABRA)) {
                GranjeroBoard newBoard = new GranjeroBoard(board);
                newBoard.moveCABRA();
                return newBoard;
            } else if (GranjeroBoard.LOBO.equals(a) && board.canMove(GranjeroBoard.LOBO)) {
                GranjeroBoard newBoard = new GranjeroBoard(board);
                newBoard.moveLOBO();
                return newBoard;
            } else if (GranjeroBoard.COL.equals(a) && board.canMove(GranjeroBoard.COL)) {
                GranjeroBoard newBoard = new GranjeroBoard(board);
                newBoard.moveCOL();
                return newBoard;
            }

            // The Action is not understood or is a NoOp
            // the result will be the current state.
            return s;
        }
    }
}
