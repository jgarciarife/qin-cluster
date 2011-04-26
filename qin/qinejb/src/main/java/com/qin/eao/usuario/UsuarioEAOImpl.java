package com.qin.eao.usuario;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Usuario;

@Stateless
public class UsuarioEAOImpl extends BaseEAOImpl implements UsuarioEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(UsuarioEAOImpl.class);
	
	public UsuarioEAOImpl() {
	}

	@Override
	public Usuario findById(Long usuarioId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT usuario ");
		jpql.append("FROM Usuario usuario ");
		jpql.append("WHERE usuario.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", usuarioId);
		return (Usuario) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT usuario ");
		jpql.append("FROM Usuario usuario ");
		Query query = getEntityManager().createQuery(jpql.toString());
		return query.getResultList();
	}
}