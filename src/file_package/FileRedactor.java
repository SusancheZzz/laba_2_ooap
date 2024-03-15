package file_package;
import java.io.*;

//ШАБЛОННЫЙ ПАТТЕРН ПРОЕКТИРОВАНИЯ
public abstract class FileRedactor {
    protected String[] array_name_files; //Здесь последний файл будет нужен для вывода -> создавать отдельную стрингу для этого файла не надо
    protected String main_directory;
    public final void Work(){  // алгоритм выполнения с шаблонным методом
        setArray_name_files();
        Procedure();
    }
    public void setArray_name_files() {

        File MAIN_PATH = new File(main_directory);
        if (MAIN_PATH.isDirectory()) {
            File[] files = new File[(int)(MAIN_PATH.length())];
            files = MAIN_PATH.listFiles();
            String[] array_name = new String[files.length];

            for (int i = 0; i < files.length; ++i) {
                array_name[i] = files[i].getAbsolutePath();
            }
            this.array_name_files = array_name;
        }
        else System.out.println(this.main_directory + " -- Not directory!");
    }
    public void setMain_directory(String name_path){
        this.main_directory = name_path;
    }
    abstract void Procedure();  //Шаблонный метод
    public FileRedactor(String name_path){
        this.main_directory = name_path;
    }


}
