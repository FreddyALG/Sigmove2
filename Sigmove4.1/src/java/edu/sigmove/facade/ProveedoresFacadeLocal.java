/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.Proveedores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Freddy
 */
@Local
public interface ProveedoresFacadeLocal {

    void create(Proveedores proveedores);

    void edit(Proveedores proveedores);

    void remove(Proveedores proveedores);

    Proveedores find(Object id);

    List<Proveedores> findAll();

    List<Proveedores> findRange(int[] range);

    int count();

    public boolean removerProveedor(int idproveedor);
    
}
