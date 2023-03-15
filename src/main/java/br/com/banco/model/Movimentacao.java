package br.com.banco.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_movimentacao")
public class Movimentacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num_seq")
	private int numSeq;
	@Column(name = "data_operacao", nullable = false)
	private LocalDate dataMovim;
	@Column(name = "valor", nullable = false)
	private double valor;
	@Column(name = "tipo_operacao", nullable = false)
	private int tipoOper;
	@Column(name = "descricao", length = 255)
	private String descricao;
	@ManyToOne
	@JoinColumn(name = "numero_conta")
	private Conta conta;

	public int getNumSeq() {
		return numSeq;
	}

	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}

	public LocalDate getDataMovim() {
		return dataMovim;
	}

	public void setDataMovim(LocalDate dataMovim) {
		this.dataMovim = dataMovim;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getTipoOper() {
		return tipoOper;
	}

	public void setTipoOper(int tipoOper) {
		this.tipoOper = tipoOper;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Movimentacao() {
		super();
		// TODO Auto-generated constructor stub
	}



} // Movimentacao
