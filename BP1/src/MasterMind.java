/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           BP1 MasterMind
// Files:           MasterMing.java, TestMasterMind.java, Config.java
// Course:          CS 200 Spring 2019
//
// Author:          Sarah Quinn
// Email:           squinn4@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here.  Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates
// strangers, etc do.  If you received no outside help from either type of
// source, then please explicitly indicate NONE.
//
// Persons:         none
// Online Sources:  https://crunchify.com/java-simple-way-to-convert-string-to-char-array/
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * MasterMind program.
 * This class runs the mastermind program.
 * The test methods and config variables are in other files.
 * All steps to run the program are encompassed in this class
 * (initializing game, generating a code to be guessed,
 * prompting the user for parameters, guesses, hints, etc.)
 *
 * @author Sarah Quinn
 */
public class MasterMind {

  /**
   * This method gives the user a prompt.
   * It then corrects the user if a number is not in range (0 to 10).
   * It will ask again if an improper input is added.
   * It returns the value once the user enters a valid value.
   *
   */
  public static int promptInt(Scanner input, String prompt, int min, int max) {
    int userNum = 0;
    do {
      System.out.print(prompt);
      if (!input.hasNextInt()) {                              // checks that user value is numerical
        input.next();
        System.out.println("Expected value between 0 and 10.");
      }
      else {
        userNum = input.nextInt();
      }
       if (userNum < min || userNum > max) {                     //checks if user value is within range
          System.out.println("Expected value between 0 and 10.");
        }
       else {
          break;
        }
    }while (true);
    //input.nextLine();       //takes away new line character after user input number
    return userNum;
  }

  /**
   * This method evaluates whether of not a particular character is in a passed array.
   * If the character is present it will return the location, if not it will return -1.
   * The location returned will be the first instance of that character.
   */
  public static int indexOf(char[] arr, char ch) {
    int i;
    int matchLocation = -1;
    if (!(arr == null) && arr.length > 0) {       //ensures that the array is not empty
      for (i = 0; i < arr.length; i++) {          //checks for relevant character in each index of array
        if (arr[i] == ch) {
          matchLocation = i;                      //ends after first location of relevant character is found
          break;
        }
      }
    }
    return matchLocation;
  }

  /**
   *  This method creates a random code based on the array of valid symbols.
   *  The size of the array is based on the parameter of numPositions passed in.
   *  The array with the randomized code of that given length is returned.
   *
   */
  public static char[] generateHiddenCode(Random rand, int numPositions, char[] symbols) {
    int i;
    char[] hiddenCode = new char[numPositions];
    for (i = 0; i < numPositions; i++) {
      hiddenCode[i] = symbols[rand.nextInt(symbols.length)];  //assigns random char in symbols array to each position
    }
    return hiddenCode;
  }

  /**
   ** This method evaluates whether the code array passed in is valid.
   * It checks whether all the symbols in the code array are valid symbols,
   * i.e. symbols that are in the designated symbols array.
   * It returns a boolean value that indicated whether the passed code includes
   * symbols that are all in the symbols array.
   */
  public static boolean isValidCode(int numPositions, char[] symbols, char[] code) {
    boolean validity = true;
    int i;
    if (numPositions != code.length) {
      validity = false;
    }
    else {
      for (i = 0; i < numPositions; i++) {
        if ((indexOf(symbols, code[i])) < 0) {         //checks indexOf method to check if valid character was used
          validity = false;
          break;
        }
      }
    }
    return validity;
  }

  /**
   * This method asks the user for a guess. It then verifies that the code is the valid by calling the the
   * previous isCodeValid method. It will tell the user the guess is invalid and re-prompt the user until
   * a valid input is entered.
   *
   */
  public static char[] promptForGuess(Scanner input, String prompt, int numPositions, char[] symbols) {
    char[] userCodeEntered;
    do {
      System.out.print(prompt);
      String enteredString = input.nextLine();
      enteredString = enteredString.trim();
      enteredString = enteredString.replaceAll(" ", "");
      userCodeEntered = enteredString.toCharArray(); // converts the user string to a char array that can run through isValidCode
      if (enteredString.equals("?")) {
        return null;
      }
      if (isValidCode(numPositions, symbols, userCodeEntered)) //ends the program is the entered code is valid
        break;
      else
        System.out.println("Invalid Entry");
    } while (true);                                           //makes the method repeat until broken by valid code
    return userCodeEntered;
  }


  /**
   * Returns the sum of "black hits" and "white hits" between the hiddenCode
   * and guess.  A "black hit" indicates a matching symbol in the same position in the
   * hiddenCode and guess.  A "white hit" indicates a matching symbol but different
   * position in the hiddenCode and guess that is not already accounted for with other
   * hits.
   * <p>
   * Algorithm to determine the total number of hits:
   * <p>
   * Count the number of each symbol in the hiddenCode, and separately count the
   * number of each symbol in the guess. For each symbol, determine the minimum of the
   * count of that symbol in the hiddenCode and the count of that symbol found in the guess.
   * The total number of hits, black and white, is the sum of these minimums for
   * all the symbols.
   * <p>
   * Algorithm based on Donald Knuth, 1976, The Computer As Master Mind,
   * J. Recreational Mathematics, Vol. 9(1)
   * <p>
   * Suggestion: To do the count, create an array of int the length of the number of symbols.
   * For each symbol use the indexOf method you wrote to determine the index in the array to increment
   * the symbols count.
   *
   * @param hiddenCode The code hidden from the user.
   * @param guess      The user's guess of the code.
   * @param symbols    The possible symbols in the hiddenCode and guess.
   * @return The total number of hits.
   */
  public static int countAllHits(char[] hiddenCode, char[] guess, char[] symbols) {
    return 0; //TODO replace
  }

  /**
   * Returns the number of each kind of hit the guess has with the code.
   * The results are an array of length Config.HITS_ARRAY_LENGTH.
   * The count of the number of symbols in the guess that correspond in position
   * and symbol with the hidden code are recorded in the Config.BLACK_HITS_INDEX
   * position within the result array. The number of symbols that match between
   * the guess and the hidden code but are in different positions and not otherwise
   * counted are recorded in the Config.WHITE_HITS_INDEX within the result array.
   * <p>
   * Algorithm:
   * Count the number of black hits - the number of positions in the guess and hidden code
   * that have the same symbol.
   * Count the total number of hits using countAllHits and subtract to find the number
   * of white hits. White hits are symbols that match between guess and hiddenCode that
   * are not in the same position and not already accounted for with other hits.
   *
   * @param hiddenCode The code the user is trying to guess.
   * @param guess      The user's guess.
   * @param symbols    The possible symbols in the hiddenCode and guess.
   * @return The array containing the number of "black hits" and "white hits".
   */
  public static int[] determineHits(char[] hiddenCode, char[] guess, char[] symbols) {
    return null; //TODO replace
  }

  /**
   * Prints out the game board showing the guesses and the corresponding hits.
   * See output examples.
   * Game board example:
   * 6) [4, 5, 2, 4] BBBB
   * 5) [4, 4, 2, 5] BBWW
   * 4) [4, 4, 2, 4] BBB
   * 3) [1, 3, 3, 3]
   * 2) [2, 3, 3, 3] W
   * 1) [1, 1, 2, 2] B
   * <p>
   * Only rows with non-null guesses are shown. The number on the left is the guess,
   * so the guesses are shown from last to first.
   * Looking at one line in detail:
   * 5) [4, 4, 2, 5] BBWW
   * ^^  2 white hits, the 2nd 4 and 5 (we don't know which until solved)
   * ^^ 2 black hits, the 1st 4 and 2 (we don't know which until solved)
   * ^^^^^^^^^^^^ the guess output using Arrays.toString()
   * ^^ the guess number
   * The symbols B and W are the characters from Config.BLACK_HIT_SYMBOL and
   * Config.WHITE_HIT_SYMBOL. All the black hits will be shown before the white hits.
   * The length of all arrays should be determined using the array .length attribute, not
   * assumed from a constant.
   *
   * @param guesses The array of guesses. Each row is a guess or null (meaning no guess
   *                yet).
   * @param hits    The array of hits. Each row is the hits from determineHits for
   *                the corresponding guess in the parallel guesses array, or null.
   */
  public static void printBoard(char[][] guesses, int[][] hits) {
  }

  /**
   * The MasterMind main method that contains the welcome and the main game
   * loop. Carefully examine example output to help answer questions on prompts and
   * how this program should work.
   * <p>
   * Algorithm:
   * Use appropriate constants from Config. For example, to create an array use Config.MAX_GUESSES,
   * but once an array exists don't use the constants but use the array .length attribute.
   * Determine seed or not (call promptInt with Integer.MIN_VALUE, Integer.MAX_VALUE)
   * Display welcome message.
   * Generate the hidden code (call generateHiddenCode)
   * Create 2D arrays for guesses and corresponding hits. Initially every row is null
   * until guesses are made and hits are determined for a guess.
   * (milestone 3) enumerate all the possibilities (call enumeratePossibilities)
   * Loop
   * Prompt for guess (call promptForGuess)
   * (milestone 3) If guess is null then call computerGuess
   * Determine how many black and white hits (call determineHits)
   * Output the board (call printBoard)
   * (milestone 3) Output number of remaining possibilities
   * End loop when won or lost
   * Output won or lost message.
   *
   * @param args unused
   */
  public static void main(String[] args) {
    //Scanner scnr = new Scanner(System.in);
    //String prompt = "Enter input: ";
    //System.out.print(promptInt(scnr, prompt, 0, 10));

    //int CODE_POSITIONS;
   // char arrOfChar[] = new char[CODE_POSITIONS];
    //char lookingForSymbol = 'c';
    //indexOf(arrOfChar, lookingForSymbol);

    //Random randGen = new Random();
    //generateHiddenCode(randGen, CODE_POSITIONS, CODE_SYMBOLS)


  }


  /**
   * Determine the next code in sequence given the ordered symbols and
   * a code. See MasterMindTests.testNextCode() method for various test cases.
   * Most significant positions are the left most, just like for a number
   * such as 1234, where 1 is the most significant digit.
   * <p>
   * Consider how you would add 1 to 199. Work out on paper.  Now try with
   * the symbols A, B, C in that order. If you added B to BC what would
   * the result be? CA?
   * <p>
   * Algorithm:
   * Loop from least significant position to the most significant
   * Find the index of the symbol
   * if least significant position
   * if last symbol then
   * set to first symbol and carry
   * else set next symbol
   * else
   * if carry and last symbol
   * set to first symbol and keep carry set
   * else if carry and not last symbol
   * set next symbol, clear carry
   * else
   * no carry, so keep symbol
   * end if
   * end if
   * End loop
   * If carry then prepend an additional symbol. Since, in decimal, leading 0's
   * are assumed then we assume the same for any symbols. So, we would prepend
   * the 2nd symbol, in decimal a 1.
   *
   * @param code    A code with the symbols.
   * @param symbols The symbols to use for the code.
   * @return The next code in the sequence based on the order of the symbols.
   */
  public static char[] nextCode(char[] code, char[] symbols) {
    return null; //TODO replace
  }

  /**
   * List all the possibilities (permutations) of codes for the specified number of
   * positions and the provided codes.
   * <p>
   * Algorithm:
   * Create an array the length being the number of possibilities (permutations).
   * For example, 3 symbols in each of 4 positions means there are 3*3*3*3 or 3^4
   * which equals 81 permutations.
   * Determine the "first" code (all positions having the same first symbol).
   * For each permutation call nextCode to generate the next code from the current.
   * <p>
   * If numPositions is less than or equal to 0 or symbols is 0 length or null
   * then return null.
   *
   * @param numPositions The number of positions in a code.
   * @param symbols      The possible symbols used in a code.
   * @return An array of all the possible codes that can be generated from the
   * symbols for the numPositions.
   */
  public static char[][] enumeratePossibilities(int numPositions, char[] symbols) {
    return null; //TODO replace
  }

  /**
   * Updates the remaining possibilities array and returns the number
   * of possibilities.
   * The hiddenCodeHits parameter contains the black and white hits when the guess is compared
   * to the code. The possibilities parameter contains all the possible remaining candidates
   * for the hidden code. Determine the hits for each non-null guess when compared to each
   * possibility and only keep the possibilities that match the result parameter hits.
   * Remove a possibility from the array of possibilities by setting it to null.
   *
   * @param guess          The current guess
   * @param hiddenCodeHits The hits when guess is compared to hiddenCode.
   * @param possibilities  The remaining codes that contain the hidden code.
   * @param symbols        The potential symbols in the codes.
   * @return The number of remaining possibilities.
   */
  public static int updatePossibilities(char[] guess, int[] hiddenCodeHits, char[][] possibilities,
                                        char[] symbols) {
    return 0; //TODO replace
  }

  /**
   * Select the first remaining code (lowest index) from possibilities.
   * If no codes are left then return null.
   *
   * @param possibilities The array of remaining possible codes.
   * @return A code from the array.
   */
  public static char[] computerGuess(char[][] possibilities) {
    return null; //TODO replace
  }
}