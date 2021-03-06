/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Freddy
 */
@Entity
@Table(name = "orden_de_compra")
@NamedQueries({
    @NamedQuery(name = "OrdenDeCompra.findAll", query = "SELECT o FROM OrdenDeCompra o")
    , @NamedQuery(name = "OrdenDeCompra.findByIDOrden", query = "SELECT o FROM OrdenDeCompra o WHERE o.iDOrden = :iDOrden")
    , @NamedQuery(name = "OrdenDeCompra.findByFecha", query = "SELECT o FROM OrdenDeCompra o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "OrdenDeCompra.findByNombreComprador", query = "SELECT o FROM OrdenDeCompra o WHERE o.nombreComprador = :nombreComprador")
    , @NamedQuery(name = "OrdenDeCompra.findByNombreVendedor", query = "SELECT o FROM OrdenDeCompra o WHERE o.nombreVendedor = :nombreVendedor")
    , @NamedQuery(name = "OrdenDeCompra.findByLugarEmision", query = "SELECT o FROM OrdenDeCompra o WHERE o.lugarEmision = :lugarEmision")
    , @NamedQuery(name = "OrdenDeCompra.findByDescripcion", query = "SELECT o FROM OrdenDeCompra o WHERE o.descripcion = :descripcion")
    , @NamedQuery(name = "OrdenDeCompra.findByPrecioUnitario", query = "SELECT o FROM OrdenDeCompra o WHERE o.precioUnitario = :precioUnitario")
    , @NamedQuery(name = "OrdenDeCompra.findByPrecioTotal", query = "SELECT o FROM OrdenDeCompra o WHERE o.precioTotal = :precioTotal")
    , @NamedQuery(name = "OrdenDeCompra.findByPagoTotal", query = "SELECT o FROM OrdenDeCompra o WHERE o.pagoTotal = :pagoTotal")
    , @NamedQuery(name = "OrdenDeCompra.findByMetodoPago", query = "SELECT o FROM OrdenDeCompra o WHERE o.metodoPago = :metodoPago")
    , @NamedQuery(name = "OrdenDeCompra.findByTelefono", query = "SELECT o FROM OrdenDeCompra o WHERE o.telefono = :telefono")
    , @NamedQuery(name = "OrdenDeCompra.findByCantidad", query = "SELECT o FROM OrdenDeCompra o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "OrdenDeCompra.findByUnidaddemedida", query = "SELECT o FROM OrdenDeCompra o WHERE o.unidaddemedida = :unidaddemedida")})
public class OrdenDeCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Orden")
    private Integer iDOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre_Comprador")
    private String nombreComprador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre_Vendedor")
    private String nombreVendedor;
    @Size(max = 20)
    @Column(name = "Lugar_Emision")
    private String lugarEmision;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Precio_Unitario")
    private Integer precioUnitario;
    @Column(name = "Precio_Total")
    private Integer precioTotal;
    @Column(name = "Pago_Total")
    private Integer pagoTotal;
    @Size(max = 30)
    @Column(name = "Metodo_Pago")
    private String metodoPago;
    @Size(max = 25)
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @Size(max = 5)
    @Column(name = "Unidad_de_medida")
    private String unidaddemedida;
    @JoinTable(name = "proveedores_has_orden_de_compra", joinColumns = {
        @JoinColumn(name = "Orden_de_compra_ID_Orden", referencedColumnName = "ID_Orden")}, inverseJoinColumns = {
        @JoinColumn(name = "Proveedores_ID_Proveedor", referencedColumnName = "idproveedor")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Proveedores> proveedoresCollection;
    @JoinColumn(name = "ID_Asistente", referencedColumnName = "ID_Asistente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Asistente iDAsistente;

    public OrdenDeCompra() {
    }

    public OrdenDeCompra(Integer iDOrden) {
        this.iDOrden = iDOrden;
    }

    public OrdenDeCompra(Integer iDOrden, Date fecha, String nombreComprador, String nombreVendedor) {
        this.iDOrden = iDOrden;
        this.fecha = fecha;
        this.nombreComprador = nombreComprador;
        this.nombreVendedor = nombreVendedor;
    }

    public Integer getIDOrden() {
        return iDOrden;
    }

    public void setIDOrden(Integer iDOrden) {
        this.iDOrden = iDOrden;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getLugarEmision() {
        return lugarEmision;
    }

    public void setLugarEmision(String lugarEmision) {
        this.lugarEmision = lugarEmision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Integer precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Integer getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(Integer pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidaddemedida() {
        return unidaddemedida;
    }

    public void setUnidaddemedida(String unidaddemedida) {
        this.unidaddemedida = unidaddemedida;
    }

    public Collection<Proveedores> getProveedoresCollection() {
        return proveedoresCollection;
    }

    public void setProveedoresCollection(Collection<Proveedores> proveedoresCollection) {
        this.proveedoresCollection = proveedoresCollection;
    }

    public Asistente getIDAsistente() {
        return iDAsistente;
    }

    public void setIDAsistente(Asistente iDAsistente) {
        this.iDAsistente = iDAsistente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDOrden != null ? iDOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenDeCompra)) {
            return false;
        }
        OrdenDeCompra other = (OrdenDeCompra) object;
        if ((this.iDOrden == null && other.iDOrden != null) || (this.iDOrden != null && !this.iDOrden.equals(other.iDOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.OrdenDeCompra[ iDOrden=" + iDOrden + " ]";
    }
    
}
