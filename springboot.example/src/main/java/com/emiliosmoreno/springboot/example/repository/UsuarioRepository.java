package com.emiliosmoreno.springboot.example.repository;

import com.emiliosmoreno.springboot.example.beans.UsuarioBean;

public interface UsuarioRepository {
	
	int count();

    int save(UsuarioBean usuario);

    int update(UsuarioBean usuario);

    int deleteById(Long id);
    
}
