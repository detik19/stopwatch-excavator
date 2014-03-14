package net.rt.stopwatch.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.rt.stopwatch.model.SimulationResult;

import org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandler {
	private static final int COL_NO = 0;
	private static final int COL_NAMA=1;
	private static final int COL_NRP=2;
	private static final int COL_TANGGAL=3;
	private static final int COL_JAM=4;
	private static final int COL_DIGTIME=5;
	private static final int COL_SWING_LOADED=6;
	private static final int COL_DUMPING_TIME=7;
	private static final int COL_SWING_EMPTY=8;
	private static final int COL_CYCLE_TIME=9;
	private static final int COL_WAIT_DT=10;
	private static final int COL_REPOSISI=11;
	private static final int COL_REPAIR_FRONT=12;





	
	public static void main(String[] args) {
		
		ExcelHandler handler=new ExcelHandler();
		//handler.printTask();
	}
	private static CellStyle createBorderedStyle(Workbook wb){
	     CellStyle style = wb.createCellStyle();
	     style.setBorderRight(CellStyle.BORDER_THIN);
	     style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	     style.setBorderBottom(CellStyle.BORDER_THIN);
	     style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	     style.setBorderLeft(CellStyle.BORDER_THIN);
	     style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	     style.setBorderTop(CellStyle.BORDER_THIN);
	     style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	     return style;
		}
	private static Map<String, CellStyle> createStyles(Workbook wb)
	{
	     Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
	     DataFormat df = wb.createDataFormat();

	     CellStyle style;
	     
	     //style to header
	     style=createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_CENTER);
	     style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
	     style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	     Font font = wb.createFont();
	     font.setFontHeightInPoints((short) 8);
	     font.setFontName("Tahoma");
	     style.setFont(font);
	     styles.put("headerku", style);
	  
	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_CENTER);
	     style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	     style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	     style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	     style.setFont(font);
	     styles.put("profil person", style);

	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_CENTER);
	     style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	     style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
	     style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	     style.setWrapText(true);
	     style.setFont(font);
	   
	     styles.put("header tengah", style);
	     
	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_CENTER);
	     style.setFillForegroundColor(IndexedColors.AUTOMATIC.getIndex());
	     //style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	     style.setFont(font);
	     styles.put("konten", style);


	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_CENTER);
	     style.setFillForegroundColor(IndexedColors.RED.getIndex());
	     style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	     style.setFont(font);
	     styles.put("grand_total", style);
	     
	     
	     style=createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_CENTER);
	     style.setFillForegroundColor(IndexedColors.LIME.getIndex());
	     style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	     style.setFont(font);
	     style.setWrapText(true);
	     styles.put("grand_value_error", style);
	     
	     return styles;
	 }
	public void printTask(SimulationResult sim){
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("TEST");
	     Map<String, CellStyle> styles = createStyles(wb);

		String[] header={"No","NAMA","NRP","Tanggal", "Jam", "Dig Time", "Swing loaded","dumping time", "swing empty","cycle time","wait dt", "reposisi","repair front"};
		Row row=sheet.createRow(0);
		for(int i=0;i<header.length;i++)
		{
			
			row.createCell(i).setCellValue(header[i]);
            row.getCell(i).setCellStyle(styles.get("headerku"));


		}
		Object[][] data= {};
		Object[][] data2= {};
		
		data=sim.getData();
		data2=sim.getData2();
		for(int i=0;i<data.length;i++){
			row=sheet.createRow(i+1);

			row.createCell(COL_NAMA).setCellValue(sim.getOperator().getName());
			row.createCell(COL_NRP).setCellValue(sim.getOperator().getNrp());
			row.createCell(COL_TANGGAL).setCellValue("");
			row.createCell(COL_JAM).setCellValue("");
			
			row.getCell(COL_NAMA).setCellStyle(styles.get("konten"));
			row.getCell(COL_NRP).setCellStyle(styles.get("konten"));
			row.getCell(COL_TANGGAL).setCellStyle(styles.get("konten"));
			row.getCell(COL_JAM).setCellStyle(styles.get("konten"));

			createCell(row, COL_NO, data[i][0], styles);
			createCell(row, COL_DIGTIME, data[i][1], styles);
			createCell(row, COL_SWING_LOADED, data[i][2], styles);
			createCell(row, COL_DUMPING_TIME, data[i][3], styles);
			createCell(row, COL_SWING_EMPTY, data[i][4], styles);
			createCell(row, COL_CYCLE_TIME, data[i][5], styles);
		
			

			
			
		}
		
		
		
		
		createXLSX(wb, "D:\\test.xlsx");
		System.out.println("finish");
	   //  Map<String, CellStyle> styles = createStyles(wb);
	}
	
	private void createCell(Row row, int col, Object value, Map<String, CellStyle> styles){
		if(value !=null){
			row.createCell(col).setCellValue(value.toString());
			row.getCell(col).setCellStyle(styles.get("konten"));

		}else{
			row.createCell(COL_NO).setCellValue("");
			row.getCell(COL_NO).setCellStyle(styles.get("konten"));
		}
	}
	private void createXLSX(Workbook wb, String strfile) {
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(strfile);
			wb.write(fileOut);
		    fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
