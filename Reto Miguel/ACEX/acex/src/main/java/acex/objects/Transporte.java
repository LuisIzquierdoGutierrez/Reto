package acex.objects;

import acex.enums.T_Tipo;


public class Transporte {
    private int id;
    private int id_actividad;
    private T_Tipo tipo;
    private double importe;
    private String comentario;
    
    public Transporte(int id, int id_actividad, T_Tipo tipo, double importe, String comentario) {
        this.id = id;
        this.id_actividad = id_actividad;
        this.tipo = tipo;
        this.importe = importe;
        this.comentario = comentario;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public int getIdActividad() {
        return id_actividad;
    }

    public void setIdActividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    
    public T_Tipo getTipo() {
        return tipo;
    }

    public void setTipo(T_Tipo tipo) {
        this.tipo = tipo;
    }

    
    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
