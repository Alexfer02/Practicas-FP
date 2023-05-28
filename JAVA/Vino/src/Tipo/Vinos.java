package Tipo;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class Vinos {
	
	private Set<Vino> vinos;

	public Vinos() {
		this.vinos = new HashSet<Vino>();
	}

	public Vinos(Stream<Vino>vinos) {
		this.vinos=vinos.collect(Collectors.toSet());
	}
	// Flujos para el constructor de una clase vinos a partir de un stream de vino. 
	
	//Añadir vino al conjunto de vinos
	public void añadirVino(Vino v) {
		this.vinos.add(v);	
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vinos == null) ? 0 : vinos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vinos other = (Vinos) obj;
		if (vinos == null) {
			if (other.vinos != null)
				return false;
		} else if (!vinos.equals(other.vinos))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vinos [vinos=" + vinos + "]";
	}
	// metodo que devuelve el numero de vinos dado un país
	public long calcularNumeroVinosPais(String pais) {
		/*Set<Vino>aux= new HashSet<>();
		for(Vino v:this.vinos)
			if(v.getPaís().equals(pais))
				aux.add(v);
		return aux.size();*/
		//Solución alternativa con Stream
		return vinos.stream().filter(v->v.getPaís().equals(pais)).count();
	}
	//metodo para obtener vino mejor puntuado
	public Vino obtenerVinoMejorPuntuado() {
		/*Vino vino_con_mejor_puntuacion= null;//variable que almacena el nombre 
		int puntuacion_maxima=0;//variable que almacena el valor max del vino
		for(Vino v:this.vinos)
			if(v.getPuntos()>=puntuacion_maxima) {//si encontramos el vino mejor puntuado
				vino_con_mejor_puntuacion = v;//almacena el vino
				puntuacion_maxima=v.getPuntos();//almacena la puntuacion
			}
		return vino_con_mejor_puntuacion;*/
		//Solución alternativa con stream
	return vinos.stream().max(Comparator.comparing(v->v.getPuntos())).get();
	}
	//calcular vinos por país con un diccionario
	public Map<String,List<Vino>> calcularVinosPorPaís(){
		
		/*Map<String, List<Vino>> vinos_agrupados_por_país = new HashMap<>();
		for(Vino v:this.vinos)
			if(vinos_agrupados_por_país.keySet().contains(v.getPaís())) {//si vinos correspondiente al país esta en la linea, lo añadimos a los vinos ya existentes
				List<Vino> aux = vinos_agrupados_por_país.get(v.getPaís());//creamos funcion auxiliar 
				aux.add(v);													//la añadimos a aux
				vinos_agrupados_por_país.put(v.getPaís(),aux);				//y lo metemos en el diccionario
			}
		return vinos_agrupados_por_país;*/
		//Solución alternativa con Stream
		return vinos.stream().collect(Collectors.groupingBy(Vino::getPaís));
	}
	public Set<String> calcularUvasPorRegion(String region){
		/*
		Set<String> aux = new HashSet<>();
		
		for(Vino v:this.vinos)
			if(v.getRegion().equals(region))
				aux.add(v.getUva());	//ponemos v.getUva porque add no puede añadir un String
		return aux;*/
		//Solución alternativa con streams
		return vinos.stream().filter(v->v.getRegion().equals(region)).map(Vino::getUva).collect(Collectors.toSet());
	}
	public Collection<Vino> obtenerVinosRangoPuntos(int inf, int sup){
		/* Checkers.check("Error en rango", sup>= inf );
		Set<Vino>vinos_con_puntuacion_en_rango= new HashSet<Vino>();
		for(Vino v:this.vinos)
			if(v.getPuntos()>=inf && v.getPuntos()<=sup)
				vinos_con_puntuacion_en_rango.add(v);
		return vinos_con_puntuacion_en_rango; */
		//Solución alternativa con streams
		return vinos.stream().filter(v->v.getPuntos()>=inf&&v.getPuntos()<=sup).collect(Collectors.toSet());
	} 
	public Map<String, Set<String>> calcularUvasPorPaís(){
		/*
		Map<String, Set<String>> uva_agrupados_por_país = new HashMap<>();
		for(Vino u:this.vinos)
			if(uva_agrupados_por_país.keySet().contains(u.getPaís())) {//si vinos correspondiente al país esta en la linea, lo añadimos a los vinos ya existentes
				Set<String>aux1= uva_agrupados_por_país.get(u.getPaís());//creamos funcion auxiliar
				aux1.add(u.getUva());
				uva_agrupados_por_país.put(u.getPaís(),aux1);
					
				}
			else {
				Set<String>aux=new HashSet<>();
				aux.add(u.getUva());
				uva_agrupados_por_país.put(u.getPaís(),aux);
				
			}
			return uva_agrupados_por_país;*/
		//Solución alternativa con streams
		return vinos.stream().collect(Collectors.groupingBy(Vino::getPaís,Collectors.mapping(Vino::getUva, Collectors.toSet())));
	}
	public Map<String,Long> calcularCalidadPrecioPorRegionMayorDe(Double umbral){
			//1. seleccionar los vinos que superan el umbral dado(recorrido)
			//2. agrupar los vinos por region(recorrido) 
			//3. contar los vinos de cada región(recorrido)
		Map<String,Long>numero_de_vinos_por_region_que_superan_el_umbral=new HashMap<>();//variable resultado
		//1. seleccionar los vinos que superan el umbral
		Set<Vino>vinos_con_calidad_superior_al_umbral=new HashSet<>();
		for(Vino v:this.vinos)
			if(v.getCalidadPrecio()>umbral)
				vinos_con_calidad_superior_al_umbral.add(v);
		//2. agrupar los vinos por region
		Map<String, List<Vino>>vinos_con_calidad_superior_al_umbral_por_region=new HashMap<>();
		for(Vino v:vinos_con_calidad_superior_al_umbral)
			if(vinos_con_calidad_superior_al_umbral_por_region.keySet().contains(v.getRegion())) {
				List<Vino>l=vinos_con_calidad_superior_al_umbral_por_region.get(v.getRegion());
				l.add(v);
				vinos_con_calidad_superior_al_umbral_por_region.put(v.getRegion(),l);
			}
			else {
				List<Vino>l=new LinkedList<>();
				l.add(v);
				vinos_con_calidad_superior_al_umbral_por_region.put(v.getRegion(), l);
			}
		//3 contar los vinos de cada region
		for(String region:vinos_con_calidad_superior_al_umbral_por_region.keySet())
			numero_de_vinos_por_region_que_superan_el_umbral.put(region,(long)vinos_con_calidad_superior_al_umbral_por_region.get(region).size());
		return numero_de_vinos_por_region_que_superan_el_umbral;
		//return vinos.stream().filter(v->v.getCalidadPrecio()>umbral).(Vino::getRegion).count();
	}
}