<p align="center">
  <img ![Estudo De Caso - Java] src="https://github.com/GaspSoft/Virtual-Medic/assets/86849487/56dd41c5-489e-4fe4-8273-27fda192fb13">
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
<p align="justify">Nosso objetivo é desenvolver um sistema desktop abrangente de prontuário eletrônico que permita a gestão eficiente de informações médicas, incluindo os dados de médicos, pacientes e planos de saúde. O sistema será projetado para atender às necessidades de clínicas e consultórios médicos, simplificando o gerenciamento de registros e melhorando a qualidade do atendimento ao paciente:</p>

1. **Gerenciamento de médicos:**
    - Cadastro de médicos com informações pessoais, especialização e dados de contato.
    - Capacidade de atualizar, visualizar e excluir registros de médicos.
2. **Gerenciamento de pacientes:**
    - Cadastro de pacientes com informações pessoais, histórico médico, alergias e dados de contato.
    - Possibilidade de atualizar, visualizar e excluir registros de pacientes.
3. **Gerenciamento de planos de saúde:**
    - Cadastro de planos de saúde com informações como nome, cobertura, detalhes de contato e requisitos específicos.
    - Capacidade de atualizar, visualizar e excluir registros de planos de saúde.

# 📃 Descrição do Sistema
<p align="justify">O sistema de prontuário eletrônico desktop é uma aplicação desenvolvida para simplificar e otimizar o gerenciamento de informações médicas em clínicas e consultórios. O sistema possui um conjunto de funcionalidades que permitem a realização das operações de criação, leitura, atualização e exclusão (CRUD) de médicos, pacientes e planos de saúde. A seguir, descrevemos cada uma dessas entidades e as principais características do sistema:</p>

1. **Médicos:**
O sistema permite o cadastro de médicos, que inclui informações pessoais como nome, especialização, endereço, número de telefone e e-mail. Os registros dos médicos podem ser atualizados, visualizados e excluídos conforme necessário. A funcionalidade de detalhar o médico permite encontrar médicos com base em critérios como nome, especialização ou número de identificação.
2. **Pacientes:**
O sistema oferece a possibilidade de cadastrar pacientes, armazenando informações como nome, data de nascimento, gênero, endereço, número de telefone e histórico médico. É possível incluir detalhes sobre alergias, medicações atuais e quaisquer outras informações relevantes para o atendimento médico adequado. Os registros dos pacientes podem ser atualizados, visualizados e excluídos quando necessário. A funcionalidade de detalhar o paciente permite encontrar pacientes com base em critérios como nome, número de identificação ou condições médicas específicas.
3. **Planos de Saúde:**
O sistema permite cadastrar os planos de saúde com os quais a clínica ou consultório trabalha. É possível registrar informações como nome do plano, detalhes de cobertura, requisitos específicos e informações de contato. Os registros dos planos de saúde podem ser atualizados, visualizados e excluídos conforme necessário. A funcionalidade de detalhar o plano de saúde permite encontrar planos de saúde com base em critérios como nome ou tipo de cobertura.

# 📈 Diagrama de Classes
<p align="center">

![image](https://github.com/pedrogodri/estudo-de-caso/assets/86849487/c3508f85-533a-4a58-8454-51deb4e2b297)
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
  
  
# 📈 Diagrama de Casos de Uso
<p align="center">
  
![DiagramaCasosUso drawio](https://github.com/GaspSoft/Virtual-Medic/assets/86849487/7fda6001-e3fe-4dad-801c-410a589cbb1f)
</p>
  
# 📈 Diagrama de Fluxos
<p align="center">

![DiagramaFluxo drawio](https://github.com/GaspSoft/Virtual-Medic/assets/86849487/1585ea69-7e5d-4f5f-965e-68acb924e9c5)


</p>


# ⌨️ Autores
| [<img src="https://avatars.githubusercontent.com/u/86849487?v=4" width=115><br><sub>Pedro Henrique Godri</sub>](https://github.com/pedrogodri) | [<img src="https://avatars.githubusercontent.com/u/111302374?v=4" width=115><br><sub>Vitor Hugo Schiphorst</sub>](https://github.com/VitorSchiphorst) |  [<img src="https://avatars.githubusercontent.com/u/114950761?v=4" width=115><br><sub>Bárbara do Nascimento</sub>](https://github.com/BahNasc) |
| :---: | :---: | :---:










