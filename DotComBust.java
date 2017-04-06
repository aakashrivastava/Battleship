import java.util.*;

public class DotComBust {

	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numberOfGuesses = 0;

	private void setUpGame() {
		DotCom one = new DotCom();
		one.setName("Pets.com");

		DotCom two = new DotCom();
		two.setName("eToys.com");

		DotCom three = new DotCom();
		three.setName("Go2.com");

		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);

		System.out.println("Your Goal is to Sink three Dot Coms.");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Try to sink them all in the fewer number of Guesses");

		for(DotCom dotComToSet: dotComsList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationsCells(newLocation);
		}
	}

	private void startPlaying() {
		while(!dotComsList.isEmpty()) {
			String userGuess = helper.getUserInput("Enter A Guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}

	private void checkUserGuess(String userGuess) {
		numberOfGuesses++;
		String result = "miss";

		for(DotCom dotComToTest: dotComsList) {
			result = dotComToTest.checkYourself(userGuess);
			if(result.equals("hit")) {
				break;
			}
			if(result.equals("kill")) {
				dotComsList.remove(dotComToTest);
				break;
			}
		}
		System.out.println(result);
	}
	private void finishGame() {
		System.out.println("All Dot Coms are Dead! Your stock is now WorthLess.");
		if(numberOfGuesses <=18) {
			System.out.println("It took you only " + numberOfGuesses + " guesses.");
			System.out.println("You got out before your options Sank");
		}else {
			System.out.println("Took you long enough! " + numberOfGuesses +" guesses.");
			System.out.println("Fish are dancing with your Options");
		}
	}

	public static void main(String[] args) {
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
}