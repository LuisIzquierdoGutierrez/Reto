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
public class ACEX_aprobadas {
    private int idActividad;
    private TipoActividad tipo;
    private boolean prevision;
    private boolean alojamiento;
    private String titulo;
    private String empresa_transporte;
    private double precio;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String comentario_estado;
    private String comentario_alojamiento;
    private String comentario_adi;

    public ACEX_aprobadas(int idActividad,TipoActividad tipo, boolean prevision, boolean alojamiento, String titulo, String empresa_transporte, double precio, LocalTime horaInicio, LocalTime horaFin, LocalDate fechaInicio, LocalDate fechaFin, String comentario_estado, String comentario_alojamiento, String comentario_adi) {
        this.idActividad=idActividad;
        this.tipo = tipo;
        this.prevision = prevision;
        this.alojamiento = alojamiento;
        this.titulo = titulo;
        this.empresa_transporte = empresa_transporte;
        this.precio = precio;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.comentario_estado = comentario_estado;
        this.comentario_alojamiento = comentario_alojamiento;
        this.comentario_adi = comentario_adi;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
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

    public String getEmpresa_transporte() {
        return empresa_transporte;
    }

    public void setEmpresa_transporte(String empresa_transporte) {
        this.empresa_transporte = empresa_transporte;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

    public String getComentario_estado() {
        return comentario_estado;
    }

    public void setComentario_estado(String comentario_estado) {
        this.comentario_estado = comentario_estado;
    }

    public String getComentario_alojamiento() {
        return comentario_alojamiento;
    }

    public void setComentario_alojamiento(String comentario_alojamiento) {
        this.comentario_alojamiento = comentario_alojamiento;
    }

    public String getComentario_adi() {
        return comentario_adi;
    }

    public void setComentario_adi(String comentario_adi) {
        this.comentario_adi = comentario_adi;
    }

    @Override
    public String toString() {
        return "ACEX_aprobadas{" + "tipo=" + tipo + ", prevision=" + prevision + ", alojamiento=" + alojamiento + ", titulo=" + titulo + ", empresa_transporte=" + empresa_transporte + ", precio=" + precio + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", comentario_estado=" + comentario_estado + ", comentario_alojamiento=" + comentario_alojamiento + ", comentario_adi=" + comentario_adi + '}';
    }
    
    
}
