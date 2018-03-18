package test;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class TestPOIDemo {

    @Test
    public void HSSF() throws IOException {
        //1.创建一个工作簿excel文件
        Workbook workbook = new HSSFWorkbook(); //HSSF操作excel 2003版本以下
        //2.创建一个工作表sheet
        Sheet sheet = workbook.createSheet();
        //3.创建一个行对象Row
        Row row = sheet.createRow(4);//第五行
        //4.创建一个单元格对象，制定列
        Cell cell = row.createCell(3);//第四列
        //5.给单元格设置内容
        cell.setCellValue("I LOVE JAVA");

        //添加样式
            //创建一个单元格样式
        CellStyle cellStyle = workbook.createCellStyle();
            //创建一个字体对象
        Font font = workbook.createFont();
        font.setFontName("华文行楷");
        font.setFontHeightInPoints((short) 26);
        cellStyle.setFont(font);
        cell.setCellStyle(cellStyle);

        //在创建一个单元格
        Row row1 = sheet.createRow(5);
        Cell cell1 = row1.createCell(5);
        cell1.setCellValue("www.xwketang.com");

        cell1.setCellStyle(cellStyle);

        //6.保存
        OutputStream outputStream = new FileOutputStream(new File("d:\\testPOI.xls"));
        workbook.write(outputStream);
        //7.关闭
        outputStream.close();
    }
}
