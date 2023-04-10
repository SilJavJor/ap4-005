/*
*
*
 */
package tp;

/**
 *
 * @author GRUPO 7
 */

public class Participante {
    // Atributos
    private int idParticipante;
    private String nombre;
    private ListaPronosticos pronosticos;

    // Metodos
    public Participante(int idParticipante, String nombre, ListaPronosticos pronosticos) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.pronosticos = pronosticos;
    }
    
    public Participante(int idParticipante, String nombre) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.pronosticos = new ListaPronosticos();
    }
    
    public Participante() {
        this.idParticipante = 0;
        this.nombre = null;
        this.pronosticos = new ListaPronosticos();
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaPronosticos getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(ListaPronosticos pronosticos) {
        this.pronosticos = pronosticos;
    }

    @Override
    public String toString() {
        return "Participante  =  " + this.idParticipante + ",  Nombre  =  " + this.nombre + ",  Pronosticos  =  " + 
                this.pronosticos + ",  Puntaje  =  " + this.getPuntaje();
    }
    
    /*
    private String listaPronosticos() {
        String res = "";
            for (Pronostico pronostico : this.getPronosticos()) {
                res += pronostico.toString()+ System.lineSeparator();
            }
            res += "- - - - - - - - - - - - - - - - - -"+ System.lineSeparator();

        return res;
    }
    */
    
    // Metodos Especificos
    void cargarPronosticos (ListaEquipos equipos, ListaPartidos partidos) {
        this.pronosticos.cargarDeArchivo(this.getIdParticipante(), equipos, partidos);
    }
    
    // retorna el puntaje del participando calculando los valores de los pronosticos
    public int getPuntaje() {
        // Para ver el puntaje debo recorrer los pronosticos y ver el puntaje
        // de cada uno y acumularlo. Debo devolver el total.
        int puntaje = 0;
        // el primer mensaje corresponde al atributo pronosticos de parrticipante
        // el segundo mensaje corresponde a la lista que tiene el atributo pronosticos
        // de esa lista se obtiene cada pronostico y se saca el puntaje acumulandolo en 
        // la variable puntaje
        for (Pronostico pronostico : this.getPronosticos().getPronosticos()) {
//            puntaje += pronostico.getPuntaje();
        }

        return puntaje;
    }
}
