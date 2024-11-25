# projeto

Descrição do Projeto
Este projeto é um sistema de gerenciamento de funcionários para uma empresa fictícia chamada TechCorp. Ele permite cadastrar, consultar, atualizar e excluir informações de funcionários de diferentes categorias, como desenvolvedores, gerentes, treinadores e gerentes desenvolvedores.

O sistema foi desenvolvido em Java, utilizando o padrão arquitetural MVC (Model-View-Controller), com persistência de dados em arquivos e armazenamento temporário utilizando ArrayList.

Funcionalidades
Cadastro de Funcionários
Permite registrar novos funcionários no sistema, especificando tipo, nome e salário.

Listagem de Funcionários
Exibe uma lista com os dados de todos os funcionários cadastrados.

Atualização de Funcionários
Permite alterar o nome e o salário de funcionários já registrados.

Exclusão de Funcionários
Remove um funcionário do sistema e do arquivo de persistência.

Persistência de Dados
Armazena os dados em um arquivo para garantir que as informações sejam mantidas mesmo após o encerramento do programa.

Tecnologias Utilizadas
Linguagem: Java
Arquitetura: MVC (Model-View-Controller)
Persistência: Arquivo de texto (funcionarios.txt)
Estruturas de Dados: ArrayList
Boas práticas: Clean Code

src/
├── app/
│   └── Main.java                  # Classe principal para iniciar o sistema
├── controller/
│   └── FuncionarioController.java # Controla a lógica do sistema
├── model/
│   ├── Funcionario.java           # Classe abstrata base para funcionários
│   ├── Desenvolvedor.java         # Subclasse de Funcionario
│   ├── Gerente.java               # Subclasse de Funcionario
│   ├── Treinador.java             # Subclasse de Funcionario
│   ├── GerenteDesenvolvedor.java  # Subclasse de Funcionario
│   ├── Desenvolve.java            # Interface para desenvolvedores
│   ├── Gerencia.java              # Interface para gerentes
│   └── Treina.java                # Interface para treinadores
├── view/
    └── FuncionarioView.java       # Interface com o usuário
