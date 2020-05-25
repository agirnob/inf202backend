/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package agirnob;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * A weekly timesheet created using Apache POI.
 * Usage:
 * TimesheetDemo -xls|xlsx
 *
 * @author Yegor Kozlov
 */
@SuppressWarnings({"java:S106", "java:S4823", "java:S1192"})
public final class excellExport {
    private static final String[] titles = {
            "Person", "ID", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun",
            "Total\nHrs", "Overtime\nHrs", "Regular\nHrs"
    };

    private static final Object[][] sample_data = {
            {"Yegor Kozlov", "YK", 5.0, 8.0, 10.0, 5.0, 5.0, 7.0, 6.0},
            {"Gisella Bronzetti", "GB", 4.0, 3.0, 1.0, 3.5, null, null, 4.0},
    };

    private excellExport() {
    }

    public static void excellExport(String[] args) throws Exception {
        Workbook wb;
        if (args.length > 0 && args[0].equals("-xls")) wb = new HSSFWorkbook();
        else wb = new XSSFWorkbook();

        Map<String, CellStyle> styles = createStyles(wb);

        Sheet sheet = wb.createSheet("Timesheet");
        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);

        sheet.setDefaultRowHeight((short) (28 * 20));
        //title row
        Row titleRow = sheet.createRow(0);
        Row ekipmanRow = sheet.createRow(8);
        titleRow.setHeightInPoints(33);
        Cell titleCell = titleRow.createCell(7);
        titleCell.setCellStyle(styles.get("title"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$H$1:$AB$1"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$H$2:$AB$2"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$23:$AB$23"));

        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$G$2"));
        for (int i = 3; i <= 14; i++)/*A-C merge*/ {
            if (i == 8) {
                sheet.addMergedRegion(CellRangeAddress.valueOf("$A$" + i + ":$AB$" + i));
            } else {
                sheet.addMergedRegion(CellRangeAddress.valueOf("$A$" + i + ":$C$" + i));
            }
        }
        for (int i = 3; i <= 7; i++) {
            sheet.addMergedRegion(CellRangeAddress.valueOf("$D$" + i + ":$P$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$Q$" + i + ":$S$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$T$" + i + ":$W$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$X$" + i + ":$Z$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$AA$" + i + ":$AB$" + i));

        }
        for (int i = 20; i <= 22; i++) {
            sheet.addMergedRegion(CellRangeAddress.valueOf("$A$" + i + ":$G$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$H$" + i + ":$AB$" + i));
        }
        for (int i = 9; i <= 14; i++) {
            sheet.addMergedRegion(CellRangeAddress.valueOf("$D$" + i + ":$J$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$K$" + i + ":$P$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$Q$" + i + ":$V$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$W$" + i + ":$Y$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$Z$" + i + ":$AB$" + i));
        }
        for (int i = 16; i <= 19; i++) {
            sheet.addMergedRegion(CellRangeAddress.valueOf("$Q$" + i + ":$R$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$S$" + i + ":$AB$" + i));
        }
        for (int i = 24; i <=38 ; i++) {
            sheet.addMergedRegion(CellRangeAddress.valueOf("$B$" + i + ":$H$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$I$" + i + ":$K$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$L$" + i + ":$Q$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$S$" + i + ":$V$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$W$" + i + ":$X$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$Y$" + i + ":$AA$" + i));
        }
        for (int i = 39; i <= 43 ; i++) {
            sheet.addMergedRegion(CellRangeAddress.valueOf("$A$" + i + ":$E$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$Z$" + i + ":$AB$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$U$" + i + ":$Y$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$P$" + i + ":$T$" + i));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$F$" + i + ":$O$" + i));
        }
        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$15:$G$19"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$44:$AB$44"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$H$15:$P$19"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$Q$15:$AB$15"));
        titleCell.setCellValue(" GÖZETİM MUAYENE VE EĞİTİM HİZMETLERİ ");
        //header row
        Row headerRow = sheet.createRow(1);
        headerRow.setHeightInPoints(42);
        Cell headerCell;
        headerCell = headerRow.createCell(7);
        headerCell.setCellStyle(styles.get("secondTitle"));
        headerCell.setCellValue("MANYETİK PARÇACIK MUAYENE RAPORU\n\tMAGNETIC PARTICLE INSPECTION REPORT");


        int rownum = 2;
        for (int i = 0; i < 10; i++) {
            Row row = sheet.createRow(rownum++);
            for (int j = 0; j < titles.length; j++) {
                Cell cell = row.createCell(j);
                if (j == 9) {
                    //the 10th cell contains sum over week days, e.g. SUM(C3:I3)
                    String ref = "C" + rownum + ":I" + rownum;
                    cell.setCellFormula("SUM(" + ref + ")");
                    cell.setCellStyle(styles.get("formula"));
                } else if (j == 11) {
                    cell.setCellFormula("J" + rownum + "-K" + rownum);
                    cell.setCellStyle(styles.get("formula"));
                } else {
                    cell.setCellStyle(styles.get("cell"));
                }
            }
        }

        //row with totals below
        Row sumRow = sheet.createRow(rownum++);
        sumRow.setHeightInPoints(35);
        Cell cell;
        cell = sumRow.createCell(0);
        cell.setCellStyle(styles.get("formula"));
        cell = sumRow.createCell(1);
        cell.setCellValue("Total Hrs:");
        cell.setCellStyle(styles.get("formula"));

        for (int j = 2; j < 12; j++) {
            cell = sumRow.createCell(j);
            String ref = (char) ('A' + j) + "3:" + (char) ('A' + j) + "12";
            cell.setCellFormula("SUM(" + ref + ")");
            if (j >= 9) cell.setCellStyle(styles.get("formula_2"));
            else cell.setCellStyle(styles.get("formula"));
        }
        rownum++;
        sumRow = sheet.createRow(rownum++);
        sumRow.setHeightInPoints(25);
        cell = sumRow.createCell(0);
        cell.setCellValue("Total Regular Hours");
        cell.setCellStyle(styles.get("formula"));
        cell = sumRow.createCell(1);
        cell.setCellFormula("L13");
        cell.setCellStyle(styles.get("formula_2"));
        sumRow = sheet.createRow(rownum++);
        sumRow.setHeightInPoints(25);
        cell = sumRow.createCell(0);
        cell.setCellValue("Total Overtime Hours");
        cell.setCellStyle(styles.get("formula"));
        cell = sumRow.createCell(1);
        cell.setCellFormula("K13");
        cell.setCellStyle(styles.get("formula_2"));

        //set sample data
        for (int i = 0; i < sample_data.length; i++) {
            Row row = sheet.getRow(2 + i);
            for (int j = 0; j < sample_data[i].length; j++) {
                if (sample_data[i][j] == null) continue;

                if (sample_data[i][j] instanceof String) {
                    row.getCell(j).setCellValue((String) sample_data[i][j]);
                } else {
                    row.getCell(j).setCellValue((Double) sample_data[i][j]);
                }
            }
        }

        //finally set column widths, the width is measured in units of 1/256th of a character width


        sheet.setColumnWidth(0, 6 * 256);
        sheet.setColumnWidth(1, 4 * 256);
        sheet.setColumnWidth(2, 4 * 256);
        sheet.setColumnWidth(3, 1 * 128);
        sheet.setColumnWidth(4, 4 * 256);
        sheet.setColumnWidth(5, 1 * 128);
        sheet.setColumnWidth(6, 4 * 256);
        sheet.setColumnWidth(7, 3 * 256);
        sheet.setColumnWidth(8, 5 * 256);
        sheet.setColumnWidth(9, 3 * 256);
        sheet.setColumnWidth(10, 5 * 256);
        sheet.setColumnWidth(11, 4 * 256);
        sheet.setColumnWidth(12, 1 * 128);
        sheet.setColumnWidth(13, 1 * 128);
        sheet.setColumnWidth(14, 1 * 128);
        sheet.setColumnWidth(15, 8 * 256);
        sheet.setColumnWidth(16, 3 * 256);
        sheet.setColumnWidth(17, 10 * 256);
        sheet.setColumnWidth(18, 4 * 256);
        sheet.setColumnWidth(19, 3 * 256);
        sheet.setColumnWidth(20, 3 * 256);
        sheet.setColumnWidth(21, 1 * 128);
        sheet.setColumnWidth(22, 10 * 256);
        sheet.setColumnWidth(23, 2 * 256);
        sheet.setColumnWidth(24, 5 * 256);
        sheet.setColumnWidth(25, 4 * 256);
        sheet.setColumnWidth(26, 6 * 256);
        sheet.setColumnWidth(27, 7 * 256);
        // Write the output to a file
        String file = "timesheet.xls";
        if (wb instanceof XSSFWorkbook) file += "x";
        FileOutputStream out = new FileOutputStream(file);
        wb.write(out);
        out.close();
        excel2pdf e2p = new excel2pdf();
        e2p.deneme();
    }


    /**
     * Create a library of cell styles
     */
    private static Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new HashMap<>();
        CellStyle style;
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short) 14);
        titleFont.setBold(true);
        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFont(titleFont);
        styles.put("title", style);

        Font secondTitleFont = wb.createFont();
        secondTitleFont.setFontHeightInPoints((short) 18);
        secondTitleFont.setBold(true);
        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFont(secondTitleFont);
        styles.put("secondTitle", style);


        Font monthFont = wb.createFont();
        monthFont.setFontHeightInPoints((short) 11);
        monthFont.setColor(IndexedColors.WHITE.getIndex());
        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFont(monthFont);
        style.setWrapText(true);
        styles.put("header", style);

        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setWrapText(true);
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        styles.put("cell", style);

        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
        styles.put("formula", style);

        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
        styles.put("formula_2", style);

        return styles;
    }

}
