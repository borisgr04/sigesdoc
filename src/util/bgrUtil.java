/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author bgr
 */
public class bgrUtil {

    public static boolean isFechaValida(String fechax) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(fechax);
           } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static boolean isDoubleValido(String sdouble) {
        try {
             Double.parseDouble(sdouble);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isIntValido(String sInteger) {
        try {
            Integer.parseInt(sInteger);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static int obtenerMes(Date date) {

        if (null == date) {
            return 0;

        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
            return Integer.parseInt(dateFormat.format(date));

        }
    }
    
    public static Date DeStringADate(String fecha){
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String strFecha = fecha;
		Date fechaDate = null;
		try {
			fechaDate = formato.parse(strFecha);
                        //System.out.println(fechaDate.toString());
			return fechaDate;
		} catch (ParseException ex) {
			ex.printStackTrace();
			return fechaDate;
		}
	}

}
