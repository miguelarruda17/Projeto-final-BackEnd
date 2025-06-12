package org.example.services;

import org.example.dto.ClienteDTO;
import org.example.entities.Cliente;
import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.repositories.ClienteRepository;
import org.example.repositories.ContatoRepository;
import org.example.repositories.EnderecoRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.example.services.exeptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Cliente insert(Cliente obj) {

        try {

            obj.setCliId(null);
            obj = clienteRepository.save(obj);
            contatoRepository.saveAll(obj.getContatos());
            enderecoRepository.saveAll(obj.getEnderecos());

            return obj;
        } catch (DataIntegrityViolationException e) {

          throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Cliente update(Long id, ClienteDTO objDTO) {

        try{
            Cliente entity = findById(id);

            entity.setCliNome(objDTO.getCliNome());
            entity.setCliCpf(objDTO.getCliCpf());

            Contato contato = entity.getContatos().get(0);

            contato.setConCelular(objDTO.getConCelular());
            contato.setConTelefoneComercial(objDTO.getConTelefoneComercial());
            contato.setConEmail(objDTO.getConEmail());

            Endereco endereco = entity.getEnderecos().get(0);

            endereco.setEndRua(objDTO.getEndRua());
            endereco.setEndNumero(objDTO.getEndNumero());
            endereco.setEndCidade(objDTO.getEndCidade());
            endereco.setEndCep(objDTO.getEndCep());
            endereco.setEndEstado(objDTO.getEndEstado());

            clienteRepository.save(entity);

            return entity;


        }catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());       }

    }

    public void deleteCliente(Long id) {
        try {
            clienteRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Cliente fromDTO(ClienteDTO objDTO) {
        Cliente cliente = new Cliente(null, objDTO.getCliNome(), objDTO.getCliCpf());

        Endereco ender = new Endereco(null, cliente, objDTO.getEndRua(), objDTO.getEndNumero(),
                objDTO.getEndCidade(), objDTO.getEndCep(),
                objDTO.getEndEstado());

        Contato contato = new Contato(null, cliente, objDTO.getConCelular(), objDTO.getConTelefoneComercial(),
                objDTO.getConEmail());

        cliente.getEnderecos().add(ender);
        cliente.getContatos().add(contato);

        return cliente;
    }

    public ClienteDTO toNewDTO(Cliente obj) {
        ClienteDTO dto = new ClienteDTO();

     // Mapeie os atributos comuns entre Cliente e ClienteNewDTO
        dto.setCliId(obj.getCliId());
        dto.setCliNome(obj.getCliNome());
        dto.setCliCpf(obj.getCliCpf());

    // Atributos específicos de Endereco
        Endereco endereco = obj.getEnderecos().get(0);
        dto.setEndRua(endereco.getEndRua());
        dto.setEndNumero(endereco.getEndNumero());
        dto.setEndCidade(endereco.getEndCidade());
        dto.setEndCep(endereco.getEndCep());
        dto.setEndEstado(endereco.getEndEstado());

    // Atributos específicos de Contato
        Contato contato = obj.getContatos().get(0);
        dto.setConCelular(contato.getConCelular());
        dto.setConTelefoneComercial(contato.getConTelefoneComercial());
        dto.setConEmail(contato.getConEmail());

        return dto;
    }
}
