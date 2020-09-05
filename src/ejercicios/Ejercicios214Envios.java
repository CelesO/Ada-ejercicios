package ejercicios;

import java.util.Scanner;
//tenemos que hacer esta importacion de clase para que java pueda acceder a todos los atributos

public class Ejercicios214Envios {

	private static final int PESO_MAX = 5000;
	private static final int ZONA_1 = 11;
	private static final int ZONA_2 = 10;
	private static final int ZONA_3 = 12;
	private static final int ZONA_4 = 24;
	private static final int ZONA_5 = 27;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// Con el System.in le decimos a Scanner que vamos a ingresar (in) en el sistema
		// (System)

		System.out.println("Bienvenido");
		System.out.println("Ingrese el peso de su paquete en gramos ");
		int peso = sc.nextInt();

		if (peso > 0 && peso <= PESO_MAX) {
			System.out.println("America del Norte 1, America Central 2, America Sur 3, Europa 4, Asia 5");
			System.out.println("Ingrese zona de envío: ");
			int zona = sc.nextInt();

			int costoEnvio = 0;

			switch (zona) {
			case 1:
				costoEnvio = peso * ZONA_1;
				break;
			case 2:
				costoEnvio = peso * ZONA_2;
				break;
			case 3:
				costoEnvio = peso * ZONA_3;
				break;
			case 4:
				costoEnvio = peso * ZONA_4;
				break;
			case 5:
				costoEnvio = peso * ZONA_5;
				break;

			default:
				System.out.println("Zona incorrecta");

			}
			System.out.println("");

		} else {
			System.out.println("");

			// sc.close();?
		}

	}
}
