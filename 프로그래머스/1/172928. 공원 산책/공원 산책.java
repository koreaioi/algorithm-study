import java.util.*;

class Solution {
    
    public static char[][] board;
    public static int H;
    public static int W;
    public static int y = 0;    
    public static int x = 0;
    
    public int[] solution(String[] park, String[] routes) {
        H = park.length;
        W = park[0].length();
        // System.out.println(W);
        board = new char[H][W];
        
        for(int i = 0 ; i < H ; i++){
            board[i] = park[i].toCharArray();
        }
        
        for(int i = 0 ; i < H ; i++){
            for(int j = 0 ; j < W ; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        
        for(int i = 0 ; i < H ; i++){
            for(int j = 0 ; j < W ; j++){
                if(board[i][j] == 'S'){
                    y = i;
                    x = j;
                    break;
                }
            }
        }
        System.out.println(y + ", " +x);
        
        for(String route : routes){
            String[] r = route.split(" ");
            String c = r[0]; // 명령어
            String w = r[1]; // 방향
            
            int weight = Integer.valueOf(w);
            
            int dy =0;
            int dx =0;
            boolean flag = true;
        
            for(int i = 0 ; i < weight ; i++){
                if(c.equals("E")) dx++;
                else if(c.equals("W")) dx--;
                else if(c.equals("N")) dy--;
                else if(c.equals("S")) dy++;
                
                // 여기서 장애물 체크 + borad범위 체크
                if(!canMove(y + dy, x + dx)){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                y+= dy;
                x+= dx;
            }
        }
        
        
        int[] answer = {y,x};
        return answer;
    }
    
    public static boolean canMove(int ny, int nx){
        return ny >= 0 && ny < H && nx >= 0 && nx < W && board[ny][nx] != 'X';
    }
    
}