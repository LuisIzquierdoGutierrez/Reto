/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author DAM103
 */
public class Solicitudes_ACEX {
    private int idSolicitudes;
    private int idSolicitante;
    private TipoActividad tipo;
    private boolean prevision;
    private boolean alojamiento;
    private String titulo;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean transporte;
    private String comentario_estado;
    // private String comentario_alojamiento; implementar mas adelante
    private String comentario_adi;
    private TipoEstado estado;

    
    // añadir  String comentario_alojamiento, mas adelante si es necesario
    public Solicitudes_ACEX(int idSolicitudes,int idSolicitante,TipoActividad tipo, boolean prevision, boolean alojamiento, String titulo, LocalTime horaInicio, LocalTime horaFin,LocalDate fechaInicio,LocalDate fechaFin, boolean transporte, String comentario_estado, String comentario_adi,TipoEstado estado) {
        this.idSolicitudes=idSolicitudes;
        this.idSolicitante = idSolicitante;
        this.tipo = tipo;
        this.prevision = prevision;
        this.alojamiento = alojamiento;
        this.titulo = titulo;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.transporte = transporte;
        this.comentario_estado = comentario_estado;
       // this.comentario_alojamiento = comentario_alojamiento;
        this.comentario_adi = comentario_adi;
        this.estado = estado;
    }

    public int getIdSolicitudes() {
        return idSolicitudes;
    }

    public int getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(int idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public void setIdSolicitudes(int idSolicitudes) {
        this.idSolicitudes = idSolicitudes;
    }
    

    public TipoActividad getTipo() {
        return tipo;
    }

    public void setTipo(TipoActividad tipo) {
        this.tipo = tipo;
    }

    public boolean isPrevision() {
        return prevision;
    }

    public void setPrevision(boolean prevision) {
        this.prevision = prevision;
    }

    public boolean isAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(boolean alojamiento) {
        this.alojamiento = alojamiento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    
    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    public String getComentario_estado() {
        return comentario_estado;
    }

    public void setComentario_estado(String comentario_estado) {
        this.comentario_estado = comentario_estado;
    }
//
//    public String getComentario_alojamiento() {
//        return comentario_alojamiento;
//    }
//
//    public void setComentario_alojamiento(String comentario_alojamiento) {
//        this.comentario_alojamiento = comentario_alojamiento;
//    }

    public String getComentario_adi() {
        return comentario_adi;
    }

    public void setComentario_adi(String comentario_adi) {
        this.comentario_adi = comentario_adi;
    }

    public TipoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }
    
}