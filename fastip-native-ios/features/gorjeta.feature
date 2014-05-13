# language: pt
# locale: utf-8

Funcionalidade: Calculando gorjeta no Brasil
   Como um cliente de um estabelecimento
   Eu gostaria de dar um gorjeta ao garçom
   Para que ele possa complementar o seu salario

   Cenario: Validando o valor da gorgeta
      Dado que o valor padrao e "15.00%"
      Quando eu informo o valor da conta como "100"
        E clico no botao "Calculate Tip"
      Entao o valor total deve ser de "115.00"
