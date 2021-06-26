package com.valtx.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @Column(name = "cod_usuario")
    private String codigoUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "pass")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sucursal_id", referencedColumnName = "cod_sucursal", foreignKey = @ForeignKey(name = "sucursal_id_fkey"))
    private SucursalEntity sucursal;

    public UsuarioEntity() {
    }

    public UsuarioEntity(String codigoUsuario, String nombre, String usuario, String password, SucursalEntity sucursal) {
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.sucursal = sucursal;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SucursalEntity getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }
}
