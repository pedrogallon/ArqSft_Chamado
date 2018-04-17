package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Usuario;

/**
 * 
 * @author RA816124368 Pedro Gallon Alves CCP3AN-MCA1
 *
 */
@Repository
public class UsuarioDAO {
	@PersistenceContext
	EntityManager manager;

	/**
	 * 
	 * @param usuario = Usuario contendo id e senha inseridos
	 * @return Caso encontre um usuario com tal id e senha, return Usuario. Caso contrário, return null
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public Usuario logarUsuario(Usuario usuario) throws IOException {
		String jpql = "select u from Usuario u where u.id = :id and u.pw = :pw";

		Query query = manager.createQuery(jpql);
		query.setParameter("id", usuario.getId());
		query.setParameter("pw", usuario.getPw());

		List<Usuario> result = query.getResultList();
		if (result.size()==0) {
			return null;
		}
		return result.get(0);
	}

}
