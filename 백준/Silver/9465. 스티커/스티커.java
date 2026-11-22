
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://acmicpc.net/problem/9465
 * */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        // 반복문 시작.
        for(int t = 0 ; t < T ; t++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] dp = new int[2 + 1][N + 1];
            int[][] arr = new int[2 + 1][N + 1];

            // DP 입력 값 초기화
            for (int i = 1; i <= 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];
            if (N == 1) {
                sb.append(Math.max(dp[1][1], dp[2][1])).append("\n");
                continue;
            }

            dp[1][2] = dp[2][1] + arr[1][2];
            dp[2][2] = dp[1][1] + arr[2][2];

            for (int j = 3; j <= N; j++) {
                dp[1][j] = Math.max(dp[2][j - 1], dp[2][j - 2]) + arr[1][j];
                dp[2][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[2][j];
            }

            int answer = Integer.MIN_VALUE;
            for (int[] ar : dp) {
                for (int x : ar) {
                    answer = Math.max(answer, x);
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }

}
