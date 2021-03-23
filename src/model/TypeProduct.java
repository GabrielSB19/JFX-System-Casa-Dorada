package model;

import java.io.Serializable;

public class TypeProduct implements Serializable{
    
    private static final long serialVersionUID = 1;

    private int tpRef;
    private int tpCode;
    private String typeName;
    private boolean typeState;
    private Admin ctpAdmin;
    private Admin mtpAdmin;

    public TypeProduct(int tpRef, int tpCode, String typeName, boolean typeState, Admin ctpAdmin, Admin mtpAdmin) {
        this.tpRef = tpRef;
        this.tpCode = tpCode;
        this.typeName = typeName;
        this.typeState = typeState;
        this.ctpAdmin = ctpAdmin;
        this.mtpAdmin = mtpAdmin;
    }

    public int getTpRef() {
        return tpRef;
    }

    public void setTpRef(int tpRef) {
        this.tpRef = tpRef;
    }
    
    

    public int getTpCode() {
        return tpCode;
    }

    public void setTpCode(int tpCode) {
        this.tpCode = tpCode;
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

    public Admin getCtpAdmin() {
        return ctpAdmin;
    }

    public void setCtpAdmin(Admin ctpAdmin) {
        this.ctpAdmin = ctpAdmin;
    }

    public Admin getMtpAdmin() {
        return mtpAdmin;
    }

    public void setMtpAdmin(Admin mtpAdmin) {
        this.mtpAdmin = mtpAdmin;
    }
    
    @Override
    public String toString(){
        return getTypeName();
    }
}
