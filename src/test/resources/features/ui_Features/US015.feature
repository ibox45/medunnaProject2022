Feature: Admin tarafından hasta oluşturma ve düzenleme

  Background: giris
    Given medunnaUrl sayfasina git
    When hesap menusune tikla
    Then birinci sign in butonuna tikla
    And Username kismina "admin_57team", Password kismina "ortakKullan.2022" gir
    And ikinci sign in butonuna tikla
    Then giris yapildigini dogrula
    Then Items&Titles butonuna tikla

  @US_15_TC_1
  Scenario: Yeni hastalar yalnızca yönetici tarafından oluşturulabilir
    Given acilan dropdownda Patient'i sec
    And Patient listesinin acildigini dogrula
    And Create a new Patient butonuna tikla
    And Gerekli textboxlari doldur
    And save butonuna tikla
    And New Patient Created basari mesajini dogrula
    And Sayfayı kapatır

  @US_15_TC_2
  Scenario: Yönetici ""SSN, First Name, Last Name, Birth Date, Phone, Gender, Blood Group, Address,Description, Created Date, User, Country and state / City"""" gibi hasta bilgilerini görebilir.
    Given acilan dropdownda Patient'i sec
    And Patient listesinin acildigini dogrula
    And Hastalarin bilgilerinin gorundugunu dogrular
    And Sayfayı kapatır

  @US_15_TC_3
  Scenario: Hasta oluşturulduğunda veya güncellendiğinde yukarıdaki öğelere data girişi yapılabilmeli.
    Given acilan dropdownda Patient'i sec
    Then Patient listesinin acildigini dogrula
    And patient listesinde olusturdugu hastanin bulundugu sayfaya gider
    And olusturulan hasta bilgilerini editler
    And bilgilerin guncellenebildigini dogrula
    And Sayfayı kapatır

  @US_15_TC_4
  Scenario: Hastaya doktoru sadece Admin atayabilir.
    Given acilan dropdownda Appointment'i sec
    Then Appointment listesinin acildigini dogrula
    And Create a new Appointment butonuna tikla
    And Gerekli olan textboxlari doldur
    And save butonuna tikla
    And A new Appointment is created basari mesajini goruldugunu dogrular
    And Sayfayı kapatır

  @US_15_TC_5
  Scenario: "Country", "US state" olmalı ve boş bırakılmamalı
    Given acilan dropdownda Patient'i sec
    Then Patient listesinin acildigini dogrula
    And ilk hastanin edit butonuna tiklar
    And Country kismini bos birakir
    And save butonuna tikla
    And Hata mesaji alir
    And ilk hastanin edit butonuna tiklar
    And Country kismini US secer
    And save butonuna tikla
    And basari mesajini dogrular
    And Sayfayı kapatır

  @US_15_TC_6
  Scenario: Yönetici herhangi bir hastayı silebilir
    Given acilan dropdownda Patient'i sec
    And Patient listesinin acildigini dogrula
    And Create a new Patient butonuna tikla
    And Gerekli textboxlari doldurur
    And save butonuna tikla
    And New Patient Created basari mesajini dogrula
    And bir hastanin delete butonuna tiklar
    And Gelen pop-up'da delete butonuna tiklar
    And  A Patient is deleted basari mesajini gorur
    And Sayfayı kapatır

