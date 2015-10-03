package com.dvp.fibowebapp;

import java.util.HashMap;
import java.util.Map;

public class FiboService {

	private final static double NOMBRE_OR = 1.61803398874989;
	private final static double RACINE_5 = 2.236067977499;
	
	private static FiboService instance;

	private static Map<Integer, Long> mapExact;
	private static Map<Integer, Long> mapApproximation;

	private FiboService() {
		mapExact = new HashMap<Integer, Long>();
		mapApproximation = new HashMap<Integer, Long>();
	}

	public static synchronized FiboService getInstance() {
		if (instance == null) {
			instance = new FiboService();
		}
		return instance;
	}

	public Long calculerFibonacci(Integer n) {

		// REGLE RG024.4
		if (n <= 0) {
			throw new IllegalArgumentException("On ne calcule que pour des nombres positifs");
		}

		// REGLE RG024.1 : f(1) = 1
		// REGLE RG024.2 : f(2) = 1
		if (n == 1 || n == 2) {
			return 1L;
		}

		// REGLE RG024.5
		// REGLE RG024.6
		Long valeur = mapExact.get(n);
		if (valeur != null) {
			return valeur;
		}

		// REGLE RG024.3.x
		valeur = calculerFibonacci(n - 1) + calculerFibonacci(n - 2);
		mapExact.put(n, valeur);
		return valeur;

	}

	

	public Long calculerApproximationfibonacci(Integer n) {
		if (n <= 0) {
			throw new IllegalArgumentException("On ne calcule que pour des nombres positifs");
		}

		if (n == 1 || n == 2) {
			return 1L;
		}

		Long valeur = mapApproximation.get(n);
		if (valeur != null) {
			return valeur;
		}

		final double nominateur = Math.pow(NOMBRE_OR, n);

		final double result = nominateur / RACINE_5;
		valeur = Math.round(result);
		mapApproximation.put(n, valeur);
		return valeur;
	}

}
