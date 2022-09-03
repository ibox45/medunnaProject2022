package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestItem {

    private String name;
    private String description;
    private int price;
    private String defaultValMin;
    private String defaultValMax;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDefaultValMin() {
        return defaultValMin;
    }

    public void setDefaultValMin(String defaultValMin) {
        this.defaultValMin = defaultValMin;
    }

    public String getDefaultValMax() {
        return defaultValMax;
    }

    public void setDefaultValMax(String defaultValMax) {
        this.defaultValMax = defaultValMax;
    }

    public TestItem() {
    }

    public TestItem(String name, String description, int price, String defaultValMin, String defaultValMax) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.defaultValMin = defaultValMin;
        this.defaultValMax = defaultValMax;
    }

    @Override
    public String toString() {
        return "TestItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", defaultValMin='" + defaultValMin + '\'' +
                ", defaultValMax='" + defaultValMax + '\'' +
                '}';
    }
}

/*
[
     {
          "createdBy": "anonymousUser",
          "createdDate": "2021-12-21T22:33:06.907662Z",
          "id": 3403,
          "startDate": "2021-12-22T17:00:00Z",
          "endDate": "2021-12-25T18:00:00Z",
          "status": "COMPLETED",
          "anamnesis": null,
          "treatment": null,
          "diagnosis": null,
          "prescription": "",
          "description": "cfgvhbjn",
          "physician": {
               "createdBy": "oscarlebsack",
               "createdDate": "2022-03-01T13:26:00.734890Z",
               "id": 10501,
               "firstName": "Harlan",
               "lastName": "Krajcik",
               "birthDate": "2001-12-02T23:00:00Z",
               "phone": "1234567890",
               "gender": "FEMALE",
               "bloodGroup": "ABpositive",
               "adress": "Apt. 341 12226 Dell Coves, Marcelview, VT 46426-5626",
               "description": "Patient Info",
               "user": {
                    "createdBy": "anonymousUser",
                    "createdDate": "2022-03-29T10:10:27.911556Z",
                    "id": 43194,
                    "login": "user_112233445_56677889991648548627822",
                    "firstName": "a",
                    "lastName": "b",
                    "email": "cazs@asblas.com",
                    "activated": false,
                    "langKey": null,
                    "imageUrl": null,
                    "resetDate": null,
                    "ssn": "444-44-0005"
               },
               "speciality": "OPHTHALMOLOGY",
               "country": {
                    "id": 80065,
                    "name": "USA"
               },
               "cstate": {
                    "id": 1254,
                    "name": "Arizona",
                    "country": {
                         "id": 1201,
                         "name": "Türkye"
                    }
               },
               "examFee": 300.00,
               "image":"",
               "imageContentType": "image/png"
          },
          "patient": null,
          "ctests": null
     },
 */