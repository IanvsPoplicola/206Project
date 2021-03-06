package application.model;

import application.util.MaoriAnswerUtil;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * this is a Question object
 * Everytime we generate a random integer
 * that integer will be stored as a Question Object
 * we can then manipulate the Question object
 * @author se206
 *
 */
public class Question {


	private IntegerProperty _theNumber;   //this is a StringProperty that is associated with this Question object
	
	
	private boolean skipped;  //this records whether this Question object has been skipped by the user
	private boolean correct;  //this records whether this Question has been answered correctly by the user
	private int attempts;		// this records the number of attempts that THIS question has been attempted

	/**
	 * a constructor for the Question object, it takes an int and saves it as its own unique* state
	 * The Question initial state for "skipped" is false.
	 * The Question initial state for "correct" is false.
	 * @param theNumber
	 */
	public Question(int theNumber) {
		_theNumber=new SimpleIntegerProperty(theNumber);
		
		skipped = false;
		correct = false;
		attempts = 1;             //initially 1 attempt
	}



	/**
	 * this method returns the integer that is associated with this Question object
	 * as a string
	 * @return
	 */
	public int getInteger() {
		return _theNumber.get();
	}
	
	/**
	 * this methods lets you set the boolean value for skipped.
	 * 
	 * note to self: should i not take an argument and assume whenever this method is called
	 * it will just set the state "skipped" to be true ?
	 * or should i just allow the caller to manipulate this state ?
	 * 
	 * @param skip
	 */
	public void setSkipped(boolean skip) {
		skipped = skip;
	}
	
	/**
	 * this method returns whether THIS Question object has been skipped by the user
	 * returns true if it has been skipped, false other wise.
	 * @return
	 */
	public boolean hasSkipped() {
		return skipped;
	}
	
	/**
	 * this method sets the boolean state "correct" for THIS Question
	 * whether this Question has been answered correctly or not 
	 * @param answer
	 */
	public void setCorrect(boolean answer) {
		correct = answer;
	}
	
	/**
	 * this method returns a boolean: whether THIS Question has been answered correctly
	 * @return
	 */
	public boolean isCorrect() {
		return correct;
	}
	
	/**
	 * this increments the attepts by 1
	 */
	public void addAttempts() {
		attempts = attempts + 1;
	}
	
	/**
	 * this returns the number of attempts that this question has had
	 * @return int : attempts
	 */
	public int getAttempts() {
		return attempts;
	}
	
}
