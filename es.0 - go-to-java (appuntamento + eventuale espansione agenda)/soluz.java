package it.unimi.di.p2.lez2;


import java.util.ArrayList;
import java.util.Scanner;

public class Appuntamento {
  private int giorno;
  private int oraInizio;
  private int oraFine;

  public Appuntamento(int giorno, int oraInizio, int oraFine) {
    if (isValidDay(giorno) && isValidTime(oraInizio) && isValidTime(oraFine) && oraInizio <= oraFine) {
      this.giorno = giorno;
      this.oraInizio = oraInizio;
      this.oraFine = oraFine;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public static void main(String[] args) {
    var agenda = new ArrayList<Appuntamento>(0);

    Scanner input = new Scanner(System.in);
    try {
      while (input.hasNextInt()) {
        Appuntamento app = parse(input);
        if (app != null)
          app.addTo(agenda);
      }
    } catch (Exception eccezione) {
      System.err.println(eccezione.toString());
      System.err.println("Errore durante la lettura interna delle ore");

      input.close();
    }
    System.out.println(agenda);

  }

  private static Appuntamento parse(Scanner input) {
    int h2;
    int h1;
    int gg;
    gg = input.nextInt();
    h1 = input.nextInt();
    h2 = input.nextInt();


    Appuntamento app = null;
    try {
      app = new Appuntamento(gg, h1, h2);
    } catch (IllegalArgumentException e) {
      System.err.println("parametri giorno o oraInizio o oraFine sbagliati");
    }
    return app;
  }


  public static boolean isValidTime(int h) {
    return 0 <= h && h <= 24;
  }

  public static boolean isValidDay(int gg) {
    return 1 <= gg && gg <= 366;
  }

  private boolean addTo(ArrayList<Appuntamento> agenda) {
    for (Appuntamento app : agenda) {
      if (checkSovrapposizioneCon(app)) {
        return false;
      }
    }
    agenda.add(this);
    return true;
  }

  private boolean checkSovrapposizioneCon(Appuntamento b) {
    return sameDay(b) && (startInside(b) || endInside(b));
  }

  private boolean sameDay(Appuntamento b) {
    return b.giorno == this.giorno;
  }

  private boolean endInside(Appuntamento b) {
    return oraFine > b.oraInizio && oraFine <= b.oraFine;
  }

  private boolean startInside(Appuntamento b) {
    return oraInizio >= b.oraInizio && oraInizio < b.oraFine;
  }

  @Override
  public String toString() {
    return "{" + giorno + "," + oraInizio + "," + oraFine + "}";
  }
}
