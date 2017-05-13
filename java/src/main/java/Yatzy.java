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

    public static int scoreSmallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int scoreLargeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int scoreFullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
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
        for (int index = 5; index >= 0; index--)
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
}



