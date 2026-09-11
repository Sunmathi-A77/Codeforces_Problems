import java.util.*;
public class BArrayMerging
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t  =  sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            
            for(int i = 0; i < n; i++)
            {
                a[i] = sc.nextInt();
            }
            for(int i = 0; i < n; i++)
            {
                b[i] = sc.nextInt();
            }
            
            int[] h_a = new int[2*n+1];
            int[] h_b = new int[2*n+1];
            int cnt = 1;

            for(int i = 1; i < n; i++)
            {
                if(a[i] == a[i-1])
                {
                    cnt ++;
                }
                else
                {
                    h_a[a[i-1]] = Math.max(h_a[a[i-1]], cnt);
                    cnt = 1;
                }
            }
            h_a[a[n-1]] = Math.max(h_a[a[n-1]], cnt);
            
            cnt = 1;
            for(int i = 1; i < n; i++)
            {
                if(b[i] == b[i-1])
                {
                    cnt ++;
                }
                else
                {
                    h_b[b[i-1]] = Math.max(h_b[b[i-1]], cnt);
                    cnt = 1;
                }
            }
            h_b[b[n-1]] = Math.max(h_b[b[n-1]], cnt);
            
            int ans = 0;
            for(int i = 1; i <= 2*n; i++)
            {
                ans = Math.max(ans, h_a[i]+h_b[i]);
            }

            System.out.println(ans);
        }
    }
}