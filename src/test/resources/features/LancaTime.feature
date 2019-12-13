#language:pt
#coding: utf-8
@funcionais
Funcionalidade: Lanca Time
  Gostaria de timeSheet do dia

  Contexto: 
    Dado que estou com o navegador aberto
    Quando preencho na barra de endereco o link "http://sco.rsinet.com.br/"

  Esquema do Cenario: Lancamento de ponto
    Quando inicio a chave de acesso
    E informo o usuario "<usuario>"
    E a senha "<senha>"
    E seleciono entrar
    Dado que estou no Menu Principal
    E passo o a filial da sessao
    E informo a planta
    E clico no ponto
    E clico em lancamento de ponto

    Exemplos: 
      | usuario        | senha        | projeto                                            | demanda              |
      | eduardo.matias | eduhitman1** | (7505) - TREINAMENTO HUBB - MODELO E TRABALHO ITAU | Treinamento Dezembro |

  Esquema do Cenario: Lancamento de timeSheet
    Quando inicio a chave de acesso
    E informo o usuario "<usuario>"
    E a senha "<senha>"
    E seleciono entrar
    Dado que estou no Menu Principal
    E passo o a filial da sessao
    E informo a planta
    E clico em lancamento de timeSheet
    Dado que estou em cadastrar TimeSheet
    E informa projeto "<projeto>"
    E passo a demanda "<demanda>"
    Dado passo a tarefa
    E a hora trabalhada
    E informo as horas arbitradas "0080"
    Entao descreva atividade do dia "Modelagem do mainframe"
    
    

    Exemplos: 
      | usuario        | senha        | projeto                                            | demanda              |
      | eduardo.matias | eduhitman1** | (7505) - TREINAMENTO HUBB - MODELO E TRABALHO ITAU | Treinamento Dezembro |
