package com.qin.manager.colaboracion;

import java.util.List;

import com.qin.entity.Grupo;
import com.qin.entity.Materia;
import com.qin.entity.TrabajoPractico;

public interface ColaboracionManager {

	void insertGrupo(Grupo grupo) throws Exception;

	void updateGrupo(Grupo grupo) throws Exception;

	void deleteGrupo(Grupo grupo) throws Exception;

	void insertTP(TrabajoPractico tp) throws Exception;
	
	List<Materia> findAllMaterias() throws Exception;

}
