/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvaro.capturadorimagen;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.ds.buildin.WebcamDefaultDriver;

public class ResolucionCamara {

    public static void main(String[] args) {
        // Inicializar el controlador predeterminado de la cámara
        Webcam.setDriver(new WebcamDefaultDriver());

        // Obtener la cámara web predeterminada
        Webcam webcam = Webcam.getDefault();

        // Obtener las resoluciones admitidas por la cámara
        for (java.awt.Dimension resolution : webcam.getViewSizes()) {
            System.out.println(resolution);
        }
    }
}
