package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExampleDate {
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy HH:mm");
        Date date = new Date();
        System.out.println(formatter.format(date));
    }
}
