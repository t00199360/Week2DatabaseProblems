/**
 * Created by t00199360 on 20/09/2018.
 */
import java.util.Date;

public class Team {
    private int id;
    private String  TEAM_NAME;
    private String  POINTS;
    private String  PLACED;

    public Team(){
        setId(0);
        setTEAM_NAME("");
        setPOINTS("");
        setPlaced("");
    }
    public void Team(String title, String synopsis, String director){
        setTEAM_NAME(title);
        setPOINTS(synopsis);
        setPlaced(placed);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTEAM_NAME(String title) {
        this.title = title;
    }

    public void setPOINTS(String director) {
        this.director = director;
    }

    public void setPlaced(int placed) {
        this.id = placed;
    }
    public int getId() {
        return id;
    }
    public String getSynopsis() {
        return synopsis;
    }
}