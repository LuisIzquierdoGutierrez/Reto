/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

/**
 * @author Adrian, Luis
 * Clase que representa un tipo de transporte.
 * 
 */
public class Tipo_transporte {
    private int id_tipo_transporte;
    private String tipo;
    private String comentario;
    
    /**
     * Constructor de la clase Tipo_transporte.
     * 
     * @param id_tipo_transporte El ID del tipo de transporte.
     * @param tipo              El tipo de transporte.
     * @param comentario        El comentario asociado al tipo de transporte.
     */

    public Tipo_transporte(int id_tipo_transporte, String tipo, String comentario) {
        this.id_tipo_transporte = id_tipo_transporte;
        this.tipo = tipo;
        this.comentario = comentario;
    }
 /**
     * Obtiene el ID del tipo de transporte.
     * 
     * @return El ID del tipo de transporte.
     */
    public int getId_tipo_transporte() {
        return id_tipo_transporte;
    }

    /**
     * Establece el ID del tipo de transporte.
     * 
     * @param id_tipo_transporte El ID del tipo de transporte a establecer.
     */
    public void setId_tipo_transporte(int id_tipo_transporte) {
        this.id_tipo_transporte = id_tipo_transporte;
    }

    /**
     * Obtiene el tipo de transporte.
     * 
     * @return El tipo de transporte.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de transporte.
     * 
     * @param tipo El tipo de transporte a establecer.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el comentario asociado al tipo de transporte.
     * 
     * @return El comentario asociado al tipo de transporte.
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Establece el comentario asociado al tipo de transporte.
     * 
     * @param comentario El comentario asociado al tipo de transporte a establecer.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
