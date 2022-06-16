package com.example.prueba.tecnica.financiero;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.prueba.tecnica.financiero.cliente.Cliente;
import com.example.prueba.tecnica.financiero.cliente.ClienteRepository;
import com.example.prueba.tecnica.financiero.tipoDocumento.TipoDocumento;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository repo;
	
	@Test
	public void testCrearCliente() {
		TipoDocumento tipoD = new TipoDocumento();
		tipoD.setId(3);
		Cliente clienteGuardado = repo.save(new Cliente("Alejandro","Morales","34324234","","34324234",tipoD,true,0));
		assertThat(clienteGuardado.getId()).isGreaterThan(0);
	}
}
