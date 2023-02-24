package Conversiones;
import java.awt.event.*;
import javax.swing.*;

public class Temperatura extends JFrame implements ActionListener {

  JButton btnResultado;
  JLabel title1, title2;
  double result;
  JTextField value;
  JComboBox<String> options;

  public Temperatura() {
    setLayout(null);
    setSize(300, 180);
    setTitle("Temperatura");
    setLocationRelativeTo(null);
    setResizable(false);
    grados();
  }

  private void grados() {
    String[] medida = new String[]{
      null, 
      "Celsius a Fareheit", 
      "Celsius a Kelvin", 
      "Ferenheit a Celsius", 
      "Kelvin a Celsius"
    };

    title1 = new JLabel("Selecciona la unidad de medida");
    title1.setBounds(37, 3, 224, 20);

    options = new JComboBox<String>(medida);
    options.setBounds(49, 22, 201, 20);

    title2 = new JLabel("Grados:");
    title2.setBounds(70, 60, 56, 20);

    value = new JTextField();
    value.setBounds(127, 60, 100, 20);

    btnResultado = new JButton("Resultado");
    btnResultado.setBounds(96, 100, 106, 20);
    btnResultado.addActionListener(this);

    add(title1);
    add(options);
    add(title2);
    add(value);
    add(btnResultado);
  }
  private void cleaner(){
    value.setText("");
    options.setSelectedItem(null);
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    String unidad = (String) options.getSelectedItem();
    if(unidad != null){
      if(!value.getText().trim().isEmpty()){
        if(Double.parseDouble(value.getText()) > 0){
          switch (unidad) {
            case "Celsius a Fareheit":
              result = (Double.parseDouble(value.getText()) * 1.8) + 32;
              JOptionPane.showMessageDialog(null, "El resultado es: " + result + " °F");
              break;
            case "Celsius a Kelvin":
              result = Double.parseDouble(value.getText()) - 273.15;
              JOptionPane.showMessageDialog(null, "El resultado es: " + result + " °K");
              break;
            case "Ferenheit a Celsius":
              result = (Double.parseDouble(value.getText()) - 32)/ 1.8;
              JOptionPane.showMessageDialog(null, "El resultado es: " + result + " °C");
              break;
            case "Kelvin a Celsius":
              result = Double.parseDouble(value.getText()) + 273.15;
              JOptionPane.showMessageDialog(null, "El resultado es: " + result + " °C");
              break;
            default:
              JOptionPane.showMessageDialog(null, "No se encontró la unidad");
          }
        }else{
          JOptionPane.showMessageDialog(null, "La unidad tiene que ser mayor a 0");
          return;
        }
      }else{
        JOptionPane.showMessageDialog(null, "Ingrese un valor");
        return;
      }
    }else{
      JOptionPane.showMessageDialog(null, "Seleccione un tipo de conversión");
      return;
    }
    cleaner();
    JOptionPane.showMessageDialog(null, "Programa finalizado");
  }
}
