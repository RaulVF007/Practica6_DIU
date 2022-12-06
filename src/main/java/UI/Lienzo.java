/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;


/**
 *
 * @author raulv
 */
public class Lienzo extends JPanel{

    private BufferedImage imagen;

    public Lienzo() {
        
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(imagen != null){       
            g.drawImage(imagen, 0, 0, null);   
        }
    }

    public BufferedImage getImagen() {
        return imagen;
    }
    
    public void drawImage(BufferedImage imagen) {
        this.imagen=imagen;
        repaint();
    }

    public Mat umbralizar(Mat imagen_original, Integer umbral) {
        // crear dos imágenes en niveles de gris con el mismo
        // tamaño que la original
        Mat imagenGris = new Mat(imagen_original.rows(),
        imagen_original.cols(),
        CvType.CV_8U);
        Mat imagenUmbralizada = new Mat(imagen_original.rows(),
        imagen_original.cols(),
        CvType.CV_8U);
        // convierte a niveles de grises la imagen original
        Imgproc.cvtColor(imagen_original,
        imagenGris,
        Imgproc.COLOR_BGR2GRAY);
        // umbraliza la imagen:
        // - píxeles con nivel de gris > umbral se ponen a 1
        // - píxeles con nivel de gris <= umbra se ponen a 0
        Imgproc.threshold(imagenGris,
        imagenUmbralizada,
        umbral,
        255,
        Imgproc.THRESH_BINARY);
        // se devuelve la imagen umbralizada  
        return imagenUmbralizada;
    }
}
