package home_work1507;


import javax.swing.*;
import java.util.*;

public class GuessingGame {

    private int bestResult = Integer.MAX_VALUE;
    private String gamerName;
    private GamerServiceImp gamer;
    private int maxInt;

    public GuessingGame(GamerServiceImp gamer) {
        this.gamer = gamer;
    }

    public void play(int max) {
        maxInt = max;
        Random random = new Random();
        int x = random.nextInt(max);

        //loop through gamers. Each one has numberOfTries tries
        for (int j =0; j<gamer.gamers.size(); j++) {
            gamerName = gamer.gamers.get(j).getName();

            int answer = Integer.parseInt(JOptionPane.showInputDialog(gamerName+ ", please pick a number"));

            for (int i = 1; i < bestResult; i++) {

                if (answer == x) {
                    JOptionPane.showMessageDialog(null, gamer.gamers.get(j).getName()+" right number!!!");
                    if (gamer.gamers.get(j).getScore()<bestResult) {
                        gamer.gamers.get(j).setScore(i);
                        break;
                    }
                } else if (answer < x) {
                    answer = Integer.parseInt(JOptionPane.showInputDialog(gamerName+ ", the number is too low, please try again"));
                } else if (answer > x) {
                    answer = Integer.parseInt(JOptionPane.showInputDialog(gamerName+ ", the number is too high, please try again"));
                }
            }
        }

    }


    public void printScores() {
        Map<Integer, String> gamerScores = new TreeMap<>(Collections.reverseOrder());
        for (int x = 0; x < gamer.gamers.size(); x++) {
            gamerScores.put((bestResult/gamer.gamers.get(x).getScore()), gamer.gamers.get(x).getName());
        }
        for (Integer key : gamerScores.keySet())
        System.out.println(key + " - " + gamerScores.get(key));
    }



      //  for (int j = 1; j < gamer.gamers.size(); j++) {
     //       if (bestResult < gamer.gamers.get(j).getScore()) {
      //          bestResult = gamer.gamers.get(j).getScore();
      //          gamerName = gamer.gamers.get(j).getName();
      //      }
     //   }
     //   return bestResult;
   // }

   /* public void printWinningScore() {

        int bestScore = bestResult/getBestScore();
        System.out.println("best score is:" + bestScore);
        System.out.println("for gamer:" + gamerName);
        JOptionPane.showMessageDialog(null, gamerName+" Wins with best result of:"+bestScore);

    }*/
}
