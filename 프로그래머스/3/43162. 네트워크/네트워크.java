import java.util.*;

class Solution {
    
    public static int L;
    
    public int solution(int n, int[][] computers) {
        L = computers.length;
        // for(int i = 0 ; i< L;i++){
            // computers[i][i] = 0;
        // }

        int answer = 0;
        for(int i = 0; i< L;i++){
            for(int j = 0 ; j < L ; j++){
                if(computers[i][j] == 1){
                    findAndMask(i, computers);
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public static void findAndMask(int startComputer, int[][] computers){
        computers[startComputer][startComputer] = 0;
        
        for(int i = 0 ; i< L ;i++){
            if(computers[startComputer][i] == 1){
                computers[startComputer][i] = 0;
                computers[i][startComputer] = 0;
                findAndMask(i, computers);
            }
        }
    }
    
}