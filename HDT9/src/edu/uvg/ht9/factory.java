/*
* Alina Carías (22539)
* Algoritmos y Estructuras de Datos Sección 40
* Hoja de Trabajo 9
* 21-04-2023
* Clase Factory: crea la factoria general
*/
package edu.uvg.ht9;

public class factory {
    private IEstructuraArbol<Palabra> result;

    public IEstructuraArbol<Palabra> getInstance(int tipo){

        switch(tipo){
            case 1:
            result = new ArbolRedBlack<Palabra>();
            break;
            case 2:
            result = new ArbolSplay<Palabra>();
            break;
            case 3:
            result = new ArbolBinarioBusqueda<Palabra>();
            break;
            default:
            break;
        }
        return result;
    }
}
