# language: pt

Dado(/^que o valor padrao e "(.*?)"$/) do |percentual|
  # verifica se o label que inicialmente e de 15% existe na tela
  element_exists("label marked:'#{percentual}'")
end

Quando(/^eu informo o valor da conta como "(.*?)"$/) do |texto|
  # toca no campo para entrar com o valor
  touch("view:'UITextField'")

  # informa o valor para o campo
  keyboard_enter_text "#{texto}"
end

Quando(/^clico no botao "(.*?)"$/) do |botao|
  # toca no botao para calcular a gorjeta
  touch("view marked:'#{botao}'")
end

Entao(/^o valor total deve ser de "(.*?)"$/) do |valor|
  total = query("label", :text)[5]
  assert_equal total, "$115.00"
end
