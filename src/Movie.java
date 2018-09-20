/**
 * Created by t00036478 on 02/02/2018.
 */
import java.util.Date;

public class Movie {
    private int id = 0;
    private String  title = null;
    private String  synopsis = null;
    private String  director = null;

    public Movie(){
        setTitle("");
        setSynopsis("");
        setDirector("");
    }
    public Movie(String title, String synopsis, String director){
        setTitle(title);
        setSynopsis(synopsis);
        setDirector(director);
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getDirector() {
        return director;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    public String getSynopsis() {
        return synopsis;
    }
}