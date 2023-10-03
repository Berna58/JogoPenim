/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package penimconsole;

/**
 *
 * @author berna
 */

// Esta é a classe da lista iniciando a mesma vazia
public class Lista 
{
    Elemento inicio;

    public Lista() 
    {
        this.inicio = null;
    }
    
    // Este método verifica se a lista esta vazia
    public int size() 
    {
        Elemento aux;
        int numPecas = 0;
        
        if(inicio == null) 
            System.out.println("Lista vazia!");
        
        else 
        {
            aux = inicio;
            
            while(aux != null) {
                aux = aux.next;
                numPecas++;
            }
        }
        return numPecas;
    }
    
    // Este método adiciona uma peça á lista
    public void add(int peca) 
    {
        Elemento novo = new Elemento(peca), aux;
        
        if(inicio == null) // lista vazia
        inicio = novo;
        else 
        {
            aux = inicio;
            while(aux.next != null) // percorre até ao último elemento
                aux = aux.next;
            aux.next = novo;
        }
    }
    
    // Este método verifica se a lista esta ou nao vazia retornando um valor de verdadeiro ou falso respetivamente
    public boolean isEmpty()
    {
        if(inicio == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    // Este método remove uma peça apartir do inicio
    public void remove() 
    {
        if(inicio == null )
        System.out.println("Lista vazia!");
        else
        inicio = inicio.next;
    }



}
