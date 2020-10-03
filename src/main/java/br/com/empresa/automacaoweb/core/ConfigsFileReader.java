package br.com.empresa.automacaoweb.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
 * Essa classe lê as propriedades do arquivo de configurações com extensão .properties
 */
public class ConfigsFileReader {
	private static Properties properties;
	private static final String propertyFilePath = "./configs/projeto.properties";

	public ConfigsFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Arquivo de configuração (extensão .properties) não encontrado em " + propertyFilePath);
		}
	}
	
	public static String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		throw new RuntimeException("Propriedade 'driverPath' não configurada em " + propertyFilePath);
	}

}
