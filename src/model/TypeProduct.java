/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TypeProduct {
    
    private String typeName;
    private boolean typeState;
    private Admin ctpAdmin;
    private Admin mtpAdmin;

    public TypeProduct(String typeName, boolean typeState) {
        this.typeName = typeName;
        this.typeState = typeState;
        this.ctpAdmin = ctpAdmin;
        this.mtpAdmin = mtpAdmin;
        
        
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean getTypeState() {
        return typeState;
    }

    public void setTypeState(boolean typeState) {
        this.typeState = typeState;
    }
    

}
