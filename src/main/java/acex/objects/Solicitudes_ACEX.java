/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acex.objects;

import acex.enums.Tipo_Estado;
import acex.enums.Tipo_Actividad;
import acex.objects.Profesor;
import acex.database.DAO_Profesor;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Esta clase representa una solicitud de actividad extracurricular.
 * @author  Luis
 * @see Solicitud
 */
public class Solicitudes_ACEX {
    private int idSolicitudes;
    private Profesor solicitante;
    private String titulo;
    private String comentario_actividad;
    private Tipo_Actividad tipo;
    private boolean programada;
    private Tipo_Estado estado;
    private String comentario_estado;
    private boolean transporte;
    private boolean alojamiento;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    
     /**
     * Crea una nueva instancia de la clase Solicitudes_ACEX.
     * 
     * @param idSolicitudes El ID de la solicitud.
     * @param idSolicitante El ID del solicitante.
     * @param titulo El título de la solicitud.
     * @param comentario_actividad El comentario de la actividad.
     * @param tipo El tipo de actividad.
     * @param programada Indica si la actividad está programada.
     * @param estado El estado de la solicitud.
     * @param comentario_estado El comentario del estado.
     * @param transporte Indica si se requiere transporte.
     * @param alojamiento Indica si se requiere alojamiento.
     * @param horaInicio La hora de inicio de la actividad.
     * @param horaFin La hora de fin de la actividad.
     * @param fechaInicio La fecha de inicio de la actividad.
     * @param fechaFin La fecha de fin de la actividad.
     */

    public Solicitudes_ACEX(int idSolicitudes, int idSolicitante, String titulo, String comentario_actividad, Tipo_Actividad tipo, boolean programada, Tipo_Estado estado, String comentario_estado, boolean transporte, boolean alojamiento, LocalTime horaInicio, LocalTime horaFin, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idSolicitudes = idSolicitudes;
        this.solicitante = new DAO_Profesor().porId(idSolicitante);
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

    /**
     * Obtiene el ID de la solicitud.
     * 
     * @return El ID de la solicitud.
     */
    public int getIdSolicitudes() {
        return idSolicitudes;
    }

    /**
     * Establece el ID de la solicitud.
     * 
     * @param idSolicitudes El ID de la solicitud.
     */
    public void setIdSolicitudes(int idSolicitudes) {
        this.idSolicitudes = idSolicitudes;
    }

    /**
     * Obtiene el solicitante de la solicitud.
     * 
     * @return El solicitante de la solicitud.
     */
    public Profesor getSolicitante() {
        return solicitante;
    }

    /**
     * Establece el solicitante de la solicitud.
     * 
     * @param solicitante El solicitante de la solicitud.
     */
    public void setSolicitante(Profesor solicitante) {
        this.solicitante = solicitante;
    }

    /**
     * Obtiene el título de la solicitud.
     * 
     * @return El título de la solicitud.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la solicitud.
     * 
     * @param titulo El título de la solicitud.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el comentario de la actividad.
     * 
     * @return El comentario de la actividad.
     */
    public String getComentario_actividad() {
        return comentario_actividad;
    }

    /**
     * Establece el comentario de la actividad.
     * 
     * @param comentario_actividad El comentario de la actividad.
     */
    public void setComentario_actividad(String comentario_actividad) {
        this.comentario_actividad = comentario_actividad;
    }

    /**
     * Obtiene el tipo de actividad.
     * 
     * @return El tipo de actividad.
     */
    public Tipo_Actividad getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de actividad.
     * 
     * @param tipo El tipo de actividad.
     */
    public void setTipo(Tipo_Actividad tipo) {
        this.tipo = tipo;
    }

    /**
     * Verifica si la actividad está programada.
     * 
     * @return true si la actividad está programada, false de lo contrario.
     */
    public boolean isProgramada() {
        return programada;
    }

    /**
     * Establece si la actividad está programada.
     * 
     * @param programada true si la actividad está programada, false de lo contrario.
     */
    public void setProgramada(boolean programada) {
        this.programada = programada;
    }

    /**
     * Obtiene el estado de la solicitud.
     * 
     * @return El estado de la solicitud.
     */
    public Tipo_Estado getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la solicitud.
     * 
     * @param estado El estado de la solicitud.
     */
    public void setEstado(Tipo_Estado estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el comentario del estado.
     * 
     * @return El comentario del estado.
     */
    public String getComentario_estado() {
        return comentario_estado;
    }

    /**
     * Establece el comentario del estado.
     * 
     * @param comentario_estado El comentario del estado.
     */
    public void setComentario_estado(String comentario_estado) {
        this.comentario_estado = comentario_estado;
    }

    /**
     * Verifica si se requiere transporte.
     * 
     * @return true si se requiere transporte, false de lo contrario.
     */
    public boolean isTransporte() {
        return transporte;
    }

    /**
     * Establece si se requiere transporte.
     * 
     * @param transporte true si se requiere transporte, false de lo contrario.
     */
    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    /**
     * Verifica si se requiere alojamiento.
     * 
     * @return true si se requiere alojamiento, false de lo contrario.
     */
    public boolean isAlojamiento() {
        return alojamiento;
    }

    /**
     * Establece si se requiere alojamiento.
     * 
     * @param alojamiento true si se requiere alojamiento, false de lo contrario.
     */
    public void setAlojamiento(boolean alojamiento) {
        this.alojamiento = alojamiento;
    }

    /**
     * Obtiene la hora de inicio de la actividad.
     * 
     * @return La hora de inicio de la actividad.
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * Establece la hora de inicio de la actividad.
     * 
     * @param horaInicio La hora de inicio de la actividad.
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Obtiene la hora de fin de la actividad.
     * 
     * @return La hora de fin de la actividad.
     */
    public LocalTime getHoraFin() {
        return horaFin;
    }

    /**
     * Establece la hora de fin de la actividad.
     * 
     * @param horaFin La hora de fin de la actividad.
     */
    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Obtiene la fecha de inicio de la actividad.
     * 
     * @return La fecha de inicio de la actividad.
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio de la actividad.
     * 
     * @param fechaInicio La fecha de inicio de la actividad.
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de fin de la actividad.
     * 
     * @return La fecha de fin de la actividad.
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de fin de la actividad.
     * 
     * @param fechaFin La fecha de fin de la actividad.
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    
 
}