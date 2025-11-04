/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTIL;

import java.io.ByteArrayOutputStream;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 *
 * @author Roberth
 */
public class MailSender {
    
    public static void sendEmail(String to, String asunto, String mensaje, String namePdf, ByteArrayOutputStream outputStream) {
        // Configuración del servidor SMTP
        final String username = "irazabarob44@gmail.com"; 
        final String password = "thhw conu tdll ozhm";      
        
        
        // Propiedades del servidor SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // Para Gmail
        props.put("mail.smtp.port", "587");
        
        // Crear sesión
        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
        
        try {
            // Crear mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
            message.setSubject(asunto);
            
            adjuntarPDF(message, outputStream, namePdf, mensaje);
            // Enviar mensaje
            Transport.send(message);
            
            System.out.println("Correo enviado exitosamente!");
            
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void adjuntarPDF(Message message, ByteArrayOutputStream outputStream, String nombreArchivo, String mensajeCuerpo) throws MessagingException{
        // Cuerpo del mensaje
            MimeBodyPart texto = new MimeBodyPart();
            texto.setText(mensajeCuerpo);
            
            // Adjuntar PDF desde memoria
            MimeBodyPart adjunto = new MimeBodyPart();
            byte[] pdfBytes = outputStream.toByteArray();
            DataSource source = new ByteArrayDataSource(pdfBytes, "application/pdf");
            adjunto.setDataHandler(new DataHandler(source));
            adjunto.setFileName(nombreArchivo + ".pdf");
            adjunto.setHeader("Content-Transfer-Encoding", "base64"); // Codificación explícita
            
            // Ensamblar mensaje
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(texto);
            multipart.addBodyPart(adjunto);
            message.setContent(multipart);
    }
    
    
}
