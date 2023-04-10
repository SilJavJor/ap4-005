/*
Clase ListaPronosticos para la entrega 2
 */
package tp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListaPronosticos {
    // atributo
    private List<Pronostico> pronosticos;
    private String pronosticosCSV;

    public ListaPronosticos(List<Pronostico> pronosticos, String pronosticosCSV) {
        this.pronosticos = pronosticos;
        this.pronosticosCSV = pronosticosCSV;
    }

    public ListaPronosticos() {
        this.pronosticos = new ArrayList<Pronostico>();
        this.pronosticosCSV = "./Archivos/pronosticos.csv";
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public String getPronosticosCSV() {
        return pronosticosCSV;
    }

    public void setPronosticosCSV(String pronosticosCSV) {
        this.pronosticosCSV = pronosticosCSV;
    }

    // add y remove elementos
    public void addPronostico(Pronostico p) {
        this.pronosticos.add(p);
    }

    public void removePronostico(Pronostico p) {
        this.pronosticos.remove(p);
    }

    @Override
    public String toString() {
        return "ListaParticipantes{" + "pronosticos=" + pronosticos + '}';
    }

    public String listar() {
        String lista = "";
        for (Pronostico pronostico : pronosticos) {
            lista += "\n" + pronostico;
        }
        
        return lista;
    }

    // Cargar desde el archivo, filtrando solamente aquellos pronósticos
    // cuyo idParticipante coincide con el indicado
    // De esa forma todos los pronósticos de la lista pertenecen al mismo participante.
    public void cargarDeArchivo(
            int idParticipante, // id del participante que realizó el pronóstico
            ListaEquipos listaequipos, // lista de equipos
            ListaPartidos listapartidos // lista de partidos
    ) {
        // para las lineas del archivo csv
        String datosPronostico;
        // para los datos individuales de cada linea
        String vectorPronostico[];

        int fila = 0;

        try {
            Scanner sc = new Scanner(new File(this.getPronosticosCSV()));
            sc.useDelimiter(System.lineSeparator());   //setea el separador de los datos

            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosPronostico = sc.next();
                // Descomentar si se quiere mostrar cada línea leída desde el archivo
                System.out.println(datosPronostico);  //muestra los datos levantados 
                fila++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1) {
                    continue;
                }

                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorPronostico = datosPronostico.split(",");

                // graba el equipo en memoria
                //convertir un string a un entero;
                int readIdPronostico = Integer.parseInt(vectorPronostico[0]);
                int readIdParticipante = Integer.parseInt(vectorPronostico[1]);
                int readIdPartido = Integer.parseInt(vectorPronostico[2]);
                int readIdEquipo = Integer.parseInt(vectorPronostico[3]);
                char readResultado = vectorPronostico[4].charAt(1);     // El primer caracter es una comilla delimitadora de campo
                // Si coincide el idParticipante con el que estoy queriendo cargar,
                // sigo, si no, salteo el registro y voy al siguiente
                if (readIdParticipante == idParticipante) {
                    // Obtener los objetos que necesito para el constructor
                    Partido partido = listapartidos.getPartido(readIdPartido);
                    Equipo equipo = listaequipos.getEquipo(readIdEquipo);
                    // crea el objeto en memoria
                    Pronostico pronostico = new Pronostico(
                            readIdPronostico, // El id leido del archivo
                            equipo, // El Equipo que obtuvimos de la lista
                            partido, // El Partido que obtuvimos de la lista
                            readResultado // El resultado que leimos del archivo
                    );

                    // llama al metodo add para grabar el equipo en la lista en memoria
                    this.addPronostico(pronostico);
                }
            }
            //closes the scanner
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    }
        
    public void cargarDeArchivoTodos(
            ListaEquipos listaequipos, // lista de equipos
            ListaPartidos listapartidos // lista de partidos
    ) {
        // para las lineas del archivo csv
        String datosPronostico;
        // para los datos individuales de cada linea
        String vectorPronostico[];

        int fila = 0;

        try {
            Scanner sc = new Scanner(new File(this.getPronosticosCSV()));
            sc.useDelimiter("\n");   //setea el separador de los datos

            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosPronostico = sc.next();
                // Descomentar si se quiere mostrar cada línea leída desde el archivo
                // System.out.println(datosPronostico);  //muestra los datos levantados 
                fila++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1) {
                    continue;
                }

                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorPronostico = datosPronostico.split(",");

                // graba el equipo en memoria
                //convertir un string a un entero;
                int readIdPronostico = Integer.parseInt(vectorPronostico[0]);
                int readIdParticipante = Integer.parseInt(vectorPronostico[1]);
                int readIdPartido = Integer.parseInt(vectorPronostico[2]);
                int readIdEquipo = Integer.parseInt(vectorPronostico[3]);
                char readResultado = vectorPronostico[4].charAt(1);     // El primer caracter es una comilla delimitadora de campo
                
                // Obtener los objetos que necesito para el constructor
                Partido partido = listapartidos.getPartido(readIdPartido);
                Equipo equipo = listaequipos.getEquipo(readIdEquipo);
                // crea el objeto en memoria
                //Pronostico pronostico = new Pronostico(
                //        readIdPronostico, // El id leido del archivo
                //        equipo, // El Equipo que obtuvimos de la lista
                //        partido, // El Partido que obtuvimos de la lista
                //        readResultado, // El resultado que leimos del archivo,
                //        readIdParticipante
                //);

                // llama al metodo add para grabar el equipo en la lista en memoria
                //this.addPronostico(pronostico);
            }
            
        // closes the scanner
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    }
}