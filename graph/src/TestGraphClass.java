/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manohar_gupta
 */
import java.util.*;
public class TestGraphClass {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int vertexcount=in.nextInt();
        int edges=in.nextInt();
        Graph g=new Graph(vertexcount);
        for(int i=0;i<edges;i++){
            int source=in.nextInt();
            int dest=in.nextInt();
            g.addEdge(source, dest);
        }
        DFS.dfs(g);
        System.out.println();
        BFS.bfs(g)
                ;
    }
    
    
    
}
