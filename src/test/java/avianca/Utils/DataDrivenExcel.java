package avianca.Utils;



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataDrivenExcel {

	static Logger logger = Logger.getLogger( DataDrivenExcel.class.getName()); 
	private DecimalFormat df = new DecimalFormat("0.###");

	public Map<String, String> leerExcel(Excel excel) {
		// Variable que contendra todas las filas
		Map<String, String> datosExcel = new HashMap<String, String>();
		try {
			// Invocaci�n y uso del excel
			FileInputStream arcExcel = new FileInputStream(new File(excel.getRutaExcel()));
			Workbook libroExcel = new XSSFWorkbook(arcExcel);
			// Hoja del excel a usar
			Sheet hojaArcExcel = libroExcel.getSheet(excel.getHojaExcel());
			Iterator<Row> iterator = hojaArcExcel.iterator();
			ArrayList<String> cabeceras = new ArrayList<String>();
			// Ciclo de iteraci�n por cada fila
			while (iterator.hasNext()) {
				Row filaActual = iterator.next();
				Iterator<Cell> iteratorCelda = filaActual.iterator();
				// Variable que almacenara cada fila
				int numFila = filaActual.getRowNum();
				if ((excel.isContieneCabecera() && numFila == 0) || numFila == excel.getFilaLeer()) {
					// Ciclo de celdas o columnas de la hoja del excel
					while (iteratorCelda.hasNext()) {
						Cell celdaActual = iteratorCelda.next();
						String valorCelda;
						// Validar tipo de celda para procesarla
						switch (celdaActual.getCellType()) {
						case NUMERIC:
							if (DateUtil.isCellDateFormatted(celdaActual)) {
								valorCelda = "" + celdaActual.getDateCellValue().getTime();
							} else {
								valorCelda = df.format(celdaActual.getNumericCellValue());
							}
							break;
						default:
							valorCelda = celdaActual.getStringCellValue();
							break;
						}
						// Validar si tiene cabecera o no
						if (excel.isContieneCabecera()) {
							if (numFila == 0) {
								cabeceras.add(valorCelda);
							} else {
								datosExcel.put(cabeceras.get(celdaActual.getColumnIndex()), valorCelda);
							}
						} else {
							if (numFila == excel.getFilaLeer()) {
								datosExcel.put("" + celdaActual.getColumnIndex() + "", valorCelda);
							}
						}
					}
				}
			}
			libroExcel.close();
		} catch (IOException e) {
			logger.log(Level.INFO, e.getMessage());
		}
		return datosExcel;
	}

	public static void actualizarCelda(String rutaExcel, String hoja, Integer fila, Integer columna, String cadena) {

		try {
			FileInputStream archivoSalida = new FileInputStream(rutaExcel);
			@SuppressWarnings("resource")
			XSSFWorkbook book = new XSSFWorkbook(archivoSalida);
			XSSFSheet sheet = book.getSheet(hoja);
			XSSFRow row = sheet.getRow(fila);

			if (row == null) row = sheet.createRow(fila);

			XSSFCell celda = row.createCell(columna);

			if (celda == null) celda = row.createCell(columna);

			celda.setCellValue(cadena);
			archivoSalida.close();

			FileOutputStream output = new FileOutputStream(rutaExcel);
			book.write(output);
			output.close();

		} catch (IOException e) {
			logger.log(Level.INFO, e.getMessage());
		}
	}

}
