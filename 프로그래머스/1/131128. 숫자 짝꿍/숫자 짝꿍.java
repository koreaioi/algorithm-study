import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Deque deque = new ArrayDeque<>();
        for(char c : X.toCharArray()){
            deque.push(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : Y.toCharArray()){
            if(deque.contains(c)){
                deque.remove(c);
                sb.append(c);
            }
        }
        
        if(sb.toString().isBlank()){
            return "-1";
        }
        
        char[] chars = sb.toString().toCharArray();
        ArrayList<Character> al = new ArrayList<>();
        for(char c : chars){
            al.add(c);
        }
        
        Collections.sort(al, Collections.reverseOrder());
        sb = new StringBuilder();
        for(Character c : al){
            sb.append(c);
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}