from collections import namedtuple
import math
Coordenada = namedtuple('Coordenada','latitud, longitud')
def calcular_distancia(c1,c2):
    return math.sqrt((c1.latitud+c2.latitud)**2+(c1.longitud+c2.longitud)**2)
def calcular_media_coordenadas(lista_coord):
    media_lat=(sum(c.laitud for c in lista_coord))/len(lista_coord)
    media_lon=(sum(c.longitud for c in lista_coord))/len(lista_coord)
    return Coordenada(media_lat,media_lon)