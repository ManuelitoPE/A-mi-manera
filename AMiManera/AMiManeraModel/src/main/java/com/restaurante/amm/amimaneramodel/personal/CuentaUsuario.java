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

    /**
     * @return the idCuentaUsuario
     */
    public int getIdCuentaUsuario() {
        return idCuentaUsuario;
    }

    /**
     * @param idCuentaUsuario the idCuentaUsuario to set
     */
    public void setIdCuentaUsuario(int idCuentaUsuario) {
        this.idCuentaUsuario = idCuentaUsuario;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the constrasenia
     */
    public String getConstrasenia() {
        return constrasenia;
    }

    /**
     * @param constrasenia the constrasenia to set
     */
    public void setConstrasenia(String constrasenia) {
        this.constrasenia = constrasenia;
    }

    /**
     * @return the tipoUsuario
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * @param tipoUsuario the tipoUsuario to set
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
}
