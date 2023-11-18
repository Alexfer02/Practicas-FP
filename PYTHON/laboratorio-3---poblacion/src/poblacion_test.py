from poblacion import*
def main():
    datos=lee_poblaciones('data/population.csv')
    print("Se han leido", len(datos), "registros")
    print('TEST lee_poblacion')
    print("Mostrando los 20 primeros")
    for d in datos[:20]:
        print(d)
    print('////////////////////////////////////////////////////////') 
    print(calcula_paises(datos))
    print('////////////////////////////////////////////////////////') 
    print(filtra_por_pais(datos,'Euro area'))
    print('////////////////////////////////////////////////////////') 
    print(filtra_por_paises_y_anyo(datos,'1980',('Euro area','Italia','Morocco')))
    
if __name__ == '__main__':
    main()