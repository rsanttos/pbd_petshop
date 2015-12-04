package model;

import java.util.List;

import javax.persistence.Transient;

public class AnimalDoDono {
	private Animal animal;
	private DonoAnimal dono;

	@Transient
	private List<Object[]> listatemporaria;
	
	public AnimalDoDono() {
		super();
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public DonoAnimal getDono() {
		return dono;
	}
	public void setDono(DonoAnimal dono) {
		this.dono = dono;
	}
	public List<Object[]> getListatemporaria() {
		return listatemporaria;
	}
	public void setListatemporaria(List<Object[]> lista) {
		this.listatemporaria = lista;
	}
}
