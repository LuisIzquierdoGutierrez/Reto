/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acex.objects;

import acex.database.DAO_Profesor;
import acex.database.DAO_Solicitudes_ACEX;

/**
 *
 * @author Adrian
 */
public class Profesor_Responsable {
    private int id;
    private Profesor Responsable;
    private Solicitudes_ACEX idActividad;

    public Profesor_Responsable(int id, int idResponsable,  int Actividad) {
        this.id = id;
        this.Responsable = new DAO_Profesor().porId(idResponsable);
        this.idActividad = new DAO_Solicitudes_ACEX().porId(Actividad);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profesor getResponsable() {
        return Responsable;
    }

    public void setResponsable(Profesor Responsable) {
        this.Responsable = Responsable;
    }

    public Solicitudes_ACEX getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Solicitudes_ACEX idActividad) {
        this.idActividad = idActividad;
    }

}
