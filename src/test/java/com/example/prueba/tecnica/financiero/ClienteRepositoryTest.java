package com.example.prueba.tecnica.financiero;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.prueba.tecnica.financiero.cliente.Cliente;
import com.example.prueba.tecnica.financiero.cliente.ClienteRepository;
import com.example.prueba.tecnica.financiero.cuenta.Cuenta;
import com.example.prueba.tecnica.financiero.tipoDocumento.TipoDocumento;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCrearCliente() {
		TipoDocumento tipoD = new TipoDocumento();
		tipoD.setId(3);
		Cliente clienteGuardado = repo.save(new Cliente("Alejandro","Morales","34324234","","4544545",tipoD,true,0));
		assertThat(clienteGuardado.getId()).isNotEqualTo(null);
	}
	
	
	@Test
	@Transactional
	public void testCrearCuentaACliente() {
		Cliente cliente = entityManager.find(Cliente.class, "70235372-1f71-492f-840a-788f4522440b");
		Cuenta cuenta = entityManager.find(Cuenta.class, "cb7f0c58-368d-4e02-8ab9-8e361847caba");
		
		cliente.setNuevaCuenta(cuenta);
	}
}
