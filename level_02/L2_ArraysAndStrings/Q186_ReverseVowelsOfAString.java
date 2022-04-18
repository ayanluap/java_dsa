package L2_ArraysAndStrings;

import java.util.*;

public class Q186_ReverseVowelsOfAString {
  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~
  public static String reverseVowels(String s) {
    StringBuilder str = new StringBuilder(s);
    // write your code here
    int st = 0, en = str.length() - 1;

    while (st < en) {
      while (!isVowel(str.charAt(st)) && st < en)
        st++;
      while (!isVowel(str.charAt(en)) && st < en)
        en--;

      if (st < en) {
        char ch = str.charAt(st);
        str.setCharAt(st, str.charAt(en));
        str.setCharAt(en, ch);
      }
      st++;
      en--;
    }

    return str.toString();
  }

  public static boolean isVowel(char ch) {
    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
      return true;
    if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
      return true;

    return false;
  }

  // ~~~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    String res = reverseVowels(str);
    System.out.println(res);
  }
}
