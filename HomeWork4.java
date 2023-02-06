//1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль,
// используя классы FileWriter и FileReader
//2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы.
// Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
//3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки.
// Фамилии, имена, отчества, возрас и пол в отдельных списках.
//4.Отсортировать по возрасту используя дополнительный список индексов.


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class HomeWork4 {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("db.sql");
            fileWriter.append("Иванов Сергей Михайлович 39 М \n");
            fileWriter.append("Петров Владимир Сергеевич 45 М \n");
            fileWriter.append("Сидорова Светлана Владимировна 29 Ж \n");
            fileWriter.append("Васильева Наталья Александровна 51 Ж \n");
            fileWriter.append("Николаев Антон Юрьевич 32 М");
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileReader fileReader = new FileReader("db.sql");
            String txt = "";
            while (fileReader.ready()) {
                txt += (char) fileReader.read();
            }
            List<String> stringList = List.of(txt.split("\n"));
            String[] tempStr;
            ArrayList<String> lastName = new ArrayList<>();
            ArrayList<String> firstName = new ArrayList<>();
            ArrayList<String> secondName = new ArrayList<>();
            ArrayList<Integer> age = new ArrayList<>();
            ArrayList<Boolean> gender = new ArrayList<>();
            ArrayList<Integer> id = new ArrayList<>();

            for (int i = 0; i < stringList.size(); i++) {
                tempStr = stringList.get(i).split(" ");
                lastName.add(tempStr[0]);
                firstName.add(tempStr[1]);
                secondName.add(tempStr[2]);
                age.add(Integer.parseInt(tempStr[3]));
                gender.add(tempStr[4].contains("М") ? false : true);
                id.add(i);
            }


            System.out.println(lastName);
            System.out.println(firstName);
            System.out.println(secondName);
            System.out.println(age);
            System.out.println(gender);
            System.out.println(id);

            Collections.sort(age);
            System.out.println(age);

//            ArrayList<Integer> sortedAge = sortId(age, id);
//            System.out.println(sortedAge);

//            Iterator<String> iterator = stringList.iterator();
//            String str = null;
//            while (iterator.hasNext()) {
//                str = iterator.next();
//                System.out.println(str);
//            }

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    public static ArrayList<Integer> sortId(ArrayList<Integer> ages, ArrayList<Integer> ids){
//        int tempAge;
//        int tempId;
//        int count = 0;
//        for (int i = 0; i < ages.size() - count; i++) {
//            count = i + 1;
//            tempAge = ages.get(i + 1);
//            tempId = ids.get(i + 1);
//            ages.set(i + 1, tempAge);
//            ids.set(i + 1, tempId);
//            count++;
//        }
//        return ages;
//    }
}