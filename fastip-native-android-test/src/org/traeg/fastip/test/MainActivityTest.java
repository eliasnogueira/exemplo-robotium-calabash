package org.traeg.fastip.test;

import org.traeg.fastip.MainActivity;
import org.traeg.fastip.R;

import com.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;

/**
 * Classe de teste onde é necessário extender a classe ActivityInstrumentationTestCase2
 * com a Activity alvo do teste que geralmente e a princial (MainActivity)
 * 
 * @author Elias Nogueira <elias.nogueira@gmail.com>
 * @author eliasnogueira.com
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	// criamos uma instancia vazia do Robotium para a utilizacao no teste
	private Solo solo;
	
	/*
	 * E necessario criar um construtor vazio dando um super na Activity principal
	 */
	public MainActivityTest() {
		super(MainActivity.class);
	}
	
	/*
	 * Na pre-condicao e necessario criar a instancia do Robotium
	 * 
	 * @see android.test.ActivityInstrumentationTestCase2#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	/*
	 * Na pos-condicao e necessario fechar a tela da atividade
	 * 
	 * @see android.test.ActivityInstrumentationTestCase2#tearDown()
	 */
	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
		super.tearDown();
	}
	
	
	/**
	 * Teste para calcular o total da tip com o valor padrao de gorjeta (5.5%)
	 * 
	 * Esta maneira de utilizar sem precisar utilizar um id direto do projeto
	 * e chamado de BlackBox Testing no Robotium
	 */
	public void testCalculaTip()  {
		
		/* 
		 * Informa 100 no campo Total da Conta
		 * 
		 * O primeiro parametro zero (0) e referente ao primeira caixa de texto (e unica)
		 * na tela. Esse numero e sequencial sempre que existir mais campos de caixa de texto
		 * 
		 * O segundo parametro e o texto (valor) que sera inserido na caixa de texto
		 */
		solo.enterText(0, "100");
		
		/* 
		 * Clica no botão pelo seu texto.
		 * O parametro pode ser um numero ao invez do texto, comecando em zero (0) para o
		 * primeiro botao na tela e sequencialmente incremental para os demais botoes
		 */
		solo.clickOnButton("Calcular Gorjeta");
		
		/*
		 * Estamos procurando pelo valor total na tela. 
		 * Se encontrado e retornado true, caso nao e retornado false
		 * 
		 * O assertTrue serve justamente para garantir que o texto foi encontrado e o valor correto
		 * A mensagem e informativa caso o retorno seja false
		 */
		assertTrue("Total da conta não está correto", solo.searchText("115,00"));
	}
	
	/**
	 * Teste para alterar o percentual da gorjeta
	 * 
	 * Este tipo de teste onde acessamos um item interno da aplicacao como o id do menu
	 * e chamado do WhiteBox Testing no Robotium
	 */
	public void testCalculaTipComAlteracaoPercentual() {
		
		/*
		 * Acessa diretamente o item de menu para a configuracao da gorjeta
		 * 
		 * Isso e feito acessando a classe R do projeto real.
		 * Nao esque o projeto de teste tambem tem uma classe R (que nao deve ser usada)
		 *  
		 */
		solo.clickOnActionBarItem(R.id.menu_settings);
		
		/*
		 * Primeiro limpa o valor que ja esta no campo senao e adicionado (append)
		 */
		solo.clearEditText(0);
		
		solo.enterText(0, "10");
		solo.clickOnButton("Salvar");

		/*
		 * Garante que a tela que foi apresentada e a Activity principal para inserir os dados
		 */
		solo.assertCurrentActivity("Nao voltou para a tela principal", MainActivity.class);
		
		/*
		 * Efetua o restante dos passos como o teste anterior 
		 */
		solo.enterText(0, "100");
		solo.clickOnButton("Calcular Gorjeta");
		assertTrue("Total da conta não está correto", solo.searchText("110,00"));
	}

}
