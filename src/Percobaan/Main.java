package Percobaan;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File fileImg = new File("Image/Percobaan/Input/gambar.jpg");
        File imgWaterMark = new File("Image/Percobaan/Input/watermark.jpg");

        int heightIMG = 0;
        int widthIMG = 0;

        int heightWR = 0;
        int widthWR = 0;

        ImageProcecing imgProg = new ImageProcecing();

        try {
            BufferedImage img = ImageIO.read(fileImg);
            BufferedImage imgWR = ImageIO.read(imgWaterMark);

            heightIMG = img.getHeight();
            widthIMG = img.getWidth();

            heightWR = imgWR.getHeight();
            widthWR = imgWR.getWidth();

            BufferedImage hasil = imgProg.watermarking(img, imgWR);

            File urlHasil = new File("Image/Percobaan/Output/gambar.jpg");
            ImageIO.write(hasil, "jpg", urlHasil);

            BufferedImage hasil2 = imgProg.extractWatermark(hasil,imgWR);

            File urlHasilEx = new File("Image/Percobaan/Output/extrak.jpg");
            ImageIO.write(hasil2, "jpg", urlHasilEx);

            BufferedImage hasil3 = imgProg.extractImage(hasil2,img);
            
            File urlHasilimg = new File("Image/Percobaan/Output/extrak2.jpg");
            ImageIO.write(hasil3, "jpg", urlHasilimg);

        } catch (IOException e) {
            System.out.println(" EROR : -=> " + e.getMessage());
        }
    }
}

// Image/Hasil/exktarksi.jpg