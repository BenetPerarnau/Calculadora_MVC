package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import Model.Calculadora;
import Vista.Interfaz;

public class Calculos implements ActionListener {

	private Calculadora calculadora;//modelo
	private Interfaz interfaz;//vista
	private static boolean doble=false;//auxiliar para saber si tenemos que concatenar en pantalla o no.
	public Calculos(Calculadora a,Interfaz i) {
		
		this.calculadora=a;
		this.interfaz=i;	
		this.interfaz.addListeners(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(JButton[] boton:interfaz.getButtons()){//bucle en el cual se recorre "filas" la coleccion de botones obtenida de la interfaz.
			
			for(JButton bot:boton){{//bucle en el cual se recorre "columnas" la coleccion de botones obtenida de la interfaz.
				
				if(e.getSource()==bot){//obtenemos el boton pulsado de la coleccion de JButtons
					
					switch(bot.getText()){//segun el texto que contenga el boton:
					case "+":
						calculadora.suma(interfaz.getPantalla());//se llama al modelo para que realize la suma pasandole la info de la pantalla de la interfaz
						interfaz.setValueToDisplay(calculadora.getNum()+"");//se acutaliza la pantalla de la interfaz segun el resultado de la operación
						doble=false;//al pulsar un signo de operación indica que el proximo digito no sera concatenado a lo que ya hay en la pantalla
						break;
					case "-":
						calculadora.resta(interfaz.getPantalla());
						interfaz.setValueToDisplay(calculadora.getNum()+"");
						doble=false;
						break;
					case "X":
						calculadora.multi(interfaz.getPantalla());
						interfaz.setValueToDisplay(calculadora.getNum()+"");
						doble=false;
						break;
					case "/":
						calculadora.divi(interfaz.getPantalla());
						interfaz.setValueToDisplay(calculadora.getNum()+"");
						doble=false;
						break;
					case "C":
						calculadora.reset();
						interfaz.setValueToDisplay(calculadora.getNum()+"");
						doble=false;
						break;
					case "=":
						calculadora.igual(interfaz.getPantalla());
						interfaz.setValueToDisplay(calculadora.getNum()+"");
						doble=false;
						break;
						default://numeros
							if(doble==false){
								interfaz.setValueToDisplay(bot.getText());
								doble=true;
							}else{
								interfaz.setValueToDisplay(interfaz.getPantalla()+bot.getText());
							}					
							break;					
					}
				}
			}		
		}	
	}
  }
}
