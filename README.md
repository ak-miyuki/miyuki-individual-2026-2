# Nippon Insight

## Execução

### Back-end

O back-end foi desenvolvido em **Java com Spring Boot e JDBC**.

1. Abra o projeto no IntelliJ IDEA.
2. Execute a aplicação Spring Boot.
3. A API ficará disponível em:

```text
http://localhost:8080
```

### Front-end

O front-end foi desenvolvido com **HTML, CSS e JavaScript (Vanilla)**.

1. Abra o projeto no VS Code.
2. Execute o arquivo HTML utilizando o **Live Server**.
3. O front-end ficará disponível em:

```text
http://127.0.0.1:5500
```

## Comunicação entre Front-end e API

O usuário deve acessar o sistema pelo **Live Server** (`http://127.0.0.1:5500/public/index.html`), escolher uma estação do ano e preencher o formulário. Ao clicar em **Cadastrar**, o front-end executa o `POST /viagens` utilizando `fetch()`. A API valida os dados e cadastra a viagem no banco de dados.

Após o cadastro, o sistema executa o `GET /viagens`, busca todas as viagens cadastradas e atualiza o `SELECT`, criando um `option` para cada `apelidoViagem`.

Ao selecionar um apelido no `SELECT`, o front-end executa o `GET /viagens/{apelidoViagem}` e exibe os dados da viagem escolhida na tela.

### Endpoints

#### GET `/viagens`

Busca todas as viagens cadastradas.

**Request:**

```http
GET http://localhost:8080/viagens
```

**Response:**

```json
[
    {
        "id": 1,
        "apelidoViagem": "ferias2026",
        "estacaoDoAno": "Inverno",
        "dataIda": "2026-12-19",
        "dataVolta": "2027-01-10",
        "diasNoJapao": 20,
        "reservaViagem": 10000.0
    }
]
```

#### GET `/viagens/{apelidoViagem}`

Busca uma viagem pelo `apelidoViagem`.

**Request:**

```http
GET http://localhost:8080/viagens/ferias2026
```

**Response:**

```json
{
    "id": 1,
    "apelidoViagem": "ferias2026",
    "estacaoDoAno": "Inverno",
    "dataIda": "2026-12-19",
    "dataVolta": "2027-01-10",
    "diasNoJapao": 20,
    "reservaViagem": 10000.0
}
```

#### POST `/viagens`

Cadastra uma nova viagem.

**Request:**

```http
POST http://localhost:8080/viagens
Content-Type: application/json
```

```json
{
    "apelidoViagem": "ferias2026",
    "estacaoDoAno": "Inverno",
    "dataIda": "2026-12-19",
    "dataVolta": "2027-01-10",
    "diasNoJapao": 20,
    "reservaViagem": 10000.0
}
```

**Response — 201 Created:**

```json
{
    "id": 1,
    "apelidoViagem": "ferias2026",
    "estacaoDoAno": "Inverno",
    "dataIda": "2026-12-19",
    "dataVolta": "2027-01-10",
    "diasNoJapao": 20,
    "reservaViagem": 10000.0
}
```

A comunicação entre o front-end e o back-end é permitida pelo **CORS** configurado na API.

