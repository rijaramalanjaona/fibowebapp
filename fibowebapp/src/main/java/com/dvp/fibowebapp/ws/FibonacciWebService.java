package com.dvp.fibowebapp.ws;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.dvp.fibowebapp.FiboResult;
import com.dvp.fibowebapp.FiboService;

@WebService
@SOAPBinding(style = Style.RPC)
public class FibonacciWebService {
	private final FiboService fiboService = FiboService.getInstance();

	public Long fibonacci(@WebParam(name = "rang") Integer rang) {
		Long result = fiboService.calculerFibonacci(rang);
		return result;
	}

	public FiboDTO[] fibonacciList(@WebParam(name = "rang") Integer rang,
									@WebParam(name = "limit") Integer nb) {

		int size = nb;
		if (rang < nb) {
			size = rang;
		}

		FiboDTO[] list = new FiboDTO[size];
		for (int i = 0; i < size; i++) {
			final FiboResult fiboResult = calculerFiboResult(rang - i);
			list[i] = convert(fiboResult);
		}

		return list;
	}

	private FiboDTO convert(FiboResult fiboResult) {
		FiboDTO fiboDTO = new FiboDTO();
		fiboDTO.setApproximation(fiboResult.getApproximation());
		fiboDTO.setRang(fiboResult.getRang());
		fiboDTO.setValeurApproximative(fiboResult.getValeurApproximative());
		fiboDTO.setValeurExacte(fiboResult.getValeurExacte());

		return fiboDTO;
	}

	private FiboResult calculerFiboResult(Integer rang) {
		final Long valeurExacte = fiboService.calculerFibonacci(rang);
		final Long valeurApproximative = fiboService
				.calculerApproximationfibonacci(rang);
		final FiboResult fiboResult = new FiboResult(rang, valeurExacte,
				valeurApproximative);
		return fiboResult;
	}

}
