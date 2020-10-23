package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.datos.AccesodatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private AccesodatosImpl datos = new AccesodatosImpl();

    public CatalogoPeliculasImpl() {

    }

    ;

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        datos.escribir(pelicula, nombreArchivo, nombrePelicula);

    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        System.out.println(datos.listar(nombreArchivo));

    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        System.out.println(datos.buscar(nombreArchivo, buscar));
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        datos.crear(nombreArchivo);
    }

    public void eliminar(String nombreArchivo) {
        datos.borrar(nombreArchivo);
    }

}
