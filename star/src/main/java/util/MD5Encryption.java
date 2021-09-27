package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encryption
{
  private static MD5Encryption instance;

  public static MD5Encryption getUniqueInstance()
  {
    if (instance == null) {
      instance = new MD5Encryption();
    }
    return instance;
  }

  public static String encrypt(String plain) {
    String password = "";
    try {
      MessageDigest algorithm = MessageDigest.getInstance("MD5");
      algorithm.reset();
      algorithm.update(plain.getBytes());
      byte[] hash = algorithm.digest();
      for (int i = 0; i < hash.length; i++) {
        int v = hash[i] & 0xFF;
        if (v < 16)
          password = password + "0";
        password = password + Integer.toString(v, 16).toUpperCase();
      }
    }
    catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return password;
  }
}