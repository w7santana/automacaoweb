package br.com.empresa.automacaoweb.core;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ManipuladorPlanilha {
	private XSSFWorkbook pastaDeTrabalho;
	private XSSFSheet planilha;
	private FileInputStream arquivo;
	private int numeroDeLinhas, numeroDeColunas;
	DataFormatter formatter = new DataFormatter();
	
	public ManipuladorPlanilha(String caminhoExcel, String nomePlanilha) throws IOException {
		try {
			arquivo = new FileInputStream(caminhoExcel);
			pastaDeTrabalho = new XSSFWorkbook(arquivo);
			planilha = pastaDeTrabalho.getSheet(nomePlanilha);
		} catch (Exception e) {
			System.out.println("Não foi possível abrir o arquivo ou a planilha :-( /n Verifique o caminho completo do arquivo e o nome da planilha");
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		infoPlanilha();
	}
	
	public int getNumLinhasPlanilha() {
//		numeroDeLinhas = planilha.getPhysicalNumberOfRows();
		numeroDeLinhas = planilha.getLastRowNum();
		
//		System.out.println("Número de linhas da planilha: "+numeroDeLinhas);
		return numeroDeLinhas;
	}
	
	public int getNumColunas() {
		numeroDeColunas = planilha.getRow(0).getLastCellNum();
//		System.out.println("A planilha tem: "+numeroDeColunas+" colunas");
		return numeroDeColunas;
	}
	
	public void infoPlanilha() {
		System.out.println("A planilha "+planilha.getSheetName()+" possui "+getNumColunas()+" COLUNAS e "+getNumLinhasPlanilha()+" LINHAS  \n");
	}
	
//	public void lerDadosTabela() {
//		for (int linha = 1; linha <= numeroDeLinhas; linha++) {
//			for (int coluna = 0; coluna < numeroDeColunas; coluna++) {
//				XSSFCell valorCelula = planilha.getRow(linha).getCell(coluna);
//				System.out.print(valorCelula+"	|");
//			}
//			System.out.println();
//		}
//	}
	
	//TODO experimentando retorno em string ou xssfcell
	public String getTextoCelula(int linha, int coluna) {
		String valorCelula = formatter.formatCellValue(planilha.getRow(linha).getCell(coluna));
//		System.out.print(valorCelula+"	|");
		return valorCelula;
	}
	
//	//TODO experimentando retorno em string ou xssfcell
//	public String getTextoCelula(int linha, int coluna) {
//		XSSFCell valorCelula = planilha.getRow(linha).getCell(coluna);
////		System.out.print(valorCelula+"	|");
//		return valorCelula.toString();
//	}
//	
	public Double getCelulaNumber(int linha, int coluna) {
		Double valorCelula = planilha.getRow(linha).getCell(coluna).getNumericCellValue();
//		System.out.print(valorCelula+"	|");
		return valorCelula;
	}
	
	
}
