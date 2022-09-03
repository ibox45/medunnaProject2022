Feature: API ile dogrulayin

  @US_17_TC06_API
  Scenario: api ile dogrulama

    Given kullanici testItem icin get request yapar
    And kullanici gelen json test item datalari javaya donustur
    And kullanici  testItem datasini dogrular

  @US_17_TC07_API
  Scenario: api ile test item olusturma

    Given kullanici testItem icin post request yapar
    And kullanici post request validation yaparr
