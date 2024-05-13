package acex.objects;

import acex.enums.P_Perfil;


public class Profesor {
    private int id;
    private int id_departamento;
    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    private P_Perfil perfil;
    private boolean activo;
    
    public Profesor(int id, int id_departamento, String dni, String nombre, String apellidos, String email, String password, P_Perfil perfil, boolean activo) {
        this.id = id;
        this.id_departamento = id_departamento;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.perfil = perfil;
        this.activo = activo;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public int getIdDepartamento() {
        return id_departamento;
    }

    public void setIdDepartamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public P_Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(P_Perfil perfil) {
        this.perfil = perfil;
    }

    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
