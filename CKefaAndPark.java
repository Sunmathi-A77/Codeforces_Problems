import java.io.*;
import java.util.*;
public class CKefaAndPark{

    static int ans = 0;
    static void dfs(int node , int [] vis , int numC , int m , int [] arr , ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        if(arr[node-1] == 1) numC++;
        else numC = 0;
        if(numC > m) return;
        int adjNode = 0;
        for(int a : adj.get(node)){
            if(vis[a] == 0){
                adjNode++;
                dfs(a , vis , numC , m , arr , adj);
            }
        }
        if(adjNode==0) ans++;
    }
    
    public static void main(String [] args) throws IOException{
        FastScanner sc = new FastScanner(System.in);            //user-defined - faster than Scanner, used to escape from TLE
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int [] vis = new int[n+1];
        dfs(1 , vis , 0, m , arr , adj);
        System.out.println(ans);
    }
    
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;
        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if(ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if(len == -1)
                    return -1;
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;

            do {
                c = read();
            } while(c <= ' ');

            int num = 0;

            while(c > ' ') {
                num = num * 10 + (c - '0');
                c = read();
            }

            return num;
        }
    }
}