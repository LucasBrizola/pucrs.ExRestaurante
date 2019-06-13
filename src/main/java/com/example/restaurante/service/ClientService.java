package com.example.restaurante.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurante.domain.Client;
import com.example.restaurante.dto.ClientDTO;
import com.example.restaurante.repository.ClientRepository;

@Service
public class ClientService {
	private ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public void save(ClientDTO clientDTO) {
		String name = clientDTO.getName();
		String cpf = clientDTO.getCpf();
		int age = clientDTO.getAge();
		String gender = clientDTO.getGender();

		Client client = new Client(name, cpf, age, gender);
		validateInsertClient(client);
		this.clientRepository.saveAndFlush(client);
	}

	private void validateInsertClient(Client client) {
		Long numberOfClientWithCPF = clientRepository.validateExistClientByCpf(client.getCpf());
		if (numberOfClientWithCPF > 0) {
			throw new ServiceException("Client already inside the bar");
		}
	}

	public Client findByCpf(String cpf) {
		Optional<Client> clientFound = clientRepository.findByCpf(cpf);
		if (clientFound.isPresent()) {
			return clientFound.get();
		}
		throw new ServiceException("Client not found inside the bar");
	}

	public void deleteAll() {
		this.clientRepository.deleteAll();
	}

	public void deleteByCpf(String cpf) {
		Optional<Client> client = clientRepository.findByCpf(cpf);
		if (client.isPresent()) {
			clientRepository.deleteById(client.get().getId());
		}
	}
	
	public List<ClientDTO> findAll(){
		List<ClientDTO> clientToReturn = new ArrayList<ClientDTO>();
		List<Client> clients = clientRepository.findAll();
		
		for (Client client : clients) {
			ClientDTO clientDTO = new ClientDTO();
			clientDTO.setName(client.getName());
			clientDTO.setCpf(client.getCpf());
			clientDTO.setAge(client.getAge());
			clientDTO.setGender(client.getGender());
			
			clientToReturn.add(clientDTO);
		}
		
		return clientToReturn;
	}

}
