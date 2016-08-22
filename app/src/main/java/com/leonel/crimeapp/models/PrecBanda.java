package com.leonel.crimeapp.models;

/**
 * PrecBanda Model
 *
 * @author APIPlug
 * @version v1.0
 */
public class PrecBanda {

    private int id_banda;
    private String nb_banda;
    private int nu_mienbro_est;
    private int nu_cedula_cabecilla;
    private String co_estado_opera;
    private String co_munc_opera;
    private String co_prq_opera;
    private String id_pobl;
    private String co_sct;
    private String tx_alias_cab;

    public int getId_banda() {
        return id_banda;
    }

    public void setId_banda(int id_banda) {
        this.id_banda = id_banda;
    }

    public String getNb_banda() {
        return nb_banda;
    }

    public void setNb_banda(String nb_banda) {
        this.nb_banda = nb_banda;
    }

    public int getNu_mienbro_est() {
        return nu_mienbro_est;
    }

    public void setNu_mienbro_est(int nu_mienbro_est) {
        this.nu_mienbro_est = nu_mienbro_est;
    }

    public int getNu_cedula_cabecilla() {
        return nu_cedula_cabecilla;
    }

    public void setNu_cedula_cabecilla(int nu_cedula_cabecilla) {
        this.nu_cedula_cabecilla = nu_cedula_cabecilla;
    }

    public String getCo_estado_opera() {
        return co_estado_opera;
    }

    public void setCo_estado_opera(String co_estado_opera) {
        this.co_estado_opera = co_estado_opera;
    }

    public String getCo_munc_opera() {
        return co_munc_opera;
    }

    public void setCo_munc_opera(String co_munc_opera) {
        this.co_munc_opera = co_munc_opera;
    }

    public String getCo_prq_opera() {
        return co_prq_opera;
    }

    public void setCo_prq_opera(String co_prq_opera) {
        this.co_prq_opera = co_prq_opera;
    }

    public String getId_pobl() {
        return id_pobl;
    }

    public void setId_pobl(String id_pobl) {
        this.id_pobl = id_pobl;
    }

    public String getCo_sct() {
        return co_sct;
    }

    public void setCo_sct(String co_sct) {
        this.co_sct = co_sct;
    }

    public String getTx_alias_cab() {
        return tx_alias_cab;
    }

    public void setTx_alias_cab(String tx_alias_cab) {
        this.tx_alias_cab = tx_alias_cab;
    }


}
