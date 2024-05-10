/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

/**
 * Clase que representa un curso.
 * @author Adrian
 * @see Curso
 */
public class Cursos {
    private int id_curso;
    private String codigo;
    private TipoEtapa etapa;
    private int num_alumnos;
    private boolean cursoActivo;
    private String descripcion;
    
     /**
     * Constructor de la clase Cursos.
     * 
     * @param id_curso El identificador del curso.
     * @param codigo El código del curso.
     * @param etapa La etapa del curso.
     * @param num_alumnos El número de alumnos inscritos en el curso.
     * @param cursoActivo Indica si el curso está activo o no.
     * @param descripcion La descripción del curso.
     */

    public Cursos(int id_curso, String codigo, TipoEtapa etapa, int num_alumnos, boolean cursoActivo, String descripcion) {
        this.id_curso = id_curso;
        this.codigo = codigo;
        this.etapa = etapa;
        this.num_alumnos = num_alumnos;
        this.cursoActivo = cursoActivo;
        this.descripcion = descripcion;
    }
     /**
     * Obtiene el identificador del curso.
     * 
     * @return El identificador del curso.
     */

    public int getId_curso() {
        return id_curso;
    }
      /**
     * Establece el identificador del curso.
     * 
     * @param id_curso El identificador del curso.
     */

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }
    /**
     * Obtiene el código del curso.
     * 
     * @return El código del curso.
     */

    public String getCodigo() {
        return codigo;
    }
    /**
     * Establece el código del curso.
     * 
     * @param codigo El código del curso.
     */

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Obtiene la etapa del curso.
     * 
     * @return La etapa del curso.
     */

    public TipoEtapa getEtapa() {
        return etapa;
    }
    /**
     * Establece la etapa del curso.
     * 
     * @param etapa La etapa del curso.
     */

    public void setEtapa(TipoEtapa etapa) {
        this.etapa = etapa;
    }
     /**
     * Obtiene el número de alumnos inscritos en el curso.
     * 
     * @return El número de alumnos inscritos en el curso.
     */

    public int getNum_alumnos() {
        return num_alumnos;
    }
     /**
     * Establece el número de alumnos inscritos en el curso.
     * 
     * @param num_alumnos El número de alumnos inscritos en el curso.
     */

    public void setNum_alumnos(int num_alumnos) {
        this.num_alumnos = num_alumnos;
    }
     /**
     * Verifica si el curso está activo.
     * 
     * @return true si el curso está activo, false de lo contrario.
     */

    public boolean isCursoActivo() {
        return cursoActivo;
    }
    /**
     * Establece si el curso está activo o no.
     * 
     * @param cursoActivo Indica si el curso está activo o no.
     */

    public void setCursoActivo(boolean cursoActivo) {
        this.cursoActivo = cursoActivo;
    }
     /**
     * Obtiene la descripción del curso.
     * 
     * @return La descripción del curso.
     */

    public String getDescripcion() {
        return descripcion;
    }
     /**
     * Establece la descripción del curso.
     * 
     * @param descripcion La descripción del curso.
     */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

   
    

   
    
}
