package br.usjt.arqsw.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.UsuarioDAO;
import br.usjt.arqsw.entity.Usuario;
/**
 * 
 * @author RA816124368 Pedro Gallon Alves CCP3AN-MCA1
 *
 */
@Service
public class UsuarioService {
	private UsuarioDAO dao;
	
	@Autowired
	public UsuarioService(UsuarioDAO dao){
		this.dao = dao;
	}
	/**
	 * 
	 * @param usuario = Usuario com id e pw
	 * @return	Usuario ou null
	 * @throws IOException
	 */
	public Usuario logarUsuario(Usuario usuario) throws IOException {
		return dao.logarUsuario(usuario);
	}
}
