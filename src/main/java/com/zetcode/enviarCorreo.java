package com.zetcode;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class enviarCorreo {
    public enviarCorreo() {

    }

    public static void enviarCorreo(String destinatario, String asunto, String cuerpo) {
        //La dirección de correo de envío
        String emisor = "pruebaadsi03@gmail.com";
        //La clave de aplicación obtenida según se explica en este artículo:
        String psaswordEmisor = "baorkvofowqwvsho";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.user", emisor); //gmail emisor
        props.put("mail.smtp.clave", psaswordEmisor);//Password del gmail
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.port", "587"); 

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(psaswordEmisor));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", emisor, psaswordEmisor);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();   

        }
    }


}