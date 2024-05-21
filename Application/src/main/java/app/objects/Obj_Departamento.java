package app.objects;
/* @author Adrian, Luis */
import app.database.DAO_Profesor;
/**
 * Esta clase representa un objeto Departamento en la aplicación.
 */
public class Obj_Departamento {
    private int id;
    private Obj_Profesor jefe;
    private String codigo;
    private String nombre;

    /**
     * Crea una instancia de Obj_Departamento con los valores especificados.
     * 
     * @param id     El ID del departamento.
     * @param idJefe El ID del jefe del departamento.
     * @param codigo El código del departamento.
     * @param nombre El nombre del departamento.
     */
    public Obj_Departamento(int id, int idJefe, String codigo, String nombre) {
        this.id = id;
        this.jefe = new DAO_Profesor().getById(idJefe);
        this.codigo = codigo;
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID del departamento.
     * 
     * @return El ID del departamento.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del departamento.
     * 
     * @param id El ID del departamento.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el jefe del departamento.
     * 
     * @return El jefe del departamento.
     */
    public Obj_Profesor getJefe() {
        return jefe;
    }

    /**
     * Establece el jefe del departamento.
     * 
     * @param jefe El jefe del departamento.
     */
    public void setJefe(Obj_Profesor jefe) {
        this.jefe = jefe;
    }

    /**
     * Obtiene el código del departamento.
     * 
     * @return El código del departamento.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del departamento.
     * 
     * @param codigo El código del departamento.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el nombre del departamento.
     * 
     * @return El nombre del departamento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del departamento.
     * 
     * @param nombre El nombre del departamento.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
