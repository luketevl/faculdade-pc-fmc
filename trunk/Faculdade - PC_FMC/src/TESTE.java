import java.util.Scanner;
import javax.swing.JOptionPane;
public class TESTE {
	public static void main(String args[]){
		Scanner op = new Scanner(System.in);
		
		/*int x;
		for(x=0;x<20;x++){
		System.out.println("Numero: "+(int)(999*Math.random()));
		
		}
		System.out.println("oola");
	
		
	double	it,lq,txDia,txMes,n,j,qo,sn;
	
	lq=Math.pow((1+1/100),(1/30)-1);
	
	txDia=lq*100;
	//it=txMes/100;
	
		sn=Math.pow((1+1),1)*1;
	
	System.out.println(sn);
		int x=2,y=2,n,i,j;
		int matriz[][];
		matriz=new int[x][y];
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				System.out.print("a"+(i+1)+""+(j+1)+":  ");
				n = op.nextInt();
				matriz[i][j] = n;
			}
		}
		System.out.println(matriz[x-1][y-1] + " FDP " + matriz[x-1][0]);
		*/
//		JOptionPane.showInputDialog(null," message","rere",JOptionPane.YES_NO_OPTION);
//		int x=0;
//		if(x==0){
//			System.out.println("UI");
//		}
//		else if(x==0 || x==1){
//			System.out.println("OIE");
//		}
		
		
//		JOptionPane.showInputDialog(null,"rere","A",JOptionPane.CANCEL_OPTION);
//		JOptionPane.showInputDialog(null,"rere","B",JOptionPane.CLOSED_OPTION);
//		JOptionPane.showInputDialog(null,"rere","C",JOptionPane.DEFAULT_OPTION);
//		JOptionPane.showInputDialog(null,"rere","D",JOptionPane.ERROR_MESSAGE);
//		JOptionPane.showInputDialog(null,"rere","E",JOptionPane.NO_OPTION);
//		JOptionPane.showInputDialog(null,"rere","F",JOptionPane.OK_CANCEL_OPTION);
//		JOptionPane.showInputDialog(null,"rere","G",JOptionPane.OK_OPTION);
//		JOptionPane.showInputDialog(null,"rere","H",JOptionPane.PLAIN_MESSAGE);
//		//JOptionPane.showInputDialog(null,"rere","I",JOptionPane.QUESTION_MESSAGE);
////		JOptionPane.showInputDialog(null,"rere","",JOptionPane.SELECTION_VALUES_PROPERTY("D"));
//		JOptionPane.showInputDialog(null,"rere","J",JOptionPane.WARNING_MESSAGE);
//		JOptionPane.showInputDialog(null,"rere","K",JOptionPane.YES_NO_CANCEL_OPTION);
//		JOptionPane.showInputDialog(null,"rere","L",JOptionPane.YES_NO_OPTION);
//		JOptionPane.showInputDialog(null,"rere","M",JOptionPane.YES_OPTION);
//		JOptionPane.showInputDialog(null,"rere","N",JOptionPane.ERROR);
//		JOptionPane.showInputDialog(null,"rere","O",JOptionPane.ABORT);
		int x=2,y=2;
		String nome[][],tst="",exib="";
		nome=new String[x][y];
		for(int ib=0;ib<x;ib++){
			for(int jb=0;jb<y;jb++){
				tst=JOptionPane.showInputDialog(null,"Digite","RE",JOptionPane.ERROR_MESSAGE);
				//tst+=nome[ib][jb];
				
				nome[ib][jb]= tst;
			}
		}
		
		for(int ib=0;ib<x;ib++){
			for(int jb=0;jb<y;jb++){
				exib+=nome[ib][jb]+"        ";
				System.out.print(nome[ib][jb]);
			}
			//System.out.println("\n\n\n\n\n\n");
			exib+="\n";
			System.out.println(exib);
		}
		/*for(int i=0;i<x;i++){
			tst +="LU";
			for(int j=0;j<y;j++){
				tst+= "CAS ";
			}
			
		}*/
		JOptionPane.showMessageDialog(null,exib,"ui",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null,tst,"ui",JOptionPane.INFORMATION_MESSAGE);
		
	}

}
