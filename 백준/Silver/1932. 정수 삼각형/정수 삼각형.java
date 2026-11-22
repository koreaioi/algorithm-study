
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] dp;
    public static int[][] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][N + 1];
        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        dp[1][1] = arr[1][1];
        for (int i = 2; i <= N; i++) {

            dp[i][1] = dp[i-1][1] + arr[i][1];
            for (int j = 2; j <= i-1; j++) {
                dp[i][j] =  Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
            dp[i][i] = dp[i-1][i-1] + arr[i][i];
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dp[N][i]);
        }
        System.out.println(answer);
    }

}
