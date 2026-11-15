import java.util.*;

class Solution {
    
    // 괄호 (,) -> 스택 국룰
    
    boolean solution(String input) {
        Deque<Character> q = new ArrayDeque<>();
        boolean answer = true;
        q.push(input.charAt(0)); // stack처럼 쓸거면 push();
            
        for(int i = 1 ; i < input.length() ; i++){
            char s = input.charAt(i);
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