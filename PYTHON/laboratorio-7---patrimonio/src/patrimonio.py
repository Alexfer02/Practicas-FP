import csv
from collections import defaultdict, namedtuple
from typing import Counter
from matplotlib import pyplot as plt
Bien= namedtuple('Bien', 'code, name, year, category, country')
def lee_bienes(fichero):
    with open(fichero,encoding='utf-8') as f:
        lector=csv.reader(f)
        next(lector)
        res=[]
        for code,name,year,category,country in lector:
            code= int(code)
            year=int(year)
            tupla=Bien(code,name,year,category,country)
            res.append(tupla)
        return res

def calcula_paises(bien):
    return{b.country for b in bien}

def bienes_por_tipo(bien):
    res=defaultdict(list)
    for b in bien:
        res[b.category].append(b)
    return res

def dibuja_bienes_por_tipo(bien):
    aux=bienes_por_tipo(bien)
    numeros_bienes=[len(aux[a]) for a in aux]
    tipos= list({c.category for c in bien})
    plt.barh(range(len(numeros_bienes)),numeros_bienes,tick_label=tipos)
    plt.show()

def pais_mas_bienes(bien,tipo='Cultural'):
    a=Counter(b.country for b in bien if b.category==tipo)
    pais,frecuencia=max(a.items(),key=lambda x:x[1])
    return (frecuencia,pais)

