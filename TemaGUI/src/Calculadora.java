

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora extends JFrame {
	JTextField texto;
	JPanel panelCentro=new JPanel();
	JButton boton;
	JButton[] botones= new JButton[100];
	String[] letras={"+","-","*","/","=","1","2","3","4","5","6","7","8","9","0"};
	String ope="",caracter;
	
	int num1=0,num2=0;
	
	Calculadora(){
		Container contenedor=this.getContentPane();
		contenedor.setLayout(null);
		
		
		texto=new JTextField();
		texto.setBounds(25, 25, 235, 100);
		texto.setEnabled(false);
		
		 
		cargar();
		panelCentro.setBounds(40, 150, 210, 60);
		
		
		ActionListener operacion=new ActionListener(){
			public void actionPerformed(ActionEvent a){
				JButton pruebas=(JButton)(a.getSource());
				
				
				for(int i=0;i<botones.length;i++)
				{
					if(pruebas==botones[i] && i<4)
							{
								if(num1!=0)
								{
									num2=Integer.parseInt(texto.getText());
								}
								else
									num1=Integer.parseInt(texto.getText());
								
								caracter=botones[i].getText();
								
								ope="";
							}
					else
						if(pruebas==botones[i] && i>4)
						{
							ope=ope+letras[i].toString();
							texto.setText(ope);
						}
						else
							if(pruebas==botones[i] && i==4)
							{
								num2=Integer.parseInt(texto.getText());
								if(caracter.equals("+"))
								{
									num1=num1+num2;
								}
								else{
									if(caracter.equals("-"))
									{
										num1=num1-num2;
									}
									else{
										if(caracter.equals("*"))
											{
												num1=num1*num2;
											}
										else{
												if(caracter.equals("/"))
													{
														num1=num1/num2;
													}
											}
										}
								}
								texto.setText(String.valueOf(num1));
								num1=0;
								num2=0;
							
								ope=null;
							}
					
				}
				
				
				
			}
		};
		

		
		botones[0].addActionListener(operacion);
		botones[1].addActionListener(operacion);
		botones[2].addActionListener(operacion);
		botones[3].addActionListener(operacion);
		botones[4].addActionListener(operacion);
		botones[5].addActionListener(operacion);
		botones[6].addActionListener(operacion);
		botones[7].addActionListener(operacion);
		botones[8].addActionListener(operacion);
		botones[9].addActionListener(operacion);
		botones[10].addActionListener(operacion);
		botones[11].addActionListener(operacion);
		botones[12].addActionListener(operacion);
		botones[13].addActionListener(operacion);
		botones[14].addActionListener(operacion);
		
				
	
		
		contenedor.add("North",texto);
		contenedor.add("Center",panelCentro);
		
		setSize(300,300);
		setVisible(true);
		
		
	}
	
	
	public void cargar()
	{
		
		
		panelCentro.setLayout(new GridLayout(4,4));//EL GRID ESTE NO LO ENTIENDO
		
		for(int i=0;i<letras.length;i++)
		{
			
			botones[i]=new JButton();
			botones[i].setText(letras[i]);
			panelCentro.add(botones[i]);
		}
		
		
	}

	public static void main(String[] args) {
		Calculadora a=new Calculadora();

	}

}
