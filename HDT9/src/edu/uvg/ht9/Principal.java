/*
* Alina Carías (22539)
* Algoritmos y Estructuras de Datos Sección 40
* Hoja de Trabajo 9
* 21-04-2023
* Clase Principal: clase que interactua con el usuario
*/
package edu.uvg.ht9;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Archivo diccionarioArchivo = new Archivo("./Spanish.txt");
        ArrayList<String> lineasDiccionario = diccionarioArchivo.leerArchivo();

        Archivo oracionesArchivo = new Archivo("./texto.txt");
        ArrayList<String> lineasOraciones = oracionesArchivo.leerArchivo();

        ArrayList<Palabra> diccionario = new ArrayList<>();
        ArrayList<String> palabrasVerificadas = new ArrayList<>();

        String menu = "¿Qué arbol desea utilizar?" + "\n1. Arbol red Black " + "\n2. Arbol Splay" + "\n3. Arbol Binario";
        
        Scanner teclado = new Scanner(System.in);
        IEstructuraArbol<Palabra> arbol = null;

        for (String linea : lineasDiccionario) {
            String[] partes = linea.split(",");
            Palabra palabra = new Palabra(partes[0], partes[1]);
            diccionario.add(palabra);
            palabrasVerificadas.add(palabra.getEnglish());
        }

        try {
            System.out.println(menu);

            int opcion = teclado.nextInt();
            teclado.nextLine();

            factory factoryArbol = new factory();
            arbol = factoryArbol.getInstance(opcion);

            for (Palabra palabra : diccionario) {
                arbol.add(palabra);
            }

            for (String linea : lineasOraciones) {
                String[] palabras = linea.split(" ");
                ArrayList<String> palabrasTraducidas = new ArrayList<>();

                for (String palabra : palabras) {
                    if (palabrasVerificadas.contains(palabra)) {
                        Palabra palabraBuscada = arbol.get(new Palabra(palabra, ""));
                        palabrasTraducidas.add(palabraBuscada.getSpanish());
                    } else {
                        palabrasTraducidas.add("*" + palabra + "*");
                    }
                }

                String lineaTraducida = String.join(" ", palabrasTraducidas);
                System.out.println("Traducción:");
                System.out.println(lineaTraducida);
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Por favor de ingresar solamente datos correctos");
        } finally {
            teclado.close();
        }
    }
}
