package com.rddev.mvc.mudi.repository;

import com.rddev.mvc.mudi.interceptor.InterceptorAdapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcessoRepository extends JpaRepository<InterceptorAdapter.Acesso, Long> {
}
