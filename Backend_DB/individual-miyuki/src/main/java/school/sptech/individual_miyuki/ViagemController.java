package school.sptech.individual_miyuki;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/viagens")
public class ViagemController {

    public final JdbcTemplate jdbcTemplate;

    // Construtor:

    public ViagemController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Viagem>> listarViagens() {

        String sql = "SELECT * FROM viagem";

        List<Viagem> viagens = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Viagem.class));

        return ResponseEntity.status(200).body(viagens);
    }

    @GetMapping("/{apelidoViagem}")
    public ResponseEntity<Viagem> listarPorApelidoViagem(@PathVariable String apelidoViagem) {

        String sql = "SELECT * FROM viagem WHERE apelido_viagem = ?";

        List<Viagem> viagens = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Viagem.class),
                apelidoViagem
        );

        if (viagens.isEmpty()) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.status(200).body(viagens.get(0));
        }
    }




}
