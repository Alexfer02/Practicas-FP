from patrimonio import *
def main():
    bien=lee_bienes('data\whs.csv')
    print('SE HAN LEIDO:', len(bien))
    print('======================================================================\n')
    test_calcula_paises(bien)
    test_bienes_por_tipo(bien)
    dibuja_bienes_por_tipo(bien)
    print(pais_mas_bienes(bien))
    print('======================================================================\n')

def test_calcula_paises(bien):
    print('LOS PAISES QUE APARACEN SON :',calcula_paises(bien))
    print('======================================================================\n')
     
def test_bienes_por_tipo(bien):
    print('Estos son los tipos de bienes:', bienes_por_tipo(bien))
    print('======================================================================\n')
if __name__=='__main__':
    main() 