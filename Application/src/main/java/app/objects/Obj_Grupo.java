package app.objects;

import app.database.DAO_Curso;


public class Obj_Grupo {
    private int id;
    private Obj_Curso curso;
    private String codigo;
    private int numAlumnos;
    private boolean activo;

    public Obj_Grupo(int id, int idCurso, String codigo, int numAlumnos, boolean activo) {
        this.id = id;
        this.curso = new DAO_Curso().getById(idCurso);
        this.codigo = codigo;
        this.numAlumnos = numAlumnos;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Obj_Curso getCurso() {
        return curso;
    }

    public void setCurso(Obj_Curso curso) {
        this.curso = curso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }

    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
