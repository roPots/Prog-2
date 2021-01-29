package it.unimi.di.prog2.blackjack;

//TODO spiegare in poche righe di commento se ha senso concatenare una dopo l'altra due strategie Random
// -- vv --
// non particolarmente. concatenare un secondo decisore casuale significa rimandare la scelta (pur sempre) casuale un'altra volta
// la scelta di prendere una nuova carta. più decisori casuali concateno maggiore sarà
// la probabilità di ottenere eventualmente la scelta di prendere una nuova carta.

public class RandomStrategy implements Strategia {
  final private Strategia next;

  public RandomStrategy(Strategia next) {
    assert next != null : "se si usa NullObject Pattern non si ha mai strategia 'null'";
    this.next = next;
  }

  @Override
  public boolean chiediCarta() {
    if (Math.random() > 0.5)
      return true;
    return next.chiediCarta();
  }
}
