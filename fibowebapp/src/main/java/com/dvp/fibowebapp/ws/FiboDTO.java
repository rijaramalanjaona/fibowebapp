package com.dvp.fibowebapp.ws;

public class FiboDTO {
	
	private Integer rang;
	private Long valeurExacte;
	private Long valeurApproximative;
	private Long approximation;

	public FiboDTO() {
		super();
	}
	
	

	public Integer getRang() {
		return rang;
	}

	public void setRang(Integer rang) {
		this.rang = rang;
	}

	public Long getValeurExacte() {
		return valeurExacte;
	}

	public void setValeurExacte(Long valeurExacte) {
		this.valeurExacte = valeurExacte;
	}

	public Long getValeurApproximative() {
		return valeurApproximative;
	}

	public void setValeurApproximative(Long valeurApproximative) {
		this.valeurApproximative = valeurApproximative;
	}

	public Long getApproximation() {
		return approximation;
	}

	public void setApproximation(Long approximation) {
		this.approximation = approximation;
	}

}