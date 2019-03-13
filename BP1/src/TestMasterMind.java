/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           BP1 Test MasterMind
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
// Online Sources:  none
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/**
 * This class contains a few methods for testing methods in the MasterMind
 * class as they are developed. These methods are private since they are only
 * intended for use within this class.
 *
 * @author Jim Williams
 * @author TODO add your name here when you add tests and comment the tests
 *
 */
public class TestMasterMind {

    /**
     * This is the main method that runs the various tests. Uncomment the tests
     * when you are ready for them to run.
     *
     * @param args  (unused)
     */
    public static void main(String[] args) {

        //Milestone 1: Supporting Methods
//        testPromptInt();
//        testIndexOf();  
//        testGenerateHiddenCode();
//        testIsValidCode(); 
//        testPromptForGuess(); 

        //Milestone 2: Playing Game
//        testCountAllHits(); 
//        testDetermineHits();
        //test printBoard by comparing to example output 
        //test main by comparing to example output

        //Milestone 3: Computer Guess
//        testNextCode();  
//        testEnumeratePossibilities();
//        testUpdatePossibilities();     
//        testComputerGuess(); 
    }

    /**
     * This runs some tests on the promptInt method.
     */
    private static void testPromptInt() {
        boolean error = false;

        { //check whether the integer between min and max is returned.
            Scanner in = new Scanner("8\n");
            int expected = 8;
            int result = MasterMind.promptInt(in, "Enter integer: ", 5, 15);
            if ( expected != result) {
                System.out.println("1) testPromptInt expected: " + expected + " result: " + result);
                error = true;
            }
        }

        //suggestions for additional test cases
        //an invalid number before a valid number
        //the first integer was within min and max
        //integers that exactly match min and max
        //leading whitespace before a number
        //a couple of invalid numbers before a correct number

        if (error) {
            System.out.println("testPromptInt failed");
        } else {
            System.out.println("testPromptInt passed");
        }
    }

    /**
     * This runs some tests on the indexOf method.
     */
    private static void testIndexOf() {
        boolean error = false;

        { //check whether the index of 'b' is returned.
            char [] list = {'a', 'A', 'b','B'};
            int expected = 2;
            int result = MasterMind.indexOf( list, 'b');
            if ( expected != result) {
                System.out.println("1) testIndexOf expected: " + expected + " result: " + result);
                error = true;
            }
        }

        //suggestions for additional test cases
        //the character is not in the array
        //the character is repeated several times in the array
        //the character is the first element in the array
        //the character is the last element in the array

        if (error) {
            System.out.println("testIndexOf failed");
        } else {
            System.out.println("testIndexOf passed");
        }
    }

    /**
     * This runs some tests on the generateHiddenCode method.
     */
    private static void testGenerateHiddenCode() {
        boolean error = false;

        {   //"randomly" chooses 3 symbols from the list
            //We know which 3 will be chosen since we set the seed
            Random rand = new Random(123);
            int numPositions = 3;
            char [] symbols = {'A', 'B', 'C', 'D'};
            char [] expected = {'C', 'A', 'D'};
            char [] result = MasterMind.generateHiddenCode( rand, numPositions, symbols);
            if ( !Arrays.equals( expected,  result)) {
                System.out.println("1) testGenerateHiddenCode expected: " + Arrays.toString(expected) + " result: " + Arrays.toString(result));
                error = true;
            }
        }

        //suggestions for additional test cases
        //vary the number of positions
        //vary the number of symbols
        //advanced:
        //  make sure multiple of the same symbol occur periodically
        //  make sure every symbol is eventually chosen
        //  run a bunch of times say 1000 and count all the symbols
        //  chosen and see if the distribution of symbols is fairly uniform.

        if (error) {
            System.out.println("testGenerateHiddenCode failed");
        } else {
            System.out.println("testGenerateHiddenCode passed");
        }
    }

    /**
     * This runs some tests on the isValidCode method.
     */
    private static void testIsValidCode() {
        boolean error = false;

        { //check whether input of 123 is valid
            char[] input = {'1','2','3'};
            char[] symbols = {'0','1','2','3','4'};
            boolean expected = true;
            boolean result = MasterMind.isValidCode(3, symbols, input);
            if ( result != expected) {
                System.out.println("1) testIsValidCode expected: " + expected + " result: " + result);
                error = true;
            }
        }

        //suggestions for additional test cases
        //different length, acceptable and not
        //different symbols, some acceptable some not
        //input with leading and trailing whitespace

        if (error) {
            System.out.println("testIsValidCode failed");
        } else {
            System.out.println("testIsValidCode passed");
        }
    }

    /**
     * This runs some tests on the promptForGuess method.
     */
    private static void testPromptForGuess() {
        boolean error = false;

        {  //check whether input of 123 is correctly read in
            Scanner in = new Scanner("123\n");
            char[] expected = {'1','2','3'};
            char[] symbols = {'0','1','2','3','4'};
            char[] result = MasterMind.promptForGuess(in, "Enter guess:", 3, symbols);
            if ( !Arrays.equals( expected, result)) {
                System.out.println("1) testPromptForGuess expected: " + Arrays.toString(expected) + " result: " + Arrays.toString(result));
                error = true;
            }
        }

        //suggestions for additional test cases
        //wrong length of input
        //a wrong character in the input
        //different length of input
        //different symbols
        //leading and trailing whitespace in the input
        //? as input

        if (error) {
            System.out.println("testPromptForGuess failed");
        } else {
            System.out.println("testPromptForGuess passed");
        }
    }

    /**
     * This runs some tests on the countAllHits method.
     */
    private static void testCountAllHits() {
        boolean error = false;

        { //count the total number of hits
            char[] hiddenCode = {'1','2','3','4'};
            char[] guess = {'1','2','4','3'};
            char[] symbols = {'0','1','2','3','4','5','6'};
            int expected = 4;
            int result = MasterMind.countAllHits(hiddenCode, guess, symbols);
            if ( expected != result) {
                System.out.println("1) testCountAllHits expected: " + expected + " result: " + result);
                error = true;
            }
        }

        //suggestions for additional test cases
        //0 hits
        //1 black hit
        //1 white hit
        //all white hits
        //all black hits

        if (error) {
            System.out.println("testCountAllHits failed");
        } else {
            System.out.println("testCountAllHits passed");
        }
    }

    /**
     * This runs some tests on the determineHits method.
     */
    private static void testDetermineHits() {
        boolean error = false;
        char[] symbols = new char[] {'1', '2', '3', '4', '5', '6'};

        { // 1 black hit, 1 white hit
            char[] code = {'1', '3', '1', '1'};
            char[] guess = {'1', '2', '3', '4'};
            int[] expected = {1, 1};
            int[] result = MasterMind.determineHits(code, guess, symbols);

            if (!Arrays.equals(expected, result)) {
                System.out.println("1) testDetermineHits expected: " + Arrays.toString(expected)
                        + " result: " + Arrays.toString(result));
                error = true;
            }
        }

        { // 4 black hits
            char[] code = {'1', '2', '3', '4'};
            char[] guess = {'1', '2', '3', '4'};
            int[] expected = {4, 0};
            int[] result = MasterMind.determineHits(code, guess, symbols);

            if (!Arrays.equals(expected, result)) {
                System.out.println("2) testDetermineHits expected: " + Arrays.toString(expected)
                        + " result: " + Arrays.toString(result));
                error = true;
            }
        }

        { // 1 black, 1 white hit
            char[] code = {'1', '2', '3', '4'};
            char[] guess = {'1', '1', '2', '2'};
            int[] expected = {1, 1};
            int[] result = MasterMind.determineHits(code, guess, symbols);

            if (!Arrays.equals(expected, result)) {
                System.out.println("3) testDetermineHits expected: " + Arrays.toString(expected)
                        + " result: " + Arrays.toString(result));
                error = true;
            }
        }

        // suggestions for additional test cases
        // 0 hits
        // 1 black hit
        // 1 white hit
        // all white hits
        // all black hits

        if (error) {
            System.out.println("testDetermineHits failed");
        } else {
            System.out.println("testDetermineHits passed");
        }
    }

    /**
     * This runs some tests on the nextCode method.
     */
    private static void testNextCode() {
        boolean error = false;

        {  //tests 6 digits, starting at 0000 and incrementing 1
            char[] symbols = {'0', '1', '2', '3', '4', '5'};
            char[] input = {'0', '0', '0', '0'};
            char[] expected = {'0', '0', '0', '1'};
            char[] result = MasterMind.nextCode(input, symbols);
            if (!Arrays.equals(expected, result)) {
                System.out.println("testNextCode 1 expected=" + Arrays.toString(expected)
                        + " result=" + Arrays.toString(result));
                error = true;
            }
        }

        {  //tests characters, and incrementing to the next from arbitrary sequence 
            char[] symbols = {'A', 'B', 'C', 'D', 'E', 'F'};
            char[] input = {'B', 'B', 'B', 'B'};
            char[] expected = {'B', 'B', 'B', 'C'};
            char[] result = MasterMind.nextCode(input, symbols);
            if (!Arrays.equals(expected, result)) {
                System.out.println("testNextCode 2 expected=" + Arrays.toString(expected)
                        + " result=" + Arrays.toString(result));
                error = true;
            }
        }

        {  //tests characters with carry
            char[] symbols = {'A', 'B', 'C', 'D', 'E', 'F'};
            char[] input = {'B', 'B', 'B', 'F'};
            char[] expected = {'B', 'B', 'C', 'A'};
            char[] result = MasterMind.nextCode(input, symbols);
            if (!Arrays.equals(expected, result)) {
                System.out.println("testNextCode 3 expected=" + Arrays.toString(expected)
                        + " result=" + Arrays.toString(result));
                error = true;
            }
        }

        {  //tests characters and carry for an additional character
            char[] symbols = {'A', 'B', 'C', 'D', 'E', 'F'};
            char[] input = {'F', 'F'};
            char[] expected = {'B', 'A', 'A'};
            char[] result = MasterMind.nextCode(input, symbols);
            if (!Arrays.equals(expected, result)) {
                System.out.println("testNextCode 4 expected=" + Arrays.toString(expected)
                        + " result=" + Arrays.toString(result));
                error = true;
            }
        }

        {  //tests with binary characters
            char[] symbols = {'0', '1'};
            char[] input = {'0', '1'};
            char[] expected = {'1', '0'};
            char[] result = MasterMind.nextCode(input, symbols);
            if (!Arrays.equals(expected, result)) {
                System.out.println("testNextCode 5 expected=" + Arrays.toString(expected)
                        + " result=" + Arrays.toString(result));
                error = true;
            }
        }

        {  //tests with arbitrary symbols, not ordered by Unicode value
            char[] symbols = {'@', '%', '#', '&', '$', '*'};
            char[] input = {'#', '%', '*', '*'};
            char[] expected = {'#', '#', '@', '@'};
            char[] result = MasterMind.nextCode(input, symbols);
            if (!Arrays.equals(expected, result)) {
                System.out.println("testNextCode 6 expected=" + Arrays.toString(expected)
                        + " result=" + Arrays.toString(result));
                error = true;
            }
        }

        // suggestions for additional test cases
        // can you think of any that are not all ready covered?

        if (error) {
            System.out.println("testNextCode failed");
        } else {
            System.out.println("testNextCode passed");
        }
    }

    /**
     * This runs some tests on the enumeratePossibilities method.
     */
    private static void testEnumeratePossibilities() {
        boolean error = false;

        {  //given 2 symbols does this generate all the correct sequences in 
            //expected order?
            char[] symbols = {'0', '1'};
            int numPositions = 2;
            char[][] results = MasterMind.enumeratePossibilities(numPositions, symbols);
            char[][] expected = {{'0', '0'}, {'0', '1'}, {'1', '0'}, {'1', '1'}};

            if (!Arrays.deepEquals(expected, results)) {
                System.out.println("testEnumeratePossibilities 1 Unexpected results");
                System.out.print("  expected:");
                for (int i = 0; i < expected.length; i++) {
                    System.out.print(Arrays.toString(expected[i]));
                }
                System.out.print("\n  results: ");
                for (int i = 0; i < results.length; i++) {
                    System.out.print(Arrays.toString(results[i]));
                }
                System.out.println();
                error = true;
            }
        }

        { //given 3 symbols, out of typical order, does this still generate
            //all sequences in order?
            char[] symbols = {'C', 'A', 'B'};
            int numPositions = 3;
            char[][] results = MasterMind.enumeratePossibilities(numPositions, symbols);
            char[][] expected = {{'C', 'C', 'C'}, {'C', 'C', 'A'}, {'C', 'C', 'B'}, {'C', 'A', 'C'},
                    {'C', 'A', 'A'}, {'C', 'A', 'B'}, {'C', 'B', 'C'}, {'C', 'B', 'A'}, {'C', 'B', 'B'},
                    {'A', 'C', 'C'}, {'A', 'C', 'A'}, {'A', 'C', 'B'}, {'A', 'A', 'C'}, {'A', 'A', 'A'},
                    {'A', 'A', 'B'}, {'A', 'B', 'C'}, {'A', 'B', 'A'}, {'A', 'B', 'B'}, {'B', 'C', 'C'},
                    {'B', 'C', 'A'}, {'B', 'C', 'B'}, {'B', 'A', 'C'}, {'B', 'A', 'A'}, {'B', 'A', 'B'},
                    {'B', 'B', 'C'}, {'B', 'B', 'A'}, {'B', 'B', 'B'}};

            if (!Arrays.deepEquals(expected, results)) {
                System.out.println("testEnumeratePossibilities 2 Unexpected results");
                System.out.print("  expected:");
                for (int i = 0; i < expected.length; i++) {
                    System.out.print(Arrays.toString(expected[i]));
                }
                System.out.print("\n  results: ");
                for (int i = 0; i < results.length; i++) {
                    System.out.print(Arrays.toString(results[i]));
                }
                System.out.println();
                error = true;
            }
        }

        // do you have ideas for additional test cases

        if (error) {
            System.out.println("testEnumeratePossibilities failed");
        } else {
            System.out.println("testEnumeratePossibilities passed");
        }
    }

    /**
     * This runs some tests on the updatePossibilities method.
     */
    private static void testUpdatePossibilities() {
        boolean error = false;

        { // checks whether the guess is eliminated and another possibility that doesn't
            // match hits while leaving the hiddenCode as a possibility.
            char[] symbols = new char[] {'1', '2', '3', '4', '5', '6'};
            char[] guess = {'1', '1', '2', '2'};
            char[] hiddenCode = {'1', '2', '3', '4'};
            int[] hiddenCodeHits = {1, 1};
            char[][] possibilities =
                    {{'1', '1', '1', '1'}, {'1', '1', '2', '2'}, {'1', '2', '3', '4'}};
            char[][] expected = {null, null, {'1', '2', '3', '4'}};
            MasterMind.updatePossibilities(guess, hiddenCodeHits, possibilities, symbols);
            if (!Arrays.deepEquals(expected, possibilities)) {
                System.out
                        .println("1) testUpdatePossibilities expected=" + Arrays.toString(expected)
                                + " possibilities=" + Arrays.toString(possibilities));
                error = true;
            }
        }

        // suggestions for additional test cases
        // full set of possibilities for say 2 symbols, 3 positions
        // is the number of possibilities remaining returned correct

        if (error) {
            System.out.println("testUpdatePossibilities failed");
        } else {
            System.out.println("testUpdatePossibilities passed");
        }
    }

    /**
     * This tests the computer guess's effectiveness by running a bunch of trials
     * and recording how many guesses on average does it take to solve the code.
     * Some descriptive statistics are printed out.
     */
    private static void testComputerGuess() {
        Random rand = new Random(123);

        int numPositions = 4;
        char[] symbols = new char[] {'1', '2', '3', '4', '5', '6'};
        int maxGuesses = 0;
        int minGuesses = Integer.MAX_VALUE;
        int totalGuesses = 0;
        int numTrials = 1000;
        for (int i = 0; i < numTrials; i++) {
            char[] hiddenCode = MasterMind.generateHiddenCode(rand, numPositions, symbols);
            boolean found = false;

            // randomly choose an initial guess
            char[] guess = MasterMind.generateHiddenCode(rand, numPositions, symbols);

            int guesses = 1;
            char[][] possibilities = MasterMind.enumeratePossibilities(numPositions, symbols);
            do {
                if (Arrays.equals(guess, hiddenCode)) {
                    found = true;
                } else {
                    int[] result = MasterMind.determineHits(hiddenCode, guess, symbols);
                    MasterMind.updatePossibilities(guess, result, possibilities, symbols);
                    guess = MasterMind.computerGuess(possibilities);
                    guesses++;
                }
            } while (!found);
            totalGuesses += guesses;
            if (guesses > maxGuesses)
                maxGuesses = guesses;
            if (guesses < minGuesses)
                minGuesses = guesses;
        }
        System.out.printf("testComputerGuess: min %d, max %d, numTrials %d, avg %.2f\n", minGuesses, maxGuesses,
                numTrials, totalGuesses / (double) numTrials);

        // do you have ideas for additional test cases
    }
}