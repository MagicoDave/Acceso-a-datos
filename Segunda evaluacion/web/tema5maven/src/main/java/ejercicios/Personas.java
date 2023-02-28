package ejercicios;

import java.util.ArrayList;
import java.util.Iterator;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
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
	@Consumes({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
	public void guardar(Persona persona) {
		personas.add(persona);
	}

	@GET
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
	public Response listar() {
		System.out.print(personas.size());
		return Response.ok(personas).build();
	}

	@GET
	@Path("/{nombre}")
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
	public Response ver(@PathParam("nombre") String nombre) {
		for (Persona persona : personas) {
			if (persona.getNombre().equals(nombre)) {
				return Response.ok(persona).build();
			}
		}
		return Response.noContent().build();
	}

	@GET
	@Path("/buscar/{cadena}")
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
	public Response ver2(@DefaultValue ("a") @PathParam("cadena") String cadena) {
		ArrayList<Persona> p = new ArrayList<Persona>();
		for (Persona persona : personas) {
			if (persona.getNombre().toLowerCase().contains(cadena.toLowerCase())) {
				p.add(persona);
			}
		}
		return Response.ok(p).build();
	}

	@POST
	@Consumes("application/x-www-form-urlencoded")
	public void getPersonaFormulario(@FormParam("id") int id, @FormParam("nombre") String nombre, @FormParam("casado") boolean casado, @FormParam("sexo") String sexo) {
		Persona p = new Persona();
		p.setId(id);
		p.setNombre(nombre);
		p.setCasado(casado);
		p.setSexo(sexo);
		personas.add(p);
	}
	
	@POST
	@Path("/add")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void add(Persona[] gente) {
		for (int i = 0; i < gente.length; i++) {
			personas.add(gente[i]);
		}
	}
	
	@POST
	@Path("/id/{id}")
	public void borrarId(@PathParam("id") int id) {
		for (Persona persona : personas) {
			if (persona.getId() == id) {
				personas.remove(persona);
			}
		}
	}
	
	@GET
	@Path("/XML/{id}")
	@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	public Response buscarId(@PathParam("id") int id) {
		for (Persona persona : personas) {
			if (persona.getId() == id) {
				return Response.ok(persona).build();
			}
		}
		return Response.noContent().build();
	}
	
	

}
