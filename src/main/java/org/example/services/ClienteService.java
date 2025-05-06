package org.example.services;

import org.example.entities.Cliente;
import org.example.repositories.ClienteRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> getAll() {
        return repository.findAll();
    }

    public Cliente findById(Long id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Cliente insert(Cliente cliente) {
        return repository.save(cliente);
    }

    public boolean update(Long id, Cliente cliente) {
        Optional<Cliente> clienteOptional = repository.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente clienteSistem = clienteOptional.get();
            clienteSistem.setCliNome(cliente.getCliNome());
            clienteSistem.setCliEmail(cliente.getCliEmail());
            clienteSistem.setCliTelefone(cliente.getCliTelefone());
            clienteSistem.setCliCpf(cliente.getCliCpf());
            repository.save(clienteSistem);
            return true;
        }
        return false;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
