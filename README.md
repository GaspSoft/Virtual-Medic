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

# 📖 Bibliotecas utilizadas
`Bibliotecas 1` : Atxy2k</br>
`Bibliotecas 2` : dom4j-2.1.4</br>
`Bibliotecas 3` : TimingFramework</br>
`Bibliotecas 4` : Filters-2.0.235</br>
`Bibliotecas 5` : Swing-Worker-1.1</br>
`Bibliotecas 6` : Swingx-1.6.1</br>
`Bibliotecas 7` : MigLayout15-Swing</br>

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
  <li><b>Pessoa</b>: a classe abstrata Pessoa representa uma entidade genérica de pessoa com atributos como CPF, nome, email, gênero e idade. Essa classe pode ser usada como uma base para criar subclasses mais específicas de pessoas, adicionando atributos e comportamentos adicionais, se necessário. A herança da classe Endereco indica que uma pessoa possui um endereço associado a ela.
  <li><b>Endereço</b>: a classe abstrata Endereco representa um endereço com atributos como CEP, UF, cidade, bairro, rua, número e complemento. Essa classe pode ser usada como uma base para criar subclasses mais específicas de endereço, adicionando atributos e comportamentos adicionais, se necessário. Ela fornece métodos de acesso para obter e modificar os atributos do endereço e também possui uma representação em formato de texto através do método toString().
  <li><b>Paciente</b>: a classe Paciente representa um paciente e herda os atributos e métodos da classe Pessoa. Ela possui atributos adicionais relacionados ao paciente, como o médico responsável, diagnóstico, plano de saúde, número do plano e validade. A classe fornece métodos de acesso para obter e modificar esses atributos e também possui uma representação em formato de texto através do método toString().
  <li><b>Médico</b>: a classe Medico representa um médico e herda os atributos e métodos da classe Pessoa. Ela possui atributos adicionais relacionados ao médico, como o número de registro (CRM) e a especificação ou especialização. A classe fornece métodos de acesso para obter e modificar esses atributos e também possui uma representação em formato de texto através do método toString().
  <li><b>Plano de Saúde</b>:  a classe PlanoSaude representa um plano de saúde. Ela possui atributos relacionados ao plano, como o identificador e o nome. A classe fornece métodos de acesso para obter e modificar esses atributos, possui uma representação em formato de texto através do método toString(), e também fornece um método remove() que ainda precisa ser implementado para remover o plano de saúde de uma lista.
  <li><b>MedicoDAO</b>: a classe DAOmedico encapsula operações de acesso a dados para manipulação de objetos Medico. Ela mantém uma lista de médicos em memória e fornece métodos para inserir, atualizar, excluir e consultar médicos na lista. O padrão Singleton é usado para garantir que haja apenas uma instância da classe DAOmedico durante a execução do programa.
  <li><b>PacienteDAO</b>: a classe DAOpaciente encapsula operações de acesso a dados para manipulação de objetos Paciente. Ela mantém uma lista de pacientes em memória e fornece métodos para inserir, atualizar, excluir e consultar pacientes na lista. O padrão Singleton é usado para garantir que haja apenas uma instância da classe DAOpaciente durante a execução do programa.
  <li><b>PlanoSaudeDAO</b>: a classe DAOplanoSaude encapsula operações de acesso a dados para manipulação de objetos PlanoSaude. Ela mantém uma lista de planos de saúde em memória e fornece métodos para inserir, atualizar, excluir e consultar planos de saúde na lista. O padrão Singleton é usado para garantir que haja apenas uma instância da classe DAOplanoSaude durante a execução do programa.
</ul>
  
# 📄 Documentação
<p align="center">
  <a href="https://docs.google.com/document/d/1183VnH4-KVf9r6mYwuRhlRnIPtvyNjijxaqpfvXsKVY/edit?usp=sharing">Link Documentação</a>
</p>
  
  
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










