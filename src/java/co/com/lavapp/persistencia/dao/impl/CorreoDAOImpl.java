/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.persistencia.dao.CorreoDAO;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Desarrollo_Planit
 */
public class CorreoDAOImpl implements CorreoDAO {

    private final Properties properties = new Properties();
    private Session session;

    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");

    private void init() {
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");
        properties.put("mail.smtp.user", "smsrenta@gmail.com"); //Correo desde donde se enviaran lo mails
        properties.put("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(properties);
    }

    @Override
    public void enviarMensajeBienvenido() {
        try {
            MimeMessage message = new MimeMessage(session);
            //quien envia
            message.setFrom(new InternetAddress("smsrenta@gmail.com"));
            // a donde se envia
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(""));
            message.setSubject("SMSRenta informe de su reservacion"); //asunto
            String mensajehtml = ""; //Mensaje
            message.setContent(mensajehtml, "text/html");
            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com", (String) properties.get("mail.smtp.user"), "Smsrenta2016"); //Datos de conexion del correo de envio
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        } catch (MessagingException me) {
            me.getMessage();
            //Aqui se deberia o mostrar un mensaje de error o en lugar
            //de no hacer nada con la excepcion, lanzarla para que el modulo
            //superior la capture y avise al usuario con un popup, por ejemplo.           
        }
    }

    @Override
    public void enviarMensajeNuevaContraseña() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enviarMensajeMalaCalificacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
