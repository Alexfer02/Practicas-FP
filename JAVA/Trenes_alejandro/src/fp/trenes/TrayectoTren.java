package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public interface TrayectoTren{
	String getCodigo();
	String getNombre();
	
	TipoTren getTipo();
	List<String> getEstaciones();
	List<LocalTime> getHoras_salida();
	List<LocalTime> getHoras_llegada();
	
	public LocalTime getHoraSalida();
	public LocalTime getHoraLlegada();
	public Duration getDuracionTrayecto();
	
	LocalTime getHoraSalida(String estacion);
	LocalTime getHoraLlegada(String estacion);
	
	void anadirEstacionIntermedia(int posicion, String estacion,LocalTime horaLlegada,LocalTime horaSalida);
	void eliminarEstacionIntermedia(String estacion);
}
