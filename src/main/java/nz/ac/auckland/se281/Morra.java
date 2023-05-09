package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  private String name;
  private int numberOfRounds;
  private ArrayList<Integer> fingerList;
  private int currentFingers;
  private int currentSum;
  private int aiFingers;
  private int aiSum;
  private int humanWin;
  private int aiWin;
  private int pointsToWin;
  private Difficulty currentDifficulty;


  public Morra() {
    this.fingerList = new ArrayList<>();
    this.name = null;
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    //Resetting most variables when new game is started
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(name);
    this.pointsToWin = pointsToWin;
    numberOfRounds = 0;
    humanWin = 0;
    aiWin = 0;
    currentDifficulty = difficulty;
    fingerList.clear();
  }


  //UNCOMMENT LINE 54 OF CLITEST, FOR THE 10 SECONDS WAIT TIME

  public void play() {
    //First check if the game has started, if name is null then game has not started
    if (name == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    //Before implementing AI level, get the finger and sum input from user
    numberOfRounds = numberOfRounds + 1;
    MessageCli.START_ROUND.printMessage(Integer.toString(numberOfRounds));
    checkFingerAndSumInput();
    MessageCli.PRINT_INFO_HAND.printMessage(
        name, Integer.toString(currentFingers), Integer.toString(currentSum));

        switch(currentDifficulty) {
          //Easy level just random strategy.
          //whoWon helper method is called to check who won the round
          case EASY:
            aiLevel easyLevel = aiFactory.createLevel("EASY");
            aiFingers = easyLevel.calculateFinger();
            aiSum = easyLevel.calculateSum(this.fingerList);
            MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", 
                Integer.toString(aiFingers), Integer.toString(aiSum));
            whoWon();
            break;

            
          case MEDIUM:
          //Medium level requires a change in strategy when the number of rounds is greater than 3
          aiLevel mediumLevel = aiFactory.createLevel("MEDIUM");
           if(numberOfRounds > 3){
            mediumLevel.changeStrategyToAverage();
          } 
          aiFingers = mediumLevel.calculateFinger();
          aiSum = mediumLevel.calculateSum(this.fingerList);
          MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", 
              Integer.toString(aiFingers), Integer.toString(aiSum));
          whoWon();
          break;

          case HARD:
          //Hard level requires a change in strategy when the number of rounds is greater than 3
          aiLevel hardLevel = aiFactory.createLevel("HARD");
           if(numberOfRounds > 3){
            hardLevel.changeStrategyToTop();
          } 
          aiFingers = hardLevel.calculateFinger();
          aiSum = hardLevel.calculateSum(this.fingerList);
          MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", 
              Integer.toString(aiFingers), Integer.toString(aiSum));
          whoWon();
          break;

          case MASTER:
          //Master level requires multiple changes in different strategy when the number of rounds is greater than 3
          //The top and average strategy also has to change back and forth
          aiLevel masterLevel = aiFactory.createLevel("MASTER");
          if(numberOfRounds > 3 && numberOfRounds % 2 == 0){
            masterLevel.changeStrategyToAverage();
          }
           else if(numberOfRounds > 3 && numberOfRounds % 2 != 0){
            masterLevel.changeStrategyToTop();
          } 
          aiFingers = masterLevel.calculateFinger();
          aiSum = masterLevel.calculateSum(this.fingerList);
          MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", 
              Integer.toString(aiFingers), Integer.toString(aiSum));
          whoWon();
          break;

          default:
            break;
            
        }
    

  }

  public void showStats() {
    //showStats only works when the game has started
    if (name == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    MessageCli.PRINT_PLAYER_WINS.printMessage(name, Integer.toString(humanWin), Integer.toString(pointsToWin-humanWin));
    MessageCli.PRINT_PLAYER_WINS.printMessage("Jarvis", Integer.toString(aiWin), Integer.toString(pointsToWin-aiWin));

  }

  public void checkFingerAndSumInput() {
    //First scan user input for finger and sum
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    String[] inputArray = input.split(" ");

    //Check if the input is valid
    if ((inputArray.length != 2)
        || Utils.isInteger(inputArray[0]) == false
        || Utils.isInteger(inputArray[1]) == false
        || (Integer.parseInt(inputArray[0]) < 1)
        || (Integer.parseInt(inputArray[0]) > 5)
        || (Integer.parseInt(inputArray[1]) < 1)
        || (Integer.parseInt(inputArray[1]) > 10)) {
      MessageCli.INVALID_INPUT.printMessage();
    //If not valid, call the method again to recursively ask for input
      checkFingerAndSumInput();
    } else {
      //Otherwise, save the finger and sum inputs, and add the finger to the list
      currentFingers = Integer.parseInt(inputArray[0]);
      currentSum = Integer.parseInt(inputArray[1]);
      fingerList.add(Integer.parseInt(inputArray[0]));
      System.out.println(currentFingers);
      System.out.println(currentSum);
    }
  }

  public void whoWon(){
    //Check who won the round
    if ((currentFingers + aiFingers == currentSum) && (currentFingers + aiFingers != aiSum)){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      humanWin = humanWin + 1;
      if(humanWin == pointsToWin){
        //Set name to null to end the game
        MessageCli.END_GAME.printMessage(name, Integer.toString(numberOfRounds));
        name = null;
      }
    }else if ((currentFingers + aiFingers == aiSum) && (currentFingers + aiFingers != currentSum)){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      aiWin = aiWin + 1;
      if(aiWin == pointsToWin){
        //Once again, set name to null to end the game if ai won
        MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(numberOfRounds));
        name = null;
      }
    }else{
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  }

}


