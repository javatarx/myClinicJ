package org.joedayz.acweb.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

public class BNUsuario implements Serializable {

    private static final long serialVersionUID = -5069094294287446581L;
    private Long coUser;
    private String userName;
    private String email;
    private String nombres;
    private String apellidos;
    private char stUsuario;//bit
    private char sexo;
    private String direccion;
    private String telefono;
    private char tipoDocumento;
    private Long documento;
    private String password;
    private char accountExpired;//bit
    private char accountLocked;//bit
    private char credentialsExpired;//bit
    private char accountEnabled;//bit
    private String passwordHint;

    private Date fechaSesion;

    private Long coRol;

    private String deRol;

    public String getDeRol() {
        return deRol;
    }

    public void setDeRol(String deRol) {
        this.deRol = deRol;
    }

    @Id
    @Column(name = "CO_CITA")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getCoUser() {
        return coUser;
    }

    public void setCoUser(Long coUser) {
        this.coUser = coUser;
    }

    @Column(name = "USERNAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Column
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Column(name = "ST_USUARIO")
    public char getStUsuario() {
        return stUsuario;
    }

    public void setStUsuario(char stUsuario) {
        this.stUsuario = stUsuario;
    }

    @Column
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Column
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Column(name ="TIPO_DOCUMENTO")
    public char getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(char tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Column
    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "ACCOUNT_EXPIRED")
    public char getAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(char accountExpired) {
        this.accountExpired = accountExpired;
    }

    @Column(name = "ACCOUNT_LOCKED")
    public char getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(char accountLocked) {
        this.accountLocked = accountLocked;
    }

    @Column(name = "CREDENTIALS_EXPIRED")
    public char getCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(char credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    @Column(name = "ACCOUNT_ENABLED")
    public char getAccountEnabled() {
        return accountEnabled;
    }

    public void setAccountEnabled(char accountEnabled) {
        this.accountEnabled = accountEnabled;
    }

    @Column(name = "PASSWORD_HINT")
    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    
    public Long getCoRol() {
        return coRol;
    }

    public void setCoRol(Long coRol) {
        this.coRol = coRol;
    }

    public Date getFechaSesion() {
        return fechaSesion;
    }

    public void setFechaSesion(Date fechaSesion) {
        this.fechaSesion = fechaSesion;
    }

}
