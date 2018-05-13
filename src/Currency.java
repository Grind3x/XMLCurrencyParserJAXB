import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.Objects;

@XmlRootElement(name = "currency")
@XmlType(propOrder = {"r030", "txt", "rate", "cc", "exchangedate"})
public class Currency {
    private String r030;
    private String txt;
    private double rate;
    private String cc;
    private Date exchangedate;

    public Currency() {
    }

    public Currency(String r030, String txt, double rate, String cc, Date exchangedate) {
        this.r030 = r030;
        this.txt = txt;
        this.rate = rate;
        this.cc = cc;
        this.exchangedate = exchangedate;
    }

    @XmlElement
    public String getR030() {
        return r030;
    }

    public void setR030(String r030) {
        this.r030 = r030;
    }

    @XmlElement
    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    @XmlElement
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @XmlElement
    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    @XmlElement
    @XmlJavaTypeAdapter(CurrenciesDateFormatter.class)
    public Date getExchangedate() {
        return exchangedate;
    }


    public void setExchangedate(Date exchangedate) {
        this.exchangedate = exchangedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Double.compare(currency.rate, rate) == 0 &&
                Objects.equals(r030, currency.r030) &&
                Objects.equals(txt, currency.txt) &&
                Objects.equals(cc, currency.cc) &&
                Objects.equals(exchangedate, currency.exchangedate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(r030, txt, rate, cc, exchangedate);
    }

    @Override
    public String toString() {
        return "\n" +"Currency{" + "\n" +
                "r030='" + r030 + '\'' +
                "," + "\n" + "txt='" + txt + '\'' +
                "," + "\n" + "rate=" + rate +
                "," + "\n" + "cc='" + cc + '\'' +
                "," + "\n" + "exchangedate='" + exchangedate + '\'' + "\n" +
                '}'+"\n";
    }
}