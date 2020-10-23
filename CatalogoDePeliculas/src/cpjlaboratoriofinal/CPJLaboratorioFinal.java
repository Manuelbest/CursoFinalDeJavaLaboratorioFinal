package cpjlaboratoriofinal;

import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;
import java.util.Scanner;

public class CPJLaboratorioFinal {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcion;
        String nombrePelicula;
        String nombreArchivo = "c:\\CatalogoPeliculas\\peliculas2.txt";
        CatalogoPeliculasImpl catalogo = new CatalogoPeliculasImpl();

        System.out.println("Elige opcion" + "\n" + "1.- Iniciar catalogo peliculas"
                + "\n" + "2.- Agregar pelicula" + "\n" + "3.- Listar peliculas"
                + "\n" + "4.- Buscar Pelicula" + "\n" + "0.- Salir");

        switch (opcion = entrada.nextInt()) {

            case 1:
                catalogo.iniciarArchivo(nombreArchivo);
                break;

            case 2:
                System.out.println("Introduce el nombre de una pelicula a agregar:");
                nombrePelicula = entrada.next();
                catalogo.agregarPelicula(nombrePelicula, nombreArchivo);
                break;

            case 3:
                System.out.println("Peliculas: ");
                catalogo.listarPeliculas(nombreArchivo);
                break;

            case 4:
                System.out.println("Introduzca el nombre de la pelicula a buscar:");
                nombrePelicula = entrada.next();
                catalogo.buscarPelicula(nombreArchivo, nombrePelicula);
                break;

            case 0:

                System.out.println("Programa terminado......");

        }

    }

}
