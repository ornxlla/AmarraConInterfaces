package amarra;

import static org.junit.Assert.*;

import org.junit.Test;

public class YatchPuertoBlackTest {

	@Test
	public void queSePuedaAmarrarElYate() throws NoHayAmarrasDisponibles {
		Fondeadero fondeadero = new Fondeadero(70);
		Yate yateMotor = new YateMotor("AZ1", "Andres Borgeat", 18.87, 5.15, 119.0, 37, 5500.0);
		Yate yateVela = new YateVela("XXR", "Sebastian Pardo", 6.90, 2.7, 13.45, 5, 1400.0);
		
		assertTrue(fondeadero.amarrarYate(yateMotor));
		assertTrue(fondeadero.amarrarYate(yateVela));
	}

	@Test (expected = NoHayAmarrasDisponibles.class)
	public void queNoSePuedaAmarrarElYate() throws NoHayAmarrasDisponibles {
		Fondeadero fondeadero = new Fondeadero(5);
		Yate yateMotor = new YateMotor("AZ1", "Andres Borgeat", 18.87, 5.15, 119.0, 37, 5500.0);
		Yate yateVela = new YateVela("XXT", "Sebastian Pardo", 6.90, 2.7, 13.45, 5, 1400.0);
		Yate yateMotor2 = new YateMotor("AZ2", "Andres Borgeat", 18.87, 5.15, 119.0, 37, 5500.0);
		Yate yateVela2 = new YateVela("XXR", "Sebastian Pardo", 6.90, 2.7, 13.45, 5, 1400.0);
		Yate yateMotor3 = new YateMotor("AP1", "Andres Borgeat", 18.87, 5.15, 119.0, 37, 5500.0);
		Yate yateVela3 = new YateVela("XER", "Sebastian Pardo", 6.90, 2.7, 13.45, 5, 1400.0);
		
		
		assertTrue(fondeadero.amarrarYate(yateMotor));
		assertTrue(fondeadero.amarrarYate(yateVela));
		assertTrue(fondeadero.amarrarYate(yateVela2));
		assertTrue(fondeadero.amarrarYate(yateMotor2));
		assertTrue(fondeadero.amarrarYate(yateVela3));
		assertFalse(fondeadero.amarrarYate(yateMotor3));
	}
	
	@Test
	public void queSePuedaDesamarrarYateYObtenerLaCantidadDeYatesAmarrados() throws NoHayAmarrasDisponibles {
		Fondeadero fondeadero = new Fondeadero(70);
		Yate yateMotor = new YateMotor("AZ1", "Andres Borgeat", 18.87, 5.15, 119.0, 37, 5500.0);
		Yate yateVela = new YateVela("XXR", "Sebastian Pardo", 6.90, 2.7, 13.45, 5, 1400.0);
		
		assertTrue(fondeadero.amarrarYate(yateMotor));
		assertTrue(fondeadero.amarrarYate(yateVela));
		
		fondeadero.desamarrarYate(yateMotor);
		assertEquals((Integer)1, fondeadero.yatesAmarrados());
	}
	
	@Test
	public void obtenerElPrecioDeAmarraVela() throws NoHayAmarrasDisponibles {
		Fondeadero fondeadero = new Fondeadero(70);
		Yate yateVela = new YateVela("XXR", "Sebastian Pardo", 6.90, 2.7, 13.45, 5, 1400.0);
		fondeadero.amarrarYate(yateVela);
		assertEquals((Double)12000.0, fondeadero.obtenerPrecioDeAmarre(yateVela));
	}

	@Test
	public void obtenerElPrecioDeAmarraMotor() throws NoHayAmarrasDisponibles {
		Fondeadero fondeadero = new Fondeadero(70);
		Yate yateMotor = new YateMotor("AZ1", "Andres Borgeat", 18.87, 5.15, 119.0, 37, 5500.0);
		fondeadero.amarrarYate(yateMotor);
		assertEquals((Double)12000.0, fondeadero.obtenerPrecioDeAmarre(yateMotor));
	}
	
	@Test
	public void obtenerRecaudacionTotal() throws NoHayAmarrasDisponibles {
		Fondeadero fondeadero = new Fondeadero(70);
		Yate yateMotor = new YateMotor("AZ1", "Andres Borgeat", 18.87, 5.15, 119.0, 37, 5500.0);
		Yate yateVela = new YateVela("XXR", "Sebastian Pardo", 6.90, 2.7, 13.45, 5, 1400.0);
		fondeadero.amarrarYate(yateVela);
		fondeadero.amarrarYate(yateMotor);
		
		assertEquals((Double)24000.0, fondeadero.obtenerRecaudacionFinal());
	}
	
	@Test
	public void ordenarYatesPorNombre() throws NoHayAmarrasDisponibles {
		Fondeadero fondeadero = new Fondeadero(70);
		Yate yateMotor = new YateMotor("AZ1", "Andres Borgeat", 18.87, 5.15, 119.0, 37, 5500.0);
		Yate yateVela = new YateVela("XXR", "Sebastian Pardo", 6.90, 2.7, 13.45, 5, 1400.0);
		fondeadero.amarrarYate(yateVela);
		fondeadero.amarrarYate(yateMotor);
		
		assertEquals(fondeadero.ordenarYatePorSuNombre().first(), yateMotor);
		assertEquals(fondeadero.ordenarYatePorSuNombre().last(), yateVela);
	}
	
	@Test
	public void ordenarYatesPorNombreDelDuenio() throws NoHayAmarrasDisponibles {
		Fondeadero fondeadero = new Fondeadero(70);
		Yate yateMotor = new YateMotor("AZ1", "Andres Borgeat", 18.87, 5.15, 119.0, 37, 5500.0);
		Yate yateVela = new YateVela("XXR", "Sebastian Pardo", 6.90, 2.7, 13.45, 5, 1400.0);
		Yate yateMotor2 = new YateMotor("A51", "Uriel Moretti", 18.87, 5.15, 119.0, 37, 5500.0);
		fondeadero.amarrarYate(yateVela);
		fondeadero.amarrarYate(yateMotor);
		fondeadero.amarrarYate(yateMotor2);	
		
		assertEquals(fondeadero.ordenarYatePorNombreDelDuenio().first(), yateMotor);
		assertEquals(fondeadero.ordenarYatePorNombreDelDuenio().last(), yateMotor2);
		}
}
