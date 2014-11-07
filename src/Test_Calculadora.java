import Controler.Calculos;
import Model.Calculadora;
import Vista.Interfaz;


public class Test_Calculadora {

	
	
	public static void main(String[]args){
				
		Calculadora modelo=new Calculadora(); //modelo
		Interfaz vista=new Interfaz(modelo);  //vista
		Calculos calcula=new Calculos(modelo,vista); //controlador
	}

}
