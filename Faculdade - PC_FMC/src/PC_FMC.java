import java.util.Scanner;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

class Matriz{
	Scanner op = new Scanner(System.in);
	private int j, i,n,diagPrinc,diagSecond,sarrus;
	private int x=3,y=3,xb=2,yb=1;
	private int matriz[][],matrizB[][],matrizresult[][],matrizteste[][];	

	void principalMenu(){	//ok
		int princMenu;
		try{
		princMenu=Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja trabalhar com : \n 1 - Matriz \n 2 - Determinante","Seja Bem Vindo!",JOptionPane.QUESTION_MESSAGE));
		//System.out.println("Seja Bem Vindo \nDeseja trabalhar com :");
		//System.out.println("1 - Matriz"); //ok
		//System.out.println("2 - Determinante"); //ok
		//System.out.println("0 - Sair");//ok
		//princMenu=op.nextInt();
		menuPrinc : switch(princMenu){
		case(0):
			break menuPrinc;
		case(1):
			escolhaMatriz();
			break;
		case(2):
			ordemMatriz();
			criarMatriz();
			//mostrarMatriz();
			criarMenu();
			break;
		}
	}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Encerrando o programa","Aguarde!",JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	void redefinirOrdemMatriz(){ // ok
		int redf;
		redf=JOptionPane.showConfirmDialog(null,"Deseja Redefinir a ordem de sua Matriz?","Selecione uma opção",JOptionPane.YES_NO_OPTION);
	//	System.out.println("Deseja Redefinir a ordem de sua Matriz?");
	//	System.out.println("1 - Sim");
	//	System.out.println("2 - Nao");
	//	redf=op.nextInt();
		switch(redf){
		case(0):
			ordemMatriz();
			criarMatriz();
			mostrarMatriz();
			criarMenu();
			break;
		case(1):
			break;
		}
		
	}
	
	void ordemMatriz(){		//ok
		try{
		x= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o numero de linhas de A","Matriz A",JOptionPane.NO_OPTION));
		//System.out.print("Digite o numero de linhas de A: ");
		//x=op.nextInt();	
		y = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o numero de colunas de A","Matriz A",JOptionPane.NO_OPTION));
		//System.out.print("Digite o numero de colunas de A:  ");
		//y=op.nextInt();
		verificaLinhasColunas();
		setMatriz();
		}
		catch(NumberFormatException e){
			
		}
	}
	void ordemMatrizB(){	//ok
		//ordemMatriz();
		try{
		xb= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o numero de linhas de B","Matriz B",JOptionPane.NO_OPTION));
		//System.out.print("Digite o número de linhas de B: ");
		//xb=op.nextInt();
		yb= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o numero de colunas de B","Matriz B",JOptionPane.NO_OPTION));
		//System.out.print("Digite o numero de colunas de B: ");
		//yb=op.nextInt();
		verificaLinhasColunasB();
		setMatrizB();
		}
		catch(NumberFormatException e){
			
		}
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	void operacoesMatriz(){ //falta determinar INVERSA e MULTIPLICAR pela MATRIZ B
		int operacoesMatriz;
		operacoesMatriz=Integer.parseInt(JOptionPane.showInputDialog(null,"Oque deseja fazer com as duas matrizes? \n 1 - Somar \n 2 - Subtrair \n 3 - Multiplicar \n 4 - Verificar o tipo da matriz \n 5 - Determinar a inversa","Operações com Matriz",JOptionPane.QUESTION_MESSAGE));
//		System.out.println("Oque deseja fazer com as duas matrizes?");
//		System.out.println("1 - Somar"); //ok
//		System.out.println("2 - Subtrair"); //ok
//		System.out.println("3 - Multiplicar"); //calculos para 2x2 2x3 2x4 ok
//		System.out.println("4 - Verificar o tipo da matriz"); //ok
//		System.out.println("5 - Determinar a inversa"); 
//		System.out.println("0 - Sair"); //ok
//		operacoesMatriz=op.nextInt();

		operacoesMatrizValidacao : switch(operacoesMatriz){
		case(0):
			break operacoesMatrizValidacao;
		case(1):
			int oposto = 0;
			//matriz oposto quando o produto da 0
			if(x!=xb || y!=yb){
			JOptionPane.showMessageDialog(null,"Nao foi possivel fazer a operacao: A duas matrizes devem ser de mesma ORDEM","ERRO!",JOptionPane.ERROR_MESSAGE);
			//System.out.println("Nao foi possivel fazer a operacao: A duas matrizes devem ser de mesma ORDEM");	//ok	
			operacoesMatriz();
			}	
			else {
				setMatrizResult();
			for(i=0;i<x;i++){
				for(j=0;j<y;j++){
					for(int ib=0;ib<xb;ib++){
						for(int jb=0;jb<yb;jb++){
							matrizresult[i][j]=matriz[i][j]+(matrizB[ib][jb]);
								if(matriz[i][j]==0){
									oposto++;
										if(oposto==(x*y)){
											JOptionPane.showMessageDialog(null,"A matriz A,B é oposto.","AVISO!",JOptionPane.INFORMATION_MESSAGE);
											//System.out.println("A matriz A,B é oposto.");	//ok
								}
							}
						}
					}
				}
			}
				mostrarMatrizResult();
			}
			break;
		case(2):	// ok
			if(x!=xb || y!=yb){
				JOptionPane.showMessageDialog(null,"Nao foi possivel fazer a operacao: A duas matrizes devem ser de mesma ORDEM","ERROR!",JOptionPane.ERROR_MESSAGE);
				//System.out.println("Nao foi possivel fazer a operacao: A duas matrizes devem ser de mesma ORDEM");
				operacoesMatriz();
				}	
				else {
					setMatrizResult();
				for(i=0;i<x;i++){
					for(j=0;j<y;j++){
						for(int ib=0;ib<xb;ib++){
							for(int jb=0;jb<yb;jb++){
								matrizresult[i][j]=matriz[i][j]-matrizB[ib][jb];
							}
						}
						}
					}
				mostrarMatrizResult();
				}		
			break;
		case(3):
			int multiplicar;
			multiplicar=Integer.parseInt(JOptionPane.showInputDialog(null," 4 - Multiplicar por um número REAL \n 5 - Multiplicar pela matriz B ","Propriedades",JOptionPane.QUESTION_MESSAGE));
//			System.out.println("4 - Multiplicar por um número REAL");	//ok
//			System.out.println("5 - Multiplicar pela matriz B");
//			multiplicar=op.nextInt();

			int ab = 0;
				if(multiplicar==4){	//ok
					multiplicar=Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o valor no qual a matriz sera multiplicada \n ","AVISO",JOptionPane.PLAIN_MESSAGE));
//					System.out.println("Informe o valor no qual a matriz sera multiplicada");
//					multiplicar=op.nextInt();
					ab=Integer.parseInt(JOptionPane.showInputDialog(null,"Multiplicar a Matriz A ou B? \n 1 - A \n 2 - B","Escolha a matriz",JOptionPane.QUESTION_MESSAGE));
//					System.out.println("Multiplicar a Matriz A ou B?");
//					System.out.println("1 - A");
//					System.out.println("2 - B");
//					ab=op.nextInt();
				}
						if(ab==1){	//ok
							setMatrizResult();
							JOptionPane.showMessageDialog(null,"O valor da sua matriz e:","Resultado",JOptionPane.DEFAULT_OPTION);
//							System.out.println("O valor da sua matriz e:");
								for(i=0;i<x;i++){
									for(j=0;j<y;j++){
										matrizresult[i][j]=matriz[i][j]*multiplicar;
							}
						
						}
			mostrarMatrizResult();
			}	
						if(ab==2){	//ok
							setMatrizResult();
							JOptionPane.showMessageDialog(null,"O valor da sua matriz e:","Resultado",JOptionPane.DEFAULT_OPTION);
//							System.out.println("O valor da sua matriz e:");
							for(i=0;i<xb;i++){
								for(j=0;j<yb;j++){
									matrizresult[i][j]=matrizB[i][j]*multiplicar;
						}
					}
			mostrarMatrizResult();
		}		
			if(multiplicar==5 && y==xb){ // fazer calculos
					// 2x2
				if(x==2 && y==2 && yb==2 && xb==2 ){
					matrizresult= new int[x][yb];
					int a11=matriz[0][0]*matrizB[0][0]+matriz[0][1]*matrizB[1][0];
					int a12=matriz[0][0]*matrizB[0][1]+matriz[0][1]*matrizB[1][1];
					int a21=matriz[1][0]*matrizB[0][0]+matriz[1][1]*matrizB[1][0];
					int a22=matriz[1][0]*matrizB[0][1]+matriz[1][1]*matrizB[1][1];
					matrizresult[0][0]=a11;
					matrizresult[0][1]=a12;
					matrizresult[1][0]=a21;
					matrizresult[1][1]=a22;
					mostrarMatrizResult(x,yb);
				}
					//2x2 2x3
				if(x==2 && y==2 && xb==2 && yb==3){
					matrizresult=new int[x][yb];
					int a11=matriz[0][0]*matrizB[0][0]+matriz[0][1]*matrizB[1][0];
					int a12=matriz[0][0]*matrizB[0][1]+matriz[0][1]*matrizB[1][1];
					int a21=matriz[1][0]*matrizB[0][0]+matriz[1][1]*matrizB[1][0];
					int a22=matriz[1][0]*matrizB[0][1]+matriz[1][1]*matrizB[1][1];
					int a13=matriz[0][0]*matrizB[0][2]+matriz[0][1]*matrizB[1][2];
					int a23=matriz[1][0]*matrizB[0][2]+matriz[1][1]*matrizB[1][2];
					matrizresult[0][0]=a11;
					matrizresult[0][1]=a12;
					matrizresult[0][2]=a13;
					matrizresult[1][0]=a21;
					matrizresult[1][1]=a22;
					matrizresult[1][2]=a23;
					mostrarMatrizResult(x,yb);
				}
					//2x2 2x4 
				if(x==2 && y==2 && xb==2 && yb==4){
					matrizresult=new int[x][yb];
					int a11=matriz[0][0]*matrizB[0][0]+matriz[0][1]*matrizB[1][0];
					int a12=matriz[0][0]*matrizB[0][1]+matriz[0][1]*matrizB[1][1];
					int a21=matriz[1][0]*matrizB[0][0]+matriz[1][1]*matrizB[1][0];
					int a22=matriz[1][0]*matrizB[0][1]+matriz[1][1]*matrizB[1][1];
					int a13=matriz[0][0]*matrizB[0][2]+matriz[0][1]*matrizB[1][2];
					int a23=matriz[1][0]*matrizB[0][2]+matriz[1][1]*matrizB[1][2];
					int a14=matriz[0][0]*matrizB[0][3]+matriz[0][1]*matrizB[1][3];
					int a24=matriz[1][0]*matrizB[0][3]+matriz[1][1]*matrizB[1][3];
					matrizresult[0][0]=a11;
					matrizresult[0][1]=a12;
					matrizresult[0][2]=a13;
					matrizresult[0][3]=a14;
					matrizresult[1][3]=a24;
					matrizresult[1][0]=a21;
					matrizresult[1][1]=a22;
					matrizresult[1][2]=a23;
					mostrarMatrizResult(x,yb);
				}
				//----------------------------------
					//1x2 2x1
				
					//1x2 2x2
				
					//1x2 2x3
				
					//1x2 2x4
				
					//1x3 3x1
				
					//1x3 3x2
				
					//1x3 3x3
				
					//1x3 3x4
				
					//1x4 4x1
				
					//1x4 4x2
				
					//1x4 4x3
					
					//1x4 4x4
				
				//----------------------------------
				//3x2 2x1
				
				//3x2 2x2
			
				//3x2 2x3
			
				//3x2 2x4
			
				//3x3 3x1
			
				//3x3 3x2
			
				//3x3 3x3
			
				//3x3 3x4
			
				//4x4 4x1
			
				//4x4 4x2
			
				//4x4 4x3
				
				//4x4 4x4 
			
			}
			if(multiplicar==5 && y!=xb){	//ok
				JOptionPane.showMessageDialog(null,"O numero de COLUNAS de A nao e igual o numero de LINHAS de B!","AVISO!",JOptionPane.WARNING_MESSAGE);
//				System.out.println("O numero de COLUNAS de A nao e igual o numero de LINHAS de B!");
				operacoesMatriz();
			}	
			break;
		case(4): //ok
			tipoMatriz();
			break;
		// A ser FEITO
		case(5):
			int temp = Integer.parseInt(JOptionPane.showInputDialog(null,"Qual matriz deseja saber a Inversa? \n 1 - A \n 2 - B","Escolha matriz",JOptionPane.INFORMATION_MESSAGE));
//			System.out.println("Qual matriz deseja saber a Inversa?");
//			System.out.println("1 - A");
//			System.out.println("2 - B");
//			int temp =op.nextInt();
	}
}
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	void escolhaMatriz(){// ok
		int escMatriz;
		//System.out.println("Escolha oque deseja fazer");
		try{
		escMatriz = Integer.parseInt(JOptionPane.showInputDialog(null," 1 - Ja tenho os valores da matriz A e B \n 2 - Gostaria de informa a lei de formacao para A e B \n 3 - Gerar uma matriz aleatoria"));
	//	System.out.println("1 - Ja tenho os valores da matriz A e B");//ok
	//	System.out.println("2 - Gostaria de informa a lei de formacao para A e B"); // ok
	//	System.out.println("3 - Gerar uma matriz aleatoria");	//ok
	//	System.out.println("0 - Sair"); //ok
	//	escMatriz=op.nextInt();
		menu : switch(escMatriz){
		case(0): //ok
			break menu;
		case(1):{ //ok
			ordemMatriz();
			ordemMatrizB();
			criarMatriz();
			criarMatrizB();
			operacoesMatriz();
			break;
			}
		case(2):{
			ordemMatriz();
			leiFormacao();
			mostrarMatriz();
			break;
		}
		case(3):{ //ok
			criarMatrizAleatoria();
			mostrarMatriz();
			break;
		}	
	}
		}
		catch(NumberFormatException e){
			
		}
}
	
	void tipoMatrizB(){ //ok
		// Validacao Matriz B
			if(xb==1){
				JOptionPane.showMessageDialog(null, "Esta matriz e do tipo: LINHA","Tipo da Matriz B",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Esta matriz e do tipo: LINHA"); //ok
			}
			if(yb==1){
				JOptionPane.showMessageDialog(null, "Esta matriz e do tipo: COLUNA","Tipo da Matriz B",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Esta matriz e do tipo: COLUNA"); //ok
			}
			if(xb==yb){
				JOptionPane.showMessageDialog(null, "Esta matriz e QUADRADA","Tipo da Matriz B",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Esta matriz e QUADRADA");	//ok
			}
			if(xb==0 && yb==0){
				JOptionPane.showMessageDialog(null, "Esta matriz e NULA","Tipo da Matriz B",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Esta matriz e NULA"); //ok
			}
			if(xb==0 && yb==0){
				JOptionPane.showMessageDialog(null, "Não é Matriz","Tipo da Matriz B",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Não é Matriz"); //ok
			}
					//elementos nao pertecentes a diagonal principal sao 0 ok.
				int verif=0;
			 	for (i = 0; i < xb; i++) {
				for (j = 0; j < yb; j++) {
					if(i!=j && matrizB[i][j]==0){
						verif++;
					}
			}
			 	}
				if(xb*yb-xb==verif++){
					JOptionPane.showMessageDialog(null, "Esta matriz e DIAGONAL","Tipo da Matriz B",JOptionPane.INFORMATION_MESSAGE);
					//System.out.println("Esta matriz e DIAGONAL");	//ok
				}
				
					//elementos diagonal principal = 1  ok
				int verif2=0;
			 	for (i = 0; i < xb; i++) {
				for (j = 0; j < yb; j++) {
					if(i==j && matrizB[i][j]==1){
						verif2++;
					}
			}
			 	}
				if(verif2==xb){
					JOptionPane.showMessageDialog(null, "Esta matriz e IDENTIDADE","Tipo da Matriz B",JOptionPane.INFORMATION_MESSAGE);
					//System.out.println("Esta matriz e IDENTIDADE");	//ok
				}
					//matriz transpota ok
				int verif3=0;
				if(xb==x && yb==y){
					for(i=0;i<xb;i++){
							for(int j=0;j<yb;j++){
									if(matrizB[j][i]==matriz[i][j]){
										verif3++;
							}
						}
					}
				}
					if(verif3==x*y){
						JOptionPane.showMessageDialog(null, "Matriz A ea Transposta de B","Tipo da Matriz B",JOptionPane.INFORMATION_MESSAGE);
						//System.out.println("Matriz A e a transposta de B"); //ok
			}
				System.out.println(verif3);

				//elementos simetricos a diagonal principal sao IGUAIS // ok			
			if(matrizB[0][yb-1]==matrizB[xb-1][0]){
				JOptionPane.showMessageDialog(null, "Esta matriz e SIMETRICA","Tipo da Matriz B",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Esta matriz e SIMETRICA");
			}
			
				//elementos simetricos a diagonal principal sao OPOSTOS(4 -4) // ok	
			if(matrizB[0][yb-1]==matrizB[xb-1][0]*(-1)){
				JOptionPane.showMessageDialog(null, "Esta matriz e ANTI SIMETRICA","Tipo da Matriz B",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Esta matriz e ANTI SIMETRICA");
			}
			
			//matriz quadrada em que TODOS os elementos ABAIXO da diagonal principal sao NULOS
			int verif9=0;
			for (i = 0; i < xb; i++) {
				for (j = 0; j < yb; j++) {
					if(i>j && matrizB[i][j]==0){
						verif9++;
					}
				}
			}
			if(verif9==xb){
				JOptionPane.showMessageDialog(null, "Esta matriz e TRIANGULAS SUPERIOR","Tipo da Matriz B",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Esta matriz e TRIANGULAR SUPERIOR");
			}
			
			//matriz quadrada em que TODOS os elementos ACIMA da diagonal principal sao NULOS //ok
			int verif10=0;
			for (i = 0; i < xb; i++) {
				for (j = 0; j < yb; j++) {
					if(i<j && matrizB[i][j]==0){
						verif10++;
					}
				}
			}
			if(verif10==xb){
				JOptionPane.showMessageDialog(null, "Esta matriz e TRINGULAS INFERIOR","Tipo da Matriz B",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Esta matriz e TRIANGULAR INFERIOR"); //ok
			}
			if(xb==x && yb==y){ //ok
				int verif11=0;
				for(i=0;i<xb;i++){
					for(j=0;j<yb;j++){
						if(matrizB[i][j]==matriz[i][j]){
							verif11++;
						}
					}
				}
				if(verif11==xb*yb){
					JOptionPane.showMessageDialog(null, "Matriz A e E sao IGUAIS","Tipo da Matriz B",JOptionPane.INFORMATION_MESSAGE);
					//System.out.println("Matriz A e B sao IGUAIS");	//ok
				}
			}
	}
	
	void tipoMatriz(){ //ok
		int sn;
		sn= Integer.parseInt(JOptionPane.showInputDialog(null,"Gostaria de saber o tipo de qual matriz? \n 1 - A \n 2 - B","Tipo Matriz",JOptionPane.QUESTION_MESSAGE));
		//System.out.println("Gostaria de saber o tipo de qual matriz?");
		//System.out.println("1 - A");
		//System.out.println("2 - B");
		//sn=op.nextInt();
		if(sn==1) {
		if(x==1){
			JOptionPane.showMessageDialog(null, "Esta matriz e do tipo: LINHA","Tipo da Matriz A",JOptionPane.INFORMATION_MESSAGE);
			//System.out.println("Esta matriz e do tipo: LINHA"); //ok
		}
		if(y==1){
			JOptionPane.showMessageDialog(null, "Esta matriz e do tipo: COLUNA","Tipo da Matriz A",JOptionPane.INFORMATION_MESSAGE);
			//System.out.println("Esta matriz e do tipo: COLUNA"); //ok
		}
		if(x==y ){
			JOptionPane.showMessageDialog(null, "Esta matriz e QUADRADA","Tipo da Matriz A",JOptionPane.INFORMATION_MESSAGE);
			//System.out.println("Esta matriz e QUADRADA");	//ok
		}
		if(x==0 && y==0){
			JOptionPane.showMessageDialog(null, "Não é Matriz","Tipo da Matriz A",JOptionPane.INFORMATION_MESSAGE);
			//System.out.println("Não é Matriz"); //ok
		}
				//elementos nao pertecentes a diagonal principal sao 0 ok.
			int verif=0;
		 	for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				if(i!=j && matriz[i][j]==0){
					verif++;
				}
		}
		 	}
			if(x*y-x==verif++){
				JOptionPane.showMessageDialog(null, "Esta matriz e DIAGONAL","Tipo da Matriz A",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Esta matriz e DIAGONAL");	//ok
			}
			
				//elementos diagonal principal = 1  ok
			int verif2=0;
		 	for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				if(i==j && matriz[i][j]==1){
					verif2++;
				}
		}
		 	}
			if(verif2==x){
				JOptionPane.showMessageDialog(null, "Esta matriz e IDENTIDADE","Tipo da Matriz A",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Esta matriz e IDENTIDADE");	//ok
			}
				//matriz transpota ok
			int verif3=0;
			if(x==xb && y==yb){
				for(i=0;i<x;i++){
						for(int jb=0;jb<yb;jb++){
								if(matriz[jb][i]==matrizB[i][jb]){
									verif3++;
						}
					}
				}
				if(verif3==x*y){
					JOptionPane.showMessageDialog(null, "Matriz B e a Transposta de A","Tipo da Matriz A",JOptionPane.INFORMATION_MESSAGE);
					//System.out.println("Matriz B e a transposta de A"); //ok
			}
		}

			//elementos simetricos a diagonal principal sao IGUAIS // ok			
		if(matriz[0][y-1]==matriz[x-1][0]){
			JOptionPane.showMessageDialog(null, "Esta matriz e SIMETRICA","Tipo da Matriz A",JOptionPane.INFORMATION_MESSAGE);
			//System.out.println("Esta matriz e SIMETRICA");
		}
		
			//elementos simetricos a diagonal principal sao OPOSTOS(4 -4) // ok	
		if(matriz[0][y-1]==matriz[x-1][0]*(-1)){
			JOptionPane.showMessageDialog(null, "Esta matriz e ANTI SIMETRICA","Tipo da Matriz A",JOptionPane.INFORMATION_MESSAGE);
			//System.out.println("Esta matriz e ANTI SIMETRICA");
		}
		
		//matriz quadrada em que TODOS os elementos ABAIXO da diagonal principal sao NULOS
		int verif9=0;
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				if(i>j && matriz[i][j]==0){
					verif9++;
				}
			}
		}
		if(verif9==x){
			JOptionPane.showMessageDialog(null, "Esta matriz e TRIANGULAR SUPERIOR","Tipo da Matriz A",JOptionPane.INFORMATION_MESSAGE);
			//System.out.println("Esta matriz e TRIANGULAR SUPERIOR");
		}
			}
		//matriz quadrada em que TODOS os elementos ACIMA da diagonal principal sao NULOS //ok
		int verif10=0;
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				if(i<j && matriz[i][j]==0){
					verif10++;
				}
			}
		}
		if(verif10==x){
			JOptionPane.showMessageDialog(null, "Esta matriz e TRINGULAR INFERIOR","Tipo da Matriz A",JOptionPane.INFORMATION_MESSAGE);
			//System.out.println("Esta matriz e TRIANGULAR INFERIOR");
		}
		if(x==xb && y==yb){ //ok
			int verif11=0;
			for(i=0;i<x;i++){
				for(j=0;j<y;j++){
					if(matriz[i][j]==matrizB[i][j]){
						verif11++;
					}
				}
			}
			if(verif11==x*y){
				JOptionPane.showMessageDialog(null, "Matriz A e B sao iguais","Tipo da Matriz A",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Matriz A e B sao IGUAIS");	//ok
			}						
		}
		if(sn==2){
			tipoMatrizB();
		}	
	}
	
	void leiFormacao(){ // ok INSERIR ELEMENTROS GRAFICOS
		int igual,maior,menor;
		setMatriz();
		igual=Integer.parseInt(JOptionPane.showInputDialog(null,"Quando i=j \n 1 - Somar \n 2 - Subtrair \n 3 - Multiplicar \n 4 - Dividir \n 5 - Elevar","Lei de Formação",JOptionPane.DEFAULT_OPTION));
//		System.out.println("Quando i=j \n 1 - Somar \n 2 - Subtrair \n 3 - Multiplicar \n 4 - Dividir \n 5 - Elevar");
//		igual=op.nextInt();
		maior=Integer.parseInt(JOptionPane.showInputDialog(null,"Quando i=j \n 1 - Somar \n 2 - Subtrair \n 3 - Multiplicar \n 4 - Dividir \n 5 - Elevar","Lei de Formação",JOptionPane.DEFAULT_OPTION));
//		System.out.println("Quando i>j \n 1 - Somar \n 2 - Subtrair \n 3 - Multiplicar \n 4 - Dividir \n 5 - Elevar");
//		maior=op.nextInt();
		menor=Integer.parseInt(JOptionPane.showInputDialog(null,"Quando i=j \n 1 - Somar \n 2 - Subtrair \n 3 - Multiplicar \n 4 - Dividir \n 5 - Elevar","Lei de Formação",JOptionPane.DEFAULT_OPTION));
//		System.out.println("Quando i<j \n 1 - Somar \n 2 - Subtrair \n 3 - Multiplicar \n 4 - Dividir \n 5 - Elevar");
//		menor=op.nextInt();
		
		for(i=0;i<x;i++){	
			for(j=0;j<y;j++){
				if(i==j){
					if(igual==1){
						matriz[i][j]=(i+1)+(j+1);
					}
					else if(igual==2){
						matriz[i][j]=(i+1)-(j+1);
					}
					else if(igual==3){
						matriz[i][j]=(i+1)*(j+1);
					}
					else if(igual==4){
						matriz[i][j]=(i+1)/(j+1);
					}
					else if(igual==5){
						matriz[i][j]=(int)Math.pow((i+1),(j+1));
					}
				}
			if(i>j){
				if(maior==1){
					matriz[i][j]=(i+1)+(j+1);
				}
				else if(maior==2){
					matriz[i][j]=(i+1)-(j+1);
				}
				else if(maior==3){
					matriz[i][j]=(i+1)*(j+1);
				}
				else if(maior==4){
					matriz[i][j]=(i+1)/(j+1);
				}
				else if(maior==5){
					matriz[i][j]=(int)Math.pow((i+1),(j+1));
				}
				
			}
		 if(i<j){
			 if(menor==1){
					matriz[i][j]=(i+1)+(j+1);
				}
				else if(menor==2){
					matriz[i][j]=(i+1)-(j+1);
				}
				else if(menor==3){
					matriz[i][j]=(i+1)*(j+1);
				}
				else if(menor==4){
					matriz[i][j]=(i+1)/(j+1);
				}
				else if(menor==5){
					matriz[i][j]=(int)Math.pow((i+1),(j+1));
				}				
		 	}
		}
	}
}
	
	
	void verificaLinhasColunas(){	//ok

		if (x==0 || y==0){
			JOptionPane.showMessageDialog(null, "Número de Linhas/Colunas nao podem ser 0");
			//System.out.println("Número de Linhas/Colunas nao podem ser 0 ");
			ordemMatriz();
		}
	}
	void verificaLinhasColunasB(){ //ok
		if (xb==0 || yb==0){
			JOptionPane.showMessageDialog(null,"Número de Linhas/Colunas nao podem ser 0");
			//System.out.println("Número de Linhas/Colunas nao podem ser 0 ");
			ordemMatrizB();
		}
	}
	void criarMenu(){	//ok
		int option=0;
		menu : while(option==0){
		option = Integer.parseInt(JOptionPane.showInputDialog(null,"Qual teorema deseja utilizar? \n 1 - Laplace \n 2 - Sarrus"));	
		//System.out.println("Qual teorema deseja utilizar?");
		//System.out.println("1 - Laplace"); //ok
		//System.out.println("2 - Sarrus"); //ok
		//System.out.println("0 - Sair"); //ok
		//option=op.nextInt();
		
			if(option==1){
				utilizarLaplace();
		}
			if(option==2){
				utilizarSarrus();
		}
			if(option==0){
				JOptionPane.showInputDialog(null,"Encerrando o Programa!","Aguarde",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Programa Encerrado ....");
				break menu;
			}
			if(option <0 || option>2){
				JOptionPane.showInputDialog(null, "Opção INVÁLIDA!","ERROR",JOptionPane.ERROR_MESSAGE);
				//System.out.println("Opcao INVALIDA");
				criarMenu();
			}
		}
	}
	
	void criarMatrizAleatoria(){	// ok
		ordemMatriz();
			for(i=0;i<x;i++){
				for(j=0;j<y;j++){
					matriz[i][j]= (int)(100*Math.random());
			}
		}
	}
	
	void criarMatriz(){ //ok
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				n=Integer.parseInt(JOptionPane.showInputDialog(null,"a"+(i+1)+""+(j+1)+"","Elementos da matriz A",JOptionPane.PLAIN_MESSAGE));
				//System.out.print("a"+(i+1)+""+(j+1)+":  ");
				//n = op.nextInt();
				matriz[i][j] = n;
			}
		}
	}

	void criarMatrizB(){ //ok
		//criarMatriz();
		int n;
		for (i = 0; i < xb; i++) {
			for (j = 0; j < yb; j++) {
				n=Integer.parseInt(JOptionPane.showInputDialog(null,"b"+(i+1)+""+(j+1)+"","Elementos da matriz B",JOptionPane.PLAIN_MESSAGE));
				//System.out.print("b"+(i+1)+""+(j+1)+":  ");
				//n = op.nextInt();
				matrizB[i][j] = n;
			}
		}		
	}
	
	void mostrarMatrizResult(){	//ok ELEMENTOS GRAFICOS
		String tst="";
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				tst+=matriz[i][j]+"       ";
				//System.out.print(matrizresult[i][j]+"\t" );
				}
			tst+="\n";
		}
		JOptionPane.showMessageDialog(null,tst,"Matriz Resultante",JOptionPane.INFORMATION_MESSAGE);
	}
	
	void mostrarMatrizResultString(){ //deprecated
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				System.out.print(matrizresult[i][j]+"\t" );
				}
			System.out.println("");
		}
	
	}
	
	void mostrarMatrizResult(int x,int y){	//ok	ELEMENTOS GRAFICOS
		String matrizResult="";
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				matrizResult+=matrizresult[i][j]+"       ";
				//System.out.print(matrizresult[i][j]+"\t" );
				}
			matrizResult+="\n";
			//System.out.println("");
		}
		JOptionPane.showMessageDialog(null,matrizResult,"Matriz Resultante",JOptionPane.INFORMATION_MESSAGE);
	}
	
	void mostrarMatriz(){ //ok	ELEMENTOS GRAFICOS
		String mostrarMatriz="";
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				mostrarMatriz+=matriz[i][j]+"       ";
				//System.out.print(matriz[i][j]+"\t" );
				}
			mostrarMatriz+="\n";
		}
		JOptionPane.showMessageDialog(null,mostrarMatriz,"Matriz Resultante A",JOptionPane.INFORMATION_MESSAGE);
	}
	
	void mostrarMatrizB(){ //ok	ELEMENTOS GRAFICOS
		String mostrarMatrizB="";
		for (i = 0; i < xb; i++) {
			for (j = 0; j < yb; j++) {
				mostrarMatrizB+=matrizB[i][j]+"       ";
				//System.out.print(matriz[i][j]+"\t" );
				}
			mostrarMatrizB+="\n";
		}
		JOptionPane.showMessageDialog(null,mostrarMatrizB,"Matriz Resultante B",JOptionPane.INFORMATION_MESSAGE);
	}
	
	void verificarMatriz(){ //deprecated
		if (x==3 && y ==3){
			utilizarSarrus();
			utilizarLaplace();
		}
	}
	
	void utilizarSarrus(){ // Calculo ok 3x3
		if (x==3 && y==3){
			diagPrinc = matriz[0][0] * matriz[1][1] * matriz[2][2] + matriz[1][0] * matriz[2][1] * matriz[0][2] + matriz[2][0]* matriz[0][1] * matriz[1][2];
			diagSecond = matriz[0][2] * matriz[1][1] * matriz[2][0] + matriz[1][2] * matriz[2][1] * matriz[0][0] + matriz[2][2] * matriz[0][1] * matriz[1][0];
			sarrus = diagPrinc - (diagSecond);
			JOptionPane.showMessageDialog(null,"Utilizando SARRUS o resultado é: "+NumberFormat.getIntegerInstance().format(sarrus)+"","Metodo Sarrus",JOptionPane.INFORMATION_MESSAGE);
			//System.out.println("Utilizando SARRUS o resultado é: "+NumberFormat.getIntegerInstance().format(sarrus));
		}
		else {
			JOptionPane.showMessageDialog(null,"Sua matriz deve ser de Ordem 3 para utilizar o metodo de SARRUS! \n","ERROR!",JOptionPane.ERROR_MESSAGE);
			//System.out.println("Sua matriz deve ser de Ordem 3 para utilizar o metodo de SARRUS! \n");
			redefinirOrdemMatriz();
		}
	}
	
	void utilizarLaplace(){ // Calculo OK 3x3 e 4x4
		if(x==y){
			double c,detA,b,result,d;
				if(x==3 && y==3){
			 // Calculo ok UTILIZANDO a PRIMEIRA COLUNA.
					detA=matriz[0][0]* Math.pow((-1),(1+1))*(matriz[1][1]*matriz[2][2]-matriz[2][1]*matriz[1][2]);
					c=matriz[1][0]* Math.pow((-1),(2+1)) * (matriz[0][1]*matriz[2][2] - matriz[0][2]*matriz[2][1]);
					b=matriz[2][0]* Math.pow((-1),(3+1))* (matriz[0][1]*matriz[1][2] - matriz[0][2]*matriz[1][1]) ;
					result= detA+c+b;
					JOptionPane.showMessageDialog(null,"Utilizando LAPLACE o resultado é: "+ NumberFormat.getIntegerInstance().format(result)+"","Metodo LAPLACE",JOptionPane.INFORMATION_MESSAGE);
					//System.out.print("Utilizando LAPLACE o resultado é: "+ NumberFormat.getIntegerInstance().format(result));
		}
				if(x==4 && y==4){
				 // Calculo TO DO UTILIZANDO a PRIMEIRA COLUNA.
						// 1 4
					diagPrinc = matriz[0][0] * matriz[1][1] * matriz[2][2] + matriz[1][0] * matriz[2][1] * matriz[0][2] + matriz[2][0]* matriz[0][1] * matriz[1][2];
					diagSecond = matriz[0][2] * matriz[1][1] * matriz[2][0] + matriz[1][2] * matriz[2][1] * matriz[0][0] + matriz[2][2] * matriz[0][1] * matriz[1][0];
					int diagPrinc1 = diagPrinc - (diagSecond);
					detA=matriz[0][3]* Math.pow((-1),(1+4))*(diagPrinc1);
		//System.out.println(detA);
						// 2 4
					diagPrinc = matriz[0][0] * matriz[2][1] * matriz[3][2] + matriz[2][0] * matriz[3][1] * matriz[0][2] + matriz[3][0]* matriz[0][1] * matriz[2][2];
					diagSecond = matriz[0][2] * matriz[2][1] * matriz[3][0] + matriz[0][0] * matriz[3][1] * matriz[2][2] + matriz[2][0] * matriz[0][1] * matriz[3][2];			
					int diagPrinc2=diagPrinc-(diagSecond);
					c=matriz[1][3]* Math.pow((-1),(2+4)) * (diagPrinc2);
				
				
	//System.out.println(c);
						//3 4
				
					diagPrinc = matriz[0][0] * matriz[1][1] * matriz[3][2] + matriz[1][0] * matriz[3][1] * matriz[0][2] + matriz[3][0]* matriz[0][1] * matriz[1][2];
					diagSecond = matriz[3][0] * matriz[1][1] * matriz[0][2] + matriz[0][0] * matriz[3][1] * matriz[3][1] + matriz[1][2] * matriz[0][1] * matriz[3][2];
					int diagPrinc3 = diagPrinc - (diagSecond);
					b=matriz[2][3]* Math.pow((-1),(3+4))* (diagPrinc3) ;
				
					// 4 4

					diagPrinc = matriz[0][0] * matriz[0][1] * matriz[0][2] + matriz[1][0] * matriz[2][1] * matriz[0][2] + matriz[2][0]* matriz[0][1] * matriz[1][2];
					diagSecond = matriz[2][0] * matriz[1][1] * matriz[0][2] + matriz[0][0] * matriz[2][1] * matriz[1][2] + matriz[1][0] * matriz[0][1] * matriz[2][2];
					int diagPrinc4 = diagPrinc - (diagSecond);
					d=matriz[3][3]* Math.pow((-1),(4+4))* (diagPrinc4) ;
					double total=detA+(c)+(b)+(d);
					JOptionPane.showMessageDialog(null,"Utilizando LAPLACE o resultado é: "+NumberFormat.getIntegerInstance().format(total)+"","Metodo LAPLACE",JOptionPane.INFORMATION_MESSAGE);
					//System.out.print("Utilizando LAPLACE o resultado é: "+NumberFormat.getIntegerInstance().format(total));
				
			}
	} 
		if(x!=3 && x!=4 || y!=3 && y!=4){
			JOptionPane.showMessageDialog(null,"Para utilizar LAPLACE a matriz deve ser QUADRADA Ordem 3 ou 4","ERRO!",JOptionPane.ERROR_MESSAGE);
			//System.out.println("Para utilizar LAPLACE a matriz deve ser QUADRADA Ordem 3 ou 4\n");
		redefinirOrdemMatriz();
	}
		
		//Laplace qlqr matriz quadrada.
				
		}
	
	public int getX(){ //ok
		return x;		
	}	
	public int getY(){//ok
		return y;
	}
	
	void setX(int x){//ok
		this.x=x;
	}
	void setY(int y){//ok
		this.y=y;
	}
	public int getXB(){//ok
		return xb;
	}
	public int getYB(){//ok
		return yb;
	}
	
	void getYB(int YB){//ok
		this.yb=YB;
	}
	void getXB(int XB){//ok
		this.xb=XB;
	}
	
	void setMatriz(){//ok
		matriz= new int[x][y];
		
		}
	void setMatrizB(){//ok
		matrizB= new int[xb][yb];
	}
	
	void setMatrizResult(){//ok
		matrizresult=new int[x][y];
	}
	
	void setMatrizResult(int x,int yb){//ok
		matrizresult=new int[x][yb];
	}
//------------------------------------------------ TESTES-------------------------------------------------
	void mostrarMatrizTeste(int x,int y){	//ok
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				System.out.print(matrizteste[i][j]+"\t" );
				}
			System.out.println("");
		}
	}
	void setMatrizTeste(int x,int y){
		matrizteste=new int [x][y];
	}
void teste(){
	setMatrizResult(x,yb);
	setMatrizTeste(x,yb);
	//setMatriz();
	//setMatrizB();
	
	for(i=0;i<x;i++){
		for(j=0;j<yb;j++){
			for(int k=0;k<yb;k++){
				matrizresult[i][i]=matriz[i][i]*matrizB[i][k];
				//mostrarMatrizResult(x,yb);
			}
				}
		}
	
	for(i=0;i<x;i++){
			for(int k=0;k<yb;k++){
				matrizteste[i][i]=matriz[i][i]*matrizB[i][k];
				//mostrarMatrizTeste(x,yb);
				}
		}
	
	System.out.println("\n");
	mostrarMatrizTeste(x,yb);
	}
}

public class PC_FMC {

	public static void main(String args[]) {
		Matriz mat = new Matriz();
		mat.principalMenu();
//		mat.ordemMatrizB();
//		mat.escolhaMatriz();
//		mat.tipoMatriz();
//		mat.setMatriz();
//		mat.setMatrizB();
//		mat.criarMatriz();
//		mat.criarMatrizB();
		//mat.teste();
		//System.out.println(mat.getX() +" "+ mat.getYB());
		
	}
}
