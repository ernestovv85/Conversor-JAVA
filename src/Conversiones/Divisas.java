package Conversiones;

import java.awt.event.*;
import javax.swing.*;

public class Divisas extends JFrame implements ActionListener {

  JButton btnResultado;
  JLabel title1, title2;
  double result;
  JTextField value;
  JComboBox<String> options;

  public Divisas() {
    setLayout(null);
    setSize(300, 180);
    setTitle("Divisas");
    setLocationRelativeTo(null);
    setResizable(false);
    tipoDeCambio();
  }

  private void tipoDeCambio() {
    String[] moneda = new String[] {
      null,
      "MXN a USD",
      "MXN a EUR",
      "MXN a GBP",
      "MXN a JPY",
      "MXN a KRW",
      "USD a MXN",
      "EUR a MXN",
      "GBP a MXN",
      "JPY a MXN",
      "KRW a MXN",
    };

    title1 = new JLabel("Selecciona el tipo de cambio");
    title1.setBounds(49, 3, 201, 20);

    options = new JComboBox<String>(moneda);
    options.setBounds(49, 22, 201, 20);

    title2 = new JLabel("Monto:");
    title2.setBounds(74, 60, 50, 20);

    value = new JTextField();
    value.setBounds(125, 60, 100, 20);

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
    String cambio = (String) options.getSelectedItem();

    if(cambio != null){
      if(!value.getText().trim().isEmpty()){
        if(Double.parseDouble(value.getText()) > 0){
          switch (cambio) {
            case "MXN a USD":
              result = Double.parseDouble(value.getText()) / 18.41;
              JOptionPane.showMessageDialog(null, "Tienes " + result + " USD");
              break;
            case "MXN a EUR":
              result = Double.parseDouble(value.getText()) / 19.52;
              JOptionPane.showMessageDialog(null, "Tienes " + result + " EUR");
              break;
            case "MXN a GBP":
              result = Double.parseDouble(value.getText()) / 22.14;
              JOptionPane.showMessageDialog(null, "Tienes " + result + " GBP");
              break;
            case "MXN a JPY":
              result = Double.parseDouble(value.getText()) * 7.41;
              JOptionPane.showMessageDialog(null, "Tienes " + result + " JPY");
              break;
            case "MXN a KRW":
              result = Double.parseDouble(value.getText()) * 100;
              JOptionPane.showMessageDialog(null, "Tienes " + result + " KRW");
              break;
            case "USD a MXN":
              result = Double.parseDouble(value.getText()) * 18.41;
              JOptionPane.showMessageDialog(null, "Tienes " + result + " MXN");
              break;
            case "EUR a MXN":
              result = Double.parseDouble(value.getText()) * 19.52;
              JOptionPane.showMessageDialog(null, "Tienes " + result + " MXN");
              break;
            case "GBP a MXN":
              result = Double.parseDouble(value.getText()) * 22.14;
              JOptionPane.showMessageDialog(null, "Tienes " + result + " MXN");
              break;
            case "JPY a MXN":
              result = Double.parseDouble(value.getText()) / 7.41;
              JOptionPane.showMessageDialog(null, "Tienes " + result + " MXN");
              break;
            case "KRW a MXN":
              result = Double.parseDouble(value.getText()) / 100;
              JOptionPane.showMessageDialog(null, "Tienes " + result + " MXN");
              break;
            default:
              JOptionPane.showMessageDialog(null, "No se encontró tipo de cambio");
          }
        }else{
          JOptionPane.showMessageDialog(null, "El monto tiene que ser mayor a 0");
          return;
        }
      }else{
        JOptionPane.showMessageDialog(null, "Ingrese un valor");
        return;
      }
    }else{
      JOptionPane.showMessageDialog(null, "Seleccione un tipo de cambio");
      return;
    }
    cleaner();
    JOptionPane.showMessageDialog(null, "Programa finalizado");
  }
}
