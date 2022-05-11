package com.api.exemplo.controllers;

import com.api.exemplo.models.Endereco;
import com.api.exemplo.services.CepService;
import com.api.exemplo.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private CepService cepService;

    @GetMapping("/{cep}")
    private Endereco buscaCep (@PathVariable String cep){
        return enderecoService.buscaPorCepBanco(cep)!=null ? enderecoService.buscaPorCepBanco(cep) : enderecoService.buscaSalvaEndereco(cep);
    }

    @GetMapping()
    private List<Endereco> listarCeps (){

        return enderecoService.buscaCeps();

    }

    @GetMapping("/feign/{cep}")
    public ResponseEntity<Endereco> getCepFeign(@PathVariable String cep) {

        Endereco endereco = cepService.buscaEnderecoPorCepFeign(cep);

        return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build();
    }


}
