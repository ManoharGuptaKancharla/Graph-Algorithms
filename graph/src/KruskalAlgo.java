
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author manohar_gupta
 */
public class KruskalAlgo {
    ArrayList<HashSet<Integer>> arr;
    PriorityQueue<Edge> pq;
    public KruskalAlgo(int v){
        this.arr = new ArrayList<>();
        pq=new PriorityQueue<>(new Comparator<Edge>(){
            @Override
            public int compare(Edge e1,Edge e2){
                return e1.weight-e2.weight;
            }
        });
        for(int i=0;i<v;i++){
            arr.add(new HashSet());
            arr.get(i).add(i);
        }
    }
    public void kruskalAlgo(int edges){        
        int count=0;
        for(int i=0;i<edges;i++){
            Scanner in = new Scanner(System.in);
            int source=in.nextInt();
            int dest=in.nextInt();
            int weight=in.nextInt();
            this.pq.add(new Edge(weight,source,dest));
        }
        while(this.arr.size()!=1){
            Edge temp=this.pq.poll();
            int s_index=-1;
            int d_index=-1;
            for (int i=0;i<this.arr.size();i++) {
                if(this.arr.get(i).contains(temp.source)){
                    s_index=i;
                }
                if(this.arr.get(i).contains(temp.dest)){
                    d_index=i;
                }
            }
            if(s_index!=d_index){
                for(int i:this.arr.get(d_index)){
                    this.arr.get(s_index).add(i);
                }
                this.arr.remove(d_index);
                count+=temp.weight;
            }
            
        }
        System.out.println("Weight of minimum spanning tree "+ count);
    }
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int v=in.nextInt();
        int edges=in.nextInt();
        KruskalAlgo ka = new KruskalAlgo(v);
        ka.kruskalAlgo(edges);
    }
}
