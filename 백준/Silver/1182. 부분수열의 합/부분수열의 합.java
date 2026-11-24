
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://acmicpc.net/problem/1182
 *
 */
public class Main {

    public static int N, S, count;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N]; // 숫자를 저장해두는 배열.
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { // 초기화
            arr[i] = Integer.valueOf(st.nextToken());
        }

        dfs(0, 0);
        if(S == 0) count--;
        System.out.println(count);
    }

    // 반복문 없이 dfs로 풀기.
    public static void dfs(int sum, int depth) {
        if (depth == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        dfs(sum + arr[depth], depth + 1);
        dfs(sum, depth + 1);
    }

    // Combination으로 풀어보기.
    public static void combination(int sum, int depth, int startIndex) {
        // 종료 조건
        if (depth != 0 && sum == S) {
            count++;
        }

        if(depth == N){
            return;
        }

        // 조합
        for (int i = startIndex; i < N; i++) {
            combination(sum + arr[i], depth + 1, i + 1);
        }

    }

}
