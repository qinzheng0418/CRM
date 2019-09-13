package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    public static String getMd5Str(String string) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(string.getBytes());
        StringBuffer buffer = new StringBuffer();
        for (byte b : digest) {
            int by=b&0xff;
            String str= Integer.toHexString(by);
            if (str.length()<2){
                str="0"+str;
            }
      buffer.append(str);
        }
        String MD5str = buffer.toString();

        return MD5str;
    }
}
