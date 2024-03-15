package file_package;
import java.io.*;

public class CapsLock extends FileRedactor{
    public CapsLock(String main_path) {
        super(main_path); //Вызов конструктора родительского класса (супер-класса**)
    }
    @Override
    void Procedure() {
        System.out.println("Procedure in CAPS\n Check result-file");

        StringBuilder content = new StringBuilder(); //Накапливаемое содержимое

        for(int i=0; i<(array_name_files.length-1);i++){
            File cur_file = new File(array_name_files[i]);

            try (FileInputStream fis = new FileInputStream(cur_file);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {

                String line;
                content.append('\n' + "Файл " + array_name_files[i] + ":" + '\n');
                while ((line = reader.readLine()) != null) {
                    line = line.toUpperCase();
                    content.append(line).append("\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        File output_file = new File(array_name_files[array_name_files.length-1]);

        try (FileOutputStream fos = new FileOutputStream(output_file);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos))) {

            writer.write(content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
