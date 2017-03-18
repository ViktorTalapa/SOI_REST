package movies;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MovieDatabase implements IMovieDatabase {

    private static final TreeMap<Integer, Movie> movieMap = new TreeMap<>();

    @Override
    public MovieList getAll() {
        return new MovieList(movieMap);
    }

    @Override
    public Movie get(int id) throws WebApplicationException {
        if (!movieMap.containsKey(id))
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        return movieMap.get(id);
    }

    @Override
    public ResultId add(Movie movie) {
        int id = (movieMap.size() != 0) ? movieMap.lastKey() + 1 : 0;
        movieMap.put(id, movie);
        return new ResultId(id);
    }

    @Override
    public void update(int id, Movie movie) {
        movieMap.put(id, movie);
    }

    @Override
    public void delete(int id) {
        movieMap.remove(id);
    }

    @Override
    public ResultIdList query(int year, String orderBy) throws WebApplicationException {
        if (!orderBy.equals("Director") && !orderBy.equals("Title"))
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        boolean orderMode = orderBy.equals("Director");

        TreeMap<String, Integer> resultMap = new TreeMap<>();
        for (Map.Entry<Integer, Movie> entry : movieMap.entrySet())
            if (entry.getValue().getYear() == year) {
                String resultKey = (orderMode) ? entry.getValue().getDirector() : entry.getValue().getTitle();
                resultMap.put(resultKey, entry.getKey());
            }
        return new ResultIdList(resultMap);
    }
}
