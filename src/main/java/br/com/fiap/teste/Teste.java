package br.com.fiap.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class Teste {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("smartcities-dao").createEntityManager();
		
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		Cliente entidade = new Cliente(0, "Simon");
		clienteDAO.cadastrar(entidade);

		try {
			clienteDAO.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Cliente> lista = clienteDAO.listar();
		for (Cliente cliente : lista) {
			System.out.println(cliente.getId() + " " + cliente.getNome());
		}
		
	}

}
