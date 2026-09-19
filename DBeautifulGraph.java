import java.util.*;
import java.io.*;
public class DBeautifulGraph{
    public static boolean dfs(int node, int[] c, int[] vis, int[] parity, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = 1;
        for(int a : adj.get(node))
        {
            if(vis[a] == 0)
            {
                parity[a] = 1 - parity[node];
                if(parity[a] == 1)
                {
                    c[1] ++;
                } 
                else
                {
                    c[0] ++;
                }
                if(!dfs(a, c, vis, parity, adj)) 
                {
                    return false;
                }
            }
            else if(parity[a] == parity[node])
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException
    {
        FastScanner sc = new FastScanner(System.in);

        final int MOD = 998244353;
        long[] power = new long[300001];
        power[0] = 1;
        for(int i = 1; i <= 300000; i ++)
        {
            power[i] = (power[i-1] * 2) % MOD;
        }
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < n + 1; i++)
            {
                adj.add(new ArrayList<>());
            }
            for(int i = 0; i < m; i ++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            int[] vis = new int[n + 1];
            int[] parity = new int[n + 1];
            Arrays.fill(parity, -1);
            long ans = 1;
            for(int i = 1; i <= n; i ++)
            {
                if(vis[i] == 0)
                {
                    int[] c = new int[2];
                    parity[i] = 1;
                    c[1] = 1;
                    if(!dfs(i, c, vis, parity, adj))
                    {
                        ans = 0;
                        break;
                    }
                    long ways = (power[c[0]] + power[c[1]]) % MOD;
                    ans = (ans * ways) % MOD;
                }
            }
            System.out.println(ans);
        }
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


