package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {

  public static int cardValue(Card c) {
    return Math.min(c.getRank().ordinal() + 1, 10);
  }

  public static void main(String[] args) {
    Mazziere banco = new Mazziere();

    Sfidante carlo = new Sfidante("Carlo", banco);
    Sfidante mattia = new Sfidante("Mattia", banco);
    Sfidante violetta = new Sfidante("Violetta", banco);

    List<Sfidante> sfidanti = new ArrayList<>();

    //TODO  gestire lo svolgimento di una partita con i tre sfidanti

    System.out.println(banco);
    for (Sfidante sfidante : sfidanti) {
      System.out.println(sfidante);
      if (sfidante.isSballato() || (sfidante.getPunti() < banco.getPunti() && !banco.isSballato()))
        System.out.println("Vince il banco.");
      else if (banco.isSballato() || sfidante.getPunti() > banco.getPunti())
        System.out.println("Il banco perde!!!");
      else
        System.out.println("Pareggio.");
    }
  }

}
