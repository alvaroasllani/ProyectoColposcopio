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
    private JPanel panelBotones;  // Agregar este atributo

    public VisorImagenes(ArrayList<String> listaImagenes) {
        this.listaImagenes = listaImagenes;
        this.indiceActual = 0;

        initComponents();
        mostrarImagenActual();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Visor de Imágenes");
        setSize(800, 600);
        setLayout(new BorderLayout());

        imagenActual = new JLabel();
        add(imagenActual, BorderLayout.CENTER);

        JButton btnAnterior = new JButton("Anterior");
        btnAnterior.addActionListener(e -> mostrarImagenAnterior());
        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.addActionListener(e -> mostrarImagenSiguiente());

        panelBotones = new JPanel();  // Inicializar el panelBotones aquí
        panelBotones.add(btnAnterior);
        panelBotones.add(btnSiguiente);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarImagenActual());
        panelBotones.add(btnGuardar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    private void guardarImagenActual() {
        if (listaImagenes.size() > 0 && indiceActual >= 0 && indiceActual < listaImagenes.size()) {
            try {
                String rutaImagenActual = listaImagenes.get(indiceActual);
                File imagenActual = new File(rutaImagenActual);

                // Nueva ruta de guardado
                String nuevaRuta = "C:\\Users\\aasll\\Desktop\\ProyectoColposcopia\\CapturadorImagen\\src\\img";

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

    private void mostrarImagenActual() {
        if (listaImagenes.size() > 0 && indiceActual >= 0 && indiceActual < listaImagenes.size()) {
            String rutaImagen = listaImagenes.get(indiceActual);
            ImageIcon icono = new ImageIcon(rutaImagen);
            imagenActual.setIcon(icono);
            pack();
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
}
