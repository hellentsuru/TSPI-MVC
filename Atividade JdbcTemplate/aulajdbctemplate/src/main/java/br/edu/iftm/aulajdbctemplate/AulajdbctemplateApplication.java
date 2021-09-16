package br.edu.iftm.aulajdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class AulajdbctemplateApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AulajdbctemplateApplication.class, args);
	}

	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		jdbcTemplate.execute("DROP TABLE agenda IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE agenda (id SERIAL, nome VARCHAR(255), telefone VARCHAR(255))");

		jdbcTemplate.update("INSERT INTO agenda(nome, telefone) values (?, ?)", "Edson Angoti Junior", "9090 12345");
		jdbcTemplate.update("INSERT INTO agenda(nome, telefone) values (?, ?)", "José Angoti", "12346");
		jdbcTemplate.update("INSERT INTO agenda(nome, telefone) values (?, ?)", "Maria Angoti", "34567");

		Contato contato = jdbcTemplate.queryForObject(
        "SELECT id, nome, telefone FROM agenda where nome = ?",
        (rs, rowNum) -> { return new Contato(rs.getLong("id"), rs.getString("nome"), rs.getString("telefone"));},
        "Edson Angoti Junior");

		int rowCount = this.jdbcTemplate.queryForObject("select count(*) from agenda", Integer.class);
		System.out.println("\n\n=================================\n Numero telefone: "+contato.getTelefone());
		System.out.println("\n Numero de registros: " + rowCount);

			
	}

}
