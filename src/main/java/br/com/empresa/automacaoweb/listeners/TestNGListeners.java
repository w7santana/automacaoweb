package br.com.empresa.automacaoweb.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("\n ------------------ TESTE INICIADO: " + result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("\n ------------------ O TESTE PASSOU: " + result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("\n ------------------ O TESTE FALHOU: " + result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("\n ------------------ O TESTE FOI PULADO: " + result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * este método invoca quando a classe de teste é instanciada e antes de executar qualquer método de teste.
	 */
	public void onStart(ITestContext context) {
		System.out.println(context.getName());		
	}
	
	/*
	 * Este método invoca quando todos os métodos de teste são executados e ocorre a chamada de todos os seus métodos de configuração.
	 */
	public void onFinish(ITestContext context) {
		System.out.println("\n ------------------ TESTES FINALIZADOS");
		
	}
	
	

}
