package movies;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "movie")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Movie {

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "year")
    private int year;

    @XmlElement(name = "director")
    private String director;

    @XmlElement(name = "actor", type = String.class)
    private List<String> actors;

    public Movie() {
        title = ""; year = 0; director = "";
        actors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }
}
