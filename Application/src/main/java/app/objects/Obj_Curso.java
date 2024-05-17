package app.objects;

import app.enums.Enum_Etapa;


public class Obj_Curso {
    private int id;
    private String codigo;
    private Enum_Etapa etapa;
    private String descripcion;
    private boolean activo;

    public Obj_Curso(int id, String codigo, Enum_Etapa etapa, String descripcion, boolean activo) {
        this.id = id;
        this.codigo = codigo;
        this.etapa = etapa;
        this.descripcion = descripcion;
        this.activo = activo;
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

    public Enum_Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Enum_Etapa etapa) {
        this.etapa = etapa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
