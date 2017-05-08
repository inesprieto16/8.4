/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8.pkg4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;
import nu.xom.Serializer;

/**
 *
 * @author ipgonzalez2
 */
public class Biblioteca {
    public static final String TagBiblioteca="biblioteca";
    
    private ArrayList<Libro> libros;
    public Biblioteca(){
        libros=new ArrayList<>();
    }
     public Biblioteca(String nf) throws ParsingException, IOException {
        this();    
        Builder parser = new Builder();
        Document doc = parser.build( new File( nf ) );
        Elements libros = doc.getRootElement().getChildElements();
        for(int i = 0; i < libros.size(); i++) {
            this.inserta(new Libro(libros.get(i)));
        }
    }
     public void inserta(Libro l){
         libros.add(l);
     }
     public int getNum(){
         return libros.size();
     }
     public Libro get(int i)throws Exception{
         if(i<0|| i>getNum()){
             throw new Exception("error");
         }
         else{
             return libros.get(i);
         }
     }
    @Override
     public String toString(){
         StringBuilder toret=new StringBuilder();
         for(int i=0;i<getNum();i++){
             toret.append(libros.get(i).toString()).append("\n");
         }
         return toret.toString();
     }
      public Element toDom(){

       Element toRet = new Element( TagBiblioteca );
        for(int i = 0; i < getNum();i++){
            toRet.appendChild(libros.get(i).toDOM());
        }
        return toRet;
    }
      public void toXML(String nf) throws IOException
    {
        FileOutputStream f = new FileOutputStream( nf );
        Serializer serial = new Serializer( f );
        Document doc = new Document( this.toDom() );
        serial.write(doc);
    }
     
     
}
