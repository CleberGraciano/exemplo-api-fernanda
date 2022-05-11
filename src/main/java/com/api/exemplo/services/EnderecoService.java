package com.api.exemplo.services;

import com.api.exemplo.models.Endereco;
import com.api.exemplo.repositories.EnderecoRepository;
import com.api.exemplo.util.ClasseRestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco buscaSalvaEndereco(String cep){

            ClasseRestTemplateUtil classeRestTemplateUtil = new ClasseRestTemplateUtil();
            String uri = "https://viacep.com.br/ws/{cep}/json/";
            Map<String, String> parametros = new HashMap<String, String>();
            parametros.put("cep", cep);
            Endereco endereco = classeRestTemplateUtil.getUrl(uri, parametros);
            endereco.setCep(endereco.getCep().replace("-",""));
            return enderecoRepository.save(endereco);

    }


    public Endereco buscaPorCepBanco(String cep){
        return enderecoRepository.findByCep(cep);
    }

    public List<Endereco> buscaCeps(){
        return enderecoRepository.findAll();
    }
}
