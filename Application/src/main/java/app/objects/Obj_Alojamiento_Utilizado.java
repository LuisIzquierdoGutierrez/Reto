package app.objects;
/*@author Miguel*/ 
import app.database.DAO_Actividad_Solicitada;
import app.database.DAO_Alojamiento;

/**
 * La clase Obj_Alojamiento_Utilizado representa un objeto que contiene información sobre un alojamiento utilizado en una actividad solicitada.
 */
public class Obj_Alojamiento_Utilizado {
    private int id;
    private Obj_Alojamiento alojamiento;
    private Obj_Actividad_Solicitada actividad;
    private double importe;
    private String comentario;

    /**
     * Crea una nueva instancia de Obj_Alojamiento_Utilizado con los valores especificados.
     * 
     * @param id el ID del alojamiento utilizado
     * @param idAlojamiento el ID del alojamiento asociado
     * @param idActividad el ID de la actividad asociada
     * @param importe el importe del alojamiento utilizado
     * @param comentario el comentario sobre el alojamiento utilizado
     */
    public Obj_Alojamiento_Utilizado(int id, int idAlojamiento, int idActividad, double importe, String comentario) {
        this.id = id;
        this.alojamiento = new DAO_Alojamiento().getById(idAlojamiento);
        this.actividad = new DAO_Actividad_Solicitada().getById(idActividad);
        this.importe = importe;
        this.comentario = comentario;
    }

    /**
     * Obtiene el ID del alojamiento utilizado.
     * 
     * @return el ID del alojamiento utilizado
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del alojamiento utilizado.
     * 
     * @param id el nuevo ID del alojamiento utilizado
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el alojamiento asociado.
     * 
     * @return el alojamiento asociado
     */
    public Obj_Alojamiento getAlojamiento() {
        return alojamiento;
    }

    /**
     * Establece el alojamiento asociado.
     * 
     * @param alojamiento el nuevo alojamiento asociado
     */
    public void setAlojamiento(Obj_Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    /**
     * Obtiene la actividad asociada.
     * 
     * @return la actividad asociada
     */
    public Obj_Actividad_Solicitada getActividad() {
        return actividad;
    }

    /**
     * Establece la actividad asociada.
     * 
     * @param actividad la nueva actividad asociada
     */
    public void setActividad(Obj_Actividad_Solicitada actividad) {
        this.actividad = actividad;
    }

    /**
     * Obtiene el importe del alojamiento utilizado.
     * 
     * @return el importe del alojamiento utilizado
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Establece el importe del alojamiento utilizado.
     * 
     * @param importe el nuevo importe del alojamiento utilizado
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }

    /**
     * Obtiene el comentario sobre el alojamiento utilizado.
     * 
     * @return el comentario sobre el alojamiento utilizado
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Establece el comentario sobre el alojamiento utilizado.
     * 
     * @param comentario el nuevo comentario sobre el alojamiento utilizado
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
