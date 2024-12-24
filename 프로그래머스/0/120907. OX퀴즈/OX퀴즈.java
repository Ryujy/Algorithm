class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i=0; i<quiz.length; i++){
            String[] e = quiz[i].split(" ");
                   
            int result = Integer.parseInt(e[0]) + (Integer.parseInt(e[2]) * (e[1].equals("+")?1:-1) );
            
            answer[i] = (result == Integer.parseInt(e[4]) ? "O" : "X");
        }
        return answer;
    }
}