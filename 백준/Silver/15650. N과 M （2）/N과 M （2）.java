
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M]; // 사용할 숫자 개수 만큼

        combination(0, 0);
        System.out.println(sb.toString());
    }

    public static void combination(int depth, int start) {
        if (depth == M) {
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            arr[depth] = i + 1; // 사용할 숫자를 넣기.
            combination(depth + 1, i + 1);
            arr[depth] = 0;
        }

    }

}
