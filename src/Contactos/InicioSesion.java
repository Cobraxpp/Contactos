package Contactos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InicioSesion extends JFrame {

    private JTextField username;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton exitButton;

    public InicioSesion() {
        setTitle("Inicio de Sesión");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        componentes ();
    }

    private void componentes () {
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(50, 50, 100, 30);
        add(userLabel);

        username = new JTextField(20);
        username.setBounds(150, 50, 180, 30);
        add(username);

        JLabel passLabel = new JLabel("Contraseña:");
        passLabel.setBounds(50, 100, 100, 30);
        add(passLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(150, 100, 180, 30);
        add(passwordField);

        loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(50, 180, 120, 40);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarCredenciales();
            }
        });
        add(loginButton);

        exitButton = new JButton("Salir");
        exitButton.setBounds(210, 180, 120, 40);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);
    }

    private void validarCredenciales() {
        String usuario = username.getText();
        String contrasena = new String(passwordField.getPassword());

       
        if (usuario.equals("") && contrasena.equals("")) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso.");
            dispose(); 
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Intefaz frame = new Intefaz();
                    frame.setVisible(true);
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

  
}

