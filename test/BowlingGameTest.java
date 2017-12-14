
/** BowlingGameTest
 *
 * @author CDT414 Student:
 * @version 1.0
 * @date 2016-11-24
 * @updated 2017-12-14
 */
import junit.framework.TestCase;


/**
 * BowlingGame Score calculator test cases
 */
public class BowlingGameTest extends TestCase {
	/**
	 * test01
	 * If no game is provided, score should be -1 (error)
	 */
	public void test01() {
		BowlingGame bowlingGame = new BowlingGame("");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testNull() {
		BowlingGame bowlingGame = new BowlingGame(null);
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testEmpty() {
		//See test01() above
		//BowlingGame bowlingGame = new BowlingGame("");
		//assertEquals(-1, bowlingGame.getScore());
	}

	public void testString() {
		BowlingGame bowlingGame = new BowlingGame("Hello");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testString2() {
		BowlingGame bowlingGame = new BowlingGame("[Hello]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testString3() {
		BowlingGame bowlingGame = new BowlingGame("[Hello,World]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testString4() {
		BowlingGame bowlingGame = new BowlingGame("[5,World]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testString5() {
		BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,HELLO]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testInvalidEmpty() {
		BowlingGame bowlingGame = new BowlingGame("[][][][][][][][][][]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testInvalidEmptyColons() {
		BowlingGame bowlingGame = new BowlingGame("[,][,][,][,][,][,][,][,][,][,]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testInvalidHalfColonsL() {
		BowlingGame bowlingGame = new BowlingGame("[1,][2,][3,][4,][5,][6,][7,][8,][9,][10,]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testInvalidHalfColonsR() {
		BowlingGame bowlingGame = new BowlingGame("[,1][,2][,3][,4][,5][,6][,7][,8][,9][,10]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testInvalidHalfColonsMix() {
		BowlingGame bowlingGame = new BowlingGame("[1,][,2][3,][,4][5,][,6][7,][,8][9,][,10]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testInvalidWrongAmount() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testInvalidWrongNumbers() {
		BowlingGame bowlingGame = new BowlingGame("[10,10][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testInvalidNegativeNumberL() {
		BowlingGame bowlingGame = new BowlingGame("[1,5][-3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testInvalidNegativeNumberR() {
		BowlingGame bowlingGame = new BowlingGame("[1,5][3,-6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testInvalidNegativeNumbers() {
		BowlingGame bowlingGame = new BowlingGame("[-10,0][-3,-6][-7,-2][-3,-6][-4,-4][-5,-3][-3,-3][-4,-5][-8,-1][-2,-6]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testInvalidBonus() {
		BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6][7]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testOpen() {
		BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(81, bowlingGame.getScore());
	}

	public void testOpenZero() {
		BowlingGame bowlingGame = new BowlingGame("[0,0][0,0][0,0][0,0][0,0][0,0][0,0][0,0][0,0][0,0]");
		assertEquals(0, bowlingGame.getScore());
	}

	public void testStrike() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(94, bowlingGame.getScore());
	}

	public void testMultipleStrikes() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(112, bowlingGame.getScore());
	}

	public void testSpare() {
		BowlingGame bowlingGame = new BowlingGame("[1,9][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(88, bowlingGame.getScore());
	}

	public void testSpare2() {
		BowlingGame bowlingGame = new BowlingGame("[0,10][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(88, bowlingGame.getScore());
	}

	public void testMultipleSpares() {
		BowlingGame bowlingGame = new BowlingGame("[8,2][5,5][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(98, bowlingGame.getScore());
	}

	public void testStrikeAndSpare() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][4,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(103, bowlingGame.getScore());
	}

	public void testSpareLast() {
		BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][7]");
		assertEquals(90, bowlingGame.getScore());
	}

	public void testStrikeLast() {
		BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][10,0][7,2]");
		assertEquals(92, bowlingGame.getScore());
	}

	public void testStrikeLastAndBonusSpare() {
		BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][10,0][9,1]");
		assertEquals(93, bowlingGame.getScore());
	}

	public void testSpareLastAndBonusStrike() {
		BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][10]");
		assertEquals(93, bowlingGame.getScore());
	}

	public void testBonusStrikeZero() {
		BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][0]");
		assertEquals(83, bowlingGame.getScore());
	}

	public void testPerfectGame() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,10]");
		assertEquals(300, bowlingGame.getScore());
	}
}
