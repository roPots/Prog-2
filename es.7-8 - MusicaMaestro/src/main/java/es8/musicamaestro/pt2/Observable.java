package es8.musicamaestro.pt2;

// interfaccia di definizione di un qualsiasi oggetto di tipo T
// che vuole definirsi come observable secondo l'omonimo patttern
public interface Observable<T> {
    void registerObserver(Observer<T> o); // metodo che registra un nuovo osservatore, sempre dell'oggetto in argomento
    void removeObserver(Observer<T> o);
    void notifyObservers(); // metodo che a seguito di un cambiamento di stato E/O se lo ritiene opportuno, notifica tutti gli osservatori registrati. un approccio del tipo "le faremo sapere"

    T getState(); // metodo che ritorna lo stato dell'oggetto osservato. serve agli osservatori per estrarre informazioni possibilmente cambiate
    void setState(T value); // metodo che permette ad un ente esterno di modificare lo stato dell'oggetto osservato, possibilmente scatenando la reazione degli osservatori.
}
