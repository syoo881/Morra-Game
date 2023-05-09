package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  private String name;
  private int numberOfRounds;
  //Maybe move the fingerList implementation over to the calculateFinger method.
  private ArrayList<Integer> fingerList;
  private int currentFingers;
  private int currentSum;
  private int aiFingers;
  private int aiSum;
  private Difficulty currentDifficulty;


  public Morra() {
    this.fingerList = new ArrayList<>();
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(name);
    // Maybe have to Titlecase the name.
    numberOfRounds = 0;
    currentDifficulty = difficulty;
    fingerList.clear();
  }


  //UNCOMMENT LINE 54 OF CLITEST, FOR THE 10 SECONDS WAIT TIME

  public void play() {
    numberOfRounds = numberOfRounds + 1;
    MessageCli.START_ROUND.printMessage(Integer.toString(numberOfRounds));
    checkFingerAndSumInput();
    MessageCli.PRINT_INFO_HAND.printMessage(
        name, Integer.toString(currentFingers), Integer.toString(currentSum));

        switch(currentDifficulty) {
          case EASY:
            AILevel EASYLevel = AIFactory.createLevel("EASY");
            aiFingers = EASYLevel.calculateFinger();
            aiSum = EASYLevel.calculateSum(this.fingerList);
            MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", 
                Integer.toString(aiFingers), Integer.toString(aiSum));
            whoWon();
            break;

            
          case MEDIUM:
          AILevel MEDIUMLevel = AIFactory.createLevel("MEDIUM");
          if(numberOfRounds > 3){
            MEDIUMLevel.changeStrategy();
          }
          aiFingers = MEDIUMLevel.calculateFinger();

          //INput this.fingerList into the calculateSum, so that calculateSum can use
          aiSum = MEDIUMLevel.calculateSum(this.fingerList);
          MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", 
              Integer.toString(aiFingers), Integer.toString(aiSum));
          whoWon();
          break;

          case HARD:

          default:
            break;
            
        }
    

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
      fingerList.add(Integer.parseInt(inputArray[0]));
      System.out.println(currentFingers);
      System.out.println(currentSum);
      // print out the numberOfRounds element of the fingers array

      /* System.out.println(fingerList.get(numberOfRounds - 1)); 
      System.out.println(fingerList.size()); */
    }
    return;
  }

  public void whoWon(){
    if (currentFingers + aiFingers == currentSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    }else if (currentFingers + aiFingers == aiSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    }else{
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  }

}


