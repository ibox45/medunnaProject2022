Feature: US027_TC03 Kullanici, API kullanarak ileti olusturmayi ve okumayi dogrulamalidir


  @US027_API  @US027_API_GET
  Scenario: API ile ileti okumayi dogrulama
    Given Kullanici istedigi ileti icin GET method'unu kullanir
    Then Kullanici ileti bilgilerini dogrular


  @US027_API @US027_API_POST
  Scenario: API ile ileti olusturmayi dogrulama
    Given Kullanici ileti olusturmak icin POST Method'unu kullanir
    Then Kullanici olusturdugu iletiyi dogrular


