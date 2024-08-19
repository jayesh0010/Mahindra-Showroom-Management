package com.mahindrashowrooms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class MahindraShowroomApplication {

    public static void main(String[] args) {
        SpringApplication.run(MahindraShowroomApplication.class, args);
        openHomePage("http://localhost:9292/");
    }

    private static void openHomePage(String url) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
