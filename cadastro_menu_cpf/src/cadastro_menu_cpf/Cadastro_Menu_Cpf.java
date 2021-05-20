package cadastro_menu_cpf;

import java.util.Scanner;

public class Cadastro_Menu_Cpf {
	
	static String cpf = "29328172802";
	static String senha = "1234";
	static Scanner opcao;
	static Scanner entrada;
	static String nome;
	static String nomealt;
	static String cpfalt;
	static String senhaalt;
	static Scanner entradacardapio;
	static Scanner entradacardapio2;
	static int qtde;
	static int[] qtdtotals = new int[9];
	static double[] precototals = new double[8];
	static int[] qtdes = new int[8];

	public static void main(String[] args) {
		
		menu();
	} 
	
	public static boolean validaCPF(String cpf) {
		
		int num[] = new int[11];
		
		int resto1=0;
		int resto2=0;
		
		int soma10 = 10;
		int soma11 = 11;
		int soma1 = 0;
		int soma2 = 0;
		
			  for(int i = 0;i<num.length;i++) {
			 
			  num[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));  
			  
			  }
			   
			   for(int j = 0;j<num.length;j++) {
				   
					   if(j<10 && num[j]==num[j+1]){
						   
						   return false;
						   
					   }else {
						   
						   for(int x = 0;x<9;x++) {
							   
								soma1 +=(num[x]*soma10);
								soma10--;
										   
							}
										  				   
							resto1 = (soma1*10)%11;
									      		  
							if(resto1==10) {
											  
								resto1 = 0;
										  
							}
										 	  
							for(int y = 0;y<10;y++) {
											   		   
								soma2 +=(num[y]*soma11);
								
								soma11--;
											   	   
							}
										  							   
							resto2 = (soma2*10)%11;
										      
											  
							if(resto2==10) {
												  
								resto2 = 0;
											  
							}
											  
											  
							if (resto1 == num[9] && resto2 == num[10]) {
																	  
								return true;
										 
							}
							   
							   
					   }
			   }	
					  
			   
			  return false;	
			 
	}

	public static void menu (){
		
		for(int y=0;y<7;y++) {
			
			qtdes[y]=0;	  
			precototals[y]=0;
			qtdtotals[y]=0;
		}	
		
		opcao = new Scanner(System.in);
		
		System.out.println ("|-----------------------------------------------|");
		System.out.println ("|  Digite uma das opções a seguir:              |");
		System.out.println ("|-----------------------------------------------|");
		System.out.println ("| ->   Digite (1); para Cadastrar               |");
		System.out.println ("| ->   Digite (2); para Alterar Cadastro        |");
		System.out.println ("| ->   Digite (3); Para Cardapio                |");
		System.out.println ("|-----------------------------------------------|");
		System.out.print ("-->");
		
		
		int opccad = opcao.nextInt();
		entrada = new Scanner(System.in);
		
		String cpfreal;
		String senhareal;
		if ((opccad < 1 || opccad > 3)) {
		      System.out.println ("Tente novamente");
		}else if (opccad == 1) {
			
			System.out.println();
			System.out.println ("|#######################################|");
			System.out.println ("|              CADASTRO                 |");
			System.out.println ("|#######################################|");
			System.out.println();
			
		      System.out.println ("Digite seu Nome.");
		      nome = entrada.nextLine();
		      
		      System.out.println ("Digite seu CPF.");
		      
		      cpf = entrada.nextLine();
		      
		      	if(validaCPF(cpf) == true) {
		      		System.out.println ("Digite sua senha.");
		      		senha = entrada.nextLine();
		      	}else{
		      		System.out.println ("cpf invalido");
		      		menu();
		      	}
		      	
		      	System.out.println ("Cadastrado com sucesso...");
		      	
		      	menu();
		      	
		}else if (opccad == 2){
		  
		      System.out.println (" Alteração no seu cadastro, informe:");
		      System.out.println ("Digite seu CPF");
		      cpfreal = entrada.nextLine();
		      senhareal = "";
		      
		  	if(validaCPF(cpfreal) == true) {
	      		System.out.println ("Digite sua senha.");
	      		senhareal = entrada.nextLine();
	      	}else{
	      		System.out.println ("cpf invalido, tente novamente");
	      		menu();
	      	}

		  	try {
		  		
		      while (cpf.equals(cpfreal) && senha.equals(senhareal)) {
		      System.out.println ("Digite o Código do Dado a ser Alterado");
		      System.out.println ("Nome  - Digite 5");
		      System.out.println ("CPF   - Digite 6");
		      System.out.println ("senha - Digite 7");
		      int opcalt = entrada.nextInt();

		      		if (opcalt == 5) {
		      			System.out.println ("Informe o Nome Desejado");
		      			nomealt = entrada.nextLine();
		      			System.out.println ("O Nome do Cadastro foi Alterado com Sucesso.");

		      		}

		      		if (opcalt == 6){
		      			System.out.println ("Informe o CPF Deifjado");
		      			cpfalt = entrada.nextLine();
		      			System.out.println ("O CPF do Cadastro foi Alterado com Sucesso.");
		      		}



		      		if (opcalt == 7){
		      			System.out.println ("Informe a Nova ifnha ");
		      			senhaalt = entrada.nextLine();
		      			System.out.println ("A senha  Alterada com Sucesso.");
		      			System.out.println("Deseja alterar outro dado");

		      		}
		      }
		  	 }catch(NullPointerException e) {
	    		 
	    		 System.out.println ("SENHA OU CPF INCORRETO OU NÃO CADASTRADO TENTE NOVAMENTE");
	    		  menu();
	    	 }
		      
		}else if  (opccad == 3){
			
			      entradacardapio = new Scanner(System.in);  
			
		    	  System.out.println ("Para Prosseguir,Informe: ");
		    	  System.out.println ("seu CPF: ");
		    	  cpfreal = entradacardapio.nextLine();
		    	  
		    	  System.out.println ("Sua senha:");
		    	  senhareal = entradacardapio.nextLine();
		    	
		    	 try {
		    		 
		    		 if(cpf.equals(cpfreal) && senha.equals(senhareal)) {
		    		  
		    		  cardapio();
		    		  
		    		 }
		    	  
		    	 }catch(NullPointerException e) {
		    		 
		    		 System.out.println ("SENHA OU CPF INCORRETO OU NÃO CADASTRADO TENTE NOVAMENTE");
		    		  menu();
		    	 }
		    	  
		}	
		
	}
		     
	public static void cardapio(){		
	
		System.out.println ("|---------------------------------------|");
		System.out.println ("|             CARDAPIO - LOJA           |");
		System.out.println ("|---------------------------------------|");
		System.out.println ("|1- Pipoca Doce                  R$:4.00|");
		System.out.println ("|2- Coxinha                      R$:4.50|");
		System.out.println ("|3- Risoles                      R$:4.00|");
		System.out.println ("|4- Croassants                   R$:6.00|");
		System.out.println ("|5- Churros                      R$:7.50|");
		System.out.println ("|6- Coquetel misto               R$:9.00|");
		System.out.println ("|7- Sanduiche Natural            R$:7.00|");
		System.out.println ("-----------------------------------------");
		System.out.println ("|0- Exibir Comanda / Tela Inicial       |");
		System.out.println ("|_______________________________________|");

		System.out.println ("-----------------------------------------");
		
		setItens();
	}
	
	public static void setItens() {
		
		Scanner entrada = new Scanner(System.in);
		int item;
		
		
		entrada = new Scanner(System.in);
		
		System.out.println(" DIGITE O CODIGO DESEJADO OU DIGITE 0 PARA EXIBIR COMANDA/RETORNAR TELA INICIAL");
	    item = entrada.nextInt();
	    
	    if(item == 0) {
	    valorPorItem();
	    }
	    
		if(item <=-1 ||item > 7) {
			System.out.println(" DIGITE O CODIGO CORRETO, TENTE NOVAMENTE");
	    	cardapio();
	    	
	    }
	    System.out.println(" DIGITE QUANTOS PRODUTOS QUER COMPRAR             ");
	    qtdes[item-1] = entrada.nextInt();
		exibirComanda(item);
	    setItens();	
	}
	
	public static void exibirComanda(int item) {
	   
	    		switch (item) {
		
	    		case 1: case 3:
	    			calculaPreco(4.00,item);
	    			break;
	    			
	    		case 2 :
	    			calculaPreco(4.50,item);
	    			break;
	    			
	    		case 4:
	    			calculaPreco(6.00,item);
	    			break;
    
	    		case 5:
	    			calculaPreco(7.50,item);
	    			break;
    
	    		case 6:
	    			calculaPreco(9.00,item);
	    			break;
    
	    		case 7:
	    			calculaPreco(7.00,item);
	    			break;
	    		}
	}
	
	public static void calculaPreco(double preco, int opc) {
		    
		    precototals[opc-1] = preco;
			qtdtotals[opc] = qtdes[opc-1];
		
	}
	
	public static void valorPorItem() {
		
		double total=0.0d;
		
		System.out.println("--------------------------------");
		System.out.println("|    VALOR TOTAL POR ITEM:     |");
		System.out.println("|------------------------------|");
		System.out.println("| Cod Item | Qtde |Valor em R$ |");
		System.out.println("|------------------------------|");

 		
	    for(int y=0;y<7;y++) {
	    	
	    	if(qtdes[y]>0 && precototals[y]>0) {
	    			
	    			System.out.printf("     "+(y+1)+"     |   "+qtdes[y]+"  |    R$%.2f    %n",qtdes[y]*precototals[y]);
	    			qtdtotals[0]+=qtdes[y];	  
	    			total+=qtdes[y]*precototals[y];
	    	}
	    }	
	    
		System.out.println("|------------------------------|");
    	System.out.printf("TOTAL A PAGAR: R$%.2f %nQUANTIDADE ITENS:"+qtdtotals[0], total);
    	System.out.println();
    	System.out.println();
	   menu();  
	}
}




		    
		   
		  





