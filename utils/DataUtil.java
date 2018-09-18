package net.vexio.startedycji.utils;

import java.util.Calendar;
import java.text.ParseException;
import net.vexio.startedycji.Main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil
{
    static boolean stop;
    
    static {
        DataUtil.stop = false;
    }
    
    public static Date getDateFromString() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = null; 
        try {
        	date = dateFormat.parse(Main.getPlugin().getConfig().getString("start.datastart"));
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    
    public static boolean getStop() {
        return DataUtil.stop;
    }
    
    public static void setStop(final boolean b) {
        DataUtil.stop = b;
    }
    
    public static int getInt(final String s) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(getDateFromString().getTime() - System.currentTimeMillis());
        final int dni = calendar.get(6);
        final int godzin = calendar.get(11);
        final int minut = calendar.get(12);
        final int sekundy = calendar.get(13);
        if (s == "d") {
            if (dni == 0 || dni < 0) {
                return 0;
            }
            return dni - 1;
        }
        else if (s == "g") {
            if (godzin == 0 || godzin < 0) {
                return 0;
            }
            return godzin - 1;
        }
        else if (s == "m") {
            if (minut == 0 || minut < 0) {
                return 0;
            }
            return minut - 1;
        }
        else {
            if (s != "s") {
                return 0;
            }
            if (getInt("d") == 0 && getInt("g") == 0 && getInt("m") == 0 && sekundy == 0) {
                setStop(true);
                return 0;
            }
            return sekundy;
        }
    }
}

