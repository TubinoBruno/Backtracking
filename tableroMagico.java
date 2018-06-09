package entregable;

import java.util.ArrayList;

public class tableroMagico {
	int n=3;
	int k=12;
	int S=15;
	int []sumfila=new int[n];
	int []sumcol=new int[n];
	boolean []usado=new boolean[k+1];
	int [][]tablero=new int[n][n];
	public tableroMagico(){
		for(int i=0;i<n;i++){
			sumfila[i]=0;
			sumcol[i]=0;
			for(int j=0;j<n;j++){
				tablero[i][j]=0;
				

			}
		}
		for(int t=0;t<k+1;t++){
			usado[t]=false;
		}
		int casillero=0;
		getSolucion(casillero);


	}
	public boolean getSolucion(int casillero){	
		if(casillero==n*n){
			if(isSolucion()){
				imprimir();
				return true;
			}
		}
		else{
			for(int valor=0;valor<=k;valor++){

				if(!usado[valor]){
					tablero[casillero/n][casillero%n]=valor;
					usado[valor]=true;
					boolean result = getSolucion(casillero+1);
					if (result){
						return true;
					}
					usado[valor]=false;
					tablero[casillero/n][casillero%n]=0;

				}





			}
		}

		return false;
	}
	public boolean esPoda(int c,int v){
		int cont=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				sumfila[c]=sumfila[c]+tablero[c][i%n];
				sumcol[c]=sumcol[c]+tablero[i/n][c];
				if(sumfila[c]+v>S&&sumcol[c]+v>S){
					cont++;
				}
			}

		}

		return false;
	}
	public boolean usado(int k){
		return usado[k];
		/*for (int i = 0; i < n; i++) {
			if (tablero[i/n][i%n] == k) {
				return true;
			}
		}
		return false;*/
	}




	public boolean isSolucion(){
		int contador=0;
		int sumafila;
		int sumacolumna;
		for(int i=0;i<n;i++){
			sumafila=0;
			for(int j=0;j<n;j++){
				sumafila=sumafila+tablero[i][j];

			}
			if(sumafila!=S){
				return false;
			}
		}
		for(int i=0;i<n;i++){
			sumacolumna=0;
			for(int j=0;j<n;j++){
				sumacolumna=sumacolumna+tablero[j][i];

			}
			if(sumacolumna!=S){
				return false;
			}
		}
		return true;

	}

	public void imprimir(){
		int t=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(t<k){
					System.out.print(tablero[i][j]+" ");

				}
			}
			System.out.println("");
		}
	}


	public static void main(String[] args) {
		tableroMagico t=new tableroMagico();

	}

}
