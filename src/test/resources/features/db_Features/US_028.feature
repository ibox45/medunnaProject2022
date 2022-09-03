Feature: US_28 Database ile doğrulama

  Scenario: Kullanıcı DB kullanarak country bilgilerini doğrulamalı
    Given Admin database ile baglanti saglar
    And Admin database'den tum country bilgilerine ulasır ve kaydeder
    And Admin DB'den gelen tum country bilgilerini dogrulamalidir