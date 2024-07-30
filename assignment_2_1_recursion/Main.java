public class Main {
  private static int getMinNumber(int minNumber, int[] numbers, int index) {
    int lastIndex = numbers.length - 1;
    /**
     * Because there's nothing left to iterate over
     */
    if (index > lastIndex)
      return minNumber;

    int currentNumber = numbers[index];
    int nextIndex = index + 1;

    if (currentNumber < minNumber)
      return getMinNumber(currentNumber, numbers, nextIndex);
    return getMinNumber(minNumber, numbers, nextIndex);
  }

  private static int recursivelyFindMinNumber(int[] numbers) throws Exception {
    if (numbers.length == 0)
      throw new Exception("No items in the array.");

    int firstNumber = numbers[0];
    return getMinNumber(firstNumber, numbers, 0);
  }

  public static void main(String[] args) throws Exception {
    int numbers[] = { 5, 9, 1, 38, -322, 8383482 };
    int min = recursivelyFindMinNumber(numbers);
    System.out.println("min: " + min);
  }
}