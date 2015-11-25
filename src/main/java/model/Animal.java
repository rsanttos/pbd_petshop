package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="animal")
@SequenceGenerator(name="SEQ_ANIMAL", initialValue=1, allocationSize=1, sequenceName="seq_animal")
public class Animal extends Persistence{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ANIMAL")
	@Column(name="id_animal")
	private Long id;
	
	private int idade;
	private String nome;
	private String tipo;
	private String raca;
	private String sexo;
	
	@ManyToOne
    @Cascade({CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="id_donoanimal")
	private DonoAnimal donoanimal;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DonoAnimal getDonoanimal() {
		return donoanimal;
	}
	public void setDonoanimal(DonoAnimal donoanimal) {
		this.donoanimal = donoanimal;
	}
	public Animal() {
		super();
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void imprime(){
		System.out.println("Id: " + this.id + "Idade: " + this.idade + "Nome: " + this.nome
					+ "Tipo: " + this.tipo + "Raça: " + this.raca
					+ "Sexo: " + this.sexo);
	}
}
