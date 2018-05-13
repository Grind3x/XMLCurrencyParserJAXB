import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Service {

    public static String performRequest(String urlAddress) throws IOException {
        String result = "";
        try {
            URL url = new URL(urlAddress);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String temp = "";
                for (; (temp = br.readLine()) != null; ) {
                    result += temp;
                    result += System.lineSeparator();
                }
            }
        } catch (IOException e) {
            throw e;
        }
        return result;
    }

    public static void saveToXMLFile(Exchange exchange, File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Exchange.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(exchange, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Exchange loadXMLFromString(String xmlString) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Exchange.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Exchange) unmarshaller.unmarshal(new InputSource(new StringReader(xmlString)));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}