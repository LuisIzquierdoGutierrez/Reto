/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

/**
 *
 * @author DAM103
 */
public class Grupo extends Cursos {
    private int idGrupo;
    private String curso;
    private int numAlumnos;
    private boolean activo;

    public Grupo( int idGrupo,String curso, int numAlumnos,int idCursos, boolean activo, boolean cursoActivo, String codigo, String descripcion, int num_alumnos, TipoEtapa etapa) {
        super(idCursos,cursoActivo, codigo, descripcion, num_alumnos, etapa);
        this.idGrupo=idGrupo;
        this.curso = curso;
        this.numAlumnos = numAlumnos;
        this.activo = activo;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
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
