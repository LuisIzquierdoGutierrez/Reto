package acex.objects;

import acex.enums.C_Etapa;


public class Curso {
    private int id;
    private String codigo;
    private C_Etapa etapa;
    private int num_alumnos;
    private boolean activo;
    private String descripcion;
    
    public Curso(int id, String codigo, C_Etapa etapa, int num_alumnos, boolean activo, String descripcion) {
        this.id = id;
        this.codigo = codigo;
        this.etapa = etapa;
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

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    public C_Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(C_Etapa etapa) {
        this.etapa = etapa;
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
