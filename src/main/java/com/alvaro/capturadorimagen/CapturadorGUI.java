/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.alvaro.capturadorimagen;

import com.github.sarxos.webcam.Webcam;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author aasll
 */
public class CapturadorGUI extends javax.swing.JFrame {

    Webcam webcam;
    Boolean isRunning = false;
    private int imageCounter = 1;
    private ArrayList<JCheckBox> listaCheckBox = new ArrayList<JCheckBox>();

    /**
     * Creates new form CapturadorGUI
     */
    public CapturadorGUI() {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);

        Dimension[] customResolutions = new Dimension[]{
            new Dimension(940, 600)
        };
        webcam = Webcam.getDefault();
        webcam.setCustomViewSizes(customResolutions);
        webcam.setViewSize(new Dimension(940, 600));
        webcam.open();
        panelImagenes.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Agregar un WindowListener al JFrame para manejar el evento de cierre
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Llamar al método para eliminar las imágenes al cerrar la ventana
                eliminarImagenes();
            }
        });
        scrollPaneImage.getVerticalScrollBar().setUnitIncrement(16);  // Puedes ajustar el valor según tu preferencia

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIniciar = new javax.swing.JButton();
        btnDetener = new javax.swing.JButton();
        btnCapturar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        scrollPaneImage = new javax.swing.JScrollPane();
        panelImagenes = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        imageHolder = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnAbrirImagenes = new javax.swing.JButton();
        btnAgrandar = new javax.swing.JButton();
        btnGuardarTodo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setSize(new java.awt.Dimension(1366, 768));

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnDetener.setText("Detener");
        btnDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetenerActionPerformed(evt);
            }
        });

        btnCapturar.setText("Capturar");
        btnCapturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapturarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        scrollPaneImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPaneImage.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneImage.setAutoscrolls(true);

        javax.swing.GroupLayout panelImagenesLayout = new javax.swing.GroupLayout(panelImagenes);
        panelImagenes.setLayout(panelImagenesLayout);
        panelImagenesLayout.setHorizontalGroup(
            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );
        panelImagenesLayout.setVerticalGroup(
            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        scrollPaneImage.setViewportView(panelImagenes);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageHolder, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageHolder, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAbrirImagenes.setText("Abrir Imagenes");
        btnAbrirImagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirImagenesActionPerformed(evt);
            }
        });

        btnAgrandar.setText("Agrandar");
        btnAgrandar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgrandarActionPerformed(evt);
            }
        });

        btnGuardarTodo.setText("Guardar Todo");
        btnGuardarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(scrollPaneImage, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgrandar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAbrirImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGuardarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDetener, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(259, 259, 259)
                                .addComponent(btnCapturar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPaneImage, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgrandar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbrirImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapturar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDetener, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        if (isRunning) {
            isRunning = false;
            webcam.close();
        }

        // Iniciar la cámara nuevamente
        webcam.open();

        // Iniciar el hilo para tomar el video
        if (!isRunning) {
            isRunning = true;
            new VideoFeedTaker().start();
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetenerActionPerformed
        // TODO add your handling code here:
        isRunning = false;
        webcam.close();
        imageHolder.setIcon(null);
    }//GEN-LAST:event_btnDetenerActionPerformed

    private void btnCapturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturarActionPerformed
        // TODO add your handling code here:
        try {
            // Ubicación y nombre de archivo predeterminados
            String fileName = "img" + imageCounter + ".png";
            File fileToSave = new File("C:\\Users\\aasll\\Desktop\\ProyectoColposcopia\\CapturadorImagen\\src\\thumbnails", fileName);

            Image image = webcam.getImage();

            // Obtener el ancho del panel donde se insertan las imágenes
            int panelWidth = panelImagenes.getWidth();

            // Establecer una altura fija para las miniaturas
            int thumbnailHeight = 200; // Puedes ajustar esta altura según tus necesidades

            // Calcular el ancho proporcional para mantener la relación de aspecto
            int thumbnailWidth = (int) (image.getWidth(null) * ((double) thumbnailHeight / image.getHeight(null)));

            // Si el ancho calculado es mayor que el ancho del panel, ajustarlo al ancho del panel
            if (thumbnailWidth > panelWidth) {
                thumbnailWidth = panelWidth;
                thumbnailHeight = (int) (image.getHeight(null) * ((double) thumbnailWidth / image.getWidth(null)));
            }

            // Crear una miniatura de la imagen con el ancho y altura calculados
            ImageIcon thumbnail = new ImageIcon(image.getScaledInstance(thumbnailWidth, thumbnailHeight, Image.SCALE_SMOOTH));

            ImageIO.write((BufferedImage) image, "PNG", fileToSave);

            // Crear un JLabel para la miniatura
            JLabel thumbnailLabel = new JLabel(thumbnail);

            // Crear un JCheckBox para la miniatura
            JCheckBox checkBox = new JCheckBox();
            checkBox.addActionListener((ActionEvent e) -> {
                // Manejar el evento de selección/deselección del JCheckBox aquí
                if (checkBox.isSelected()) {
                    thumbnailLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    thumbnailLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
            });

            // Agregar un MouseListener a la miniatura para manejar clics
            thumbnailLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    checkBox.setSelected(!checkBox.isSelected());
                    if (checkBox.isSelected()) {
                        thumbnailLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
                    } else {
                        thumbnailLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    }
                }
            });

            // Configurar el JPanel con BoxLayout y alineación vertical (solo si no se ha configurado antes)
            if (!(panelImagenes.getLayout() instanceof BoxLayout)) {
                panelImagenes.setLayout(new BoxLayout(panelImagenes, BoxLayout.Y_AXIS));
            }

            // Crear un JPanel para la imagen capturada
            JPanel imagePanel = new JPanel();

            // Agregar el JCheckBox y el JLabel al JPanel
            imagePanel.add(checkBox);
            imagePanel.add(thumbnailLabel);

            // Configurar el JPanel con BoxLayout y alineación vertical (solo si no se ha configurado antes)
            if (!(panelImagenes.getLayout() instanceof BoxLayout)) {
                panelImagenes.setLayout(new BoxLayout(panelImagenes, BoxLayout.Y_AXIS));
            }

            // Verificar si el checkbox está seleccionado (imagen guardada)
            if (checkBox.isSelected()) {
                // Añadir un texto indicando que ya está guardado
                JLabel savedLabel = new JLabel("Ya Guardado");
                savedLabel.setForeground(Color.GREEN);  // Color del texto
                imagePanel.add(savedLabel);

                // Desactivar el checkbox ya que la imagen está guardada
                checkBox.setEnabled(false);
                // Cambiar el borde del JLabel a verde
                thumbnailLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
            }

            // Agregar al inicio si es una nueva imagen
            panelImagenes.add(imagePanel, 0);

            // Repintar el panelImagenes para reflejar los cambios
            panelImagenes.revalidate();
            panelImagenes.repaint();

            listaCheckBox.add(checkBox);

            // Incrementar el contador para la próxima imagen
            imageCounter++;
        } catch (IOException ex) {
            Logger.getLogger(CapturadorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCapturarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        try {
            // Obtener la fecha actual en el formato "yy-MM-dd"
            SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
            String fechaActual = dateFormat.format(new Date());

            // Nueva ruta de guardado con la fecha actual
            String nuevaRuta = "C:\\Users\\aasll\\Desktop\\ProyectoColposcopia\\CapturadorImagen\\src\\img\\" + fechaActual;

            boolean alMenosUnaSeleccionada = false; // Variable para rastrear si al menos una imagen está seleccionada

            // Crear la carpeta de destino si no existe
            File carpetaDestino = new File(nuevaRuta);
            if (!carpetaDestino.exists()) {
                carpetaDestino.mkdirs();  // Crea la carpeta y sus directorios padres si no existen
            }

            // Iterar a través de las imágenes capturadas
            for (int i = 0; i < listaCheckBox.size(); i++) {
                // Obtener la ruta de la imagen original
                String originalImagePath = "C:\\Users\\aasll\\Desktop\\ProyectoColposcopia\\CapturadorImagen\\src\\thumbnails\\img" + (i + 1) + ".png";

                // Obtener el JCheckBox asociado a la imagen
                JCheckBox checkBox = listaCheckBox.get(i);

                // Si el JCheckBox está marcado y no está deshabilitado, copiar la imagen a la nueva ubicación
                if (checkBox.isSelected() && checkBox.isEnabled()) {
                    // Obtener un identificador único basado en el nombre original y el timestamp
                    String originalImageName = "ImagenGuardada" + (i + 1);
                    String hash = sha256(originalImageName + System.currentTimeMillis()).substring(0, 8); // Truncar a 8 caracteres

                    // Generar el nombre de archivo único
                    String fileName = "img-gineco" + hash + ".png";
                    File fileToSave = new File(nuevaRuta, fileName);

                    // Verificar si la imagen ya está guardada
                    if (!fileToSave.exists()) {
                        // Copiar la imagen a la nueva ubicación
                        if (copyImage(originalImagePath, fileToSave)) {
                            alMenosUnaSeleccionada = true;

                            // Cambiar el borde a verde y deshabilitar permanentemente el JCheckBox
                            checkBox.setEnabled(false);
                            // Obtener el JPanel que contiene el JLabel y el JCheckBox
                            JPanel imagePanel = (JPanel) checkBox.getParent();
                            // Obtener el JLabel del JPanel
                            JLabel thumbnailLabel = (JLabel) imagePanel.getComponent(1);
                            // Cambiar el borde del JLabel a verde
                            thumbnailLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN));

                            // Desmarcar el JCheckBox 
                            checkBox.setSelected(false);

                            // Quitar el JPanel del panel de imágenes
                            panelImagenes.remove(imagePanel);

                            // Repintar el panelImagenes para reflejar los cambios
                            panelImagenes.revalidate();
                            panelImagenes.repaint();

                            // Agregar un MouseListener para que ya no se pueda volver a marcar
                            thumbnailLabel.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    // Desactivar el listener del mouse para esta miniatura específica
                                    thumbnailLabel.removeMouseListener(this);

                                    checkBox.setSelected(!checkBox.isSelected());
                                    if (checkBox.isSelected()) {
                                        thumbnailLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
                                    } else {
                                        thumbnailLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                                    }
                                }
                            });
                        }
                    } else {
                        // Si la imagen ya existe, mostrar un mensaje de advertencia
                        JOptionPane.showMessageDialog(this, "Estás intentando guardar una imagen que ya existe.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }

            if (!alMenosUnaSeleccionada) {
                JOptionPane.showMessageDialog(this, "Por favor, marque las imágenes que quiere guardar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Imágenes guardadas con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (IOException ex) {
            Logger.getLogger(CapturadorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAbrirImagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirImagenesActionPerformed
        // TODO add your handling code here:
        String rutaCarpeta = "C:\\Users\\aasll\\Desktop\\ProyectoColposcopia\\CapturadorImagen\\src\\img";
        abrirCarpeta(rutaCarpeta);
    }//GEN-LAST:event_btnAbrirImagenesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        eliminarImagenes();
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgrandarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgrandarActionPerformed
        // TODO add your handling code here:
        // Crear una instancia de VisorImagenes y pasar la lista de rutas de imágenes
        // Obtener la fecha actual en el formato "yy-MM-dd"
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
        String fechaActual = dateFormat.format(new Date());

        // Crear una instancia de VisorImagenes y pasar la lista de rutas de imágenes y la ruta de destino
        VisorImagenes visor = new VisorImagenes(obtenerRutasImagenes(), "C:\\Users\\aasll\\Desktop\\ProyectoColposcopia\\CapturadorImagen\\src\\img\\" + fechaActual);
        visor.setVisible(true);
    }//GEN-LAST:event_btnAgrandarActionPerformed

    private void btnGuardarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTodoActionPerformed
        // TODO add your handling code here:
        try {
            String nuevaRuta = "C:\\Users\\aasll\\Desktop\\ProyectoColposcopia\\CapturadorImagen\\src\\img";

            boolean alMenosUnaSeleccionada = false;

            for (int i = 0; i < listaCheckBox.size(); i++) { // Iterar a través de la lista de JCheckBox
                JCheckBox checkBox = listaCheckBox.get(i);
                if (checkBox.isSelected()) {
                    String fileName = "ImagenGuardada" + (i + 1) + ".png";
                    File fileToSave = new File(nuevaRuta, fileName);

                    if (!fileToSave.exists()) {
                        String originalImagePath = "C:\\Users\\aasll\\Desktop\\ProyectoColposcopia\\CapturadorImagen\\src\\thumbnails\\img" + (i + 1) + ".png";
                        if (copyImage(originalImagePath, fileToSave)) {
                            alMenosUnaSeleccionada = true;
                        }
                    }
                }
            }

            if (!alMenosUnaSeleccionada) {
                JOptionPane.showMessageDialog(this, "Por favor, marque las imágenes que quiere guardar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Imágenes guardadas con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (IOException ex) {
            Logger.getLogger(CapturadorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarTodoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CapturadorGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CapturadorGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CapturadorGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CapturadorGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CapturadorGUI().setVisible(true);
            }
        });

    }

    class VideoFeedTaker extends Thread {

        @Override
        public void run() {
            while (true && isRunning) {
                try {
                    Image image = webcam.getImage();

                    // Verificar si la imagen no es nula antes de crear el ImageIcon
                    if (image != null) {
                        imageHolder.setIcon(new ImageIcon(image));
                    }

                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CapturadorGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // Método para eliminar las imágenes en la carpeta "thumbnails"
    private void eliminarImagenes() {
        String rutaCarpeta = "C:\\Users\\aasll\\Desktop\\ProyectoColposcopia\\CapturadorImagen\\src\\thumbnails";
        File carpeta = new File(rutaCarpeta);

        // Verificar si la carpeta existe
        if (carpeta.exists() && carpeta.isDirectory()) {
            // Obtener la lista de archivos en la carpeta
            File[] archivos = carpeta.listFiles();

            // Eliminar cada archivo en la carpeta
            if (archivos != null) {
                for (File archivo : archivos) {
                    archivo.delete();
                }
            }
        }
    }
    // Método para abrir una carpeta en el explorador de archivos

    private void abrirCarpeta(String rutaCarpeta) {
        try {
            File carpeta = new File(rutaCarpeta);

            // Verificar si la carpeta existe
            if (carpeta.exists() && carpeta.isDirectory()) {
                Desktop.getDesktop().open(carpeta);
            } else {
                JOptionPane.showMessageDialog(this, "La carpeta no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al abrir la carpeta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Método para copiar una imagen de una ubicación a otra

    private boolean copyImage(String sourcePath, File destinationFile) throws IOException {
        File sourceFile = new File(sourcePath);

        // Verificar si la imagen original existe
        if (sourceFile.exists()) {
            // Copiar la imagen
            Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "La imagen original no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Método para obtener las rutas de imágenes capturadas
    private ArrayList<String> obtenerRutasImagenes() {
        ArrayList<String> rutasImagenes = new ArrayList<>();
        for (int i = 1; i < imageCounter; i++) {
            String rutaImagen = "C:\\Users\\aasll\\Desktop\\ProyectoColposcopia\\CapturadorImagen\\src\\thumbnails\\img" + i + ".png";
            rutasImagenes.add(rutaImagen);
        }
        return rutasImagenes;
    }
// Función para obtener el hash SHA-256 de una cadena

    private static String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Convertir el hash a una representación hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CapturadorGUI.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirImagenes;
    private javax.swing.JButton btnAgrandar;
    private javax.swing.JButton btnCapturar;
    private javax.swing.JButton btnDetener;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarTodo;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel imageHolder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelImagenes;
    private javax.swing.JScrollPane scrollPaneImage;
    // End of variables declaration//GEN-END:variables
}
