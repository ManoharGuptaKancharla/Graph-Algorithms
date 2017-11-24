
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manohar_gupta
 */
public class BFS {
    public static void bfs(Graph g){
        ArrayList<Integer> que = new ArrayList<>();
        que.add(0);
        g.display(0);
        g.vertexList[0].visited=true;
        while(que.size()>0){
            int temp=que.get(0);
            que.remove(0);
            for(int i:g.vertices[temp]){
                if(g.vertexList[i].visited==false){
                    g.vertexList[i].visited=true;
                    g.display(i);
                    que.add(i);                    
                }
            }            
        }
        for(int i=0;i<g.vertexcount;i++){
            g.vertexList[i].visited=false;
        }
    }
    
}
