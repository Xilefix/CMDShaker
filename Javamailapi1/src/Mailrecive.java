


import java.io.*;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.*;

public class Mailrecive {

     public static void mailrecive(String server,String name, String pw) {
         try {
             Properties props = new Properties();
             props.setProperty("mail.store.protocol","pop3");
             Session emailSession = Session.getDefaultInstance(props);
             Store emailStore = emailSession.getStore("pop3");
             emailStore.connect(server,name,pw);
             Folder emailFolder = emailStore.getFolder("INBOX");
             emailFolder.open(Folder.READ_ONLY);
             Message messages[] = emailFolder.getMessages();

             System.out.println("\nSie haben "+messages.length+" Emails im Postfach.");

             for(int i=0;i<messages.length;i++) {
                 Message message = messages[i];
                 System.out.println("Email Nummer: "+(i+1));
                 System.out.println("Betreff: "+message.getSubject());
                 System.out.println("Absender: "+message.getFrom()[0]);
                 System.out.println("Datum: "+message.getSentDate()+"\n");
             }

             Scanner scanner = new Scanner(System.in);

             int h=1;
             while(h==1) {
                 System.out.print("\nWelche Nachricht möchten sie Lesen? Geben sie die Nummer ein:  ");
                 String mailNum = scanner.nextLine();

                 System.out.println("Absender: "+messages[Integer.valueOf(mailNum)-1].getFrom()[0]);
                 System.out.println("Datum: "+messages[Integer.valueOf(mailNum)-1].getSentDate()+"\n");
                 System.out.println("Betreff: "+messages[Integer.valueOf(mailNum)-1].getSubject());
                 if ( messages[Integer.valueOf(mailNum)-1].isMimeType("text/plain" ) )
                     System.out.println(messages[Integer.valueOf(mailNum)-1].getContent() );


                 System.out.println("\nWas möchten sie als nächstes tun?");
                 System.out.println("1 um eine weitere Nachricht zu lesen.");
                 System.out.println("0 um das Programm zu beenden. (bzw. jede andere Zahl)");
                 h= Integer.valueOf(scanner.nextLine());
             }
             scanner.close();
             emailFolder.close(false);
             emailStore.close();
         }catch(NoSuchProviderException nspe) {
             nspe.printStackTrace();
         }catch(MessagingException me) {
             me.printStackTrace();
         }catch(IOException ioe) {
             ioe.printStackTrace();
         }

     }

     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         System.out.println("Geben Sie den POP3-Servernamen ein!");
         String server = scanner.nextLine(); //pop3.firemail.de
         System.out.println("Geben Sie ihren Benutzernamen ein!");
         String name =  scanner.nextLine(); //unijena123@firemail.de
         System.out.println("Geben Sie ihr Passwort ein!");
         String pw=  scanner.nextLine();    //Felix#jena1

         mailrecive(server, name, pw);

         scanner.close();
     }
}



