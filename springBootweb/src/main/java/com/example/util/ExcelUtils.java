/*
 * www.zdsoft.cn Inc.
 * Copyright (c) 2005-2017 All Rights Reserved.
 */
/*
 * 修订记录：
 * Administrator 2017/4/6 16:44 创建
*/
/*
 * @author Administrator
*/
package com.example.util;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
       	public static XSSFCellStyle getStyle(XSSFWorkbook workbook) {
		// 设置字体
		XSSFFont font = workbook.createFont();
		// 设置字体大小
		font.setFontHeightInPoints((short) 9);
		// 字体加粗
		// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 设置字体名字
		font.setFontName("Courier New");
		// 设置样式;
		XSSFCellStyle style = workbook.createCellStyle();
		// 设置底边框;
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// 设置底边框颜色;
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		// 设置左边框;
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// 设置左边框颜色;
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		// 设置右边框;
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// 设置右边框颜色;
		style.setRightBorderColor(HSSFColor.BLACK.index);
		// 设置顶边框;
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// 设置顶边框颜色;
		style.setTopBorderColor(HSSFColor.BLACK.index);
		// 在样式用应用设置的字体;
		style.setFont(font);
		// 设置自动换行;
		style.setWrapText(false);
		// 设置水平对齐的样式为居中对齐;
		// style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 设置垂直对齐的样式为居中对齐;
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		return style;

	}
	public static Row createRow(Sheet sheet, int rowNum, int rowHeight) {
		Row row = sheet.getRow(rowNum);
		if (row != null)
			return row;
		row = sheet.createRow(rowNum);
		if (rowHeight > 0)
			row.setHeightInPoints(rowHeight);
		return row;
	}

	public static Cell createCellTitle(Row row, int column, XSSFCellStyle style) {
		return createCell(row, column, style, HSSFCellStyle.ALIGN_CENTER);
	}

	public static Cell createCellBottom(Row row, int column, XSSFCellStyle style) {
		return createCell(row, column, style, HSSFCellStyle.ALIGN_LEFT);
	}

	public static Cell createCellText(Row row, int column, XSSFCellStyle style) {
		return createCell(row, column, style, HSSFCellStyle.ALIGN_CENTER);
	}

	public static Cell createCellQuantity(Row row, int column, XSSFCellStyle style) {
		return createCell(row, column, style, HSSFCellStyle.ALIGN_CENTER);
	}

	public static Cell createCellAmount(Row row, int column, XSSFCellStyle style) {
		return createCell(row, column, style, HSSFCellStyle.ALIGN_CENTER);
	}

	private static Cell createCell(Row row, int column, XSSFCellStyle style, short align) {
		Cell cell = row.getCell(column);
		if (cell == null) {
			cell = row.createCell(column);
		}
		style.setAlignment(align);
		cell.setCellStyle(style);
		return cell;
	}
}
