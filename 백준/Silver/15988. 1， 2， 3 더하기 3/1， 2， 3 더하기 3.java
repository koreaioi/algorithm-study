

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://acmicpc.net/problem/15988
 *
 */
public class Main {

    public static int T;
    public static int N = 1_000_000;
    public static final int QUOTIENT = 1_000_000_009;
    public static int[] dp;
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        long[] dp = new long[N + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) %  QUOTIENT;
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.valueOf(st.nextToken());
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb.toString());
    }

}
