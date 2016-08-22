package com.leonel.crimeapp.models;

/**
 * PrecCrimen Model
 *
 * @author APIPlug
 * @version v1.0
 */
public class PrecCrimen {

    private int id_crimen;
    private double nu_lat;
    private double nu_long;
    private String tx_obs;
    private String in_status_proc;
    private String fe_crimen;
    private String fe_proc;
    private int id_delito;
    private String co_usr;
    private String tx_movil;
    private int id_rut_esc;
    private int id_prq;
    private int id_stat_crimen;
    private String tx_direccion;
    private String tx_descripcion;
    private String co_clima;
    private String nu_temperatura;

    public int getId_crimen() {
        return id_crimen;
    }

    public void setId_crimen(int id_crimen) {
        this.id_crimen = id_crimen;
    }

    public double getNu_lat() {
        return nu_lat;
    }

    public void setNu_lat(double nu_lat) {
        this.nu_lat = nu_lat;
    }

    public double getNu_long() {
        return nu_long;
    }

    public void setNu_long(double nu_long) {
        this.nu_long = nu_long;
    }

    public String getTx_obs() {
        return tx_obs;
    }

    public void setTx_obs(String tx_obs) {
        this.tx_obs = tx_obs;
    }

    public String getIn_status_proc() {
        return in_status_proc;
    }

    public void setIn_status_proc(String in_status_proc) {
        this.in_status_proc = in_status_proc;
    }

    public String getFe_crimen() {
        return fe_crimen;
    }

    public void setFe_crimen(String fe_crimen) {
        this.fe_crimen = fe_crimen;
    }

    public String getFe_proc() {
        return fe_proc;
    }

    public void setFe_proc(String fe_proc) {
        this.fe_proc = fe_proc;
    }

    public int getId_delito() {
        return id_delito;
    }

    public void setId_delito(int id_delito) {
        this.id_delito = id_delito;
    }

    public String getCo_usr() {
        return co_usr;
    }

    public void setCo_usr(String co_usr) {
        this.co_usr = co_usr;
    }

    public String getTx_movil() {
        return tx_movil;
    }

    public void setTx_movil(String tx_movil) {
        this.tx_movil = tx_movil;
    }

    public int getId_rut_esc() {
        return id_rut_esc;
    }

    public void setId_rut_esc(int id_rut_esc) {
        this.id_rut_esc = id_rut_esc;
    }

    public int getId_prq() {
        return id_prq;
    }

    public void setId_prq(int id_prq) {
        this.id_prq = id_prq;
    }

    public int getId_stat_crimen() {
        return id_stat_crimen;
    }

    public void setId_stat_crimen(int id_stat_crimen) {
        this.id_stat_crimen = id_stat_crimen;
    }

    public String getTx_direccion() {
        return tx_direccion;
    }

    public void setTx_direccion(String tx_direccion) {
        this.tx_direccion = tx_direccion;
    }

    public String getTx_descripcion() {
        return tx_descripcion;
    }

    public void setTx_descripcion(String tx_descripcion) {
        this.tx_descripcion = tx_descripcion;
    }

    public String getCo_clima() {
        return co_clima;
    }

    public void setCo_clima(String co_clima) {
        this.co_clima = co_clima;
    }

    public String getNu_temperatura() {
        return nu_temperatura;
    }

    public void setNu_temperatura(String nu_temperatura) {
        this.nu_temperatura = nu_temperatura;
    }


}
