package app.objects;
/* @author Luis */
import app.database.DAO_Actividad_Solicitada;
import app.database.DAO_Curso;

/**
 * La clase Obj_Curso_Participante representa un participante de un curso en la aplicación.
 */
public class Obj_Curso_Participante {
    private int id;
    private Obj_Curso curso;
    private Obj_Actividad_Solicitada actividad;
    private int numAlumnos;

    /**
     * Crea una nueva instancia de Obj_Curso_Participante con los valores especificados.
     * 
     * @param id el ID del participante
     * @param idCurso el ID del curso al que pertenece el participante
     * @param idActividad el ID de la actividad solicitada por el participante
     * @param numAlumnos el número de alumnos del participante
     */
    public Obj_Curso_Participante(int id, int idCurso, int idActividad, int numAlumnos) {
        this.id = id;
        this.curso = new DAO_Curso().getById(idCurso);
        this.actividad = new DAO_Actividad_Solicitada().getById(idActividad);
        this.numAlumnos = numAlumnos;
    }

    /**
     * Obtiene el ID del participante.
     * 
     * @return el ID del participante
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del participante.
     * 
     * @param id el nuevo ID del participante
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el curso al que pertenece el participante.
     * 
     * @return el curso al que pertenece el participante
     */
    public Obj_Curso getCurso() {
        return curso;
    }

    /**
     * Establece el curso al que pertenece el participante.
     * 
     * @param curso el nuevo curso al que pertenece el participante
     */
    public void setCurso(Obj_Curso curso) {
        this.curso = curso;
    }

    /**
     * Obtiene la actividad solicitada por el participante.
     * 
     * @return la actividad solicitada por el participante
     */
    public Obj_Actividad_Solicitada getActividad() {
        return actividad;
    }

    /**
     * Establece la actividad solicitada por el participante.
     * 
     * @param actividad la nueva actividad solicitada por el participante
     */
    public void setActividad(Obj_Actividad_Solicitada actividad) {
        this.actividad = actividad;
    }

    /**
     * Obtiene el número de alumnos del participante.
     * 
     * @return el número de alumnos del participante
     */
    public int getNumAlumnos() {
        return numAlumnos;
    }

    /**
     * Establece el número de alumnos del participante.
     * 
     * @param numAlumnos el nuevo número de alumnos del participante
     */
    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }
}