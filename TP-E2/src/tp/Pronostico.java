/*
*
*
*/
package tp;

/**
 *
 * @author GRUPO 7
 */
public class Pronostico {
    // Atributos
    private int idPronostico;
    private Participante participante;
    private Equipo equipo;
    private Partido partido;
    private char resultado;
    
    
    // Metodos

    public Pronostico(int idPronostico, Equipo equipo, Partido partido, char resultado) {
        this.idPronostico = idPronostico; 
        this.participante = null; 
        this.equipo = equipo;
        this.partido = partido;
        this.resultado = resultado;
    }

    public Pronostico(int idPronostico, Equipo equipo, Partido partido, char resultado,  Participante participante) {
        this.idPronostico = idPronostico; 
        this.equipo = equipo;
        this.partido = partido;
        this.resultado = resultado;
        this.participante = participante; 
    }
    
    public Pronostico() {
        this.idPronostico = 0; 
        this.participante = null;
        this.equipo = null;
        this.partido = null;
        this.resultado = ' ';
    }

    public int getIdPronostico() {
        return idPronostico;
    }

    public void setIdPronostico(int idPronostico) {
        this.idPronostico = idPronostico;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public char getResultado() {
        return resultado;
    }

    public void setResultado(char resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Pronostico{" + "equipo=" + this.equipo + ", partido=" + this.partido + ", resultado=" + this.resultado + '}';
    }
    
    // Metodos Especificos
}
