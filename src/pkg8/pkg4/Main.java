/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8.pkg4;

import java.io.IOException;
import nu.xom.ParsingException;

/**
 *
 * @author ipgonzalez2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Biblioteca biblioteca;
        try {
        	biblioteca = new Biblioteca( "biblio.xml" );
        	System.out.println( "Arrancando con datos...\n" );
        }
        catch(IOException exc) {
        	biblioteca = new Biblioteca();
        	System.out.println( "Archivo no encontrado. arrancando sin datos...\n" );
        }
        catch(ParsingException exc) {
        	biblioteca = new Biblioteca();
        	System.out.println( "Archivo con errores, arrancando sin datos...\n" );
        }
        if ( biblioteca.getNum() == 0 ) {
    	    biblioteca.inserta( new Libro( "Harry Potter", "J.K.Rowling", 
                    1998) );
	    biblioteca.inserta( new Libro( "No soy un monstruo", "Carmen Chaparro",
                    2017) );
            biblioteca.inserta( new Libro( "Por trece razones", "Jay Asher",
                    2017) );
        }
        try {
            System.out.println( biblioteca );
            System.out.println( "Guardando..." );
            biblioteca.toXML( "biblio.xml" );
        }
        catch(IOException exc) {
        	biblioteca = new Biblioteca();
        	System.out.println( "Archivo no encontrado" );
        }
	}
    }
    

