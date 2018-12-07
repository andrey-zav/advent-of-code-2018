package com.monigredo.day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * @author Andrew Z
 */
public class Main {
   public static void main(String[] args) throws IOException, URISyntaxException {
      URL resource = Main.class.getClassLoader().getResource("day2/input.txt");
      List<String> ids = Files.readAllLines(Paths.get(resource.toURI()));

      printChecksum(ids);
      printBoxesWithFabric(ids);
   }

   private static void printBoxesWithFabric(List<String> ids) {
      for (int i = 0; i < ids.size(); i++) {
         for (int j = i + 1; j < ids.size(); j++) {
            String a = ids.get(i);
            String b = ids.get(j);

            if (match(a, b)) {
               printCommonLetters(a, b);
            }
         }
      }


   }

   private static void printCommonLetters(String a, String b) {
      char[] aChars = a.toCharArray();
      char[] bChars = b.toCharArray();

      for (int i = 0; i < a.length(); i++) {
         if (aChars[i] == bChars[i]) {
            System.out.print(aChars[i]);
         }
      }
   }

   private static boolean match(String a, String b) {
      if (a.length() != b.length()) return false;

      char[] aChars = a.toCharArray();
      char[] bChars = b.toCharArray();

      int diffs = 0;
      for (int i = 0; i < a.length(); i++) {
         if (aChars[i] != bChars[i]) {
            diffs++;

            if (diffs > 1) return false;
         }
      }

      return diffs == 1;
   }

   private static void printChecksum(List<String> ids) {
      long twoLetters = 0;
      long threeLetters = 0;
      for (String id : ids) {
         Map<Character, Long> fqs = new LetterCounter().countFrequencies(id);

         if (fqs.containsValue(2L)) {
            twoLetters++;
         }

         if (fqs.containsValue(3L)) {
            threeLetters++;
         }
      }

      System.out.println(twoLetters * threeLetters);
   }
}
