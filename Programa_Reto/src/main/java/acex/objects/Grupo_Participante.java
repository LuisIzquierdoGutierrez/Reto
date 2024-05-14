/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acex.objects;

import acex.database.*;

/**
 *
 * @author DAM126
 */
public class Grupo_Participante {
    int id;
    Grupo grupo;
    Solicitudes_ACEX actividad;
    int num_alumnos;

    public Grupo_Participante(int id, int grupo, int actividad, int num_alumnos) {
        this.id = id;
        this.grupo = new DAO_Grupo().porId(grupo);
        this.actividad = new DAO_Solicitudes_ACEX().porId(actividad);
        this.num_alumnos = num_alumnos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Solicitudes_ACEX getActividad() {
        return actividad;
    }

    public void setActividad(Solicitudes_ACEX actividad) {
        this.actividad = actividad;
    }

    public int getNum_alumnos() {
        return num_alumnos;
    }

    public void setNum_alumnos(int num_alumnos) {
        this.num_alumnos = num_alumnos;
    }
    
}
