package ejercicios;

import java.util.Scanner;

/*
 * Un tablero de 3x3 matriz [fila][columna]
 * Dos jugadores ingresan las coordenadas de cada ficha x teclado
 * Una vez que tengo fila y columna muestro tablero con X o 0
 * Verificar si esa posicion es posible y si hay ganador
 * mientras no haya ganador continua el juego
 * 
 *    |   |
 * ---|---|---
 *    |   | X  -> tablero[1][2]
 * ---|---|---
 *    |   | 
 *    
 *    bugs
 *    1.no deja volver a jugar si hay una jugada no valida
 *    2.nombres de los jugadores estan mal (porque dependen del turno)
 *    3.no muestra un tablero decente
 *    4.validar rangos de fila y col (de 0 a 2)
 *    5.avisar del empate y reiniciar juego
 */

public class EjercicioTaTeTi {

	private static int FILAS = 3;
	private static int COLUMNAS = 3;

	public static void main(String[] args) {
		char[][] tablero = new char[FILAS][COLUMNAS];
		darBienvenida("Juego Ta-Te-Ti");
		imprimir(tablero);
		boolean ganador = false;
		int contador = 0;
		int turno = 0;

		while (!ganador && contador < 9) {
			contador++;
			turno++;
			jugarFicha(turno, tablero);
			imprimir(tablero);
			ganador = verificarGanador(tablero);
			if (ganador) {
				if (turno == 1 || turno == 3 || turno == 5 || turno == 7 || turno == 9) {
					System.out.println("Jugador 1 Ganaste!");
				} else {
					System.out.println("Jugador 2 Ganaste!");
				}
			}
		}
		if (contador == 9) {
			System.out.println("Empate");
		}
	}

	private static void jugarFicha(int turno, char[][] tablero) {
		Scanner sc = new Scanner(System.in);
		if (turno == 1 || turno == 3 || turno == 5 || turno == 7 || turno == 9) {
			System.out.println("JUGADOR 1: ");
		} else {
			System.out.println("JUGADOR 2: ");
		}
		System.out.println("Ingrese fila ");
		int fila = sc.nextInt();
		System.out.println("Ingrese columna ");
		int col = sc.nextInt();
		validarTablero(fila, col);
		verificarJugada(fila, col, tablero, turno);

	}
	// imprimir(tablero);
	// } else {
	// if (turno == 1) {
	// tablero[fila][col] = 'X';
	// } else {
	// tablero[fila][col] = 'O';
	// }
	// ganador = verificar(tablero);
	// imprimir(tablero);
	// if (ganador) {
	// System.out.println("Jugador " + turno + " ¡Ganaste!");
	// }
	// }

	// return ganador;
	// }

	private static char[][] verificarJugada(int fila, int col, char[][] tablero, int turno) {
		Scanner sc = new Scanner(System.in);
		while (tablero[fila][col] == 'X' || tablero[fila][col] == 'O') {
			System.out.println("Jugada no valida. Elegi de nuevo");
			System.out.println("Ingrese fila: ");
			fila = sc.nextInt();
			System.out.println("Ingrese columna: ");
			col = sc.nextInt();
			validarTablero(fila, col);
		}
		if (turno == 1 || turno == 3 || turno == 5 || turno == 7 || turno == 9) {
			tablero[fila][col] = 'X';
		} else {
			tablero[fila][col] = 'O';
		}
		return tablero;
	}

	private static int validarTablero(int fila, int col) {
		Scanner sc = new Scanner(System.in);
		while (fila < 0 || fila > 2) {
			System.out.println("Posicion inexistente. Elegi de nuevo");
			System.out.println("Ingrese fila ");
			fila = sc.nextInt();
		}
		while (col < 0 || col > 2) {
			System.out.println("Posicion inexistente. Elegi de nuevo");
			System.out.println("Ingrese columna ");
			col = sc.nextInt();
		}
		return fila | col;
	}

	private static boolean verificarGanador(char[][] tablero) {
		boolean cond1 = tablero[0][0] == tablero[0][1] && tablero[0][0] == tablero[0][2]
				&& (tablero[0][0] == 'X' || tablero[0][0] == 'O');
		boolean cond2 = tablero[1][0] == tablero[1][1] && tablero[1][0] == tablero[1][2]
				&& (tablero[1][0] == 'X' || tablero[1][0] == 'O');
		boolean cond3 = tablero[2][0] == tablero[2][1] && tablero[2][0] == tablero[2][2]
				&& (tablero[2][0] == 'X' || tablero[2][0] == 'O');
		boolean cond4 = tablero[0][0] == tablero[1][0] && tablero[0][0] == tablero[2][0]
				&& (tablero[0][0] == 'X' || tablero[0][0] == 'O');
		boolean cond5 = tablero[0][1] == tablero[1][1] && tablero[0][1] == tablero[2][1]
				&& (tablero[0][1] == 'X' || tablero[0][1] == 'O');
		boolean cond6 = tablero[0][2] == tablero[1][2] && tablero[0][2] == tablero[2][2]
				&& (tablero[0][2] == 'X' || tablero[0][2] == 'O');
		boolean cond7 = tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2]
				&& (tablero[0][0] == 'X' || tablero[0][0] == 'O');
		boolean cond8 = tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[2][0]
				&& (tablero[0][2] == 'X' || tablero[0][2] == 'O');

		return cond1 || cond2 || cond3 || cond4 || cond5 || cond6 || cond7 || cond8;
	}

	private static void imprimir(char[][] tablero) {
		for (int fila = 0; fila < FILAS; fila++) {
			for (int col = 0; col < COLUMNAS; col++) {
				System.out.print("[" + tablero[fila][col] + "]");
			}
			System.out.println();
		}
		System.out.println();

	}

	private static void darBienvenida(String mensajeBienvenida) {

		dibujarDivisor(mensajeBienvenida.length(), "=");
		System.out.println(mensajeBienvenida.toUpperCase());
		dibujarDivisor(mensajeBienvenida.length(), "=");
		System.out.println();
	}

	private static void dibujarDivisor(int longitud, String simbolo) {
		for (int i = 0; i < longitud; i++) {
			System.out.print(simbolo);

		}
		System.out.println();
	}

}
