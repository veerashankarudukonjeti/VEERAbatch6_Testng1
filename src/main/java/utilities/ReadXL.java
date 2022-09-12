package utilities;


	

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;



	public class ReadXL {
		
		public static String ReadXLData(String sheetName,int r,int c) throws IOException {
			File F = new File(FilePath.xlString);
					
			FileInputStream fi;
			String value = "";
			
			fi=new FileInputStream(F);
			Workbook w = new XSSFWorkbook(fi);
			Sheet s = w.getSheet(sheetName);
			Row row = s.getRow(r);
			Cell cell = row.getCell(c);
			
			int cellType = cell.getCellType();
			
			//cell is string
			if(cellType==1) {
				value = cell.getStringCellValue();
			}
				//cell is date
			else if(DateUtil.isCellDateFormatted(cell)) {
				Date d = cell.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
				value = sim.format(d);
			}
			//cell is numeric
			else {
				double d = cell.getNumericCellValue();
				long l = (long)d;
				value = String.valueOf(1);
			}
			return value;
		}

}
