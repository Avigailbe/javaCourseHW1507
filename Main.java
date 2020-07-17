package home_work1507;

public class Main {
    public static void main(String[] args) {

        //create gamers
        GamerServiceImp gamerService = new GamerServiceImp();
        gamerService.addGamer(new Gamer("Avi"));
        gamerService.addGamer(new Gamer("Don"));
        gamerService.addGamer(new Gamer("Jon"));

        GuessingGame guessingGame = new GuessingGame(gamerService);
        guessingGame.play(3);
        guessingGame.printScores();
    }
}
