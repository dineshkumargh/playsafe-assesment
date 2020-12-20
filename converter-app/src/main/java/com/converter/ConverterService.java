package com.converter;

import org.springframework.stereotype.Service;

@Service
public class ConverterService implements IConverterService {

	@Override
	public double kelvinToCelsius(double value) {
		return value - 273.15;
	}

	@Override
	public double celsiusToKelvin(double value) {
		return value + 273.15;
	}

	@Override
	public double kilometerToMile(double value) {
		return value * 0.621371;
	}

	@Override
	public double mileToKilometer(double value) {
		return value * 1.60934;
	}

}