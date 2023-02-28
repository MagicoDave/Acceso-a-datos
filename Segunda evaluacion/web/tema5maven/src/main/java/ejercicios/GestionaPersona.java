package ejercicios;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/persona")
public class GestionaPersona {
	private static Persona persona;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	public Response leer() {
		return Response.ok(persona).build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	public void guardar(Persona persona) {
		GestionaPersona.persona = persona;
	}
}
