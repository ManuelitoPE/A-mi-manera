package com.restaurante.amm.amimaneramodel.personal;

public class CuentaUsuario {
    
    private int idCuentaUsuario;
    private String nombreUsuario;
    private String constrasenia;
    private String tipoUsuario;
    
    //CONSTRUCTOR
    
    public CuentaUsuario(){}
    public CuentaUsuario(int idCuentaUsuario, String nombreUsuario,
            String constrasenia, String tipoUsuario){
    
        this.idCuentaUsuario = idCuentaUsuario;
        this.nombreUsuario = nombreUsuario;
        this.constrasenia = constrasenia;
        this.tipoUsuario = tipoUsuario;
    }
    public CuentaUsuario(CuentaUsuario cuentaUsuario){
        this.idCuentaUsuario = cuentaUsuario.idCuentaUsuario;
        this.nombreUsuario = cuentaUsuario.nombreUsuario;
        this.constrasenia = cuentaUsuario.constrasenia;
        this.tipoUsuario = cuentaUsuario.tipoUsuario;
    }
    
    //GETERS Y SETERS

    public int getIdCuentaUsuario() {
        return idCuentaUsuario;
    }

    public void setIdCuentaUsuario(int idCuentaUsuario) {
        this.idCuentaUsuario = idCuentaUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getConstrasenia() {
        return constrasenia;
    }

    public void setConstrasenia(String constrasenia) {
        this.constrasenia = constrasenia;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
}
