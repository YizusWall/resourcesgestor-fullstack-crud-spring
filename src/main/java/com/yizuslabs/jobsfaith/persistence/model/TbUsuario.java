package com.yizuslabs.jobsfaith.persistence.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tbusuario", schema = "costmanager")
public class TbUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codusuario")
    private long codUsuario;
    @Column(name = "nomusuario")
    private String nomUsuario;
    @Column(name = "indusuario")
    private String indUsuario;
    @Column(name = "codempleado")
    private String codEmpleado;
    @Column(name = "pwdusuario")
    private String pwdUsuario;
    @Column(name = "feccrea")
    private Timestamp fecCrea;
    @Column(name = "usercrea")
    private String userCrea;




    public long getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(long codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getIndUsuario() {
        return indUsuario;
    }

    public void setIndUsuario(String indUsuario) {
        this.indUsuario = indUsuario;
    }

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getPwdUsuario() {
        return pwdUsuario;
    }

    public void setPwdUsuario(String pwdUsuario) {
        this.pwdUsuario = pwdUsuario;
    }

    public Timestamp getFecCrea() {
        return fecCrea;
    }

    public void setFecCrea(Timestamp fecCrea) {
        this.fecCrea = fecCrea;
    }

    public String getUserCrea() {
        return userCrea;
    }

    public void setUserCrea(String userCrea) {
        this.userCrea = userCrea;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbUsuario that = (TbUsuario) o;
        return Objects.equals(codUsuario, that.codUsuario) &&
                Objects.equals(nomUsuario, that.nomUsuario) &&
                Objects.equals(indUsuario, that.indUsuario) &&
                Objects.equals(codEmpleado, that.codEmpleado) &&
                Objects.equals(pwdUsuario, that.pwdUsuario) &&
                Objects.equals(fecCrea, that.fecCrea) &&
                Objects.equals(userCrea, that.userCrea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codUsuario, nomUsuario, indUsuario, codEmpleado, pwdUsuario, fecCrea, userCrea);
    }
}
