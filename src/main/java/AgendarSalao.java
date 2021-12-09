import java.util.concurrent.TimeUnit;
import org.apache.commons.mail.EmailException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AgendarSalao {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {

		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver.get("https://www.meucondominio.com.br/Home/Login");
		dsl = new DSL(driver);
		// baixar:
		// https://chromedriver.storage.googleapis.com/index.html?path=96.0.4664.45/
		// File file = new File("D:\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

	}

	@Test
	public void Teste() throws EmailException {

		Assert.assertEquals("Acessar o site do seu condomínio", dsl.obterTitulo());
		dsl.escrever("Usuario", "hu.psilva@gmail.com");
		String nome = dsl.obterValor("Usuario");
		Assert.assertEquals("hu.psilva@gmail.com", nome);
		dsl.escrever("Senha", "hpereira7");

		dsl.clicarBotao("button[type=\"submit\"]");
		//dsl.clicarBotao("a[href=\"/villehungria/ReservaDeEspacos\"][class=\"m-subCard t-reservas\"]");
       
		dsl.clicarBotao("a[class=\"m-subCard t-reservas\"]");
       
		driver.manage().timeouts().implicitlyWait(190, TimeUnit.SECONDS);
    
		//rever esse abaixo
		
		dsl.clicarBotao("body > div.l-body__main > div > div > section > article > section > div > div.m-mainsection__body__wrapper--noBottom > div > div > div > a");
		
		
		String mes = dsl.obterTexto("div [class=\"m-calendarium__container\"] [class= \"m-calendarium__header\"]");

		switch (mes) {

		case "DEZEMBRO 2021":

			driver.findElement(By.xpath("//*[@id=\"reservarEspaço\"]/div/div/div[1]/header/button[2]")).click();

		case "JANEIRO 2022":

			driver.findElement(By.xpath("//*[@id=\"reservarEspaço\"]/div/div/div[1]/header/button[2]")).click();

		case "FEVEREIRO 2022":

			driver.findElement(By.xpath("//*[@id=\"reservarEspaço\"]/div/div/div[1]/header/button[2]")).click();

		case "MARÇO 2022":

			// driver.findElement(By.xpath("//*[@id=\"reservarEspaço\"]/div/div/div[1]/header/button[2]")).click();

//			mes = (driver
//					.findElement(By
//							.cssSelector("div [class=\"m-calendarium__container\"] [class= \"m-calendarium__header\"]"))
//					.getText());

			// System.out.println(mes);

			// testando o projeto
			break;

		case "ABRIL 2022":

//			mes = (driver
//					.findElement(By
//							.cssSelector("div [class=\"m-calendarium__container\"] [class= \"m-calendarium__header\"]"))
//					.getText());
//
//			System.out.println(mes);

			break;

		}

		// String c = "3";
		// clicar na data para agendar
		String dia = driver.findElement(By.cssSelector(
				"div [class=\"m-calendarium__container\"] [class=\"m-calendarium__monthDays\"] li:nth-child(9)"))
				.getText();
		System.out.println(dia);

		String motivo = driver.findElement(By.cssSelector(
				"div [class=\"m-calendarium__container\"] [class=\"m-calendarium__monthDays\"] li:nth-child(9)"))
				.getAttribute("title");
		System.out.println(motivo);

		if (motivo.equals("Já existe outra reserva neste espaço!")) {

			System.out.println(motivo);

			NotificarPorEmail enviarEmail = new NotificarPorEmail();
			enviarEmail.EnviarEmail(
					"Infelizmente não foi possível agendar para a Anna Clara o salão de festas para a data: " + dia
							+ "/04/2022, pois " + motivo + ".");

		} else if (motivo == "") {

			System.out.println("Pode Clicar para agendar");
			driver.findElement(By.cssSelector(
					"div [class=\"m-calendarium__container\"] [class=\"m-calendarium__monthDays\"] li:nth-child(9)"))
					.click();
			// agendar perigoso
			///// driver.findElement(By.cssSelector("button[class=\"m-button--md\"]")).click;

			// desistir de agendar
			driver.findElement(By.cssSelector("button[class=\"m-buttonlink--md s-button-clean\"]")).click();

			// Enviar o email de agendado

			NotificarPorEmail enviarEmail = new NotificarPorEmail();
			enviarEmail.EnviarEmail("Agendado o salão de Festa do Ville Hungria para Anna Clara para o dia : " + dia
					+ "/04/2022, Parabêns para a minha pessoa (Robô) pela persistência que eu tive para com você!.. agendamento realizado com sucesso para o dia 18/04/2022");

		} else if (motivo.equals("Data não atinge a antecedencia maxíma para reserva")) {

			NotificarPorEmail enviarEmail = new NotificarPorEmail();
			enviarEmail.EnviarEmail(
					"O Agendamento do salão de Festa do Ville Hungria para Anna Clara ainda não foi possível fazer, estamos batalhando pra conseguir de forma automática....Vamos aguardar pois a "
							+ motivo + ("."));

		}

	}

	@After
	public void finalizar() {

		driver.quit();

	}
}
