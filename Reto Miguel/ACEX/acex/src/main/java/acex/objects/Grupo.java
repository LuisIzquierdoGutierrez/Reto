package acex.objects;


public class Grupo {
    private int id;
    private int id_curso;
    private String codigo;
    private int num_alumnos;
    private boolean activo;
    private String descripcion;
    
    public Grupo(int id, int id_curso, String codigo, int num_alumnos, boolean activo, String descripcion) {
        this.id = id;
        this.id_curso = id_curso;
        this.codigo = codigo;
        this.num_alumnos = num_alumnos;
        this.activo = activo;
        this.descripcion = descripcion;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public int getIdCurso() {
        return id_curso;
    }

    public void setIdCurso(int id_curso) {
        this.id_curso = id_curso;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    public int getNumAlumnos() {
        return num_alumnos;
    }

    public void setNumAlumnos(int num_alumnos) {
        this.num_alumnos = num_alumnos;
    }

    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
