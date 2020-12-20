package com.converter;

import org.springframework.stereotype.Service;

@Service
public class ConverterService implements IConverterService {

	@Override
	public double celciusToKelvin(double value) {
		return value + 273.15;
	}
}
