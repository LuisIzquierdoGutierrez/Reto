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
    private int id_grupo;
    private String cod_grupo;
    private int numAlumnos;
    private boolean activo;

    public Grupo( int idGrupo,String curso, int numAlumnos,int idCursos, boolean activo, boolean cursoActivo, String codigo, String descripcion, int num_alumnos, TipoEtapa etapa) {
        super(idCursos,cursoActivo, codigo, descripcion, num_alumnos, etapa);
        this.id_grupo=idGrupo;
        this.cod_grupo = curso;
        this.numAlumnos = numAlumnos;
        this.activo = activo;
    }

    public int getIdGrupo() {
        return id_grupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.id_grupo = idGrupo;
    }

    public String getCurso() {
        return cod_grupo;
    }

    public void setCurso(String curso) {
        this.cod_grupo = curso;
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
