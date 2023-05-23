<p align="center">
  <img ![Estudo De Caso - Java] src="https://github.com/GaspSoft/Virtual-Medic/assets/86849487/4efa5659-61fe-485f-8085-41d8656954c4">
</p>

<h1 align="center"> Estudo de Caso </h1>

<p align="center"><a href="https://github.com/pedrogodri/estudo-de-caso/blob/main/LICENSE"><img alt="GitHub Licença" src="https://img.shields.io/badge/License-CC0--1.0-blue"></a>
<a href="https://github.com/pedrogodri/estudo-de-caso/blob/main/STATUS"><img alt="GitHub Status de Desenvolvimento" src="https://img.shields.io/badge/Status-Desenvolvimento-blue"></a>
<a href="https://github.com/pedrogodri/estudo-de-caso/blob/main/RELEASE-DATE"><img alt="GitHub Data Entrega" src="https://img.shields.io/badge/Release%20Date-Dezembro-blue"></a></p>
<p align="center"> :construction: <b>Projeto em construção</b> :construction: </p>

# :hammer: Funcionalidades do projeto

| `Cadastrar` | `Alterar` | `Excluir` | `Listar`
| --- | --- | --- | --- | 
| Médico | Médico | Médico | Médico |
| Paciente | Paciente | Paciente | Paciente |
| Plano de Saúde | Plano de Saúde | Plano de Saúde | Plano de Saúde |

# 🏗️ Tecnologias utilizadas
`Tecnologia 1` : Java 17</br>
`Tecnologia 2` : Java SE JDK 8</br>
`Tecnologia 3` : Java Swing</br>
`Tecnologia 4` : IDE eclipse workspace</br>
`Tecnologia 5` : Window Builder</br>

# 📝 Proposta Geral
<p align="justify">O sistema tem como objetivo a venda de automóveis, busca auxiliar e promover de forma mais simples os usuários. Para isso o mesmo contará com diversas funcionalidades, como o usuário realizar o seu cadastro e caso queira vender seu automóvel pode cadastrar o mesmo com as informações necessárias, possibilitando ainda alterar algo se necessário. Já o comprador poderá buscar os carros, motos, caminhões ou ônibus, por fim o mesmo poderá comprar o carro do vendedor. Assim se finaliza a proposta geral, que tem como objetivo principal garantir ao usuário uma visão ampla sobre os automóveis e assim realizar a compra do mesmo</p>

# 📃 Descrição do Sistema
<p align="justify">Tendo em vista que a forma utilizada atualmente é arcaica, nosso sistema visa facilitar a vida dos usuário nas compras e troca de carros. Tem como objetivo tornar mais prática a venda de automóveis, contando com as opções de criar um usuário realizando o seu cadastro Caso o usuário seja um vendedor, poderá cadastrar um carro, moto, ônibus ou caminhão. Se necessário o vendedor pode descadastrar um veículo também. Mas se o usuário for um comprador, ele poderá comprar os veículos anunciados pelos vendedores, e também poderá anunciar seus veículos.</p>

# 📈 Diagrama de Classes
<p align="center">

![image](https://github.com/pedrogodri/estudo-de-caso/assets/86849487/c3508f85-533a-4a58-8454-51deb4e2b297)
  
# 📈 Diagrama de Casos de Uso
<p align="center">
  
![DiagramaCasosUso drawio](https://github.com/GaspSoft/Virtual-Medic/assets/86849487/7fda6001-e3fe-4dad-801c-410a589cbb1f)

  
# 📈 Diagrama de Fluxos
<p align="center">

![DiagramaFluxo drawio](https://github.com/GaspSoft/Virtual-Medic/assets/86849487/1585ea69-7e5d-4f5f-965e-68acb924e9c5)


</p>
<ul>
  <li><b>Veiculo</b>: Possui uma associação a classe VeiculoDAO. Tem atributos privados, sendo eles: marca, modelo, tipo, cor, placa, tipoAutomovel e tipoCombustivel que são do tipo String, possui também anoFabricacao, qtdPeneu, totalDonos e informacaoAutomovel que são do tipo Integer e informacaoAutomovel que é um Float. Possui três métodos publicos sem retorno, dentre eles veiculoEspecificação com características específicas e veiculoUtilizado e estadoVeiculo;
  <li><b>VeiculoDAO</b>: Possui uma associação a classe Veiculo. Tem um atributo privado que é um ArrayList de veículos. Tem cinco métodos públicos e sem retorno são eles: listar, cadastrar, alterar, excluir e comprar;
  <li><b>Carro</b>: Herda da classe Veiculo. Possui três atributos privados do tipo Integer, dentre eles: numeroPortas, numeroBancos e cavalosMotor. Ainda possui dois atributos privados booleanos sendo eles airBag e arCondicionado;
  <li><b>Moto</b>: Herda da classe Veiculo. Possui dois atributos privados Integer sendo eles numeroRodas cilindroMoto e possui um booleano privado chamado bagageiro;
  <li><b>Pesados</b>: Herda de Veiculo e tem dois atributos privados, dentre eles uma String o sistemaFrenagem e um Float, o comprimento;
  <li><b>Onibus</b>: Herda da classe Pesados e possui um atributo privado do tipo Integer o bancosPassageiros;
  <li><b>Caminhão</b>: Herda da classe Pesados, possui dois atributos privados uma String o tipoCaminhao e um Integer o pesoCarga;
</ul>

# ⌨️ Autores
| [<img src="https://avatars.githubusercontent.com/u/86849487?v=4" width=115><br><sub>Pedro Henrique Godri</sub>](https://github.com/pedrogodri) | [<img src="https://avatars.githubusercontent.com/u/111302374?v=4" width=115><br><sub>Vitor Hugo Schiphorst</sub>](https://github.com/VitorSchiphorst) |  [<img src="https://avatars.githubusercontent.com/u/114950761?v=4" width=115><br><sub>Bárbara do Nascimento</sub>](https://github.com/BahNasc) |
| :---: | :---: | :---:
