package br.edu.unifcv.exceptions;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException() {
        super("Produto não encontrado nos registros do sistema");
    }

}
