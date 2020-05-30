import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

class Solution {
  private static Player getWinner(Player a, Player b) {
    int winner = whoWins(a.getSign(), b.getSign());
    switch (winner) {
      case 0:
        return a.getNumber() < b.getNumber() ? a : b;
      case 2:
        return b;
      default:
        return a;
    }
  }

  private static int whoWins(String s1, String s2) {
    if (s1.equals(s2))
      return 0;
    if (signs.get(s1).contains(s2)) {
      return 1;
    } else {
      return 2;
    }
  }

  static final HashMap<String, String> signs = new HashMap<>();
  static {
    signs.put("R", "L C");
    signs.put("P", "R S");
    signs.put("C", "P L");
    signs.put("L", "S P");
    signs.put("S", "C R");
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    ArrayList<Player> players = new ArrayList<>(N);

    for (int i = 0; i < N; i++) {
      int NUMPLAYER = in.nextInt();
      String SIGNPLAYER = in.next();
      players.add(new Player(NUMPLAYER, SIGNPLAYER));
    }

    Player winner = play(players);

    System.out.println(winner.getNumber());

    // Print the opponents
    StringJoiner joiner = new StringJoiner(" ");
    for (Integer p : winner.getOpponents()) {
      String s = String.valueOf(p);
      joiner.add(s);
    }
    System.out.print(joiner.toString());
  }

  // Play until there is a winner
  private static Player play(ArrayList<Player> players) {
    if (players.size() == 1)
      return players.get(0);

    ArrayList<Player> winners = new ArrayList<>();
    for (int i = 0; i <= players.size() - 1; i = i + 2) {
      winners.add(fight(players.get(i), players.get(i + 1)));
    }
    return play(winners);
  }

  private static Player fight(Player p1, Player p2) {
    if (getWinner(p1, p2) == p1) {
      p1.addOpponents(p2.getNumber());
      return p1;
    } else {
      p2.addOpponents(p1.getNumber());
      return p2;
    }
  }
}