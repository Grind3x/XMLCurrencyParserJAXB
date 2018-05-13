import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrenciesDateFormatter extends XmlAdapter<String, Date> {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");

    @Override
    public Date unmarshal(String v) {
        Date date = new Date();
        try{
            date = sdf.parse(v);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public String marshal(Date v) {
        return sdf.format(v);
    }
}
