/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author jhona
 */
import Abstraccion.Hamburguesa;
import Concreta.HamburguesaBasica;
import Modeldecorator.Queso;
import Modeldecorator.Salsa;
import Modeldecorator.Tocino;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HamburguesaGUI extends JFrame {
    private Hamburguesa hamburguesa;
    private JLabel descripcionLabel;
    private JLabel costoLabel;
    private int extrasCount = 0;

    public HamburguesaGUI() {
        setTitle("Hamburguesa McDonald's");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        hamburguesa = new HamburguesaBasica();

        // Estilo y diseño de la interfaz
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        centralPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        centralPanel.setBackground(new Color(255, 230, 204));  // Color crema

        descripcionLabel = new JLabel(hamburguesa.getDescripcion());
        descripcionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        descripcionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        costoLabel = new JLabel("Costo: $" + hamburguesa.getCosto());
        costoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        costoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Botones para agregar extras
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));  // 3 botones para extras + 1 botón finalizar
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(new Color(255, 204, 153));  // Color naranja suave

        JButton quesoButton = new JButton("Agregar Queso");
        quesoButton.setBackground(new Color(255, 255, 204));  // Color amarillo claro
        quesoButton.setFont(new Font("Arial", Font.PLAIN, 16));
        quesoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hamburguesa = new Queso(hamburguesa);
                extrasCount++;
                actualizarVista();
            }
        });

        JButton tocinoButton = new JButton("Agregar Tocino");
        tocinoButton.setBackground(new Color(255, 255, 204));
        tocinoButton.setFont(new Font("Arial", Font.PLAIN, 16));
        tocinoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hamburguesa = new Tocino(hamburguesa);
                extrasCount++;
                actualizarVista();
            }
        });

        JButton salsaButton = new JButton("Agregar Salsa");
        salsaButton.setBackground(new Color(255, 255, 204));
        salsaButton.setFont(new Font("Arial", Font.PLAIN, 16));
        salsaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hamburguesa = new Salsa(hamburguesa);
                extrasCount++;
                actualizarVista();
            }
        });

        // Botón "Finalizar Compra"
        JButton finalizarCompraButton = new JButton("Finalizar Compra");
        finalizarCompraButton.setBackground(new Color(255, 102, 102));  // Color rojo claro
        finalizarCompraButton.setFont(new Font("Arial", Font.BOLD, 16));
        finalizarCompraButton.setForeground(Color.WHITE);
        finalizarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarResumenCompra();
            }
        });

        buttonPanel.add(quesoButton);
        buttonPanel.add(tocinoButton);
        buttonPanel.add(salsaButton);
        buttonPanel.add(finalizarCompraButton);

        // Añadir los paneles a la ventana principal
        centralPanel.add(descripcionLabel);
        centralPanel.add(Box.createRigidArea(new Dimension(0, 20)));  // Espacio entre la descripción y el costo
        centralPanel.add(costoLabel);
        centralPanel.add(Box.createRigidArea(new Dimension(0, 30)));  // Espacio antes de los botones

        add(centralPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Método para actualizar la descripción y el costo de la hamburguesa
    private void actualizarVista() {
        descripcionLabel.setText(hamburguesa.getDescripcion());
        costoLabel.setText("Costo: $" + hamburguesa.getCosto());
    }

    // Método para mostrar el resumen de la compra
    private void mostrarResumenCompra() {
        String mensaje = "Resumen de la compra:\n\n" +
                "Hamburguesa: " + hamburguesa.getDescripcion() + "\n" +
                "Número de extras: " + extrasCount + "\n" +
                "Costo total: $" + hamburguesa.getCosto();

        JOptionPane.showMessageDialog(this, mensaje, "Resumen de Compra", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HamburguesaGUI().setVisible(true);
            }
        });
    }
}


