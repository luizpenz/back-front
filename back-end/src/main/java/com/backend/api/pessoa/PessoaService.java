package com.backend.api.pessoa;

import com.backend.api.core.AbstractService;
import com.backend.api.core.exceptions.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService  extends AbstractService<Pessoa, PessoaRepository> {

    @Override
    public Pessoa update(Pessoa p) {
        if (p.getId() == null)
            throw new ServiceException("id cannot be null");

        Pessoa pessoa = this.findById(p.getId());
        pessoa.setCpf(p.getCpf());
        pessoa.setDataNascimento(p.getDataNascimento());
        pessoa.setEmail(p.getEmail());
        pessoa.setNacionalidade(p.getNacionalidade());
        pessoa.setNaturalidade(p.getNaturalidade());
        pessoa.setNome(p.getNome());
        pessoa.setSexo(p.getSexo());

        return this.save(pessoa);
    }
}
