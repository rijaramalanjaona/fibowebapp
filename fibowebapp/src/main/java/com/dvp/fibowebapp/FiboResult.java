package com.dvp.fibowebapp;

public class FiboResult {

	private Integer rang;
	private Long valeurExacte;
	private Long valeurApproximative;
	private Long approximation;

	public FiboResult(Integer rang, Long valeurExacte, Long valeurApproximative) {
		super();

		this.rang = rang;
		this.valeurExacte = valeurExacte;
		this.valeurApproximative = valeurApproximative;

		this.approximation = Math.abs(valeurExacte - valeurApproximative);
	}

	/* hashcode / equals / tostring */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rang == null) ? 0 : rang.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "FiboResult [rang=" + rang + ", valeurExacte=" + valeurExacte + ", valeurApproximative=" + valeurApproximative + ", approximation="
				+ approximation + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FiboResult other = (FiboResult) obj;
		if (rang == null) {
			if (other.rang != null)
				return false;
		} else if (!rang.equals(other.rang))
			return false;
		return true;
	}

	/* Getter et setter */

	public Integer getRang() {
		return rang;
	}

	public Long getValeurExacte() {
		return valeurExacte;
	}

	public Long getValeurApproximative() {
		return valeurApproximative;
	}

	public Long getApproximation() {
		return approximation;
	}

}
