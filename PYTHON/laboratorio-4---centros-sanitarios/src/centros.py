from collections import namedtuple
import csv
from coordenadas import *
CentroSanitario=namedtuple('CentroSanitario','nombre,localidad,coordenada,estado,num_camas,acceso_minusvalidos,tiene_uci')
def parse_bool(cadena):
    cadena=cadena.strip()
    if cadena=='true':
        cadena=True
    else:
        cadena=False
    return cadena
def leer_centros(fichero):
    with open(fichero, encoding='utf-8') as f:
        lector=csv.reader(f, delimiter=';')
        next(lector)
        res=[]
        for nombre, localidad, latitud, longitud, estado, num_camas, acceso_minusvalidos, tiene_uci in lector:
            nombre= nombre
            localidad=localidad.strip()
            coordenada=Coordenada(float(latitud),float(longitud))
            estado=estado.strip()#.strip() para eliminar los espacios en blanco
            num_camas= int(num_camas)
            acceso_minusvalidos=parse_bool(acceso_minusvalidos)
            tiene_uci=parse_bool(tiene_uci)
            tupla=CentroSanitario(nombre,localidad,coordenada,estado,num_camas,acceso_minusvalidos,tiene_uci)
            res.append(tupla)
        return res
def calcular_total_camas_centros_accesibles(centros):
    return sum(c.num_camas for c in centros if c.acceso_minusvalidos)
def obtener_centros_con_uci_cercanos_a(centros, punto):
    
    return