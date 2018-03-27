package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
/**
 * 
 * @author RA816124368 Pedro Gallon Alves CCP3AN-MCA1
 *
 */
@Service
public class ChamadoService {
	private ChamadoDAO dao;
	
	@Autowired
	public ChamadoService(ChamadoDAO dao) {
		this.dao = dao;
	}
	/**
	 * 
	 * @param idFila = id da Fila a quais os chamados necessários pertencem
	 * @return Lista de Chamados Abertos
	 * @throws IOException
	 */
	public List<Chamado> listarChamados(Fila fila) throws IOException{
		return dao.listarChamados(fila);
	}
	/**
	 * 
	 * @param idFila = id da Fila a quais os chamados necessários pertencem
	 * @return Lista de Chamados Abertos
	 * @throws IOException
	 */
	public List<Chamado> listarChamadosAbertos(Fila fila) throws IOException{
		return dao.listarChamadosAbertos(fila);
	}
//	public Chamado carregarChamado(int id) throws IOException{
//		return dao.carregarChamado(id);
//	}
	/**
	 * 
	 * @param chamado = Chamado com Desc e idFila
	 * @throws IOException
	 */
	public void criarChamado(Chamado chamado) throws IOException{
		dao.criarChamado(chamado);
	}
	/**
	 * 
	 * @param id = id do Chamado a ser fechado
	 * @throws IOException
	 */
	public void fecharChamado(int id[]) throws IOException{
		dao.fecharChamado(id);
	}
}
