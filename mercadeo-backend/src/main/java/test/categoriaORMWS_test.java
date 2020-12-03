package test;

import Controllers.categoriaORMWS;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import dtos.CategoriaDto;
import entidades.Categoria;
import java.util.List;

import java.text.SimpleDateFormat;


public class categoriaORMWS_test {

    @Test
    public void addCategoriaTest() throws Exception {
        categoriaORMWS servicio = new categoriaORMWS();
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setNombre( "Categoria1" );
        categoriaDto.setEstado( "A" );
        CategoriaDto resultado = servicio.addCategoria( categoriaDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void showCategoriaTest() throws Exception
    {
        categoriaORMWS servicio = new categoriaORMWS();
        List<Categoria> categorias = servicio.showCategoria();
        Assert.assertFalse("Consulta Realizada con Exito",categorias.isEmpty());
    }

    @Test
    public void updateCategoriaTest() throws Exception{

        categoriaORMWS servicio = new categoriaORMWS();
        CategoriaDto categoriaDto = new CategoriaDto(1);
        categoriaDto.setNombre( "Categoria2" );
        categoriaDto.setEstado( "I" );
        CategoriaDto resultado = servicio.editCategoria(categoriaDto);
        Assert.assertNotEquals( resultado.getId(), 0);
    }

    @Test
    public void deleteCategoriaTest() throws Exception{

        categoriaORMWS servicio = new categoriaORMWS();
        CategoriaDto categoriaDto = new CategoriaDto(1);
        CategoriaDto resultado = servicio.deleteCategoria(categoriaDto);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }
}
