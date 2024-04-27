package tresenraya;

public class Partida {

	private static final String N = System.lineSeparator();
	private Tablero tablero;
	private boolean terminada;
	private Ficha ultimaFichaJugada;
	
	private static final String ERROR_00 = "Casilla [%d, %d] ocupada, vuelve a jugar O";
	private static final String ERROR_01 = "Casilla [%d, %d] ocupada, vuelve a jugar X";
	
	/**
	 * Constructor de la clase Partida que inicializa una nueva partida con un tablero de tamaño especificado.
	 *
	 * @param tam Tamaño del tablero, que define el número de filas y columnas.
	 */
	public Partida(int tam) {
		tablero = new Tablero(tam);
		this.terminada = false;
	}

	/**
	 * Verifica si la partida ha terminado, ya sea porque el tablero está lleno o porque hay un ganador.
	 *
	 * @return true si la partida ha terminado, false en caso contrario.
	 */
	public boolean terminada() {
		if(tablero.estaLleno() || ganador() != null) {
			terminada = true;
		}
	
		return terminada;
	}
	
	/**
	 * Determina la ficha del jugador ganador en la partida, si hay alguno.
	 *
	 * @return La ficha del jugador ganador (X o O), o null si no hay un ganador.
	 */
	public Ficha ganador() {
		Ficha fichaGanadora = null;
		
		if(tablero.ganaHorizontal(Ficha.X)) {
			fichaGanadora = Ficha.X;
		}
		if(tablero.ganaVertical(Ficha.X)) {
			fichaGanadora = Ficha.X;
		}
		if(tablero.ganaDiagonalDirecta(Ficha.X)) {
			fichaGanadora = Ficha.X;
		}
		if(tablero.ganaDiagonalInversa(Ficha.X)) {
			fichaGanadora = Ficha.X;
		}
		if(tablero.ganaHorizontal(Ficha.O)) {
			fichaGanadora = Ficha.O;
		}
		if(tablero.ganaVertical(Ficha.O)) {
			fichaGanadora = Ficha.O;
		}
		if(tablero.ganaDiagonalDirecta(Ficha.O)) {
			fichaGanadora = Ficha.O;
		}
		if(tablero.ganaDiagonalInversa(Ficha.O)) {
			fichaGanadora = Ficha.O;
		}
		
		return fichaGanadora;
	}

	/**
	 * Realiza una jugada en el tablero en la posición especificada por la posición (i, j).
	 * Cambia la ficha del jugador actual y maneja posibles errores de jugada.
	 *
	 * @param i Entero que representa la fila en la que se realizará la jugada.
	 * @param j Entero que representa la columna en la que se realizará la jugada.
	 */
	public void jugar(int i, int j) {
		
		if(ultimaFichaJugada == null) {
			ultimaFichaJugada = Ficha.X;
		}else {
			ultimaFichaJugada = ultimaFichaJugada.siguiente();
		}

		if(!tablero.jugar(ultimaFichaJugada, i, j)) {
			if(ultimaFichaJugada.equals(Ficha.X)) {
				System.err.println(String.format(ERROR_01, i, j));
			}else {
				System.err.println(String.format(ERROR_00, i, j));
			}
			ultimaFichaJugada = ultimaFichaJugada.siguiente();
		}	
	}

	@Override
	public String toString() {
		return tablero.toString() + N + " Turno: " + 
				(ultimaFichaJugada == null ? Ficha.X.toString() : ultimaFichaJugada.siguiente().toString());
	}

	
	
}
