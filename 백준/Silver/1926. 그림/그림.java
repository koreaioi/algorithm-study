
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int count = 0;
    public static int max = 0;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[][] board;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    count++;
                    board[i][j] = 0;
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    public static int bfs(int startY, int startX) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startY, startX));

        int ext = 0;
        while (!q.isEmpty()) {
            Point pt = q.poll();
            for(int i = 0; i < 4; i++) {
                int ny = pt.y + dy[i];
                int nx = pt.x + dx[i];
                if(ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx] && board[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    board[ny][nx] = 0;
                    q.add(new Point(ny, nx));
                }
            }
            ext++;
        }


        return ext;
    }

    public static class Point{
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
