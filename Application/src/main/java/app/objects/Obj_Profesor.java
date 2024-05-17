package app.objects;

import app.database.DAO_Departamento;
import app.enums.Enum_Perfil;


public class Obj_Profesor {
    private int id;
    private Obj_Departamento departamento;
    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    private Enum_Perfil perfil;
    private boolean activo;

    public Obj_Profesor(int id, int idDepartamento, String dni, String nombre, String apellidos, String email, String password, Enum_Perfil perfil, boolean activo) {
        this.id = id;
        this.departamento = new DAO_Departamento().getById(idDepartamento);
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

    public Obj_Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Obj_Departamento departamento) {
        this.departamento = departamento;
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

    public Enum_Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Enum_Perfil perfil) {
        this.perfil = perfil;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
