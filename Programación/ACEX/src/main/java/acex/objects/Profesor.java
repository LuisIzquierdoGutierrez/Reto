package acex.objects;

import acex.enums.P_Perfil;


public class Profesor {
    private int idProfesor;
    private int idDepartamento;
    private String dniProfesor;
    private String nombreProfesor;
    private String apellidosProfesor;
    private String emailProfesor;
    private String passwordProfesor;
    private P_Perfil perfilProfesor;
    private boolean activoProfesor;
    
    public Profesor(int idProfesor, int idDepartamento, String dniProfesor, String nombreProfesor, String apellidosProfesor, String emailProfesor, String passwordProfesor, P_Perfil perfilProfesor, boolean activoProfesor) {
        this.idProfesor = idProfesor;
        this.idDepartamento = idDepartamento;
        this.dniProfesor = dniProfesor;
        this.nombreProfesor = nombreProfesor;
        this.apellidosProfesor = apellidosProfesor;
        this.emailProfesor = emailProfesor;
        this.passwordProfesor = passwordProfesor;
        this.perfilProfesor = perfilProfesor;
        this.activoProfesor = activoProfesor;
    }
    
    
    public int getId() {
        return idProfesor;
    }

    public void setId(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    
    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    
    public String getDni() {
        return dniProfesor;
    }

    public void setDni(String dniProfesor) {
        this.dniProfesor = dniProfesor;
    }

    
    public String getNombre() {
        return nombreProfesor;
    }

    public void setNombre(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    
    public String getApellidos() {
        return apellidosProfesor;
    }

    public void setApellidos(String apellidosProfesor) {
        this.apellidosProfesor = apellidosProfesor;
    }

    
    public String getEmail() {
        return emailProfesor;
    }

    public void setEmail(String emailProfesor) {
        this.emailProfesor = emailProfesor;
    }

    
    public String getPassword() {
        return passwordProfesor;
    }

    public void setPassword(String passwordProfesor) {
        this.passwordProfesor = passwordProfesor;
    }

    
    public P_Perfil getPerfil() {
        return perfilProfesor;
    }

    public void setPerfil(P_Perfil perfilProfesor) {
        this.perfilProfesor = perfilProfesor;
    }

    
    public boolean isActivo() {
        return activoProfesor;
    }

    public void setActivo(boolean activoProfesor) {
        this.activoProfesor = activoProfesor;
    }
}
