/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acex.objects;

import acex.database.DAO_Cursos;

/**
 * Esta clase representa un grupo de alumnos en un curso.
 * @author Adrian , Luis
 * @see GrupoAlumnos
 */
public class Grupo {
    private int id_grupo;
    private String cod_grupo;
    private boolean activo;
    private String descripcion_grupo;
    private Cursos curso;
    
    /**
     * Constructor de la clase Grupo.
     * 
     * @param id_grupo El identificador del grupo.
     * @param cod_grupo El código del grupo.
     * @param numAlumnos El número de alumnos en el grupo.
     * @param activo Indica si el grupo está activo o no.
     * @param descripcion_grupo La descripción del grupo.
     * @param id_curso El identificador del curso al que pertenece el grupo.
     * 
     * @throws IllegalArgumentException Si el identificador del curso es inválido.
     * 
     * @see DAO_Cursos#porId(int)
     */

    public Grupo(int id_grupo, String cod_grupo, boolean activo, String descripcion_grupo, int id_curso) {
        this.id_grupo = id_grupo;
        this.cod_grupo = cod_grupo;
        this.activo = activo;
        this.descripcion_grupo = descripcion_grupo;
        this.curso = new DAO_Cursos().porId(id_curso);
    }
     /**
     * Obtiene el identificador del grupo.
     * 
     * @return El identificador del grupo.
     */

    public int getId_grupo() {
        return id_grupo;
    }
    /**
     * Establece el identificador del grupo.
     * 
     * @param id_grupo El identificador del grupo.
     */

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }
    /**
     * Obtiene el código del grupo.
     * 
     * @return El código del grupo.
     */

    public String getCod_grupo() {
        return cod_grupo;
    }
     /**
     * Establece el código del grupo.
     * 
     * @param cod_grupo El código del grupo.
     */

    public void setCod_grupo(String cod_grupo) {
        this.cod_grupo = cod_grupo;
    }


    /**
     * Verifica si el grupo está activo.
     * 
     * @return true si el grupo está activo, false de lo contrario.
     */

    public boolean isActivo() {
        return activo;
    }
    /**
     * Establece si el grupo está activo o no.
     * 
     * @param activo Indica si el grupo está activo o no.
     */

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    /**
     * Obtiene la descripción del grupo.
     * 
     * @return La descripción del grupo.
     */

    public String getDescripcion_grupo() {
        return descripcion_grupo;
    }
    /**
     * Establece la descripción del grupo.
     * 
     * @param descripcion_grupo La descripción del grupo.
     */

    public void setDescripcion_grupo(String descripcion_grupo) {
        this.descripcion_grupo = descripcion_grupo;
    }
    /**
     * Obtiene el curso al que pertenece el grupo.
     * 
     * @return El curso al que pertenece el grupo.
     */

    public Cursos getCurso() {
        return curso;
    }
    /**
     * Establece el curso al que pertenece el grupo.
     * 
     * @param curso El curso al que pertenece el grupo.
     */

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }




}
