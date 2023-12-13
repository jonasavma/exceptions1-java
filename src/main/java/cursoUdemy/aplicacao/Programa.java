package cursoUdemy.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import cursoUdemy.model.Reserva;
import cursoUdemy.model.exception.DomainException;

public class Programa {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do Quarto :");
			int numero = entrada.nextInt();

			System.out.print("Data do check-In (dd/MM/yyyy)");
			Date checkIn = sdf.parse(entrada.next());

			System.out.print("Data do check-out  (dd/MM/yyyy)");
			Date checkOut = sdf.parse(entrada.next());
			Reserva reserva = new Reserva(numero, checkIn, checkOut);

			System.out.println("Reserva" + reserva);

			System.out.println();

			System.out.println("Entre com data para reserva.");
			checkIn = sdf.parse(entrada.next());

			System.out.print("Data do check-out  (dd/MM/yyyy)");
			checkOut = sdf.parse(entrada.next());

			reserva.updateDates(checkIn, checkOut);
			System.out.println("Reserva :" + reserva);
		} catch (ParseException e) {
			System.out.println("Data com formato de data errado .");
		} catch (DomainException e) {
			System.out.println("Error em reserva :  " + e.getMessage());
		}catch (RuntimeException e) {
            System.out.println("Error inesperado");
		}

		entrada.close();
	}

}
