package app.objects;

import app.database.DAO_Actividad_Solicitada;
import app.database.DAO_Grupo;


public class Obj_Grupo_Participante {
    private int id;
    private Obj_Grupo grupo;
    private Obj_Actividad_Solicitada actividad;
    private int numAlumnos;

    public Obj_Grupo_Participante(int id, int idGrupo, int idActividad, int numAlumnos) {
        this.id = id;
        this.grupo = new DAO_Grupo().getById(idGrupo);
        this.actividad = new DAO_Actividad_Solicitada().getById(idActividad);
        this.numAlumnos = numAlumnos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Obj_Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Obj_Grupo grupo) {
        this.grupo = grupo;
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
