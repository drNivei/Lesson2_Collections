package GameSaver;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class GameState implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    String player_Name;
    int lvl;
    long points;
    List<String> achievements;
    long played;
    Inventory inventory;

    GameState(){

    }

    GameState (String player_Name,
               int lvl,
               long points,
               List<String> achievements,
               long played,
               Inventory inventory){
        this.player_Name = player_Name;
        this.lvl = lvl;
        this.points = points;
        this.achievements = achievements;
        this.played = played;
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "serialVersionUID='" + serialVersionUID + '\'' +
                ", player_Name='" + player_Name + '\'' +
                ", lvl=" + lvl +
                ", points=" + points +
                ", achievements=" + achievements +
                ", played=" + played +
                ", inventory=" + inventory +
                '}';
    }
}