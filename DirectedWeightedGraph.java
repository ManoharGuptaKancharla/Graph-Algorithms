
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
/**
 *
 * @author manohar_gupta
 */
/*------------*/
public class DirectedWeightedGraph{
    protected int vertexcount;
    protected Vertex vertexList[];
    protected ArrayList<HashMap<Integer,Integer>> vertices[];
    public DirectedWeightedGraph(int v){
        this.vertexcount=v;
        vertexList=new Vertex[v];
        vertices=new ArrayList[v];
        for(int i=0;i<v;i++){
            vertices[i]=new ArrayList<>();
            vertices[i].add(new HashMap<>());
            vertexList[i]=new Vertex(i);
        }
    }
    public void addEdge(int source,int dest,int weight){
        vertexList[source].outdegree++;
        vertexList[dest].indegree++;
        vertices[source].get(0).put(dest, weight);
    }
    public void removeEdge(int source,int dest){
        vertexList[source].outdegree--;
        vertexList[dest].indegree--;
        vertices[source].get(0).remove(dest);
    }
    public void display(int i){
        System.out.println(vertexList[i].v);
    }
}
