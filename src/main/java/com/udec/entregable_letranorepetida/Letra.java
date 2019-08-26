/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.entregable_letranorepetida;

import java.util.Scanner;
/**
 *
 * @author michl
 */

/**
 *
 * @author Michael Cardenas
 * clase que tiene los metodos logicos para resolver el problema
 */
public class Letra {
    
    
    /**
     * variable global que guarda la frase dada por el usuario
     */
    private String palabra;
    
    /**
     * constructor vacio de la clase que inicializa el objeto
     */
    public Letra(){
    }
    
    /**
     * metodo publico usado para pedir la frase al usuario y guardarla en la variable palabra.
     */
    public void solicitarFrase(){
        Scanner entrada = new Scanner(System.in);
        char opcion = ' ';
        do{
            System.out.println("¿Palabra o frase? ");
            palabra = entrada.nextLine();
            
            hallarLetras(palabra);
            
            System.out.println("¿Quiere evaluar otra palabra? s/n ");
            opcion = entrada.nextLine().charAt(0);
        }while(opcion=='s');
    }
    
    /**
     * 
     * @param frase se recibe la variable llena con la frase que digito el usuario
     * 
     * metodo usado para calcular las letras este a su vez llama mas metodos
     */
    
    private void hallarLetras(String frase){
        short bandera=0;
        char letraActual = frase.charAt(0);
        
        for(short i=0;i<frase.length();i++){
            System.out.println("Leyendo......" + frase.charAt(i));
            if(bandera==0){
                letraActual = frase.charAt(i);
                bandera=1;
            }else{
                if(letraActual==frase.charAt(i)){
                    letraActual = validarCaracteres(letraActual,i,frase);
                }
                if(letraActual=='A'){
                    letraActual = validarRepetidas(frase.charAt(i),frase);
                }
            }
            if(letraActual=='A'){
                System.out.println("Todas las letras se repiten");
            }else{
                System.out.println("La primera letra que no se repite es la " + letraActual);
            }
        }
    }
    
    /**
     * metodo que se usa para calcular la siguiente letra que no se repite 
     * @param letraActual guarda la letra que se esta evaluando actualmente
     * @param iterador guarda la iteracion actual para continuar iterando desde esa posicion
     * @param frase guarda la frase que digito el usuario y que es necesaria para extraer la posicion para compararla con la letra actual
     * @return retorna un caracter especifico para validarlo en un if en el metodo que invoca este metodo
     */
    private char validarCaracteres(char letraActual,short iterador,String frase){
        
        short aux = 0;
        for(short i=0;i<iterador;i++){
            if(letraActual!=frase.charAt(i)){
                aux=1;
                for(short j=0;j<iterador;j++){
                    if(frase.charAt(i)==frase.charAt(j)){
                        aux++;
                    }
                }
                if(aux!=1){
                    return frase.charAt(i);
                }
            }
        }
        return 'A';
    }
    
    /**
     * determina la nueva primera letra cuando ya estan las demas repetidas
     * @param letraActual guarda la letra actual que se esta leyendo en el metodo donde se invoca
     * @param frase contiene la frase dada por el usuuario para compararla con la letra actual.
     * @return  devuelve la nueva primera letra siguiente
     */
    private char validarRepetidas(char letraActual,String frase){
        short contador = 0;
        char[]aux = frase.toCharArray();
        for(char i:aux){
            if(i==letraActual){
                contador++;
            }
        }
        if(contador==1){
            return  letraActual;
        }
        else{
            return 'B';
        }
    }
}  



 