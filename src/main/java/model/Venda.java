package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="venda")
@SequenceGenerator(name="SEQ_VENDA", initialValue=1, allocationSize=1, sequenceName="seq_venda")
public class Venda extends Persistence implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_VENDA")
	@Column(name="id_venda")
	private Long id;
	
	private Date dataVenda;
	
	@ManyToOne
    @Cascade({CascadeType.ALL})
	@JoinColumn(name="id_donoanimal")
	private DonoAnimal donoanimal;
	
	@ManyToOne
    @Cascade({CascadeType.ALL})
	@JoinColumn(name="id_funcionario")
	private Funcionario funcionario;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="venda_servico",
			joinColumns = @JoinColumn(name="id_venda"),
			inverseJoinColumns = @JoinColumn(name="id_servico"))
	private Collection<Servico> servicos;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="venda_produto",
			joinColumns = @JoinColumn(name="id_venda"),
			inverseJoinColumns = @JoinColumn(name="id_produto"))
	private Collection<Produto> produtos;
	
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Collection<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(Collection<Servico> servicos) {
		this.servicos = servicos;
	}

	public Collection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Venda() {
		super();
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public void imprime(){
		System.out.println("Id: " + this.id + "Data da venda: " + this.dataVenda);
	}
	
}
