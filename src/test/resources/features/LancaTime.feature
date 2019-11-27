#language:pt
#coding: utf-8
@funcionais
Funcionalidade: Lanca Time
  Gostaria de timeSheet do dia

Contexto:
    Dado que estou com o navegador aberto
    Quando preencho na barra de endereco o link "http://sco.rsinet.com.br/"
     
Esquema do Cenario:    
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
    E a data Trabalhada
    Entao informo as horas arbitradas "0080"
    
    
    
Exemplos:
|    usuario   |    senha    |                     projeto                        |         demanda       |    
|eduardo.matias|    senha    | (7505) - TREINAMENTO HUBB - MODELO E TRABALHO ITAU |  Treinamento Novembro |

    
