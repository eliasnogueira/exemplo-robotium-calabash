# Exemplo de Automação com Robotium e Calabash (iOS)

Este repositório contém projetos de exemplo para mostrar, de forma básica, a automação para dispositivos móveis utilizando [Robotium] e [Calabash] [para iOS].

### De onde veio a idéia deste repositório?
Este repositório foi criado para exemplificar uma palestra no The Developers Conference 2014 Florianópolis com o título _Como testar sua aplicação Android e iOS: uma abordagem prática_ na Trilha de Teste.

Este apresentação está disponível [aqui]

O exemplo destas duas aplicações foram retirados dos seguintes posts:
  - Four Ways To Build A Mobile Application, Part 1: Native iOS
  - Four Ways To Build A Mobile Application, Part 2: Native Android

##Automatizando para Android com Robotium


### Instalação
Serão necessários os seguintes itens:

  - [Java JDK]
  - [Eclipse ADT]
  - [Biblioteca do Robotium]
  - API 15 ou superior instalada via SDK Manager

### Projetos
Existem dois projetos referentes a automação com Robotium
  - **fastip-native-android:** aplicação real alvo dos testes
  - **fastip-native-android-test:** projeto de teste para automação do projeto alvo

O projeto de teste precisa estar ligado ao projeto do real.
Para isso, no Eclipse, siga os passos:
  1. Clique com o botão direito no projeto de teste e selecione _Build Path/Configure Build Path..._
  2. Clique na aba _Projects_
  3. Clique no botão _Add_
  4. Selecione o projeto real (FastTip) e clique em OK

Um outro item necessário é associar a biblioteca do Robotium ao projeto. Provavelmente seu projeto estará com um "x" vermelho, que é um indicativo da biblioteca faltante. Execute os seguintes passos:
  1. Faça o download da biblioteca do Robotium
  2. Clique com o botão direito no projeto de teste e selecione _Build Path/Configure Build Path..._
  3. Selecione a aba _Libraries_
  4. Selecione a biblioteca que está com um "x" vermelho e clique em _Remove_ para remove-la
  5. Clique no botão _Add External JARs..._
  6. Selecione a biblioteca do Robotium que você baixou e clique em OK.
  7. Ainda não feche a janela... leia o que está abaixo...

Um outro ponto importante: adicionar a biblioteca do Robotium no _Order and Export_
  1. Clique na aba _Order and Export_
  2. Clique na checkbox da biblioteca do Robotium
  3. Clique em OK para fechar a janela de propriedades do projeto

### Onde encontrar os testes?
O teste está localizado na pasta _src_ através do pacote _org.traeg.fastip.test_ utilizando a classe _MainActivityTest_

### Execução
Clique no botão _Run_ ou selecione o menu _Run/Run_
Se uma caixa de diálogo aparecer selecione _Android JUnit Testing_ para a execução.


##Automatizando para iOS com Calabash

### Instalação
Serão necessário os seguintes itens:
  - [Ruby]
  - [calabash-cucumber]
  - [calabash-ios]
  - [XCode]
  - [Licença de desenvolvedor para iOS]

### Projeto
O projeto **fastip-native-ios** possui o código-fonte da aplicação e o teste de exemplo.

### Onde encontrar o teste?
Como o Calabash utiliza [BDD] para a escrita e execução dos testes os mesmos serão encontados na pasta _features_.

O arquivo _gorjeta.feature_ é o arquivo descritivo do teste (critério de aceitação) e a impletentação desta feature está em _steps_definitions/gorjeta_steps.rb_

### Execução
Para a execução, você deve:
  1. Abrir o _Terminal_
  2. Navegar até a pasta raiz do projeto
  3. Inserir o seguinte comando:
     ```sh
    cucumber features/gorjeta.feature
     ```



## Quer conhecer mais sobre as ferramentas?
   - https://code.google.com/p/robotium/
   - https://code.google.com/p/robotium/wiki/RobotiumTutorials
   - https://github.com/calabash/calabash-ios/wiki

[Robotium]:https://code.google.com/p/robotium/
[Calabash]:http://calaba.sh
[para iOS]:https://github.com/calabash/calabash-ios
[Java JDK]:http://www.oracle.com/technetwork/java/javase/downloads/index.html
[Eclipse ADT]:http://developer.android.com/sdk/index.html
[Biblioteca do Robotium]:https://code.google.com/p/robotium/wiki/Downloads?tm=2
[Ruby]:https://www.ruby-lang.org/en/downloads/
[calabash-cucumber]:https://github.com/calabash/calabash-ios#fast-track
[calabash-ios]:https://github.com/calabash/calabash-ios#fast-track
[XCode]:https://developer.apple.com/xcode/
[Licença de desenvolvedor para iOS]:https://developer.apple.com/programs/ios/
[BDD]:http://pt.wikipedia.org/wiki/Behavior_Driven_Development
[aqui]:http://eliasnogueira.com/portfolio-item/2806/
[The Developers Conference 2014 Florianópolis]:http://www.thedevelopersconference.com.br/tdc/2014/florianopolis/
[Four Ways To Build A Mobile Application, Part 1: Native iOS]:http://www.smashingmagazine.com/2013/11/22/four-ways-to-build-a-mobile-app-part1-native-ios/
[Four Ways To Build A Mobile Application, Part 2: Native Android]:http://www.smashingmagazine.com/2014/01/10/four-ways-to-build-a-mobile-app-part2-native-android/
