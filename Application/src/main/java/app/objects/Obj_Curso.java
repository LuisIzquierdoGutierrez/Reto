package app.objects;
/* @author Adrian */
import app.enums.Enum_Etapa;

/**
 * La clase Obj_Curso representa un curso en la aplicación.
 */
public class Obj_Curso {
    private int id;
    private String codigo;
    private Enum_Etapa etapa;
    private String descripcion;
    private boolean activo;

    /**
     * Crea una instancia de Obj_Curso con los datos proporcionados.
     * 
     * @param id          el ID del curso
     * @param codigo      el código del curso
     * @param etapa       la etapa del curso
     * @param descripcion la descripción del curso
     * @param activo      indica si el curso está activo o no
     */
    public Obj_Curso(int id, String codigo, Enum_Etapa etapa, String descripcion, boolean activo) {
        this.id = id;
        this.codigo = codigo;
        this.etapa = etapa;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    /**
     * Obtiene el ID del curso.
     * 
     * @return el ID del curso
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del curso.
     * 
     * @param id el ID del curso
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el código del curso.
     * 
     * @return el código del curso
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del curso.
     * 
     * @param codigo el código del curso
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene la etapa del curso.
     * 
     * @return la etapa del curso
     */
    public Enum_Etapa getEtapa() {
        return etapa;
    }

    /**
     * Establece la etapa del curso.
     * 
     * @param etapa la etapa del curso
     */
    public void setEtapa(Enum_Etapa etapa) {
        this.etapa = etapa;
    }

    /**
     * Obtiene la descripción del curso.
     * 
     * @return la descripción del curso
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del curso.
     * 
     * @param descripcion la descripción del curso
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Verifica si el curso está activo.
     * 
     * @return true si el curso está activo, false de lo contrario
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Establece si el curso está activo o no.
     * 
     * @param activo true si el curso está activo, false de lo contrario
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
