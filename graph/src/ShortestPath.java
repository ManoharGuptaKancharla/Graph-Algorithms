
import java.util.ArrayList;
import java.util.Scanner;

/** @author manohar_gupta
 */
/*----Shortest Path Algorithm for Unweighted Directed Graph-----*/
public class ShortestPath {
    int distances[];
    int path[];
    int source;
    DirectedGraph g;
    public ShortestPath(DirectedGraph g,int source){
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
    public void shortestPath(){
        ArrayList<Integer> arr = new ArrayList<>();
        int s=this.source;
        arr.add(s);
        while(arr.size()>0){
            int temp=arr.remove(0);
            int new_dis=distances[temp]+1;
            for(int i:this.g.vertices[temp]){
                if(this.distances[i]==-1){
                    distances[i]=new_dis;
                    path[i]=temp;
                    arr.add(i);
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
            System.out.println(this.distances[i]);
        }
    }
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int v=in.nextInt();
        int edges=in.nextInt();
        DirectedGraph g = new DirectedGraph(v);
        for(int i=0;i<edges;i++){
            int source=in.nextInt();
            int dest=in.nextInt();
            g.addEdge(source, dest);
        }
        System.out.println("Enter the source vertex");
        int s=in.nextInt();
        ShortestPath sp = new ShortestPath(g,s);
        sp.shortestPath();
    }
}
