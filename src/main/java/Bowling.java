public class Bowling {

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    
    public static Integer bowlingGame(String s){
        s = s.replaceAll("\\s", "");
        int score = 0;
        int frame = 0;
        int roll = 0;
        for (int i = 0; i < s.length(); i++){
            String cur = Character.toString(s.charAt(i));
            if (Bowling.isNumeric(cur) && roll == 0 && frame <= 9){
                score += Integer.parseInt(cur);
                roll += 1;
            } else if (Bowling.isNumeric(cur) && roll == 1 && frame <= 9) {
                score += Integer.parseInt(cur);
                roll = 0;
                frame += 1;
            } else if (Bowling.isNumeric(cur) && frame > 9) {
                roll = 0;
                frame += 1;
            } else if (cur.equals("-") && roll == 0) {
                roll += 1;
            } else if (cur.equals("-") && roll == 1) {
                roll = 0;
                frame += 1;
            } else if (cur.equals("/")) {
                int pre = Integer.parseInt(Character.toString(s.charAt(i - 1)));
                roll = 0;
                score += 10 - pre;
                if (frame <= 9) {
                    String next = Character.toString(s.charAt(i + 1));
                    if (next.equals("X")) {
                        score += 10;
                    } else if (Bowling.isNumeric(next)) {
                        score += Integer.parseInt(next);
                    }
                }
                frame += 1;
            } else if (cur.equals("X") ) {
                if (frame <= 9){
                    score += 10;
                    String next = Character.toString(s.charAt(i + 1));
                    if (next.equals("X")) {
                        score += 10;
                    } else if (Bowling.isNumeric(next)) {
                        score += Integer.parseInt(next);
                    }
                    next = Character.toString(s.charAt(i + 2));
                    if (next.equals("X")) {
                        score += 10;
                    } else if (Bowling.isNumeric(next)) {
                        score += Integer.parseInt(next);
                    }
                }
                frame += 1;
            }
        }
        return score;
    }
}
