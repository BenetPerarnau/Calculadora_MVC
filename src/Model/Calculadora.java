package Model;

public class Calculadora {

	private static double num;
	private static double acumulador;
	private static char signo;
	
	public Calculadora() {
		num=0;
		acumulador=0;
	}
	
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
			default://se introduce un nuemero y no se detecta singun signo el resultado sera el mismo numero.
				primerValor(pantalla);
				break;
		}
		
		signo='=';
	}
	public static void suma(String pantalla){
		/*
		 * Pq en cada metodo hay todas las operaciones?
		 * 		pq si hacemos (2-2+3=3) cuando apretamos el - tiene que hacer una suma y no una resta.
		 * 		y asi en todas las operaciones incluso cuando apretamos el = tendra que realizar la operacion marcada por
		 * 		el ultimo signo pulsado.
		 */
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
	//metodos auxiliares para no escribir en cada metodo y signo lo mismo
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
	//metodo para retornar resultado
	public static double getNum(){
		return acumulador;
	}
	//metofo para poner todo a 0
	public static void reset(){
		num=0;
		acumulador=0;
		signo='n';
	}
}
