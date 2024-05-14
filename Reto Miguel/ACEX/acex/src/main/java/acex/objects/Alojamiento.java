package acex.objects;


public class Alojamiento {
    private int id;
    private int id_actividad;
    private String nombre;
    private double importe;
    private String comentario;
    
    public Alojamiento(int id, int id_actividad, String nombre, double importe, String comentario) {
        this.id = id;
        this.id_actividad = id_actividad;
        this.nombre = nombre;
        this.importe = importe;
        this.comentario = comentario;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public int getIdActividad() {
        return id_actividad;
    }

    public void setIdActividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
