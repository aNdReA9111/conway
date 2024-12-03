# Conway's Game of Life

Il Conway's Game of Life è un automa cellulare ideato dal matematico John Conway. È un gioco zero giocatori, il che significa che la sua evoluzione è determinata dal suo stato iniziale, senza necessità di ulteriori input. Il gioco si svolge su una griglia di celle che possono essere vive o morte, e lo stato di ciascuna cella evolve nel tempo secondo regole semplici basate sul numero di vicini vivi.

## Design Pattern Utilizzati

### Strategy Pattern
Il pattern Strategy è stato utilizzato per determinare lo stato successivo di una cella in base al numero di vicini vivi. Questo permette di separare la logica di transizione dello stato dal contesto in cui viene utilizzata.

### Factory Pattern
Il pattern Factory è stato utilizzato per creare istanze di `CellState` in base allo stato attuale della cella (viva o morta). Questo permette di centralizzare la logica di creazione degli oggetti e di semplificare il codice.

### Polimorfismo
Il polimorfismo è stato utilizzato per evitare l'uso di istruzioni `if` e costrutti ternari. Invece di controllare lo stato di una cella con `if`, viene utilizzato il polimorfismo per chiamare il metodo `nextState` dell'oggetto `CellState` appropriato.