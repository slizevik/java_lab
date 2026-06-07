package laba8;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

public class NewReadExelFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;

        System.out.println("Программа для чтения Excel-файлов");
        System.out.println("Для выхода из программы введите 'exit' вместо пути к файлу.\n");

        // Цикл для возможности повторного запуска после исправления ошибок
        while (!success) {
            System.out.print("Введите путь к Excel-файлу (.xlsx): ");
            String filePath = scanner.nextLine();

            if ("exit".equalsIgnoreCase(filePath)) {
                System.out.println("Завершение работы программы.");
                break;
            }

            // Предварительная проверка существования файла
            File file = new File(filePath);
            if (!file.exists()) {
                System.err.println("ОШИБКА 1: Файл не найден по указанному пути.");
                System.err.println("Рекомендация: Проверьте правильность написания пути и убедитесь, что файл существует.\n");
                continue; // Возвращаемся к началу цикла для повторного ввода
            }

            try (FileInputStream inputStream = new FileInputStream(file)) {
                // WorkbookFactory сам определяет формат и корректно выбрасывает InvalidFormatException
                Workbook workbook = WorkbookFactory.create(inputStream);

                if (workbook.getNumberOfSheets() == 0) {
                    System.err.println("ОШИБКА 2: Файл не содержит ни одного листа.");
                    System.err.println("Рекомендация: Убедитесь, что Excel-файл не пустой и содержит хотя бы один лист с данными.\n");
                    workbook.close();
                    continue;
                }

                Sheet sheet = workbook.getSheetAt(0);
                System.out.println("\nУспешное подключение! Чтение листа: '" + sheet.getSheetName() + "'\n");

                int rowNum = 0;
                for (Row row : sheet) {
                    System.out.print("Строка " + rowNum + ": ");
                    for (Cell cell : row) {
                        printCellValue(cell);
                    }
                    System.out.println();
                    rowNum++;
                }

                System.out.println("\nЧтение завершено успешно!");
                workbook.close();
                success = true;

            } catch (EncryptedDocumentException e) {
                System.err.println("ОШИБКА 4: Файл защищен паролем.");
                System.err.println("Рекомендация: Снимите защиту паролем с файла в Excel или выберите другой файл.\n");

            } catch (IllegalArgumentException e) {
                System.err.println("ОШИБКА 3: Неверный формат файла.");
                System.err.println("Рекомендация: Файл поврежден, имеет неподдерживаемый формат или это вовсе не Excel-файл.");
                System.err.println("Убедитесь, что файл является корректным документом .xls или .xlsx.\n");

            } catch (IOException e) {
                System.err.println("ОШИБКА 5: Ошибка ввода-вывода (файл заблокирован или поврежден).");
                System.err.println("Рекомендация: Возможно, файл сейчас открыт в Microsoft Excel. Закройте его и попробуйте снова.\n");

            } catch (Exception e) {
                System.err.println("НЕИЗВЕСТНАЯ ОШИБКА: " + e.getMessage() + "\n");
            }
        }
        scanner.close();
    }

    private static void printCellValue(Cell cell) {
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
}

