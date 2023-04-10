/*
*
*
 */
package tp;

/**
 *
 * @author GRUPO 7
 */

public class Equipo {
    // Atributos
    private int idEquipo;
    private String nombre;
    private String descripcion;
    
    // Metodos
    public Equipo(int idEquipo, String nombre, String descripcion) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public Equipo() {
        this.idEquipo = 0;
        this.nombre = null;
        this.descripcion = null;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescriopcion() {
        return descripcion;
    }

    public void setDescriopcion(String descriopcion) {
        this.descripcion = descriopcion;
    }

    @Override
    public String toString() {
        return "Equipo  =  " + idEquipo + ",  Nombre  =  " + nombre + ",  Descripcion  =  " + descripcion;
    }
    
    // Metodos Especificos
}
