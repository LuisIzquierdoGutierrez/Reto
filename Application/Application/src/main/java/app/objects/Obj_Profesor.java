package app.objects;
/* @author  Adrian, luis*/
import app.database.DAO_Departamento;
import app.enums.Enum_Perfil;

/**
 * Esta clase representa un objeto Profesor en la aplicación.
 */
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

    /**
     * Constructor de la clase Obj_Profesor.
     * 
     * @param id              el ID del profesor
     * @param idDepartamento  el ID del departamento al que pertenece el profesor
     * @param dni             el DNI del profesor
     * @param nombre          el nombre del profesor
     * @param apellidos       los apellidos del profesor
     * @param email           el email del profesor
     * @param password        la contraseña del profesor
     * @param perfil          el perfil del profesor
     * @param activo          indica si el profesor está activo o no
     */
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

    /**
     * Obtiene el ID del profesor.
     * 
     * @return el ID del profesor
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del profesor.
     * 
     * @param id el ID del profesor
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el departamento al que pertenece el profesor.
     * 
     * @return el departamento del profesor
     */
    public Obj_Departamento getDepartamento() {
        return departamento;
    }

    /**
     * Establece el departamento al que pertenece el profesor.
     * 
     * @param departamento el departamento del profesor
     */
    public void setDepartamento(Obj_Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtiene el DNI del profesor.
     * 
     * @return el DNI del profesor
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del profesor.
     * 
     * @param dni el DNI del profesor
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el nombre del profesor.
     * 
     * @return el nombre del profesor
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del profesor.
     * 
     * @param nombre el nombre del profesor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del profesor.
     * 
     * @return los apellidos del profesor
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del profesor.
     * 
     * @param apellidos los apellidos del profesor
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el email del profesor.
     * 
     * @return el email del profesor
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del profesor.
     * 
     * @param email el email del profesor
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña del profesor.
     * 
     * @return la contraseña del profesor
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del profesor.
     * 
     * @param password la contraseña del profesor
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene el perfil del profesor.
     * 
     * @return el perfil del profesor
     */
    public Enum_Perfil getPerfil() {
        return perfil;
    }

    /**
     * Establece el perfil del profesor.
     * 
     * @param perfil el perfil del profesor
     */
    public void setPerfil(Enum_Perfil perfil) {
        this.perfil = perfil;
    }

    /**
     * Verifica si el profesor está activo.
     * 
     * @return true si el profesor está activo, false de lo contrario
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Establece si el profesor está activo o no.
     * 
     * @param activo true si el profesor está activo, false de lo contrario
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
