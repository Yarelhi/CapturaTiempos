/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.BodyPart;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMultipart;


public class MailClient {


    public void sendMail(String message, String mail, String subject) {

        final String username = "notificaciones@it-globalsolutions.com";
        final String password = "1Tglobal2020#";

        String to = mail;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.it-globalsolutions.com");
        props.put("mail.smtp.port", "587");

        Session session =
            Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        try {

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("notificaciones@it-globalsolutions.com"));
            msg.setRecipients(Message.RecipientType.TO,
                              InternetAddress.parse(to, false));
            msg.setSubject(subject);

            MimeMultipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(message + "<img src=\"cid:image\">",
                                       "text/html;charset=UTF-8");
            // add it
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
            msg.setContent(multipart);

            //message.setText("Correo prueba");

            // Transport.connect(username, password);
            System.out.println("Enviando correo...");

            Transport.send(msg, msg.getAllRecipients());

            System.out.println("Correo Enviado");

        } catch (MessagingException e) {
            e.printStackTrace();


        }
    }

    public static void main(String[] args) {
        try {

            MailClient client = new MailClient();
            String Message = "Envio de correo";
            client.sendMail(Message,"ar.chely19.96@gmail.com", "iT-Global-Informe de Reporte de Gastos");

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}

