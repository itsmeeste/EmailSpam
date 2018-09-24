package com.qa.quickstart.SomeWebSite;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail 
{
	public String output = "";
	public String sender = "";
	public void Send(String email,String filepath)
	{
		final String username = "qaclassfunstuff@gmail.com";
		final String password = "???????";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("WELCOME");
			message.setText("GUESS THE WORD AND THEN REPLY IN THE SUBJECT "
					+ "TO STOP THE EMAILS THESE ARE SENT EVERY 60 SECONDS");
			
			// Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         messageBodyPart.setText("GUESS THE PLACE AND THEN REPLY IN THE SUBJECT \"\r\n" + 
	         		"					+ \"TO STOP THE EMAILS THESE ARE SENT EVERY 60 SECONDS");

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = filepath;
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);


			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	public boolean read(String keyword) {
		 
        Properties props = new Properties();
 
        try {

            //create properties field
            Properties properties = new Properties();

            properties.put("mail.pop3.host", "pop.gmail.com");
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);
        
            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect("pop.gmail.com", "qaclassfunstuff@gmail.com", "Itspassword123");

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
               Message message = messages[i];
               System.out.println("---------------------------------");
               System.out.println("Email Number " + (i + 1));
               System.out.println("Subject: " + message.getSubject());
               System.out.println("From: " + message.getFrom()[0]);
               System.out.println("Text: " + message.getContent().toString());
               output = message.getSubject().toLowerCase();
               System.out.println(output);
               int index = message.getFrom()[0].toString().indexOf("<");
               int indexend = message.getFrom()[0].toString().indexOf(">");
               sender = message.getFrom()[0].toString().substring(index +1, indexend);
               System.out.println(sender);
            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();

            } catch (NoSuchProviderException e) {
               e.printStackTrace();
            } catch (MessagingException e) {
               e.printStackTrace();
            } catch (Exception e) {
               e.printStackTrace();
            }
        if(output.equals(keyword))
        {
        	System.out.println("was found");
        	return true;
        }
        else
        	return false;
    }
	
	public void SendTestStuff(String email,String filepath,String expected) throws Exception
	{
		boolean gotresult = false;
		while(!read(expected))
		{
			Send(email,filepath);
			Thread.sleep(10000);
		}
		Utils.IncScore(email);
		
	}

}
