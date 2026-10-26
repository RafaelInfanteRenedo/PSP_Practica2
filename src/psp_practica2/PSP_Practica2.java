package psp_practica2;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class PSP_Practica2 extends JFrame
{
    static Cliente cliente1 = new Cliente(222, "Manuel", 20, 75);
    static Cliente cliente2 = new Cliente(333, "Nicolas", 45, 2);
    static Cliente cliente3 = new Cliente(444, "Dylan", 27, 87);
    static Cliente cliente4 = new Cliente(555, "Enrique", 18, 100);
    static Cliente cliente5 = new Cliente(666, "Daniel", 31, 46);
    static Cliente cliente6 = new Cliente(777, "Juan", 19, 89);
    private static List<Cliente> clientes = new ArrayList<>();
    int indice = -1;
    //Valores para los campos de texto
    private int numero = 0;
    private int doble = 0;

    //Etiquetas para identificar los campos de texto
    private JLabel numeroLabel;
    private JLabel nombreLabel;
    private JLabel edadLabel;
    private JLabel puntosLabel;

    //Cadenas para las etiquetas
    private static String numeroString = "Número: ";
    private static String dobleString = "El doble es: ";

    //Text fields para introducir números (ahora son de Swing: JTextField)
    private JTextField numeroField;
    private JTextField nombreField;
    private JTextField edadField;
    private JTextField puntosField;
    
    private JButton atrasButton;
    private JButton delanteButton;

    public PSP_Practica2() {
        super("Doble");
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);
        clientes.add(cliente6);

        //Lo que pasa si cerramos la ventana (sustituye al WindowListener
        //con windowClosing y System.exit(0) de la versión anterior).
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Crea las etiquetas.
        numeroLabel = new JLabel("Numero");
        nombreLabel = new JLabel("Nombre");
        edadLabel = new JLabel("Edad");
        puntosLabel = new JLabel("Puntos");

        //Campo donde vamos a introducir el número
        numeroField = new JTextField(10);
        numeroField.setEditable(false);

        //Campo que nos muestra el doble del numero introducido
        nombreField = new JTextField(10);
        nombreField.setEditable(false);
        nombreField.setForeground(Color.red);
        
        //Campo edad
        edadField = new JTextField(10);
        edadField.setEditable(true);
        edadField.setForeground(Color.BLUE);
        
        //Campo puntos
        puntosField = new JTextField(10);
        puntosField.setEditable(false);
        puntosField.setForeground(Color.red);
        
        atrasButton = new JButton("<--");  // Asignarle una tecla.
        atrasButton.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                if(indice > 0){
                    System.out.println("Atras");
                    indice--;
                    clientesArray(indice);
                    if(indice!=0){
                        atrasButton.setVisible(true);
                    }
                    if(indice<clientes.size()-1){
                        delanteButton.setVisible(true);
                    }
                    if(indice <= 0){
                        atrasButton.setVisible(false);
                    }
                }
            }
        });
        
        delanteButton = new JButton("-->");  // Asignarle una tecla.
        delanteButton.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                if(indice < clientes.size()-1){
                    System.out.println("delante");
                    indice++;
                    clientesArray(indice);
                    if(indice!=0){
                        atrasButton.setVisible(true);
                    }
                    if(indice == clientes.size()-1){
                        delanteButton.setVisible(false);
                    }
                    if(indice <= 0){
                        atrasButton.setVisible(false);
                    }
                }
            }
        });

        //Dispone la geometría de las etiquetas en un panel
        JPanel labelPane = new JPanel();
        labelPane.setLayout(new GridLayout(0, 1));
        labelPane.add(numeroLabel);
        labelPane.add(nombreLabel);
        labelPane.add(edadLabel);
        labelPane.add(puntosLabel);

        //Dispone los campos de texto en otro panel
        JPanel fieldPane = new JPanel();
        fieldPane.setLayout(new GridLayout(0, 1));
        fieldPane.add(numeroField);
        fieldPane.add(nombreField);
        fieldPane.add(edadField);
        fieldPane.add(puntosField);
        
        //Panel para los botones
        JPanel botonesPane = new JPanel();
        botonesPane.setLayout(new GridLayout(1, 0));
        botonesPane.add(atrasButton);
        botonesPane.add(delanteButton);

        //Incluye los dos paneles en otro panel,
        //etiquetas a la izquierda
        //y campos de texto a la derecha.
        JPanel contentPane = new JPanel();
        contentPane.setBorder(
               BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BorderLayout());
        contentPane.add(labelPane, BorderLayout.CENTER);
        contentPane.add(fieldPane, BorderLayout.EAST);
        contentPane.add(botonesPane, BorderLayout.SOUTH);

        setContentPane(contentPane);  //this.setContentPane(contentPane);
          // es set, o sea, machado el contenedor del objeto "Doble", hijo de JFrame

    }
    
    public void clientesArray(int indice){
        numeroField.setText(clientes.get(indice).getNumero()+"");
        nombreField.setText(clientes.get(indice).getNombre());
        edadField.setText(clientes.get(indice).getEdad()+"");
        puntosField.setText(clientes.get(indice).getPuntos()+"");
    }

    public static void main(String[] args) {

        // Toda la interfaz Swing se crea en el hilo de eventos (receta: se hace siempre así).
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final PSP_Practica2 app = new PSP_Practica2();

                //Este WindowListener ya solo sirve para poner el foco.
                //(Para cerrar la ventana ya no hace falta: setDefaultCloseOperation.)
                app.pack();
                app.setVisible(true);
            }
        });
    }


}
