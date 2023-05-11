package nz.ac.auckland.se281;

public class AiFactory {

  public static AiLevel createLevel(String type) {
    // Creating instances of AI level, based on the type of level selected
    switch (type) {
      case "EASY":
        return new EasyLevel();
      case "MEDIUM":
        return new MediumLevel();
      case "HARD":
        return new HardLevel();
      case "MASTER":
        return new MasterLevel();
      default:
        return null;
    }
  }
}
