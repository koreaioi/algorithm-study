
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 메모리 초과 발생
 * 100,000 * 100,000....
 * <p>
 * 음... DP에 필요한 건 직전의 값...!?
 * 일단 배열 포기! 하드코딩!
 *
 */
public class Main {

    public static final int COUNT_OF_NUMBER = 3;

    public static int n;
    public static int[][] board;
    public static int[] maxDp = new int[COUNT_OF_NUMBER];
    public static int[] minDp = new int[COUNT_OF_NUMBER];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < COUNT_OF_NUMBER; i++) {
            int value = Integer.parseInt(st.nextToken());
            maxDp[i] = value;
            minDp[i] = value;
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int n0 = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            int pMaxDp0 = maxDp[0];
            int pMaxDp1 = maxDp[1];
            int pMaxDp2 = maxDp[2];

            int pMinDp0 = minDp[0];
            int pMinDp1 = minDp[1];
            int pMinDp2 = minDp[2];

            maxDp[0] = Math.max(n0 + pMaxDp0, n0 + pMaxDp1);
            maxDp[1] = Math.max(n1 + pMaxDp0, Math.max(n1 + pMaxDp1, n1 + pMaxDp2));
            maxDp[2] = Math.max(n2 + pMaxDp1, n2 + pMaxDp2);

            minDp[0] = Math.min(n0 + pMinDp0, n0 + pMinDp1);
            minDp[1] = Math.min(n1 + pMinDp0, Math.min(n1 + pMinDp1, n1 + pMinDp2));
            minDp[2] = Math.min(n2 + pMinDp1, n2 + pMinDp2);
        }

        System.out.println(Arrays.stream(maxDp).max().getAsInt());
        System.out.println(Arrays.stream(minDp).min().getAsInt());
    }

}
