# Proyecto del Primer Cuatrimestre Fundamentos de Programación (Curso  \<21\>/\<22\>)
Autor/a: \<Alejandro Fernández Orozco\>   uvus:\<aleferoro\>


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes módulos de Python que conforman el proyecto.
  * **\<review_bebidas.py\>**: En este módulo desarrollaremos las distintas funciones que aplicaran los filtros al CSV
  * **\<review_bebidas_test.py\>**: En este módulo escribiremos los test que comprueban las funciones que desarrollamos en el módulo de `review_bebidas.py`. En este módulo está el main
  * **\<parsear.py\>**: En este módulo desarrollaremos el código para parsear los datos del CSV, donde cambiar el formato de los tipos de datos del CSV leidos.
* **/data**: Contiene el dataset o datasets del proyecto.
    * **\<reviews_bebidas.csv\>**: Se trata de un dataset orientado a las reviews de bebidas, donde se identifican con un nombre, tamaño de botella y más caracteristicas.
    
## Estructura del *dataset*

El dataset está compuesto por <7> columnas, con la siguiente descripción:

* **\<('Marca')>**: de tipo \<String>, representa la marca de la bebida
* **\<('Dimensiones')>**: de tipo \<String>, muestra las dimensiones de la botella
* **\<('Nombre')>**: de tipo \<String>, representa el nombre del modelo de la marca y la cantidad que contiene
* **\<('Fecha Revisión')>**: de tipo \<Date>, nos da la fecha en la que se realizo la review con formato yyyy/mm/dd y hora hh/mm/ss
* **\<('Recomendado')>**: de tipo \<Boolean>, nos dice si es recomendable o no la bebida
* **\<('Puntuación')>**: de tipo \<Integer>, nos da la puntuación de la bebida
* **\<('Texto')>**: de tipo \<String>, nos da una leve descripción acerca de las sensaciones al consumir la bebida

## Tipos implementados

He descrito una namedtuple llamada Review que tiene como parametros:
('Review','marca,dimensiones,nombre, fecha_revision, recomendado,puntuacion,texto')

## Funciones implementadas

### \<review_bebidas.py\>

* **<lee_reviews(fichero)>**:lee el fichero de entrada y devuelve una lista de tuplas Review(marca,dimensiones,nombre,fecha_revision,recomendado,puntuacion,texto).

* **<filtrar_por_recomendado(datos,recomendacion=True)>**: Recibe como parametros una lista de tuplas de tipo Review y un parametro de valor Bool por defecto en True y devuelve una lista de tuplas que cumplan con la recomendación
* **<filtrar_por_recomendacion_y_puntuacion(datos,recomendacion,puntuacion=None)>**: Recibe como parametros una lista de tuplas de tipo Review, un parametro recomendacion y un puntuacion y devuelve una lista de tuplas con las bebidas que cumplan la recomendación y la puntuación indicadaFunción que filtra los datos por recomendación y en una puntuación exacta
* **<calcular_numero_marcas_distintas(datos)>**: Recibe como parametro una lista de tuplas de tipo Review y devuelve un int con el numero de marcas distintas
* **<calcular_media_puntuacion_por_marca(datos,marca)>**: Recibe como parametros una lista de tuplas de tipo Review y una marca de tipo String y devuelve un valor float con la media de las puntuaciones de la marca
* **<calcular_maximo_minimo_dimensiones_por_longitud(datos)>**: Recibe como parametro una lista de tuplas de tipo Review y devuelve una tupllon el valor maximo y minimo de los tamaños de botellas
* **<obtener_lista_bebidas_puntuacion_ordenadas(datos)>**: Recibe como parametro una lista de tuplas de tipo Review y devuelve una lista ordenada de tipo review por puntuación
* **<obtener_diccionario_por_marcas(datos)>**: Recibe como parametro una lista de tuplas de tipo Review y devuelve un diccionario con las bebidas oredenadas por marcas
* **<calcular_puntuacion_total_por_marca(datos)>**: #Recibe como parametro una lista de tuplas de tipo Review y devuelve un diccionario con la suma de puntuacion total agrupadas por marcas
* **<dimensiones_mas_comunes(datos)>**:#Recibe como parametro una lista de tuplas de tipo Review y devuelve un diccionario de tipo Counter, contando el numero de bebidas que tienen esas dimensiones
* **<dimensiones_mas_grandes_por_marca(datos)>**:#Recibe como parametro una lista de tuplas de tipo Review y devuelve un diccionario con clave marca y valor la maxima dimension de la bebida
* **<dicc_top_n_bebidas_por_marca(datos, n=1)>**:#Recibe como parametro una lista de tuplas de tipo Review y devuelve un diccionario con las top n bebidas agrupadas por marca 
* **<dibujar_grafica_barras(datos)>**:Recibe como parametro una lista de tuplas de tipo Review y imprime en pantalla un grafico de pastel con el numero de bebidas recomendadas


### \<review_bebidas_test.py\>

* **<main()>**:Función principal sirve para ejecutar los test dentro de esta función
* **<test_lectura(cadena)>**: Muestra por pantalla los datos leídos por la función `lee_reviews(fichero)`

### \<parsear.py\>

* **<parse_datetime(cadena, formato = '%Y-%m-%D %H:%M:%SZ')>**: Dar formato date a la string recibida en el CSV, mediante procesos de la librería datetime
* **<parse_bool(cadena)>**: Da formato booleano a los valores recibidos en el lector del CSV
* **<parse_float(cadena)>**:Se utiliza para dar formato a la cadena que reciban valores float.
* **<parse_str(cadena)>**:Recibe como entrada una cadena y le da el formato tipo String.