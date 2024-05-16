#### 3. Java:  
##### 3.1  Diagrama de clases  

![image](https://github.com/LuisIzquierdoGutierrez/Reto/assets/119076009/78e85832-6a55-440e-ab03-a9e8ef57738f)




En la representacion de este diagrama de clases representamos las clases de una aplicacion java de Actividades extraescolares y las relaciones entre ellas mismas.

Cada una de las siguientes clases(Departamento, Tipo_transporte, Transporte, Alojamiento, Profesor, ACEX_Aprobadas, Curso, Solicitudes_ACEX,Grupo) tiene representados sus atributos , deberian estar puestos los metodos, pero se añadio un comentario en el que explicamos que todas estas clases tienen los getters y setters de todos sus atributos, pero que no se han puesto para que entrara en el pdf, tambien estan represetadas las clases de enumerados y la  relacion y cardinalidad entre clases. 

##### 3.2  Diagrama de casos de uso

![image](https://github.com/LuisIzquierdoGutierrez/Reto/assets/119076009/1127cb1c-bd88-4ffa-b76d-d4529e185f1f)

## Diagrama de Casos de Uso
Se desea crear un programa que simule la gestión de actividades extraescolares de un centro e información de estas.
Diagrama de Casos de Uso
Hay 4 actores en el diagrama UML, Profesor, Equipo directivo, Administrador y SuperUsuario.
Las operaciones que debería realizar la aplicación son las que se indican a continuación:

##Profesor:
Visualizar actividad.
Realizar solicitud de la actividad.
Modificar solicitud que este solicitando.

##Equipo directivo:
Visualizar actividad.
Realizar solicitud de la actividad.
Modificar solicitud que este solicitando.
Aprobar y denegar solicitudes. 

##Administrador:
Visualizar actividad.
Realizar solicitud de la actividad.
Modificar solicitud que este solicitando.
Aprobar y denegar solicitudes. 
Modificar todo tipo de solicitudes.

##SuperUsuario:
Visualizar actividad.
Realizar solicitud de la actividad.
Modificar solicitud que este solicitando.
Aprobar y denegar solicitudes. 
Modificar todo tipo de solicitudes.
Mantenimientos básicos (editar datos, cargar CSV, inhabilitar profesor)

##Restricciones:
No puede haber 2 id de Profesor iguales.
No puede haber 2 Profesores con el mismo DNI.
No puede haber 2 id de Actividad_solicitada iguales.
No puede haber 2 id de Actividad_aprobada iguales.

##Visualizar actividad:
Actores involucrados: Profesor, Equipo directivo, Administrador y SuperUsuario.
Precondición: la actividad debe estar creada y debe haber uno de los actores creados para poder consultar la actividad.
- Flujo básico:
1.	Cualquiera de los actores intenta acceder a través del login que pide email y contraseña para poder consultar la actividad.
2.	El sistema comprueba que email y contraseña son correctos.
3.	Se muestra la actividad.
- Caminos alternativos:
Si los datos de email y contraseña no son correctos, muestra mensaje de error y vuelve a solicitar contraseña.

##Realizar solicitud actividad:
Actores involucrados: Profesor, Equipo directivo, Administrador y SuperUsuario.
Precondición: debe haber uno de los actores creados para poder realizar la solicitud de la actividad.
- Flujo básico:
1.	Cualquiera de los actores intenta acceder a través del login que pide email y contraseña para poder consultar la actividad.
2.	El sistema comprueba que email y contraseña son correctos.
3.	Introduce datos para solicitar actividad.
- Caminos alternativos:
Si los datos de email y contraseña no son correctos, muestra mensaje de error y vuelve a solicitar contraseña. Si hay datos incompletos en la actividad solicitada que no admite nulos, no se guarda la solicitud.

##Modificar solicitud que estés solicitando:
Actores involucrados: Profesor, Equipo directivo, Administrador y SuperUsuario.
Precondición: debe haber uno de los actores creados para poder realizar la solicitud de la actividad y debe haber una solicitud creada por ese profesor para poder modificarla. 
- Flujo básico:
1.	Cualquiera de los actores intenta acceder a través del login que pide email y contraseña para poder consultar la actividad.
2.	El sistema comprueba que email y contraseña son correctos.
3.	Introduce datos para modificar actividad.
- Caminos alternativos:
Si los datos de email y contraseña no son correctos, muestra mensaje de error y vuelve a solicitar contraseña.Si hay datos incompletos en la actividad solicitada que no admite nulos, no se guarda la solicitud.

##Aprobar y denegar solicitudes:
Actores involucrados: Equipo directivo, Administrador y SuperUsuario.
Precondición: debe haber uno de los actores involucrados para poder aprobar o denegar alguna de las solicitudes de actividades, que a su vez tienen que estar creadas
- Flujo básico:
1.	Cualquiera de los actores intenta acceder a través del login que pide email y contraseña para poder consultar la actividad.
2.	El sistema comprueba que email y contraseña son correctos.
3.	Visualiza actividades solicitadas.
4.	Comprueba que tipo de perfil de profesor tienes.
5.	Aprueba o deniega alguno de esas solicitudes
- Caminos alternativos:
Si los datos de email y contraseña no son correctos, muestra mensaje de error y vuelve a solicitar contraseña. Si el perfil del profesor no es Equipo directivo, Administrador o SuperUsuario no dejara realizar la operación.

##Modificar todo tipo de solicitudes:
Actores involucrados: Administrador y SuperUsuario.
Precondición: debe haber uno de los actores involucrados para poder modificar alguna de las actividades solicitadas y aprobadas y denagadas, que a su vez tienen que estar creadas
- Flujo básico:
1.	Cualquiera de los actores intenta acceder a través del login que pide email y contraseña para poder consultar la actividad.
2.	El sistema comprueba que email y contraseña son correctos.
3.	Visualiza actividades solicitadas.
4.	Comprueba que tipo de perfil de profesor tienes.
5.	Modifica cualquier tipo de actividad.
- Caminos alternativos:
Si los datos de email y contraseña no son correctos, muestra mensaje de error y vuelve a solicitar contraseña. Si el perfil del profesor no es Administrador o SuperUsuario no dejara realizar la operación.

##Mantenimiento básico:
Actores involucrados: SuperUsuario.
Precondición: el perfil de profesor solo puede ser el de SuperUsuario, para realizar cualquier tarea de mantenimientos básicos. Para editar datos e inhabilitar profesores y cargar csv todos tienen que estar creados antes.
- Flujo básico:
1.	Cualquiera de los actores intenta acceder a través del login que pide email y contraseña para poder consultar la actividad.
2.	El sistema comprueba que email y contraseña son correctos.
3.	Comprueba que tipo de perfil de profesor tienes.
4.	Visualiza todos los datos.
5.	Modifica cualquier tipo de actividad, inhabilitar o cargar csv.
- Caminos alternativos:
Si los datos de email y contraseña no son correctos, muestra mensaje de error y vuelve a solicitar contraseña. Si el perfil del profesor no es SuperUsuario no dejara realizar la operación.





##### 3.3  JavaDoc  

[Enlace a Javadoc](file:///C:/Users/adry1/Desktop/Application/target/site/apidocs/index.html)

##### 3.4  Explicación del código 
Hemos creado un proyecto en NetBeans llamado ACEX2, en el hemos creado una serie de objetos basándonos en el diagrama de clases que hemos creado para la creación de la aplicación. En el hemos creado una serie de objetos(Obj_Transporte_Utilizado, Obj_Actividas_Aprobada, Obj_Alojamiento, Obj_Alojamiento_Utilizado, Obj_Curso_Participante, Obj_Curso, Obj_Departamento, Obj_Grupo, Obj_Grupo_Participante, Obj_Profesor, Obj_Profesor_Participante, Obj_Profesor_Responsable, Obj_Actividad_Solicitada, Obj_Transporte) todos ellos con sus atributos y sus métodos get y set.
Ejemplo de una de las clases:

```
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
     * @param id               el ID del profesor
     * @param idDepartamento   el ID del departamento al que pertenece el profesor
     * @param dni              el DNI del profesor
     * @param nombre           el nombre del profesor
     * @param apellidos        los apellidos del profesor
     * @param email            el email del profesor
     * @param password         la contraseña del profesor
     * @param perfil           el perfil del profesor
     * @param activo           indica si el profesor está activo o no
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


```
A parte de esto hemos creado una interface llamada DAO_Interface con un método que consultar una lista de objetos, un método que nos devuelve un true si guardamos un objeto, un método que obtiene un objeto del repositorio por su identificador y otro método boolean que nos devuelve un true, si elimina un objeto del repositorio por su identificador.

Ejemplo:

```
public interface DAO_Interface<T> {
    /**
     * Obtiene todos los objetos de la base de datos.
     * 
     * @return una lista de objetos de tipo T
     */
    public List<T> getAll();

    /**
     * Obtiene un objeto de la base de datos por su identificador.
     * 
     * @param id el identificador del objeto a obtener
     * @return el objeto de tipo T con el identificador especificado
     */
    public T getById(int id);

    /**
     * Actualiza un objeto en la base de datos.
     * 
     * @param object el objeto a actualizar
     * @return true si la actualización fue exitosa, false de lo contrario
     */
    public boolean update(T object);

    /**
     * Elimina un objeto de la base de datos por su identificador.
     * 
     * @param id el identificador del objeto a eliminar
     * @return true si la eliminación fue exitosa, false de lo contrario
     */
    public boolean delete(int id);
}
```

Una clase Access que como el mismo nombre dice nos conecta con la base de datos creada.

Ejemplo:

```
public class Access {
    private Connection conn = null;
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/acex?useSSL=false&autoReconnect=true";
     /**
     * Constructor privado para evitar la creación de instancias directamente.
     * Se establece la conexión a la base de datos.
     */
    
    private Access() {
        try {
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
    }
     /**
     * Obtiene la conexión a la base de datos.
     * 
     * @return la conexión a la base de datos
     */
    
    public Connection getConnection() {
        return conn;
    }
     /**
     * Cierra la conexión a la base de datos.
     */
    
    public void closeConnection() {
        try {
            conn.close();
            System.out.println("Connection closed.");
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (NullPointerException ex) {}
    }
     /**
     * Obtiene la instancia única de la clase Access.
     * 
     * @return la instancia única de Access
     */
    
    public static Access getInstance() {
        return InstanceHolder.INSTANCE;
    }
    
    /**
     * Clase interna que contiene la instancia única de Access.
     */
    
    
    private static class InstanceHolder {
        private static final Access INSTANCE = new Access();
    }
    
    /**
     * Maneja las excepciones de SQL y muestra información detallada del error.
     * 
     * @param ex la excepción de SQL
     */
    
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Code: " + ex.getErrorCode());
        System.out.println("[ERROR] Message: " + ex.getMessage());
        System.out.println("[ERROR] SQL State: " + ex.getSQLState());
    }
}
```

También se han realizado la creacion de una serie de clases… llamadas DAO_Actividad_Aprobadas, DAO_Actividad_Solicitada,DAO_Alojamineto....  las cuales implementan la interface Patron_DAO y en la que desarrollamos los métodos   de este patrón para el manejo de cada clase en la base de datos y aparte la creación de los objetos de cada clase.

Ejemplo de uno de los patrones:

```
public class DAO_Departamento implements DAO_Interface<Obj_Departamento> {
    
    /**
     * Obtiene todos los departamentos de la base de datos.
     * 
     * @return una lista de objetos Obj_Departamento que representan los departamentos en la base de datos.
     * @throws SQLException si ocurre un error al ejecutar la consulta SQL.
     */

    @Override
    public List<Obj_Departamento> getAll() {
        String sql = "SELECT id, id_jefe, codigo, nombre FROM departamento";
        List<Obj_Departamento> departamentos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Departamento departamento = newDepartamento(rset);
                
                if (!departamentos.add(departamento)) {
                    throw new Exception("[ERROR] No se ha podido obtener el objecto.");
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return departamentos;
    }
    
     /**
     * Obtiene un departamento de la base de datos por su ID.
     * 
     * @param id el ID del departamento a buscar.
     * @return un objeto Obj_Departamento que representa el departamento en la base de datos, o null si no se encuentra.
     * @throws SQLException si ocurre un error al ejecutar la consulta SQL.
     */

    
    @Override
    public Obj_Departamento getById(int id) {
        String sql = "SELECT id, id_jefe, codigo, nombre FROM departamento WHERE id=?";
        Obj_Departamento departamento = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    departamento = newDepartamento(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return departamento;
    }
    
     /**
     * Actualiza un departamento en la base de datos.
     * 
     * @param departamento el departamento a actualizar.
     * @return true si se actualiza correctamente, false de lo contrario.
     * @throws SQLException si ocurre un error al ejecutar la consulta SQL.
     */

    
    @Override
    public boolean update(Obj_Departamento departamento) {
        String sql = null;
        boolean result = false;
        
        if (departamento.getId() > 0) {
            sql = "UPDATE departamento SET id_jefe=?, codigo=?, nombre=? WHERE id=?";
        } else {
           sql = "INSERT INTO departamento (id_jefe, codigo, nombre) VALUES (?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (departamento.getId() > 0) {
                stmt.setInt(4, departamento.getId());
            }
            stmt.setInt(1, departamento.getJefe().getId());
            stmt.setString(2, departamento.getCodigo());
            stmt.setString(3, departamento.getNombre());
            
            if (stmt.executeUpdate() != 1) {
                throw new Exception("[ERROR] No se ha podido actualizar el objecto.");
            } else {
                result = true;
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return result;
    }
    
    /**
     * Elimina un departamento de la base de datos por su ID.
     * 
     * @param id el ID del departamento a eliminar.
     * @return true si se elimina correctamente, false de lo contrario.
     * @throws SQLException si ocurre un error al ejecutar la consulta SQL.
     */
    
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM departamento WHERE id=?";
        boolean result = false;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            if (stmt.executeUpdate() != 1) {
                throw new Exception("[ERROR] No se ha podido eliminar el objecto.");
            } else {
                result = true;
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return result;
    }
    
     /**
     * Crea un nuevo objeto Obj_Departamento a partir de un ResultSet.
     * 
     * @param rset el ResultSet que contiene los datos del departamento.
     * @return un objeto Obj_Departamento creado a partir de los datos del ResultSet.
     * @throws SQLException si ocurre un error al acceder a los datos del ResultSet.
     */
    

    private Obj_Departamento newDepartamento(final ResultSet rset) throws SQLException {
        return new Obj_Departamento(rset.getInt("id"), rset.getInt("id_jefe"), rset.getString("codigo"), rset.getString("nombre"));
    }
    
     /**
     * Obtiene la conexión a la base de datos.
     * 
     * @return la conexión a la base de datos.
     */
    
    
    private Connection getConnection() {
        return Access.getInstance().getConnection();
    }
    
     /**
     * Maneja una excepción de tipo SQLException.
     * 
     * @param ex la excepción SQLException a manejar.
     */
    
    
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Code: " + ex.getErrorCode());
        System.out.println("[ERROR] Message: " + ex.getMessage());
        System.out.println("[ERROR] SQL State: " + ex.getSQLState());
    }
}
```




