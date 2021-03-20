package model;

public class TypeProduct {

    private int tpCode;
    private String typeName;
    private boolean typeState;
    private Admin ctpAdmin;
    private Admin mtpAdmin;

    public TypeProduct(int tpCode, String typeName, boolean typeState, Admin ctpAdmin, Admin mtpAdmin) {
        this.tpCode = tpCode;
        this.typeName = typeName;
        this.typeState = typeState;
        this.ctpAdmin = ctpAdmin;
        this.mtpAdmin = mtpAdmin;
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

    public boolean isTypeState() {
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
    
    
}
