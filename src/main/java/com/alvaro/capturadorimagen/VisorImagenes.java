/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvaro.capturadorimagen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class VisorImagenes extends JFrame {

    private ArrayList<String> listaImagenes;
    private int indiceActual;
    private JLabel imagenActual;
    private JPanel panelBotones;
    private String rutaDestino;

    public VisorImagenes(ArrayList<String> listaImagenes, String rutaDestino) {
        this.listaImagenes = listaImagenes;
        this.indiceActual = 0;
        this.rutaDestino = rutaDestino;

        initComponents();
        mostrarImagenActual();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Visor de Imágenes");
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximizar el JFrame al tamaño de la pantalla
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        imagenActual = new JLabel();
        imagenActual.setHorizontalAlignment(SwingConstants.CENTER);  // Centrar la imagen horizontalmente
        imagenActual.setVerticalAlignment(SwingConstants.CENTER);    // Centrar la imagen verticalmente
        add(imagenActual, BorderLayout.CENTER);

        JButton btnAnterior = new JButton("Anterior");
        btnAnterior.setPreferredSize(new Dimension(100, 40));
        btnAnterior.addActionListener(e -> mostrarImagenAnterior());

        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setPreferredSize(new Dimension(100, 40));
        btnSiguiente.addActionListener(e -> mostrarImagenSiguiente());

        panelBotones = new JPanel();
        panelBotones.add(btnAnterior);
        panelBotones.add(btnSiguiente);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setPreferredSize(new Dimension(100, 40));
        btnGuardar.addActionListener(e -> guardarImagenActual());
        panelBotones.add(btnGuardar);

        // Botón "Volver"
        JButton btnVolver = new JButton("Volver");
        btnVolver.setPreferredSize(new Dimension(100, 40));
        btnVolver.addActionListener(e -> cerrarVisor());
        panelBotones.add(btnVolver);

        add(panelBotones, BorderLayout.SOUTH);
    }

    private void guardarImagenActual() {
        if (listaImagenes.size() > 0 && indiceActual >= 0 && indiceActual < listaImagenes.size()) {
            try {
                String rutaImagenActual = listaImagenes.get(indiceActual);
                File imagenActual = new File(rutaImagenActual);

                // Nueva ruta de guardado
                String nuevaRuta = rutaDestino;

                // Crear un nuevo nombre de archivo para la imagen en la nueva ruta
                String nombreOriginal = imagenActual.getName();
                String nuevoNombre = "ImagenGuardadaDesdeVisor_" + System.currentTimeMillis() + "_" + nombreOriginal;
                File fileToSave = new File(nuevaRuta, nuevoNombre);

                // Copiar la imagen actual a la nueva ubicación
                Files.copy(imagenActual.toPath(), fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "Imagen guardada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }

    void mostrarImagenActual() {
        if (listaImagenes.size() > 0 && indiceActual >= 0 && indiceActual < listaImagenes.size()) {
            String rutaImagen = listaImagenes.get(indiceActual);
            ImageIcon icono = new ImageIcon(rutaImagen);

            // Obtener las dimensiones del componente imagenActual
            int ancho = imagenActual.getWidth();
            int alto = imagenActual.getHeight();

            // Verificar que las dimensiones son válidas (mayores que cero)
            if (ancho > 0 && alto > 0) {
                Image imagen = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
                ImageIcon iconoEscalado = new ImageIcon(imagen);
                imagenActual.setIcon(iconoEscalado);
                pack();
            }
        }
    }

    private void mostrarImagenAnterior() {
        if (indiceActual > 0) {
            indiceActual--;
            mostrarImagenActual();
        }
    }

    private void mostrarImagenSiguiente() {
        if (indiceActual < listaImagenes.size() - 1) {
            indiceActual++;
            mostrarImagenActual();
        }
    }

    private void cerrarVisor() {
        this.dispose();  // Cierra el JFrame actual
    }
}
