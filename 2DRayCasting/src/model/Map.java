package model;

public class Map {
	public Map() {

	}
	
	public Double mapDouble(Double d, Double e, Double f, Double g, Double h) {
	    return (g + (h - g) * ((d - e) / (f - e)));
	 }
	
	public Integer mapInteger(Integer d, Integer e, Integer f, Integer g, Integer h) {
	    return (g + (h - g) * ((d - e) / (f - e)));
	 }
}
