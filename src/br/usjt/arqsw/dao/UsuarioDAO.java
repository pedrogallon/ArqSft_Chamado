package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Usuario;

/**
 * 
 * @author RA816124368 Pedro Gallon Alves CCP3AN-MCA1
 *
 */
@Repository
public class UsuarioDAO {
	private Connection conn;

	
	/**
	 * 
	 * @param dataSource = Parametros de conexão com DB
	 * @throws IOException
	 */
	@Autowired
	public UsuarioDAO(DataSource dataSource) throws IOException {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}

	/**
	 * 
	 * @param usuario = Usuario contendo id e senha inseridos
	 * @return Caso encontre um usuario com tal id e senha, return Usuario. Caso contrário, return null
	 * @throws IOException
	 */
	public Usuario logarUsuario(Usuario usuario) throws IOException {
		String query = "SELECT ID_USUARIO, PW_USUARIO FROM servicedesk.USUARIO WHERE ID_USUARIO=? AND PW_USUARIO=?";

		try (PreparedStatement pst = conn.prepareStatement(query);) {
			pst.setString(1, usuario.getId());
			pst.setString(2, usuario.getPw());
			try (ResultSet rs = pst.executeQuery();) {

				while (rs.next()) {
					return usuario;
				}
			}

		} catch (SQLException e) {
			throw new IOException(e);
		}
		return null;
	}

}
