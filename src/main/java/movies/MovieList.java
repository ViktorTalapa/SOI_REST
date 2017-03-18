package movies;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "movies")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Movie.class)
public class MovieList {

    @XmlElement(name = "movie", type = Movie.class)
    private List<Movie> movies;

    public MovieList() {
        movies = new ArrayList<>();
    }

    public MovieList(Map<Integer, Movie> movieMap) {
        movies = new ArrayList<>(movieMap.values());
    }
}