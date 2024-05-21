package app.objects;
/*@author Adrian,Luis */
import app.database.DAO_Actividad_Solicitada;
import app.database.DAO_Transporte;

/**
 * Esta clase representa un objeto de transporte utilizado en una actividad solicitada.
 */
public class Obj_Transporte_Utilizado {
    private int id;
    private Obj_Transporte transporte;
    private Obj_Actividad_Solicitada actividad;
    private double importe;
    private String comentario;

    /**
     * Constructor de la clase Obj_Transporte_Utilizado.
     * 
     * @param id el ID del transporte utilizado
     * @param idTransporte el ID del transporte asociado
     * @param idActividad el ID de la actividad solicitada asociada
     * @param importe el importe del transporte utilizado
     * @param comentario el comentario sobre el transporte utilizado
     */
    public Obj_Transporte_Utilizado(int id, int idTransporte, int idActividad, double importe, String comentario) {
        this.id = id;
        this.transporte = new DAO_Transporte().getById(idTransporte);
        this.actividad = new DAO_Actividad_Solicitada().getById(idActividad);
        this.importe = importe;
        this.comentario = comentario;
    }

    /**
     * Obtiene el ID del transporte utilizado.
     * 
     * @return el ID del transporte utilizado
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del transporte utilizado.
     * 
     * @param id el ID del transporte utilizado
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el transporte asociado.
     * 
     * @return el transporte asociado
     */
    public Obj_Transporte getTransporte() {
        return transporte;
    }

    /**
     * Establece el transporte asociado.
     * 
     * @param transporte el transporte asociado
     */
    public void setTransporte(Obj_Transporte transporte) {
        this.transporte = transporte;
    }

    /**
     * Obtiene la actividad solicitada asociada.
     * 
     * @return la actividad solicitada asociada
     */
    public Obj_Actividad_Solicitada getActividad() {
        return actividad;
    }

    /**
     * Establece la actividad solicitada asociada.
     * 
     * @param actividad la actividad solicitada asociada
     */
    public void setActividad(Obj_Actividad_Solicitada actividad) {
        this.actividad = actividad;
    }

    /**
     * Obtiene el importe del transporte utilizado.
     * 
     * @return el importe del transporte utilizado
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Establece el importe del transporte utilizado.
     * 
     * @param importe el importe del transporte utilizado
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }

    /**
     * Obtiene el comentario sobre el transporte utilizado.
     * 
     * @return el comentario sobre el transporte utilizado
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Establece el comentario sobre el transporte utilizado.
     * 
     * @param comentario el comentario sobre el transporte utilizado
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
