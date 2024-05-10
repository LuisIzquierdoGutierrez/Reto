/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acex.objects;

/**
 * Esta clase representa un alojamiento.
 * @author Adrian
 * 
 */
public class Alojamiento {
    private int id_alojamiento;
    private String nombre;
    private String comentario;
    
     /**
     * Crea una instancia de la clase Alojamiento.
     * 
     * @param id_alojamiento El ID del alojamiento.
     * @param nombre El nombre del alojamiento.
     * @param comentario El comentario del alojamiento.
     */

    public Alojamiento(int id_alojamiento, String nombre, String comentario) {
        this.id_alojamiento = id_alojamiento;
        this.nombre = nombre;
        this.comentario = comentario;
    }
    /**
     * Obtiene el ID del alojamiento.
     * 
     * @return El ID del alojamiento.
     */

    public int getId_alojamiento() {
        return id_alojamiento;
    }
    /**
     * Establece el ID del alojamiento.
     * 
     * @param id_alojamiento El nuevo ID del alojamiento.
     */

    public void setId_alojamiento(int id_alojamiento) {
        this.id_alojamiento = id_alojamiento;
    }
    /**
     * Obtiene el nombre del alojamiento.
     * 
     * @return El nombre del alojamiento.
     */

    public String getNombre() {
        return nombre;
    }
     /**
     * Establece el nombre del alojamiento.
     * 
     * @param nombre El nuevo nombre del alojamiento.
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene el comentario del alojamiento.
     * 
     * @return El comentario del alojamiento.
     */

    public String getComentario() {
        return comentario;
    }
     /**
     * Establece el comentario del alojamiento.
     * 
     * @param comentario El nuevo comentario del alojamiento.
     */

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
}
