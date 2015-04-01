/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Thibaut
 */
public class DummyException extends Exception {
    private String nomOperation;

    public DummyException(String nomOperation, String message) {
        super(message);
        this.nomOperation = nomOperation;
    }

    public String getNomOperation() {
        return nomOperation;
    }

    public void setNomOperation(String nomOperation) {
        this.nomOperation = nomOperation;
    }

}
