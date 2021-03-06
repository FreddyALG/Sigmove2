/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Freddy
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "Sigmove4.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public Usuario recuperarContraseña(String usuarioIn) {
        try {
            Query qt = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :usuarioIn ");
            qt.setParameter("usuarioIn", usuarioIn);
            return (Usuario) qt.getSingleResult();
        } catch (Exception e) {
            return new Usuario();
        }

    }
    
    @Override
    public Usuario loginUsuario(String usuarioIn, String contraseñaIn) {
        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :usuarioIn AND u.contraseña = :contraseñaIn");
            q.setParameter("usuarioIn", usuarioIn);
            q.setParameter("contraseñaIn", contraseñaIn);
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            return new Usuario();
        }
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
}
