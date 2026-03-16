
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final int MINIMUM_BOARD_SIZE = 1;
    public static int n, r, c, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = (int) (Math.pow(2, Integer.parseInt(st.nextToken())));
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        recursion(n, 0, 0);
        System.out.println(count);
    }

    private static void recursion(int boardSize, int x, int y) {
        if (isMinimumSize(boardSize) && isTargetPosition(x, y)) {
            return;
        }

        int half = boardSize / 2;
        if (containTarget(half, x, y)) { // Left Up
            recursion(half, x, y);
            return;
        }

        if (containTarget(half, x, y + half)) { // Right Up
            count += (int) (Math.pow(half, 2)) * 1;
            recursion(half, x, y + half);
            return;
        }

        if (containTarget(half, x + half, y)) { // Left Down
            count += (int) (Math.pow(half, 2)) * 2;
            recursion(half, x + half, y);
            return;
        }

        if (containTarget(half, x + half, y + half)) { // Right Down
            count += (int) (Math.pow(half, 2)) * 3;
            recursion(half, x + half, y + half);
            return;
        }

    }

    private static boolean isMinimumSize(int boardSize) {
        return boardSize == MINIMUM_BOARD_SIZE;
    }

    public static boolean isTargetPosition(int x, int y) {
        return x == r && y == c;
    }

    private static boolean containTarget(int boardSize, int x, int y) {
        return (x <= r && r < x + boardSize) && (y <= c && c < y + boardSize);
    }

}
