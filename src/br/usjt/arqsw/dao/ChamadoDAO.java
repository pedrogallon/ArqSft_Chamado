package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author RA816124368 Pedro Gallon Alves CCP3AN-MCA1
 *
 */

@Repository
public class ChamadoDAO {
	@PersistenceContext
	EntityManager manager;

	/**
	 * 
	 * @param idFila
	 *            = Fila.id selecionado
	 * @return ArrayList de todos os Chamados com Fila.id correspondente
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public List<Chamado> listarChamados(Fila fila) throws IOException {
		fila = manager.find(Fila.class, fila.getId());

		String jpql = "select c from Chamado c where c.fila = :fila";

		Query query = manager.createQuery(jpql);
		query.setParameter("fila", fila);

		List<Chamado> result = query.getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Chamado> listarChamados() throws IOException {
		

		Query query = manager.createQuery("select c from Chamado c");

		List<Chamado> result = query.getResultList();
		return result;
	}

	/**
	 * 
	 * @param idFila
	 *            = Fila.id selecionado
	 * @return ArrayList de todos os Chamados Abertos com Fila.id correspondente
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public List<Chamado> listarChamadosAbertos(Fila fila) throws IOException {
		// conectei minha fila com a persistencia
		fila = manager.find(Fila.class, fila.getId());

		String jpql = "select c from Chamado c where c.fila = :fila and c.status = :status";

		Query query = manager.createQuery(jpql);
		query.setParameter("fila", fila);
		query.setParameter("status", Chamado.ABERTO);

		List<Chamado> result = query.getResultList();
		return result;
	}

	// public Chamado carregarChamado(int id) throws IOException {
	// String query = "SELECT ID_CHAMADO, DESCRICAO, STATUS, DT_ABERTURA,
	// DT_FECHAMENTO, ID_FILA FROM servicedesk.chamado WHERE ID_CHAMADO = ?; ";
	// Chamado chamado = new Chamado();
	// try(Connection conn = ConnectionFactory.getConnection();
	// PreparedStatement pst = conn.prepareStatement(query);
	// ){
	// pst.setInt(1, id);
	// try(ResultSet rs = pst.executeQuery();){
	// while(rs.next()) {
	//
	// chamado.setId(rs.getInt("ID_CHAMADO"));
	// chamado.setDescricao(rs.getString("DESCRICAO"));
	// chamado.setStatus(rs.getString("STATUS"));
	// chamado.setDataAbertura(rs.getDate("DT_ABERTURA"));
	// chamado.setDataFechamento(rs.getDate("DT_FECHAMENTO"));
	// chamado.setIdFila(rs.getInt("ID_FILA"));
	// }
	// }
	// }catch (SQLException e) {
	// throw new IOException(e);
	// }
	// return chamado;
	// }

	/**
	 * 
	 * @param chamado
	 *            = Chamado com descricao e idFila Criação de entrada no banco com
	 *            descrição, status = aberto, dt_abertura = data atual e idFila
	 * @throws IOException
	 */
	public void criarChamado(Chamado chamado) throws IOException {
		chamado.setDataAbertura(new Date());
		chamado.setStatus("aberto");
		manager.persist(chamado);
	}

	/**
	 * 
	 * @param ids
	 *            = array de ID's de Chamados a serem fechados Update status =
	 *            fechado e dt_fechamento = data atual
	 * @throws IOException
	 */
	public void fecharChamado(int[] lista) throws IOException {

		for (int id : lista) {
			Chamado chamado = manager.find(Chamado.class, id);
			chamado.setDataFechamento(new java.util.Date());
			chamado.setStatus(Chamado.FECHADO);
			manager.merge(chamado);
		}

	}

}
