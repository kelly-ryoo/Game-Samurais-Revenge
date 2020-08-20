import javafx.scene.text.Font;
import javafx.scene.text.Text;
public class Score extends Text{

	int score;
	
	public Score() {
		score = 0;

		setFont(new Font("Georgia", 25));
		updateDisplay();
	}
	
	public void updateDisplay() {
		setText("Points: " + score);
	}
	
	public int getScore() {
		return score;
	}
	
	public void incrementFive() {
		score+= 5;
	}
	
	public void incrementTen() {
		score+=10;
	}
	
	public void setScore(int val) {
		score = val;
		updateDisplay();
	}
	
	public void decrementScore() {
		score--;
		updateDisplay();
	}
	
}