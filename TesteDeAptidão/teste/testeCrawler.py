
from bs4 import BeautifulSoup
from urllib.request import urlopen as uReq


listaTitulos = []
listaVizu = []
listaFinal = []
def processamentoListas(listaTitulos, listaVizu):

    for j in range(0, listaVizu.__len__() -1):
        for i in range(0, listaVizu.__len__() -1):
            if (listaVizu[i] < listaVizu[i+1]):
                temp1 = listaVizu[i]
                listaVizu[i] = listaVizu[i+1]
                listaVizu[i+1] = temp1
                temp2 = listaTitulos[i]
                listaTitulos[i] = listaTitulos[i+1]
                listaTitulos[i+1] = temp2
    
    x = 0
    for nome in listaTitulos:
        listaFinal.append (listaTitulos[x] + " - " + str(listaVizu[x]))
        x+=1
    
    return listaFinal       


def videoCrawler():
    
    url = 'https://www.youtube.com/results?search_query=Chit%C3%A3ozinho+e+Choror%C3%B3&sp=QgIIAQ%253D%253D'
    
    codigoFonte = uReq(url)
    texto = codigoFonte.read()
    codigoFonte.close()
    soup = BeautifulSoup(texto, "html.parser")
    
    

    for group in soup.findAll("div", {'class': 'yt-lockup-content'}):
        
        #putamerda
        listaTitulos.append(group.h3.a.get('title'))
        
        aManipular = (group.ul.li.find_next().text)
        aManipular = aManipular.replace(' visualizações', '')
        aManipular = aManipular.replace('.', '')
        listaVizu.append(int(aManipular))
        
    processamentoListas(listaTitulos, listaVizu)
    
    for item in listaFinal:
        print(item)    
    


try :
    videoCrawler()
except AttributeError:
    videoCrawler()       

