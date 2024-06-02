# Projeto - Desenvolvimento de Software
# Clinica Médica

# Diagrama Básico

                            +---------------------+
                            |     Pessoa          |
                            +---------------------+
                            | - nome: String      |
                            | - telefone: String  |
                            | - email: String     |
                            | - endereco: String  |
                            +-----------+---------+
                                        |
                                        |
                                        |
               +------------------------+------------------------------+
               |                        |                              |
               |                        |                              |
               |                        |                              |
               |                        |                              |
               |                        |                              |
  +---------------------+    +---------------------+    +-----------------------+
  |  PessoaPaciente     |    |    PessoaMedico     |    |   PessoaFornecedor    |
  +---------------------+    +---------------------+    +-----------------------+
  | - cpf: String       |    | - cpf: String       |    | - cnpj: String        |
  | - sus: String       |    | - crm: String       |    | - marca: String       |
  +---------------------+    | - especialidade:    |    +-----------------------+
            |                | String              |				|		
            |                +---------------------+				|
            |							|							|
            |                           |                           |
            |                           |                           |
            |                           |                           |
			+---------------------------+                           |
							|										|
							|										|
                   +------------------+								|
                   |  Agendamento     |								|
                   +------------------+								|		
                   | - data: Date     |								|	
                   | - paciente:      |								|	
                   |   PessoaPaciente |								|
                   | - medico:        |								|
                   |   PessoaMedico   |								|
                   | - especialidade: |								|	
                   |   String         |								|
                   +------------------+								|
                           |										|
                           |										|	
                           |										|	
                   +----------------+					+-----------+---------+
                   |   Historico    |					|    Medicamento      |
                   +----------------+					+---------------------+
                   | - agendamento: |					| - nome: String      |	
                   |   Agendamento  +-------------------+					  |
                   | - medicamento: |					| - marca:            |
                   |   Medicamento  |					|   PessoaFornecedor  |
                   +----------------+					+---------------------+

                   