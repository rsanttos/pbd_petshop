package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Persistence;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pessoa")
@SequenceGenerator(name="SEQ_PESSOA", initialValue=1, allocationSize=1, sequenceName="seq_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)

public class Pessoa extends Persistence implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PESSOA")
	@Column(name="id_pessoa")
	private Long id;
	
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String nome;
	private String cpf;
	private String sexo;
	private Date dataNascimento;
	
	public Pessoa(){
		this.nome = null;
		this.cpf = null;
		this.sexo = null;
		this.dataNascimento = null;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void imprime(){
		System.out.println("Id: " + this.id + "Nome: " + this.nome
					+ "CPF: " + this.cpf + "Sexo: " + this.sexo
					+ "Data de Nascimento: " + this.dataNascimento);
	}	
	
}
