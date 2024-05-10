/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acex.objects;

import acex.enums.Tipo_Perfil;

/**
 * Esta clase representa a un profesor.
 * 
 * @see ProfesorNuevo
 * 
 * @author Adrian,Luis
 */
public class Profesor {
    private int id_profesor;
    private String DNI;
    private String nombreProfesor;
    private String apellidos;
    private String correo;
    private String password;
    private Tipo_Perfil tipo_perfil;
    private boolean profesorActivo;
    private int id_departamento;
    
     /**
     * Crea una instancia de la clase Profesor.
     * 
     * @param id_profesor El ID del profesor.
     * @param id_departamento El ID del departamento al que pertenece el profesor.
     * @param DNI El DNI del profesor.
     * @param nombreProfesor El nombre del profesor.
     * @param apellidos Los apellidos del profesor.
     * @param correo El correo electrónico del profesor.
     * @param password La contraseña del profesor.
     * @param tipo El perfil del profesor.
     * @param profesorActivo Indica si el profesor está activo o no.
     */

    public Profesor(int id_profesor, int id_departamento, String DNI, String nombreProfesor, String apellidos, String correo, String password, Tipo_Perfil tipo, boolean profesorActivo) {
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
    /**
     * Obtiene el ID del departamento al que pertenece el profesor.
     * 
     * @return El ID del departamento.
     */

    public int getId_departamento() {
        return id_departamento;
    }
    /**
     * Establece el ID del departamento al que pertenece el profesor.
     * 
     * @param id_departamento El ID del departamento.
     */

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }
    /**
     * Obtiene el ID del profesor.
     * 
     * @return El ID del profesor.
     */

    public int getId_profesor() {
        return id_profesor;
    }
     /**
     * Establece el ID del profesor.
     * 
     * @param id_profesor El ID del profesor.
     */

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }
      /**
     * Obtiene el DNI del profesor.
     * 
     * @return El DNI del profesor.
     */

    public String getDNI() {
        return DNI;
    } 
    /**
     * Establece el DNI del profesor.
     * 
     * @param DNI El DNI del profesor.
     */

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
     /**
     * Obtiene el nombre del profesor.
     * 
     * @return El nombre del profesor.
     */

    public String getNombreProfesor() {
        return nombreProfesor;
    }
     /**
     * Establece el nombre del profesor.
     * 
     * @param nombreProfesor El nombre del profesor.
     */

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }
     /**
     * Obtiene los apellidos del profesor.
     * 
     * @return Los apellidos del profesor.
     */

    public String getApellidos() {
        return apellidos;
    }
    /**
     * Establece los apellidos del profesor.
     * 
     * @param apellidos Los apellidos del profesor.
     */

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    /**
     * Obtiene el correo electrónico del profesor.
     * 
     * @return El correo electrónico del profesor.
     */

    public String getCorreo() {
        return correo;
    }
    /**
     * Establece el correo electrónico del profesor.
     * 
     * @param correo El correo electrónico del profesor.
     */

    public void setCorreo(String correo) {
        this.correo = correo;
    }
     /**
     * Obtiene la contraseña del profesor.
     * 
     * @return La contraseña del profesor.
     */

    public String getPassword() {
        return password;
    }
    /**
     * Establece la contraseña del profesor.
     * 
     * @param password La contraseña del profesor.
     */

    public void setPassword(String password) {
        this.password = password;
    }
     /**
     * Obtiene el perfil del profesor.
     * 
     * @return El perfil del profesor.
     */

    public Tipo_Perfil getTipo_perfil() {
        return tipo_perfil;
    }
     /**
     * Establece el perfil del profesor.
     * 
     * @param tipo_perfil El perfil del profesor.
     */

    public void setTipo_perfil(Tipo_Perfil tipo_perfil) {
        this.tipo_perfil = tipo_perfil;
    }
    /**
     * Verifica si el profesor está activo.
     * 
     * @return true si el profesor está activo, false de lo contrario.
     */

    public boolean isProfesorActivo() {
        return profesorActivo;
    }
     /**
     * Establece si el profesor está activo o no.
     * 
     * @param profesorActivo true si el profesor está activo, false de lo contrario.
     */

    public void setProfesorActivo(boolean profesorActivo) {
        this.profesorActivo = profesorActivo;
    }
     /**
     * Devuelve una representación en forma de cadena de la clase Profesor.
     * 
     * @return Una cadena que representa la clase Profesor.
     */

    @Override
    public String toString() {
        return "test";
    }
    

   
    

   
    
    
    
}
