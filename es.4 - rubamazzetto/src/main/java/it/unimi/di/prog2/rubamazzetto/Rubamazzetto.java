package it.unimi.di.prog2.rubamazzetto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rubamazzetto {
  public static void main(String[] args) {
    List<Player> participants = new ArrayList<>();
    //TODO: creare i partecipanti componendo per ciascuno opportune strategie

    Player jay = new Player("JAY");
    jay.setStrategy(Player.RANDO);
    participants.add(jay);

    Player jen = new Player("JEN");
    jen.setStrategy(Player.TAKEY);
    participants.add(jen);

    Player jim = new Player("JIM");
    jim.setStrategy(Player.STEALO);
    participants.add(jim);

    Player joe = new Player("JOE");
    joe.setStrategy(Player.SAFEY);
    participants.add(joe);

    //participants.add(new Player("JULES"));

    Game myGame = new Game(participants);

    myGame.initialize();
    System.out.println(myGame);

    Scanner in = new Scanner(System.in);

    while (!myGame.isFinished()){

      for (Player player : participants) {
        System.out.println(player.playTurn(myGame.tableCards()));
      }

      in.nextLine();

      myGame.nextTurn();

      System.out.println(myGame);
    }
  }
}
