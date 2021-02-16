# Coda dal Fruttivendolo (Model View Presenter)
  


Obiettivo dell'esercizio è progettare e realizzare (secondo la **metodologia
TDD** e facendo uso di opportuni **design pattern**) una gerarchia di classi
atte a produrre un semplice programma Java che si occupa di supportare *clienti*
(Customer) e *commessi* (Clerks) di un negozio nella gestione della *coda*
(unica, il "modello" del sistema). In particolare i clienti vengono serviti in modo FIFO in
base al numero di *biglietto* (Ticket) che ritirano quando arrivano nel negozio
tramite uno specifico *dispenser* (una "vista" particolare). Ci possono essere più
dispenser, che naturalmente devono essere coerenti tra di loro, cioè distribuire il numero
corretto in quel momento. I commessi, prima di servire, chiedono al sistema
(attraverso ulteriori "viste" particolari) il prossimo numero in coda. 

Il sistema deve poter funzionare con *N* (grande a piacere) dispenser per i clienti ed *M* (grande  piacere) viste per i commessi.
Tutte le viste devono essere coerenti sul numero di biglietto da *servire* e da *erogare*.

Per semplicità, assumiamo che le operazioni degli utenti vengano eseguite in modo *atomico*, 
non è richiesto quindi di occuparsi di problemi di *sincronizzazione*.

### Requisiti informali

Il progetto deve tener conto dei seguenti requisiti:

*  Le viste associate a *clienti* e *impiegati* possono essere realizzate tramite una unica classe. Attraverso un `Button` e una `Label` ci permettono di richiedere e di leggere il prossimo numero di *biglietto*. La classe astratta da cui partire per definire la classe per le due viste è già presente in `TicketView` che ha due metodi:
   - `handle` che permette di fissare il metodo che reagisce alla pressione del bottone 
   - `set` che permette di modificare il valore della label

* La componente `Model` si occupa di mantenere i dati riguardo ai `Ticket` da erogare/servire. E' unica e comune a tutte le viste. Il `Model` a fronte di un cambiamento di stato, deve occuparsi di *notificare* tutti i controller che si sono registrati.

* Il `Controller` reagisce all’input dell’utente (pressione di un bottone) e richiama le operazioni opportune (definite dalla `View` tramite un pattern strategy) sul `Model`, quando notificato da `Model` aggiorna la `View` di cui è responsabile.


* Lo svolgimento dell'esercizio richiede l'uso del *compound pattern* Model-View-Presenter (MVP).



## Verifica e Convalida

### Integration Test

E' già fornito oltre al main anche un test di integrazione che simula alcuni click su una `View` e fa asserzioni sulle modifiche conseguenti nelle altre `View`.

## Compiti

Dopo aver esplorato le interfacce e classi fornite, rispondere alle domande e completare i punti segnalati dai vari commenti `TODO` che troverete sparsi nel codice.

In aggiunta ai TODO: visto che viene richiesto uno sviluppo TDD, si dovrebbe scrivere qualche test di unità.
