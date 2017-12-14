import java.util.ArrayList;


/**
 * BowlingGame Score calculator
 *
 * @author CDT414 Student: Erik Ullberg (eug11001)
 * @version 1.0
 * @date 2017-12-14
 */
public class BowlingGame {
	//Vars
	private ArrayList<Frame> frames_AlF;

	//Consstructors
	/**
	 * BowlingGame Score calculator constructor which require string as input
	 *
	 * @param game Expected format "[n,n][n,n]..[n,n]"
	 */
	public BowlingGame(String game) {
		String[] split, temp;
		int t1 = -1, t2 = -1;

		if(game != null) {
			frames_AlF = new ArrayList<Frame>();
			split = game.replace("[", "").split("]");

			for(String s : split) {
				t1 = t2 = -1; //-1 represents empty
				temp = s.split(",");
				if(temp.length > 0) {
					try {
						if(temp[0].length() > 0) {
							t1 = Integer.parseInt(temp[0]);
							if((temp.length > 1) && (temp[1].length() > 0)) {
								t2 = Integer.parseInt(temp[1]);
							}
						}
					}
					catch(NumberFormatException e) {
						//Just so a parseInt()-error won't stop execution
						break;
					}
				}

				if(t1 > -1) {
					frames_AlF.add(new Frame(t1, t2));
				}
			}

			//System.out.println("Frames: " + frames_AlF.size());
		}
	}

	//Methods
	//-Public
	/**
	 * getScore method returns a score of current Bowling game or -1 if error
	 *
	 * @return Integer value of Bowling score, in case of error return value is
	 *         -1
	 */
	public int getScore() {
		int score = 0;
		int t1 = -1, t2 = -1;

		if((frames_AlF != null) && (frames_AlF.size() > 0) && ((frames_AlF.size() == 10) || ((frames_AlF.size() == 11) && ((frames_AlF.get(9).getThrow1() + frames_AlF.get(9).getThrow2()) == 10)))) {
			for(int i = 0; i < frames_AlF.size(); ++i) {
				t1 = frames_AlF.get(i).getThrow1();
				t2 = frames_AlF.get(i).getThrow2();
				//System.out.println("t1: " + t1 + ", t2: " + t2 + " (i: " + i + ") (" + frames_AlF.size() + ")");

				//Check if invalid (VALID: t1 not -1, [0, 10], t1+t2 <= 10 (20 if frame 11 (bonus) (10 when 0-index)), t2 not -1 if not last square (bonus))
				if(!((t1 > -1) && (t1 <= 10) && (t2 >= -1) && (t2 <= 10) && (((i < 10) && ((t1 + t2) <= 10)) || (((i == 10) && ((t1 + t2) <= 20)))) && ((((t2 != -1) && (i < (frames_AlF.size() - 1))) || (i == (frames_AlF.size() - 1)))))) {
					return (-1);
				}

				//Add together
				score += t1;
				if((t1 == 10) && (i < (frames_AlF.size() - 2))) { //Strike
					//Assume next frame is valid - If next frame is invalid it will be caught by above if-statement in the next iteration
					score += (frames_AlF.get(i + 1).getThrow1() + (((frames_AlF.get(i + 1).getThrow1() < 10) ? frames_AlF.get(i + 1).getThrow2() : frames_AlF.get(i + 2).getThrow1())));
				}
				else if(t2 != -1) {
					score += t2;

					//Spare
					if(((t1 + t2) == 10) && (i < (frames_AlF.size() - 2))) {
						//Assume next frame is valid - If next frame is invalid it will be caught by above if-statement in the next iteration
						score += frames_AlF.get(i + 1).getThrow1();
					}
				}
			}
			//System.out.println(score);

			return score;
		}

		return (-1);
	}

}
