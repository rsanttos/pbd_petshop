package model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="donoanimal")
@PrimaryKeyJoinColumn(name="id_donoanimal")
public class DonoAnimal extends Pessoa {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date dataCadastro;
	
	@OneToMany(mappedBy="donoanimal")
    @Cascade({CascadeType.MERGE, CascadeType.REMOVE})
	private Collection<Animal> animais;
	
	@OneToMany(mappedBy="donoanimal")
    @Cascade({CascadeType.MERGE, CascadeType.REMOVE})
	private Collection<Venda> vendas;
	
	
	public Collection<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(Collection<Animal> animais) {
		this.animais = animais;
	}

	public Collection<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(Collection<Venda> vendas) {
		this.vendas = vendas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DonoAnimal(){
		this.dataCadastro = new Date();
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public void imprime(){
		System.out.println("Data de cadastro: " + this.dataCadastro);
	}
	
}
