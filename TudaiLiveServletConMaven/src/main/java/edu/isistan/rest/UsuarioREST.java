package edu.isistan.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import edu.isistan.entities.Usuario;

@Path("/usuarios")
public class UsuarioREST {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuarios(){
		System.out.println(LectorCicloDeVida.EMF);
		return IntStream.range(0, 20).
				mapToObj(i -> new Usuario(i,"Name_"+i, "Surname_"+i)).
				collect(Collectors.toList());
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuario(@PathParam("id")int id){
		System.out.println(LectorCicloDeVida.EMF);
		return new Usuario(id,"Name_"+id, "Surname_"+id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addUser(Usuario u){
		System.out.println(LectorCicloDeVida.EMF);
		System.out.println("Agregando" + u);
		return "El usuario se agrego correctamente";
	}
}
