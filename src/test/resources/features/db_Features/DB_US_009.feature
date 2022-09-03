@US_009_DB
Feature:US09 Staff (Personel), hasta bilgilerini gorebilmeli, duzenleyebilmeli ve silebilmelidir.

  Scenario:Kullanıcı, DB kullanarak tüm hasta bilgilerini doğrulamalıdır.

    Given Kullanici database ile baglanti kurar
    And Kullanici query tanimlar
    And Kullanici database'den tum hasta bilgilerine ulasır ve kaydeder
    And Kullanıcının DB'den gelen tüm hasta bilgilerini doğrulamalıdır.


