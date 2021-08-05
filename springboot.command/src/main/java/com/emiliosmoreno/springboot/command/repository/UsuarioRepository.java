package com.emiliosmoreno.springboot.command.repository;

import com.emiliosmoreno.springboot.command.beans.UsuarioBean;

public interface UsuarioRepository {
	
	int count();

    int save(UsuarioBean usuario);

    int update(UsuarioBean usuario);

    int deleteById(Long id);
    
}
