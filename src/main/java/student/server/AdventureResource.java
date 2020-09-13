package student.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import student.adventure.Adventure;


@Path("/")
public class AdventureResource {
    /**
     * Helper method to build an `instanceNotFound` error.
     * @param id the id given.
     */
    private Response instanceNotFound(int id) {
        return Response
                .status(Status.BAD_REQUEST)
                .entity(new Error("No game found with id '" + id + "'."))
                .build();
    }

    @GET
    @Path("ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        // TODO: This method should return `pong`.
        return "";
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(NewGame request) {
        int id = -1;
        try {
            id = AdventureService.instance().newGame(request.getUrl());
        } catch (Exception e) {
            // TODO: Make exception caught more specific.
            return Response
                    .status(Status.BAD_REQUEST)
                    .entity(new Error(e.getMessage()))
                    .build();
        }

        return getGame(id);
    }

    @GET
    @Path("instance/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGame(@PathParam("id") int id) {
        Adventure game = AdventureService.instance().getGame(id);
        if (game == null) {
            return instanceNotFound(id);
        }

        // TODO: Implement your own constructor for CommandResult and use it here
        CommandResult response = new CommandResult();
        return Response.ok(response).build();
    }

    @DELETE
    @Path("instance/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response destroyGame(@PathParam("id") int id) {
        if (!AdventureService.instance().destroyGame(id)) {
            return instanceNotFound(id);
        }

        return Response.ok().build();
    }

    @POST
    @Path("instance/{id: \\d+}/command")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response doCommand(@PathParam("id") int id, Command request) {
        Adventure game = AdventureService.instance().getGame(id);

        if (game == null) {
            return instanceNotFound(id);
        }

        String commandName = request.getCommandName();
        String commandValue = request.getCommandValue();

        if (commandName == null || commandValue == null) {
            return Response
                    .status(Status.BAD_REQUEST)
                    .build();
        }

        // TODO: Implement command handling

        return getGame(id);
    }
}