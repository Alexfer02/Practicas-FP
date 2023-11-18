from collections import defaultdict, namedtuple, Counter
import csv
from matplotlib import pyplot as plt
from matplotlib.text import OffsetFrom
Pregunta= namedtuple('Pregunta','puntuacion, titulo, año, etiqueta')
def leer_preguntas(fichero):
    with open (fichero, encoding='utf-8') as f:
        lector=csv.reader(f)
        next(lector)
        res=[]
        for score,title,year,tag in lector:
            score=int(score)
            year=int(year)
            tupla=Pregunta(score,title,year,tag)
            res.append(tupla)
    return res

def filtrar_por_año(datos,año):
    return [d for d in datos if año==d.año]

def calcular_etiquetas(datos):
    return {d.etiqueta for d in datos}

def calcular_preguntas_mejor_valoradas(datos,n):
    return sorted(((d.titulo,d.puntuacion) for d in datos), key=lambda t:t[1],reverse=True)[:n]

def contar_etiquetas(datos):
    return Counter(d.etiqueta for d in datos)

def mostrar_distribucion_etiquetas(datos,etiquetas):
    conteo=contar_etiquetas(datos)
    tamaños=[conteo[c] for c in etiquetas ]
    plt.pie(tamaños, labels=etiquetas, autopct='%1.1f%%', shadow=True, startangle=90)
    plt.legend()
    plt.show()

def calcular_palabras_clave(titulo, stopwords):
    titulo=titulo.lower()
    terminos=titulo.split()
    terminos=[t.strip('¿?[](){}¡!-+/*,;.<>=') for t in terminos]
    terminos = [t for t in terminos if t.isalpha()]
    terminos = [t for t in terminos if t not in stopwords]
    return terminos

def contar_palabras_calve(preguntas,stopwords):
    contador=Counter()
    for t in preguntas:
      contador.update(calcular_palabras_clave(t.titulo,stopwords))  
    return contador

def agrupar_preguntas_por_año(preguntas):
    res=defaultdict(list)
    for p in preguntas:
        res[p.año].append(p)
    return res

def mostrar_evolucion_etiquetas(preguntas,etiquetas):
    preguntas_por_año=agrupar_preguntas_por_año(preguntas)
    años=sorted(preguntas_por_año.keys())
    contador_por_año_y_etiqueta=dict()
    for a in años:
        contador_por_año_y_etiqueta[a]=contar_etiquetas(preguntas_por_año[a])
    evoluciones=[]
    evolucion=[]
    for e in etiquetas:
        '''for a in años:
        evolucion=[contador_por_año_y_etiqueta[a][e]]'''
        evolucion=[contador_por_año_y_etiqueta[a][e] for a in años]
        evoluciones.append(evolucion)
    for etiqueta, evolucion in zip(etiquetas, evoluciones):
        plt.plot(evolucion, label=etiqueta)
        plt.xticks(range(len(años)), años, rotation=80, fontsize=10)
        plt.legend()
    plt.show()