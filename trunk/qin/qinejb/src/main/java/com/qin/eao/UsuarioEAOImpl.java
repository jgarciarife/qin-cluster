package com.qin.eao;

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

	@Override
	public void insert(Usuario usuario) throws Exception {
		getEntityManager().persist(usuario);
	}

	@Override
	public void update(Usuario usuario) throws Exception {
		getEntityManager().merge(usuario);
	}

	@Override
	public void delete(Usuario usuario) throws Exception {
		getEntityManager().remove(usuario);
	}

	@Override
	public Usuario findById(Usuario usuario) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT usuario ");
		jpql.append("FROM UsuarioEntity usuario ");
		jpql.append("WHERE usuario.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", usuario.getId());
		return (Usuario) query.getSingleResult();
	}
}
