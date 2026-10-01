import java.util.*;
import java.io.*;

public class CRemovalOfUnattractivePairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();

            // Pass 1: Boyer-Moore majority vote to find the candidate
            int count = 0;
            char candidate = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (count == 0) {
                    candidate = c;
                }
                if (c == candidate) {
                    count++;
                } else {
                    count--;
                }
            }

            // Pass 2: count the real frequency of the candidate
            int freq = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == candidate) freq++;
            }

            int others = n - freq;
            int ans;
            if (freq > others) {
                ans = freq - others;   // majority survives
            } else {
                ans = n % 2;           // everything cancels except parity
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
