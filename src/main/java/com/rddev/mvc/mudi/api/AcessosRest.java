package com.rddev.mvc.mudi.api;

import com.rddev.mvc.mudi.interceptor.InterceptorAdapter;
import com.rddev.mvc.mudi.repository.AcessoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/acessos")
@RestController
@RequiredArgsConstructor
public class AcessosRest {

    private final AcessoRepository acessoRepository;

    @GetMapping
    public List<InterceptorAdapter.Acesso> getAcessos() {
        return acessoRepository.findAll();
    }
}
