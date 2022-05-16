package com.tokio.marine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 6)
	private String contaOrigem;
	
	@Column(length = 6)
	private String contaDestino;
	
	private double valor;
	
	private int dataTransferencia;
	
	private int dataAgendamento;
	
	private double taxa;
	
	private int dias;
	
	public int dias(int dataTransferencia, int dataAgendamento) {
		var total = 0;
		if(dataAgendamento> dataTransferencia) {
			total = dataAgendamento - dataTransferencia;
		}else {
			total = dataTransferencia - dataAgendamento;
		}
		return total;
	}
	
	public double taxa(double valor, int dias) {
		if (dias == 0)  {
			return (((valor+3) * 1.3) - valor);
		}
		else if (dias >= 1 && dias <= 10) {
			return ((valor + 12) - valor);
		}
		else if (dias > 10 && dias <= 20) {
			return ((valor * 1.082) - valor);
		}
		else if (dias > 20 && dias <= 30) {
			return ((valor * 1.069) - valor);
		}
		else if (dias > 30 && dias <= 40) {
			return ((valor * 1.047) - valor);
		} else {
			return ((valor * 1.017) - valor);
		}
	}
	

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(int dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public int getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(int dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public double getTaxa(double taxa) {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	
	public double getDias(int dias) {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}


}
