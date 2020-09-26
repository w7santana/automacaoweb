package br.com.empresa.automacaoweb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {
	
	public static void main(String[] args) {
		testaLog();

	}
	
	public static void testaLog() {
		
		int numA=1;
		int numB=2;
		Logger logger = LogManager.getLogger(Demo.class);
		System.out.println("testando logs!"+numA+numB);
        
        logger.info("Essa é uma msg de informação (Log4j)!");
        logger.error("Essa é uma msg de erro!");
        logger.warn("Essa é uma msg de alerta!");
        logger.fatal("Essa é uma msg fatal!");
        
	}

}
