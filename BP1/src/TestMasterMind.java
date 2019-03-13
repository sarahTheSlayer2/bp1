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
 * This class runs tests of the Mastermind class. It is designed to ensure the program runs as desired when
 * expected user inputs are given and when unexpected inputs are given.
 *
 * @author Jim Williams
 * @author Sarah Quinn
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
        testPromptInt();
        testIndexOf();
        testGenerateHiddenCode();
        testIsValidCode();
        testPromptForGuess();

        //Milestone 2: Playing Game
//        testCountAllHits();
//        testDetermineHits();
//        test printBoard by comparing to example output
//        test main by comparing to example output

        //Milestone 3: Computer Guess
//        testNextCode();  
//        testEnumeratePossibilities();
//        testUpdatePossibilities();     
//        testComputerGuess(); 
    }

    /**
     * This method test promptInt for single and multiple invalid inputs, boundaries of the range,
     * and within range.
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

        { //check whether properly re-prompts if the first entry is invalid.
            Scanner in = new Scanner("sar\n7");
            int expected = 7;
            int result = MasterMind.promptInt(in, "Enter integer: ", 5, 15);
            if ( expected != result) {
                System.out.println("2) testPromptInt expected: " + expected + " result: " + result);
                error = true;
            }
        }

        { //check whether works for inclusive range.
            Scanner in = new Scanner("5\n");
            int expected = 5;
            int result = MasterMind.promptInt(in, "Enter integer: ", 5, 15);
            if ( expected != result) {
                System.out.println("3) testPromptInt expected: " + expected + " result: " + result);
                error = true;
            }
        }

        { //check whether properly works with leading whitespace.
            Scanner in = new Scanner("   7");
            int expected = 7;
            int result = MasterMind.promptInt(in, "Enter integer: ", 5, 15);
            if ( expected != result) {
                System.out.println("4) testPromptInt expected: " + expected + " result: " + result);
                error = true;
            }
        }

        { //check whether properly re-prompts after multiple invalid entries.
            Scanner in = new Scanner("20\n2\n5");
            int expected = 5;
            int result = MasterMind.promptInt(in, "Enter integer: ", 5, 15);
            if ( expected != result) {
                System.out.println("5) testPromptInt expected: " + expected + " result: " + result);
                error = true;
            }
        }

        if (error) {
            System.out.println("testPromptInt failed");
        } else {
            System.out.println("testPromptInt passed");
        }
    }

    /**
     * This method tests the IndexOf method for the invalid indexes and valid indexes in
     * the first, middle, and last positions of the array.
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

        { //check whether value of -1 is returned for char not in array.
            char [] list = {'a', 'A', 'b','B'};
            int expected = -1;
            int result = MasterMind.indexOf( list, 'f');
            if ( expected != result) {
                System.out.println("2) testIndexOf expected: " + expected + " result: " + result);
                error = true;
            }
        }

        { //check whether the first index is returned when the character is present twice.
            char [] list = {'a', 'b', 'b','B'};
            int expected = 1;
            int result = MasterMind.indexOf( list, 'b');
            if ( expected != result) {
                System.out.println("1) testIndexOf expected: " + expected + " result: " + result);
                error = true;
            }
        }

        { //check whether the index of the first char is returned.
            char [] list = {'a', 'A', 'b','B'};
            int expected = 0;
            int result = MasterMind.indexOf( list, 'a');
            if ( expected != result) {
                System.out.println("3) testIndexOf expected: " + expected + " result: " + result);
                error = true;
            }
        }

        { //check whether the index the last char is returned.
            char [] list = {'a', 'A', 'b','B'};
            int expected = 3;
            int result = MasterMind.indexOf( list, 'B');
            if ( expected != result) {
                System.out.println("4) testIndexOf expected: " + expected + " result: " + result);
                error = true;
            }
        }

        if (error) {
            System.out.println("testIndexOf failed");
        } else {
            System.out.println("testIndexOf passed");
        }
    }

    /**
     * This method tests the method generateHiddenCode for several different lengths and number of symbols.
     */
    private static void testGenerateHiddenCode() {
        boolean error = false;

        {   //Tests that 3 symbols are "randomly" (though here seeded) chosen from a list of 4 symbols.
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

        {   //Tests that 2 symbols are "randomly" (though here seeded) chosen from a list of 4 symbols.
            Random rand = new Random(123);
            int numPositions = 2;
            char [] symbols = {'A', 'B', 'C', 'D'};
            char [] expected = {'C', 'A'};
            char [] result = MasterMind.generateHiddenCode( rand, numPositions, symbols);
            if ( !Arrays.equals( expected,  result)) {
                System.out.println("2) testGenerateHiddenCode expected: " + Arrays.toString(expected) + " result: " + Arrays.toString(result));
                error = true;
            }
        }

        {   //Tests that 3 symbols are "randomly" (though here seeded) chosen from a list of 6 symbols.
            Random rand = new Random(123);
            int numPositions = 3;
            char [] symbols = {'A', 'B', 'C', 'D', 'E', 'F'};
            char [] expected = {'C', 'C', 'C'};
            char [] result = MasterMind.generateHiddenCode( rand, numPositions, symbols);
            if ( !Arrays.equals( expected,  result)) {
                System.out.println("3) testGenerateHiddenCode expected: " + Arrays.toString(expected) + " result: " + Arrays.toString(result));
                error = true;
            }
        }

        if (error) {
            System.out.println("testGenerateHiddenCode failed");
        } else {
            System.out.println("testGenerateHiddenCode passed");
        }
    }

    /**
     * This method tests the method isValidCode for correct and incorrect number of inputs as well as
     * valid and invalid inputs.
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

        { //tests response of not enough inputs
            char[] input = {'1','2'};
            char[] symbols = {'0','1','2','3','4'};
            boolean expected = false;
            boolean result = MasterMind.isValidCode(3, symbols, input);
            if ( result != expected) {
                System.out.println("1) testIsValidCode expected: " + expected + " result: " + result);
                error = true;
            }
        }

        { //tests response of too many inputs
            char[] input = {'1','2','3','4'};
            char[] symbols = {'0','1','2','3','4'};
            boolean expected = false;
            boolean result = MasterMind.isValidCode(3, symbols, input);
            if ( result != expected) {
                System.out.println("1) testIsValidCode expected: " + expected + " result: " + result);
                error = true;
            }
        }
        { //tests response of invalid symbol
            char[] input = {'1','2','3','5'};
            char[] symbols = {'0','1','2','3','4'};
            boolean expected = false;
            boolean result = MasterMind.isValidCode(3, symbols, input);
            if ( result != expected) {
                System.out.println("1) testIsValidCode expected: " + expected + " result: " + result);
                error = true;
            }
        }

        if (error) {
            System.out.println("testIsValidCode failed");
        } else {
            System.out.println("testIsValidCode passed");
        }
    }

    /**
     * This method tests the promptForGuess method to make sure that invalid inputs are re-prompted correctly,
     * invalid characters are re-prompted, and inputs with white spaces are read properly.
     * Also that the ? option yields the correct response.
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

        {  //To check if successfully ignore first two invalid inputs and save third input if valid.
            Scanner in = new Scanner("1234\n2423\n123");
            char[] expected = {'1','2','3'};
            char[] symbols = {'0','1','2','3','4'};
            char[] result = MasterMind.promptForGuess(in, "Enter guess:", 3, symbols);
            if ( !Arrays.equals( expected, result)) {
                System.out.println("1) testPromptForGuess expected: " + Arrays.toString(expected) + " result: " + Arrays.toString(result));
                error = true;
            }
        }

        {  //to check if properly re-prompts after invalid character
            Scanner in = new Scanner("12a4\n124");
            char[] expected = {'1','2','4'};
            char[] symbols = {'0','1','2','3','4'};
            char[] result = MasterMind.promptForGuess(in, "Enter guess:", 3, symbols);
            if ( !Arrays.equals( expected, result)) {
                System.out.println("1) testPromptForGuess expected: " + Arrays.toString(expected) + " result: " + Arrays.toString(result));
                error = true;
            }
        }

        {  //check whether input with leading, middle, and ending whitespace is read properly
            Scanner in = new Scanner(" 1 2 3 ");
            char[] expected = {'1','2','3'};
            char[] symbols = {'0','1','2','3','4'};
            char[] result = MasterMind.promptForGuess(in, "Enter guess:", 3, symbols);
            if ( !Arrays.equals( expected, result)) {
                System.out.println("1) testPromptForGuess expected: " + Arrays.toString(expected) + " result: " + Arrays.toString(result));
                error = true;
            }
        }

        {  //checks if help character is read correctly
            Scanner in = new Scanner("?");
            String expected = "null";
            char[] symbols = {'0','1','2','3','4'};
            if (MasterMind.promptForGuess(in, "Enter guess:", 3, symbols) != null) {
                System.out.println("1) testPromptForGuess expected: " + expected);
                error = true;
            }
        }

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