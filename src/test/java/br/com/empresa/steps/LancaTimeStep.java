package br.com.empresa.steps;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.javafx.binding.StringFormatter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class LancaTimeStep {

	private static WebDriver driver;

	@Dado("^que estou com o navegador aberto$")
	public void que_estou_com_o_navegador_aberto() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\eduardo.matias\\Documents\\DRIVERS\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Quando("^preencho na barra de endereco o link \"(.*?)\"$")
	public void preencho_na_barra_de_endereco_o_link(String arg1) throws Throwable {
		driver.get(arg1);
		// barragem de dialogo
//		try {
//			WebDriverWait wait1 = new WebDriverWait(driver, 10);
//			WebElement element1 = wait1.until(
//					ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[3]/button")));
//			element1.click();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	@E("^inicio a chave de acesso$")
	public void inicio_a_chave_de_acesso() throws Throwable {
		String chave = driver.findElement(By.xpath("//*[@id=\"caption\"]")).getText();
		driver.findElement(By.id("txtcaption")).sendKeys(chave);
	}

	@E("^informo o usuario \"(.*?)\"$")
	public void informoOUsuario(String arg1) throws Throwable {
		driver.findElement(By.id("txtLogin")).sendKeys(arg1);
	}

	@E("^a senha \"(.*?)\"$")
	public void aSenha(String arg1) throws Throwable {
		driver.findElement(By.id("txtSenha")).sendKeys(arg1);
	}

	@E("^seleciono entrar$")
	public void selecionoEntrar() throws Throwable {
		driver.findElement(By.id("btnEntrar")).click();
	}

	@Dado("^que estou no Menu Principal$")
	public void que_estou_no_Menu_Principal() throws Throwable {
		String BemVindo = driver.findElement(By.className("col-md-6")).getText();
		Assert.assertEquals("Bem vindo, ao SCO - Sistema de Controle de Operações!", BemVindo);
	}

	@E("^passo o a filial da sessao$")
	public void passo_o_a_filial_da_sessao() throws Throwable {
		driver.findElement(By.name("ctl00$ContentConteudo$ddlFilial")).click();
		WebElement element = driver.findElement(By.name("ctl00$ContentConteudo$ddlFilial"));
		Select combo = new Select(element);
		combo.selectByVisibleText("OSASCO - OPERAÇÕES");
	}

	@E("^informo a planta$")
	public void informo_a_planta() throws Throwable {
		driver.findElement(By.name("ctl00$ContentConteudo$ddlPlantasUsuario")).click();
		WebElement element2 = driver.findElement(By.name("ctl00$ContentConteudo$ddlPlantasUsuario"));
		Select combo2 = new Select(element2);
		combo2.selectByVisibleText("ITAU - FÁBRICA DE TESTES");
	}

	@E("^clico em lancamento de timeSheet$")
	public void clico_em_lancamento_de_timeSheet() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
		driver.findElement(By.linkText("Lançamento de TimeSheet")).click();
		driver.findElement(By.id("ctl00_ContentConteudo_btnAddAcao")).click();
	}

	@Dado("^que estou em cadastrar TimeSheet$")
	public void que_estou_em_cadastrar_TimeSheet() throws Throwable {
		String cadastroTime = driver.findElement(By.xpath("//*[@id=\"conteudo\"]/legend")).getText();
		Assert.assertEquals(cadastroTime, "Cadastro de TimeSheet");
	}

	@E("^informa projeto \"(.*?)\"$")
	public void informa_projeto(String arg1) throws Throwable {
		driver.findElement(By.name("ctl00$ContentConteudo$ddlProjeto")).click();
		WebElement element3 = driver.findElement(By.name("ctl00$ContentConteudo$ddlProjeto"));
		Select combo3 = new Select(element3);
		combo3.selectByVisibleText(arg1);
	}

	@E("^passo a demanda \"(.*?)\"$")
	public void passo_a_demanda(String arg1) throws Throwable {
		driver.findElement(By.name("ctl00$ContentConteudo$ddlDemanda")).click();
		WebElement element3 = driver.findElement(By.name("ctl00$ContentConteudo$ddlDemanda"));
		Select combo3 = new Select(element3);
		combo3.selectByVisibleText(arg1);
	}

	@Dado("^passo a tarefa$")
	public void passo_a_tarefa() throws Throwable {
		driver.findElement(By.name("ctl00$ContentConteudo$ddlTarefa")).click();
		WebElement element5 = driver.findElement(By.name("ctl00$ContentConteudo$ddlTarefa"));
		Select combo5 = new Select(element5);
		combo5.selectByVisibleText("Treinamento Automação Trainee");
	}

	@Dado("^a hora trabalhada$")
	public void aHoraTrabalhada() throws Throwable {
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorformatado = hoje.format(formatador);
		driver.findElement(By.id("ctl00_ContentConteudo_txtData_Trabalhada")).sendKeys(valorformatado);
	}

	@E("^informo as horas arbitradas \"(.*?)\"$")
	public void informo_as_horas_arbitradas(String arg1) throws Throwable {
		driver.findElement(By.name("ctl00$ContentConteudo$txtHoras")).sendKeys(arg1);
	}

	@After
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getId() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
//	driver.quit();
	}

	@E("^clico no ponto$")
	public void clicoNoPonto() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
	}

	@E("^clico em lancamento de ponto$")
	public void clicoEmLancamentoDePonto() throws Throwable {
		driver.findElement(By.linkText("Lançamento de Ponto")).click();

	}

	@Entao("^descreva atividade do dia \"(.*?)\"$")
	public void descrevaAtividadeDoDia(String arg1) throws Throwable {
     driver.findElement(By.name("ctl00$ContentConteudo$txtObservacao")).sendKeys(arg1);
	}

}
