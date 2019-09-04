package com.tao.leanrn.demo.qrcode.local;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.UUID;

/**
 * @ClassName Qrcode
 * @Descriiption 创建二维码
 * @Author yanjiantao
 * @Date 2019/8/28 8:50
 **/
@Slf4j
public class Qrcode {
    public static void main(String[] args) {
        log.info("开始创建二维码");
//        createQrCode(300, 300, "https://blog.booleandev.xyz");
        createLogoQrCode(600, 600, "https://blog.booleandev.xyz");
        log.info("二维码创建完成");
    }

    /**
     * 创建二维码
     * @param width 宽度
     * @param height    高度
     * @param content   文本
     */
    public static void createQrCode(int width, int height, String content) {

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

            // 2.3、执行生成二维码
            MatrixToImageWriter.writeToPath(bitMatrix, "png", codePath);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void createLogoQrCode(int width, int height, String content) {

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
            File qrFile = new File("d:/qrcode", UUID.randomUUID() + ".jpg");

            // logoFile用来存放带有logo的二维码图片
            File logoFile = new File("d:/qrcode", "head.jpg");

            // 2.3、执行生成二维码
            MatrixToImageWriter.writeToPath(bitMatrix, "jpg", qrFile.toPath());

            // 2.4在二维码中添加logo
            LogoConfig logoConfig = new LogoConfig();
            addLogo(qrFile, logoFile, logoConfig);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 二维码添加logo
     * @param qrPic 二维码链接
     * @param logoPic   logo链接
     * @param logoConfig    logo配置
     */
    private static void addLogo(File qrPic, File logoPic, LogoConfig logoConfig) {

        if (!qrPic.isFile() || !logoPic.isFile()) {
            System.out.println("file not found!");
            System.exit(0);
        }

        try {

            // 1、读取二维码图片，并构建绘图对象
            BufferedImage image = ImageIO.read(qrPic);
            Graphics2D graph = image.createGraphics();

            // 2、读取logo图片
            BufferedImage logo = ImageIO.read(logoPic);

            int widthLogo = image.getWidth() / logoConfig.getLogoPart();
            int heightLogo = image.getHeight() / logoConfig.getLogoPart();

            // 3、计算图片放置的位置
            int x = (image.getWidth() - widthLogo) / 2;
            int y = (image.getHeight() - heightLogo) / 2;

            // 4、绘制图片
            graph.drawImage(logo, x, y, widthLogo, heightLogo, null);
            graph.drawRoundRect(x, y, widthLogo, heightLogo, 10, 10);
            graph.setStroke(new BasicStroke(logoConfig.getBorder()));
            graph.setColor(logoConfig.getBorderColor());
            graph.drawRect(x, y, widthLogo, heightLogo);

            graph.dispose();

            ImageIO.write(image, "jpeg", new File("d:/qrcode/newPic.jpg"));

        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
