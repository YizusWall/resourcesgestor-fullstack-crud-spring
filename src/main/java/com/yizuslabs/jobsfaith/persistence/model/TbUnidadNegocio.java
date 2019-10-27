package com.yizuslabs.jobsfaith.persistence.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tbunidadnegocio", schema = "costmanager")
public class TbUnidadNegocio {
    private Long codUnidad;
    private String desUnidad;
    private String indUnidad;
    private String codTipUnidad;
    private Timestamp fecCrea;
    private String userCrea;
    private String obsUnidad;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codunidad", updatable = false, nullable = false)
    public Long getCodUnidad() {
        return codUnidad;
    }

    public void setCodUnidad(Long codUnidad) {
        this.codUnidad = codUnidad;
    }

    @Basic
    @Column(name = "desunidad")
    public String getDesUnidad() {
        return desUnidad;
    }

    public void setDesUnidad(String desUnidad) {
        this.desUnidad = desUnidad;
    }

    @Basic
    @Column(name = "indunidad")
    public String getIndUnidad() {
        return indUnidad;
    }

    public void setIndUnidad(String indUnidad) {
        this.indUnidad = indUnidad;
    }

    @Basic
    @Column(name = "codtipunidad")
    public String getCodTipUnidad() {
        return codTipUnidad;
    }

    public void setCodTipUnidad(String codTipUnidad) {
        this.codTipUnidad = codTipUnidad;
    }

    @DateTimeFormat(pattern = "YYYY-MM-DD")
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
    @Column(name = "obsunidad")
    public String getObsUnidad() {
        return obsUnidad;
    }

    public void setObsUnidad(String obsUnidad) {
        this.obsUnidad = obsUnidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbUnidadNegocio that = (TbUnidadNegocio) o;
        return codUnidad == that.codUnidad &&
                Objects.equals(desUnidad, that.desUnidad) &&
                Objects.equals(indUnidad, that.indUnidad) &&
                Objects.equals(codTipUnidad, that.codTipUnidad) &&
                Objects.equals(fecCrea, that.fecCrea) &&
                Objects.equals(userCrea, that.userCrea) &&
                Objects.equals(obsUnidad, that.obsUnidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codUnidad, desUnidad, indUnidad, codTipUnidad, fecCrea, userCrea, obsUnidad);
    }

}
