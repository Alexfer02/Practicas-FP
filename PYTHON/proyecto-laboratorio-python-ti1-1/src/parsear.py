from datetime import datetime
def parse_datetime(cadena, formato = '%Y-%m-%d'):
    bueno=cadena.split('T')[0]
    if bueno=='':
        sol=None
    else:
       sol = datetime.strptime(bueno, formato).date()
    return sol
def parse_bool(cadena):
    if cadena == 'no'or cadena=='FALSE':
        booleano = False
    elif cadena=='':
        booleano=None
    else:
        booleano = True
    return booleano
def parse_float(cadena):
    if cadena=='':
        cadena=None
    else:
        cadena=float(cadena)
    return cadena
def parse_str(cadena):
    if cadena=='':
        cadena=None
    else:
        str(cadena)
    return cadena

def parse_dime(cadena):
    if cadena!='':
        length,width, height, _ = cadena.split(' in')
        dimensiones=(float(length), float(width.strip(' x ')), float(height.strip(' x ')))
    else:
         dimensiones= None
    return dimensiones