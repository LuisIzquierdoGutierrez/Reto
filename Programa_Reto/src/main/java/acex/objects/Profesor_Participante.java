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
public class Profesor_Participante {
    private int id;
    private Profesor Participante;
    private Solicitudes_ACEX idActividad;

    public Profesor_Participante(int id, int idParticipante,  int Actividad) {
        this.id = id;
        this.Participante = new DAO_Profesor().porId(idParticipante);
        this.idActividad = new DAO_Solicitudes_ACEX().porId(Actividad);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profesor getParticipante() {
        return Participante;
    }

    public void setParticipante(Profesor Participante) {
        this.Participante = Participante;
    }

    public Solicitudes_ACEX getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Solicitudes_ACEX idActividad) {
        this.idActividad = idActividad;
    }
    
}
