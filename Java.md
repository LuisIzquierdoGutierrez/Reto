#### 3. Java:  
##### 3.1  Diagrama de clases  

![image](https://github.com/LuisIzquierdoGutierrez/Reto/assets/119076009/4c39d256-2d25-4e1c-97f8-aafceca5d98b)


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





##### 3.3  Clases usadas en JavaDoc  
##### 3.4  Explicación del código 
