/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

/**
 *
 * @author adry1
 */
public class Tipo_transporte {
    private int id_tipo_transporte;
    private String tipo;
    private String comentario;

    public Tipo_transporte(int id_tipo_transporte, String tipo, String comentario) {
        this.id_tipo_transporte = id_tipo_transporte;
        this.tipo = tipo;
        this.comentario = comentario;
    }

    public int getId_tipo_transporte() {
        return id_tipo_transporte;
    }

    public void setId_tipo_transporte(int id_tipo_transporte) {
        this.id_tipo_transporte = id_tipo_transporte;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
}
