import java.util.*;
public class BMonsters
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t  =  sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[n][2];
            
            for(int i = 0; i < n; i++)
            {
                int a = sc.nextInt();
                if(a % k == 0)
                {
                    arr[i][0] = k;
                    arr[i][1] = i;
                }
                else
                {
                    arr[i][0] = a % k;
                    arr[i][1] = i;
                }
            }

            Arrays.sort(arr, (a, b) -> {        //lambda function
                if(a[0] != b[0])
                {
                    return b[0] - a[0];
                }
                return a[1] - b[1];
            });

            for(int i = 0; i < n; i++)
            {
                System.out.print(arr[i][1]+1 + " ");
            }
            System.out.println();
        }
    }
}