package amarra;

import java.util.TreeSet;

public class Fondeadero {

	private TreeSet<Yate> yates = new TreeSet<Yate>();
	private Integer cantidadMaximaDeAmarras;
	private Double precioIndividual = 0.0;
	private Double precioFinal = 0.0;

	public Fondeadero(Integer cantidadMaximaDeAmarras) {
		this.cantidadMaximaDeAmarras = cantidadMaximaDeAmarras;
	}

	public TreeSet<Yate> ordenarYatePorSuNombre() {
		return yates;
	}

	public Integer getCantidadMaximaDeAmarras() {
		return cantidadMaximaDeAmarras;
	}
	
	public Integer yatesAmarrados() {
		return this.yates.size();
	}

	public Double getPrecioIndividual() {
		return precioIndividual;
	}

	public TreeSet<Yate> ordenarYatePorNombreDelDuenio(){
		TreeSet<Yate> ordenarPorNombre = new TreeSet<Yate>(new PorNombreDeDuenioComparator());
		ordenarPorNombre.addAll(yates);
		return ordenarPorNombre;
	}
	
	public Boolean amarrarYate(Yate yate) throws NoHayAmarrasDisponibles {
		if(this.yatesAmarrados() < this.cantidadMaximaDeAmarras) {
			this.yates.add(yate);
			return true;
		}
		throw new NoHayAmarrasDisponibles("No hay amarras disponibles");
	}

	public void desamarrarYate(Yate yate) {
		this.yates.remove(yate);
	}
	
	public Double obtenerPrecioDeAmarre(Yate yate) {
		if(yate.getEslora() > 20.0) {
			this.precioIndividual = yate.getPrecioTipo() + yate.getPRECIO_ESLORA_MIN();
		} else {
			this.precioIndividual = yate.getPrecioTipo() + yate.getPRECIO_ESLORA_MAX();
		}
		return this.precioIndividual;
	}

	public Double obtenerRecaudacionFinal() {
		for(Yate yate:yates) {
			this.precioFinal += this.obtenerPrecioDeAmarre(yate);
		}
		return this.precioFinal;
	}

	
}
