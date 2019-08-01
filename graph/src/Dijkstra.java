
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author manohar_gupta
 */
/*-----Shortest Path Algorithm for weighted Directed Graph with non negative weights------*/
public class Dijkstra {
    private int distances[];
    private int path[];
    private DirectedWeightedGraph g;
    private int source;
    public Dijkstra(DirectedWeightedGraph g,int source){
        this.source=source;
        this.g=g;
        distances=new int[g.vertexcount];
        path=new int[g.vertexcount];
        for(int i=0;i<g.vertexcount;i++){
            distances[i]=-1;
        }
        distances[source]=0;
        path[source]=source;
    }
    public void dijkstra(){
        PriorityQueue<Vertex> pq = new PriorityQueue<>(new Comparator<Vertex>(){
            @Override
            public int compare(Vertex v1,Vertex v2){
                return v1.weight-v2.weight;
        }
    });
        int s=this.source;
        Vertex v1=g.vertexList[s];
        v1.weight=Integer.MIN_VALUE;
        pq.offer(v1);
        while(!pq.isEmpty()){
            Vertex temp=pq.poll();
            for(int i:this.g.vertices[temp.v].get(0).keySet()){
                int new_dis=this.distances[temp.v]+this.g.vertices[temp.v].get(0).get(i);
                if(this.distances[i]==-1){
                    this.distances[i]=new_dis;
                    this.path[i]=temp.v;
                    g.vertexList[i].weight=new_dis;
                    pq.offer(g.vertexList[i]);
                }
                else{
                    if(distances[i]>new_dis){
                        if(pq.remove(g.vertexList[i])){
                            this.distances[i]=new_dis;
                            this.path[i]=temp.v;
                            g.vertexList[i].weight=new_dis;
                            pq.offer(g.vertexList[i]);
                        }
                    }
                            
                }
            }
        }
        /*for(int i=0;i<this.g.vertexcount;i++){
            System.out.print(this.path[i]+"\t");
        }*/
        for(int i=0;i<this.g.vertexcount;i++){
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(0, i);
            while(this.path[arr.get(0)]!=this.source){
                arr.add(0,this.path[arr.get(0)]);
            }
            arr.add(0,this.source);
            for(int j:arr){
                System.out.print(j+" ");
            }
            System.out.println("\t" + this.distances[i]);
        }
    }
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int v=in.nextInt();
        int edges=in.nextInt();
        DirectedWeightedGraph g=new DirectedWeightedGraph(v);
        for(int i=0;i<edges;i++){
            int source=in.nextInt();
            int dest=in.nextInt();
            int w=in.nextInt();
            g.addEdge(source, dest, w);
        }
        System.out.println("Enter the source vertex");
        int source=in.nextInt();
        Dijkstra d = new Dijkstra(g,source);
        d.dijkstra();
    }
}
