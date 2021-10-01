import service.*;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File textFile = new File("data/textFile.txt");
        File javaFile = new File("data/java_file/Airport.java");
        File javaProgrammeDirectory = new File("data/java_programme");

        // 1. Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.
        FileService.writeRandomIntegersInFileAndSort("data/file_task1.txt");

        //2.     Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.
        JavaProgramService.changeAccessModifiersFromPublicToPrivate(javaProgrammeDirectory);

        //3.     Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.
        JavaProgramService.writeJavaFileInBackOrder(javaFile);

        //4.     Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы заменить прописными.
        JavaProgramService.changeCaseOfWordsLongerTwoSymbolsInJavaProgramme(javaFile);

        //5.     В файле, содержащем фамилии студентов и их оценки, записать прописными буквами фамилии тех студентов, которые имеют средний балл более 7.
        FileService.changeCaseOfStudentsNameWithUpperAverageMarkValue("data/students.txt", 7);

        //6.     Файл содержит символы, слова, целые числа и числа с плавающей запятой. Определить все данные, тип которых вводится из командной строки.
        FileService.readAllDataTypesFromFile("data/differentDataTypes.txt");

        //7.Из файла удалить все слова, содержащие от трех до пяти символов, но при этом из каждой строки должно быть удалено только максимальное четное количество
        FileService.deleteMaxEvenNumberOfWordsWithLengthDiapason(textFile, 3, 5);

        //8.     Прочитать текст Java-программы и удалить из него все «лишние» пробелы и табуляции, оставив только необходимые для разделения операторов.
        JavaProgramService.deleteExtraSpacesAndTabulationFromJavaFile(javaFile);

        //9.     Из текста Java-программы удалить все виды комментариев.
        JavaProgramService.deleteCommentsFromJavaFile(javaFile);

        //10.  Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.
        FileService.changeFirstAndLastWordInFile(textFile);

        //11.  Ввести из текстового файла, связанного с входным потоком, последовательность строк. Выбрать и сохранить m последних слов в каждой из последних n строк.
        FileService.saveLastWordsInLines(textFile, 3, 3);

        //12.  Из текстового файла ввести последовательность строк. Выделить отдельные слова, разделяемые пробелами. Написать метод поиска слова по образцу-шаблону. Вывести найденное слово в другой файл.
        FileService.searchWordInFile(textFile, "tears");

        //13.  Сохранить в файл, связанный с выходным потоком, записи о телефонах и их вла-дельцах. Вывести в файл записи, телефоны в которых начинаются на k и на j.
        FileService.filterTelephoneBase(FileService.createTelephoneBaseFile("data/telephoneBase.txt"), 7,3);

    }
}
