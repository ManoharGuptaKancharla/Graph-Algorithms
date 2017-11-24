
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author manohar_gupta
 */
/*---------Shortest Path Algorithm for Graph with Negative Edges--------*/
public class BellmanFord {
    DirectedWeightedGraph g;
    int distances[];
    int path[];
    int source;
    public BellmanFord(DirectedWeightedGraph g,int source){
        this.g=g;
        this.source=source;
        distances=new int[g.vertexcount];
        path=new int[g.vertexcount];
        for(int i=0;i<g.vertexcount;i++){
            distances[i]=Integer.MAX_VALUE;
            path[i]=-1;
        }
        distances[source]=0;
        path[source]=source;
    }
    public void bellmanFord(){
        int source=this.source;
        ArrayList<Vertex> arr= new ArrayList<>();
        this.g.vertexList[source].weight=0;
        arr.add(this.g.vertexList[source]);
        while(arr.size()>0){
            int temp=arr.remove(0).v;
            for(int i:this.g.vertices[temp].get(0).keySet()){
                int new_dis=distances[temp]+this.g.vertices[temp].get(0).get(i);
                if(distances[i]>new_dis){
                    distances[i]=new_dis;
                    path[i]=temp;
                    this.g.vertexList[i].weight=new_dis;
                    arr.add(this.g.vertexList[i]);
                }
            }
        }
        for(int i=0;i<this.g.vertexcount;i++){
            ArrayList<Integer> a = new ArrayList<>();
            a.add(0, i);
            while(this.path[a.get(0)]!=this.source){
                a.add(0,this.path[a.get(0)]);
            }
            a.add(0,this.source);
            for(int j:a){
                System.out.print(j+" ");
            }
            System.out.println("\t" + this.distances[i]);
        }
    }
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int v=in.nextInt();
        int edges=in.nextInt();
        DirectedWeightedGraph g = new DirectedWeightedGraph(v);
        for(int i=0;i<edges;i++){
            int source=in.nextInt();
            int dest=in.nextInt();
            int weight=in.nextInt();
            g.addEdge(source, dest, weight);
        }
        System.out.println("Enter the source vertex");
        int source=in.nextInt();
        BellmanFord b= new BellmanFord(g,source);
        b.bellmanFord();
    }
}
