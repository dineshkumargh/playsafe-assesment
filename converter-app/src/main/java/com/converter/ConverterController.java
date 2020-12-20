package com.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

	@Autowired
	private IConverterService converterService;

	@GetMapping(value = "/conversions/ctok")
	public double celciusToKelvin(@RequestParam double value) {
		return converterService.celsiusToKelvin(value);
	}

	@GetMapping(value = "/conversions/ktoc")
	public double kelvinToCelcius(@RequestParam double value) {
		return converterService.kelvinToCelsius(value);
	}

	@GetMapping(value = "/conversions/ktom")
	public double kilometerToMile(@RequestParam double value) {
		return converterService.kilometerToMile(value);
	}

	@GetMapping(value = "/conversions/mtok")
	public double mileToKilometer(@RequestParam double value) {
		return converterService.mileToKilometer(value);
	}

}