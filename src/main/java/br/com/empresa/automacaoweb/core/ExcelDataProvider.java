package br.com.empresa.automacaoweb.core;

import org.apache.poi.xssf.usermodel.XSSFCell;

public class ExcelDataProvider {
	
	@org.testng.annotations.DataProvider(name="nomeDataProvider")
	public static Object[][] getData() {
		
		Object data[][] = testData("./src/main/resources/data/testdata.xlsx", "Plan1");
		return data;
	}
	
	public static Object[][] testData(String caminhoExcel, String nomePlanilha) {
		
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
