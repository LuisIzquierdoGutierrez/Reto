package app.objects;

/* @author Adrian, Luis */
/**
 * Esta clase representa un objeto de transporte.
 */
public class Obj_Transporte {
    private int id;
    private String nombre;

    /**
     * Crea un nuevo objeto de transporte con el ID y nombre especificados.
     * 
     * @param id     el ID del objeto de transporte
     * @param nombre el nombre del objeto de transporte
     */
    public Obj_Transporte(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID del objeto de transporte.
     * 
     * @return el ID del objeto de transporte
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del objeto de transporte.
     * 
     * @param id el nuevo ID del objeto de transporte
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del objeto de transporte.
     * 
     * @return el nombre del objeto de transporte
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del objeto de transporte.
     * 
     * @param nombre el nuevo nombre del objeto de transporte
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
