import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File fileImg = new File("Image/Input/gambar.jpg");
        File imgWaterMark = new File("Image/Input/watermark.jpg");

        ImageProcecing imgProg = new ImageProcecing();

        try {
            BufferedImage img = ImageIO.read(fileImg);
            BufferedImage imgWR = ImageIO.read(imgWaterMark);

            BufferedImage hasil = imgProg.watermarking(img, imgWR);

            File urlHasil = new File("Image/Output/gambar.jpg");
            ImageIO.write(hasil, "jpg", urlHasil);

            BufferedImage extrak = imgProg.extractWatermark(hasil, imgWR);

            File urlExtra = new File("Image/Output/extrak.jpg");
            ImageIO.write(extrak, "jpg", urlExtra);

        } catch (IOException e) {
            System.out.println(" EROR : -=> " + e.getMessage());
        }
    }
}