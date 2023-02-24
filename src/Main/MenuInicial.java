package Main;
import javax.swing.*;
import java.awt.event.*;
import Conversiones.*;

public class MenuInicial extends JFrame implements ActionListener{
	JLabel title;	
	JComboBox<String> selector;
	JButton btnOK;


	public MenuInicial() {
		setLayout(null);
		setSize(300, 180);
		setTitle("Menú");
		setLocationRelativeTo(null);
		setResizable(false);
		inicial();
	}
	
	private void inicial() {
		String[] options = new String[]{null, "Divisas", "Temperatura"};
		
		title = new JLabel("Selecciona una opción de conversión");
		title.setBounds(19, 5, 270, 30);
		
		selector = new JComboBox<String>(options);
		selector.setBounds(90, 50, 120, 20);

		btnOK = new JButton("OK");
		btnOK.setBounds(119, 100, 60, 20);
		btnOK.addActionListener(this);

		add(title);
		add(selector);
		add(btnOK);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String select = (String) selector.getSelectedItem();
		if(select == null){
			JOptionPane.showMessageDialog(null, "Selecciona una opción de conversión");
			return;
		}
		if(select == "Divisas"){
			Divisas ventanaDivisas = new Divisas();
			ventanaDivisas.setVisible(true);
		}else if(select == "Temperatura"){
			Temperatura ventanTemperatura = new Temperatura();
			ventanTemperatura.setVisible(true);
		}
	}
}
