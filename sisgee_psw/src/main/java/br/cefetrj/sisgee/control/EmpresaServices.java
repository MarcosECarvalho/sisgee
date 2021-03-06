package br.cefetrj.sisgee.control;

import java.util.List;

import br.cefetrj.sisgee.model.dao.GenericDAO;
import br.cefetrj.sisgee.model.dao.PersistenceManager;
import br.cefetrj.sisgee.model.entity.Empresa;

/**
 * Serviços de Empresa. 
 * Trata a lógica de negócios
 * associada com a entidade Empresa.
 * 
 * @author Paulo Cantuária
 * @since 1.0
 */
public class EmpresaServices {
	
	/**
	 * Recupera todas as empresas e retorna em uma lista.
	 * 
	 * @return lista com todas as empresas
	 */
	public static List<Empresa> listarEmpresas(){
		GenericDAO<Empresa> empresaDao = PersistenceManager.createGenericDAO(Empresa.class);
		return empresaDao.buscarTodos();
	}	
	
	public static void incluirEmpresa(Empresa empresa){
		GenericDAO<Empresa> empresaDao = PersistenceManager.createGenericDAO(Empresa.class);	
		PersistenceManager.getTransaction().begin();
		try{
			empresaDao.incluir(empresa);
			PersistenceManager.getTransaction().commit();
		}catch(Exception e){
			PersistenceManager.getTransaction().rollback();
		}
	}
}

