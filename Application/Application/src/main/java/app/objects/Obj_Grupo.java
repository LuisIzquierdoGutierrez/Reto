package app.objects;
/* @author Adrian,Luis */
import app.database.DAO_Curso;

/**
 * La clase Obj_Grupo representa un grupo de estudiantes en una aplicación.
 */
public class Obj_Grupo {
    private int id;
    private Obj_Curso curso;
    private String codigo;
    private int numAlumnos;
    private boolean activo;

    /**
     * Crea una instancia de Obj_Grupo con los datos proporcionados.
     * 
     * @param id          El ID del grupo.
     * @param idCurso     El ID del curso al que pertenece el grupo.
     * @param codigo      El código del grupo.
     * @param numAlumnos  El número de alumnos en el grupo.
     * @param activo      Indica si el grupo está activo o no.
     */
    public Obj_Grupo(int id, int idCurso, String codigo, int numAlumnos, boolean activo) {
        this.id = id;
        this.curso = new DAO_Curso().getById(idCurso);
        this.codigo = codigo;
        this.numAlumnos = numAlumnos;
        this.activo = activo;
    }

    /**
     * Obtiene el ID del grupo.
     * 
     * @return El ID del grupo.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del grupo.
     * 
     * @param id El nuevo ID del grupo.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el curso al que pertenece el grupo.
     * 
     * @return El curso al que pertenece el grupo.
     */
    public Obj_Curso getCurso() {
        return curso;
    }

    /**
     * Establece el curso al que pertenece el grupo.
     * 
     * @param curso El nuevo curso al que pertenece el grupo.
     */
    public void setCurso(Obj_Curso curso) {
        this.curso = curso;
    }

    /**
     * Obtiene el código del grupo.
     * 
     * @return El código del grupo.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del grupo.
     * 
     * @param codigo El nuevo código del grupo.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el número de alumnos en el grupo.
     * 
     * @return El número de alumnos en el grupo.
     */
    public int getNumAlumnos() {
        return numAlumnos;
    }

    /**
     * Establece el número de alumnos en el grupo.
     * 
     * @param numAlumnos El nuevo número de alumnos en el grupo.
     */
    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }

    /**
     * Verifica si el grupo está activo.
     * 
     * @return true si el grupo está activo, false de lo contrario.
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Establece si el grupo está activo o no.
     * 
     * @param activo Indica si el grupo está activo o no.
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
