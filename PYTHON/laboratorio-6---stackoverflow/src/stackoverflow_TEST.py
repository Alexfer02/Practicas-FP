from stackoverflow import *
def main():
    print('TEST LECTURA')
    preguntas=leer_preguntas('data\stackoverflow_python_questions.csv')
    for d in preguntas[:5]:
        print(d)
    print('//////////////////////////////////////////////////////////\n')
    print('FUNCIÓN FILTRAR POR AÑO')
    for d in test_filtrar_por_año(preguntas,2008)[:5]:
        print(d)
    print('//////////////////////////////////////////////////////////\n')
    print('FUNCIÓN CALCULAR ETIQUETAS')
    print(calcular_etiquetas(preguntas))
    print('//////////////////////////////////////////////////////////\n')
    print('FUNCIÓN CALCULAR PREGUNTAS MEJOR VALORADAS')
    print(calcular_preguntas_mejor_valoradas(preguntas,7))
    print('//////////////////////////////////////////////////////////\n')
    print('FUNCIÓN CONTAR ETIQUETAS')
    print(contar_etiquetas(preguntas))
    print('///////////////////////////////////////////////////////////\n')
    '''mostrar_distribucion_etiquetas(preguntas,['list','file','string'])'''
    test_calcular_palabras_calve(preguntas)
    print('///////////////////////////////////////////////////////////\n')
    print(list(contar_palabras_calve(preguntas,lee_stopwords()).items())[:10])
    '''test_agrupar_preguntas_por_año(preguntas)'''
    mostrar_evolucion_etiquetas(preguntas,['list','file','string'])




def test_filtrar_por_año(datos,año):
    a= filtrar_por_año(datos,año)
    return a

def test_calcular_palabras_calve(preguntas):
    stopwords=lee_stopwords()
    titulo= preguntas[0].titulo
    print('PALABRAS CLAVE DEL TÍTULO :', titulo)
    print(calcular_palabras_clave(titulo,stopwords))
    print('///////////////////////////////////////////////////////////\n')

def test_agrupar_preguntas_por_año(preguntas):
    a=agrupar_preguntas_por_año(preguntas)
    print('LAS PREGUNTAS POR AÑO SON:',a.items())

def lee_stopwords():
    with open('data\stopwords.txt', encoding='utf-8') as f:
        res=[]
        for linea in f:
            res.append(linea.strip())
        return res
if __name__=='__main__':
    main()