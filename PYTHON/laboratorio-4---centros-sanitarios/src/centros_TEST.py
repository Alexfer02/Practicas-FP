from centros import *
def main():
    registros= leer_centros('data\centrosSanitarios.csv')
    test_lee_centros(registros)
    test_calcular_total_camas_centros_accesibles(registros)
def test_lee_centros(datos):
    print('Leidos', len(datos))
    print('Mostrando los tres primeros:')
    for d in datos[:3]:
        print(d)
    print('Mostrando los tres últimos:')
    for d in datos[-3:]:
        print(d)
def test_calcular_total_camas_centros_accesibles(centros):
    b = calcular_total_camas_centros_accesibles(centros)
    print('Hay', b, 'camas disponibles')
if __name__=='__main__':
    main()