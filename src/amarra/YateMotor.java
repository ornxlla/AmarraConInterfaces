package amarra;

public class YateMotor extends Yate {
	
	public YateMotor(String nombre, String duenio, Double manga, Double calado, Double eslora, Integer tripulacion,
			Double peso) {
		super(nombre, duenio, manga, calado, eslora, tripulacion, peso);
		this.precioTipo = 10000.0;
	}

}
