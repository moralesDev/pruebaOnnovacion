package com.example.prueba.tecnica.financiero;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.prueba.tecnica.financiero.cliente.Cliente;
import com.example.prueba.tecnica.financiero.cliente.ClienteRepository;
import com.example.prueba.tecnica.financiero.cuenta.Cuenta;
import com.example.prueba.tecnica.financiero.cuenta.CuentaRepository;
import com.example.prueba.tecnica.financiero.moneda.Moneda;
import com.example.prueba.tecnica.financiero.movimiento.Movimiento;
import com.example.prueba.tecnica.financiero.movimiento.MovimientoRepository;
import com.example.prueba.tecnica.financiero.tipoDocumento.TipoDocumento;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository repo;

	@Autowired
	private CuentaRepository cuentaRepo;
	
	@Autowired
	private MovimientoRepository movimientoRepo;

	@Test
	public void testCrearCliente() {
		TipoDocumento tipoD = new TipoDocumento();
		tipoD.setId(3);

		Moneda moneda = new Moneda();
		moneda.setId(1);

		Random random = new Random();
		int rutAleatorio = random.nextInt(100000);
		int numCuentaAleatorio = random.nextInt(100000);

		List<Cliente> list = repo.findByRut(String.valueOf(rutAleatorio));
		if (list.isEmpty()) {
			Cliente clienteGuardado = repo.save(
					new Cliente("Alejandro", "Morales", "34324234", "", String.valueOf(rutAleatorio), tipoD, true, 0));
			assertThat(clienteGuardado.getId()).isNotEqualTo(null);

			Cuenta cuentaGuardada = cuentaRepo.save(new Cuenta(String.valueOf(numCuentaAleatorio), moneda, clienteGuardado, 0));
			assertThat(cuentaGuardada.getId()).isNotEqualTo(null);
			
			Movimiento movimientoGuardado = movimientoRepo.save(new Movimiento(moneda,800000,cuentaGuardada));
			assertThat(movimientoGuardado.getId()).isNotEqualTo(null);
			
		}

	}

}
