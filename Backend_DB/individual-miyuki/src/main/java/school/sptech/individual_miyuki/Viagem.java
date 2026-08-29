package school.sptech.individual_miyuki;

import java.time.LocalDate;

public class Viagem {

    // Atributos:

    private Integer id;
    private String apelidoViagem;
    private String estacao;
    private LocalDate dataIda;
    private LocalDate dataVolta;
    private Integer diasNoJapao;
    private Double dinheiroViagem;

    // Construtores:

    public Viagem() {
    }

    public Viagem(Integer id, String apelidoViagem, String estacao, LocalDate dataIda, LocalDate dataVolta, Integer diasNoJapao, Double dinheiroViagem) {
        this.id = id;
        this.apelidoViagem = apelidoViagem;
        this.estacao = estacao;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
        this.diasNoJapao = diasNoJapao;
        this.dinheiroViagem = dinheiroViagem;
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
        return estacao;
    }

    public void setEstacao(String estacao) {
        this.estacao = estacao;
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
        return dinheiroViagem;
    }

    public void setDinheiroViagem(Double dinheiroViagem) {
        this.dinheiroViagem = dinheiroViagem;
    }
}
