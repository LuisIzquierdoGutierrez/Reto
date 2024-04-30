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
    private boolean cursoActivo;
    private String codigo;
    private String descripcion;
    private int num_alumnos;
    private TipoEtapa etapa; 

    public Cursos(int idCurso,boolean cursoActivo, String codigo, String descripcion, int num_alumnos, TipoEtapa etapa) {
        this.id_curso=idCurso;
        this.cursoActivo = cursoActivo;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.num_alumnos = num_alumnos;
        this.etapa = etapa;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    
    

    public boolean isCursoActivo() {
        return cursoActivo;
    }

    public void setCursoActivo(boolean cursoActivo) {
        this.cursoActivo = cursoActivo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNum_alumnos() {
        return num_alumnos;
    }

    public void setNum_alumnos(int num_alumnos) {
        this.num_alumnos = num_alumnos;
    }

    public TipoEtapa getEtapa() {
        return etapa;
    }

    public void setEtapa(TipoEtapa etapa) {
        this.etapa = etapa;
    }

   

    
    
}
