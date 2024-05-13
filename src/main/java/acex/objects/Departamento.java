/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acex.objects;

import acex.objects.Profesor;
import acex.database.DAO_Profesor;

/**
 * Esta clase representa un departamento en una organización.
 * 
 * @author Adrian, Luis
 * 
 * @see DepartamentoNuevo
 */
public class Departamento {
    private int idDepartamento;
    private Profesor jefe;
    private String codigo;
    private String nombre;
    
    /**
     * Crea una instancia de la clase Departamento.
     * 
     * @param idDepartamento El identificador del departamento.
     * @param id_jefe        El identificador del jefe del departamento.
     * @param codigo         El código del departamento.
     * @param nombre         El nombre del departamento.
     */

    public Departamento(int idDepartamento,int id_jefe, String codigo, String nombre) {
        this.idDepartamento = idDepartamento;

        this.jefe=new DAO_Profesor().porId(id_jefe);
        this.codigo = codigo;
        this.nombre = nombre;
    }
    /**
     * Obtiene el jefe del departamento.
     * 
     * @return El jefe del departamento.
     */

    public Profesor getJefe() {
        return jefe;
    }
     /**
     * Establece el jefe del departamento.
     * 
     * @param jefe El jefe del departamento.
     */
    

    public void setJefe(Profesor jefe) {
        this.jefe = jefe;
    }
    /**
     * Obtiene el identificador del departamento.
     * 
     * @return El identificador del departamento.
     */

    public int getIdDepartamento() {
        return idDepartamento;
    }
    /**
     * Establece el identificador del departamento.
     * 
     * @param idDepartamento El identificador del departamento.
     */

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    /**
     * Obtiene el código del departamento.
     * 
     * @return El código del departamento.
     */

    public String getCodigo() {
        return codigo;
    }
    /**
     * Establece el código del departamento.
     * 
     * @param codigo El código del departamento.
     */

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Obtiene el nombre del departamento.
     * 
     * @return El nombre del departamento.
     */

    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del departamento.
     * 
     * @param nombre El nombre del departamento.
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  
    
}
