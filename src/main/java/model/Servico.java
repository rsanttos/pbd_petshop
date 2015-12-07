package model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Persistence;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import dao.Persistencia;

@Entity
@Table(name="servico")
@SequenceGenerator(name="SEQ_SERVICO", initialValue=1, allocationSize=1, sequenceName="seq_servico")
public class Servico extends Persistence implements Persistencia {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SERVICO")
	@Column(name="id_servico")
	private Long id;
	
	private int preco;
	private String descricao;	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="venda_servico",
			joinColumns = @JoinColumn(name="id_servico"),
			inverseJoinColumns = @JoinColumn(name="id_venda"))
	private Collection<Venda> vendas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Collection<Venda> getVendas() {
		return vendas;
	}
	public void setVendas(Collection<Venda> vendas) {
		this.vendas = vendas;
	}
	public Servico() {
		super();
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void imprime(){
		System.out.println("Id: " + this.id + "Preço: " + this.preco
				+ "Descricao: " + this.descricao);
	}
	

}
