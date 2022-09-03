package utilities;

import pojos.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadTxt {



    public static List<String> getSSNIDs(){
        List <String > list = new ArrayList<>();


        try{

            //identify file location
            FileReader fileReader = new FileReader(ConfigurationReader.getProperty("database_registrant_data"));

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();//856-45-6789,

            while(line != null){

                String ssn = line.split(",")[0];
                list.add(ssn);

                line = br.readLine();

            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;
    }




    public static List<String> getAPISSNIDs(){
        List <String > list = new ArrayList<>();


        try{

            //identify file location
            FileReader fileReader = new FileReader(ConfigurationReader.getProperty("api_all_registrant_data"));

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();//856-45-6789,

            while(line != null){

                String ssn = line.split(",")[2];
                list.add(ssn);

                line = br.readLine();

            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;
    }



    public static List<Registrant> getAllRegistrants(){
        List <Registrant > list = new ArrayList<>();


        try{

            //identify file location
            FileReader fileReader = new FileReader(ConfigurationReader.getProperty("api_all_registrant_data"));

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();//856-45-6789,

            while(line != null){
                Registrant registrant = new Registrant();


                registrant.setFirstName(line.split(",")[0]);
                registrant.setLastName(line.split(",")[1]);
                registrant.setSsn(line.split(",")[2]);
                registrant.setLogin(line.split(",")[3]);
                if(line.split(",")[4] != null) {
                    String  id = line.split(",")[4];
                    boolean flag = true;
                    for(int i=0; i<id.length();i++){
                        if(id.charAt(i) >= '0' && id.charAt(i) <= '9'){
                            flag = true;
                        }else{
                            flag = false;
                            break;
                        }
                    }
                    if(flag)
                        registrant.setId(Integer.parseInt(line.split(",")[4]));
                }
                if(line.split(",")[5] != null)
                    registrant.setEmail(line.split(",")[5]);

                list.add(registrant);

                line = br.readLine();

            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;
    }



    public static List<Object> returnPhysicianIDsList(String filePath){
        List<Object>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Physician physician = new Physician();
                physician.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();

//                System.out.println(i++);

                all.add(physician.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }



    public static List<String> returnPhysicianName(String filePath){
        List<String>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Physician physician = new Physician();
                physician.setFirstName(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

//                System.out.println(i++);

                all.add(physician.getFirstName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }



    public static List<Object> returnPatientId(String filePath){
        List<Object>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Patient patient = new Patient();
                patient.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();

//            System.out.println(i++);

                all.add(patient.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    public static List<Object> returnStaffId(String filePath){
        List<Object>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Staff staff = new Staff();
                staff.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();

//            System.out.println(i++);

                all.add(staff.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }
    public static List<Object> returnTestItemId(String filePath){
        List<Object>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                TestItemId testItem = new TestItemId();
                testItem.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();

                //System.out.println(i++);

                all.add(testItem.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    public static List<Object> returnTestItemName(String filePath){
        List<Object>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                TestItemId testItem = new TestItemId();
                testItem.setName(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

                // System.out.println(i++);

                all.add(testItem.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    public static String readLastLinePatientInfoList(String filePath, int index) {
        List<String> patientList = new ArrayList<>();
        String line = "";
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fileReader);
            patientList = br.lines().collect(Collectors.toList());
            line = patientList.get(patientList.size() - index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }

    public static int readLastLinePatientInfoListInteger(String filePath, int index) {
        List<String> patientList = new ArrayList<>();
        int line = 0;
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fileReader);
            patientList = br.lines().collect(Collectors.toList());
            line = Integer.parseInt(patientList.get(patientList.size() - index));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }






   /* public static List<C_MessageGetId> gettAllRegistrants(){
        List <C_MessageGetId > list = new ArrayList<>();


        try{

            //identify file location
            FileReader fileReader = new FileReader(ConfigurationReader.getProperty("api_all_registrant_data"));

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();//856-45-6789,

            while(line != null){
                C_MessageGetId c_messageGetId = new C_MessageGetId();


                c_messageGetId.setEmail(line.split(",")[0]);
                c_messageGetId.setMessage(line.split(",")[1]);
                c_messageGetId.setName(line.split(",")[2]);
                c_messageGetId.setSubject(line.split(",")[3]);
                if(line.split(",")[4] != null) {
                    String  id = line.split(",")[4];
                    boolean flag = true;
                    for(int i=0; i<id.length();i++){
                        if(id.charAt(i) >= '0' && id.charAt(i) <= '9'){
                            flag = true;
                        }else{
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        c_messageGetId.setId(Integer.parseInt(line.split(",")[4]));
                    }
                }

                list.add(c_messageGetId);

                line = br.readLine();

            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;
    }

    */
}