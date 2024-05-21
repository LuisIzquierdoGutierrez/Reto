package app.objects;
/* @author  Luis*/
import app.database.DAO_Actividad_Solicitada;
import app.database.DAO_Grupo;

/**
 * Esta clase representa un objeto Grupo Participante.
 * Contiene información sobre el grupo y la actividad en la que participa.
 */
public class Obj_Grupo_Participante {
    private int id;
    private Obj_Grupo grupo;
    private Obj_Actividad_Solicitada actividad;
    private int numAlumnos;

    /**
     * Constructor de la clase Obj_Grupo_Participante.
     * @param id El ID del grupo participante.
     * @param idGrupo El ID del grupo al que pertenece.
     * @param idActividad El ID de la actividad en la que participa.
     * @param numAlumnos El número de alumnos en el grupo.
     */
    public Obj_Grupo_Participante(int id, int idGrupo, int idActividad, int numAlumnos) {
        this.id = id;
        this.grupo = new DAO_Grupo().getById(idGrupo);
        this.actividad = new DAO_Actividad_Solicitada().getById(idActividad);
        this.numAlumnos = numAlumnos;
    }

    /**
     * Obtiene el ID del grupo participante.
     * @return El ID del grupo participante.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del grupo participante.
     * @param id El ID del grupo participante.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el grupo al que pertenece el participante.
     * @return El grupo al que pertenece el participante.
     */
    public Obj_Grupo getGrupo() {
        return grupo;
    }

    /**
     * Establece el grupo al que pertenece el participante.
     * @param grupo El grupo al que pertenece el participante.
     */
    public void setGrupo(Obj_Grupo grupo) {
        this.grupo = grupo;
    }

    /**
     * Obtiene la actividad en la que participa el grupo.
     * @return La actividad en la que participa el grupo.
     */
    public Obj_Actividad_Solicitada getActividad() {
        return actividad;
    }

    /**
     * Establece la actividad en la que participa el grupo.
     * @param actividad La actividad en la que participa el grupo.
     */
    public void setActividad(Obj_Actividad_Solicitada actividad) {
        this.actividad = actividad;
    }

    /**
     * Obtiene el número de alumnos en el grupo.
     * @return El número de alumnos en el grupo.
     */
    public int getNumAlumnos() {
        return numAlumnos;
    }

    /**
     * Establece el número de alumnos en el grupo.
     * @param numAlumnos El número de alumnos en el grupo.
     */
    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }
}
