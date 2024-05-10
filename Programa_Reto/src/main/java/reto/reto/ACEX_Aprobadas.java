/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/** Esta clase representa las actividades aprobadas para el programa ACEX.
 * @author Adrian
 * @see Profesor
 * @see TipoActividad
 * @see TipoEstado
 */
public class ACEX_Aprobadas {

    private int idAprobadas;
    private Profesor solicitante;
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
    
    /**
     * Constructor de la clase ACEX_Aprobadas.
     * 
     * @param id_aprobada el ID de la actividad aprobada
     * @param idSolicitante el ID del profesor solicitante
     * @param titulo el título de la actividad
     * @param comentario_actividad el comentario de la actividad
     * @param tipo el tipo de actividad
     * @param programada indica si la actividad está programada
     * @param estado el estado de la actividad
     * @param comentario_estado el comentario del estado de la actividad
     * @param transporte indica si se requiere transporte para la actividad
     * @param alojamiento indica si se requiere alojamiento para la actividad
     * @param hora_inicio la hora de inicio de la actividad
     * @param hora_fin la hora de fin de la actividad
     * @param fecha_inicio la fecha de inicio de la actividad
     * @param fecha_fin la fecha de fin de la actividad
     */

    public ACEX_Aprobadas(int id_aprobada, int idSolicitante, String titulo, String comentario_actividad, TipoActividad tipo, boolean programada, TipoEstado estado, String comentario_estado, boolean transporte, boolean alojamiento, LocalTime hora_inicio, LocalTime hora_fin, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.idAprobadas = id_aprobada;
        this.solicitante = new ProfesorDAO().porId(idSolicitante);
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
      /**
     * Obtiene el ID de la actividad aprobada.
     * 
     * @return el ID de la actividad aprobada
     */


    public int getIdAprobadas() {
        return idAprobadas;
    }
    /**
     * Establece el ID de la actividad aprobada.
     * 
     * @param idAprobadas el ID de la actividad aprobada
     */

    public void setIdAprobadas(int idAprobadas) {
        this.idAprobadas = idAprobadas;
    }
    /**
     * Obtiene el profesor solicitante.
     * 
     * @return el profesor solicitante
     */

    public Profesor getSolicitante() {
        return solicitante;
    }
    
     /**
     * Establece el profesor solicitante.
     * 
     * @param solicitante el profesor solicitante
     */

    public void setSolicitante(Profesor solicitante) {
        this.solicitante = solicitante;
    }
    
     /**
     * Obtiene el título de la actividad.
     * 
     * @return el título de la actividad
     */


    public String getTitulo() {
        return titulo;
    }
    /**
     * Establece el título de la actividad.
     * 
     * @param titulo el título de la actividad
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Obtiene el comentario de la actividad.
     * 
     * @return el comentario de la actividad
     */

    public String getComentario_actividad() {
        return comentario_actividad;
    }
    /**
     * Establece el comentario de la actividad.
     * 
     * @param comentario_actividad el comentario de la actividad
     */

    public void setComentario_actividad(String comentario_actividad) {
        this.comentario_actividad = comentario_actividad;
    } /**
     * Obtiene el tipo de actividad.
     * 
     * @return el tipo de actividad
     */

    public TipoActividad getTipo() {
        return tipo;
    }
     /**
     * Establece el tipo de actividad.
     * 
     * @param tipo el tipo de actividad
     */

    public void setTipo(TipoActividad tipo) {
        this.tipo = tipo;
    }
    /**
     * Verifica si la actividad está programada.
     * 
     * @return true si la actividad está programada, false de lo contrario
     */

    public boolean isProgramada() {
        return programada;
    }
     /**
     * Establece si la actividad está programada.
     * 
     * @param programada true si la actividad está programada, false de lo contrario
     */

    public void setProgramada(boolean programada) {
        this.programada = programada;
    }
     /**
     * Obtiene el estado de la actividad.
     * 
     * @return el estado de la actividad
     */

    public TipoEstado getEstado() {
        return estado;
    }
      /**
     * Establece el estado de la actividad.
     * 
     * @param estado el estado de la actividad
     */

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }
      /**
     * Obtiene el comentario del estado de la actividad.
     * 
     * @return el comentario del estado de la actividad
     */

    public String getComentario_estado() {
        return comentario_estado;
    }
     /**
     * Establece el comentario del estado de la actividad.
     * 
     * @param comentario_estado el comentario del estado de la actividad
     */

    public void setComentario_estado(String comentario_estado) {
        this.comentario_estado = comentario_estado;
    }
     /**
     * Verifica si se requiere transporte para la actividad.
     * 
     * @return true si se requiere transporte, false de lo contrario
     */

    public boolean isTransporte() {
        return transporte;
    }
     /**
     * Establece si se requiere transporte para la actividad.
     * 
     * @param transporte true si se requiere transporte, false de lo contrario
     */

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }
     /**
     * Verifica si se requiere alojamiento para la actividad.
     * 
     * @return true si se requiere alojamiento, false de lo contrario
     */

    public boolean isAlojamiento() {
        return alojamiento;
    }
    /**
     * Establece si se requiere alojamiento para la actividad.
     * 
     * @param alojamiento true si se requiere alojamiento, false de lo contrario
     */

    public void setAlojamiento(boolean alojamiento) {
        this.alojamiento = alojamiento;
    }
    /**
     * Obtiene la hora de inicio de la actividad.
     * 
     * @return la hora de inicio de la actividad
     */

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }
     /**
     * Establece la hora de inicio de la actividad.
     * 
     * @param hora_inicio la hora de inicio de la actividad
     */

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }
     /**
     * Obtiene la hora de fin de la actividad.
     * 
     * @return la hora de fin de la actividad
     */

    public LocalTime getHora_fin() {
        return hora_fin;
    }
     /**
     * Establece la hora de fin de la actividad.
     * 
     * @param hora_fin la hora de fin de la actividad
     */

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }
      /**
     * Obtiene la fecha de inicio de la actividad.
     * 
     * @return la fecha de inicio de la actividad
     */

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }
     /**
     * Establece la fecha de inicio de la actividad.
     * 
     * @param fecha_inicio la fecha de inicio de la actividad
     */

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    /**
     * Obtiene la fecha de fin de la actividad.
     * 
     * @return la fecha de fin de la actividad
     */

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }
     /**
     * Establece la fecha de fin de la actividad.
     * 
     * @param fecha_fin la fecha de fin de la actividad
     */

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

   

}
