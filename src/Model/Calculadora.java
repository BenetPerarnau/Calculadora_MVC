package Model;

public class Calculadora {

	private static double num;
	private static double acumulador;
	private static char signo;
	
	public Calculadora() {
		num=0;
		acumulador=0;
	}
	
	//
	public static void igual( String pantalla){
		switch (signo){
		case '+':
			sumaAux(pantalla);
			break;
		case '-':
			restaAux(pantalla);
			break;
		case '*':
			multiAux(pantalla);
			break;
		case '/':
			diviAux(pantalla);
			break;
			default://se introduce un nuemero no se detecta singun signo resultado sera el mismo numero
				primerValor(pantalla);
				break;
		}
		
		signo='=';
	}
	public static void suma(String pantalla){
		
		if(signo=='+'){
			sumaAux(pantalla);
		}else if(signo=='-'){
			restaAux(pantalla);
		}else if(signo=='*'){
			multiAux(pantalla);
		}else if(signo=='/'){
			diviAux(pantalla);
		}else if(signo=='='){
			igualAux(pantalla);
		}else{
			primerValor(pantalla);
		}
		signo='+';
	}
	public static void resta(String pantalla){		
		if(signo=='-'){
			restaAux(pantalla);
		}else if(signo=='+'){
			sumaAux(pantalla);
		}else if(signo=='*'){
			multiAux(pantalla);
		}else if(signo=='/'){
			diviAux(pantalla);
		}else if(signo=='='){
			igualAux(pantalla);
		}else{
			primerValor(pantalla);
		}
		signo='-';
	}
	public static void multi(String pantalla){
		
		if(signo=='*'){
			multiAux(pantalla);
		}else if(signo=='-'){
			restaAux(pantalla);
		}else if(signo=='+'){
			sumaAux(pantalla);
		}else if(signo=='/'){
			diviAux(pantalla);
		}else if(signo=='='){
			igualAux(pantalla);
		}else{
			primerValor(pantalla);
		}
		signo='*';
	}
	public static void divi(String pantalla){
		
		if(signo=='*'){
			multiAux(pantalla);
		}else if(signo=='-'){
			restaAux(pantalla);
		}else if(signo=='+'){
			sumaAux(pantalla);
		}else if(signo=='/'){
			diviAux(pantalla);
		}else if(signo=='='){
			igualAux(pantalla);
		}else{
			primerValor(pantalla);
		}
		signo='/';
		
	}
	//metodos auxiliares para no escribir en cada signo lo mismo
	private static void sumaAux(String pantalla){
		num=Double.parseDouble(pantalla);
		acumulador+=num;
	}
	private static void restaAux(String pantalla){
		num=Double.parseDouble(pantalla);
		acumulador-=num;
	}
	private static void multiAux(String pantalla){
		num=Double.parseDouble(pantalla);
		acumulador*=num;
	}
	private static void diviAux(String pantalla){
		num=Double.parseDouble(pantalla);
		acumulador/=num;
	}
	private static void igualAux(String pantalla){
		acumulador=Double.parseDouble(pantalla);
	}
	private static void primerValor(String pantalla){
		num=Double.parseDouble(pantalla);
		acumulador=num;
	}

	public static double getNum(){
		return acumulador;
	}
	public static void reset(){
		num=0;
		acumulador=0;
		signo='n';
	}
}
