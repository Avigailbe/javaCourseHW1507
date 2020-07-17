package home_work1507;

import java.util.ArrayList;
import java.util.List;

public class GamerServiceImp implements GamerService {

    public List<Gamer> gamers =new ArrayList<Gamer>();
    private Gamer gamer;

    @Override
    public void addGamer(Gamer gamer){
        this.gamer = gamer;
        gamers.add(gamer);
    }


    @Override
    public void printWinner() {

    }
}
