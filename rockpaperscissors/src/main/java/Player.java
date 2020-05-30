import java.util.ArrayList;
import java.util.List;

class Player {
  private int number;

  private String sign;

  private List<Integer> opponents;

  public Player(int number, String sign) {
    this.number = number;
    this.sign = sign;
  }

  public int getNumber() {
    return number;
  }

  public String getSign() {
    return sign;
  }

  public List<Integer> getOpponents() {
    return opponents;
  }

  public void addOpponents(int opp) {
    if (this.opponents == null) {
      this.opponents = new ArrayList<>();
    }
    this.opponents.add(opp);
  }
}