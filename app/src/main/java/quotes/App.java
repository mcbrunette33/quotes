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


public class App
{
    final String starwarsFile = "https://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote";
    final String forismaticFileName = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
    String toPrint;
    Gson gson = new Gson();
    public static void main(String[] args)
    { //Gson gson = new Gson();

        String arg = args.length > 0? args[0]: "default";

        try{
            new App().run(arg);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }

        return;
    }
    public void run(String fileName) throws IOException
    {
        switch(fileName)
        {
            case starwarsFile:
                HttpsURLConnection testSecure = secureCreateRequest(fileName);
                StringBuffer responseStringBuffSecure = readResponse(testSecure);
                StarWars newQuoteSecure = parseStarWars(responseStringBuffSecure);
                toPrint = newQuoteSecure.toString();
                break;
            case forismaticFileName:
                HttpURLConnection test = createRequest(fileName);
                StringBuffer responseStringBuff = readResponse(test);
                Quotes newQuote = parseQuote(responseStringBuff);
                toPrint = newQuote.toString();
                break;
            default:
                defaultQuote();
                return;
        }
        System.out.println(toPrint);
        return;

    }
    public void defaultQuote() throws IOException
    {
        Gson gson = new Gson();
        File jsonFile = new File("src/main/resources/recentquotes.json");
        try
        {
            int rand = new Random().nextInt(137 + 0 + 1);
            FileReader jsonFileReader = new FileReader(jsonFile);
            Type collectionType = new TypeToken<Collection<DefaultQuotes>>(){}.getType();
            ArrayList<DefaultQuotes> quotesArrayList = gson.fromJson(jsonFileReader, collectionType);
            System.out.println(quotesArrayList.get(rand).author);
            System.out.println(quotesArrayList.get(rand).text);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
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

