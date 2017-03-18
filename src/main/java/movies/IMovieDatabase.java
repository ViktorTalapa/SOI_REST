package movies;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("MovieDatabase")
public interface IMovieDatabase {

    @GET
    @Path("movies")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    MovieList getAll();

    @GET
    @Path("movies/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    Movie get(@PathParam("id") int id) throws WebApplicationException;

    @POST
    @Path("movies")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    ResultId add(Movie movie);

    @PUT
    @Path("movies/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    void update(@PathParam("id") int id, Movie movie);

    @DELETE
    @Path("movies/{id}")
    void delete(@PathParam("id") int id);

    @GET
    @Path("movies/find")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    ResultIdList query(@QueryParam("year") int year, @QueryParam("orderby") String orderBy);

}
