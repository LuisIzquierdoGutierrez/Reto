package app.objects;

import app.database.DAO_Profesor;
import app.enums.Enum_Estado;
import app.enums.Enum_Tipo;
import java.time.LocalDate;
import java.time.LocalTime;


public class Obj_Actividad_Aprobada {
    private int id;
    private Obj_Profesor solicitante;
    private String nombre;
    private String comentarioActividad;
    private Enum_Tipo tipo;
    private boolean prevista;
    private Enum_Estado estado;
    private String comentarioEstado;
    private boolean transporte;
    private boolean alojamiento;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Obj_Actividad_Aprobada(int id, int idSolicitante, String nombre, String comentarioActividad, Enum_Tipo tipo, boolean prevista, Enum_Estado estado, String comentarioEstado, boolean transporte, boolean alojamiento, LocalTime horaInicio, LocalTime horaFin, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.solicitante = new DAO_Profesor().getById(idSolicitante);
        this.nombre = nombre;
        this.comentarioActividad = comentarioActividad;
        this.tipo = tipo;
        this.prevista = prevista;
        this.estado = estado;
        this.comentarioEstado = comentarioEstado;
        this.transporte = transporte;
        this.alojamiento = alojamiento;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Obj_Profesor getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Obj_Profesor solicitante) {
        this.solicitante = solicitante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentarioActividad() {
        return comentarioActividad;
    }

    public void setComentarioActividad(String comentarioActividad) {
        this.comentarioActividad = comentarioActividad;
    }

    public Enum_Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Enum_Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean isPrevista() {
        return prevista;
    }

    public void setPrevista(boolean prevista) {
        this.prevista = prevista;
    }

    public Enum_Estado getEstado() {
        return estado;
    }

    public void setEstado(Enum_Estado estado) {
        this.estado = estado;
    }

    public String getComentarioEstado() {
        return comentarioEstado;
    }

    public void setComentarioEstado(String comentarioEstado) {
        this.comentarioEstado = comentarioEstado;
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

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
