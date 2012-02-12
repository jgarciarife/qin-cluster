package ar.com.ospim.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ar.com.ospim.dao.BaseDao;
import ar.com.ospim.entities.Usuario;

@Service
public class LoginService {

	@Resource
	private BaseDao usuarioDaoImpl;

	public List<Usuario> getUsuarios() {
		final List<Usuario> list = usuarioDaoImpl.find(Usuario.class);
		return list;
	}

	public BaseDao getUsuarioDaoImpl() {
		return usuarioDaoImpl;
	}

	public void setUsuarioDaoImpl(BaseDao usuarioDaoImpl) {
		this.usuarioDaoImpl = usuarioDaoImpl;
	}
}
