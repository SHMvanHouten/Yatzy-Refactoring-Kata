import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        Yatzy game = new Yatzy();
        int expected = 15;
        int actual = game.chance(new int[]{2,3,4,5,1});
        assertEquals(expected, actual);
        assertEquals(16, game.chance(new int[]{3,3,4,5,1}));
    }

    @Test public void yatzy_scores_50() {
        Yatzy game = new Yatzy();
        int expected = 50;
        int actual = game.scoreYatzy(new int[]{4,4,4,4,4});
        assertEquals(expected, actual);
        assertEquals(50, game.scoreYatzy(new int[]{6,6,6,6,6}));
        assertEquals(0, game.scoreYatzy(new int[]{6,6,6,6,3}));
    }

    @Test public void test_1s() {
        Yatzy game = new Yatzy();
        assertTrue(game.scoreOnes(new int[]{1,2,3,4,5}) == 1);
        assertEquals(2, game.scoreOnes(new int[]{1,2,1,4,5}));
        assertEquals(0, game.scoreOnes(new int[]{6,2,2,4,5}));
        assertEquals(4, game.scoreOnes(new int[]{1,2,1,1,1}));
    }

    @Test
    public void test_2s() {
        Yatzy game = new Yatzy();
        assertEquals(4, game.scoreTwos(new int[]{1,2,3,2,6}));
        assertEquals(10, game.scoreTwos(new int[]{2,2,2,2,2}));
    }

    @Test
    public void test_threes() {
        Yatzy game = new Yatzy();
        assertEquals(6, game.scoreThrees(new int[]{1,2,3,2,3}));
        assertEquals(12, game.scoreThrees(new int[]{2,3,3,3,3}));
    }

    @Test
    public void fours_test() {
        Yatzy game = new Yatzy();
        assertEquals(12, game.scoreFours(new int[]{4,4,4,5,5}));
        assertEquals(8, game.scoreFours(new int[]{4,4,5,5,5}));
        assertEquals(4, game.scoreFours(new int[]{4,5,5,5,5}));
    }

    @Test
    public void fives() {
        Yatzy game = new Yatzy();
        assertEquals(10, game.scoreFives(new int[]{4,4,4,5,5}));
        assertEquals(15, game.scoreFives(new int[]{4,4,5,5,5}));
        assertEquals(20, game.scoreFives(new int[]{4,5,5,5,5}));
    }

    @Test
    public void sixes_test() {
        Yatzy game = new Yatzy();
        assertEquals(0, game.scoreSixes(new int[]{4,4,4,5,5}));
        assertEquals(6, game.scoreSixes(new int[]{4,4,6,5,5}));
        assertEquals(18, game.scoreSixes(new int[]{6,5,6,6,5}));
    }

    @Test
    public void one_pair() {
        Yatzy game = new Yatzy();
        assertEquals(6, game.scorePair(new int[]{3,4,3,5,6}));
        assertEquals(10, game.scorePair(new int[]{5,3,3,3,5}));
        assertEquals(12, game.scorePair(new int[]{5,3,6,6,5}));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, Yatzy.scoreTwoPair(3,3,5,4,5));
        assertEquals(16, Yatzy.scoreTwoPair(3,3,5,5,5));
    }

//    @Test
//    public void three_of_a_kind()
//    {
//        assertEquals(9, new Yatzy.scoreThreeOfAKind(new int[]{3,3,3,4,5}));
//        assertEquals(15, Yatzy.scoreThreeOfAKind(5,3,5,4,5));
//        assertEquals(9, Yatzy.scoreThreeOfAKind(3,3,3,3,5));
//        assertEquals(9, Yatzy.scoreThreeOfAKind(3,3,3,3,3));
//    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, Yatzy.scoreFourOfAKind(3,3,3,3,5));
        assertEquals(20, Yatzy.scoreFourOfAKind(5,5,5,4,5));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.scoreSmallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy.scoreSmallStraight(2,3,4,5,1));
        assertEquals(0, Yatzy.scoreSmallStraight(1,2,2,4,5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.scoreLargeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy.scoreLargeStraight(2,3,4,5,6));
        assertEquals(0, Yatzy.scoreLargeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.scoreFullHouse(6,2,2,2,6));
        assertEquals(0, Yatzy.scoreFullHouse(2,3,4,5,6));
    }
}
