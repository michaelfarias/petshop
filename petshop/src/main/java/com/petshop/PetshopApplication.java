package com.petshop;

import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.petshop.modelo.Animal;
import com.petshop.modelo.Cliente;
import com.petshop.modelo.Compra;
import com.petshop.modelo.Promocao;
import com.petshop.modelo.Servico;
import com.petshop.modelo.enums.FormaPagamento;
import com.petshop.repositories.AnimalRepository;
import com.petshop.repositories.ClienteRepository;
import com.petshop.repositories.CompraRepository;
import com.petshop.repositories.PromocaoRepository;
import com.petshop.repositories.ServicoRepository;

@SpringBootApplication
public class PetshopApplication implements CommandLineRunner {
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private ServicoRepository servicoRepository;

	@Autowired
	private PromocaoRepository promocaoRepository;

	@Autowired
	private CompraRepository compraRepository;

	public static void main(String[] args) {
		SpringApplication.run(PetshopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cliente cliente1 = new Cliente("laksjd", "123456", "João", "joao@gmail.com", "546565", "666666666");
		clienteRepository.save(cliente1);

		Animal animal1 = new Animal("Cachorro", 1, "pitbull", 1.5, 5.45, 1);

		animal1.setCliente(cliente1);
		cliente1.setAnimais(Arrays.asList(animal1));

		animalRepository.save(animal1);
		clienteRepository.save(cliente1);

		Servico servico1 = new Servico("Banho de agua", "Passar shampoo, pentear", Arrays.asList(LocalTime.now()),
				45.99, 1, 2);
		servicoRepository.save(servico1);

		Promocao promocao1 = new Promocao("Dia do bixo", 20, 1);
		promocaoRepository.save(promocao1);

		Compra compra1 = new Compra();

		compra1.setCliente(cliente1);
		compra1.setServicos(Arrays.asList(servico1));
		compra1.setFormaPagamento(FormaPagamento.CARTAODECREDITO);

		cliente1.setCompras(Arrays.asList(compra1));
		servico1.setCompras(Arrays.asList(compra1));

		compraRepository.save(compra1);
		clienteRepository.save(cliente1);
		servicoRepository.save(servico1);

		promocao1.setServicos(Arrays.asList(servico1));
		servico1.setPromocao(promocao1);

		promocaoRepository.save(promocao1);
		servicoRepository.save(servico1);
	}
}
