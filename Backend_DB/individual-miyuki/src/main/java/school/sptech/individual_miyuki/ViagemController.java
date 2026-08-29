package school.sptech.individual_miyuki;

import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

@RestController

@RequestMapping("/viagens")
public class ViagemController {

    public final JdbcTemplate jdbcTemplate;

    // Construtor:

    public ViagemController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Requests:

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

    @PostMapping
    public ResponseEntity<Viagem> criarViagem(@RequestBody Viagem viagemParaCriar) {

        String apelidoViagem = viagemParaCriar.getApelidoViagem();
        String estacaoDoAno = viagemParaCriar.getEstacaoDoAno();
        LocalDate dataIda = viagemParaCriar.getDataIda();
        LocalDate dataVolta = viagemParaCriar.getDataVolta();
        Integer diasNoJapao = viagemParaCriar.getDiasNoJapao();
        Double reservaViagem = viagemParaCriar.getReservaViagem();

        if (!viagemValidada(apelidoViagem, estacaoDoAno, dataIda, dataVolta, diasNoJapao, reservaViagem)) {
            return ResponseEntity.status(400).build();
        }

        if (existeApelidoViagem(apelidoViagem)) {
            return ResponseEntity.status(409).build();
        }

        String sql = "INSERT INTO viagem (apelido_viagem, estacao_do_ano, data_ida, data_volta, dias_no_japao, reserva_viagem) VALUES (?,?,?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, apelidoViagem);
            ps.setString(2, estacaoDoAno);
            ps.setObject(3, dataIda);
            ps.setObject(4, dataVolta);
            ps.setInt(5, diasNoJapao);
            ps.setDouble(6, reservaViagem);

            return ps;
        }, keyHolder);

        Integer idGerado = keyHolder.getKeyAs(Integer.class);

        viagemParaCriar.setId(idGerado);

        return ResponseEntity.status(201).body(viagemParaCriar);
    }

    // Validações:

    public boolean existeApelidoViagem(String apelidoViagem) {

        String sqlExisteApelidoViagem = "SELECT COUNT(*) FROM viagem WHERE UPPER(apelido_viagem) = ?";

        Integer countId = jdbcTemplate.queryForObject(sqlExisteApelidoViagem,
                Integer.class,
                apelidoViagem.toUpperCase()
        );

        boolean existeApelidoViagem = countId >= 1;
        return existeApelidoViagem;
    }

    public boolean viagemValidada(String apelidoViagem, String estacaoDoAno, LocalDate dataIda, LocalDate dataVolta, Integer diasNoJapao, Double reservaViagem) {

        if (apelidoViagem == null || apelidoViagem.isBlank() ||
                estacaoDoAno == null || estacaoDoAno.isBlank() ||
                dataIda == null ||
                dataVolta == null ||
                diasNoJapao == null ||
                reservaViagem == null) {

            return false;
        }
        return true;
    }


}
