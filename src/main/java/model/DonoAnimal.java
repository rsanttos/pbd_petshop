package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

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

import dao.Persistencia;

@Entity
@Table(name="donoanimal")
@SequenceGenerator(name="SEQ_DONOANIMAL", initialValue=1, allocationSize=1, sequenceName="seq_donoanimal")
public class DonoAnimal extends Persistence implements Serializable, Persistencia {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DONOANIMAL")
	@Column(name="id_donoanimal")
	private Long id;

	private Date dataCadastro;
	
	@OneToMany(mappedBy="donoanimal")
    @Cascade({CascadeType.ALL})
	private Collection<Animal> animais;
	
	@OneToMany(mappedBy="donoanimal")
    @Cascade({CascadeType.ALL})
	private Collection<Venda> vendas;	

	@ManyToOne
    @Cascade({CascadeType.ALL})
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	
	
	
	public DonoAnimal() {
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
