package ch.bouverat.engine.game_engine.core;

import ch.bouverat.engine.game_engine.core.enums.ErrorType;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Error {
    public static void message(ErrorType errorType,  String parentName, String message) {
        Format format = new SimpleDateFormat("hh:mm:ss");
        System.out.println("[" + errorType + "] ["+ format.format(new Date()) +"] [" + parentName + "] -> " + message);
    }
}
