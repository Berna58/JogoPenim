/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package penimconsole;

/**
 *
 * @author berna
 */

// Esta é a classe responsável por representar o elemento (peça) assim como uma referência para a proxima peça
public class Elemento 
{
    int obj;
    Elemento next;
    
    public Elemento(int o) 
    {
        obj = o;
        next = null;
    }
}

