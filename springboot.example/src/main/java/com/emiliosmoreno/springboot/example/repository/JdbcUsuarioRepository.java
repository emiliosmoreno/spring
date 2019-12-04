package com.emiliosmoreno.springboot.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emiliosmoreno.springboot.example.beans.UsuarioBean;

@Repository
public class JdbcUsuarioRepository implements UsuarioRepository {

	// Spring Boot will create and configure DataSource and JdbcTemplate
	// To use it, just @Autowired
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from usuarios", Integer.class);
	}

	public int save(UsuarioBean usuario) {
		return jdbcTemplate.update("insert into usuarios (nombre, apellidos) values(?,?)", usuario.getNombre(), usuario.getApellidos());
	}

	public int update(UsuarioBean usuario) {
		return jdbcTemplate.update("update usuarios set apellidos = ? where id = ?",  usuario.getApellidos(),usuario.getNombre());
	}

	public int deleteById(Long id) {
		return jdbcTemplate.update("delete usuarios where id = ?", id);
	}

}
