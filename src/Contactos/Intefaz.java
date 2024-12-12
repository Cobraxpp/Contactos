package Contactos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Intefaz extends JFrame {

    private JButton buscar;
    private JButton insertar;
    private JButton actualizar;
    private JButton eliminar;
    private JButton salir;

    private JTextField nombre;
    private JTextField telefono;
    private JTextArea textArea;

    private ArrayList<Contacto> contactos;

    public Intefaz() {

        setTitle("Gestión de Contactos");
        setSize(1000, 500); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); 

        contactos = new ArrayList<>();
        
       
        Componentes();
    }

    private void Componentes() {

       
        JLabel labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(50, 30, 100, 30);
        add(labelNombre);
        
        nombre = new JTextField(20);
        nombre.setBounds(150, 30, 200, 30);
        add(nombre);

        JLabel labelTelefono = new JLabel("Teléfono:");
        labelTelefono.setBounds(50, 80, 100, 30);
        add(labelTelefono);

        telefono = new JTextField(20);
        telefono.setBounds(150, 80, 200, 30);
        add(telefono);

      
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(400, 30, 550, 300);
        add(scrollPane);

       
        buscar = new JButton("Buscar por número de teléfono");
        buscar.setBounds(50, 150, 200, 40);
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarContacto();
            }
        });
        add(buscar);

        insertar = new JButton("Insertar contacto nuevo");
        insertar.setBounds(50, 200, 200, 40);
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarContacto();
            }
        });
        add(insertar);

        actualizar = new JButton("Actualizar contacto existente");
        actualizar.setBounds(50, 250, 200, 40);
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarContacto();
            }
        });
        add(actualizar);

        eliminar = new JButton("Eliminar contacto");
        eliminar.setBounds(50, 300, 200, 40);
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarContacto();
            }
        });
        add(eliminar);

        salir = new JButton("Salir");
        salir.setBounds(50, 350, 200, 40);
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(salir);

       
        
    }

    private void buscarContacto() {
        String phone = telefono.getText();
        Contacto found = null;
        for (Contacto c : contactos) {
            if (c.getPhone().equals(phone)) {
                found = c;
                break;
            }
        }
        if (found != null) {
            textArea.setText("Contacto encontrado: \n" + found.toString());
        } else {
            textArea.setText("Contacto no encontrado.");
        }
    }

    private void insertarContacto() {
        String nombreInsert = nombre.getText();
        String telefonoInsert = telefono.getText();
        if (!nombreInsert.isEmpty() && !telefonoInsert.isEmpty()) {
            Contacto nuevo = new Contacto(nombreInsert, telefonoInsert);
            contactos.add(nuevo);
            textArea.setText("Contacto insertado: \n" + nuevo.toString());
        } else {
            textArea.setText("Por favor ingresa un nombre y un teléfono.");
        }
    }

    private void actualizarContacto() {
        String phone = telefono.getText();
        for (Contacto c : contactos) {
            if (c.getPhone().equals(phone)) {
                c.setName(nombre.getText());
                c.setPhone(telefono.getText());
                textArea.setText("Contacto actualizado: \n" + c.toString());
                return;
            }
        }
        textArea.setText("Contacto no encontrado para actualizar.");
    }

    private void eliminarContacto() {
        String phone = telefono.getText();
        for (Contacto c : contactos) {
            if (c.getPhone().equals(phone)) {
                contactos.remove(c);
                textArea.setText("Contacto eliminado: \n" + c.toString());
                return;
            }
        }
        textArea.setText("Contacto no encontrado para eliminar.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Intefaz frame = new Intefaz();
                frame.setVisible(true);
            }
        });
    }
}
