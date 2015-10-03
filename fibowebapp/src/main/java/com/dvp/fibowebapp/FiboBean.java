package com.dvp.fibowebapp;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "fiboBean")
public class FiboBean {

	private static final Integer DEFAULT_RANG = 7;
	
	private Integer rang;

	private Long valeur;
	private List<FiboResult> valeurs;

	private final FiboService fiboService = FiboService.getInstance();

	public void calculer() {
		System.out.println("Calcul de la suite de Fibonacci pour le rang " + rang);

		// Je calcule d'abord la liste.
		valeurs = new ArrayList<FiboResult>(rang);
		for (int i = 1; i <= rang; i++) {
			final FiboResult fiboResult = calculerFiboResult(i);
			valeurs.add(fiboResult);
		}

		// Puis la valeur pour le rang. Ici j'aurais pu optimiser mais ce n'est
		// pas l'objet de cet article.
		valeur = fiboService.calculerFibonacci(rang);
	}

	private FiboResult calculerFiboResult(Integer rang) {
		final Long valeurExacte = fiboService.calculerFibonacci(rang);
		final Long valeurApproximative = fiboService.calculerApproximationfibonacci(rang);
		final FiboResult fiboResult = new FiboResult(rang, valeurExacte, valeurApproximative);
		return fiboResult;
	}

	/* Getters et setters */

	public Integer getRang() {
		return rang;
	}

	public void setRang(Integer rang) {
		this.rang = rang;
	}

	public Long getValeur() {
		return valeur;
	}

	public List<FiboResult> getValeurs() {
		return valeurs;
	}
	
	public Integer getDefaultRang() {
		return DEFAULT_RANG;
	}

	public List<FiboResult> getValeursInversees() {

		final List<FiboResult> result = new ArrayList<FiboResult>();
		
		for(int i = valeurs.size() - 1; 0 <= i; i--) {
			result.add(valeurs.get(i));
		}

		return result;
	}

}
