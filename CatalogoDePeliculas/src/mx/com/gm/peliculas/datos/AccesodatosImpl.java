package mx.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.domain.Pelicula;

public class AccesodatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {

        File archivo = new File(nombreArchivo);

        if (archivo.exists()) {

            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) {

        File archivo = new File(nombreArchivo);
        List<Pelicula> mispeliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while (lectura != null) {
                Pelicula pelicula = new Pelicula(lectura);
                mispeliculas.add(pelicula);
                lectura = entrada.readLine();
            }

            entrada.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        return mispeliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, String anexar) {
        Pelicula pelicula1 = new Pelicula(anexar);
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(anexar);
            salida.close();
            System.out.println("Se ha agregado la pelicula");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        String salida = new String();
        String lectura = new String();
        try {
            File archivo = new File(nombreArchivo);
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            lectura = entrada.readLine();
          
            while (lectura != null) {
                if (lectura.equalsIgnoreCase(buscar)) {
                    salida = lectura;

                }

                lectura = entrada.readLine();

            }
            if (salida.equalsIgnoreCase(buscar)) {
                System.out.println("pelicula encontrada");

            } else {
                System.out.println("Pelicula no encontrada");

            }

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        
        return salida;
    }

    @Override
    public void crear(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void borrar(String nombreArchivo) {

        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("Archivo eliminado");
    }

}
