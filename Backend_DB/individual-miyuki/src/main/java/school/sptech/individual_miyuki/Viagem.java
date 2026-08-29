package school.sptech.individual_miyuki;

import java.time.LocalDate;

public class Viagem {

    // Atributos:

    private Integer id;
    private String apelidoViagem;
    private String estacaoDoAno;
    private LocalDate dataIda;
    private LocalDate dataVolta;
    private Integer diasNoJapao;
    private Double reservaViagem;

    // Construtores:

    public Viagem() {
    }

    public Viagem(Integer id, String apelidoViagem, String estacaoDoAno, LocalDate dataIda, LocalDate dataVolta, Integer diasNoJapao, Double reservaViagem) {
        this.id = id;
        this.apelidoViagem = apelidoViagem;
        this.estacaoDoAno = estacaoDoAno;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
        this.diasNoJapao = diasNoJapao;
        this.reservaViagem = reservaViagem;
    }

    // Getters e setters:


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApelidoViagem() {
        return apelidoViagem;
    }

    public void setApelidoViagem(String apelidoViagem) {
        this.apelidoViagem = apelidoViagem;
    }

    public String getEstacao() {
        return estacaoDoAno;
    }

    public void setEstacao(String estacaoDoAno) {
        this.estacaoDoAno = estacaoDoAno;
    }

    public LocalDate getDataIda() {
        return dataIda;
    }

    public void setDataIda(LocalDate dataIda) {
        this.dataIda = dataIda;
    }

    public LocalDate getDataVolta() {
        return dataVolta;
    }

    public void setDataVolta(LocalDate dataVolta) {
        this.dataVolta = dataVolta;
    }

    public Integer getDiasNoJapao() {
        return diasNoJapao;
    }

    public void setDiasNoJapao(Integer diasNoJapao) {
        this.diasNoJapao = diasNoJapao;
    }

    public Double getDinheiroViagem() {
        return reservaViagem;
    }

    public void setDinheiroViagem(Double reservaViagem) {
        this.reservaViagem = reservaViagem;
    }
}
