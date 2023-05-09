package nz.ac.auckland.se281;

public class AIFactory {

    public static AILevel createLevel(String type) {
        //Creating instances of AI level, based on the type of level selected
        switch (type) {
            case "EASY":
                return new Easy();
             case "MEDIUM":
                return new Medium();
             case "HARD":
                return new Hard(); 
            case "MASTER":
                return new Master();
            default:
                return null;
        }
    }

}

