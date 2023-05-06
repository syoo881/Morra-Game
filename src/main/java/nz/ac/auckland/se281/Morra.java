package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  private String name;
  private int numberOfRounds = 0;
  private List<Integer> fingers = new ArrayList<>();
  private int currentFingers;
  private int currentSum;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(name);
    // Maybe have to Titlecase the name.
    numberOfRounds = 0;
  }

  public void play() {
    numberOfRounds = numberOfRounds + 1;
    MessageCli.START_ROUND.printMessage(Integer.toString(numberOfRounds));

    checkFingerAndSumInput();

    MessageCli.PRINT_INFO_HAND.printMessage(
        name, Integer.toString(currentFingers), Integer.toString(currentSum));
  }

  public void showStats() {}

  public void checkFingerAndSumInput() {
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    String[] inputArray = input.split(" ");

    if ((inputArray.length != 2)
        || Utils.isInteger(inputArray[0]) == false
        || Utils.isInteger(inputArray[1]) == false
        || (Integer.parseInt(inputArray[0]) < 1)
        || (Integer.parseInt(inputArray[0]) > 5)
        || (Integer.parseInt(inputArray[1]) < 1)
        || (Integer.parseInt(inputArray[1]) > 10)) {
      MessageCli.INVALID_INPUT.printMessage();
      checkFingerAndSumInput();
    } else {
      currentFingers = Integer.parseInt(inputArray[0]);
      currentSum = Integer.parseInt(inputArray[1]);
      fingers.add(Integer.parseInt(inputArray[0]));
      System.out.println(currentFingers);
      System.out.println(currentSum);
      // print out the numberOfRounds element of the fingers array

      System.out.println(fingers.get(numberOfRounds - 1));
    }
    return;
  }
}
