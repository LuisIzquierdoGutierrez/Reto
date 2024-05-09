/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

/**
 *
 * @author DAM103
 */
public class Departamento {
    private int idDepartamento;
    private Profesor jefe;
    private String codigo;
    private String nombre;

    public Departamento(int idDepartamento,int id_jefe, String codigo, String nombre) {
        this.idDepartamento = idDepartamento;

        this.jefe=new ProfesorDAO().porId(id_jefe);
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Profesor getJefe() {
        return jefe;
    }

    public void setJefe(Profesor jefe) {
        this.jefe = jefe;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  
    
}
