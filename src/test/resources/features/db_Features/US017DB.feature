Feature: Data Base ile kontrol

  Scenario: DB ile tum testitemler dogrulanmali
    Given kullanici data base ile baglanti kurar
    Then kullanici query tanimlar
    And kullanici tum test ıtem bilgilerine ulasir ve kaydeder
    And kullanici tum test ıtem bilgilerini dogrular