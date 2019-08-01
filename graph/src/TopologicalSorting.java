
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author manohar_gupta
 */

/* Topological sorting is only applicable for Directed Acyclic Graph*/
public class TopologicalSorting {

    ArrayList<Integer> que;
    DirectedGraph g;
    int count=0;
    public TopologicalSorting(DirectedGraph g){
        que=new ArrayList<>();
        this.g=g;
    }
    public void topologicalSorting(){
        for(Vertex v: g.vertexList){
            if(v.indegree==0){
                que.add(v.v);
                count++;
                //System.out.println(v.v);
            }
        }
        while(que.size()>0){
            int temp=que.remove(0);
            System.out.println(temp);
            for(int i:g.vertices[temp]){
                g.vertexList[i].indegree--; 
                if(g.vertexList[i].indegree==0){
                    que.add(i);
                    count++;
                }
            }            
        }
        if(count!=g.vertexcount){
            System.out.println("Graph has a cycle");
        }
    }
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int v=in.nextInt();
        DirectedGraph g=new DirectedGraph(v);
        int edges=in.nextInt();
        for(int i=0;i<edges;i++){
            int source=in.nextInt();
            int dest=in.nextInt();
            g.addEdge(source, dest);
        }
        TopologicalSorting ts=new TopologicalSorting(g);
        ts.topologicalSorting();
    }
}
