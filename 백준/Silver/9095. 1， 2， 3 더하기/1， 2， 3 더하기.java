import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int[] arr = new int[num + 1];
        int[] dp = new int[11 + 1];
        for(int i = 1; i <= num; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.valueOf(st.nextToken());
        }

        // dp 미리 구해두기.
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            sb.append(dp[arr[i]]).append("\n");
        }

//        for (int index : arr) {
//            sb.append(dp[index]).append("\n");
//        }
        System.out.println(sb.toString());
    }

}
