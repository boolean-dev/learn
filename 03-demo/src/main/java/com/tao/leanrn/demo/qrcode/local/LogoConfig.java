package com.tao.leanrn.demo.qrcode.local;

import java.awt.*;

/**
 * @ClassName LogoConfig
 * @Descriiption logo工具类
 * @Author yanjiantao
 * @Date 2019/8/28 8:57
 **/
public class LogoConfig {

    // logo默认边框颜色
    public static final Color DEFAULT_BORDERCOLOR = Color.WHITE;
    // logo默认边框宽度
    public static final int DEFAULT_BORDER = 5;
    // logo大小默认为照片的1/6
    public static final int DEFAULT_LOGOPART = 6;

    private final int border = DEFAULT_BORDER;
    private final Color borderColor;
    private final int logoPart;

    public LogoConfig() {
        this(DEFAULT_BORDERCOLOR, DEFAULT_LOGOPART);
    }

    public LogoConfig(Color borderColor, int logoPart) {
        this.borderColor = borderColor;
        this.logoPart = logoPart;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public int getBorder() {
        return border;
    }

    public int getLogoPart() {
        return logoPart;
    }
}
