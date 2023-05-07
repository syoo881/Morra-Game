package nz.ac.auckland.se281;

public class AIFactory {
    
    public static AILevel createLevel(String type) {


        switch (type) {
            case "EASY":
                return new Easy();
            /* case "MEDIUM":
                return new Medium();
            case "HARD":
                return new Hard(); */
            default:
                return null;
        }
    }

}
