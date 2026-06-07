package laba8;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFileExample {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\develop\\vivo\\example_exel.xlsx";

        // Открываем файл Excel для чтения
        FileInputStream inputStream = new FileInputStream(filePath);

        // Создаем экземпляр книги Excel из файла
        Workbook workbook = new XSSFWorkbook(inputStream);

        // Получаем первый лист из книги (по индексу 0)
        Sheet sheet = workbook.getSheetAt(0);

        System.out.println("Чтение файла Excel\n");

        // Перебираем строки и ячейки листа
        int rowNum = 0;
        for (Row row : sheet) {
            System.out.print("Строка " + rowNum + ": ");

            for (Cell cell : row) {
                // Выводим значение ячейки на экран
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            System.out.print(cell.getDateCellValue() + "\t");
                        } else {
                            System.out.print(cell.getNumericCellValue() + "\t");
                        }
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue() + "\t");
                        break;
                    case FORMULA:
                        System.out.print(cell.getCellFormula() + "\t");
                        break;
                    default:
                        System.out.print("UNKNOWN\t");
                }
            }

            System.out.println();
            rowNum++;
        }

        System.out.println("\nЧтение завершено");

        // Закрываем файл и освобождаем ресурсы
        workbook.close();
        inputStream.close();
    }
}
