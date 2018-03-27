package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Fila;
/**
 * 
 * @author RA816124368 Pedro Gallon Alves CCP3AN-MCA1
 *
 */
@Repository
public class FilaDAO {
	@PersistenceContext 
	EntityManager manager;
	
	/**
	 * 
	 * @return ArryList com todas as filas
	 * @throws IOException
	 */
	public List<Fila> listarFilas() throws IOException {
		return manager.createQuery("select f from Fila f").getResultList();
	}
	
	/**
	 * 
	 * @param id = id da fila a ser carregada
	 * @return	Fila preenchida
	 * @throws IOException
	 */
	public Fila carregarFila(int id) throws IOException {
		return manager.find(Fila.class, id);
	}

}
