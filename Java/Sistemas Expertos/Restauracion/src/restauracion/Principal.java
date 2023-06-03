/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restauracion;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;




public class Principal {
    public static void main(String args[]){
        System.out.println("Cargar y Mostrar una Imagen con OpenCV en Java y Netbeans");
        System.load("C:\\Users\\Jair Hernandez\\Documents\\Opencv\\opencv\\build\\java\\x64\\opencv_java460.dll");
        Procesar procesar = new Procesar();
        procesar.
   }
    
}
class Procesar{
    URL img_url = getClass().getResource("C:\\Users\\Jair Hernandez\\Documents\\Universidad\\2022-B\\net\\Restauracion\\src\\restauracion\\1.jpg");
    String ruta = img_url.getPath();
    
    public Procesar(){
        Mat imagen;
        imagen = Imgcodecs.imread(ruta);
        if(!imagen.empty()){
            Image imagenMostrar = convertir(imagen);
            int width=imagenMostrar.getWidth(null);
            int height=imagenMostrar.getHeight(null);
            Ventana ventana = new Ventana(imagenMostrar);
            ventana.setSize(width,height);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        }
    }

    private Image convertir(Mat imagen) {
        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".jpg", imagen, matOfByte); 

        byte[] byteArray = matOfByte.toArray();
        BufferedImage bufImage = null;

        try {

            InputStream in = new ByteArrayInputStream(byteArray);
            bufImage = ImageIO.read(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (Image)bufImage;
    }
}    

