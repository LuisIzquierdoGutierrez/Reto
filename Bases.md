
#### 1. Base de Datos:
##### 1.1  Descripción 
El diseño de la base de datos para la gestión de actividades complementarias y extraescolares en el IES Miguel Herrero
es fundamental para asegurar una administración eficiente y organizada.

Se establece un esquema que abarca tanto la información sobre los profesores del centro como los detalles de las actividades
solicitadas y aprobadas. La estructura contempla aspectos como la identificación única de cada profesor a través de su correo
institucional, así como su asociación con un departamento específico y un perfil de acceso determinado.

Además, se registra con detalle cada solicitud de actividad, incluyendo información relevante como el título, tipo, fechas, horarios,
grupos participantes y comentarios adicionales. El estado de cada solicitud, junto con posibles comentarios de aprobación o denegación,
se mantiene actualizado para un seguimiento transparente del proceso.

La inclusión de la posibilidad de añadir comentarios sobre la realización de las actividades y la gestión de fotografías permite una
documentación exhaustiva de cada evento, contribuyendo así a una evaluación y mejora continua de las actividades ofrecidas por el centro.

##### 1.2  Imagen E/R  
![Diagrama Entidad-Relacion](https://github.com/LuisIzquierdoGutierrez/Reto/assets/152623929/56b60a16-4003-44d3-8243-540ea2550623)

En este diagrama se representan las relaciones de todas aquellas entidades que son necesarias para el funcionamiento y organización de la aplicación de ACEX.
##### 1.3  Diagrama Relacional 

![image](https://github.com/LuisIzquierdoGutierrez/Reto/assets/119076009/bbc98e12-0c39-4571-ac7d-4c4dfc4dddc0)

actividad_solicitada: guarda todos los datos de una solicitud.
actividad_aprobada: es una copia de actividad_solicitada que se genera una vez a sido aprobada.
imagen: guarda urls de imagenes vinculandolas a una solicitud aprobada.
departamento: Guarda los departamentos del centro.
profesores: Guarda los datos de los profesores del centro.
profesor_responsable: Guarda relaciones entre profesores y actividades en las que son responsables



transporte: guarda los tipos de transporte que se pueden utilizar.
transporte_utilizado: guarda los transporte que se han utilizado y su importe, relacionandolos a la actividad en la que se han utilizado o se van a utilizar.
alojamiento: guarda los tipos de alojamiento que se pueden utilizar.
alojamiento_utilizado: guarda los alojamientos que se han utilizado y su importe, relacionandolos a la actividad en la que se han utilizado o se van a utilizar.



##### 1.4  Importación SQL 
