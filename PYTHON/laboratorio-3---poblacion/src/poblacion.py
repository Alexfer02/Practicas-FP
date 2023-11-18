import csv
from collections import namedtuple
def lee_poblaciones(fichero):
    with open(fichero, encoding='utf-8') as f :
        lector = csv.reader(f)
        Poblacion = namedtuple('Poblacion','nombre_pais,cod_pais,anyo,num_habitantes')
        poblaciones = []
        for nombre_pais,cod_pais,anyo,num_habitantes in lector:
            nombre_pais = nombre_pais
            cod_pais=cod_pais
            anyo=int(anyo)
            num_habitantes=int(num_habitantes)
            tupla=Poblacion(nombre_pais,cod_pais,anyo,num_habitantes)
            poblaciones.append(tupla)
    return poblaciones

def calcula_paises(poblaciones):
    return sorted({pais for pais,_,_,_ in poblaciones})
    

def filtra_por_pais(poblaciones, pais):
    return [(p.anyo, p.num_habitantes) for p in poblaciones if pais==p.nombre_pais or pais==p.cod_pais]

def filtra_por_paises_y_anyo(poblaciones, anyo, paises):
   lista_paises=[p for p in poblaciones if p.nombre_pais in paises]
   anyo=int(anyo)
   return [(p.nombre_pais, p.num_habitantes) for p in lista_paises if anyo==p.anyo]