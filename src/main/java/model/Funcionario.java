package model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="funcionario")
@PrimaryKeyJoinColumn(name="id_funcionario")
public class Funcionario extends Pessoa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int salario;
	
	@OneToMany(mappedBy="funcionario")
    @Cascade({CascadeType.MERGE, CascadeType.REMOVE})
	private Collection<Venda> vendas;	
	
	public Collection<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(Collection<Venda> vendas) {
		this.vendas = vendas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Funcionario() {
		super();
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	public void imprime(){
		System.out.println("Salário: " + this.salario);
	}
}
