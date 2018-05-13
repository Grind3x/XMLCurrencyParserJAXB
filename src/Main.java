import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String response = "";
        try {
            response = Service.performRequest("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Exchange exchange = Service.loadXMLFromString(response);
        System.out.println(exchange);

        Service.saveToXMLFile(exchange, new File("Exchange.xml"));
    }
}
