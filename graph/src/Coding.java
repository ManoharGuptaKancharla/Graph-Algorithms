
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Coding {
    public static void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            int len=Integer.parseInt(br.readLine());
            String s[]=br.readLine().trim().split(" ");
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i=0;i<len;i++){
                arr.add(Integer.parseInt(s[i]));
            }  
            int res=0;
            System.out.println(arr.size());
            if(arr.size()%2==0){
                while(arr.size()>1){
                arr.add(arr.remove(0)^arr.remove(1));
                }
                res=arr.get(0);
            }
            else{
                int temp=arr.remove(arr.size()-1);
                while(arr.size()>1){
                arr.add(arr.remove(0)^arr.remove(1));
                }
                res=temp^arr.get(0);
            }
            System.out.println(res);
        }
        
        
    }
    
}
