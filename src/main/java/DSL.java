import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DSL {
	
	private WebDriver driver;

	public DSL(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	public void escrever(String id_campo, String texto) {
		
		
		driver.findElement(By.id(id_campo)).sendKeys(texto);
		
	}
	
	public void clicarBotao(String css) {
		
		driver.findElement(By.cssSelector(css)).click();
		
	}
	
	public String obterValor(String id_campo) {
		
		return driver.findElement(By.id(id_campo)).getAttribute("value");
		
	}

	public String obterTexto(String css) {
		
		return driver.findElement(By.cssSelector(css)).getText();
		
	}
	
	
	public String obterTitulo() {
		
		return driver.getTitle();
		
	}
	
	

}
