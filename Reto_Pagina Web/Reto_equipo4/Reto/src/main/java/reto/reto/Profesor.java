/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

/**
 *
 * @author DAM103
 */
public class Profesor extends Departamento {
    private int id_profesor;
    private String correo;
    private String nombreProfesor;
    private String apellidos;
    private String DNI;
    private boolean profesorActivo;
    private String password;
    private Perfil tipo;

    public Profesor(int idProfesor,String correo, String nombreProfesor, String apellidos, String DNI, boolean profesorActivo, String password, Perfil tipo,int idDepartamento, String nombre, String codigo) {
        super(idDepartamento,nombre, codigo);
        this.id_profesor=idProfesor;
        this.correo = correo;
        this.nombreProfesor = nombreProfesor;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.profesorActivo = profesorActivo;
        this.password = password;
        this.tipo = tipo;
    }

    public int getIdProfesor() {
        return id_profesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.id_profesor = idProfesor;
    }
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public boolean isProfesorActivo() {
        return profesorActivo;
    }

    public void setProfesorActivo(boolean profesorActivo) {
        this.profesorActivo = profesorActivo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Perfil getTipo() {
        return tipo;
    }

    public void setTipo(Perfil tipo) {
        this.tipo = tipo;
    }

    

   
    
    
    
}
