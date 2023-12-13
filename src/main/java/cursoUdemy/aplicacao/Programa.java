package cursoUdemy.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import cursoUdemy.model.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do Quarto :");
		int numero = entrada.nextInt();

		System.out.print("Data do check-In (dd/MM/yyyy)");
		Date checkin = sdf.parse(entrada.next());

		System.out.print("Data do check-out  (dd/MM/yyyy)");
		Date checkOut = sdf.parse(entrada.next());

		if (!checkOut.after(checkin)) {
			System.out.println(
					"Error in reservation: Check-out date must be after check-in date");

		} else {

			Reserva reserva = new Reserva(numero, checkin, checkOut);
			System.out.println("Reserva" + reserva);

			System.out.println();
			System.out.println("Entre com data para reserva.");

			checkin = sdf.parse(entrada.next());

			System.out.print("Data do check-out  (dd/MM/yyyy)");
			checkOut = sdf.parse(entrada.next());

			Date agora = new Date();
			if (checkin.before(agora) || checkOut.before(agora)) {

				System.out.println(
						"Error in reservation: Reservation dates for update must be future dates");

			} else if (!checkin.after(checkin)) {

				System.out.println(
						"Error in reservation: Check-out date must be after check-in date");

			} else {
				reserva.updateData(checkin, checkOut);
				System.out.println("Reserva :" + reserva);

			}
			reserva.updateData(checkin, checkOut);
			System.out.println("Reserva" + reserva);

		}

		entrada.close();
	}

}
