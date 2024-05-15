#### 3. Java:  
##### 3.1  Diagrama de clases  

![image](https://github.com/LuisIzquierdoGutierrez/Reto/assets/119076009/de8cef99-a57d-47e2-9a73-7fef534c281e)



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
##### 3.4  Explicación del código 
Hemos creado un proyecto en NetBeans llamado ACEX2, en el hemos creado una serie de objetos basándonos en el diagrama de clases que hemos creado para la creación de la aplicación. En el hemos creado una serie de objetos(Tipo_transporte, ACEX_Aprobadas, Alojamiento, Curso_Participante, Cursos, Departamento, Grupo, Grupo_Participante, Profesor, Profesor_participante, Profesor_Responsable, Solicitudes_ACEX, Transporte) todos ellos con sus atributos y sus métodos get y set.
Ejemplo de una de las clases:

```
public class Profesor {
    private int id_profesor;
    private String DNI;
    private String nombreProfesor;
    private String apellidos;
    private String correo;
    private String password;
    private Tipo_Perfil tipo_perfil;
    private boolean profesorActivo;
    private Departamento idDepartamento;
    

    public Profesor(int id_profesor, String DNI, String nombreProfesor, String apellidos, String correo, String password, Tipo_Perfil tipo_perfil, boolean profesorActivo,int idDepartamento) {
        this.id_profesor = id_profesor;
        this.DNI = DNI;
        this.nombreProfesor = nombreProfesor;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
        this.tipo_perfil = tipo_perfil;
        this.profesorActivo = profesorActivo;
        this.idDepartamento = new DAO_Departamento().porId(idDepartamento);
    }
  
    public Departamento getIdDepartamento() {
        return idDepartamento;
    }
   
    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
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
    
    public Tipo_Perfil getTipo_perfil() {
        return tipo_perfil;
    }
   
    public void setTipo_perfil(Tipo_Perfil tipo_perfil) {
        this.tipo_perfil = tipo_perfil;
    }
   
    public boolean isProfesorActivo() {
        return profesorActivo;
    }
   
    public void setProfesorActivo(boolean profesorActivo) {
        this.profesorActivo = profesorActivo;
    }
   
    
    
}

```
A parte de esto hemos creado una interface llamada Patron_DAO con un método que consultar una lista de objetos, un método que nos devuelve un true si guardamos un objeto, un método que obtiene un objeto del repositorio por su identificador y otro método boolean que nos devuelve un true, si elimina un objeto del repositorio por su identificador.

Ejemplo:

```
public interface Patron_DAO<T> {
     
    public List<T> consultar();
  
    public boolean save(T t);
    
    public T porId( int id);
   
    public boolean eliminar( int id);
    
}
```

Una clase AccesoBaseDatos que como el mismo nombre dice nos conecta con la base de datos creada.

Ejemplo:

```
public class AccesoBaseDatos {
    private Connection conn = null;
    private static final String USER = "developer";
    private static final String PASSWORD = "";
    private static final String DATABASE_URL = "jdbc:mysql://10.0.16.35:3306/acex?useSSL=false&autoReconnect=true";
    

    public AccesoBaseDatos() {
        try {
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
    }
    
    public Connection getConn() {
        return conn;
    }
    
    public void closeConnection() {
        try {
            conn.close();
            System.out.println("Conexión cerrada.");
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (NullPointerException ex) {}
    }
        
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Código: " + ex.getErrorCode());
        System.out.println("[ERROR] Mensaje: " + ex.getMessage());
        System.out.println("[ERROR] Estado SQL: " + ex.getSQLState());
    }
    
    public static AccesoBaseDatos getInstance() {
        return InstanceHolder.INSTANCE;
    }
    
    private static class InstanceHolder {
        private static final AccesoBaseDatos INSTANCE = new AccesoBaseDatos();
    }
}
```

También se han realizado la creacion de una serie de clases… llamadas DAO_ACEXArpobadas, DAO_cursos, DAO_Cursos_Participantes….  las cuales implementan la interface Patron_DAO y en la que desarrollamos los métodos   de este patrón para el manejo de cada clase en la base de datos y aparte la creación de los objetos de cada clase.

Ejemplo de uno de los patrones:

```
public class DAO_Departamento implements Patron_DAO<Departamento> {
    
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
   
    @Override
    public List<Departamento> consultar() {
        List<Departamento> departamentos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,id_jefe,codigo,nombre FROM departamento");) {
            while (rs.next()) {
                Departamento departamento = crearDepartamento(rs);
                if (!departamentos.add(departamento)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }
        } catch (SQLException e) {
            // errores
            System.out.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return departamentos;
    }
    
    @Override
    public boolean save(Departamento departamento) {
        String sql = null;
        boolean resultado = true;
        if (departamento.getIdDepartamento() > 0) {
            sql = "UPDATE departamento SET id_jefe=?, codigo=?, nombre=? WHERE id=?";
        } else {
            String query = "INSERT INTO departamento (id_jefe, codigo, nombre) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
                if (departamento.getIdDepartamento() > 0) {
                    stmt.setInt(4, departamento.getIdDepartamento());
                }
                stmt.setInt(1, departamento.getJefe().getId_profesor());
                stmt.setString(2, departamento.getCodigo());
                stmt.setString(3, departamento.getNombre());

                int salida = stmt.executeUpdate();
                if (salida != 1) {
                    resultado = false;
                    throw new Exception(" No se ha insertado/modificado un solo registro");
                }
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return resultado;
    }
   
    @Override
    public Departamento porId(int id) {
        Departamento departamento = null;
        String sql = "SELECT id,id_jefe,codigo,nombre FROM departamento WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    departamento = crearDepartamento(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return departamento;
    }
    
    @Override
    public boolean eliminar(int id) {
        boolean resultado = true;
        String sql = "DELETE FROM departamento WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                resultado = false;
                throw new Exception(" No se ha borrado un solo registro");
            }
        } catch (SQLException e) {
            // errores
            System.out.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
    private Departamento crearDepartamento(ResultSet rs) throws SQLException {

        return new Departamento(rs.getInt("id"), rs.getInt("id_jefe"), rs.getString("codigo"), rs.getString("nombre"));

    }
}
```




