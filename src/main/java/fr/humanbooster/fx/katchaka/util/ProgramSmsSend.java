package fr.humanbooster.fx.katchaka.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.humanbooster.fx.katchaka.beans.MessageSms;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class ProgramSmsSend {

    private static final String ServiceName = "sms-cf678891-1";

    // Application Key
    protected static String AK = "gKAOK6RsehQTMWm9";

    // Application Secret
    protected static String AS = "F9orV45FA8KNmWXkVlMpBiBfqrBAiS4u";

    // Consumer Key
    protected static String CK = "4pJ5jjzpeRKvrpT9s0QwFlM9oo1IKNtI";

    private static String contenuDuMessage = "Vous avez recu une invitation";


    public void sendSms(String telephone)
    {

        String METHOD = "POST";
        try {
            URL QUERY  = null;
            try {
                QUERY = new URL("https://eu.api.ovh.com/1.0/sms/"+ServiceName+"/jobs");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            //On doit envoyer à l'API d'OVH le messageSMS sérialisé
            // Ne surtout pas faire comme dans le guide OVH :
            // String BODY   = "{\"receivers\":[\"+33612345678\"],\"messageSMS\":\"Test SMS OVH\",\"priority\":\"high\",\"senderForResponse\":true}";
            // La ligne ci-dessus est du bricodage

            // On sérialise le messageSMS avec la bibliothèque Jackson
            // ObjectMapper est une classe de la bibliothèque Jackson et elle sait exprimer
            // un objet Java en JSON, cette traduction s'appelle une sérialisation
            ObjectMapper objectMapper = new ObjectMapper();
            MessageSms messageSMS = new MessageSms();
            messageSMS.getDestinataires().add("+33" + telephone.substring(1));
            messageSMS.setContenu(contenuDuMessage);

            // On demande à Jackson de sérialiser l'objet messageSMS
            // Exemple : {"receivers":["+33665088677"],"messageSMS":"Vous avez recu une invitation","priority":"high","senderForResponse":true}
            String BODY = objectMapper.writeValueAsString(messageSMS);

            System.out.println(BODY);

            long TSTAMP  = new Date().getTime()/1000;

            //Création de la signature
            String toSign    = AS + "+" + CK + "+" + METHOD + "+" + QUERY + "+" + BODY + "+" + TSTAMP;
            String signature = "$1$" + HashSHA1(toSign);
            System.out.println(signature);


            HttpURLConnection req = null;
            try {
                req = (HttpURLConnection)QUERY.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            req.setRequestMethod(METHOD);
            req.setRequestProperty("Content-Type",      "application/json");
            req.setRequestProperty("X-Ovh-Application", AK);
            req.setRequestProperty("X-Ovh-Consumer",    CK);
            req.setRequestProperty("X-Ovh-Signature",   signature);
            req.setRequestProperty("X-Ovh-Timestamp",   "" + TSTAMP);

            if(!BODY.isEmpty())
            {
                req.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(req.getOutputStream());
                wr.writeBytes(BODY);
                wr.flush();
                wr.close();
            }

            String inputLine;
            BufferedReader in;
            int responseCode = req.getResponseCode();
            if ( responseCode == 200 )
            {
                //Récupération du résultat de l'appel
                in = new BufferedReader(new InputStreamReader(req.getInputStream()));
            }
            else
            {
                in = new BufferedReader(new InputStreamReader(req.getErrorStream()));
            }
            StringBuffer response   = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //Affichage du résultat
            System.out.println(response.toString());

        } catch (MalformedURLException e) {
            final String errmsg = "MalformedURLException: " + e;
        } catch (IOException e) {
            final String errmsg = "IOException: " + e;
        }
    }

    public static String HashSHA1(String text)
    {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] sha1hash = new byte[40];
            md.update(text.getBytes("iso-8859-1"), 0, text.length());
            sha1hash = md.digest();
            return convertToHex(sha1hash);
        } catch (NoSuchAlgorithmException e) {
            final String errmsg = "NoSuchAlgorithmException: " + text + " " + e;
            return errmsg;
        } catch (UnsupportedEncodingException e) {
            final String errmsg = "UnsupportedEncodingException: " + text + " " + e;
            return errmsg;
        }
    }

    private static String convertToHex(byte[] data)
    {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9))
                    buf.append((char) ('0' + halfbyte));
                else
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        }
        return buf.toString();
    }
}
