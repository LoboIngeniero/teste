/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.granjero;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import java.util.Arrays;

/**
 *
 * @author josftm
 */
public class GranjeroBoard {
    
    public static Action LOBO = new DynamicAction("LOBO");
    public static Action CABRA = new DynamicAction("CABRA");
    public static Action COL = new DynamicAction("COL");
    
    private int[] state;
    
    public GranjeroBoard(){
        state = new int[]{1,1,1};
    }
    
    public GranjeroBoard(int[] state){
        this.state = new int[state.length];
        System.arraycopy(state, 0, this.state, 0, state.length);
    }
    
    public GranjeroBoard(GranjeroBoard copyBoard){
        this(copyBoard.getState());
    }
    
    public int[] getState() {
        return state;
    }
    
    public void moveLOBO(){
        if(this.state[0]==0){
            this.state[0]=1;
        }else{
            this.state[0]=0;
        }
    }
    
    public void moveCABRA(){
        if(this.state[1]==0){
            this.state[1]=1;
        }else{
            this.state[1]=0;
        }
    }
    
    public void moveCOL(){
        if(this.state[2]==0){
            this.state[2]=1;
        }else{
            this.state[2]=0;
        }
    }
    
    public boolean canMove(Action where){
        boolean retVal=true;
        
        if(where.equals(LOBO)){
            retVal= this.state[1]!=this.state[2];
        }else if (where.equals(CABRA)){
            retVal= true;
        }else if(where.equals(COL)){
            retVal= this.state[0]!=this.state[1];;
        }

        return retVal;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        GranjeroBoard aBoard = (GranjeroBoard) o;

        for (int i = 0; i < state.length; i++) {
            if (this.state[i] != aBoard.state[i]) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Arrays.hashCode(this.state);
        return hash;
    }

    @Override
    public String toString() {
        String retVal = "[ " + state[0] + " , " + state[1] + " , " + state[2] + " ]";
        return retVal;
    }
    
}
