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
public class Curso_Participante {

    int id;
    Cursos curso;
    Solicitudes_ACEX actividad;
    int num_alumnos;

    public Curso_Participante(int id, int curso, int actividad, int num_alumnos) {
        this.id = id;
        this.curso = new DAO_Cursos().porId(curso);
        this.actividad = new DAO_Solicitudes_ACEX().porId(actividad);
        this.num_alumnos = num_alumnos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
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
