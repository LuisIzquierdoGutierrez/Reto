/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

/**
 *
 * @author DAM103
 */
public class Cursos {
    private int id_curso;
    private String codigo;
    private TipoEtapa etapa;
    private int num_alumnos;
    private boolean cursoActivo;
    private String descripcion;

    public Cursos(int id_curso, String codigo, TipoEtapa etapa, int num_alumnos, boolean cursoActivo, String descripcion) {
        this.id_curso = id_curso;
        this.codigo = codigo;
        this.etapa = etapa;
        this.num_alumnos = num_alumnos;
        this.cursoActivo = cursoActivo;
        this.descripcion = descripcion;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TipoEtapa getEtapa() {
        return etapa;
    }

    public void setEtapa(TipoEtapa etapa) {
        this.etapa = etapa;
    }

    public int getNum_alumnos() {
        return num_alumnos;
    }

    public void setNum_alumnos(int num_alumnos) {
        this.num_alumnos = num_alumnos;
    }

    public boolean isCursoActivo() {
        return cursoActivo;
    }

    public void setCursoActivo(boolean cursoActivo) {
        this.cursoActivo = cursoActivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

   
    

   
    
}
