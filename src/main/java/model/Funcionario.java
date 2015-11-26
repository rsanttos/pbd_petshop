package model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="funcionario")
@SequenceGenerator(name="SEQ_FUNCIONARIO", initialValue=1, allocationSize=1, sequenceName="seq_funcionario")
public class Funcionario extends Persistence implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_FUNCIONARIO")
	@Column(name="id_funcionario")
	private Long id;

	private int salario;
	
	@OneToMany(mappedBy="funcionario")
    @Cascade({CascadeType.ALL})
	private Collection<Venda> vendas;	
	
	@ManyToOne
    @Cascade({CascadeType.ALL})
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	
	
	public Funcionario() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
