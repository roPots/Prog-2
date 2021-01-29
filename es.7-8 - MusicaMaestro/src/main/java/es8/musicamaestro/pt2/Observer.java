package es8.musicamaestro.pt2;

// interfaccia di definizione di una classe
// che vuole definirsi come osservatore di un oggetto di tipo T
public interface Observer<T> {
    void update(Observable<T> model, T state); // metodo usato dall'observable per passare le informazioni all'osservatore
                                               // esistono due modi con cui questo può avvenire: modalità pull e modalità push
                                               // > push, viene passato direttamente un preciso oggetto che rappresenta lo stato attuale dell'osservato
                                               // > pull, viene passato l'intero oggetto osservato, affinché solo se si desidera può poi essere estratta dell'informazione di interesse (non soltanto limitata ad uno particolare oggetto)
}
