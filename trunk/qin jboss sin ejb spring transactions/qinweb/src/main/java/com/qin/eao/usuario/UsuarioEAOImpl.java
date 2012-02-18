package com.qin.eao.usuario;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Usuario;

@Repository
public class UsuarioEAOImpl extends BaseEAOImpl implements UsuarioEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(UsuarioEAOImpl.class);

	public UsuarioEAOImpl() {
	}

	@Override
	@Transactional
	public Usuario findById(Long usuarioId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT usuario ");
		jpql.append("FROM Usuario usuario ");
		jpql.append("WHERE usuario.id = :id ");
		Query query = sessionFactory.getCurrentSession().createQuery(
				jpql.toString());
		query.setParameter("id", usuarioId);
		return (Usuario) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Usuario> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT usuario ");
		jpql.append("FROM Usuario usuario ");
		Query query = sessionFactory.getCurrentSession().createQuery(
				jpql.toString());
		return query.list();
	}

	@Override
	@Transactional
	public Usuario findByName(String loginName) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT usuario ");
		jpql.append("FROM Usuario usuario ");
		jpql.append("WHERE usuario.nombreUsuario = :nombreUsuario ");
		Query query = sessionFactory.getCurrentSession().createQuery(
				jpql.toString());
		query.setParameter("nombreUsuario", loginName);
		return (Usuario) query.uniqueResult();
	}
}