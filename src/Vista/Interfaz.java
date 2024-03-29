package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controler.Calculos;
import Model.Calculadora;

public class Interfaz extends JFrame {
	
	private Calculadora calculadora;
	private JPanel visor,pbotones,panelcontenido;
	private BoxLayout boxlayaut;
	private JTextField pan;
	private final String[][] nombres={{"7","8","9","+"},{"4","5","6","-"},{"3","2","1","X"},{"0","C","=","/"}};
	private  JButton[][] botones;
	
	public Interfaz(Calculadora a){

		this.calculadora=a;
		
		panelcontenido=(JPanel)this.getContentPane();
		boxlayaut=new BoxLayout(panelcontenido,BoxLayout.Y_AXIS);
		panelcontenido.setLayout(boxlayaut);
		
			visor=new JPanel();
			visor.setMaximumSize(new Dimension(300,50));
		
				pan= new JTextField("0.0");
				pan.setHorizontalAlignment(JTextField.RIGHT);
				pan.setFont(new Font("Arial", Font.PLAIN, 30));
				pan.setEditable(false);
				pan.setPreferredSize(new Dimension(300,35));
		
			visor.add(pan);
		panelcontenido.add(visor);
		
			pbotones=new JPanel(new GridLayout(4,4));
					
					botones=new JButton[4][4];
			
					for(int i=0; i<4; i++){
						for(int j=0; j<4; j++){
							botones[i][j]=new JButton(nombres[i][j]);
							botones[i][j].setFont(new Font("Arial", Font.PLAIN, 24));
							if(botones[i][j].getText().equalsIgnoreCase("C")){
								botones[i][j].setForeground(Color.RED);
							}else if(botones[i][j].getText().equalsIgnoreCase("+")||botones[i][j].getText().equalsIgnoreCase("-")||botones[i][j].getText().equalsIgnoreCase("X")||botones[i][j].getText().equalsIgnoreCase("/")){
								botones[i][j].setForeground(Color.ORANGE);
							}else if(botones[i][j].getText().equalsIgnoreCase("=")){
								botones[i][j].setForeground(Color.BLUE);
							}
							pbotones.add(botones[i][j]);
						}
					}
		
		panelcontenido.add(pbotones);
		
		this.setTitle("Calculadora MVC");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(300,350));
		this.setLocationRelativeTo(null);//tendria que abrir la aplicacion en el medio de la pantalla pero en mac pantalla retina no
		this.setResizable(false);
		this.setVisible(true);
		this.pack();
	}
	
	//metodo el cual pondra listeners a los botones usando la clase controlador de nestro modelo MVC
	public void addListeners(Calculos controler){
		
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				botones[i][j].addActionListener((ActionListener) controler);
			}
		}
	}
	//metodo para que la clase controladora pueda disponer de los botones, es decir retornara la coleccion de botones
	public JButton[][] getButtons() { 
		return botones;
	}
	//metodo para madificar la visual de la pantalla con el valor asignado
	public void setValueToDisplay(String value){ 
		this.pan.setText(value);
	}
	//metodo para obtener lo que hay en la pantalla
	public String getPantalla(){
		return this.pan.getText();
	}

	

}
