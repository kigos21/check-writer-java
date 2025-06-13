package dev.kigos.checkwriter.util;

import com.soundicly.jnanoidenhanced.jnanoid.NanoIdUtils;

public class NanoIdGenerator {

  public static final int DEFAULT_SIZE = 10;
  public static final char[] DEFAULT_ALPHABET = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();

  @SuppressWarnings("deprecation")
  public static String generate() {
    return NanoIdUtils.randomNanoId(DEFAULT_ALPHABET, DEFAULT_SIZE);
  }

  public static String generateWithPrefix(String prefix) {
    prefix = prefix.toLowerCase();
    return prefix + '-' + generate();
  }

}
