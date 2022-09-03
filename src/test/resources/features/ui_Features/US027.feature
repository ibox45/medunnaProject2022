Feature: Messages by Admin Validate with API and DB

  Background:
    Given Admin Kullanici anasayfaya gider
    When Admin kullanici anasayfadaki account-menu ye tiklar
    And Admin kullanici sign in butonuna tiklar
    Then Admin kullanici gecerli username ve password girisi yapar
    And Admin kullanici ikinci sign in butonuna tiklar
    And Admin kullanici  sagustteki menuden  Items&Titles a tiklar
    And Kullanici acilan dropdown menuden Messages satirina tiklar

  @US027_UI  @US027_UI_01
  Scenario: Admin, mesaj portalina gidebilir ve tum mesajlari, yazarlarini ve e-postalarini goruntuleyebilir.
    Given Kullanici acilan sayfadaki Message basliginin oldugunu gorur
    And Kullanici acilan sayfadaki Name basliginin oldugunu gorur
    And Kullanici acilan sayfadaki Email basliginin oldugunu gorur
    And Sayfa kapan


  @US027_UI  @US027_UI_02
  Scenario: Admin, mesajları oluşturabilir, güncelleyebilir, silebilir.
    Given Kullanici acilan sayfada  Create a new Message butonunu gorur ve tiklar
    When Kullanici Name Email Subject Message  bolumlerine ifade girisi yapar save butonuna tiklar
    Then Save butonuna tiklanir ve ekrana gelen ID goruntulenip kaydedilir
    And ID ye tiklayarak siralama degistirip olusturulan son mesajin sayfaya gelmesi saglanir
    And Sayfadaki View butonu ile olusturuldugunu gorur
    And Edit butonuna tiklayarak olusturulan mesajin iceriginin degistirilebildigini gorur
    And Delete butonunu kullanarak olusturulan mesajin guncel listede olmadigini gorur
    And Sayfa kapan
