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

    private int id_aprobada;
    private String titulo;
    private String comentario_actividad;
    private TipoActividad tipo;
    private boolean programada;
    private TipoEstado estado;
    private String comentario_estado;
    private boolean transporte;
    private boolean alojamiento;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    public int getId_aprobada() {
        return id_aprobada;
    }

    public void setId_aprobada(int id_aprobada) {
        this.id_aprobada = id_aprobada;
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

    public ACEX_aprobadas(int id_aprobada, String titulo, String comentario_actividad, TipoActividad tipo, boolean programada, TipoEstado estado, String comentario_estado, boolean transporte, boolean alojamiento, LocalTime hora_inicio, LocalTime hora_fin, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.id_aprobada = id_aprobada;
        this.titulo = titulo;
        this.comentario_actividad = comentario_actividad;
        this.tipo = tipo;
        this.programada = programada;
        this.estado = estado;
        this.comentario_estado = comentario_estado;
        this.transporte = transporte;
        this.alojamiento = alojamiento;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

}
