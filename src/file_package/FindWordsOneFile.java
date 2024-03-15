package file_package;
import java.io.*;
import java.util.*;

public class FindWordsOneFile extends FileRedactor{

    public FindWordsOneFile(String main_path) {
        super(main_path);
    }

    @Override
    void Procedure() {
        System.out.println(" Procedure in FIND_WORDS\n Check result-file");

        StringBuilder content = new StringBuilder(); //Накапливаемое содержимое

            try {
                // Считываем слова из первого файла
                Set<String> wordsToSearch = getWordsFromFile(new File(array_name_files[0]));

                // Перебираем все остальные файлы
                for (int j=1; j<array_name_files.length-1;j++) {
                        Set<String> foundWords = getWordsFromFile(new File(array_name_files[j]));

                        // Ищем общие слова и выводим их
                        if (!foundWords.isEmpty()) {
                            content.append('\n'+"Слова из файла " + array_name_files[j] + ", которые есть в первом файле:" + '\n');
                            for (String word : foundWords) {
                                if(wordsToSearch.contains(word))
                                    content.append(word+'\n');
                            }
                        }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        // Вывод результата в файл
        File output_file = new File(array_name_files[array_name_files.length-1]);

        try (FileOutputStream fos = new FileOutputStream(output_file);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos))) {

            writer.write(content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Set<String> getWordsFromFile(File file) throws IOException {
        Set<String> words = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.split("\\s+")) {
                    words.add(word);
                }
            }
        }
        return words;
    }

}



