package ejercicios;

import java.util.ArrayList;
import java.util.Iterator;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/personas")
public class Personas {
	public static ArrayList<Persona> personas = new ArrayList<Persona>();
	
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void guardar(Persona persona) {
		personas.add(persona);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public Response listar(){
		return Response.ok(personas).build();
	}
	
	@GET
	@Path("/personas/{nombre}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response ver(@PathParam("nombre") String nombre) {
		String error = "No hay personas con ese nombre";
		for (Persona persona : personas) {
			if (persona.getNombre().equals(nombre)) {
				return Response.ok(persona).build();
			}
		}
		return Response.ok(error).build();
	}
}
