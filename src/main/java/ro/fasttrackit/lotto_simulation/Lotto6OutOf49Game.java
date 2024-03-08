package ro.fasttrackit.lotto_simulation;

import java.util.Arrays;
import java.util.Random;

public class Lotto6OutOf49Game {
    public static void main(String[] args) {
        int[] agencyTicket = getAgencyTicket();
        int counterNumberOfTicketsPlayed = 0;
        int numbersMatched;
        boolean fourWinning = false;
        boolean fiveWinning = false;

        do {
            numbersMatched = 0;
            int[] userTicket = getUserTicket();
            for (int agencyNumber : agencyTicket) {
                for (int userNumber : userTicket) {
                    if (agencyNumber == userNumber) {
                        numbersMatched++;
                    }
                }
            }
            counterNumberOfTicketsPlayed++;
            if (numbersMatched == 4 && !fourWinning) {
                fourWinning = true;
                System.out.println("My ticket was matching " + numbersMatched +
                        " of the agency numbers, after " + counterNumberOfTicketsPlayed + " attempts");
                System.out.println("My ticket numbers are: " + Arrays.toString(userTicket));
                System.out.println("Agency numbers are: " + Arrays.toString(agencyTicket));
            }
            if (numbersMatched == 5 && !fiveWinning) {
                fiveWinning = true;
                System.out.println("My ticket was matching " + numbersMatched +
                        " of the agency numbers, after " + counterNumberOfTicketsPlayed + " attempts");
                System.out.println("My ticket numbers are: " + Arrays.toString(userTicket));
                System.out.println("Agency numbers are: " + Arrays.toString(agencyTicket));
            }
            if (numbersMatched == 6) {
                System.out.println("My ticket was matching all " + numbersMatched +
                        " of the agency numbers, after " + counterNumberOfTicketsPlayed + " attempts");
                System.out.println("My ticket numbers are: " + Arrays.toString(userTicket));
                System.out.println("Agency numbers are: " + Arrays.toString(agencyTicket));
            }
        }
        while (numbersMatched < 6);
    }

    public static int[] getAgencyTicket() {
        int[] agencyNumbersArray = getRandomUniqueNumberFrom1to49();
        return agencyNumbersArray;
    }

    public static int[] getUserTicket() {
        int[] userNumbersArray = getRandomUniqueNumberFrom1to49();
        return userNumbersArray;
    }

    public static int[] getRandomUniqueNumberFrom1to49() {
        int[] randomNumbers = new int[6];
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int randomNumber;
            do {
                randomNumber = random.nextInt(49) + 1;
            } while (contains(randomNumbers, randomNumber));
            randomNumbers[i] = randomNumber;
        }
        return randomNumbers;
    }

    private static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }
}