package app.objects;
/* @author Adrian */

/**
 * Esta clase representa un objeto de alojamiento.
 */
public class Obj_Alojamiento {
    private int id;
    private String nombre;

    /**
     * Crea un nuevo objeto de alojamiento con el ID y nombre especificados.
     * 
     * @param id el ID del alojamiento
     * @param nombre el nombre del alojamiento
     */
    public Obj_Alojamiento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID del alojamiento.
     * 
     * @return el ID del alojamiento
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del alojamiento.
     * 
     * @param id el nuevo ID del alojamiento
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del alojamiento.
     * 
     * @return el nombre del alojamiento
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del alojamiento.
     * 
     * @param nombre el nuevo nombre del alojamiento
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

