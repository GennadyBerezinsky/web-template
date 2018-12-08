package model.service;

import java.util.Locale;

/**
 * Created by User on 06.12.2018.
 */


public class LocaleService {
    public static void runService() {
        if(Locale.getDefault() != Locale.US){
            Locale.setDefault(Locale.US);
        }

    }
}
