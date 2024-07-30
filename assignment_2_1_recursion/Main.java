/**
 * The main class of the program.
 */
public class Main {
  /**
   * The recursive helper function to find the minimum number
   */
  private static int getMinNumber(int minNumber, int[] numbers, int index) {
    int lastIndex = numbers.length - 1;
    /**
     * Because there's nothing left to iterate over
     */
    if (index > lastIndex)
      return minNumber;

    int currentNumber = numbers[index];
    int nextIndex = index + 1;

    /**
     * We continue searching for the minimum number and pass the new minimum
     * number to the next call.
     */
    if (currentNumber < minNumber)
      return getMinNumber(currentNumber, numbers, nextIndex);
    /**
     * We do not update the minimum number, and we continue searching for the
     * next smallest number.
     */
    return getMinNumber(minNumber, numbers, nextIndex);
  }

  private static int recursivelyFindMinNumber(int[] numbers) throws Exception {
    /**
     * There cannot be a minimum if there are no numbers, so we simply throw an
     * error.
     */
    if (numbers.length == 0)
      throw new Exception("No items in the array.");

    /**
     * We start looking for the minimum number, starting from the first position
     * in the array.
     */
    int firstNumber = numbers[0];
    return getMinNumber(firstNumber, numbers, 0);
  }

  /**
   * Finds the min number in an array and prints it.
   */
  public static void main(String[] args) throws Exception {
    int numbers[] = { 5, 9, 1, 38, -322, 8383482 };
    int min = recursivelyFindMinNumber(numbers);
    System.out.println("min: " + min);
  }
}