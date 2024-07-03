import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// 2.2
public class UniData {
    public static void main(String[] args) {

        String csvFile = "D:\\WORKS\\Intellij java\\Main\\QS-World-University-Rankings-2017.csv";
        String csvFile1 = "QS_World University Ranking 2017_out.CSV";
        List<DataObject> dataObjects = new ArrayList<>();

        try {
            BufferedReader BR = new BufferedReader(new FileReader(csvFile));
            BufferedWriter BW = new BufferedWriter(new FileWriter(csvFile1));
            String line;

            while ((line = BR.readLine()) != null) {
                String[] data = line.split(",");
                DataObject DataOb = new DataObject();
                DataOb.setField1(data[0]);
                DataOb.setField2(data[1]);
                DataOb.setField3(data[2]);
                DataOb.setField4(data[3]);
                DataOb.setField5(data[4]);
                DataOb.setField6(data[5]);
                DataOb.setField7(data[6]);
                DataOb.setField8(data[7]);
                DataOb.setField9(data[8]);
                dataObjects.add(DataOb);
            }
            for (DataObject DataOb : dataObjects) {
                BW.write(DataOb.getField1() + "," + DataOb.getField2() + "," + DataOb.getField3()
                        + ","  + DataOb.getField4() + "," + DataOb.getField5() + "," + DataOb.getField6()
                        + ","  + DataOb.getField7() + "," + DataOb.getField8() + "," + DataOb.getField9() + "\n");
            }
            BR.close();
            BW.write("2017,551-600,Chiang Mai University, ,https://www.topuniversities.com/universities/chiang-mai-university,Thailand,Chiang Mai,Asia,https://www.topuniversities.com/sites/default/files/profiles/logos/chiang-mai-university_118_large.jpg");
            BW.close();
        } catch (IOException e) {
           System.out.println("Can't find file");
        }
    }
}

class DataObject {
    private String field1;
    private String field2;
    private String filed3;
    private String filed4;
    private String filed5;
    private String filed6;
    private String filed7;
    private String filed8;
    private String filed9;

    public String getField1() {
        return field1;
    }
    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }
    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3(){
        return filed3;
    }
    public void setField3(String field3) {
        this.filed3 = field3;
    }

    public String getField4(){
        return filed4;
    }
    public void setField4(String field4) {
        this.filed4 = field4;
    }

    public String getField5(){
        return filed5;
    }
    public void setField5(String field5) {
        this.filed5 = field5;
    }

    public String getField6(){
        return filed6;
    }
    public void setField6 (String field6) {
        this.filed6 = field6;
    }

    public String getField7(){
        return filed7;
    }
    public void setField7 (String field7) {
        this.filed7 = field7;
    }

    public String getField8(){
        return filed8;
    }
    public void setField8 (String field8) {
        this.filed8 = field8;
    }

    public String getField9(){
        return filed9;
    }
    public void setField9 (String field9) {
        this.filed9 = field9;
    }

    @Override
    public String toString() {
        return field1 + "," + field2 + "," + filed3 + "," + filed4 + "," + filed5;
    }
}