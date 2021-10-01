package service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JavaProgramService {

    //2.     Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.
    public static void changeAccessModifiersFromPublicToPrivate(File file) {
        List<File> files = new ArrayList<>();
        if (file.isDirectory()) {
            files = createTreeOfFiles(file);
            for (File f : files) {
                List<String> lines = new ArrayList<>();
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(f))) {
                    while (bufferedReader.ready()) {
                        lines.add(bufferedReader.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //------------ Decided to create a clone of program and write output there, to see the difference
                File fileExitDirectory = new File(f.getParentFile().getAbsolutePath().replace(file.getAbsolutePath(), (file.getAbsolutePath() + "_task2_converted")));
                fileExitDirectory.mkdirs();
                try (FileWriter fileWriter = new FileWriter(fileExitDirectory.getAbsolutePath() + "/" + f.getName())) { // write exit file to another folder to check the difference
                    for (String line : lines) {
                        if (line.contains("public")) {
                            fileWriter.write(line.replace("public", "private") + "\n");
                        } else {
                            fileWriter.write(line + "\n");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // In case there will be only one file
        else {
            List<String> lines = new ArrayList<>();
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                while (bufferedReader.ready()) {
                    lines.add(bufferedReader.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            File convertedFile = new File(file.getAbsolutePath().replace(".java", "task2_converted.java"));
            try (FileWriter fileWriter = new FileWriter(convertedFile)) {
                for (String line : lines) {
                    if (line.contains("public")) {
                        fileWriter.write(line.replace("public", "private") + "\n");
                    } else {
                        fileWriter.write(line + "\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<File> createTreeOfFiles(File file){
        List<File> files = new ArrayList<>();
        for (File f : Objects.requireNonNull(file.listFiles())){
            if (f.isDirectory()){
                files.addAll(createTreeOfFiles(f));
            }
            else {
                files.add(f);
            }
        }
        return files;
    }

    //3.     Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.
    public static void writeJavaFileInBackOrder(File file){
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            while (bufferedReader.ready()){
                lines.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File convertedFile = new File(file.getAbsolutePath().replace(".java", "_task3_converted.java"));
        try (FileWriter fileWriter = new FileWriter(convertedFile)){
            for (String line : lines){
                StringBuilder stringBuilder = new StringBuilder();
//-------------------------------------- if need to save tabulation -----------------------------
                for (int i = 0; i < line.length(); i++){
                    if (line.charAt(i) == ' '){
                        stringBuilder.append(line.charAt(i));
                    }
                    else {
                        break;
                    }
                }
                String tabulation = stringBuilder.toString();
//-----------------------------------------------------------------------------------
                String lineInBackOrder = new StringBuffer(line).reverse().toString();
                fileWriter.write(tabulation + lineInBackOrder + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //4.     Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы заменить прописными.
    public static void changeCaseOfWordsLongerTwoSymbolsInJavaProgramme(File file){
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            while (bufferedReader.ready()){
                lines.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File convertedFile = new File(file.getAbsolutePath().replace(".java", "_task4_converted.java"));
        try (FileWriter fileWriter = new FileWriter(convertedFile)){
            for (String line : lines){
                StringBuilder stringBuilder = new StringBuilder();
                String[] words = line.split("\\s+");
                for (String word : words){
                    if (word.replaceAll("[^a-zA-Z]", "").length() > 2){
                        word = word.toUpperCase();
                    }
                    stringBuilder.append(word + " ");
                }
                line = stringBuilder.toString();
                fileWriter.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //8.     Прочитать текст Java-программы и удалить из него все «лишние» пробелы и табуляции, оставив только необходимые для разделения операторов.
    public static void deleteExtraSpacesAndTabulationFromJavaFile(File file){
        List<String> content = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()){
                content.add(bufferedReader.readLine().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(file.getAbsolutePath().replace(".java", "_task8_converted.java"))){
            for (String s : content){
                if (s.length() != 0){
                    fileWriter.write(s.replaceAll("\\s+", " ") + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //9.     Из текста Java-программы удалить все виды комментариев.
    public static void deleteCommentsFromJavaFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(new FileReader(file))) {
            int b;
            while ((b = reader.read()) != -1) {
                if ((char) b == '/') {
                    int c;
                    if ((char) (c = reader.read()) == '/') {
                        int d;
                        while ((char) (d = reader.read()) != '\n') {
                            continue;
                        }
                        stringBuilder.append((char) d);
                    } else if ((char) c == '*') {
                        boolean isCommentClosed = false;
                        while (!isCommentClosed) {
                            int d;
                            if ((char) (d = reader.read()) == '*') {
                                int f;
                                if ((char) (f = reader.read()) == '/') {
                                    isCommentClosed = true;
                                }
                                if ((char) d == '\n') {
                                    stringBuilder.append((char) d);
                                }
                            }
                        }
                    } else {
                        stringBuilder.append((char) b);
                    }
                } else {
                    stringBuilder.append((char) b);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter fileWriter = new FileWriter(file.getAbsolutePath().replace(".java", "task9_converted.java"))) {
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
