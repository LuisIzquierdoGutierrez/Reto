package app.objects;
/* @author  Luis*/
import app.database.DAO_Profesor;
import app.enums.Enum_Estado;
import app.enums.Enum_Tipo;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Esta clase representa una actividad solicitada por un profesor.
 */
public class Obj_Actividad_Solicitada {
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

    /**
     * Constructor de la clase Obj_Actividad_Solicitada.
     * 
     * @param id                  El ID de la actividad.
     * @param idSolicitante       El ID del profesor solicitante.
     * @param nombre              El nombre de la actividad.
     * @param comentarioActividad El comentario de la actividad.
     * @param tipo                El tipo de la actividad.
     * @param prevista            Indica si la actividad está prevista.
     * @param estado              El estado de la actividad.
     * @param comentarioEstado    El comentario del estado de la actividad.
     * @param transporte          Indica si se requiere transporte para la actividad.
     * @param alojamiento         Indica si se requiere alojamiento para la actividad.
     * @param horaInicio          La hora de inicio de la actividad.
     * @param horaFin             La hora de fin de la actividad.
     * @param fechaInicio         La fecha de inicio de la actividad.
     * @param fechaFin            La fecha de fin de la actividad.
     */
    public Obj_Actividad_Solicitada(int id, int idSolicitante, String nombre, String comentarioActividad, Enum_Tipo tipo, boolean prevista, Enum_Estado estado, String comentarioEstado, boolean transporte, boolean alojamiento, LocalTime horaInicio, LocalTime horaFin, LocalDate fechaInicio, LocalDate fechaFin) {
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

    /**
     * Obtiene el ID de la actividad.
     * 
     * @return El ID de la actividad.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la actividad.
     * 
     * @param id El ID de la actividad.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el profesor solicitante de la actividad.
     * 
     * @return El profesor solicitante de la actividad.
     */
    public Obj_Profesor getSolicitante() {
        return solicitante;
    }

    /**
     * Establece el profesor solicitante de la actividad.
     * 
     * @param solicitante El profesor solicitante de la actividad.
     */
    public void setSolicitante(Obj_Profesor solicitante) {
        this.solicitante = solicitante;
    }

    /**
     * Obtiene el nombre de la actividad.
     * 
     * @return El nombre de la actividad.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la actividad.
     * 
     * @param nombre El nombre de la actividad.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el comentario de la actividad.
     * 
     * @return El comentario de la actividad.
     */
    public String getComentarioActividad() {
        return comentarioActividad;
    }

    /**
     * Establece el comentario de la actividad.
     * 
     * @param comentarioActividad El comentario de la actividad.
     */
    public void setComentarioActividad(String comentarioActividad) {
        this.comentarioActividad = comentarioActividad;
    }

    /**
     * Obtiene el tipo de la actividad.
     * 
     * @return El tipo de la actividad.
     */
    public Enum_Tipo getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la actividad.
     * 
     * @param tipo El tipo de la actividad.
     */
    public void setTipo(Enum_Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * Verifica si la actividad está prevista.
     * 
     * @return true si la actividad está prevista, false de lo contrario.
     */
    public boolean isPrevista() {
        return prevista;
    }

    /**
     * Establece si la actividad está prevista.
     * 
     * @param prevista true si la actividad está prevista, false de lo contrario.
     */
    public void setPrevista(boolean prevista) {
        this.prevista = prevista;
    }

    /**
     * Obtiene el estado de la actividad.
     * 
     * @return El estado de la actividad.
     */
    public Enum_Estado getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la actividad.
     * 
     * @param estado El estado de la actividad.
     */
    public void setEstado(Enum_Estado estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el comentario del estado de la actividad.
     * 
     * @return El comentario del estado de la actividad.
     */
    public String getComentarioEstado() {
        return comentarioEstado;
    }

    /**
     * Establece el comentario del estado de la actividad.
     * 
     * @param comentarioEstado El comentario del estado de la actividad.
     */
    public void setComentarioEstado(String comentarioEstado) {
        this.comentarioEstado = comentarioEstado;
    }

    /**
     * Verifica si se requiere transporte para la actividad.
     * 
     * @return true si se requiere transporte, false de lo contrario.
     */
    public boolean isTransporte() {
        return transporte;
    }

    /**
     * Establece si se requiere transporte para la actividad.
     * 
     * @param transporte true si se requiere transporte, false de lo contrario.
     */
    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    /**
     * Verifica si se requiere alojamiento para la actividad.
     * 
     * @return true si se requiere alojamiento, false de lo contrario.
     */
    public boolean isAlojamiento() {
        return alojamiento;
    }

    /**
     * Establece si se requiere alojamiento para la actividad.
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
