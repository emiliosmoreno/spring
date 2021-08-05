package com.emiliosmoreno.springboot.command;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.emiliosmoreno.springboot.command.beans.UsuarioBean;
import com.emiliosmoreno.springboot.command.repository.UsuarioRepository;

@SpringBootApplication
public class App implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("jdbcUsuarioRepository") // Test JdbcTemplate
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		runJDBC();
	}

	void runJDBC() {

		log.info("Creating tables for testing...");

		jdbcTemplate.execute("DROP TABLE usuarios IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE usuarios(" + "id SERIAL, nombre VARCHAR(255), apellidos VARCHAR(255))");

		List<UsuarioBean> books = Arrays.asList(
				new UsuarioBean("Emilio", "M.","1234567z"),
				new UsuarioBean("Daniel", "D.", "123654z"), 
				new UsuarioBean("Jesus", "C.","43456567z"));

		log.info("[SAVE]");
		books.forEach(UsuarioBean -> {
			log.info("Saving...{}", UsuarioBean.getNombre());
			usuarioRepository.save(UsuarioBean);
		});

		// count
		log.info("[COUNT] Total usuarios: {}", usuarioRepository.count());

	}
}
