
package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;

public interface IAccesoDatos {
    
   boolean existe(String nombre);
   
   List<Pelicula> listar(String nombreArchivo);
   
   void escribir(Pelicula pelicula, String nombreArchivo, String anexar);
   
   String buscar(String nombreArchivo, String buscar);
   
   void crear(String nombreArchivo);
   
   void borrar(String nombreArchivo);
   
    
}
