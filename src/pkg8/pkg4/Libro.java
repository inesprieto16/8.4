/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8.pkg4;

import java.util.*;
import java.lang.*;
import java.io.*;
import nu.xom.*;

/**
 *
 * @author ipgonzalez2
 */
public class Libro {
    public static final String TagLibro="libro";
    public static final String TagTitulo="titulo";
    public static final String TagAutor="autor";
    public static final String TagAño="año";
    
    private String titulo;
    private String autor;
    private int año;

    public Libro(String titulo, String autor, int año) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
    }
     public Libro(Element e) throws ParsingException {
        Element titulo = e.getFirstChildElement( TagTitulo);
        Element autor = e.getFirstChildElement( TagAutor);
        Element año = e.getFirstChildElement( TagAño);
        if ( titulo == null ) {
            throw new ParsingException( "Falta el titulo en el elemento libro" );
        }
        if ( autor == null ) {
            throw new ParsingException( "Falta el autor en el elemento libro" );
        }
        if ( año == null ) {
            throw new ParsingException( "Falta el año en el elemento libro" );
        }
        this.titulo = titulo.getValue().trim();
        this.autor = autor.getValue().trim();
        try{
                this.año = Integer.parseInt(año.getValue().trim());
        }catch(NumberFormatException exc)
        {
                throw new ParsingException("Valor incorrecto para el año");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    @Override
    public String toString(){
        return String.format("Titulo: %s"+ "\nAutor: %s"+"\nAño: %d",getTitulo(),getAutor(),getAño());
    }
    public Element toDOM(){
        Element raiz = new Element ( TagLibro );
        Element titulo1 = new Element ( TagTitulo );
        Element autor1 = new Element( TagAutor );
        Element año1 = new Element ( TagAño );
        titulo1.appendChild(titulo);
        autor1.appendChild(autor);
        año1.appendChild(Integer.toString(año));
        raiz.appendChild(titulo1);
        raiz.appendChild(autor1);
        raiz.appendChild(año1);
        return raiz;
    }
    
    
    
    
}
