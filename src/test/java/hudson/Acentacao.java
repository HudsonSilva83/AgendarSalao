package hudson;
	import java.text.Normalizer;
	import java.util.regex.Pattern;

public class Acentacao {

	
	public String trata (String passa){
        passa = passa.replaceAll("[�����]","A");
        passa = passa.replaceAll("[�����]","a");
        passa = passa.replaceAll("[����]","E");
        passa = passa.replaceAll("[����]","e");
        passa = passa.replaceAll("����","I");
        passa = passa.replaceAll("����","i");
        passa = passa.replaceAll("[�����]","O");
        passa = passa.replaceAll("[�����]","o");
        passa = passa.replaceAll("[����]","U");
        passa = passa.replaceAll("[����]","u");
        passa = passa.replaceAll("�","C");
        passa = passa.replaceAll("�","c"); 
        passa = passa.replaceAll("[��]","y");
        passa = passa.replaceAll("�","Y");
        passa = passa.replaceAll("�","n");
        passa = passa.replaceAll("�","N");
        passa = passa.replaceAll("�","i");
        passa = passa.replaceAll("['<>\\|/]","");
        return passa;
    }}
	
	
	
	

