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

    public void excelExpo(String musteriAdiS, String muayeneProseduruS, String sayfaNoS, String projeAdiS, String raporNoS, String testYeriS, String resimNoS, String raporTarihiS, String muayeneStandartiS, String yuzeyDurumuS, String isEmriNoS, String degerlendirmeStandartiS, String muayeneAsamasiS, String teklifNoS, String kutupMesafesiS, String muayeneBolgesiS, String yuzeySicakligiS, String cihazAdiS, String akimTipiS, String muayeneBolgesiAlanS, String MPTasiyiciOrtamS, String luxMetreS, String miknatislamaTeknigiS, String muayeneOrtamiS, String yuzeyS, String UVIsikSiddetiS, String miknatisGiderimiS, String isikCihazTanimiS, String isikMesafesiS, String isilIslemS, String kaldirmaTestiS, String standartSapmalarS, String muayeneTarihleriS, String aciklamalarEklerS, String operatorIsimS, String operatorSeviyeS, String operatorTarihS, String degerlendirenIsimS, String degerlendirenSeviyeS, String degerlendirenTarihS, String onayIsimS, String onaySeviyeS, String onayTarihS, ObservableList<MuayeneSonuclari> list, String muayeneKapsamiS) throws IOException {
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
        Cell muayeneKapsami = row3.getCell(19);//column
        Cell raporNo = row3.getCell(26);//column
        projeAdi.setCellValue(projeAdiS);
        muayeneKapsami.setCellValue(muayeneKapsamiS);
        raporNo.setCellValue(raporNoS);

        Row row4 = sheet.getRow(4);//row
        Cell testYeri = row4.getCell(3);//column
        Cell resimNo = row4.getCell(19);//column
        Cell raporTarihi = row4.getCell(26);//column
        testYeri.setCellValue(testYeriS);
        resimNo.setCellValue(resimNoS);
        raporTarihi.setCellValue(raporTarihiS);

        Row row5 = sheet.getRow(5);//row
        Cell muayeneStandarti = row5.getCell(3);//column
        Cell yuzeyDurumu = row5.getCell(19);//column
        Cell isEmriNo = row5.getCell(26);//column
        muayeneStandarti.setCellValue(muayeneStandartiS);
        yuzeyDurumu.setCellValue(yuzeyDurumuS);
        isEmriNo.setCellValue(isEmriNoS);


        Row row6 = sheet.getRow(6);//row
        Cell degerlendirmeStandarti = row6.getCell(3);//column
        Cell muayeneAsamasi = row6.getCell(19);//column
        Cell teklifNo = row6.getCell(26);//column
        degerlendirmeStandarti.setCellValue(degerlendirmeStandartiS);
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
        muayeneBolgesiAlan.setCellValue(muayeneBolgesiAlanS);

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
        operatorSeviye.setCellValue(operatorSeviyeS);
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