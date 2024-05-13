package acex.objects;


public class Departamento {
    private int id;
    private int id_jefe;
    private String codigo;
    private String nombre;
    
    public Departamento(int id, int id_jefe, String codigo, String nombre) {
        this.id = id;
        this.id_jefe = id_jefe;
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public int getIdJefe() {
        return id_jefe;
    }

    public void setIdJefe(int id_jefe) {
        this.id_jefe = id_jefe;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
