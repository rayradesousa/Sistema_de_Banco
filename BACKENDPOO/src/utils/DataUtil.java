package src.utils;

import java.text.SimpleDateFormat;
import java.util.Date;



public class DataUtil {
    
    public static String converterDateParaDataHora(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("DD/MM/YYYY HH:mm");
        return formatador.format(data);
    }

    public static String converterDateParaData(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("DD/MM/YYYY");
        return formatador.format(data);
    }

    public static String converterDateParaHora(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss");
        return formatador.format(data);
    }
}
