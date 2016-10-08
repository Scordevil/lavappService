/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.modelo.dto.Usuario_TO;
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
        properties.put("mail.smtp.user", "soportelavaapp@gmail.com"); //Correo desde donde se enviaran lo mails
        properties.put("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(properties);
    }

    @Override
    public int enviarMensajeBienvenido(Usuario_TO usuario) {
        int valor = 0;
        init();
        try {
            MimeMessage message = new MimeMessage(session);
            //quien envia
            message.setFrom(new InternetAddress("soportelavaapp@gmail.com"));
            // a donde se envia
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(usuario.getEmail()));
            message.setSubject("Bienvenid@ a LavaApp"); //asunto
            String mensajehtml = "Te damos la bienvenida a LavaApp, desde hoy podrá contar con nuestro excelente servicio y calidad en el lavado de sus prendas y articulos de hogar.\n"
                    + "Agenda desde nuestra APP las 24 horas, acumula puntos y goza de nuestras promociones"; //Mensaje
            message.setContent(mensajehtml, "text/html");
            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com", (String) properties.get("mail.smtp.user"), "lavaapp2016"); //Datos de conexion del correo de envio
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            valor = 1;
        } catch (MessagingException me) {
            valor = 0;
            me.getMessage();
            //Aqui se deberia o mostrar un mensaje de error o en lugar
            //de no hacer nada con la excepcion, lanzarla para que el modulo
            //superior la capture y avise al usuario con un popup, por ejemplo.           
        }
        return valor;
    }

    @Override
    public int enviarMensajeNuevaContraseña(Usuario_TO usuario) {
        int valor = 0;
        init();
        try {
            MimeMessage message = new MimeMessage(session);
            //quien envia
            message.setFrom(new InternetAddress("soportelavaapp@gmail.com"));
            // a donde se envia
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(usuario.getEmail()));
            message.setSubject("Nueva contraseña para ingreso a sistema LavaApp"); //asunto
            String mensajehtml = "Hemos recibido una solicitud para generar una contraseña provisional al sistema.\n"
                    + "La contraseña es "+usuario.getContrasena()+", por favor ingrese al sistema e inmediatamente modifique esta contraseña por una personal."; //Mensaje
            message.setContent(mensajehtml, "text/html");
            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com", (String) properties.get("mail.smtp.user"), "lavaapp2016"); //Datos de conexion del correo de envio
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            valor = 1;
        } catch (MessagingException me) {
            valor = 0;
            me.getMessage();
            //Aqui se deberia o mostrar un mensaje de error o en lugar
            //de no hacer nada con la excepcion, lanzarla para que el modulo
            //superior la capture y avise al usuario con un popup, por ejemplo.           
        }
        return valor;
    }

    @Override
    public int enviarMensajeMalaCalificacion(Usuario_TO usuario) {
        int valor = 0;
        init();
        try {
            MimeMessage message = new MimeMessage(session);
            //quien envia
            message.setFrom(new InternetAddress("soportelavaapp@gmail.com"));
            // a donde se envia
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(usuario.getEmail()));
            message.setSubject("Mala Calificación"); //asunto
            String mensajehtml = ""; //Mensaje
            message.setContent(mensajehtml, "text/html");
            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com", (String) properties.get("mail.smtp.user"), "lavaapp2016"); //Datos de conexion del correo de envio
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            valor = 1;
        } catch (MessagingException me) {
            valor = 0;
            me.getMessage();
            //Aqui se deberia o mostrar un mensaje de error o en lugar
            //de no hacer nada con la excepcion, lanzarla para que el modulo
            //superior la capture y avise al usuario con un popup, por ejemplo.           
        }
        return valor;
    }

    @Override
    public int enviarMensajeAgendamiento(Usuario_TO usuario) {
        int valor = 0;
        init();
        try {
            MimeMessage message = new MimeMessage(session);
            //quien envia
            message.setFrom(new InternetAddress("soportelavaapp@gmail.com"));
            // a donde se envia
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(usuario.getEmail()));
            message.setSubject("Confirmacion de servicio"); //asunto
            String mensajehtml = "Su agendamiento ha sido procesado con éxito, nuestro asesor recibirá sus prendas a la mayor brevedad.\n"
                    + " No olvide calificar nuestro servicio para que nos ayude a mejorar día a día."; //Mensaje
            message.setContent(mensajehtml, "text/html");
            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com", (String) properties.get("mail.smtp.user"), "lavaapp2016"); //Datos de conexion del correo de envio
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            valor = 1;
        } catch (MessagingException me) {
            valor = 0;
            me.getMessage();
            //Aqui se deberia o mostrar un mensaje de error o en lugar
            //de no hacer nada con la excepcion, lanzarla para que el modulo
            //superior la capture y avise al usuario con un popup, por ejemplo.           
        }
        return valor;
    }

    @Override
    public int enviarMensajeRecibidoAlCliente(Usuario_TO usuario) {
        int valor = 0;
        init();
        try {
            MimeMessage message = new MimeMessage(session);
            //quien envia
            message.setFrom(new InternetAddress("soportelavaapp@gmail.com"));
            // a donde se envia
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(usuario.getEmail()));
            message.setSubject("Confirmacion de recibido"); //asunto
            String mensajehtml = "Hemos procesado su orden y estará disponible a partir de 24 horas, adjuntamos su recibo en PDF adjunto.\n"
                    + "Contribuimos con el ambiente cero papel."; //Mensaje
            message.setContent(mensajehtml, "text/html");
            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com", (String) properties.get("mail.smtp.user"), "lavaapp2016"); //Datos de conexion del correo de envio
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            valor = 1;
        } catch (MessagingException me) {
            valor = 0;
            me.getMessage();
            //Aqui se deberia o mostrar un mensaje de error o en lugar
            //de no hacer nada con la excepcion, lanzarla para que el modulo
            //superior la capture y avise al usuario con un popup, por ejemplo.           
        }
        return valor;
    }

    @Override
    public int enviarMensajeRecibidoALaPlanta(Usuario_TO usuario) {
        int valor = 0;
        init();
        try {
            MimeMessage message = new MimeMessage(session);
            //quien envia
            message.setFrom(new InternetAddress("soportelavaapp@gmail.com"));
            // a donde se envia
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(usuario.getEmail()));
            message.setSubject("Confirmacion de entrenga en plata de lavado"); //asunto
            String mensajehtml = "Orden en traslado para procesamiento."; //Mensaje
            message.setContent(mensajehtml, "text/html");
            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com", (String) properties.get("mail.smtp.user"), "lavaapp2016"); //Datos de conexion del correo de envio
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            valor = 1;
        } catch (MessagingException me) {
            valor = 0;
            me.getMessage();
            //Aqui se deberia o mostrar un mensaje de error o en lugar
            //de no hacer nada con la excepcion, lanzarla para que el modulo
            //superior la capture y avise al usuario con un popup, por ejemplo.           
        }
        return valor;
    }

    @Override
    public int enviarMensajeRecibidoDePlanta(Usuario_TO usuario) {
        int valor = 0;
        init();
        try {
            MimeMessage message = new MimeMessage(session);
            //quien envia
            message.setFrom(new InternetAddress("soportelavaapp@gmail.com"));
            // a donde se envia
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(usuario.getEmail()));
            message.setSubject("Confirmacion de entrenga en plata de lavado"); //asunto
            String mensajehtml = "Hemos recibido el pedido de la planta."; //Mensaje
            message.setContent(mensajehtml, "text/html");
            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com", (String) properties.get("mail.smtp.user"), "lavaapp2016"); //Datos de conexion del correo de envio
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            valor = 1;
        } catch (MessagingException me) {
            valor = 0;
            me.getMessage();
            //Aqui se deberia o mostrar un mensaje de error o en lugar
            //de no hacer nada con la excepcion, lanzarla para que el modulo
            //superior la capture y avise al usuario con un popup, por ejemplo.           
        }
        return valor;
    }

    @Override
    public int enviarMensajeRecibidoDelCliente(Usuario_TO usuario) {
        int valor = 0;
        init();
        try {
            MimeMessage message = new MimeMessage(session);
            //quien envia
            message.setFrom(new InternetAddress("soportelavaapp@gmail.com"));
            // a donde se envia
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(usuario.getEmail()));
            message.setSubject("Confirmacion de entrega del pedido"); //asunto
            String mensajehtml = "Hemos entregado su orden de servicio adjunta, no olvide calificar nuestro servicio para que no ayude a mejorar a día a día."; //Mensaje
            message.setContent(mensajehtml, "text/html");
            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com", (String) properties.get("mail.smtp.user"), "lavaapp2016"); //Datos de conexion del correo de envio
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            valor = 1;
        } catch (MessagingException me) {
            valor = 0;
            me.getMessage();
            //Aqui se deberia o mostrar un mensaje de error o en lugar
            //de no hacer nada con la excepcion, lanzarla para que el modulo
            //superior la capture y avise al usuario con un popup, por ejemplo.           
        }
        return valor;
    }

}
