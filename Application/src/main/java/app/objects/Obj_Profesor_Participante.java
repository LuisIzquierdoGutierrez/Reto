package app.objects;
/* @author  Adrian*/
import app.database.DAO_Actividad_Solicitada;
import app.database.DAO_Profesor;

/**
 * Esta clase representa un objeto Profesor Participante.
 * Contiene información sobre el profesor y la actividad en la que participa.
 */
public class Obj_Profesor_Participante {
    private int id;
    private Obj_Profesor profesor;
    private Obj_Actividad_Solicitada actividad;

    /**
     * Constructor de la clase Obj_Profesor_Participante.
     * @param id el ID del profesor participante
     * @param idProfesor el ID del profesor asociado
     * @param idActividad el ID de la actividad asociada
     */
    public Obj_Profesor_Participante(int id, int idProfesor, int idActividad) {
        this.id = id;
        this.profesor = new DAO_Profesor().getById(idProfesor);
        this.actividad = new DAO_Actividad_Solicitada().getById(idActividad);
    }

    /**
     * Obtiene el ID del profesor participante.
     * @return el ID del profesor participante
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del profesor participante.
     * @param id el ID del profesor participante
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el profesor asociado al participante.
     * @return el profesor asociado al participante
     */
    public Obj_Profesor getProfesor() {
        return profesor;
    }

    /**
     * Establece el profesor asociado al participante.
     * @param profesor el profesor asociado al participante
     */
    public void setProfesor(Obj_Profesor profesor) {
        this.profesor = profesor;
    }

    /**
     * Obtiene la actividad asociada al participante.
     * @return la actividad asociada al participante
     */
    public Obj_Actividad_Solicitada getActividad() {
        return actividad;
    }

    /**
     * Establece la actividad asociada al participante.
     * @param actividad la actividad asociada al participante
     */
    public void setActividad(Obj_Actividad_Solicitada actividad) {
        this.actividad = actividad;
    }
}
