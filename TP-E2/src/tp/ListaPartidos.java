/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp;

/**
 *
 * @author GRUPO 7
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class ListaPartidos {
    // Atributos
    private List<Partido> partidos;
    private String partidosCSV;
    
    // Metodos
    public ListaPartidos(List<Partido> partidos, String partidosCSV) {
        this.partidos = partidos;
        this.partidosCSV = partidosCSV;
    }
    
    public ListaPartidos() {
        this.partidos = new ArrayList<Partido>();
        this.partidosCSV = "./Archivos/partidos.csv";
    }
    
    public List<Partido> getPartidos() {
        return partidos;
    }
    
    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    // Agregar elemento a la lista
    public void addPartido(Partido partido) {
        this.partidos.add(partido);
    }

    // Eliminar elemento de la lista
    public void removePartido(Partido partido) {
        this.partidos.remove(partido);
    }

    /***
     * Este método devuelve un Equipo (o null) buscandolo por idEquipo
     * @param idPartido Identificador del equipo deseado
     * @return Objeto Equipo (o null si no se encuentra)
     */
    public Partido getPartido (int idPartido) {
        // Defini un objeto de tipo Equipo en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el equipo que 
        // buscaba todavía.
        Partido encontrado = null;
        // Recorro la lista de equipos que está cargada
        for (Partido partido : this.getPartidos()) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (partido.getIdPartido() == idPartido) {
                // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                encontrado = partido;
                // Y hago un break para salir del ciclo ya que no hace falta seguir buscando
                break;
            }
        }
        // Una vez fuera del ciclo retorno el equipo, pueden pasar dos cosas:
        // 1- Lo encontré en el ciclo, entonces encontrado tiene el objeto encontrado
        // 2- No lo encontré en el ciclo, entonces conserva el valor null del principio
        return encontrado;
    }

    @Override
    public String toString() {
        return "ListaEquipos{" + "equipos=" + partidos + '}';
    }
    
    // Metodos Especificos    
    public String listar() {
        String lista = "";
        
        lista += System.lineSeparator();
        lista += "Los partidos cargados son : " + System.lineSeparator();
        lista += "---------------------------" + System.lineSeparator();
        
        for (Partido partido: partidos) {
            lista += partido + System.lineSeparator();  // System.lineSeparator() se utiliza com separador de linea pero por S.O.
        } 
        
        return lista;
    }
    
    // Raaliza la carga desde el archivo especificado
    public void cargarDeArchivo(ListaEquipos listaequipos)
    {
        // para las lineas del archivo csv
        String datosPartido;
        // para los datos individuales de cada linea
        String vectorPartido[];
        // para el objeto en memoria
        Partido partido;
        
        int fila = 0;
       
        try { 
            Scanner sc = new Scanner(new File("./Archivos/partidos.csv"));
            sc.useDelimiter(System.lineSeparator());   //setea el separador de los datos
                
            System.out.println("Los partidos cargados en el archivo son : ");
            System.out.println("-----------------------------------------");

            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosPartido = sc.next();
                System.out.println(datosPartido);  //muestra los datos levantados 
                fila ++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1)
                    continue;              
                 
                // Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorPartido = datosPartido.split(",");   
                
                // graba el equipo en memoria
                // convertir un string a un entero;
                int readIdPartido = Integer.parseInt(vectorPartido[0]);
                int readIdEquipo1 = Integer.parseInt(vectorPartido[1]);
                int readIdEquipo2 = Integer.parseInt(vectorPartido[2]);
                int readGolesEquipo1 = Integer.parseInt(vectorPartido[3]);
                int readGolesEquipo2 = Integer.parseInt(vectorPartido[4]);

                Equipo equipo1 = listaequipos.getEquipo(readIdEquipo1);
                Equipo equipo2 = listaequipos.getEquipo(readIdEquipo2);
                
                // crea el objeto en memoria
                partido = new Partido(readIdPartido, equipo1, equipo2, readGolesEquipo1, readGolesEquipo2);
                // crea el objeto en memoria
                
                // llama al metodo add para grabar el equipo en la lista en memoria
                this.addPartido(partido);
            }

        // closes the scanner
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }           
    }
}