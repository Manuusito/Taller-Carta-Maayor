package CartaMayor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGridBagLayout extends JFrame {
    private static final String MENSAJE_INICIO = "Bienvenido a Carta Mayor \n"
            + "Oprime el botón lanzar para iniciar el juego"
            + "\nSi tu lanzaminto de carta es Mayor que a la de la maquina Ganaras,"
            + "\nSi no, entonces perderas."
            + "\nEn caso de sacar el mismo valor, el ganador se define por el Palo,"
            + "\nSiendo Oros mayor que Copas, Copas mayor que Espadas y Espadas mayor que Bastos.";

    private Header headerProject;
    private JLabel carta1, carta2;
    private JButton lanzar, ayuda, salir;
    // private JPanel panelCartas;
    private JTextArea mensajesSalida, resultadosCartas;
    private Escucha escucha;
    private ModelCard modelCard;

    public GUIGridBagLayout() {
        initGUI();
        //Default JFrame configuration
        this.setTitle("Juego Carta Mayor");
        this.setUndecorated(true);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Create Listener Object and Control Object
        escucha = new Escucha();
        modelCard = new ModelCard();
        //Set up JComponents
        headerProject = new Header("Mesa Juego Carta Mayor", Color.BLACK);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(headerProject, constraints);

        ayuda = new JButton("?");
        ayuda.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        this.add(ayuda,constraints);

        salir = new JButton("Salir");
        salir.addActionListener(escucha);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_END;
        this.add(salir,constraints);
/**
        imageDado = new ImageIcon(getClass().getResource("/resources/dado.png"));
        dado1 = new JLabel(imageDado);
        dado2 = new JLabel(imageDado);

        panelDados = new JPanel();
        panelDados.setPreferredSize(new Dimension(300,180));
        panelDados.setBorder(BorderFactory.createTitledBorder("Tus Cartas"));
        panelDados.add(dado1);
        panelDados.add(dado2);

        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(panelDados,constraints);
 */
        resultadosCartas = new JTextArea(4,31);
        resultadosCartas.setBorder(BorderFactory.createTitledBorder("Resultados"));
        resultadosCartas.setText("Debes tomar una carta");
        resultadosCartas.setBackground(null);
        resultadosCartas.setEditable(false);

        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(resultadosCartas,constraints);

        lanzar = new JButton("Tomar Carta");
        lanzar.addActionListener(escucha);

        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(lanzar,constraints);

        mensajesSalida = new JTextArea(4,31);
        mensajesSalida.setText("Usa el botón (?) para ver las reglas del juego");
        mensajesSalida.setBorder(BorderFactory.createTitledBorder("Mensajes"));
        mensajesSalida.setBackground(null);
        mensajesSalida.setEditable(false);

        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(mensajesSalida,constraints);

    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIGridBagLayout miProjectGUI = new GUIGridBagLayout();
        });
    }

    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==lanzar){
                modelCard.calcularTiro();
                //int[] caras = modelCraps.getCaras();
                //imageDado = new ImageIcon(getClass().getResource("/resources/"+caras[0]+".png"));
                //dado1.setIcon(imageDado);
                //imageDado = new ImageIcon(getClass().getResource("/resources/"+caras[1]+".png"));
                //dado2.setIcon(imageDado);

                modelCard.determinarJuego();

                resultadosCartas.setText(modelCard.getEstadoToString()[0]);
                mensajesSalida.setText(modelCard.getEstadoToString()[1]);
                revalidate();
                repaint();
            }else{
                if(e.getSource()==ayuda){
                    JOptionPane.showMessageDialog(null,MENSAJE_INICIO);
                }else{
                    System.exit(0);
                }
            }
        }
    }
}
