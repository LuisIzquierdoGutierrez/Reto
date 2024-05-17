package app.objects;

import app.database.DAO_Profesor;


public class Obj_Departamento {
    private int id;
    private Obj_Profesor jefe;
    private String codigo;
    private String nombre;

    public Obj_Departamento(int id, int idJefe, String codigo, String nombre) {
        this.id = id;
        this.jefe = new DAO_Profesor().getById(idJefe);
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Obj_Profesor getJefe() {
        return jefe;
    }

    public void setJefe(Obj_Profesor jefe) {
        this.jefe = jefe;
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
