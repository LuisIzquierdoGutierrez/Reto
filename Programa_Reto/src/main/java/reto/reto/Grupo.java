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
    private String descripcion_grupo;

    public Grupo(int id_grupo, String cod_grupo, int numAlumnos, boolean activo, String descripcion_grupo, int id_curso, String codigo, TipoEtapa etapa, int num_alumnos, boolean cursoActivo, String descripcion) {
        super(id_curso, codigo, etapa, num_alumnos, cursoActivo, descripcion);
        this.id_grupo = id_grupo;
        this.cod_grupo = cod_grupo;
        this.numAlumnos = numAlumnos;
        this.activo = activo;
        this.descripcion_grupo = descripcion_grupo;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getCod_grupo() {
        return cod_grupo;
    }

    public void setCod_grupo(String cod_grupo) {
        this.cod_grupo = cod_grupo;
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

    public String getDescripcion_grupo() {
        return descripcion_grupo;
    }

    public void setDescripcion_grupo(String descripcion_grupo) {
        this.descripcion_grupo = descripcion_grupo;
    }

   
    

   
   

 

  

  

   
   
}
