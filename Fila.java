/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pierrote
 */
public interface Fila {
    
    
    int comprimento();
    int pecas();
    Peca peca(int pos) throws IndexOutOfBoundsException;
    
}
