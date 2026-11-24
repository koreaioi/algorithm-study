
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static Queue<Point> q = new LinkedList<Point>();
    public static int[][] board;
    public static boolean[][] visited;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                board[i][j] = tomato;
            }
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                int tomato = board[i][j];
                if(tomato == 1){
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        // == 초기화 끝
        bfs();

        // bfs가 끝났을 때, 탐색해서 0이 남아있으면 -1
//        for (int[] arr : board) {
//            for (int x : arr) {
//                System.out.print(x + " ");
//            }
//            System.out.println();
//        }

        for (int[] arr : board) {
            for (int x : arr) {
                if (x == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        System.out.println(answer-1);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int L = q.size();
            for (int t = 0; t < L; t++) {
                Point pt = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = pt.x + dx[i];
                    int ny = pt.y + dy[i];
                    if (ny >= 0 && ny < M && nx >= 0 && nx < N && !visited[ny][nx] && board[ny][nx] != -1) {
                        q.add(new Point(ny, nx));
                        board[ny][nx] = 1;
                        visited[ny][nx] = true; // 갔다고 체크
                    }
                }

            }
            answer++;
        }


    }

    public static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
