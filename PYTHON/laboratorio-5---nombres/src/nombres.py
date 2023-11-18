from collections import namedtuple
import csv
FrecuenciaNombre= namedtuple('FrecuenciaNombre', 'año,nombre,frecuencia,genero')
def leer_frecuencias_nombres(fichero):
    with open(fichero, encoding='utf-8') as f:
        lector=csv.reader(f)
        next(lector)
        res=[]
        for año,nombre,frecuencia,genero in lector:
            año = int(año)
            frecuencia=int(frecuencia)
            tupla=FrecuenciaNombre(año,nombre,frecuencia,genero)
            res.append(tupla)
    return res

def filtrar_por_genero(nombres,genero):
    return [n for n in nombres if n.genero==genero]

def calcular_nombres(nombres,genero=None):
    return {n.nombre for n in nombres if genero== None or n.genero == genero}

def calcular_top_nombres_de_año(nombres, año, limite=10, genero=None):
    año=int(año)
    limite=int(limite)
    lista_genero=[n for n in nombres if año==n.año and genero== None or n.genero == genero]
    lista_genero.sort(key=lambda t:t.frecuencia,reverse=True)
    return [(n.nombre,n.frecuencia)for n in lista_genero][:limite]

def calcular_nombres_ambos_generos(nombres):
    lista_hombres=filtrar_por_genero(nombres,'Hombre')
    lista_mujeres=filtrar_por_genero(nombres,'Mujer')
    setintersection = list(set(lista_hombres) & set(lista_mujeres))
    intersectionmethod = list(set(lista_hombres).intersection(lista_mujeres))
    return{n for n in lista_hombres.intersection(lista_mujeres)}

'''def calcular_nombres_compuestos(nombres, genero):
    lista_nombres=calcular_nombres(nombres,genero)
    return {l for l in lista_nombres if l.contains(' ')}'''