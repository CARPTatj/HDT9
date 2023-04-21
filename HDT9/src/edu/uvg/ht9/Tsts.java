/*Test tomados del repositiorio de moises */

package edu.uvg.ht9;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.uvg.ht9.ArbolHashMap;
import edu.uvg.ht9.IKeyGenerator;
import edu.uvg.ht9.ObtenerLlaveDesdePalabra;
import edu.uvg.ht9.Palabra;
import java.util.HashMap;
import edu.uvg.ht9.ComparadorPalabras;
import edu.uvg.ht9.Palabra;
import edu.uvg.ht9.ArbolBinarioBusqueda;
import edu.uvg.ht9.*;
import structure5.SplayTree;


public class Tsts {

    @Test
	void testhashmap() {
		IKeyGenerator<String, Palabra> miExtractor = new ObtenerLlaveDesdePalabra<String, Palabra>();
		ArbolHashMap<String, Palabra> miDiccionario = new ArbolHashMap<String, Palabra>(miExtractor);
		
		miDiccionario.add(new Palabra("house", "casa"));
		miDiccionario.add(new Palabra("window", "ventana"));
		miDiccionario.add(new Palabra("dog", "perro"));
		
		Palabra miBusqueda = miDiccionario.get(new Palabra("house", ""));
		
		assertEquals("house", miBusqueda.getEnglish());
		assertEquals("casa", miBusqueda.getSpanish());
		
	}

    void testBinarytree() {
		ArbolBinarioBusqueda<Palabra> miDiccionario = new ArbolBinarioBusqueda<Palabra>(new ComparadorPalabras<Palabra>());
		
		miDiccionario.add(new Palabra("dog", "perro"));
		miDiccionario.add(new Palabra("house", "casa"));
		miDiccionario.add(new Palabra("window", "ventana"));
		
		
		Palabra mibusqueda = miDiccionario.get(new Palabra("house", ""));
		
		assertEquals("house", mibusqueda.getEnglish());
		assertEquals("casa", mibusqueda.getSpanish());

	}

    void testSplayTreePalabra() {
		SplayTree<Palabra> miDiccionario = new SplayTree<Palabra>(new ComparadorPalabras<Palabra>());
		
		miDiccionario.add(new Palabra("dog", "perro"));
		miDiccionario.add(new Palabra("house", "casa"));
		miDiccionario.add(new Palabra("window", "ventana"));
		
		
		Palabra mibusqueda = miDiccionario.get(new Palabra("house", ""));
		
		assertEquals("house", mibusqueda.getEnglish());
		assertEquals("casa", mibusqueda.getSpanish());
		
	}

    void InsertionRedBlackTree() {
		RedBlackSearchTree<Palabra> miDiccionario = new RedBlackSearchTree<Palabra>();
		
		miDiccionario.add(new Palabra("dog", "perro"));
		miDiccionario.add(new Palabra("house", "casa"));
		miDiccionario.add(new Palabra("window", "ventana"));
		
		Palabra miBusqueda = miDiccionario.get(new Palabra("house", ""));
		
		assertEquals("house", miBusqueda.getEnglish());
		assertEquals("casa", miBusqueda.getSpanish());
				
		
		
	}

    void test() {
		SplayTree<String> mySplayTree = new SplayTree<String>();
		
		mySplayTree.add("1");
		mySplayTree.add("2");
		mySplayTree.add("3");
		mySplayTree.add("4");

		mySplayTree.get("2");
		mySplayTree.get("2");
		
	}
}
