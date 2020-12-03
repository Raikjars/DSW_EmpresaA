package Controllers;

import daos.DaoCategoria;
import dtos.CategoriaDto;
import entidades.Categoria;
import javax.ws.rs.*;
import java.util.List;
import javax.ws.rs.core.MediaType;

@Path( "/categoria" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class categoriaORMWS {

    @PUT
    @Path( "/agregar" )
    public CategoriaDto addCategoria( CategoriaDto categoriaDto )
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = new Categoria();
            categoria.set_nombre( categoriaDto.getNombre() );
            categoria.set_estado( categoriaDto.getEstado() );
            Categoria resul = dao.insert( categoria );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path("/buscar")
    public List<Categoria> showCategoria()
    {
        List<Categoria> categorias = null;
        try {
            DaoCategoria dao = new DaoCategoria();
            categorias = dao.findAll(Categoria.class);
            System.out.println("Categorias: ");
            for(Categoria categoria : categorias) {
                System.out.print(categoria.get_id());
                System.out.print(", ");
                System.out.print(categoria.get_nombre());
                System.out.print(", ");
                System.out.print(categoria.get_estado());
                System.out.println();
            }
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return categorias;
    }

    @PUT
    @Path( "/actualizar/{id}" )
    public CategoriaDto editCategoria( CategoriaDto categoriaDto)
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = new Categoria(categoriaDto.getId());
            categoria.set_nombre( categoriaDto.getNombre());
            categoria.set_estado (categoriaDto.getEstado());
            Categoria resul = dao.update (categoria );
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/borrar/{id}" )
    public CategoriaDto deleteCategoria( CategoriaDto categoriaDto)
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = dao.find(categoriaDto.getId(), Categoria.class);
            Categoria resul = dao.delete (categoria );
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
