package palindromeNumber;

public class palindrome {

  public static void main(String args[]) {
    int x = 10301;
    boolean isPalindrome = true;

    String numberString = Integer.toString(x);
    int size = numberString.length();
    int[] arr = new int[size];

    int i = 0;
    while (x > 0) {
      int remainder = x % 10;
      x = x / 10;

      arr[i++] = remainder;
    }

    for (int j = 0; j < size; j++) {
      System.out.println(arr[j]);
    }

    for (int l = 0; l <= size / 2; l++) {
      if (arr[l] != arr[size - 1 - l]) {
        isPalindrome = false;
      }
    }
    System.out.println(isPalindrome);
  }
}
