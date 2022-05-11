package com.api.exemplo.util;

import com.api.exemplo.models.Endereco;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class ClasseRestTemplateUtil {

    public Endereco getUrl(String uri, Map<String, String> params){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, Endereco.class, params);
    }
}
