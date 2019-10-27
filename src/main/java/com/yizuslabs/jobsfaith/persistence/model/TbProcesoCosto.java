package com.yizuslabs.jobsfaith.persistence.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tbprocesocosto", schema = "costmanager", catalog = "")
public class TbProcesoCosto {


    private Long numOrden;
    private Long codUnidad;
    private Long codSubUnidad;
    private String codEmpleado;
    private BigDecimal costoAsignado;
    private BigDecimal costoConsume;
    private BigDecimal porcentaje;
    private BigDecimal currentCosto;
    private Date fecIngreso;
    private Timestamp fecCrea;
    private String userCrea;
    private String indDel;
    private String codFormato;

    @Basic
    @Id
    @Column(name = "numorden")
    public Long getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(Long numOrden) {
        this.numOrden = numOrden;
    }

    @Basic
    @Column(name = "codunidad")
    public Long getCodUnidad() {
        return codUnidad;
    }

    public void setCodUnidad(Long codUnidad) {
        this.codUnidad = codUnidad;
    }

    @Basic
    @Column(name = "codsubunidad")
    public Long getCodSubUnidad() {
        return codSubUnidad;
    }

    public void setCodSubUnidad(Long codSubUnidad) {
        this.codSubUnidad = codSubUnidad;
    }

    @Basic
    @Column(name = "codempleado")
    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    @Basic
    @Column(name = "costoasignado")
    public BigDecimal getCostoAsignado() {
        return costoAsignado;
    }

    public void setCostoAsignado(BigDecimal costoAsignado) {
        this.costoAsignado = costoAsignado;
    }

    @Basic
    @Column(name = "costoconsume")
    public BigDecimal getCostoConsume() {
        return costoConsume;
    }

    public void setCostoConsume(BigDecimal costoConsume) {
        this.costoConsume = costoConsume;
    }

    @Basic
    @Column(name = "porcentaje")
    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Basic
    @Column(name = "currentcosto")
    public BigDecimal getCurrentCosto() {
        return currentCosto;
    }

    public void setCurrentCosto(BigDecimal currentCosto) {
        this.currentCosto = currentCosto;
    }

    @Basic
    @Column(name = "fecingreso")
    public Date getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(Date fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    @Basic
    @Column(name = "feccrea")
    public Timestamp getFecCrea() {
        return fecCrea;
    }

    public void setFecCrea(Timestamp fecCrea) {
        this.fecCrea = fecCrea;
    }

    @Basic
    @Column(name = "usercrea")
    public String getUserCrea() {
        return userCrea;
    }

    public void setUserCrea(String userCrea) {
        this.userCrea = userCrea;
    }

    @Basic
    @Column(name = "inddel")
    public String getIndDel() {
        return indDel;
    }

    public void setIndDel(String indDel) {
        this.indDel = indDel;
    }

    @Basic
    @Column(name = "codformato")
    public String getCodFormato() {
        return codFormato;
    }

    public void setCodFormato(String codFormato) {
        this.codFormato = codFormato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbProcesoCosto that = (TbProcesoCosto) o;
        return numOrden == that.numOrden &&
                codUnidad == that.codUnidad &&
                codSubUnidad == that.codSubUnidad &&
                Objects.equals(codEmpleado, that.codEmpleado) &&
                Objects.equals(costoAsignado, that.costoAsignado) &&
                Objects.equals(costoConsume, that.costoConsume) &&
                Objects.equals(porcentaje, that.porcentaje) &&
                Objects.equals(currentCosto, that.currentCosto) &&
                Objects.equals(fecIngreso, that.fecIngreso) &&
                Objects.equals(fecCrea, that.fecCrea) &&
                Objects.equals(userCrea, that.userCrea) &&
                Objects.equals(indDel, that.indDel) &&
                Objects.equals(codFormato, that.codFormato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOrden, codUnidad, codSubUnidad, codEmpleado, costoAsignado, costoConsume, porcentaje, currentCosto, fecIngreso, fecCrea, userCrea, indDel, codFormato);
    }
}
