package com.courage.platform.store.delay.server;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by zhangyong on 2020/6/3.
 */
public class MainApplication {

    public static void main(String[] args) throws MalformedURLException {
        try {
            String fileUrl = null;
            if (args != null && args.length == 1) {
                fileUrl = args[0];
            } else {
                fileUrl = "http://download.edu.binzhou.gov.cn/rrt_test/2020/06/03/20/45/3bff7452-c77e-40ab-8000-98b3a2490387.png";
            }
            URL url = new URL(fileUrl);
            // 建立链接
            HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
            // 连接指定的资源
            httpUrl.connect();
            // 获取网络输入流
            InputStream is = null;
            is = httpUrl.getInputStream();
            BufferedImage image = null;
            image = ImageIO.read(is);
            int width = image.getWidth();
            int height = image.getHeight();
            System.out.println("width:" + width + " height:" + height);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
