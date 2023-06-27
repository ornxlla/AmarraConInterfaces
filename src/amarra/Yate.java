package amarra;

import java.util.Objects;

public class Yate implements Comparable<Yate>{

	protected String nombre;
	protected String duenio;
	protected Double manga;
	protected Double calado;
	protected Double eslora;
	protected Integer tripulacion;
	protected Double peso;
	protected Double precioTipo;
	protected final Double PRECIO_ESLORA_MIN = 2000.0;
	protected final Double PRECIO_ESLORA_MAX = 3000.0;
	
	
	public Yate(String nombre, String duenio, Double manga, Double calado, Double eslora, Integer tripulacion, Double peso) {
		this.nombre = nombre;
		this.duenio = duenio;
		this.manga = manga;
		this.calado = calado;
		this.eslora = eslora;
		this.tripulacion = tripulacion;
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDuenio() {
		return duenio;
	}

	public Double getManga() {
		return manga;
	}

	public Double getCalado() {
		return calado;
	}
	
	public Double getEslora() {
		return eslora;
	}

	public Integer getTripulacion() {
		return tripulacion;
	}

	public Double getPeso() {
		return peso;
	}

	public Double getPrecioTipo() {
		return precioTipo;
	}

	public Double getPRECIO_ESLORA_MIN() {
		return PRECIO_ESLORA_MIN;
	}

	public Double getPRECIO_ESLORA_MAX() {
		return PRECIO_ESLORA_MAX;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Yate other = (Yate) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Yate o) {
		return this.nombre.compareTo(o.nombre);
	}
	
	
}
