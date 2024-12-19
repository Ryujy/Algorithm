class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i=0; i<quiz.length; i++){
            String[] e = quiz[i].split(" ");
            
            int result = 0;
            if(e[1].equals("+")){
                result = Integer.parseInt(e[0]) + Integer.parseInt(e[2]);
            } else{
                result = Integer.parseInt(e[0]) - Integer.parseInt(e[2]);
            }
            
            if (result == Integer.parseInt(e[4])){
                    answer[i] = "O";
            } else {
                    answer[i] = "X";
            }
        }
        return answer;
    }
}