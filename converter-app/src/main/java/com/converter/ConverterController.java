package com.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

	@Autowired
	private IConverterService converterService;

	@GetMapping(value = "/conversions/ktoc/{value}")
	public double celciusToKelvin(@PathVariable double value) {
		return converterService.celciusToKelvin(value);
	}
}
