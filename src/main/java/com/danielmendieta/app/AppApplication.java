package com.danielmendieta.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
    private JavaMailSender mailSender;
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
  
    @Override
    public void run(String... args) {
        if(mailSender instanceof JavaMailSenderImpl) {
            JavaMailSenderImpl impl = (JavaMailSenderImpl) mailSender;
            System.out.println("Host configurado: " + impl.getHost());
            System.out.println("Puerto configurado: " + impl.getPort());
        }
    }
}
