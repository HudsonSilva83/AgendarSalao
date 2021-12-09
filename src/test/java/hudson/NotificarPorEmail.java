package hudson;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class NotificarPorEmail {

	public void EnviarEmail(String motivo) throws EmailException  {

		System.out.println("-----Enviando email----");
		
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("t800.hma@gmail.com", "hpereira6611"));
		email.setSSLOnConnect(true);
		email.setFrom("robo@gmail.com");
		email.setSubject("Agendamento Salão de Festas para Anna Clara");
		email.setMsg(motivo);
		email.addTo("hu.psilva@gmail.com");
		//email.addTo("marianna.angelica@hotmail.com");
		//email.addTo("hudson.silva@capgemini.com");
		email.send();
		
		
		System.out.println("-----Enviado email----");

}
}