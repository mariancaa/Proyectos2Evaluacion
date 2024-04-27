package tresenraya;

public enum Ficha {

	X,O;

	/**
	 * Constructor de Clase Ficha. Devuelve la ficha siguiente a la actual.
	 *
	 * @return La ficha siguiente: si la ficha actual es X, devuelve O; si la ficha actual es O, devuelve X.
	 */
	Ficha siguiente() {
		if(this.equals(X)) {
			return O;
		} else {
			return X;
		}
		
	}


}
