package Percobaan;

import java.awt.*;
import java.awt.geom.AffineTransform;
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

                    int red = mainRed ^ (watermarkRed > 128 ? 1 : 0);
                    int blue = mainBlue ^ (watermarkBlue > 128 ? 1 : 0);
                    int green = mainGreen ^ (watermarkGreen > 128 ? 1 : 0);

                    Color newColor = new Color(red, green, blue);

                    mainImg.setRGB(x, y, newColor.getRGB());
                }
            }
        }

        return mainImg;
    }

    public BufferedImage extractWatermark(BufferedImage mainImage, BufferedImage watermarkImage) {
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

                    System.out.println("1.\t Red" + watermarkRed + " Green" + watermarkGreen + " Blue" + watermarkBlue);

                    int red1 = watermarkRed ^ (mainRed > 128 ? 1 : 0);
                    int blue2 = watermarkBlue ^ (mainBlue > 128 ? 1 : 0);
                    int green3 = watermarkGreen ^ (mainGreen > 128 ? 1 : 0);
                    System.out.println("2.\t Red" + red1 + " Green" + green3 + " Blue" + blue2);

                    Color newColor = new Color(red1, green3, blue2);

                    mainImg.setRGB(x, y, newColor.getRGB());
                }
            }
        }

        return mainImg;
    }

    public BufferedImage extractImage(BufferedImage mainImage, BufferedImage watermarkImage) {
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

                    int red1 = watermarkRed ^ (mainRed > 128 ? 1 : 0);
                    int blue2 = watermarkBlue ^ (mainBlue > 128 ? 1 : 0);
                    int green3 = watermarkGreen ^ (mainGreen > 128 ? 1 : 0);

                    Color newColor = new Color(red1, green3, blue2);

                    mainImg.setRGB(x, y, newColor.getRGB());
                }
            }
        }

        return mainImg;
    }

    public BufferedImage resize(BufferedImage img) {
        BufferedImage resizedImg = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImg.createGraphics();
        double scaleX = 600.0 / img.getWidth();
        double scaleY = 600.0 / img.getHeight();
        AffineTransform at = AffineTransform.getScaleInstance(scaleX, scaleY);
        g.drawRenderedImage(img, at);
        g.dispose();
        return resizedImg;
    }

}
