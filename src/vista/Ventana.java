package vista;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Division;
import modelo.Multiplicacion;
import modelo.Resta;
import modelo.Suma;
/**
 * 
 * @author Blanca
 *
 */
public class Ventana extends JFrame implements ActionListener{
	/**
	 * Se crean los objetos a utilizar en la ventana
	 */
	private JLabel lbN1 = new JLabel("Número 1");
	private JTextField txtN1 = new JTextField();
	private JLabel lbN2 = new JLabel("Número 2");
	private JTextField txtN2 = new JTextField();
	private JLabel lbResultado = new JLabel("El resultado es:");
	
	private JButton btnSuma= new JButton("+");
	private JButton btnResta= new JButton("-");
	private JButton btnMultiplicacion= new JButton("x");
	private JButton btnDivision = new JButton("/");
	
	private Container c= getContentPane();
	
	private Division div = new Division();
	private Multiplicacion mul= new Multiplicacion();
	private Resta res= new Resta();
	private Suma sum = new Suma();
	/**
	 * Método para crear la ventana
	 */
	public Ventana(){
		super.setTitle("Operaciones");
		super.setSize(250,340);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarControles();
		
	}
	
	
	/**
	 * Método en donde se coloca la posición y dimesión de los objetos y se agregan a la ventana
	 */
	private void cargarControles() {
		// TODO Auto-generated method stub
		c.setLayout(null);
		lbN1.setBounds(10, 10, 100, 30);
		txtN1.setBounds(10, 40, 180, 30);
		
		lbN2.setBounds(10, 80, 100, 30);
		txtN2.setBounds(10, 120, 180, 30);
		
		btnSuma.setBounds(28, 160, 60, 30);
		btnResta.setBounds(98,160,60,30);
		btnMultiplicacion.setBounds(28, 200, 60, 30);
		btnDivision.setBounds(98, 200, 60, 30);
		lbResultado.setBounds(50, 240, 280, 30);
		
		c.add(lbN1);
		c.add(lbN2);
		c.add(txtN1);
		c.add(txtN2);
		c.add(btnSuma);
		c.add(btnResta);
		c.add(btnMultiplicacion);
		c.add(btnMultiplicacion);
		c.add(btnDivision);
		c.add(lbResultado);
		
		btnSuma.addActionListener(this);
		btnResta.addActionListener(this);
		btnMultiplicacion.addActionListener(this);
		btnDivision.addActionListener(this);
		
		
	}



	@Override
	/**
	 * Método en donde se le coloca la acción a los botones 
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object btn = e.getSource();
		if(btn==btnSuma){
			int r=sum.operaciones(Integer.parseInt(txtN1.getText()), Integer.parseInt(txtN2.getText()));
			lbResultado.setText(String.format("%s + %s = %d", txtN1.getText(),txtN2.getText(),r));
		}
		if(btn==btnResta){
			int r=res.operaciones(Integer.parseInt(txtN1.getText()),Integer.parseInt(txtN2.getText()));
			lbResultado.setText(String.format("%s - %s = %d", txtN1.getText(),txtN2.getText(),r));
		}
		if(btn==btnMultiplicacion){
			int r=mul.operaciones(Integer.parseInt(txtN1.getText()), Integer.parseInt(txtN2.getText()));
			lbResultado.setText(String.format("%s x %s = %d", txtN1.getText(), txtN2.getText(),r));
		}
		if(btn==btnDivision){
			float r=div.operaciones2(Float.parseFloat(txtN1.getText()), Float.parseFloat(txtN2.getText()));
			lbResultado.setText(String.format("%s / %s = %f", txtN1.getText(), txtN2.getText(),r));
		}
		
	}

}
