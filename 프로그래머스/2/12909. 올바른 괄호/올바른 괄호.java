import java.util.*;

class Solution {
    
    // 괄호 (,) -> 스택 국룰
    
    boolean solution(String input) {
        char[] spilted = input.toCharArray();

        Deque<Character> q = new ArrayDeque<>();
        boolean answer = true;
        q.push(spilted[0]); // stack처럼 쓸거면 push();
            
        for(int i = 1 ; i < spilted.length ; i++){
            char s = spilted[i];
            if(s == '('){
                q.push(s);
                continue;
            }
            
            if(s == ')' && q.size()==0){
                return false;
            }
            
            if(s == ')' && q.peek() == '('){
                q.pop();
                continue;
            }
        }
        
        if(q.size() > 0){
            answer = false;
        }
        
        return answer;
    }
}