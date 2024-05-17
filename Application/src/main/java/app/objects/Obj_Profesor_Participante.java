package app.objects;

import app.database.DAO_Actividad_Solicitada;
import app.database.DAO_Profesor;


public class Obj_Profesor_Participante {
    private int id;
    private Obj_Profesor profesor;
    private Obj_Actividad_Solicitada actividad;

    public Obj_Profesor_Participante(int id, int idProfesor, int idActividad) {
        this.id = id;
        this.profesor = new DAO_Profesor().getById(idProfesor);
        this.actividad = new DAO_Actividad_Solicitada().getById(idActividad);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Obj_Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Obj_Profesor profesor) {
        this.profesor = profesor;
    }

    public Obj_Actividad_Solicitada getActividad() {
        return actividad;
    }

    public void setActividad(Obj_Actividad_Solicitada actividad) {
        this.actividad = actividad;
    }
}
