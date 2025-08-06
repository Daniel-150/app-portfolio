package com.danielmendieta.app.controllers;

import com.danielmendieta.app.models.Mail;
import com.danielmendieta.app.services.ServicioMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/contacto")  
public class ControladorMail {
    
    @Autowired
    private ServicioMail serviceMail;
    
    @GetMapping
    public String mostrarFormulario() {
        return "mail-formulario";
    }
    
    @PostMapping("/enviar")
    public String procesarFormulario(
            @RequestParam String nombre,
            @RequestParam String email,
            @RequestParam String mensaje,
            Model model) {
        
        try {
            serviceMail.enviarMensajeHTML(nombre, email, mensaje);
            model.addAttribute("exito", "¡Mensaje enviado con éxito!");
        } catch (Exception e) {
            model.addAttribute("error", "Error al enviar: " + e.getMessage());
        }
        
        return "mail-formulario";
    }
}
