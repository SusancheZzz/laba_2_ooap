
import file_package.CapsLock;
import file_package.FindWordsOneFile;

//ШАБЛОННЫЙ ПАТТЕРН ПРОЕКТИРОВАНИЯ
public class Main {
    public static void main(String[] args){

        String name_path = "D:\\TASKS JAVA\\OOAP\\laba_2\\my_path";
        CapsLock caps = new CapsLock(name_path);
        FindWordsOneFile findWords = new FindWordsOneFile(name_path);

        //caps.Work();
        findWords.Work();
    }
}
