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
    private int id_actividad;
    private TipoActividad tipo;
    private boolean programada;
    private boolean alojamiento;
    private String titulo;
    private boolean transporte;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String comentario_estado;
    private String comentario_alojamiento;
    private String comentario_actividad;

    public ACEX_aprobadas(int idActividad,TipoActividad tipo, boolean prevision, boolean alojamiento, String titulo, LocalTime horaInicio, LocalTime horaFin, LocalDate fechaInicio, LocalDate fechaFin, String comentario_estado, String comentario_alojamiento, String comentario_adi) {
        this.id_actividad=idActividad;
        this.tipo = tipo;
        this.programada = prevision;
        this.alojamiento = alojamiento;
        this.titulo = titulo;
       
        this.hora_inicio = horaInicio;
        this.hora_fin = horaFin;
        this.fecha_inicio = fechaInicio;
        this.fecha_fin = fechaFin;
        this.comentario_estado = comentario_estado;
        this.comentario_alojamiento = comentario_alojamiento;
        this.comentario_actividad = comentario_adi;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
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

    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
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

    public String getComentario_actividad() {
        return comentario_actividad;
    }

    public void setComentario_actividad(String comentario_actividad) {
        this.comentario_actividad = comentario_actividad;
    }

   
    
    
}
