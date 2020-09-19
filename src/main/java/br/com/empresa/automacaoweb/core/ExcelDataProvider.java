package br.com.empresa.automacaoweb.core;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	@DataProvider(name="nomeDataProvider")
	public Object[][] getData() throws Exception {
		
		Object data[][] = testData("./src/main/resources/data/testdata.xlsx", "Plan1");
		return data;
	}
	
	public Object[][] testData(String caminhoExcel, String nomePlanilha) throws Exception {
		
		ManipuladorPlanilha planilha = new ManipuladorPlanilha(caminhoExcel, nomePlanilha);
		int numLinhas = planilha.getNumLinhasPlanilha();
		int numColunas = planilha.getNumColunas();

		Object data [][] = new Object [numLinhas][numColunas];
		
			for (int linha = 1; linha <= numLinhas; linha++) {
				for (int coluna = 0; coluna < numColunas; coluna++) {
//					XSSFCell valorCelula = planilha.getRow(linha).getCell(coluna);
					String valorCelula = planilha.getTextoCelula(linha, coluna);
					data[linha-1][coluna] = valorCelula;
//					System.out.print(valorCelula+"	|");
//					System.out.println(data.toString());
				}
				System.out.println();
			}
			return data;
	}
	
	
	
}
