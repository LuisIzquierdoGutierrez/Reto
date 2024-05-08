/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

/**
 *
 * @author DAM103
 */
public class Profesor {
    private int id_profesor;
    private String DNI;
    private String nombreProfesor;
    private String apellidos;
    private String correo;
    private String password;
    private Perfil tipo_perfil;
    private boolean profesorActivo;
    private int id_departamento;

    public Profesor(int id_profesor, int id_departamento, String DNI, String nombreProfesor, String apellidos, String correo, String password, Perfil tipo, boolean profesorActivo) {
        this.id_profesor = id_profesor;
        this.DNI = DNI;
        this.nombreProfesor = nombreProfesor;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
        this.tipo_perfil = tipo;
        this.profesorActivo = profesorActivo;
        this.id_departamento = id_departamento;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Perfil getTipo_perfil() {
        return tipo_perfil;
    }

    public void setTipo_perfil(Perfil tipo_perfil) {
        this.tipo_perfil = tipo_perfil;
    }



    public boolean isProfesorActivo() {
        return profesorActivo;
    }

    public void setProfesorActivo(boolean profesorActivo) {
        this.profesorActivo = profesorActivo;
    }
    

   
    

   
    
    
    
}
