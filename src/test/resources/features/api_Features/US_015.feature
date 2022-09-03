@US_15_API
Feature: API ile hasta bilgilerini doğrulayın

  @US15_GET
  Scenario: API ile hasta bilgilerini doğrula (GET)
    Given URL'e Get Request gonder ve Response al
    Then Status Code'un 200 oldugunu dogrula
    And Response De-seralize et ve patient bilgilerini dogrula

    @US_15_DELETE
  Scenario: API ile hasta sil (DELETE)
    Given URL'e Delete Request gonder, Response al ve dogrula

  @US_15_POST
    Scenario: API ile yeni hasta olustur (POST) 201
      Given URL'e Post Request gonder, Response al ve dogrula

  @US_15_PUT
    Scenario: API ile hasta guncelle (PUT)
      Given URL'e Put Request gonder, Response al ve dogrula
