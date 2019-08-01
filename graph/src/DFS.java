
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manohar_gupta
 */
public class DFS {
    public static void dfs(Graph g){
        Stack<Integer> theStack=new Stack<>();
        g.vertexList[0].visited=true;
        g.display(0);
        theStack.push(0);
        while(!theStack.empty()){
            int temp=g.getAdjUnvisitedVertex(theStack.peek());
            if(temp!=-1){
                g.vertexList[temp].visited=true;
                g.display(temp);
                theStack.push(temp);
            }
            else{
                theStack.pop();
            }
        }
        for(int i=0;i<g.vertexcount;i++){
            g.vertexList[i].visited=false;
        }        
    }
    
}
