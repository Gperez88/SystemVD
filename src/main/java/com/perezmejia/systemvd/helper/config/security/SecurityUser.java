package com.perezmejia.systemvd.helper.config.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.userdetails.User;

/**
 * Created by Guil on 4/30/2016.
 */
public class SecurityUser extends User {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String sexo;
    private Date fechaAlta;
    private Date fechaModificacion;
    private String correElectronicoPpal;
    private String husoHorario;
    private String defaultLang;

    public SecurityUser(String login, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
                        boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Long userId, String nombre,
                        String apellidos, Date fechaNacimiento, String sexo, Date fechaAlta, Date fechaModificacion,
                        String correElectronicoPpal, String husoHorario, String defaultLang) {

        super(login, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userId = userId;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.fechaAlta = fechaAlta;
        this.fechaModificacion = fechaModificacion;
        this.correElectronicoPpal = correElectronicoPpal;
        this.husoHorario = husoHorario;
        this.defaultLang = defaultLang;
    }

    public SecurityUser(String login, String password, boolean enabled, boolean accountNonExpired,
                        boolean credentialsNonExpired, boolean accountNonLocked,
                        Collection<? extends GrantedAuthority> authorities) {

        super(login, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getCorreElectronicoPpal() {
        return correElectronicoPpal;
    }

    public void setCorreElectronicoPpal(String correElectronicoPpal) {
        this.correElectronicoPpal = correElectronicoPpal;
    }

    public String getHusoHorario() {
        return husoHorario;
    }

    public void setHusoHorario(String husoHorario) {
        this.husoHorario = husoHorario;
    }

    public String getDefaultLang() {
        return defaultLang;
    }

    public void setDefaultLang(String defaultLang) {
        this.defaultLang = defaultLang;
    }
}