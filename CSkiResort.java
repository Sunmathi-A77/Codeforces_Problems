import java.util.*;
public class CSkiResort
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t  =  sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n];
            
            for(int i = 0; i < n; i++)
            {
                int a = sc.nextInt();
                if(a <= q)
                {
                    arr[i] = 1;
                }
                else
                {
                    arr[i] = 0;
                }
            }

            long cnt = 0;
            long ans = 0;
            for(int i = 0; i < n; i++)
            {
                if(arr[i] == 1)
                {
                    cnt ++;
                }
                else
                {
                    if(cnt >= k)
                    {
                        long l = cnt - k + 1;
                        ans += (l* (l + 1)) / 2;
                    }
                    cnt = 0;
                }
            }

            if(cnt >= k)
            {
                long l = cnt - k + 1;
                ans += (l* (l + 1)) / 2;
            }

            System.out.println(ans);
        }
    }
}