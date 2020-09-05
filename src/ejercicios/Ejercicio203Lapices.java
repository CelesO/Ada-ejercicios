package ejercicios;

import java.util.Scanner;

public class Ejercicio203Lapices {

	// private static final int PRECIO_NOMINA = 90;
	// private static final int PRECIO_MAYOR = 85;

	private static final int PRECIO_NOMINA = 90;
	private static final int PRECIO_MAYOR = 85;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// de 1000 en adelante precio es 85
		// sino es 90
		// solicitar cantidad de lapices
		// informar el total

		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese cantidad de lapices ");
		int cant = sc.nextInt();

		int precioL = 0;

		if (cant < 1000) {
			precioL = PRECIO_NOMINA * cant;
		} else if (cant > 1000) {
			precioL = PRECIO_MAYOR * cant;
		} else {
			System.out.println("Cantidad invalida: ");
		}

		sc.close();
		System.out.println("El costo total es $ " + precioL);

	}

}
