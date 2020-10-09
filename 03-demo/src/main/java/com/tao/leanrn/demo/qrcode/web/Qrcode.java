package com.tao.leanrn.demo.qrcode.web;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tao.leanrn.demo.qrcode.local.LogoConfig;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.UUID;

/**
 * @ClassName Qrcode
 * @Descriiption 二维码
 * @Author yanjiantao
 * @Date 2019/8/28 9:13
 **/
@Service
public class Qrcode {


    /**
     * 创建二维码
     * @param width 宽度
     * @param height    高度
     * @param content   文本
     */
    public void createQrCode(int width, int height, String content, HttpServletResponse httpServletResponse) {

        // 1、设置二维码的一些参数
        HashMap hints = new HashMap(16);

        // 1.1设置字符集
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

        // 1.2设置容错等级；因为有了容错，在一定范围内可以把二维码p成你喜欢的样式
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);

        // 1.3设置外边距;(即白色区域)
        hints.put(EncodeHintType.MARGIN, 1);

        // 2、生成二维码

        try {
            // 2.1定义BitMatrix对象
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

            // 2.2、设置二维码存放路径,以及二维码的名字
            Path codePath = new File("d:/qrcode/" + UUID.randomUUID() + ".png").toPath();

            httpServletResponse.setContentType("image/png");
            OutputStream os = httpServletResponse.getOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "png", os);
            os.flush();
            os.close();

            // 2.3、执行生成二维码
//            MatrixToImageWriter.writeToPath(bitMatrix, "png", codePath);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void createLogoQrCode(int width, int height, String content, HttpServletResponse httpServletResponse) {

        // 1、设置二维码的一些参数
        HashMap hints = new HashMap();

        // 1.1设置字符集
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

        // 1.2设置容错等级；因为有了容错，在一定范围内可以把二维码p成你喜欢的样式
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

        // 1.3设置外边距;(即白色区域)
        hints.put(EncodeHintType.MARGIN, 1);

        // 2、生成二维码

        try {
            // 2.1定义BitMatrix对象
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

            // 2.2、设置二维码存放路径,以及二维码的名字

            // qrFile用来存放生成的二维码图片
//            File qrFile = new File("d:/qrcode", UUID.randomUUID() + ".jpg");

            // logoFile用来存放带有logo的二维码图片
//            File logoFile = new File("d:/qrcode", "head.jpg");

            // 2.3、执行生成二维码
//            MatrixToImageWriter.writeToPath(bitMatrix, "jpeg", qrFile.toPath());
//            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            BufferedImage bufferedImage = toBufferedImage(bitMatrix);

            // 2.4在二维码中添加logo
            LogoConfig logoConfig = new LogoConfig();
            addLogo(bufferedImage, logoConfig, httpServletResponse);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 二维码添加logo
     * @param logoConfig    logo配置
     */
    private void addLogo(BufferedImage image, LogoConfig logoConfig, HttpServletResponse response) {

        /*if (!qrPic.isFile() || !logoPic.isFile()) {
            System.out.println("file not found!");
            System.exit(0);
        }*/

        try {

            // 1、读取二维码图片，并构建绘图对象
//            BufferedImage image = ImageIO.read(qrPic);
            Graphics2D graph = image.createGraphics();

            URL url = new URL("https://boolean-dev.oss-cn-hangzhou.aliyuncs.com/head.jpg");
//            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setConnectTimeout(5 * 1000);
//            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据

            // 2、读取logo图片
            BufferedImage logo = ImageIO.read(url);

            int widthLogo = image.getWidth() / logoConfig.getLogoPart();
            int heightLogo = image.getHeight() / logoConfig.getLogoPart();

            // 3、计算图片放置的位置
            int x = (image.getWidth() - widthLogo) / 2;
            int y = (image.getHeight() - heightLogo) / 2;

            // 4、绘制图片
            boolean aa = graph.drawImage(logo.getScaledInstance(widthLogo, heightLogo, Image.SCALE_SMOOTH), x, y,null);
//            graph.drawImage(logo, x, y, widthLogo, heightLogo, null);
            graph.drawRoundRect(x, y, widthLogo, heightLogo, 10, 10);
            graph.setStroke(new BasicStroke(logoConfig.getBorder()));
            graph.setColor(logoConfig.getBorderColor());
            graph.drawRect(x, y, widthLogo, heightLogo);

            graph.dispose();

            response.setContentType("image/JPEG");
            OutputStream os = response.getOutputStream();
            ImageIO.write(image,"JPEG",os);
            os.flush();
            os.close();

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void getLogo(HttpServletResponse response) throws IOException, WriterException {



        // 1、设置二维码的一些参数
        HashMap hints = new HashMap();

        // 1.1设置字符集
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

        // 1.2设置容错等级；因为有了容错，在一定范围内可以把二维码p成你喜欢的样式
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

        // 1.3设置外边距;(即白色区域)
        hints.put(EncodeHintType.MARGIN, 1);

        // 2、生成二维码

            // 2.1定义BitMatrix对象
        BitMatrix bitMatrix = new MultiFormatWriter().encode("2431214", BarcodeFormat.QR_CODE, 600, 600, hints);

        // 2.2、设置二维码存放路径,以及二维码的名字

        // qrFile用来存放生成的二维码图片
//            File qrFile = new File("d:/qrcode", UUID.randomUUID() + ".jpg");

        // logoFile用来存放带有logo的二维码图片
//            File logoFile = new File("d:/qrcode", "head.jpg");

        // 2.3、执行生成二维码
//            MatrixToImageWriter.writeToPath(bitMatrix, "jpeg", qrFile.toPath());
        BufferedImage bufferedImage = toBufferedImage(bitMatrix);

        URL url = new URL("https://boolean-dev.oss-cn-hangzhou.aliyuncs.com/head.jpg");
        BufferedImage logo = ImageIO.read(url);

        BufferedImage  bi = new BufferedImage(600,600,5);
//        Graphics2D graph = bi.createGraphics();

        Graphics2D graph = bufferedImage.createGraphics();

        int widthLogo = 60;
        int heightLogo = 60;

        // 3、计算图片放置的位置
        int x = (bi.getWidth() - widthLogo) / 2;
        int y = (bi.getHeight() - heightLogo) / 2;

        graph.drawImage(logo, x, y, widthLogo, heightLogo, null);
        graph.drawRoundRect(x, y, widthLogo, heightLogo, 10, 10);
        graph.setStroke(new BasicStroke(6));
        graph.setColor(Color.WHITE);
        graph.drawRect(x, y, widthLogo, heightLogo);

        graph.dispose();

        response.setContentType("image/JPEG");
        OutputStream os = response.getOutputStream();
        ImageIO.write(bufferedImage,"JPEG",os);
        os.flush();
        os.close();
    }


    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        MatrixToImageConfig config = new MatrixToImageConfig();
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int onColor = config.getPixelOnColor();
        int offColor = config.getPixelOffColor();
        int[] rowPixels = new int[width];
        BitArray row = new BitArray(width);
        for (int y = 0; y < height; y++) {
            row = matrix.getRow(y, row);
            for (int x = 0; x < width; x++) {
                rowPixels[x] = row.get(x) ? onColor : offColor;
            }
            image.setRGB(0, y, width, 1, rowPixels, 0, width);
        }
        return image;
    }
}
