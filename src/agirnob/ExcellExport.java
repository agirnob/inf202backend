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

import com.company.MuayeneSonuclari;
import javafx.collections.ObservableList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


@SuppressWarnings({"java:S106", "java:S4823", "java:S1192"})
public final class ExcellExport {

    public void excelExpo(String musteriAdiS, String muayeneProseduruS, String sayfaNoS, String projeAdiS, String raporNoS, String testYeriS, String resimNoS, String raporTarihiS, String muayeneStandartıS, String yuzeyDurumuS, String isEmriNoS, String degerlendirmeStandartiS, String muayeneAsamasiS, String teklifNoS, String kutupMesafesiS, String muayeneBolgesiS, String yuzeySicakligiS, String cihazAdiS, String akimTipiS, String muayeneBolgesiAlanS, String MPTasiyiciOrtamS, String luxMetreS, String miknatislamaTeknigiS, String muayeneOrtamiS, String yuzeyS, String UVIsikSiddetiS, String miknatisGiderimiS, String isikCihazTanimiS, String isikMesafesiS, String isilIslemS, String kaldirmaTestiS, String standartSapmalarS, String muayeneTarihleriS, String aciklamalarEklerS, String operatorIsimS, String operatorSeviyeS, String operatorTarihS, String degerlendirenIsimS, String degerlendirenSeviyeS, String degerlendirenTarihS, String onayIsimS, String onaySeviyeS, String onayTarihS, ObservableList<MuayeneSonuclari> list, String muayeneKapsamiS) throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("FR_02_MT.xlsx");
        XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row2 = sheet.getRow(2);//row
        Cell musteriAdi = row2.getCell(3);//column
        Cell muayeneProseduru = row2.getCell(19);//column
        Cell sayfaNo = row2.getCell(26);//column
        musteriAdi.setCellValue(musteriAdiS);
        muayeneProseduru.setCellValue(muayeneProseduruS);
        sayfaNo.setCellValue(sayfaNoS);


        Row row3 = sheet.getRow(3);//row
        Cell projeAdi = row3.getCell(3);//column
        Cell muayeneKapsamı = row3.getCell(19);//column
        Cell raporNo = row3.getCell(26);//column
        projeAdi.setCellValue(projeAdiS);
        muayeneKapsamı.setCellValue(muayeneKapsamiS);
        raporNo.setCellValue(raporNoS);

        Row row4 = sheet.getRow(4);//row
        Cell testYeri = row4.getCell(3);//column
        Cell resimNo = row4.getCell(19);//column
        Cell raporTarihi = row4.getCell(26);//column
        testYeri.setCellValue(testYeriS);
        resimNo.setCellValue(resimNoS);
        raporTarihi.setCellValue(raporTarihiS);

        Row row5 = sheet.getRow(5);//row
        Cell muayeneStandartı = row5.getCell(3);//column
        Cell yuzeyDurumu = row5.getCell(19);//column
        Cell isEmriNo = row5.getCell(26);//column
        muayeneStandartı.setCellValue(muayeneStandartıS);
        yuzeyDurumu.setCellValue(yuzeyDurumuS);
        isEmriNo.setCellValue(isEmriNoS);


        Row row6 = sheet.getRow(6);//row
        Cell degerlendirmeStandarti = row6.getCell(3);//column
        Cell muayeneAsamasi = row6.getCell(19);//column
        Cell teklifNo = row6.getCell(26);//column
        degerlendirmeStandarti.setCellValue(degerlendirenSeviyeS);
        muayeneAsamasi.setCellValue(muayeneAsamasiS);
        teklifNo.setCellValue(teklifNoS);

        Row row8 = sheet.getRow(8);//row
        Cell kutupMesafesi = row8.getCell(4);
        Cell muayeneBolgesi = row8.getCell(16);
        Cell yuzeySicakligi = row8.getCell(25);
        kutupMesafesi.setCellValue(kutupMesafesiS);
        muayeneBolgesi.setCellValue(muayeneBolgesiS);
        yuzeySicakligi.setCellValue(yuzeySicakligiS);

        Row row9 = sheet.getRow(9);//row
        Cell cihazAdi = row9.getCell(4);
        Cell akimTipi = row9.getCell(16);
        Cell muayeneBolgesiAlan = row9.getCell(25);
        cihazAdi.setCellValue(cihazAdiS);
        akimTipi.setCellValue(akimTipiS);
        muayeneBolgesiAlan.setCellValue(muayeneAsamasiS);

        Row row10 = sheet.getRow(10);//row
        Cell MPTasiyiciOrtam = row10.getCell(4);
        Cell luxMetre = row10.getCell(16);
        MPTasiyiciOrtam.setCellValue(MPTasiyiciOrtamS);
        luxMetre.setCellValue(luxMetreS);

        Row row11 = sheet.getRow(11);//row
        Cell miknatislamaTeknigi = row11.getCell(4);
        Cell muayeneOrtami = row11.getCell(16);
        Cell yuzey = row11.getCell(25);
        miknatislamaTeknigi.setCellValue(miknatislamaTeknigiS);
        muayeneOrtami.setCellValue(muayeneOrtamiS);
        yuzey.setCellValue(yuzeyS);

        Row row12 = sheet.getRow(12);//row
        Cell UVIsikSiddeti = row12.getCell(4);
        Cell miknatisGiderimi = row12.getCell(16);
        Cell isikCihazTanimi = row12.getCell(25);
        UVIsikSiddeti.setCellValue(UVIsikSiddetiS);
        miknatisGiderimi.setCellValue(miknatisGiderimiS);
        isikCihazTanimi.setCellValue(isikCihazTanimiS);


        Row row13 = sheet.getRow(13);//row
        Cell isikMesafesi = row13.getCell(4);
        Cell isilIslem = row13.getCell(16);
        Cell kaldirmaTesti = row13.getCell(25);
        isikMesafesi.setCellValue(isikMesafesiS);
        isilIslem.setCellValue(isilIslemS);
        kaldirmaTesti.setCellValue(kaldirmaTestiS);

        Row row19 = sheet.getRow(19);//row
        Cell standartSapmalar = row19.getCell(7);
        standartSapmalar.setCellValue(standartSapmalarS);

        Row row20 = sheet.getRow(20);//row
        Cell muayeneTarihleri = row20.getCell(7);
        muayeneTarihleri.setCellValue(muayeneTarihleriS);

        Row row21 = sheet.getRow(21);//row
        Cell aciklamalarEkler = row21.getCell(7);
        aciklamalarEkler.setCellValue(aciklamalarEklerS);
        int i = 1;
        while (!list.isEmpty() && i <= 14) {
            Row rowTable = sheet.getRow(i + 23);//row
            Cell sira = rowTable.getCell(0);
            Cell kaynakParca = rowTable.getCell(1);
            Cell kontrolUzun = rowTable.getCell(8);
            Cell kaynakYon = rowTable.getCell(11);
            Cell kalinlik = rowTable.getCell(17);
            Cell cap = rowTable.getCell(18);
            Cell hataTip = rowTable.getCell(22);
            Cell hataninYeri = rowTable.getCell(24);
            Cell sonuc = rowTable.getCell(27);
            sira.setCellValue(i);
            kaynakParca.setCellValue(list.get(0).getKaynak());
            kontrolUzun.setCellValue(list.get(0).getUzun());
            kaynakYon.setCellValue(list.get(0).getYon());
            kalinlik.setCellValue(list.get(0).getKalin());
            cap.setCellValue(list.get(0).getCap());
            hataTip.setCellValue(list.get(0).getHata());
            hataninYeri.setCellValue(list.get(0).getHatayer());
            sonuc.setCellValue(list.get(0).getSonuc());
            list.remove(0);
            i++;
        }

        Row row39 = sheet.getRow(39);//row
        Cell operatorIsim = row39.getCell(5);
        Cell degerlendirenIsim = row39.getCell(15);
        Cell onayIsim = row39.getCell(20);

        operatorIsim.setCellValue(operatorIsimS);
        degerlendirenIsim.setCellValue(degerlendirenIsimS);
        onayIsim.setCellValue(onayIsimS);

        Row row40 = sheet.getRow(40);//row
        Cell operatorSeviye = row40.getCell(5);
        Cell degerlendirenSeviye = row40.getCell(15);
        Cell onaySeviye = row40.getCell(20);
        operatorSeviye.setCellValue(onaySeviyeS);
        degerlendirenSeviye.setCellValue(degerlendirenSeviyeS);
        onaySeviye.setCellValue(onaySeviyeS);


        Row row41 = sheet.getRow(41);//row
        Cell operatorTarih = row41.getCell(5);
        Cell degerlendirenTarih = row41.getCell(15);
        Cell onayTarih = row41.getCell(20);
        operatorTarih.setCellValue(operatorTarihS);
        degerlendirenTarih.setCellValue(degerlendirenTarihS);
        onayTarih.setCellValue(onayTarihS);

        String file = System.getProperty("user.home");
        file += "/x.xlsx";
        System.out.println(file);
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();
        String file2 = "x.xls";
        FileOutputStream out2 = new FileOutputStream(file2);
        workbook.write(out2);
        out2.close();
    }


}


//private static final String[] titles = {
//            "Person", "ID", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun",
//            "Total\nHrs", "Overtime\nHrs", "Regular\nHrs"
//    };
//
//    private static final Object[][] sample_data = {
//            {"Yegor Kozlov", "YK", 5.0, 8.0, 10.0, 5.0, 5.0, 7.0, 6.0},
//            {"Gisella Bronzetti", "GB", 4.0, 3.0, 1.0, 3.5, null, null, 4.0},
//    };
//
//    private ExcellExport() {
//    }
//
//    public static void excellExport(String[] args) throws Exception {
//        Workbook wb;
//        if (args.length > 0 && args[0].equals("-xls")) wb = new HSSFWorkbook();
//        else wb = new XSSFWorkbook();
//
//        Map<String, CellStyle> styles = createStyles(wb);
//
//        Sheet sheet = wb.createSheet("Timesheet");
//        PrintSetup printSetup = sheet.getPrintSetup();
//        printSetup.setLandscape(true);
//        sheet.setFitToPage(true);
//        sheet.setHorizontallyCenter(true);
//
//        sheet.setDefaultRowHeight((short) (28 * 20));
//        //title row
//        Row titleRow = sheet.createRow(0);
//        Row ekipmanRow = sheet.createRow(8);
//        titleRow.setHeightInPoints(33);
//        Cell titleCell = titleRow.createCell(7);
//        titleCell.setCellStyle(styles.get("title"));
//        sheet.addMergedRegion(CellRangeAddress.valueOf("$H$1:$AB$1"));
//        sheet.addMergedRegion(CellRangeAddress.valueOf("$H$2:$AB$2"));
//        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$23:$AB$23"));
//
//        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$G$2"));
//        for (int i = 3; i <= 14; i++)/*A-C merge*/ {
//            if (i == 8) {
//                sheet.addMergedRegion(CellRangeAddress.valueOf("$A$" + i + ":$AB$" + i));
//            } else {
//                sheet.addMergedRegion(CellRangeAddress.valueOf("$A$" + i + ":$C$" + i));
//            }
//        }
//        for (int i = 3; i <= 7; i++) {
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$D$" + i + ":$P$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$Q$" + i + ":$S$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$T$" + i + ":$W$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$X$" + i + ":$Z$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$AA$" + i + ":$AB$" + i));
//
//        }
//        for (int i = 20; i <= 22; i++) {
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$A$" + i + ":$G$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$H$" + i + ":$AB$" + i));
//        }
//        for (int i = 9; i <= 14; i++) {
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$D$" + i + ":$J$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$K$" + i + ":$P$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$Q$" + i + ":$V$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$W$" + i + ":$Y$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$Z$" + i + ":$AB$" + i));
//        }
//        for (int i = 16; i <= 19; i++) {
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$Q$" + i + ":$R$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$S$" + i + ":$AB$" + i));
//        }
//        for (int i = 24; i <=38 ; i++) {
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$B$" + i + ":$H$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$I$" + i + ":$K$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$L$" + i + ":$Q$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$S$" + i + ":$V$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$W$" + i + ":$X$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$Y$" + i + ":$AA$" + i));
//        }
//        for (int i = 39; i <= 43 ; i++) {
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$A$" + i + ":$E$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$Z$" + i + ":$AB$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$U$" + i + ":$Y$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$P$" + i + ":$T$" + i));
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$F$" + i + ":$O$" + i));
//        }
//        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$15:$G$19"));
//        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$44:$AB$44"));
//        sheet.addMergedRegion(CellRangeAddress.valueOf("$H$15:$P$19"));
//        sheet.addMergedRegion(CellRangeAddress.valueOf("$Q$15:$AB$15"));
//        titleCell.setCellValue(" GÖZETİM MUAYENE VE EĞİTİM HİZMETLERİ ");
//        //header row
//        Row headerRow = sheet.createRow(1);
//        headerRow.setHeightInPoints(42);
//        Cell headerCell;
//        headerCell = headerRow.createCell(7);
//        headerCell.setCellStyle(styles.get("secondTitle"));
//        headerCell.setCellValue("MANYETİK PARÇACIK MUAYENE RAPORU\n\tMAGNETIC PARTICLE INSPECTION REPORT");
//
//
//        int rownum = 2;
//        for (int i = 0; i < 10; i++) {
//            Row row = sheet.createRow(rownum++);
//            for (int j = 0; j < titles.length; j++) {
//                Cell cell = row.createCell(j);
//                if (j == 9) {
//                    //the 10th cell contains sum over week days, e.g. SUM(C3:I3)
//                    String ref = "C" + rownum + ":I" + rownum;
//                    cell.setCellFormula("SUM(" + ref + ")");
//                    cell.setCellStyle(styles.get("formula"));
//                } else if (j == 11) {
//                    cell.setCellFormula("J" + rownum + "-K" + rownum);
//                    cell.setCellStyle(styles.get("formula"));
//                } else {
//                    cell.setCellStyle(styles.get("cell"));
//                }
//            }
//        }
//
//        //row with totals below
//        Row sumRow = sheet.createRow(rownum++);
//        sumRow.setHeightInPoints(35);
//        Cell cell;
//        cell = sumRow.createCell(0);
//        cell.setCellStyle(styles.get("formula"));
//        cell = sumRow.createCell(1);
//        cell.setCellValue("Total Hrs:");
//        cell.setCellStyle(styles.get("formula"));
//
//        for (int j = 2; j < 12; j++) {
//            cell = sumRow.createCell(j);
//            String ref = (char) ('A' + j) + "3:" + (char) ('A' + j) + "12";
//            cell.setCellFormula("SUM(" + ref + ")");
//            if (j >= 9) cell.setCellStyle(styles.get("formula_2"));
//            else cell.setCellStyle(styles.get("formula"));
//        }
//        rownum++;
//        sumRow = sheet.createRow(rownum++);
//        sumRow.setHeightInPoints(25);
//        cell = sumRow.createCell(0);
//        cell.setCellValue("Total Regular Hours");
//        cell.setCellStyle(styles.get("formula"));
//        cell = sumRow.createCell(1);
//        cell.setCellFormula("L13");
//        cell.setCellStyle(styles.get("formula_2"));
//        sumRow = sheet.createRow(rownum++);
//        sumRow.setHeightInPoints(25);
//        cell = sumRow.createCell(0);
//        cell.setCellValue("Total Overtime Hours");
//        cell.setCellStyle(styles.get("formula"));
//        cell = sumRow.createCell(1);
//        cell.setCellFormula("K13");
//        cell.setCellStyle(styles.get("formula_2"));
//
//        //set sample data
//        for (int i = 0; i < sample_data.length; i++) {
//            Row row = sheet.getRow(2 + i);
//            for (int j = 0; j < sample_data[i].length; j++) {
//                if (sample_data[i][j] == null) continue;
//
//                if (sample_data[i][j] instanceof String) {
//                    row.getCell(j).setCellValue((String) sample_data[i][j]);
//                } else {
//                    row.getCell(j).setCellValue((Double) sample_data[i][j]);
//                }
//            }
//        }
//
//        //finally set column widths, the width is measured in units of 1/256th of a character width
//
//
//        sheet.setColumnWidth(0, 6 * 256);
//        sheet.setColumnWidth(1, 4 * 256);
//        sheet.setColumnWidth(2, 4 * 256);
//        sheet.setColumnWidth(3, 1 * 128);
//        sheet.setColumnWidth(4, 4 * 256);
//        sheet.setColumnWidth(5, 1 * 128);
//        sheet.setColumnWidth(6, 4 * 256);
//        sheet.setColumnWidth(7, 3 * 256);
//        sheet.setColumnWidth(8, 5 * 256);
//        sheet.setColumnWidth(9, 3 * 256);
//        sheet.setColumnWidth(10, 5 * 256);
//        sheet.setColumnWidth(11, 4 * 256);
//        sheet.setColumnWidth(12, 1 * 128);
//        sheet.setColumnWidth(13, 1 * 128);
//        sheet.setColumnWidth(14, 1 * 128);
//        sheet.setColumnWidth(15, 8 * 256);
//        sheet.setColumnWidth(16, 3 * 256);
//        sheet.setColumnWidth(17, 10 * 256);
//        sheet.setColumnWidth(18, 4 * 256);
//        sheet.setColumnWidth(19, 3 * 256);
//        sheet.setColumnWidth(20, 3 * 256);
//        sheet.setColumnWidth(21, 1 * 128);
//        sheet.setColumnWidth(22, 10 * 256);
//        sheet.setColumnWidth(23, 2 * 256);
//        sheet.setColumnWidth(24, 5 * 256);
//        sheet.setColumnWidth(25, 4 * 256);
//        sheet.setColumnWidth(26, 6 * 256);
//        sheet.setColumnWidth(27, 7 * 256);
//        // Write the output to a file
//        String file = "timesheet.xls";
//        if (wb instanceof XSSFWorkbook) file += "x";
//        FileOutputStream out = new FileOutputStream(file);
//        wb.write(out);
//        out.close();
//        Excel2pdf e2p = new Excel2pdf();
//        e2p.deneme();
//    }
//
//
//    /**
//     * Create a library of cell styles
//     */
//    private static Map<String, CellStyle> createStyles(Workbook wb) {
//        Map<String, CellStyle> styles = new HashMap<>();
//        CellStyle style;
//        Font titleFont = wb.createFont();
//        titleFont.setFontHeightInPoints((short) 14);
//        titleFont.setBold(true);
//        style = wb.createCellStyle();
//        style.setAlignment(HorizontalAlignment.CENTER);
//        style.setVerticalAlignment(VerticalAlignment.CENTER);
//        style.setFont(titleFont);
//        styles.put("title", style);
//
//        Font secondTitleFont = wb.createFont();
//        secondTitleFont.setFontHeightInPoints((short) 18);
//        secondTitleFont.setBold(true);
//        style = wb.createCellStyle();
//        style.setAlignment(HorizontalAlignment.CENTER);
//        style.setVerticalAlignment(VerticalAlignment.CENTER);
//        style.setFont(secondTitleFont);
//        styles.put("secondTitle", style);
//
//
//        Font monthFont = wb.createFont();
//        monthFont.setFontHeightInPoints((short) 11);
//        monthFont.setColor(IndexedColors.WHITE.getIndex());
//        style = wb.createCellStyle();
//        style.setAlignment(HorizontalAlignment.CENTER);
//        style.setVerticalAlignment(VerticalAlignment.CENTER);
//        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
//        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        style.setFont(monthFont);
//        style.setWrapText(true);
//        styles.put("header", style);
//
//        style = wb.createCellStyle();
//        style.setAlignment(HorizontalAlignment.CENTER);
//        style.setWrapText(true);
//        style.setBorderRight(BorderStyle.THIN);
//        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
//        style.setBorderLeft(BorderStyle.THIN);
//        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
//        style.setBorderTop(BorderStyle.THIN);
//        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
//        style.setBorderBottom(BorderStyle.THIN);
//        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//        styles.put("cell", style);
//
//        style = wb.createCellStyle();
//        style.setAlignment(HorizontalAlignment.CENTER);
//        style.setVerticalAlignment(VerticalAlignment.CENTER);
//        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
//        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
//        styles.put("formula", style);
//
//        style = wb.createCellStyle();
//        style.setAlignment(HorizontalAlignment.CENTER);
//        style.setVerticalAlignment(VerticalAlignment.CENTER);
//        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
//        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
//        styles.put("formula_2", style);
//
//        return styles;
//    }