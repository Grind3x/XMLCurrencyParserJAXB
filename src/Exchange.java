import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Exchange {
    @XmlElement(name = "currency")
    private List<Currency> currencies = new ArrayList<>();

    public Exchange() {
    }

    public void addCurrency(Currency currency) {
        if (currency == null) {
            throw new IllegalArgumentException();
        }
        currencies.add(currency);
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "currencies=" + currencies +
                '}';
    }
}
