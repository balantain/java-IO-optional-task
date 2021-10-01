package service;

import java.io.*;
import java.util.*;

public class FileService {

    // 1. Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.
    public static void writeRandomIntegersInFileAndSort(String filePath){
        File file = new File(filePath);
        try(FileWriter fileWriter = new FileWriter(file)){
            Random random2 = new Random();
            for (int i = 0; i < 10; i++){
                fileWriter.write(random2.nextInt(50+1) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Integer> integers = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            while (bufferedReader.ready()){
                integers.add(Integer.valueOf(bufferedReader.readLine()));
            }
            Collections.sort(integers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter fileWriter = new FileWriter(file, true)){
            fileWriter.write("\nSorted ints:\n");
            for (Integer integer : integers){
                fileWriter.write(integer.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //5.     В файле, содержащем фамилии студентов и их оценки, записать прописными буквами фамилии тех студентов, которые имеют средний балл более 7.
    public static void changeCaseOfStudentsNameWithUpperAverageMarkValue(String filePath, int markValue){
        File file = new File(filePath);
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            while (bufferedReader.ready()){
                lines.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(FileWriter fileWriter = new FileWriter(file.getAbsolutePath().replace(".txt", "_task5_result.txt"))){
            for (String line : lines){
                int sum = 0;
                double avrValue;
                String[] studentInfo = line.split("\\s+");
                for (int i = 1; i < studentInfo.length; i++){
                    sum += Integer.parseInt(studentInfo[i]);
                }
                avrValue = (double) sum/ (studentInfo.length - 1);
                if (avrValue > markValue){
                    line = line.toUpperCase();
                }
                fileWriter.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //6.     Файл содержит символы, слова, целые числа и числа с плавающей запятой. Определить все данные, тип которых вводится из командной строки.
    public static void readAllDataTypesFromFile(String filepath){
        File file = new File(filepath);
        ArrayList<String> content = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            while (bufferedReader.ready()){
                content.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        boolean isInputCorrect = false;
        do{
            System.out.println("Please enter the type of data (String, Character, Integer, Double):");
            String input = scanner.nextLine().toLowerCase();
            StringBuilder result;
            switch (input){
                case "string":
                    result = new StringBuilder();
                    for (String line : content){
                        String[] data = line.split("\\s+");
                        for (String datum : data) {
                            try {
                                Integer.parseInt(datum);
                                continue;
                            } catch (NumberFormatException ignored) {
                            }
                            try {
                                Double.parseDouble(datum);
                                continue;
                            } catch (NumberFormatException ignored) {
                            }
                            if (datum.length() > 1) {
                                result.append(datum).append(" ");
                            }
                        }
                    }
                    System.out.println("All words in file: "  + result.toString());
                    isInputCorrect = true;
                    break;
                case "double":
                    result = new StringBuilder();
                    for (String line : content){
                        String[] data = line.split("\\s+");
                        for (String datum : data) {
                            if (datum.contains(".")) {
                                try {
                                    Double.parseDouble(datum);
                                    result.append(datum).append(" ");
                                } catch (NumberFormatException ignored) {
                                }
                            }
                        }
                    }
                    System.out.println("All doubles in file: "  + result.toString());
                    isInputCorrect = true;
                    break;
                case "character":
                    result = new StringBuilder();
                    for (String line : content){
                        String[] data = line.split("\\s+");
                        for (String datum : data) {
                            try {
                                Integer.parseInt(datum);
                                continue;
                            } catch (NumberFormatException ignored) {
                            }
                            try {
                                Double.parseDouble(datum);
                                continue;
                            } catch (NumberFormatException ignored) {
                            }
                            if (datum.length() == 1) {
                                result.append(datum).append(" ");
                            }
                        }
                    }
                    System.out.println("All symbols in file: "  + result.toString());
                    isInputCorrect = true;
                    break;
                case "integer":
                    result = new StringBuilder();
                    for (String line : content){
                        String[] data = line.split("\\s+");
                        for (String datum : data) {
                            try {
                                Integer.parseInt(datum);
                                result.append(datum).append(" ");
                            } catch (NumberFormatException ignored) {
                            }
                        }
                    }
                    System.out.println("All Integers in file: "  + result.toString());
                    isInputCorrect = true;
                    break;
                default:
                    System.out.println("Wrong input, try again!");
            }
        }while(!isInputCorrect);
        scanner.close();
    }

    //7.Из файла удалить все слова, содержащие от трех до пяти символов, но при этом из каждой строки должно быть удалено только максимальное четное количество
    public static void deleteMaxEvenNumberOfWordsWithLengthDiapason(File file, int diapasonStart, int DiapasonEnd){
        List<String> content = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            while (bufferedReader.ready()){
                content.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> newContent = new ArrayList<>();
        for (String line : content){
            String[] wordsList = line.split("\\s+");
            int count = 0;
            for (String s : wordsList) {
                if (s.replaceAll("[,.:;?!\"]", "").length() <= DiapasonEnd && s.replaceAll("[,.:;?!\"]", "").length() >= diapasonStart) {
                    count++;
                }
            }
            if (count%2 != 0){
                count--;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : wordsList){
                if (s.replaceAll("[,.:;?!\"]", "").length() <= DiapasonEnd && s.replaceAll("[,.:;?!\"]", "").length() >= diapasonStart && count > 0){
                    count--;
                } else{
                    stringBuilder.append(s).append(" ");
                }
            }
            newContent.add(stringBuilder.toString());
        }
        try (FileWriter fileWriter = new FileWriter(file.getAbsolutePath().replace(".txt", "_task7_result.txt"))){
            for (String s : newContent){
                fileWriter.write(s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //10.  Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.
    public static void changeFirstAndLastWordInFile(File file) {
        List<String> content = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            while (reader.ready()){
                content.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> newContent = new ArrayList<>();
        for (String line : content){
            String[] words = line.split("\\s+");
            String buffer = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = buffer;
            StringBuilder sb = new StringBuilder();
            for (String word : words){
                sb.append(word).append(" ");
            }
            newContent.add(sb.toString());
        }
        try (FileWriter fileWriter = new FileWriter(file.getAbsolutePath().replace(".txt", "_task10_result.txt"))){
            for (String line : newContent){
                fileWriter.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //11.  Ввести из текстового файла, связанного с входным потоком, последовательность строк. Выбрать и сохранить m последних слов в каждой из последних n строк.
    public static void saveLastWordsInLines(File file, int lines, int words) {
        List<String> content = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            while (bufferedReader.ready()){
                content.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int m = words;
        int n = lines;
        try (FileWriter fileWriter = new FileWriter(file.getAbsolutePath().replace(".txt", "_task11_result.txt"))){
            for (int i = (content.size() - (n)); i < content.size(); i++){
                StringBuilder sb = new StringBuilder();
                String[] splitWords = content.get(i).split("\\s+");
                for (int j = (splitWords.length - (m)); j < splitWords.length; j++){
                    sb.append(splitWords[j]).append(" ");
                }
                fileWriter.write(sb.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //12.  Из текстового файла ввести последовательность строк. Выделить отдельные слова, разделяемые пробелами. Написать метод поиска слова по образцу-шаблону. Вывести найденное слово в другой файл.
    public static void searchWordInFile(File file, String searchWord){
        List<String> content = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            while (bufferedReader.ready()){
                content.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter fileWriter = new FileWriter(file.getAbsolutePath().replace(".txt", "_task12_result.txt"))){
            for (String line : content){
                String[] words = line.split("\\s+");
                for (String word : words){
                    if (searchWord.equals(word)){
                        fileWriter.write(word + " found in " + content.indexOf(line) + " line\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //13.  Сохранить в файл, связанный с выходным потоком, записи о телефонах и их вла-дельцах. Вывести в файл записи, телефоны в которых начинаются на k и на j.

    public static File createTelephoneBaseFile(String baseFilePath){
        File file = new File(baseFilePath);
        Map<String, String> telephoneBase = new HashMap<>();
        telephoneBase.put("Ivanov", "773-15-23");
        telephoneBase.put("Petrov", "672-12-98");
        telephoneBase.put("Sidorov", "772-13-13");
        telephoneBase.put("Fedorov", "612-62-62");
        telephoneBase.put("Egorov", "555-15-15");
        telephoneBase.put("Orlov", "343-33-33");
        telephoneBase.put("Berezov", "394-11-71");
        try (FileWriter fileWriter = new FileWriter(file)){
            for (Map.Entry<String, String> entry : telephoneBase.entrySet()){fileWriter.write(entry.getKey() + " " + entry.getValue() + "\n");}
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static void filterTelephoneBase(File telephoneBase, Integer... startNum) {
        List<String> content = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(telephoneBase))){
            while (bufferedReader.ready()){
                content.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Integer> numbers = Arrays.asList(startNum);
        File file = new File(telephoneBase.getAbsolutePath().replace(".txt", "_task13_result.txt"));
        try (FileWriter fileWriter = new FileWriter(file)){
            for (String line : content){
                String[] words = line.split("\\s+");
                if (numbers.contains(Integer.parseInt(String.valueOf(words[1].charAt(0))))){
                    fileWriter.write(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
