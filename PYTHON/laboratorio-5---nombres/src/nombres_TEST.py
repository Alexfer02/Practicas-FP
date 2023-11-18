from nombres import *
def main():
    datos=leer_frecuencias_nombres('data/frecuencias_nombres.csv')
    for d in datos[:5]:
        print(d)
    print(test_filtrar_por_genero(datos,'Hombre')[:5])
    print(test_calcular_nombres(datos,None))
    print(test_calcular_top_nombres_de_año(datos,2006,10,'Mujer'))
    print(test_calcular_nombres_ambos_generos(datos))
    '''print(test_calcular_nombres_compuestos(datos,'Mujer'))'''

def test_filtrar_por_genero(lista,genero):
    return filtrar_por_genero(lista,genero)
def test_calcular_nombres(lista,genero):
    return calcular_nombres(lista,genero)
def test_calcular_top_nombres_de_año(nombres, año, limite, genero):
    return calcular_top_nombres_de_año(nombres,año, limite,genero)
def test_calcular_nombres_ambos_generos(nombres):
    return calcular_nombres_ambos_generos(nombres)
'''def test_calcular_nombres_compuestos(nombres, genero):
    calcular_nombres_compuestos(nombres,genero)'''
if __name__ =='__main__':
    main()