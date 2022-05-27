/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.net.ssl.*;
import java.io.*;
import java.lang.reflect.Type;
import java.net.*;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

<<<<<<< HEAD
public class App {
    public static void main(String[] args)
    {
        try{
            new App().run();
        }catch (IOException e)
=======
public class App
{
    Gson gson = new Gson();
    public static void main(String[] args)
    {
        //Gson gson = new Gson();

        try{
            new App().run(args[0]);
        }
        catch (IOException e)
>>>>>>> feature2
        {
            e.printStackTrace();
            System.exit(-1);
        }
<<<<<<< HEAD
    }

    public void run() throws IOException
    {
        Gson gson = new Gson();
=======
        return;
    }
    public void run(String fileName) throws IOException
    {

        //dis the URL
        HttpURLConnection test = fileName.equals("https://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote")?
                secureCreateRequest(fileName):
                createRequest(fileName);
        StringBuffer responseBuffer =  readResponse(test);
        boolean checker = responseBuffer.isEmpty();
        if(checker == true)defaultQuote();

        Quotes newQuote = parseQuote(responseBuffer);
        //for usage of ./gradlew test --args result will pring out content
        System.out.println(newQuote.toString());

    }

    public void defaultQuote() throws FileNotFoundException {
>>>>>>> feature2
        File jsonFile = new File("app/src/main/resources/recentquotes.json");
        FileReader jsonFileReader = new FileReader(jsonFile);
        Type collectionType = new TypeToken<Collection<Quotes>>(){}.getType();
        ArrayList<DefaultQuotes> quotesArrayList = gson.fromJson(jsonFileReader, collectionType);
        System.out.println(quotesArrayList.get(new Random().nextInt(69)+0).author);
    }

    public HttpURLConnection createRequest(String fileName) throws IOException
    {
        //dis the URL
        URL quoteUrl = new URL(fileName);
        //we want type HttpURL connection so we must cast
        HttpURLConnection quoteUrlConnection = (HttpURLConnection) quoteUrl.openConnection();
        quoteUrlConnection.setRequestMethod(("GET"));

        return quoteUrlConnection;
    }
    public StringBuffer readResponse(HttpURLConnection _connection) throws IOException
    {
        try(BufferedReader responseReader = new BufferedReader((
                new InputStreamReader(_connection.getInputStream())
        ))) {
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = responseReader.readLine()) != null) {
                content.append(inputLine);
            }
            return content;
        }
    }


    public Quotes parseQuote(StringBuffer _content)
    {
        Quotes newQuote = gson.fromJson(String.valueOf(_content), Quotes.class);
        return newQuote;
    }

    public StarWars parseStarWars(StringBuffer _content)
    {
        StarWars newQuote = gson.fromJson(String.valueOf(_content), StarWars.class);
        return newQuote;
    }

    public HttpsURLConnection secureCreateRequest(String fileName) throws IOException
    {
        //dis the URL
        URL quoteUrl = new URL(fileName);
        //we want type HttpURL connection so we must cast
        trustAllHosts();
        HttpsURLConnection quoteUrlConnection = (HttpsURLConnection) quoteUrl.openConnection();
        quoteUrlConnection.setHostnameVerifier(DO_NOT_VERIFY);
        quoteUrlConnection.setRequestMethod(("GET"));
        quoteUrlConnection.setDoOutput(true);
        quoteUrlConnection.setDoInput(true);

        return quoteUrlConnection;
    }
    final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };
    public void trustAllHosts()
    {
        try
        {
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509ExtendedTrustManager()
                    {
                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers()
                        {
                            return null;
                        }

                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
                        {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
                        {
                        }

                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] xcs, String string, Socket socket) throws CertificateException
                        {

                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] xcs, String string, Socket socket) throws CertificateException
                        {

                        }

                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] xcs, String string, SSLEngine ssle) throws CertificateException
                        {

                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] xcs, String string, SSLEngine ssle) throws CertificateException
                        {

                        }

                    }
            };

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new  HostnameVerifier()
            {
                @Override
                public boolean verify(String hostname, SSLSession session)
                {
                    return true;
                }
            };
            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        }
        catch (Exception e)
        {
            System.out.println("Error occurred" +e);
            System.exit(-1);
        }
    }


}

