from review_bebidas import * 
def main():
    print('\n/////////////////////////////////////////////////////////////////////////////////////////////////\n')
    print('TEST DE LAS FUNCIONES DE REVIEW BEBIDAS')
    registro=test_lectura('data/reviews bebidas.csv')
    print('\nESTOS SON LOS 3 PRIMEROS:\n')
    for d in registro[:3]:
        print(d,'\n')
    print('\nESTOS SON LOS 3 ÚLTIMOS:\n')    
    for d in registro[-3:]:
        print(d,'\n')
    print('\n/////////////////////////////////////////////////////////////////////////////////////////////////\n')
    print('TEST DE LA FUNCION DE FILTRAR POR RECOMENDACIÓN')
    for d in test_filtrar_por_recomendado(registro)[:3]:
        print(d,'\n')
    print('\n/////////////////////////////////////////////////////////////////////////////////////////////////\n')
    print('TEST DE LA FUNCION FILTRAR POR RECOMENDACIÓN Y PUNTUACIÓN')
    print(test_filtrar_por_recomendacion_y_puntuacion(registro,True,8))#El csv no contiene bebidas com mas puntuación de 5 por tanto la solución para no mostrar conjunto vacío es mostrar un mensaje que diga que no existe ninguna bebida con esas caracteristicas
    print('\n/////////////////////////////////////////////////////////////////////////////////////////////////\n')
    print('TEST DE LA FUNCIÓN PARA CALCULAR EL NUMERO DE MARCAS DISTINTAS')
    print('El número de marcas distintas es:',test_calcular_numero_marcas_distintas(registro))
    print('\n/////////////////////////////////////////////////////////////////////////////////////////////////\n')
    print('TEST DE LA FUNCIÓN PARA CALCULAR LA MEDIA DE PUNTUACION DE UNA MARCA')
    print(test_calcular_media_puntuacion_por_marca(registro,'California Roots'))  #Probar mas ejemplos como 'Gallo' ,'Apothic'
    print('\n/////////////////////////////////////////////////////////////////////////////////////////////////\n')
    print('TEST DE LA FUNCIÓN PARA CALCULAR LA BEBIDA DE MAXIMO TAMAÑO Y MINIMO TAMAÑO DE ENVASE')
    test_calcular_maximo_minimo_dimensiones_por_longitud(registro)
    print('\n/////////////////////////////////////////////////////////////////////////////////////////////////\n')
    test_obtener_lista_bebidas_puntuacion_ordenadas(registro,4) #El csv no tiene bebidas con puntuacion superior a 5 pero, nos sirve para ordenar por peores bebidas
    print('\n/////////////////////////////////////////////////////////////////////////////////////////////////\n')
    print('TEST PARA OBTENER UN DICCIONARIO POR MARCAS')  
    a=obtener_diccionario_por_marcas(registro) #Muestra solo 3 diccionarios de todos los que puede obtener
    for f in ['Gallo','California Roots','Apothic']:
        print("\t{}: {}".format(f, a[f]),'\n')
    print('\n/////////////////////////////////////////////////////////////////////////////////////////////////\n')
    print('TEST DE LA FUNCION PARA SUMAR LAS PUNTUACIONES POR MARCAS')
    print(calcular_puntuacion_total_por_marca(registro))
    print('\n/////////////////////////////////////////////////////////////////////////////////////////////////\n')
    print('TEST DE LA FUNCIÓN PARA OBTENER LA DIMENSION MAS COMUN DE LAS BEBIDAS QUE TIENEN REGISTRO DE DIMENSIONES')
    print('Las dimensiones más común en las bebidas es:',dimensiones_mas_comunes(registro)[0], '\nCon un numero de:',dimensiones_mas_comunes(registro)[1])
    print('\n/////////////////////////////////////////////////////////////////////////////////////////////////\n')
    print('TEST PARA CREAR UN DICCIONARIO DE LA DIMENSION MAS GRANDE POR MARCA')
    print(dimensiones_mas_grandes_por_marca(registro))
    print('\n/////////////////////////////////////////////////////////////////////////////////////////////////\n')
    print('TEST PARA OBTENER DICC CON LAS TOP N BEBIDAS AGRUPADAS POR MARCA\n')
    print(dicc_top_n_bebidas_por_marca(registro, n=2))
    dibujar_grafica_barras(registro)




def test_lectura(cadena):
        a= lee_reviews(cadena)
        return a  
def test_filtrar_por_recomendado(datos):
    a=filtrar_por_recomendado(datos,False)
    return a
def test_filtrar_por_recomendacion_y_puntuacion(datos,recomendacion,puntuacion):
    puntuacion=float(puntuacion)
    a = filtrar_por_recomendacion_y_puntuacion(datos,recomendacion,puntuacion) 
    if a ==[]:
        a= 'NO EXISTE NINGUNA BEBIDA CON ESAS CARACTERISTICAS'
    return a 
def test_calcular_numero_marcas_distintas(datos):
    a= calcular_numero_marcas_distintas(datos)
    return a 
def test_calcular_media_puntuacion_por_marca(datos,marca):
    a= calcular_media_puntuacion_por_marca(datos,marca)
    print('La media de la marca', marca , 'es:')
    return a
def test_calcular_maximo_minimo_dimensiones_por_longitud(datos):#Devuelve una lista de tuplas pero para el test las he separado para verlas mas claro
    a=calcular_maximo_minimo_dimensiones_por_longitud(datos)
    print('\nEl tamaño máximo es:\n',a[0][0],'\nCuya ficha es:',a[0][1], '\n\nEl tamaño mínimo es:\n', a[1][0],'\nCuya ficha es:',a[1][1])
def test_obtener_lista_bebidas_puntuacion_ordenadas(datos,n):
    a=obtener_lista_bebidas_puntuacion_ordenadas(datos,n)
    print('TEST PARA OBTENER LAS',n, 'PEORES BEBIDAS\n')
    for d in a:
        print(d,'\n')
if __name__=='__main__':
    main()