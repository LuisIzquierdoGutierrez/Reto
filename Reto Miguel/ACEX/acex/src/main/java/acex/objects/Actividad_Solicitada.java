package acex.objects;

import acex.enums.A_Estado;
import acex.enums.A_Tipo;
import java.time.LocalDateTime;


public class Actividad_Solicitada {
    private int id;
    private int id_solicitante;
    private String titulo;
    private String comentario_actividad;
    private A_Tipo tipo;
    private boolean prevista;
    private A_Estado estado;
    private String comentario_estado;
    private boolean transporte;
    private boolean alojamiento;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    
    public Actividad_Solicitada(int id, int id_solicitante, String titulo, String comentario_actividad, A_Tipo tipo, boolean prevista, A_Estado estado, String comentario_estado, boolean transporte, boolean alojamiento, LocalDateTime inicio, LocalDateTime fin) {
        this.id = id;
        this.id_solicitante = id_solicitante;
        this.titulo = titulo;
        this.comentario_actividad = comentario_actividad;
        this.tipo = tipo;
        this.prevista = prevista;
        this.estado = estado;
        this.comentario_estado = comentario_estado;
        this.transporte = transporte;
        this.alojamiento = alojamiento;
        this.inicio = inicio;
        this.fin = fin;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public int getIdSolicitante() {
        return id_solicitante;
    }

    public void setIdSolicitante(int id_solicitante) {
        this.id_solicitante = id_solicitante;
    }

    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    public String getComentarioActividad() {
        return comentario_actividad;
    }

    public void setComentarioActividad(String comentario_actividad) {
        this.comentario_actividad = comentario_actividad;
    }

    
    public A_Tipo getTipo() {
        return tipo;
    }

    public void setTipo(A_Tipo tipo) {
        this.tipo = tipo;
    }

    
    public boolean isPrevista() {
        return prevista;
    }

    public void setPrevista(boolean prevista) {
        this.prevista = prevista;
    }

    
    public A_Estado getEstado() {
        return estado;
    }

    public void setEstado(A_Estado estado) {
        this.estado = estado;
    }

    
    public String getComentarioEstado() {
        return comentario_estado;
    }

    public void setComentarioEstado(String comentario_estado) {
        this.comentario_estado = comentario_estado;
    }

    
    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    
    public boolean isAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(boolean alojamiento) {
        this.alojamiento = alojamiento;
    }

    
    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    
    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }
}
