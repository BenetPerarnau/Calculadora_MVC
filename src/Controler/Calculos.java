package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.Calculadora;
import Vista.Interfaz;

public class Calculos implements ActionListener {

	private Calculadora calculadora;
	private Interfaz interfaz;
	
	public Calculos(Calculadora a,Interfaz i) {
		
		this.calculadora=a;
		this.interfaz=i;
		
		this.interfaz.addListeners(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(JButton[] boton:interfaz.getButtons()){
			
			for(JButton bot:boton){
				
				if(e.getSource()==bot){
					
					switch(bot.getText()){
					case "+":
						calculadora.suma(interfaz.getPantalla());
						interfaz.setValueToDisplay(calculadora.getNum()+"");
						break;
					case "-":
						calculadora.resta(interfaz.getPantalla());
						interfaz.setValueToDisplay(calculadora.getNum()+"");
						break;
					case "X":
						calculadora.multi(interfaz.getPantalla());
						interfaz.setValueToDisplay(calculadora.getNum()+"");
						break;
					case "/":
						calculadora.divi(interfaz.getPantalla());
						interfaz.setValueToDisplay(calculadora.getNum()+"");
						break;
					case "C":
						calculadora.reset();
						interfaz.setValueToDisplay(calculadora.getNum()+"");
						break;
					case "=":
						calculadora.igual(interfaz.getPantalla());
						interfaz.setValueToDisplay(calculadora.getNum()+"");
						break;
						default:
								interfaz.setValueToDisplay(bot.getText());				
							break;
					
					}
				}
			}
			
		}
		
	}

}
