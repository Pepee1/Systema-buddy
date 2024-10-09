package SRC;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArbolBinarioGUI extends JFrame {
    private ArbolBinario arbol;
    private JTextField entradaValor;
    private JButton botonAgregar;
    private JPanel panelArbol;

    public ArbolBinarioGUI() {
        arbol = new ArbolBinario();
        configurarVentana();
        configurarComponentes();
    }

    private void configurarVentana() {
        setTitle("Árbol Binario GUI");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void configurarComponentes() {
        JPanel panelSuperior = new JPanel();
        entradaValor = new JTextField(10);
        botonAgregar = new JButton("Agregar");

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = entradaValor.getText();
                try {
                    int valor = Integer.parseInt(texto);
                    arbol.agregar(valor);
                    entradaValor.setText("");
                    panelArbol.repaint();  // Redibuja el árbol en el panel
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                }
            }
        });

        panelSuperior.add(new JLabel("Valor:"));
        panelSuperior.add(entradaValor);
        panelSuperior.add(botonAgregar);

        add(panelSuperior, BorderLayout.NORTH);

        panelArbol = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarNodo(g, arbol.raiz, getWidth() / 2, 30, getWidth() / 4);
            }
        };
        add(panelArbol, BorderLayout.CENTER);
    }

    private void dibujarNodo(Graphics g, Nodo nodo, int x, int y, int xOffset) {
        if (nodo != null) {
            g.drawOval(x - 15, y - 15, 30, 30);
            g.drawString(String.valueOf(nodo.valor), x - 6, y + 4);

            if (nodo.izquierdo != null) {
                g.drawLine(x, y, x - xOffset, y + 50);
                dibujarNodo(g, nodo.izquierdo, x - xOffset, y + 50, xOffset / 2);
            }

            if (nodo.derecho != null) {
                g.drawLine(x, y, x + xOffset, y + 50);
                dibujarNodo(g, nodo.derecho, x + xOffset, y + 50, xOffset / 2);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ArbolBinarioGUI().setVisible(true);
            }
        });
    }
}
