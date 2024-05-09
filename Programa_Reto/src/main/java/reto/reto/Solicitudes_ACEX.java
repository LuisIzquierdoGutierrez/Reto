/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author DAM103
 */
public class Solicitudes_ACEX {
    private int idSolicitudes;
    private Profesor solicitante;
    private String titulo;
    private String comentario_actividad;
    private TipoActividad tipo;
    private boolean programada;
    private TipoEstado estado;
    private String comentario_estado;
    private boolean transporte;
    private boolean alojamiento;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Solicitudes_ACEX(int idSolicitudes, int idSolicitante, String titulo, String comentario_actividad, TipoActividad tipo, boolean programada, TipoEstado estado, String comentario_estado, boolean transporte, boolean alojamiento, LocalTime horaInicio, LocalTime horaFin, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idSolicitudes = idSolicitudes;
        this.solicitante = new ProfesorDAO().porId(idSolicitante);
        this.titulo = titulo;
        this.comentario_actividad = comentario_actividad;
        this.tipo = tipo;
        this.programada = programada;
        this.estado = estado;
        this.comentario_estado = comentario_estado;
        this.transporte = transporte;
        this.alojamiento = alojamiento;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdSolicitudes() {
        return idSolicitudes;
    }

    public void setIdSolicitudes(int idSolicitudes) {
        this.idSolicitudes = idSolicitudes;
    }

    public Profesor getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Profesor solicitante) {
        this.solicitante = solicitante;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComentario_actividad() {
        return comentario_actividad;
    }

    public void setComentario_actividad(String comentario_actividad) {
        this.comentario_actividad = comentario_actividad;
    }

    public TipoActividad getTipo() {
        return tipo;
    }

    public void setTipo(TipoActividad tipo) {
        this.tipo = tipo;
    }

    public boolean isProgramada() {
        return programada;
    }

    public void setProgramada(boolean programada) {
        this.programada = programada;
    }

    public TipoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }

    public String getComentario_estado() {
        return comentario_estado;
    }

    public void setComentario_estado(String comentario_estado) {
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