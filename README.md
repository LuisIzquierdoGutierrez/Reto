# ***Reto: DamEquipo4***  


[](https://tasks.office.com/educantabria.es/es-es/home/planner/#/plantaskboard?groupid=3fbb2604-a253-49a6-9c33-c0a1afe976e4&planid=0ww7mkzmjkot0iieuxxuqpyah7gg)
![Icono GitHub](https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png)
#### Integrantes:
-Adrián de Diego Fernández      
-Luis Izquierdo Gutierrez     
-Naiara Martínez Odriozola   
-Diego Rodríguez Rubio     
-Saúl García Girón    
-Miguel Gutiérrez Caso 


## ***Índice***
#### 1. Base de Datos:
    1.1  Descripción
    1.2  Imagen E/R          
    1.3  Diagrama Relacional      
    1.4  Importación SQL        
#### 2. Pagina web:         
    2.1  Estructura de la página web   
    2.2  Tipos de estilos  
    2.3  Contenidos de la web  
#### 3. Java:  
    3.1  Diagrama de clases  
    3.2  Clases usadas en JavaDoc  
    3.3  Explicación del código  
#### 4. Implementación y Despliegue:  
    4.1  Tecnologías usadas para la implementación (Tecnologías y características principales usadas en tabla)

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

##### 1.4  Importación SQL 
#### 2. Pagina web:         
##### 2.1  Estructura de la página web

El HTML es importante para dar la estructura a la página web, siendo lo principal para hacer antes de realizar el diseño en CSS. Es fundamental para
establecer las cajas (Header,section,nav,div...etc) con sus atributos identificatorios (Class,id) para poder llamarlos posteriormente en CSS. Así,
incluir en las cajas los elementos (Imagenes,textos...etc) que se quieran incluir en la página para su visualización sin diseño establecido. En
el head se establece diferentes links a archivos css para tenerlo más organizado y fácil de encontrar el código en cuanto se deba modificar
algún código.

El header será un elemento único para cada HTML que se realice, es decir, aparecerá en cada página que se cree vinculada al home de las
actividades complementarias y extraescolares del IES Miguel Herrero. Con su misma estructura y diseño. En esta contendrá el menú
de navegación, donde se podrá ir a diferentes secciones como: actividades (Una pagina donde hablará con mas profundidad sobre las mismas),
Inscripciones (Un formulario para que los alumnos y profesores se inscriban para participar en la actividad), Contacto (con el correo y telefono
del centro), Inicio de Sesión y el registro (Ambas llevarán a un formulario distinto dependiendo del botón escogido)

En el main será dividido por tres sections, que contendran diferentes elementos. Siendo que en el primero habrán imagenes sobre excursiones
ya realizadas por el centro educativo, y textos que explican sobre la importancia de las actividades extraescolares.

En el segundo section contiene diversas cajas que contienen de forma breve información sobre las actividades
que se están por realizar y están abiertas para su inscripción. Cada caja de la información tiene un hipervinculo hacia la página
concreta que explica en mas profundidad la actividad seleccionada (Su cronograma, los lugares a visitar, el transporte...)

##### 2.2  Tipos de estilos  

Se ha utilizado la paleta de colores del logo de IES Miguel Herrero Pereda, para dar sensación que pertenece al centro. Los colores
son de tono pastel para la salud visual, pues son colores que no duelen al verlos en una pantalla. Varian en la coloración de los elementos para dar un
sentido mas armonioso de los 3 colores establecidos, de igual forma, se varian los tonos de los tres colores. 

Las imagenes, tanto informativas de las excursiones como decoraciones, contienen sombras para darle sensación de profundidad y animación de escalado,
aumentando su tamaño de forma suave, y volviendo a su estado original de la misma forma. Los bordes de algunas cajas contienen colores gradiantes de forma
lineal, utilizando un mismo color pero a distintos tonos. 

En las secciones de las actividades se utiliza un diseño de como si estuvieran colgados en un tablon de anuncios de un instituto. (Tablon de corcho)

##### 2.3  Contenidos de la web  
#### 3. Java:  
##### 3.1  Diagrama de clases  

https://github.com/LuisIzquierdoGutierrez/Reto/blob/master/Programaci%C3%B3n/Diagramas/Diagramas%20de%20clases%2010-05.pdf

En la representacion de este diagrama de clases representamos las clases de una aplicacion java de Actividades extraescolares y las relaciones entre ellas mismas.

Cada una de las siguientes clases(Departamento, Tipo_transporte, Transporte, Alojamiento, Profesor, ACEX_Aprobadas, Curso, Solicitudes_ACEX,Grupo) tiene representados sus atributos , deberian estar puestos los metodos, pero se añadio un comentario en el que explicamos que todas estas clases tienen los getters y setters de todos sus atributos, pero que no se han puesto para que entrara en el pdf, tambien estan represetadas las clases de enumerados y la  relacion y cardinalidad entre clases. 


##### 3.2  Clases usadas en JavaDoc  
##### 3.3  Explicación del código 
#### 4. Implementación y Despliegue:  
##### 4.1  Tecnologías usadas para la implementación (Tecnologías y caracteríticas principales usadas en tabla)
| Módulos  | Descripción |
| ---------- | ---------- |
|Programación | Desarrollo entorno servidor  |
| Entornos de desarrollo| Desarrollo entorno cliente |
|Programación | Desarrollo entorno servidor  |
|Programación | Desarrollo entorno servidor  |
|Programación | Desarrollo entorno servidor  |
|Programación | Desarrollo entorno servidor  |

