Feature:US027_TC04 Kullanıcı DB ile mesajları doğrulamalıdır

  @US027_DB
  Scenario: DB ile mesajları doğrulama
    Given Kullanici database ile baglanti olusturur
    When Kullanici query tanimlamalarini gerceklestirir
    Then Kullanici DB deki mesajlara ulasir ve kaydeder
    And Kullanici DB'den gelen mesajlari dogrular