package test;

import java.util.Calendar;
/**
 * @author guyao
 * */
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar c1 = Calendar.getInstance();
        System.out.println(c1.get(Calendar.YEAR) + "年" + (c1.get(Calendar.MONTH) + 1)
                + "月" + c1.get(Calendar.DAY_OF_MONTH) + "日" + c1.get(Calendar.HOUR)
                + ":" + c1.get(Calendar.MINUTE) + ":" + c1.get(Calendar.SECOND));

        c1.add(Calendar.DAY_OF_YEAR, 23);

        System.out.println(c1.get(Calendar.YEAR) + "年" + (c1.get(Calendar.MONTH) + 1)
                + "月" + c1.get(Calendar.DAY_OF_MONTH) + "日" + c1.get(Calendar.HOUR)
                + ":" + c1.get(Calendar.MINUTE) + ":" + c1.get(Calendar.SECOND));

    }
}
