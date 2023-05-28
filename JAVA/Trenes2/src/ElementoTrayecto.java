package fp.trenes;

import java.time.LocalTime;

public record ElementoTrayecto(String nombre, 
		LocalTime horaLlegada, LocalTime horaSalida) {
}
