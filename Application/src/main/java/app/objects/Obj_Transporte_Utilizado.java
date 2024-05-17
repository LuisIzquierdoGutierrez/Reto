package app.objects;

import app.database.DAO_Actividad_Solicitada;
import app.database.DAO_Transporte;


public class Obj_Transporte_Utilizado {
    private int id;
    private Obj_Transporte transporte;
    private Obj_Actividad_Solicitada actividad;

    public Obj_Transporte_Utilizado(int id, int idTransporte, int idActividad) {
        this.id = id;
        this.transporte = new DAO_Transporte().getById(idTransporte);
        this.actividad = new DAO_Actividad_Solicitada().getById(idActividad);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Obj_Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Obj_Transporte transporte) {
        this.transporte = transporte;
    }

    public Obj_Actividad_Solicitada getActividad() {
        return actividad;
    }

    public void setActividad(Obj_Actividad_Solicitada actividad) {
        this.actividad = actividad;
    }
}
