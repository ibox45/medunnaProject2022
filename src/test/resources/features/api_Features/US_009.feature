Feature:US_009 API
  @US_009_API
 Scenario Outline:Kullanici API kullanarak tum hasta bilgilerini dogrulamalidir.

    Given Kullanici Medunna patient API endpointini "<patientId>" ile olusturur
  And Kullanici patient icin get request gonderir ve response alir
    Then Kullanici statuscode 200 oldugunu dogrular
    And Kullanici gelen Json patient datalarini javaya donusturur
    And Kullanici API ile gelen bilgileri "<patientId>" dogrular

  Examples: id
    |patientId|
    |154140   |
