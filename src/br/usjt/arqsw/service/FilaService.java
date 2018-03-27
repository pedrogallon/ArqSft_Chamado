package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.FilaDAO;
import br.usjt.arqsw.entity.Fila;
/**
 * 
 * @author RA816124368 Pedro Gallon Alves CCP3AN-MCA1
 *
 */
@Service
public class FilaService {
	private FilaDAO dao;
	
	@Autowired
	public FilaService(FilaDAO dao) {
		this.dao = dao;
	}
	/**
	 * 
	 * @return Lista de Filas
	 * @throws IOException
	 */
	public List<Fila> listarFilas() throws IOException{
		return dao.listarFilas();
	}
	/**
	 * 
	 * @param id = id da fila a ser carregada
	 * @return Fila
	 * @throws IOException
	 */
	public Fila carregarFila(int id) throws IOException{
		return dao.carregarFila(id);
	}
}
