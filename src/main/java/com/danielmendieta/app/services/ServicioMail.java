package com.danielmendieta.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class ServicioMail {

    @Value("${email.destino}")
    private String emailDestino;

    @Autowired
    private JavaMailSender mailSender;

    // Versión HTML corregida
    public void enviarMensajeHTML(String nombre, String emailRemitente, String mensaje) 
        throws MessagingException {
        
        MimeMessage email = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(email, true, "UTF-8");
        
        helper.setTo(this.emailDestino);
        helper.setSubject("Nuevo mensaje de " + nombre + " desde tu portfolio");
        helper.setText(
            "<h2>Nuevo contacto</h2>" +
            "<p><strong>Nombre:</strong> " + nombre + "</p>" +
            "<p><strong>Email:</strong> " + emailRemitente + "</p>" +
            "<p><strong>Mensaje:</strong></p>" +
            "<p>" + mensaje.replace("\n", "<br>") + "</p>",
            true // Indica que es HTML
        );
        helper.setFrom(emailRemitente);
        
        mailSender.send(email);
    }
}