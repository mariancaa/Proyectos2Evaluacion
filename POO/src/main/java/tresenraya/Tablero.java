package tresenraya;


public class Tablero {
	private static final String N = System.lineSeparator();
	private static final String VERT = "|";
	private static final String SEP = " ";
	private static final String HORT = "---";
	private static final String CRUZ = "+";

	private static final Ficha VACIA = null;

	private Ficha[][] tablero;
	private int tam;
	
	/**
	 * Constructor del Tablero que inicializa una matriz bidimensional.
	 *
	 * @param tam Tamaño que define el número de columnas y filas de la matriz.
	 * @return Tablero vacío creado con las dimensiones especificadas.
	 */
	public Tablero(int tam) {
		this.tam = tam;
		tablero = new Ficha[tam][tam];
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				tablero[i][j] = VACIA;

			}
		}
	}
	
	/**
	 * Verifica si la casilla seleccionada está ocupada o vacía.
	 *
	 * @return true si la casilla está llena.
	 */
	public boolean estaLleno() {
		boolean estaLleno = true;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == VACIA) {
					estaLleno = false;
				}
			}
		}
		return estaLleno;
	}
	
	/**
	 * Realiza una jugada en el tablero verificando la disponibilidad de la casilla.
	 *
	 * @param ficha Ficha del jugador, representada por un objeto de tipo Ficha.
	 * @param fila  Entero que representa la fila en la que se realizará la jugada.
	 * @param columna Entero que representa la columna en la que se realizará la jugada.
	 * @return true si la casilla estaba vacía y se realizó la jugada, false si la casilla ya estaba ocupada.
	 */
	public boolean jugar(Ficha ficha, int fila, int columna) {

		if (tablero[fila][columna] == VACIA) {
			tablero[fila][columna] = ficha;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		StringBuilder salida = new StringBuilder();
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (j < tablero[i].length - 1) {
					salida.append(SEP).append(tablero[i][j] != null ? tablero[i][j] : " ").append(SEP).append(VERT);
				} else {
					salida.append(SEP).append(tablero[i][j] != null ? tablero[i][j] : " ").append(SEP);
				}
			}
			salida.append(N);
			if (i < tablero.length - 1) {
				for (int k = 0; k < tablero[i].length; k++) {
					if (k < tablero[i].length - 1) {
						salida.append(HORT).append(CRUZ);
					} else {
						salida.append(HORT);
					}
				}
				salida.append(N);
			}
		}
		return salida.toString();
	}
	
	/**
	 * Verifica si hay una victoria en sentido horizontal para la ficha especificada en el tablero.
	 *
	 * @param o Ficha a verificar para la victoria horizontal, representada por un objeto de tipo Ficha.
	 * @return true si hay una línea horizontal completa con la ficha especificada, false en caso contrario.
	 */
	public boolean ganaHorizontal(Ficha o) {
		boolean ganar = false;
		for(int i = 0; i < tablero.length; i++) {
			if(tablero[i][0] == o && tablero[i][1] == o && tablero[i][2] == o) {
				ganar = true;
			}
		}
		return ganar;
	}
	
	/**
	 * Verifica si hay una victoria en sentido vertical para la ficha especificada en el tablero.
	 *
	 * @param o Ficha a verificar para la victoria vertical, representada por un objeto de tipo Ficha.
	 * @return true si hay una línea vertical completa con la ficha especificada, false en caso contrario.
	 */
	public boolean ganaVertical(Ficha x) {
		boolean ganar = false;
		for (int i = 0; i < tablero.length; i++) {
			if (tablero[0][i] == x && tablero[1][i] == x && tablero[2][i] == x) {
				ganar = true;
			}
		}
		return ganar;
	}
	/**
	 * Verifica si hay una victoria en sentido diagonal ([0,0][1,1][2,2]) para la ficha especificada en el tablero.
	 *
	 * @param o Ficha a verificar para la victoria diagonal ([0,0][1,1][2,2]), representada por un objeto de tipo Ficha.
	 * @return true si hay una línea diagonal ([0,0][1,1][2,2]) completa con la ficha especificada, false en caso contrario.
	 */
	public boolean ganaDiagonalDirecta(Ficha x) {
		 boolean ganar = true;
		    for (int i = 0; i < tablero.length; i++) {
		        if (tablero[i][i] != x) {
		            ganar = false;
		            break;
		        }
		    }
		    return ganar;
	}
	
	/**
	 * Verifica si hay una victoria en sentido diagonal ([0,2][1,1][2,0]) para la ficha especificada en el tablero.
	 *
	 * @param o Ficha a verificar para la victoria diagonal ([0,2][1,1][2,0]), representada por un objeto de tipo Ficha.
	 * @return true si hay una línea diagonal ([0,2][1,1][2,0]) completa con la ficha especificada, false en caso contrario.
	 */
	public boolean ganaDiagonalInversa(Ficha x) {
		   boolean ganar = true;
		    for (int i = 0; i < tablero.length; i++) {
		        if (tablero[i][tablero.length - 1 - i] != x) {
		            ganar = false;
		            break;
		        }
		    }
		    return ganar;
	}
	
	/**
	 * Verifica si un jugador ha ganado al completar al menos una fila, columna o diagonal en el tablero.
	 *
	 * @param F Fichas utilizadas por los jugadores en la partida de tres en raya, representada por un objeto de tipo Ficha.
	 * @return true si hay una victoria al completar una fila, columna o diagonal; false en caso contrario.
	 */
	public boolean gana(Ficha o) {
		
		if (ganaHorizontal(o) || ganaVertical(o) || ganaDiagonalDirecta(o) || ganaDiagonalInversa(o))  {
			return true;
		} 
		return false;
	}
}
