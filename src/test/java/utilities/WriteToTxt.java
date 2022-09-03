package utilities;

import pojos.Appointment;
import pojos.C_MessageGet;
import pojos.Physician;
import pojos.Registrant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToTxt {



    public static void saveRegistrantData(Registrant registrant){
        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("api_registrant_data"), true);

            BufferedWriter writer = new BufferedWriter(fileWriter);


            writer.append(registrant+"\n");


            writer.close();



        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void saveAppointData(Appointment appointment){

        try{

            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("appointment_records"), true);

            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(appointment+"\n");


            writer.close();



        }catch (Exception e){
            e.printStackTrace();
        }


    }




    public static void saveRegistrantData(List<Object> SSNIds){
        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("database_registrant_data"), false);

            BufferedWriter writer = new BufferedWriter(fileWriter);

            for(Object eachSSN: SSNIds) {
                writer.append(eachSSN + ",\n");
            }

            writer.close();



        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public static void saveRegistrantData(Registrant [] registrants){
        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("api_all_registrant_data"), false);

            BufferedWriter writer = new BufferedWriter(fileWriter);


            for(int i=0; i< registrants.length;i++) {
                writer.append(registrants[i].getFirstName()+","+ registrants[i].getLastName()+","+registrants[i].getSsn()+","+ registrants[i].getLogin()+
                        ","+ registrants[i].getId()+","+registrants[i].getEmail()+ "\n");
            }

            writer.close();



        }catch (Exception e){
            e.printStackTrace();
        }


    }

//    public static void savePhysicianIds(String fileName, Physician[] physicians)  {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
//
//            for (int i = 0; i < physicians.length ; i++) {
//                writer.append(physicians[i].getId()+",\n");
//            }
//
//
//            writer.close();
//        } catch(Exception e){
//
//        }
//    }

    public static void savePhysicianIds(String fileName, List<Object> id){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false));

            for (int i=0; i< id.size(); i++)
                writer.append(id.get(i).toString()+",\n");

            writer.close();
        } catch (IOException e){
        }
    }

    public static void savePhysicianName(String fileName, List<Object> firstname){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false));

            for (int i=0; i< firstname.size(); i++)
                writer.append(firstname.get(i).toString()+",\n");

            writer.close();
        } catch (IOException e){
        }
    }




    public static void savePatientId(String fileName, List<Object> id){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false));
            for (int i=0; i< id.size(); i++)
                writer.append(id.get(i).toString()+",\n");
            writer.close();
        } catch (IOException e){
        }
    }

    public static void saveStafftId(String fileName, List<Object> id){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false));
            for (int i=0; i< id.size(); i++)
                writer.append(id.get(i).toString()+",\n");
            writer.close();
        } catch (IOException e){
        }
    }
    public static void saveItemId(String fileName, List<Object> id) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
            for (int i = 0; i < id.size(); i++)
                writer.append(id.get(i).toString() + ",\n");
            writer.close();
        } catch (IOException e) {
        }
    }

    public static void saveItemName(String fileName, List<Object> name) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
            for (int i = 0; i < name.size(); i++)
                writer.append(name.get(i).toString() + ",\n");
            writer.close();
        } catch (IOException e) {
        }
    }

    public static void SaveCountryId(String id){
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(ConfigurationReader.getProperty("countryIdTex"),true));
            bw.append("\n"+id);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void saveCountryIds(String fileName, List<Object> id){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false));
            for (int i=0; i< id.size(); i++)
                writer.append(id.get(i) +",\n");
            writer.close();
        } catch (IOException e){
        }
    }


    public static void writePatientInfo(String id){

        try {
            FileWriter fileWriter = new FileWriter("src/test/resources/testData/PatientInfo.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(id + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public static void saveMessage(C_MessageGet[] messages) {
        try {
            //src/test/resources/testData/Messages.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("api_all_messages_data"), false);

            BufferedWriter writer = new BufferedWriter(fileWriter);


            for (int i = 0; i < messages.length; i++) {
                writer.append(messages[i].getEmail() + "," + messages[i].getId() + "," + messages[i].getMessage() + "," + messages[i].getName() +
                        "," + messages[i].getSubject() + "\n");
            }

            writer.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}