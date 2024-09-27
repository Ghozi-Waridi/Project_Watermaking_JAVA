
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageProcecing {

    public BufferedImage watermarking(BufferedImage mainImage, BufferedImage watermarkImage) {

        BufferedImage mainImg = mainImage;
        BufferedImage watrImage = watermarkImage;

        int y = 0;
        int x = 0;
        
        for (y = 0; y < mainImg.getHeight(); y++) {
            for (x = 0; x < mainImg.getWidth(); x++) {

                int watermarkX = x % watrImage.getWidth();
                int watermarkY = y % watrImage.getHeight();

                Color watrmarkColor = new Color(watrImage.getRGB(watermarkX, watermarkY), true);
                Color maincolor = new Color(mainImg.getRGB(x, y), true);

                if (watrmarkColor.getAlpha() > 0) {
                    int mainRed = maincolor.getRed();
                    int mainGreen = maincolor.getGreen();
                    int mainBlue = maincolor.getBlue();

                    int watermarkRed = watrmarkColor.getRed();
                    int watermarkGreen = watrmarkColor.getGreen();
                    int watermarkBlue = watrmarkColor.getBlue();

                    int red = mainRed ^ (watermarkRed % 255);
                    int blue = mainBlue ^ (watermarkBlue % 255);
                    int green = mainGreen ^ (watermarkGreen % 255);

                    Color newColor = new Color(red, green, blue);

                    mainImg.setRGB(x, y, newColor.getRGB());
                }
            }
        }

        return mainImg;
    }

    public BufferedImage extractWatermark(BufferedImage hasil, BufferedImage waterImage) {
        BufferedImage mainImg = hasil;
        BufferedImage watrImage = waterImage;

        int y = 0;
        int x = 0;
        for (y = 0; y < mainImg.getHeight(); y++) {
            for (x = 0; x < mainImg.getWidth(); x++) {

                int watermarkX = x % watrImage.getWidth();
                int watermarkY = y % watrImage.getHeight();

                Color watrmarkColor = new Color(watrImage.getRGB(watermarkX, watermarkY), true);
                Color maincolor = new Color(mainImg.getRGB(x, y), true);

                if (watrmarkColor.getAlpha() > 0) {
                    int mainRed = maincolor.getRed();
                    int mainGreen = maincolor.getGreen();
                    int mainBlue = maincolor.getBlue();

                    int watermarkRed = watrmarkColor.getRed();
                    int watermarkGreen = watrmarkColor.getGreen();
                    int watermarkBlue = watrmarkColor.getBlue();

                    int red = (mainRed % 255) ^ (watermarkRed % 255);
                    int blue = (mainBlue % 255) ^ (watermarkBlue % 255);
                    int green = (mainGreen % 255) ^ (watermarkGreen % 255);

                    Color newColor = new Color(red, green, blue);

                    mainImg.setRGB(x, y, newColor.getRGB());
                }
            }
        }
        return mainImg;
    }
}
