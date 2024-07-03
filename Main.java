
import java.util.Scanner;
import java.io.*;

// Part 1 Data Set Information and Attribute Information
//1.1 = year, rank_display, university, score, link, country, city, region, logo,

// 1.2 = All the data type  is String

//Part 2 Basic descriptive with Java
//= 2.1
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("D:\\WORKS\\Intellij java\\Main\\QS-World-University-Rankings-2017.csv"));
        sc.useDelimiter("");

        while (sc.hasNext()) {
            System.out.print(sc.next());
        }
        sc.close();

    }

}

