package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Cliente;
import com.cibertec.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente crear(Cliente cliente) throws Exception {
		if (cliente.getNombre() == null) {
			throw new Exception("Debe ingresar el nombre del Cliente");
		}
		if (cliente.getTipoDocumento() == null) {
			throw new Exception("Debe ingresar el tipo de documento");
		}
		if (cliente.getNroDocumento() == null) {
			throw new Exception("Debe ingresar el numero de documento");
		}
		return clienteRepository.save(cliente);
	}

	public Cliente editar(Cliente cliente) throws Exception {
		if (cliente.getNombre() == null) {
			throw new Exception("Debe ingresar el nombre del Cliente");
		}
		if (cliente.getTipoDocumento() == null) {
			throw new Exception("Debe ingresar el tipo de documento");
		}
		if (cliente.getNroDocumento() == null) {
			throw new Exception("Debe ingresar el numero de documento");
		}

		Cliente clienteEdit = getCliente(cliente.getIdCliente());

		clienteEdit.setNombre(cliente.getNombre());
		clienteEdit.setTipoDocumento(cliente.getTipoDocumento());
		clienteEdit.setNroDocumento(cliente.getNroDocumento());

		return clienteRepository.save(cliente);
	}

	public void eliminar(Integer idCliente) {
		clienteRepository.deleteById(idCliente);
	}

	public Cliente getCliente(Integer idCliente) throws Exception {
		Optional<Cliente> optCliente = clienteRepository.findById(idCliente);

		if (optCliente.isEmpty()) {
			throw new Exception("El Cliente con ID: " + idCliente + " no existe");
		}

		return optCliente.get();
	}

	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}

}
