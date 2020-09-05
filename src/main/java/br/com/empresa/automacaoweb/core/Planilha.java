package br.com.empresa.automacaoweb.core;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;

public class Planilha {
	
	public static void main(String[] args) throws Exception {
		String caminhoArquivo = "./src/main/resources/data/testdata.xlsx";
		
		/**
		 * Abrindo arquivo em modo de edição
		 */
		FileInputStream arquivo = new FileInputStream(caminhoArquivo);
		
		@SuppressWarnings("resource")
		XSSFWorkbook pastaTrabalho = new XSSFWorkbook(arquivo);
		
		XSSFSheet planilha = pastaTrabalho.getSheet("Plan1");
//		XSSFSheet planilha = pastaTrabalho.getSheetAt(1); //Para selecionar planilha por index
		
		int numLinhas = planilha.getLastRowNum();
		
		int numColunas = planilha.getRow(0).getLastCellNum();
		
		for (int i = 0; i <= numLinhas; i++) {
			for (int j = 0; j < numColunas; j++) {
				
				XSSFCell valorCelula = planilha.getRow(i).getCell(j);
				System.out.print(valorCelula+"	|");
			}
		System.out.println();
		}
		
	}
	
	
	
	
	
}
