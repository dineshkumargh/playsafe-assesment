package com.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

	@Autowired
	private IConverterService converterService;

	@GetMapping(value = "/conversions/ctok/{value}")
	public double celciusToKelvin(@PathVariable double value) {
		return converterService.celsiusToKelvin(value);
	}

	@GetMapping(value = "/conversions/ktoc/{value}")
	public double kelvinToCelcius(@PathVariable double value) {
		return converterService.kelvinToCelsius(value);
	}

	@GetMapping(value = "/conversions/ktom/{value}")
	public double kilometerToMile(@PathVariable double value) {
		return converterService.kilometerToMile(value);
	}

	@GetMapping(value = "/conversions/mtok/{value}")
	public double mileToKilometer(@PathVariable double value) {
		return converterService.mileToKilometer(value);
	}

}