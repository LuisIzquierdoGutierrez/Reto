#### 2. Pagina web:         
##### 2.1  Estructura de la página web

Antes de empezar con la realización del HTML y el CSS, se empezó con una maquetación en canva para tener una plantilla base con los elementos que se querían incluir en la página. Esta decisión fue tomada debido a que tomaría mas tiempo realizar una página desde cero sin tener previamente un diseño base, y es mejor tener organizadas las ideas para poder saber que elementos se pondrán.

![image](https://github.com/LuisIzquierdoGutierrez/Reto/assets/152624303/87d5ad55-5602-4bdd-afc4-410a5ca54d44)

En el canva se realiza el diseño que contendrá en index,home o principal de la página y el resto de las páginas adiccionales que estarán vinculadas a la principal. Como: Actividades escolares, Inscripciones, Contacto… etc. Cada pestaña contiene un nombre identificatorio para saber donde se implementará cuando se realice el HTML y CSS.

Cuando el equipo aprobó el diseño de la página, se procedió a su implementación en primero HTML, para organizar los elementos mediante cajas. Empezando con la conexión del HTML a un CSS único, y la implementación de un icono y nombre a la página que se mostrará cada vez se abra en el navegador. 

______________________________________________________________________________________________________________________________________________________________________________

"HTML"

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IES Miguel Herrero Pereda</title>
    <link rel="icon" href="_IMG/Logo_Reto.png" type="image/x-icon"> //Esto añadirá un logo a la pestaña de la página
    <link rel="stylesheet" type="text/css" src="_CSS/PaginaWeb.css" href="_CSS/PaginaWeb.css"> //Esto vinculará el HTML con el CSS
</head>

______________________________________________________________________________________________________________________________________________________________________________

Se  procedió a escribir el código HTML en el body, el CSS se fue realizando a la par que se escribía el código estructural. Empezando por el header, pues sería uno de los bloques se emplearían para todas las páginas adicionales a la principal. El header sería el banner de nuestra página, siendo lo primero que el usuario viera, entonces el diseño debía dejar claro de que se trataba su contenido: sobre Actividades extraescolares del IES Miguel Herrero Pereda. 

El background es una imagen en vista del instituto desde arriba, para así dar a entender en que ubicación se enfoca la pagina. El titulo del banner utiliza los tres colores del logo del centro educativo: rojo, gris y verde. Utilizando tonos mas pastel para que la vista no se saturara con colores fuertes. Se busca principalmente que la página sea agradable visualmente y no canse. El titulo refleja el otro campo de la educación, expresando “La educación no es solo en el aula”, que quiere reflejar que también se puede aprender yendo a lugares que cuenten la historia de primera mano, como aun museo, catedrales… Todo en su estado natural, y algunos con indicios del pasado que no han sido removidos. Estos elementos pueden promover de mejor medida la educación, y en un lugar diferente a lo que son cuatro paredes leyendo de un libro. Dicho de otro modo, explorar la historia en el lugar donde se realizó o se expone. Esto es explicado mas adelante en el home. 

Todo en la página se podrá apreciar diferentes tonalidades, pero siempre enfocandose en los tres colores del logo, por lo cual será normal que solo existan estas tres, salvo algun añadido mas tarde. Siendo reflejado también en el menú de navegación del header, donde los botones contienen colores distintos: uno en rojo, tres en verde y dos en gris. Estos botones para dar sensación de que se pueden clickear, se añadió una animación de aumento de escala y el color se palidece un poco mas al pasar el ratón por encima, así mismo, la flecha del ratón cambia a la de la mano para indicar que puede clickear. Se añadió el logo a la parte izquierda, mas grande y visible, pues en la pestaña del navegador apenas se puede apreciar, al igual que algunos elementos decorativos que están por encima de las cajas (Como el autobus, los monumentos historicos y maleta de viaje), utilizando z-index, para poder decorar el header y dar sensación de que es una página escolar de viajes. Estos elementos tienen efecto de sombra para dar la sensación de que están por encima del banner-header.

Como se ve visualmente:

![image](https://github.com/LuisIzquierdoGutierrez/Reto/assets/152624303/a7333435-f812-46d2-8047-77c4f3a332e8)

HTML:

______________________________________________________________________________________________________________________________________________________________________________

<header>
        <div id="MarcoNav">
            <nav>
                <ul>
                    <li><img id="imgLogo" src="_IMG/Logo_Reto.png"></li>
                    <li id="InicioBanner"><a href="Home.html">Inicio</a></li>
                    <li class="menúVerde"><a href="Actividades.html">Actividades</a></li>
                    <li class="menúVerde"><a href="Inscripcion.html">Inscripciones</a></li>
                    <li class="menúVerde"><a href="Contacto.html">Contacto</a></li>
                    <li><img id="imgSeparadorNav" src="_IMG/img_separador_nav.png"></li>

                    <div id="menuRegistro">
                        <li class="menuInicioRegistro"><a href="Registro.html">Registrarse</a></li>
                        <li class="menuInicioRegistro"><a href="Inicio_Sesion.html">Inicio de Sesión</a></li>
                    </div>
                </ul>
            </nav>
        </div>

        <div id="TituloHome">
            <span class="Rojo">Actividades</span><span class="Verde"> Extraescolares<br></span>
            <span class="Verde2">La educación</span><span class="Blanco"> no es solo </span><span class="Rojo2">en el
                aula</span>
        </div>
    </header>

    <img id="imgIzqBanner" src="_IMG/imgIzqBanner.png">
    <img id="imgDerBanner" src="_IMG/img1DerBanner.png">
    <img id="imgBannerTransporte" src="_IMG/autobusBanner.png">

______________________________________________________________________________________________________________________________________________________________________________

Las imágenes decorativas se encuentran fuera del header debido a que estarían afectadas por el css que se le dio a dicha etiqueta, y actuarían de manera diferente a la planeada.

CSS:

______________________________________________________________________________________________________________________________________________________________________________

html{

    width: 100%;
    zoom:100%;

}

header{

    height: 450px;
    display: flex;
    flex-direction: row;
    background-image: url(../_IMG/BackgroundBanner.jpg);
    background-size: 100%;
    background-repeat: no-repeat;
    align-items: center;
    justify-content: center;
    justify-items: center;
    flex-direction: column;

    width:100%;
    overflow:hidden;

    z-index: 1;
    position: relative;
}

#MarcoNav{

    background-color: white;
    height: 190px;
    border-radius: 20px;
    border: 5px;
    border-style: solid;
    border-color: rgb(223, 86, 86);
    padding-right: 35px;

    box-shadow: 10px 5px 15px black;
}

ul{
    
    display: flex;
    align-items: center;
    list-style-type: none;

}

#imgLogo{

    width: 150px;

}

#InicioBanner{

    margin: 10px;
    background-color: #df6262;
    background-size: 30px;
    color: white;
    border-radius: 30px;
    font-size: 20px;
    padding: 20px;
    padding-left: 30px;
    padding-right: 30px;
    font-weight: bolder;
    transition: all 500ms ease-out;
}

.menúVerde{

    background-color: #5c955c;
    padding: 12px;
    color: white;
    font-size: 20px;
    padding-left: 20px;
    font-weight: bolder;
    transition: all 500ms ease-out;

}

#imgSeparadorNav{

    width: 105px;
    padding-left: 15px;
    padding-right: 15px;

}

.menuInicioRegistro{

    background-color: #b9b9b9;
    padding: 10px;
    border-radius: 20px;
    text-align: center;
    font-size: 20px;
    font-weight: bold;
    margin-top: 10px;
    transition: all 500ms ease-out;
}

#TituloHome{

    text-align: center;
    margin-top: 20px;
    justify-content: center;
    justify-items: center;
}

Span.Rojo{

    color: rgb(201, 56, 56);
    -webkit-text-stroke-width: 1px;
    -webkit-text-stroke-color: white;
    font-size: 75px;
    font-weight: bold;

    text-shadow: 7px 1px 6px black;

}

Span.Verde{

    color:rgb(41, 99, 41);
    -webkit-text-stroke-width: 1px;
    -webkit-text-stroke-color: white;
    font-size: 75px;
    font-weight: bold;

    text-shadow: 7px 1px 6px black;
}

Span.blancoGrande{
    color:rgb(255, 255, 255);
    -webkit-text-stroke-width: 1px;
    -webkit-text-stroke-color: rgb(41, 99, 41);
    font-size: 75px;
    font-weight: bold;

    text-shadow: 7px 1px 6px black;
}

Span.Blanco{

    color: rgb(226, 226, 226);
    -webkit-text-stroke-width: 2px;
    -webkit-text-stroke-color: rgb(24, 24, 24);
    font-size: 60px;
    font-weight: bold;

    text-shadow: 5px 1px 8px black;
}

Span.Rojo2{

    color: rgb(201, 56, 56);
    -webkit-text-stroke-width: 2px;
    -webkit-text-stroke-color: rgb(24, 24, 24);
    font-size: 60px;
    font-weight: bold;

    text-shadow: 5px 1px 8px black;
}

Span.Verde2{

    color:rgb(65, 131, 65);
    -webkit-text-stroke-width: 2px;
    -webkit-text-stroke-color: rgb(24, 24, 24);
    font-size: 60px;
    font-weight: bold;

    text-shadow: 5px 1px 8px black;

}

#InicioBanner,.menúVerde,.menuInicioRegistro:hover{

    cursor: pointer;
    transition: all 500ms ease-out;
}

#imgIzqBanner, #imgDerBanner, #imgBannerTransporte{
    position: absolute;
    width: 500px;
    z-index: 2;
    top: 165px;

    filter: drop-shadow(5px 1px 6px black);

}

#imgBannerTransporte{

    width: 115px;
    left: 400px;
    top: 172px;
}
#imgDerBanner{

    right: 5px;
    top: 24px;
}

#InicioBanner:hover{

    background-color: #dd9191;
    
    transform:scale(1.1);
}

.menúVerde:hover{

    background-color: #8cb48c;
    transform:scale(1.1);
}

.menuInicioRegistro:hover{

    background-color: #dddddd;
    transform:scale(1.1);
    
}

______________________________________________________________________________________________________________________________________________________________________________

Los elementos que tendran el mismo estilo de diseño se empleó el atributo class, y para los elementos que tendrán un diseño unico, se empleó el atributo ID. La diferencia entre ambos, es que en el css se refleja con un .NombreDelAtributo en un atributo class, y #NombreDelAtributo en un atributo ID. Los nombres de los atributos se intentó realizar de la manera mas intuitiva para quien venga despues a modificar o ampliar el código, tanto del mismo home o de las páginas adicionales.

Tras terminar con el header, se procedió con el main, que está conformada por tres sections. Cada section contiene información diferente, pero dos contienen el mismo diseño. Esto para ahorrar código y no alterar a la vista con elementos distintos. 

En el primer sectión contiene la información sobre las actividades extraescolares de forma general. Sobre lo positivo que es realizar estas actividades: porque es un entorno distinto, se pueden realizar actividades en la excursión para aprender mas, generan experiencias que después los alumnos pueden no olvidar... Enfoques positivos sobre las actividades extraescolares. En las imágenes que se muestran en este bloque, son fotos realizadas por el centro educativo en excursiones ya realizadas con anterioridad. Fueron conseguidas en la página oficial del centro al contar con una galería de imágenes. Lo distinto de estas, es que varia su modo de presentación en las dos columnas. En la primera columna, las imágenes están presentadas con una decoración de simbolo de ubicación, icono que se suele emplear en los mapas para indicar la ubicación que estás buscando, o tu posición misma. Esto para reforzar la imagen de que la página es sobre actividades extraescolares como excursiones a otros lugares. En la segunda columna, se emplea la presentación de fotos, para dar la sensación de que se guardan recuerdos y experiencias de las actividades participadas. Siempre o mayoritariamente, el centro educativo saca fotos de este tipo de actividades para almacenarlas y tenerlas como recuerdo, de igual modo, tambien cada alumno se lleva un recuerdo, tanto en imagen como en la mente. Cada foto tiene un hover que reacciona a la flecha del ratón, aumentando suavemente su tamaño y apareciendo una sombra a su vez va aumentando la escala, dando la sensación que se está separando de la página. Finalmente, como en el header, se ponen un par de decoraciones para adornar el section, de igual manera empleando las sombras.

Como se ve visualmente:

![image](https://github.com/LuisIzquierdoGutierrez/Reto/assets/152624303/a7e92b92-d8bd-4262-8bf8-859573579bc5)

Con animacion:

![image](https://github.com/LuisIzquierdoGutierrez/Reto/assets/152624303/0e2a154d-c182-4e58-935f-73b45a68067c)

HTML:

______________________________________________________________________________________________________________________________________________________________________________

<main>

        <img src="_IMG/iconoDecoradoPrimeraParte.png" id="TamañoIconoDecorado">
        <span id="titulo1Verde">Las actividades extraescolares</span>

        <section id="Section1">

            <div id="InfoGeneral_LadoIzquierdo">

                <table>

                    <tr>
                        <td class="celdaIMG"><img src="_IMG/ExcursionDecorada_1.png" class="tamañoImagen"></td>
                        <td><span class="textoPrimeraParte">Excursiones fuera de la escuela, realizando determinadas
                                actividades acordes a la finalidad de la excursión</span></td>
                    </tr>
                    <tr>
                        <td><span class="textoPrimeraParte">La educación no es solo es dentro de un aula, con las
                                excursiones podrán aprender en un entorno distinto</span></td>
                        <td class="celdaIMG"><img src="_IMG/ExcursionDecorada_2.png" class="tamañoImagen"></td>
                    </tr>
                    <tr>
                        <td class="celdaIMG"><img src="_IMG/ExcursionDecorada_3.png" class="tamañoImagen"></td>
                        <td><span class="textoPrimeraParte">Excursiones fuera de la escuela, realizando determinadas
                                actividades acordes a la finalidad de la excursión</span></td>
                    </tr>
            </div>

            <div id="InfoGeneral_LadoDerecho">

                <table>
                    <tr>
                        <td class="celdaIMG"><img src="_IMG/Excursion4.png" class="tamañoImagen2"></td>
                        <td><span class="textoPrimeraParte">Las experiencias son tambien aprendizajes y se guardan mejor
                                en nuestra memoria.</span></td>
                    </tr>
                    <tr>
                        <td><span class="textoPrimeraParte">No se debería asociar el aburrimiento con la educación,
                                existen mas dinámicas para aprender. Un entorno entretenido, mantiene la concentración.
                            </span></td>
                        <td class="celdaIMG"><img src="_IMG/Excursion5.png" class="tamañoImagen2"></td>
                    </tr>
                    <tr>
                        <td class="celdaIMG"><img src="_IMG/Excursion6.png" class="tamañoImagen2"></td>
                        <td><span class="textoPrimeraParte">Excursiones fuera de la escuela, realizando determinadas
                                actividades acordes a la finalidad de la excursión</span></td>
                    </tr>
                </table>
            </div>
        </section>

        <img src="_IMG/iconoDecoradoPrimeraParte2.png" id="TamañoIconoDecorado2">
        <span id="titulo2Rojo">La diversión forma parte del aprendizaje</span>

______________________________________________________________________________________________________________________________________________________________________________

CSS:

______________________________________________________________________________________________________________________________________________________________________________

#Section1{

    display: flex;
    justify-content: space-between;
}

#TamañoIconoDecorado{

    position: absolute;
    width: 100px;
    z-index: 3;
    top: 450px;
    left:730px;

    filter: drop-shadow(5px 1px 6px black);
}

tr{

    text-align: center;
    width: 200px;
}
#InfoGeneral_LadoIzquierdo{

    display: flex;

    width: 50%;
    height: 855px;
    
    border-right-color: black;
    border-right: 2px;
    border-right-style:double;

    margin-right: 100px;
}

#titulo1Verde{

    background-color:rgb(41, 99, 41);
    font-size: 40px;
    color: white;
    font-weight: bold;
    border-radius: 20px;
    padding: 20px;
    padding-left: 100px;
    padding-right: 100px;

    margin-left: 100px;

}


table{

    width: 500px;   
    margin-top: 50px;

    display: flex;
    justify-content: space-between;

    margin-right: 500px;
}

.celdaIMG{

    width: 50px;
}

.tamañoImagen{

    width: 250px;
    padding-right: 40px;
    padding-left: 40px;
    transition: all 500ms ease-out;
}

.tamañoImagen.td{

    width: 20px;
    
}

.textoPrimeraParte{

    font-size: 20px;
    text-align: center;
}

.tamañoImagen:hover{

    transform:scale(1.1);
    filter: drop-shadow(5px 1px 6px black);
    transition: all 500ms ease-out;
}

#InfoGeneral_LadoDerecho{

    display: flex;


    width: 50%;
    height: 890px;
    flex-grow: 1;
    margin-left: 100px;


}

.tamañoImagen2{

    width: 250px;
    padding-right: 40px;
    padding-left: 40px;
    transition: all 500ms ease-out;
}

.tamañoImagen2:hover{

    transform:scale(1.1);
    transition: all 500ms ease-out;
}

#TamañoIconoDecorado2{

    position: absolute;
    width: 150px;
    z-index: 2;
    top: 1230px;
    right: 150px;

    filter: drop-shadow(5px 1px 6px black);
}

#titulo2Rojo{

    background-color: #df6262;
    font-size: 40px;
    color: white;
    font-weight: bold;
    
    border-top-left-radius: 20px;
    border-top-right-radius: 20px;
    border-bottom-right-radius: 20px;
    padding: 20px;
    
    margin-left: 1040px;
}

______________________________________________________________________________________________________________________________________________________________________________


El segundo section y el tercer section comparten similitudes, como el CSS, pues ambos contienen el mismo diseño. Aunque su información se diferencia entre las actividades pendientes por realizarse, y las que ya realizaron. Siendo en el segundo section donde se implementan tres actividades extraescolares que se encuentren activas en ese momento, es decir, que están pendientes de realizarse. Está dividido en dos columnas por display flex, la primera columna con las imagenes relacionadas con la excursión, y la segunda con el titulo y descripción de la actividad. En cada fila de actividad tiene un enlace clickeable que redirigirá al usuario a una página adicional donde se informará en mas profundidad sobre la actividad extraescolar seleccionada (Cronograma, lugares que visitarán, transporte que se utilizará, profesores encargados...) Si se quiere comprobar que mas actividades están por realizarse, se puede clickear en el botón de "Lista de actividades pendientes" que redirigirá al usuario a una nueva página donde mostrará al completo todas las actividades propuestas y aun no se han realizado, por lo que aun hay tiempo para inscribirse en estas si se cumple los requisitos establecidos.

Como se ve visualmente:

![image](https://github.com/LuisIzquierdoGutierrez/Reto/assets/152624303/808e5dff-08f5-4b98-a157-886ec5428ca5)

HTML:

______________________________________________________________________________________________________________________________________________________________________________

<section id="Section2">

            <span id="tituloSection2">Actividades extraescolares por realizarse</span>

            <div id="ContenidoActividadesPendientes">

                <img src="_IMG/DecoracionParte2_1.png" class="DecoracionParte2" id="DecoracionParte2_1">
                <img src="_IMG/DecoracionParte2_2.png" class="DecoracionParte2" id="DecoracionParte2_2">
                <img src="_IMG/DecoracionParte2_3.png" class="DecoracionParte2" id="DecoracionParte2_3">

                <div id="ContenedorViajes">
                    <div id="imagenes">
                        <img src="_IMG/ViajePendiente1.png" class="ViajePendiente" id="ViajePendiente1">
                        <img src="_IMG/ViajePendiente2.png" class="ViajePendiente" id="ViajePendiente2">
                        <img src="_IMG/ViajePendiente3.png" class="ViajePendiente" id="ViajePendiente3">
                    </div>

                    <div id="InfoViaje">

                        <div id="InfoViaje1">
                            <span class="TituloViaje">Viaje a Madrid</span>
                            <img src="_IMG/DecoracionSegundaParteGif_2.gif" class="DecoracionParte2"
                                id="DecoracionSegundaParteGif_1"><br>
                            <span class="DescripcionViaje">Los alumnos que cursan la ESO y Bachillerato que se inscriban
                                podrán ir de viaje al parque de atracciones Warner de Madrid, entre otros destinos.<br>
                                <span class="MasInformacionViaje"><a href="Info_Actividades_Pendientes_Madrid.html">[Click aquí para más información]</a></span></span>

                        </div>

                        <div id="InfoViaje2">
                            <span class="TituloViaje">Viaje a Segovia</span>
                            <img src="_IMG/DecoracionSegundaParteGif_3.gif" class="DecoracionParte2"
                                id="DecoracionSegundaParteGif_2"><br>
                            <span class="DescripcionViaje">Los alumnos de Bachillerato que se inscriban podrán ir de
                                viaje a Segovia para visitar los lugares mas históricos de la comunidad. Como el
                                Acueducto de Segovia.<br>
                                <span class="MasInformacionViaje"><a href="Info_Actividades_Pendientes_Segovia.html">[Click aquí para más información]</a></span></span>

                        </div>

                        <div id="InfoViaje3">
                            <span class="TituloViaje">Viaje a Cabarceno</span>
                            <img src="_IMG/DecoracionSegundaParteGif_1.gif" class="DecoracionParte2"
                                id="DecoracionSegundaParteGif_3"><br>
                            <span class="DescripcionViaje">Los alumnos de ESO y Bachillerato que se inscriban podrán ir
                                de excursión al Zoo Carbarceno de Cantabria.<br>
                                <span class="MasInformacionViaje"><a href="Info_Actividades_Pendientes_Cabarceno.html">[Click aquí para más información]</a></span></span>

                        </div>
                    </div>
                </div>

                <span id="ListaMasViajes"><a href="ListaActividadesPendientes.html">Lista de mas viajes por realizarse</a></span>

            </div>

            </div>

        </section>
        
______________________________________________________________________________________________________________________________________________________________________________

CSS:

______________________________________________________________________________________________________________________________________________________________________________

#Section2{

    margin-top: 48px;
    
}

#tituloSection2{

    background-color:rgb(73, 73, 73);
    font-size: 40px;
    color: white;
    font-weight: bold;

    border-top-left-radius: 20px;
    border-bottom-left-radius: 20px;
    border-bottom-right-radius: 20px;

    padding: 20px;
    padding-left: 100px;
    padding-right: 100px;
    padding-bottom: 30px;
    padding-top:30px;

    margin-left: 500px;
    
    
}
#ContenidoActividadesPendientes{

	

    margin-left: 150px;
    margin-right: 150px;
    padding-top: 50px;

    background-color: bisque;
    border-style: solid;
    border-width: 10px;
    border-radius: 10px;
    
    border-image: linear-gradient(45deg, rgb(255, 90, 90), rgb(255, 231, 164),rgb(255, 148, 49)) 1;

    padding-bottom: 50px;
    
}

#ContenedorViajes{

    display: flex;
    justify-content: space-between;

    margin-bottom: 100px;
    margin-left: 20px;
    margin-right: 20px;
}

.ViajePendiente{

    width: 200px;
    height: 200px;

    margin-left: 20px;
    margin-bottom: 20px;

    transition: all 500ms ease-out;
}

#imagenes{

    display: flex;
    flex-direction: column;
    
}

#InfoViaje{

    display: flex;
    flex-direction: column;
    justify-content: space-around;
    margin-left: 20px;
   
}

.TituloViaje{

    color: rgb(99, 172, 57);
    font-size: 40px;
    font-weight: bold;

    
}

.DescripcionViaje{

    font-size: 20px;
    
}

#ListaMasViajes{

    background-color:rgb(248, 114, 80);
    font-size: 20px;
    color: white;
    font-weight: bold;

    border-radius: 20px;

    padding: 20px;
    padding-left: 100px;
    padding-right: 100px;
    padding-bottom: 15px;
    padding-top:15px;

    margin-left: 500px;
    transition: all 500ms ease-out;
}

#ListaMasViajes:hover{

    background-color: rgb(255, 155, 130);
    transform:scale(1.1);
    cursor: pointer;
    transition: all 500ms ease-out;
}

.ViajePendiente:hover{

    filter: drop-shadow(5px 1px 6px black);
    transform:scale(1.1);
    transition: all 500ms ease-out;
}

.MasInformacionViaje{

    font-weight: bold;
    color: rgb(192, 83, 56);;
}

.MasInformacionViaje:hover{

    cursor: pointer;
    text-decoration: underline;
}

.DecoracionParte2{

    position: absolute;
    width: 150px;
    z-index: 3;

    filter: drop-shadow(5px 1px 6px black);
    transition: all 500ms ease-out;
}

#DecoracionParte2_1{

    left: 275px;
    top: 1620px;

}

#DecoracionParte2_2{

    left: 275px;
    top: 1873px;
    width: 120px;

}

#DecoracionParte2_3{

    left: 275px;
    top: 2110px;
}

.DecoracionParte2:hover{

    transform:scale(1.1);
    transition: all 500ms ease-out;
}

#DecoracionSegundaParteGif_1{

    left: 700px;
    top: 1580px;
    width: 90px;
}

#DecoracionSegundaParteGif_2{

    left: 670px;
    top: 1790px;
}

#DecoracionSegundaParteGif_3{

    left: 740px;
    top: 2015px;
    width: 110px;
}
______________________________________________________________________________________________________________________________________________________________________________

El tercer section a diferencia del segundo, contiene información sobre tres actividades ya realizadas del centro educativo. Contiene el mismo diseño como en el anterior section comentado. Las imagenes son fotos realizadas durante la actividad extraescolares que el instituto ha tomado. Se podrá ver la información mas completa y mas fotos de la actividad al clickear en el enlace "Click aquí para más información". 

Como se ve visualmente:

![image](https://github.com/LuisIzquierdoGutierrez/Reto/assets/152624303/4131acf2-df7d-4b15-8d3a-94bb10dc1fe9)

HTML:

______________________________________________________________________________________________________________________________________________________________________________

<section id="Section3">

            <span id="tituloSection3">Actividades extraescolares realizadas</span>

            <div id="ContenidoActividadesPendientes">

                <img src="_IMG/DecoradoRealizado1_1.png" class="DecoracionParte3" id="DecoracionParte3_1">
                <img src="_IMG/DecoradoRealizado1_2.png" class="DecoracionParte3" id="DecoracionParte3_2">
                <img src="_IMG/DecoradoRealizado1_3.png" class="DecoracionParte3" id="DecoracionParte3_3">

                <div id="ContenedorViajes">
                    <div id="imagenes">
                        <img src="_IMG/ViajeRealizado1.png" class="ViajePendiente" id="ViajePendiente1">
                        <img src="_IMG/ViajeRealizado2.png" class="ViajePendiente" id="ViajePendiente2">
                        <img src="_IMG/ViajeRealizado3.png" class="ViajePendiente" id="ViajePendiente3">
                    </div>

                    <div id="InfoViaje">

                        <div id="InfoViaje1">
                            <span class="TituloViaje">Viaje a Barcelona</span>
                            <img src="_IMG/DecoracionSegundaParteGif_2.gif" class="DecoracionParte2"
                                id="DecoracionSegundaParteGif_1"><br>
                            <span class="DescripcionViaje">Los alumnos que cursaron 4ºESO, realizaron un viaje a
                                Barcelona, visitando la Colina De Montjuic entre otras paradas en el viaje sobre la
                                historia
                                de la ciudad<br>
                                <span class="MasInformacionViaje"><a href="Info_Actividades_Realizadas_Barcelona.html">[Click aquí para más información]</a></span></span>

                        </div>

                        <div id="InfoViaje2">
                            <span class="TituloViaje">Viaje al parque natural Saja-Besaya</span>
                            <img src="_IMG/DecoracionSegundaParteGif_3.gif" class="DecoracionParte2"
                                id="DecoracionSegundaParteGif_2"><br>
                            <span class="DescripcionViaje">Los alumnos de Biología y Geología de 4ºESO fueron a conocer
                                el centro de visitantes del parque natural Saja-Besaya para después realizar un
                                recorrido
                                por el hayedo.<br>
                                <span class="MasInformacionViaje"><a href="Info_Actividades_Realizadas_Saja-Besaya.html">[Click aquí para más información]</a></span></span>

                        </div>

                        <div id="InfoViaje3">
                            <span class="TituloViaje">Carrera solidaria y orientación</span>
                            <img src="_IMG/DecoracionSegundaParteGif_1.gif" class="DecoracionParte2"
                                id="DecoracionSegundaParteGif_3"><br>
                            <span class="DescripcionViaje">Con motivo del 60 aniversario del instituto el alumnado de
                                ESO y 1ºBachillerato participó en una
                                carrera solidaria y una prueba de Orientación en la Viesca. <br>
                                <span class="MasInformacionViaje"><a href="Info_Actividades_Realizadas_CarreraSolidaria.html">[Click aquí para más información]</a></span></span>

                        </div>
                    </div>
                </div>

                <span id="ListaMasViajes"><a href="ListaActividadesRealizadas.html">Lista de mas viajes realizados</a></span>

            </div>
            </div>
        </section>
    </main>

______________________________________________________________________________________________________________________________________________________________________________

CSS (Comparte CSS con la segunda section):

______________________________________________________________________________________________________________________________________________________________________________

#Section3{

    margin-top: 29px;

}

.DecoracionParte3{

    position: absolute;
    width: 150px;
    z-index: 3;

    filter: drop-shadow(5px 1px 6px black);
    transition: all 500ms ease-out;

}

.DecoracionParte3:hover{

    transform:scale(1.1);
    transition: all 500ms ease-out;
}

#DecoracionParte3_1{

    left: 275px;
    top: 2628px;
    width: 110px;


}

#DecoracionParte3_2{

    left: 275px;
    top: 2840px;
    width: 130px;

}

#DecoracionParte3_3{

    left: 275px;
    top: 3070px;
    width: 110px;

}

#tituloSection3{

    background-color:rgb(73, 73, 73);
    font-size: 40px;
    color: white;
    font-weight: bold;

    
    border-bottom-left-radius: 20px;
    border-bottom-right-radius: 20px;

    padding: 20px;
    padding-left: 100px;
    padding-right: 100px;
    padding-bottom: 30px;
    padding-top:30px;

    margin-left: 500px;
    
    
}
______________________________________________________________________________________________________________________________________________________________________________

Terminado con el main, se procede con el footer de la página. Junto con el header, el footer también aparecerá en todas las páginas conectadas a la página principal. En este tiene un background con fotos de algunas actividades extraescolares realizadas en IES Miguel Herrero. Está organizado en tres columnas con flex. La primera columna contiene el logotipo del Gobierno de Cantabria y la consejería de educación. La segunda columna un menú de navegación hacia páginas adicionales como: aviso legal, política de cookies, protección de datos... etc. La tercera columna contiene la información de contacto del centro educativo. Finalmente, en el final del footer, contiene una caja con los nombres de los miembros del equipo 4 que realizaron el reto.

Como se ve visualmente:

![image](https://github.com/LuisIzquierdoGutierrez/Reto/assets/152624303/4cf9f491-d84a-4a1a-8aab-4e2dd9802d61)

HTML:

______________________________________________________________________________________________________________________________________________________________________________

<footer>

        <div id="ContenedorFlexFooter">
        <div id="GobiernoCantabria">
            <img src="_IMG/GobiernoCantabria.png" id="imgGobierno">
        </div>

            <div id="NavegaciónFooter">

                <nav id="Información">
                    <span class="TituloFooter">Información</a></span>
                        <p class="EnlaceFooter"><a href="MapaSitio.html">Mapa de Sitio</a></p>
                        <p class="EnlaceFooter"><a href="AvisoLegal.html">Aviso Legal</a></p>
                        <p class="EnlaceFooter"><a href="ProteccionDatos.html">Protección de Datos</a></p>
                        <p class="EnlaceFooter"><a href="PoliticaCookies.html">Política de Cookies</a></p>
                        <p class="EnlaceFooter"><a href="Accesibilidad.html">Accesibilidad</a></p>
                </nav>

            </div>

            <div id="ContactoFooter">

                <div id="Contacto">
                    <span class="TituloFooter">Contacto</span>
                        <p class="textFooter"><img src="_IMG/imagen1Footer.png" class="imgFooter">P.º de Julio Hauzeur, 59, 39300, Torrelavega, Cantabria</p>
                        <p class="textFooter"><img src="_IMG/imagen2Footer.png" class="imgFooter">942 88 24 98</p>
                        <p class="textFooter" id="emailFooter"><img src="_IMG/imagen3Footer.png" class="imgFooter">ies.miguel.herrero.pereda@educantabria.es</p>
                </div>
            </div>
            </div>

        <div id="TrabajoRealizadoPor">
            <span id="Creditos">Trabajo Realizado Por: </span><span class="HoverNombres">Naiara Martinez</span>, <span class="HoverNombres">Luis Izquierdo</span>, <span class="HoverNombres">Adrían de Diego</span>, <span class="HoverNombres">Diego Rodriguez</span>, <span class="HoverNombres">Miguel Gutiérrez</span> y <span class="HoverNombres">Saúl García</span>
        </div>
    </footer>
</body>
</html>
______________________________________________________________________________________________________________________________________________________________________________

CSS:

______________________________________________________________________________________________________________________________________________________________________________

footer{

    background-image: url(../_IMG/Background_Footer.png);
    background-size: 100%;
    background-repeat: no-repeat;
    height: 950px;
}


#imgGobierno{

    width: 400px;
}

.imgFooter{

    width: 25px;
    margin-right: 5px;
}

#ContenedorFlexFooter{

    display: flex;
    justify-content: center;
    justify-content: space-around;
    margin-left: 20px;
    margin-right: 20px;
}

#NavegaciónFooter{

    display: flex;
    flex-direction: column;

    
}

#Información{

    display: flex;
    flex-direction: column;

}


#NavegaciónFooter,
#ImagenesContactoFooter,
#ContactoFooter{

    margin-top: 20px;
    margin-left: 20px;
    margin-right: 20px;

    display: flex;
    flex-direction: column;
}

#GobiernoCantabria,
#NavegaciónFooter,
#ContactoFooter{

    margin-top: 50px;
}

.TituloFooter{

    color:rgb(41, 99, 41);
    font-size: 30px;
    font-weight: bold;
    text-decoration: underline;
}

.textFooter{

    font-size: 20px;

}

.EnlaceFooter{

    font-size: 20px;
    transition: all 500ms ease-out;
    

}
.EnlaceFooter:hover{

    cursor: pointer;
    color: rgb(192, 83, 56);
    transform: scale(1.1);
    transition: all 500ms ease-out;
}


#emailFooter{

    text-decoration: underline;
}

#TrabajoRealizadoPor{

    background-color: rgb(192, 61, 61);
    margin-top: 550px;
    padding-top: 15px;
    padding-bottom: 15px;
    color: wheat;
    padding-left: 20px;
}

#Creditos{

    font-weight: bold;
    text-decoration: underline;
    margin-right: 10px;
}

.HoverNombres{
    transition: all 500ms ease-out;
}

.HoverNombres:hover{

    transform: scale(1.1);
    transition: all 500ms ease-out;
}

a{

    color:black;
    text-decoration: none;
}
______________________________________________________________________________________________________________________________________________________________________________

##### 2.2  Breve explicación de los tipos de estilos utilizados

    height: 450px; //Establece una altura a la caja
 
    display: flex; //Activa el modelo de cajas flexible y sus correspondientes codigos. Sin este, no se podría utilizar los códigos asociados al flex.
    
    flex-direction: row; //Esto hace que los elementos hijos se organicen en filas (Está asociado con el flex)
    
    background-image: url(../_IMG/BackgroundBanner.jpg); //Este código establece una imagen de fondo para la caja header. Por ende estará por debajo de los elementos de html.
    
    background-size: 100%; //Va asociado al código anterior. Esto establece un tamaño para la imagen del fondo de la caja.
    
    background-repeat: no-repeat; //Va asociado con la imagen de fondo. Esto establece si se repite, si queremos que se repita horizontalmente o verticalmente, o si no queremos que se repita. En este caso, no se repetirá la imagen de fondo.
    align-items: center; //Esto provocará que los elementos se alineen en el centro del eje y (Verticalmente de la caja)
    
    justify-content: center;  //Esto provocará que los elementos se alineen en el centro del eje x (Horizontalmente de la caja)
    
    justify-items: center; //Alinea los elementos nietos en el centro del eje x
    
    flex-direction: column; //Esto provoca que los elementos se alineen en columna (Está asociado con el flex)

    width:100%; //Establece el ancho a la caja
    overflow:hidden; //Este código hará que todo contenido que se salga del header no se visualice, solo se verá lo que permanezca dentro de la caja sin salirse.

    z-index: 1; //Establece el orden en que se posiciona los elementos. En caso de que otro elemento tenga un numero superior, se superpondrá a esta caja. (Funcionará si declaramos una position)
    position: relative; // Libera al elemento de su posición original y combinado con top, bottom, left y right, nos permite desplazarlo respecto a ella. El resto de elementos no es afectado por esto.

    background-color: white; //Establece un color de fondo a la caja.

    border-radius: 20px; //Provoca que el elemento tenga un borde con bordes redondeados.
    
    border: 5px; //Establece el tamaño del border
    
    border-style: solid; //Establece el diseño del borde, en este caso es un diseño liso lineal.
    
    border-color: rgb(223, 86, 86); //Establece el color del borde
    
    padding-right: 35px; //Provoca relleno en el lado derecho de la caja, expandiendo la caja o alejando otro

    box-shadow: 10px 5px 15px black; //Establece una sombra a la caja, la direccion en x e y, la intensidad y el color.

    list-style-type: none; //Establece que no aparezca el simbolo de las listas <ul> y <ol>. Seguirá manteniendose como una lista pero sin el punto o numeración.

    margin: 10px; //Establece margen en todas las direcciones (Left, Right, Top y Bottom)

    font-size: 20px; //Establece un tamaño de fuente de letra

    padding: 20px; //Establece relleno en todas las direcciones (Left, Right, Top y Bottom)

    font-weight: bolder; //Establece el grosor de la fuente. En este caso, se hace mas grueso.

    transition: all 500ms ease-out; //Establece una animación de transicción, siendo de 500 milisegundos. El ease out establece que será mas rapido inicialmente y despues desaparecería lentamente. Esto va asociado con un hover y su correspondiente animación. De 
    ponerlo tanto en un hover como en una caja normal, se verá una transición suave en caso de utilizar aumento de escala o cambios de color. (Utilizados en nuestro sitio web)

    -webkit-text-stroke-width: 1px; //Establece un borde a las letras

    -webkit-text-stroke-color: white; //Establece un color al borde de la letra

    text-shadow: 7px 1px 6px black; //Establece una sombra al texto

    cursor: pointer; //Cambia el puntero a la de una mano. Se utiliza para botones que se pueden clickear o menús de navegación. Se debe poner en los elementos atribuidos con un hover.

    position: absolute; Se posiciona automáticamente en el punto de inicio (top-left esquina) de su elemento padre

    filter: drop-shadow(5px 1px 6px black); //Se utiliza para que aparezca un filtro de sombra cuando se posiciona el ratón encima de un elemento con hover.

    left: 400px; //Establece la posición desde la izquierda 

    top: 172px; //Establece la posición desde arriba

    transform:scale(1.1); //Provoca que el elemento aumente en el valor entre parentesis. Es recomendable utilizarlo en un elemento con hover, pues al pasar el ratón por encima, hará que una animación de aumento de tamaño, dando sensación de que se puede interactuar o 
    dinamismo.

    justify-content: space-between; //Va asociado al display flex, de no tener un flex activado no funcionará. Hará que los elementos tengan un espacio entre si.

    border-right-color: black; //Establece un borde solo para la derecha de color negro
    border-right: 2px;
    border-right-style:double;
    
    color: white; //Establece el color del texto

    border-image: linear-gradient(45deg, rgb(255, 90, 90), rgb(255, 231, 164),rgb(255, 148, 49)) 1; //Establece un borde con color degradado de forma lineal, es decir, los 3 colores actuan como columnas mezclando sus colores con los que rgb que hemos puesto

    justify-content: space-around; //Código asociado al display flex. De no tener activado el flex no funcionará. Hará que los elementos tengan un espacio de alrededor de ellos.

    text-decoration: underline; //Provoca que el texto tenga una sublinea.

    text-decoration: none; //Provoca que el texto no tenga ninguna decoración.
    
##### 2.3  Explicación de los contenidos incluidos en la web  

Se han incluido contenidos multimedia oficiales de IES Miguel Herrero Pereda, siendo las fotos que se realizaron durante algunas actividades extraescolares publicas del centro. La información sobre las actividades realizadas han sido sacadas de las revistas públicas del instituto, donde los alumnos relatan sobre sus experiencias y paradas en estas excursiones, entre otras secciones. Esto se ha decidido debido a que es una página de ambito escolar y perteneciente del centro educativo, daría mas la sensación de pertenencia al centro educativo incluyendo las fotos de las excursiones que ha realizado. 

Por otro lado, se incluirá contenido de video, enlazado con un video de youtube pero insertado en la página en las actividades pendientes, mientras sea relacionado a este. Esto para darle mas atractivo a la página y  coherencia. Así mismo, se intentará implementar videos realizados por el IES Miguel Herrero Pereda sobre sus excursiones realizadas, para incluirlas en las actividades ya realizadas de la página.

Se han incluido contenidos decorativos para que la página se vea más atractiva, ajena a una página aburrida como algunos asocian a la una escolar. Estos elementos tienen como función a ver la página mas moderna y agradable a la vista.
