package org.example.services;

import org.example.dto.FornecedorDTO;
import org.example.entities.Fornecedor;
import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.repositories.ContatoRepository;
import org.example.repositories.EnderecoRepository;
import org.example.repositories.FornecedorRepository;

import org.example.services.exeptions.ResourceNotFoundException;
import org.example.services.exeptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Fornecedor> getAll() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor findById(Long id) {
        Optional<Fornecedor> obj = fornecedorRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Fornecedor insert(FornecedorDTO obj) {

        Fornecedor fornecedor = fromDTO(obj);
        return fornecedorRepository.save(fornecedor);

    }

    public Fornecedor update(Long id, FornecedorDTO objDTO) {

        try{
            Fornecedor entity = findById(id);

            entity.setForNomeFantasia(objDTO.getForNomeFantasia());
            entity.setForRazaoSocial(objDTO.getForRazaoSocial());
            entity.setForCnpj(objDTO.getForCnpj());
            entity.setForStatus(objDTO.getForStatus());

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

            fornecedorRepository.save(entity);

            return entity;


        }catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());       }

    }

    public void delete(Long id) {
        try {
            fornecedorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Fornecedor fromDTO(FornecedorDTO objDTO) {
        Fornecedor fornecedor = new Fornecedor(null, objDTO.getForNomeFantasia(), objDTO.getForRazaoSocial(), objDTO.getForCnpj(), objDTO.getForStatus());

        Contato contato = new Contato(null, fornecedor, objDTO.getConCelular(), objDTO.getConTelefoneComercial(),
                objDTO.getConEmail());

        Endereco endereco = new Endereco(null, fornecedor, objDTO.getEndRua(), objDTO.getEndNumero(),
                objDTO.getEndCidade(), objDTO.getEndCep(),
                objDTO.getEndEstado());

        fornecedor.getContatos().add(contato);
        fornecedor.getEnderecos().add(endereco);

        return fornecedor;
    }

    public FornecedorDTO toNewDTO(Fornecedor obj) {
        FornecedorDTO dto = new FornecedorDTO();

        // Mapeie os atributos comuns entre Fornecedor e FornecedorDTO
        dto.setForId(obj.getForId());
        dto.setForNomeFantasia(obj.getForNomeFantasia());
        dto.setForRazaoSocial(obj.getForRazaoSocial());
        dto.setForCnpj(obj.getForCnpj());
        dto.setForStatus(obj.getForStatus());

        // Atributos específicos de Contato
        Contato contato = obj.getContatos().get(0);
        dto.setConCelular(contato.getConCelular());
        dto.setConTelefoneComercial(contato.getConTelefoneComercial());
        dto.setConEmail(contato.getConEmail());

        // Atributos específicos de Endereco
        Endereco endereco = obj.getEnderecos().get(0);
        dto.setEndRua(endereco.getEndRua());
        dto.setEndNumero(endereco.getEndNumero());
        dto.setEndCidade(endereco.getEndCidade());
        dto.setEndCep(endereco.getEndCep());
        dto.setEndEstado(endereco.getEndEstado());



        return dto;
    }
}