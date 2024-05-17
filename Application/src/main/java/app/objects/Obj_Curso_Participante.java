package app.objects;

import app.database.DAO_Actividad_Solicitada;
import app.database.DAO_Curso;


public class Obj_Curso_Participante {
    private int id;
    private Obj_Curso curso;
    private Obj_Actividad_Solicitada actividad;
    private int numAlumnos;

    public Obj_Curso_Participante(int id, int idCurso, int idActividad, int numAlumnos) {
        this.id = id;
        this.curso = new DAO_Curso().getById(idCurso);
        this.actividad = new DAO_Actividad_Solicitada().getById(idActividad);
        this.numAlumnos = numAlumnos;
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

    public Obj_Actividad_Solicitada getActividad() {
        return actividad;
    }

    public void setActividad(Obj_Actividad_Solicitada actividad) {
        this.actividad = actividad;
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }

    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }
}
