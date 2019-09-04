package com.tao.leanrn.demo.qrcode.web;

import com.google.zxing.WriterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName QrcodeController
 * @Descriiption 二维码Controller
 * @Author yanjiantao
 * @Date 2019/8/28 9:13
 **/
@Slf4j
@RestController
public class QrcodeController {

    @Autowired
    private Qrcode qrcode;

    @RequestMapping(value = "/qrcode/get", method = RequestMethod.GET)
    public void getQrcode(HttpServletResponse response) {
        qrcode.createQrCode(600,600,"https://blog.booleandev.xyz", response);
        log.info("controller调用...");
    }


    @RequestMapping(value = "/qrcode/logo/get", method = RequestMethod.GET)
    public void getQrcodeWithLogo(HttpServletResponse response) {
        qrcode.createLogoQrCode(600,600,"https://blog.booleandev.xyz", response);
        log.info("controller调用...");
    }

    @RequestMapping(value = "/logo/get", method = RequestMethod.GET)
    public void getLogo(HttpServletResponse response) throws IOException, WriterException {
        qrcode.getLogo(response);
        log.info("controller调用...");
    }

}
