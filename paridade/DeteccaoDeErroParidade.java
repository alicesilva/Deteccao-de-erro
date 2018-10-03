package paridade;

import java.util.Scanner;

public class DeteccaoDeErroParidade {
	
	public static final String ERRO = "ERRO";
	public static final String NOTERRO = "NOT ERRO";
	public static final char UM = '1';
	public static final String PARIDADEPAR= "par";
	public static final String PARIDADEIMPAR= "ímpar";
	public static final String DEFAULT= "ENTRADA OU TIPO DE PARIDADE INVÁLIDA";



	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite uma entrada de bits: (Ex: 1110)");
		String entrada = input.next();
		input.nextLine();
		
		System.out.println("Digite o tipo de paridade: (Ex: par ou ímpar)");
		String tipoDeParidade = input.next();
		input.nextLine();
		
		String retorno = paridade(entrada, tipoDeParidade);
		
		System.out.println(retorno);
	}

	public static String paridade(String palavra, String tipoDeParidade) {
		
		int count = 0;
		int i;
		for(i = 0; i < palavra.length(); i++){
			char letra = palavra.charAt(i);
			if(letra == UM){
				count ++;
			}
		}
		
		return detectaErro(count, tipoDeParidade);
	}
	
	public static String detectaErro(int count, String tipoDeParidade){
		String detectaErro = "";
		
		if(count % 2 == 0 && tipoDeParidade.equals(PARIDADEPAR)){
			detectaErro = NOTERRO;
		}else if(count % 2 != 0 && tipoDeParidade.equals(PARIDADEPAR)){
			detectaErro = ERRO;
		}else if(count % 2 == 0 && tipoDeParidade.equals(PARIDADEIMPAR)){
			detectaErro = ERRO;
		}else if (count % 2 != 0 && tipoDeParidade.equals(PARIDADEIMPAR)){
			detectaErro = NOTERRO;
		}else{
			detectaErro = DEFAULT;
		}
		
		return detectaErro;
	}
}
