package utils;

import java.util.UUID;

public class UUIDUtils {
    public static String getUid(){
        UUID uuid = UUID.randomUUID();
        String string = uuid.toString();

        String s = string.replaceAll("-", "");

        return s;

    }
}
