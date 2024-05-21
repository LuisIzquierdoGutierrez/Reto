package app.objects;
/* @author  Adrian*/
import app.database.DAO_Actividad_Solicitada;
import app.database.DAO_Profesor;

/**
 * Esta clase representa un objeto Profesor Responsable.
 * Un Profesor Responsable es aquel que está a cargo de una actividad solicitada.
 */
public class Obj_Profesor_Responsable {
    private int id;
    private Obj_Profesor profesor;
    private Obj_Actividad_Solicitada actividad;

    /**
     * Constructor de la clase Obj_Profesor_Responsable.
     * @param id el identificador del profesor responsable
     * @param idProfesor el identificador del profesor asociado
     * @param idActividad el identificador de la actividad asociada
     */
    public Obj_Profesor_Responsable(int id, int idProfesor, int idActividad) {
        this.id = id;
        this.profesor = new DAO_Profesor().getById(idProfesor);
        this.actividad = new DAO_Actividad_Solicitada().getById(idActividad);
    }

    /**
     * Obtiene el identificador del profesor responsable.
     * @return el identificador del profesor responsable
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del profesor responsable.
     * @param id el identificador del profesor responsable a establecer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el profesor asociado al profesor responsable.
     * @return el profesor asociado al profesor responsable
     */
    public Obj_Profesor getProfesor() {
        return profesor;
    }

    /**
     * Establece el profesor asociado al profesor responsable.
     * @param profesor el profesor asociado al profesor responsable a establecer
     */
    public void setProfesor(Obj_Profesor profesor) {
        this.profesor = profesor;
    }

    /**
     * Obtiene la actividad asociada al profesor responsable.
     * @return la actividad asociada al profesor responsable
     */
    public Obj_Actividad_Solicitada getActividad() {
        return actividad;
    }

    /**
     * Establece la actividad asociada al profesor responsable.
     * @param actividad la actividad asociada al profesor responsable a establecer
     */
    public void setActividad(Obj_Actividad_Solicitada actividad) {
        this.actividad = actividad;
    }
}
