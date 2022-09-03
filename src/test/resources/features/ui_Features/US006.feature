@US006
Feature: US006 Kullanıcı bilgisi sekmesi (Setting) Ana Sayfada düzenlenebilir olmalıdır.


  Scenario: TC001 Kullanıcı bilgileri "firstname, lastname, email and language" girerken doldurulan kullanıcı bilgileri olmalıdır.

    When Kullanici "medunnaUrl" adresinde
    And Kullanici account-menu butonuna tiklar
    And Kullanici Sign in butonuna tiklar
    And Kullanici gecerli username ve password ile girisi yapar
    Then Kullanici account-menu butonuna tiklar
    And Kullanici settings butonuna tiklar
    And Firstname textbox'unda onceden girilen isimin gorundugu dogrulanir
    And Lastname textbox'unda onceden girilen soyismin gorundugu dogrulanir
    Then email textbox'unda onceden girilen mail adresinin gorundugu dogrulanir
    Then kullanici sayfayi kapatir


  Scenario: TC002 "Firstname"güncelleme seçeneği olmalıdır.

    When Kullanici "medunnaUrl" adresinde
    And Kullanici account-menu butonuna tiklar
    And Kullanici Sign in butonuna tiklar
    And Kullanici gecerli username ve password ile girisi yapar
    Then Kullanici account-menu butonuna tiklar
    And Kullanici settings butonuna tiklar
    And Kulanici farkli isim girer
    And Kullanici Save butonuna tiklar
    Then Settings Saved yazisi gorundugu dogrulanir
    Then kullanici sayfayi kapatir


  Scenario: TC003 "Lastname"güncelleme seçeneği olmalıdır.

    When Kullanici "medunnaUrl" adresinde
    And Kullanici account-menu butonuna tiklar
    And Kullanici Sign in butonuna tiklar
    And Kullanici gecerli username ve password ile girisi yapar
    Then Kullanici account-menu butonuna tiklar
    And Kullanici settings butonuna tiklar
    And Kulanici farkli soyisim girer
    And Kullanici Save butonuna tiklar
    Then Settings Saved yazisi gorundugu dogrulanir
    Then kullanici sayfayi kapatir


  Scenario: TC004 "Email"güncelleme seçeneği olmalıdır.

    When Kullanici "medunnaUrl" adresinde
    And Kullanici account-menu butonuna tiklar
    And Kullanici Sign in butonuna tiklar
    And Kullanici gecerli username ve password ile girisi yapar
    Then Kullanici account-menu butonuna tiklar
    And Kullanici settings butonuna tiklar
    And Kulanici farkli email girer
    And Kullanici Save butonuna tiklar
    Then Settings Saved yazisi gorundugu dogrulanir
    Then kullanici sayfayi kapatir

