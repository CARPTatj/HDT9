package edu.uvg.ht9;

import java.util.ArrayList;
import java.util.Scanner;



public class Principal{
    public static void main(String[] args) {
        Archivo archivo = new Archivo("./Spanish.txt");
        ArrayList<String> lineas = archivo.leerArchivo();
        Archivo archivo1 = new Archivo("./texto.txt");
        ArrayList<String> oraciones = archivo1.leerArchivo();
        ArrayList<Palabra> diccionario = new ArrayList<Palabra>();
        Scanner teclado = new Scanner(System.in);
        factory generador = new factory();
        IEstructuraArbol<Palabra> arbol;
        ArrayList<String> verificar = new ArrayList<String>();

        for(String palabras : lineas){
            String[] palabra = palabras.split(",");
            diccionario.add(new Palabra(palabra[0], palabra[1]));
            verificar.add(palabra[0]);
        }

        try{
            System.out.println("Que tipo de arbol desea usar?: \n1. Arbol red black \n2. Arbol splay \n3. Arbol binario");
            int tipo = teclado.nextInt();
            teclado.nextLine();
            arbol = generador.getIstance(tipo);
            for(Palabra val1 : diccionario){
                arbol.add(val1);
            }
            for(String oracion : oraciones){
                String[] oracionSeparada = oracion.split(" ");
                ArrayList<String> oracionTraducida = new ArrayList<String>();
                String traduccion = "";
                for(String individual : oracionSeparada){
                    if(verificar.contains(individual)){
                        Palabra val2 = arbol.get(new Palabra(individual, ""));
                        oracionTraducida.add(val2.getSpanish());
                    }
                    else{
                        String val3 = "*"+individual+"*";
                        oracionTraducida.add(val3); 
                    }

                }
                for(String palabra : oracionTraducida){
                    traduccion = traduccion + palabra+ " ";
                }
                System.out.println("Oración traducida: ");
                System.out.println(traduccion+"\n");
            }

        } catch (Exception e){
            teclado.nextLine();
            System.out.println("Ingreso algo incorrecto");
        }

        
    }
}
