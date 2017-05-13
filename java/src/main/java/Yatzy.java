public class Yatzy {

//    private int[] dice;
//
//    Yatzy(int d1, int d2, int d3, int d4, int d5)
//    {
//        dice = new int[5];
//        dice[0] = d1;
//        dice[1] = d2;
//        dice[2] = d3;
//        dice[3] = d4;
//        dice[4] = d5;
//    }

    int chance(int[] dice)
    {
        int total = 0;
        for (int die : dice) {
            total += die;
        }
        return total;
    }

    int scoreYatzy(int[] dice)
    {
        int firstDie = dice[0];
        for (int die : dice) {
            if(die != firstDie){
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

    int scoreFives(int[] dice)
    {
        return sumUpAllDieOfType(5, dice);
    }

    int scoreSixes(int[] dice)
    {
        return sumUpAllDieOfType(6, dice);
    }

    int scorePair(int[] dice) {
        return scoreNOfAKind(2, dice);
    }

    private int scoreNOfAKind(int n, int[] dice) {
        int[] amountOfEachDie = getAmountOfEachDie(dice);
        for (int index = 5; index >= 0; index--)
            if (amountOfEachDie[index] >= n) {
                return (index + 1) * n;
            }
        return 0;
    }

    public static int scoreTwoPair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }        
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int scoreFourOfAKind(int _1, int _2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[_1-1]++;
        tallies[_2-1]++;
        tallies[d3-1]++;
        tallies[d4-1]++;
        tallies[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int scoreThreeOfAKind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] t;
        t = new int[6];
        t[d1-1]++;
        t[d2-1]++;
        t[d3-1]++;
        t[d4-1]++;
        t[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public static int scoreSmallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int scoreLargeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int scoreFullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }

    private int sumUpAllDieOfType(int eyes, int[] dice) {
        int sum = 0;
        for (int die : dice) {
            if(die == eyes){
                sum += eyes;
            }
        }
        return sum;
    }

    private int[] getAmountOfEachDie(int[] dice) {
        int[] amountOfEachDie = new int[6];
        for (int die : dice) {
            amountOfEachDie[die -1]++;
        }
        return amountOfEachDie;
    }

}



