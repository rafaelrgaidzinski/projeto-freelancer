# projeto-freelancer
Projeto de uma plataforma para conectar profissionais com ofertas de vagas freelancer.

Este projeto foi desenvolvido utilizando a linguagem Java e o framework Spring Boot.

O projeto foi implementado inicialmente contendo os models: 
- EstabelecimentoModel (Respresenta restaurantes e outros tipos de estabelecimentos que desejam cadastrar suas ofertas de vaga para freelancers)
- OfertaModel (Representa as informações da vaga para freelancer cadastrada)

Além dos models foram implementados os Dtos de cada model para fazer a validação dos dados do corpo da requisição HTTP.

Para persistir os dados foram criados os repositories EstabelecimentoRepository e OfertaRepository que herdam as funções da classe JpaRepository
para realizar a persistência dos dados no banco de dados H2 Database que teve sua depedência adicionada no pom.xml e foi configurado no arquivo 
application.properties.

Foram implementados os seguintes Services:

- EstabelecimentoService e OfertaService: com os métodos save, delete e find que serão implementados no Controller para a criação do CRUD
  e que utilizam da Annotation @Autowired para fazer a injeção de dependência dos respectivos @Repositories.
- CambioService: com o método "requisicaoCambio" para fazer uma requisição na API de Cotações da Awesome API que retorna as informações da
  última cotação do câmbio das moedas informadas na url.

Os seguintes Controllers foram implementados:

- EstabelecimentoController e OfertaController: que utilizam da Annotation @Autowired para fazer a injeção de dependência dos respectivos @Services
  e possuem os métodos POST para salvar, PUT para atualizar, DELETE para deletar e GET para buscar todas ou somente uma informação.
- AjudaController: foi implementado somente com o método GET para retornar as informações do projeto.
- CambioController: foi implementado somente com o método GET para realizar a requisição na API de Cotações.

Para executar este projeto, basta seguir os seguintes passos:

1- Abrir o terminal de comando e navegar até o diretório onde deseja salvar o projeto 

2- Utilizar o seguinte comando no terminal para copiar o projeto para o seu repositório local: 
   git clone https://github.com/rafaelrgaidzinski/projeto-freelancer.git

3- Abrir a pasta do projeto utilizando o IntelliJ ou outro programa

4- No arquivo application.properties alterar o datasource do H2 Database para um repositório local:
   pring.datasource.url=jdbc:h2:file:C:/Users/rafae/freelancer

5- Agora é só rodar o projeto e utilizar o Postman ou Insomnia para realizar as requisições HTTP






