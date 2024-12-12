package Contactos;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	
                InicioSesion login = new InicioSesion();
                login.setVisible(true);
            }
        });
    }
}
