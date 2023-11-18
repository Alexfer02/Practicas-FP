import csv
from string import punctuation
from matplotlib import pyplot as plt
from collections import Counter
from parsear import * #Importamos todas las funciones definidas en el archivo parsear para darle formato a las distintas columnas de datos del csv.
from collections import defaultdict, namedtuple 
Review = namedtuple('Review','marca,dimensiones,nombre, fecha_revision, recomendado,puntuacion,texto')
def lee_reviews(fichero):# definimos la función para poder llamarla en el archivo de TEST
    with open(fichero) as f: #Abrimos el fichero por defecto en 'UTF-8'
        lector = csv.reader(f,delimiter=';') #Utilizando la librería csv obtenemos el lector que leerá cada una de las líneas del csv y al estar delimitadas en un formato csv con; utilizamos el delimiter con el valor de ;
        next(lector)#utilizado para saltar la cabecera del fichero ya que no contiene datos los cuales nos vayan a servir
        res = [] #Creamos una lista para almacenar más tarde las tuplas nombrada con el paquete importado de collections llamado namedtuple
        for marca,dimensiones,nombre, fecha_revision, recomendado,puntuacion,texto in lector: #bucle for para recorrer todas las líneas del csv
            dimensiones= parse_dime(dimensiones)
            fecha_revision=parse_datetime(fecha_revision,formato = '%Y-%m-%d')
            recomendado= parse_bool(recomendado)
            puntuacion= parse_float(puntuacion)
            texto=parse_str(texto)
            tupla=Review(marca,dimensiones,nombre,fecha_revision,recomendado,puntuacion,texto)# creamos una tupla con el parametro Review de namedtuple
            res.append(tupla)#añadimos la tupla a lista
        return res# devolvemos la lista de tuplas con los datos del fichero
#---------------------BLOQUE 1---------------------
#FUNCIÓN 1
def filtrar_por_recomendado(datos,recomendacion=True): #Recibe como parametros una lista de tuplas de tipo Review y un parametro de valor Bool por defecto en True y devuelve una lista de tuplas que cumplan con la recomendación
    return [d for d in datos if d.recomendado ==recomendacion]
#FUNCIÓN 2
def filtrar_por_recomendacion_y_puntuacion(datos,recomendacion=True,puntuacion=None): #Recibe como parametros una lista de tuplas de tipo Review, un parametro recomendacion y un puntuacion y devuelve una lista de tuplas con las bebidas que cumplan la recomendación y la puntuación indicada
    return [d for d in datos if d.recomendado== recomendacion and puntuacion == None or d.puntuacion == puntuacion]
#FUNCIÓN 3
def calcular_numero_marcas_distintas(datos): #Recibe como parametro una lista de tuplas de tipo Review y devuelve un int con el numero de marcas distintas
    return len({d.marca for d in datos})
#FUNCIÓN 4
def calcular_media_puntuacion_por_marca(datos,marca): #Recibe como parametros una lista de tuplas de tipo Review y una marca de tipo String y devuelve un valor float con la media de las puntuaciones de la marca
    lista_marcas =[d.puntuacion for d in datos if d.marca == marca]
    return sum(lista_marcas)/len(lista_marcas)
#---------------------BLOQUE 2---------------------
#FUNCIÓN 5
def calcular_maximo_minimo_dimensiones_por_longitud(datos): #Recibe como parametro una lista de tuplas de tipo Review y devuelve una tupllon el valor maximo y minimo de los tamaños de botellas
    lista_dimensiones=[]
    for d in datos:
        if d.dimensiones != None:
            lista_dimensiones.append([d.dimensiones,d])
    return (max(lista_dimensiones,key=lambda t:t[0]),min(lista_dimensiones,key=lambda t:t[0]))
#FUNCIÓN 6
def obtener_lista_bebidas_puntuacion_ordenadas(datos,n=3): #Recibe como parametro una lista de tuplas de tipo Review y devuelve una lista ordenada de tipo review por puntuación
    return sorted([d for d in datos if d.puntuacion != None],key=lambda t:t.puntuacion)[:n]#Para obtener en orden mayor ponemos el parametro reverse = True
#FUNCIÓN 7
def obtener_diccionario_por_marcas(datos):# Recibe como parametro una lista de tuplas de tipo Review y devuelve un diccionario con las bebidas oredenadas por marcas
    res=defaultdict(set)
    for a in datos:
        res[a.marca].add(a)
    return res

#---------------------BLOQUE 3---------------------

#FUNCIÓN 8 
def calcular_puntuacion_total_por_marca(datos): #Recibe como parametro una lista de tuplas de tipo Review y devuelve un diccionario con la puntuacion total agrupadas por marcas
    res={}
    for dato in datos:
        clave=dato.marca
        if clave in res:
            if dato.puntuacion!= None:
                res[clave].append(dato.puntuacion)
        else:
            if dato.puntuacion!= None:
                res[clave]=[float(dato.puntuacion)]  #Para crear una registro clave valor en el diccionario, llamamos al diccionario comentando entre en corchetes la clave 
                # así creamos la clave en el diccionario con el valor de la marca, luego para inicializar el valor de la clave pasamos a float el valor
                # de la puntuacion que la podemos obtener al hacer un bucle for y guardar la puntuacion del dato correspondiente al primer registro que aparezca con una marca no almacenada
    dic=dict()
    for marca, puntuacion in res.items():
        dic[marca]=sum(puntuacion)/len(puntuacion)
    return dic


#FUNCIÓN 10
def dimensiones_mas_comunes(datos):#Recibe como parametro una lista de tuplas de tipo Review y devuelve las medidas de la dimension mas comun y el número de veces que aparece en un diccionario de tipo Counter, contando el número de bebidas que tienen esas dimensiones
    return Counter(d.dimensiones for d in datos if d.dimensiones != None).most_common(1)[0]


#FUNCION 12
def dimensiones_mas_grandes_por_marca(datos): #Recibe como parametro una lista de tuplas de tipo Review y devuelve un diccionario con clave marca y valor la maxima dimension de la bebida
    res=defaultdict(list)
    for d in datos:
        if d.dimensiones!=None:
            res[d.marca].append(d.dimensiones)
    dic=dict()
    for marca,bebida in res.items():
        dic[marca]=max(bebida,key=lambda d:(d[0]*d[1]*d[2]))
    return dic

#FUNCION 14
def dicc_top_n_bebidas_por_marca(datos, n=1): #Recibe como parametro una lista de tuplas de tipo Review y devuelve un diccionario con las top n bebidas agrupadas por marca 
    bebidas_por_marca=defaultdict(list)
    for d in datos:
        bebidas_por_marca[d.marca].append(d)
        
    res={}
    for marca,bebida in bebidas_por_marca.items():
        res[marca]=[(v.puntuacion,v.nombre) for v in bebida[:n]]
    return res

#---------------------BLOQUE 4---------------------
def dibujar_grafica_barras(datos): #Recibe como parametro una lista de tuplas de tipo Review y imprime en pantalla un grafico de pastel con el numero de bebidas recomendadas
    res={}
    for d in datos:
        clave=d.recomendado
        if clave!=None:
            if clave in res:
                res[clave]+=1
            else:
                res[clave]=1
        else:
            clave='Ningún dato'
            if clave in res:
                res[clave]+=1
            else:
                res[clave]=1

    etiquetas=[]
    valores=[]
    print(res)
    for m,v in res.items():
        etiquetas.append(m) 
        valores.append(v)
    plt.title('Grafica de recomendación')
    colores = ["#EE6055","#60D394","#AAF683"]
    plt.pie(valores, labels=etiquetas, autopct='%1.1f%%', shadow=True, startangle=90,colors=colores)
    plt.legend()
    plt.axis("equal")
    plt.show()