import java.util.Arrays;

public class Yatzy {

    int chance(int[] dice) {
        int total = 0;
        for (int die : dice) {
            total += die;
        }
        return total;
    }

    int scoreYatzy(int[] dice) {
        int firstDie = dice[0];
        for (int die : dice) {
            if (die != firstDie) {
                return 0;
            }
        }
        return 50;
    }

    int scoreOnes(int[] dice) {
        return sumUpAllDieOfType(1, dice);
    }

    int scoreTwos(int[] dice) {
        return sumUpAllDieOfType(2, dice);
    }

    int scoreThrees(int[] dice) {
        return sumUpAllDieOfType(3, dice);
    }

    int scoreFours(int[] dice) {
        return sumUpAllDieOfType(4, dice);
    }

    int scoreFives(int[] dice) {
        return sumUpAllDieOfType(5, dice);
    }

    int scoreSixes(int[] dice) {
        return sumUpAllDieOfType(6, dice);
    }

    int scorePair(int[] dice) {
        return scoreNOfAKind(2, dice);
    }

    int scoreThreeOfAKind(int[] dice) {
        return scoreNOfAKind(3, dice);
    }

    int scoreFourOfAKind(int[] dice) {
        return scoreNOfAKind(4, dice);
    }

    public int scoreTwoPair(int[] dice) {
        int[] amountOfEachDie = getAmountOfEachDie(dice);
        int score = 0;
        int amountOfPairs = 0;
        for (int index = 5; index >= 0; index--) {
            if (amountOfEachDie[index] >= 2) {
                score += (index + 1) * 2;
                amountOfPairs++;
            }
        }
        if(amountOfPairs <2){
            score = 0;
        }
        return score;
    }

    static int scoreSmallStraight(int[] dice) {
        if (isAStraight(dice, true)){
            return 15;
        }else {
            return 0;
        }
    }

    public static int scoreLargeStraight(int[] dice) {
        if (isAStraight(dice, false)){
            return 20;
        }else {
            return 0;
        }
    }

    public int scoreFullHouse(int[] dice) {

        int[] amountOfEachDie= getAmountOfEachDie(dice);
        boolean hasDoubles = false;
        boolean hasTriples = false;
        int score = 0;
        for (int index = 0; index < amountOfEachDie.length; index++) {
            if(amountOfEachDie[index] == 2){
                hasDoubles = true;
                score += (index + 1) * 2;
            }else if(amountOfEachDie[index] == 3){
                hasTriples = true;
                score += (index + 1) * 3;
            }
        }
        if(hasDoubles && hasTriples){
            return score;
        }else {
            return 0;
        }
    }

    private int sumUpAllDieOfType(int eyes, int[] dice) {
        int sum = 0;
        for (int die : dice) {
            if (die == eyes) {
                sum += eyes;
            }
        }
        return sum;
    }

    private int scoreNOfAKind(int n, int[] dice) {
        int[] amountOfEachDie = getAmountOfEachDie(dice);
        for (int index = amountOfEachDie.length -1; index >= 0; index--)
            if (amountOfEachDie[index] >= n) {
                return (index + 1) * n;
            }
        return 0;
    }

    private int[] getAmountOfEachDie(int[] dice) {
        int[] amountOfEachDie = new int[6];
        for (int die : dice) {
            amountOfEachDie[die - 1]++;
        }
        return amountOfEachDie;
    }

    private static boolean isAStraight(int[] dice, boolean small) {
        Arrays.sort(dice);
        int n = small? 1 : 2;
        for (int i = 0; i < dice.length; i++) {
            if(dice[i] != i + n){
                return false;
            }
        }
        return true;
    }
}



