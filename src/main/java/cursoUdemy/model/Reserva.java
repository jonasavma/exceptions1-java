package cursoUdemy.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import cursoUdemy.model.exception.DomainException;

public class Reserva {

	private Integer salaNumero;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer salaNumero, Date checkIn, Date checkOut) {
		if (!checkIn.after(checkIn)) {

			throw new DomainException(
					"Error in reservation: Check-out date must be after check-in date");

		}
		this.salaNumero = salaNumero;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getSalaNumero() {
		return salaNumero;
	}

	public void setSalaNumero(Integer salaNumero) {
		this.salaNumero = salaNumero;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {

		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}

	public void updateDates(Date checkIn, Date checkOut) {

		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {

			throw new DomainException(
					"Error in reservation: Reservation dates for update must be future dates");

		}
		if (!checkIn.after(checkIn)) {

			throw new DomainException(
					"Error in reservation: Check-out date must be after check-in date");

		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}

	@Override
	public String toString() {
		return "Quarto" + salaNumero + ", checkIn=" + sdf.format(checkIn)
				+ ", checkOut=" + sdf.format(checkOut) + ":" + duracao()
				+ "=> noite:";
	}

}
