from extranjeria import *
def main():
    datos = lee_datos_extranjeros('data/extranjerosSevilla.csv')
    print("Se han cargado los datos", len(datos), "registros.")
    print("Mostrando los 3 primeros")
    for r in datos[:3]: #para poner solo los 3 primero se llama slide
        print("\t", r)
    test_numero_nacionalidades_distintas(datos)
    test_secciones_distritos_con_extranjeros_nacionalidades(datos)
    test_total_extranjeros_por_pais(datos)
    test_top_n_extranjeria(datos)
    test_barrio_mas_multicultural(datos)
    test_barrio_con_mas_extranjeros(datos)
    #test_agrupar_por_barrio(datos)

def test_numero_nacionalidades_distintas(datos):
    print("\n\n TEST de la funcion numero_nacionalidades_distintas")
    print("Hay,", numero_nacionalidades_distintas(datos), "nacionalidades distintas")
    print("==============================")

def test_secciones_distritos_con_extranjeros_nacionalidades(datos):
    print("\n\n TEST de la funcion secciones_distritos_con_extranjeros_nacionalidades")
    paises={'ALEMANIA', 'ITALIA'}
    print("\n\n Los distritos que tienen extranjeros de alguna de las nacionalidades", paises, "son:")
    print(secciones_distritos_con_extranjeros_nacionalidades(datos,paises))
    print("Los distritos que tienen extranjeros de alguna de las nacionalidades SANTA SEDE son")
    print("==============================")

def test_total_extranjeros_por_pais(datos):
    print("Extranjeros totales por pais:")
    print(total_extranjeros_por_pais(datos))
    print("==============================")

def test_top_n_extranjeria(datos):
    print("El top-3 es: ")
    print(top_n_extranjeria(datos,n=3))
    print("==============================")

def test_barrio_mas_multicultural(datos):
    print("El barrio con mas inmigrantes  es:")
    print(barrio_mas_multicultural(datos))
    print("==============================")

def test_agrupar_por_barrio(datos):
    print("\n\n Los paises más representados en cada distrito son")
    print(agrupar_por_barrio(datos))
    print("==============================")

def test_barrio_con_mas_extranjeros(datos):
    print("El barrio con mas inmigrantes Hombres es:")
    print(barrio_con_mas_extranjeros(datos,tipo="Hombres"))
    print("El barrio con mas inmigrantes Mujeres es:")
    print(barrio_con_mas_extranjeros(datos,tipo="Mujeres"))

if __name__ == '__main__':
    main()