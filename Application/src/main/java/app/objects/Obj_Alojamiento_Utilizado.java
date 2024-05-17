package app.objects;

import app.database.DAO_Actividad_Solicitada;
import app.database.DAO_Alojamiento;


public class Obj_Alojamiento_Utilizado {
    private int id;
    private Obj_Alojamiento alojamiento;
    private Obj_Actividad_Solicitada actividad;

    public Obj_Alojamiento_Utilizado(int id, int idAlojamiento, int idActividad) {
        this.id = id;
        this.alojamiento = new DAO_Alojamiento().getById(idAlojamiento);
        this.actividad = new DAO_Actividad_Solicitada().getById(idActividad);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Obj_Alojamiento getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(Obj_Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    public Obj_Actividad_Solicitada getActividad() {
        return actividad;
    }

    public void setActividad(Obj_Actividad_Solicitada actividad) {
        this.actividad = actividad;
    }
}
