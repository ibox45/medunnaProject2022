Feature: US_010 Doktor randevulari

Background:

    Given medunna sayfasina git
    Then Account-menuye tikla
    And Sing in tikla
    And Username kismina "username",  Password kismina  "password" gir
    And Sing in butonuna tikla
    And MY PAGES sekmesini tikla
    And My Appointments sekmesini tikla
    And Appointmentin gorunur oldugunu dogrula
    And Onbes gunluk tarih araligini sec
    And Zaman diliminin gorunur oldugunu dogrula


  Scenario:US_010-TC_001 Kullanici, randevu listesini ve zaman dilimlerini My Appointments sekmesinden gorebilmeli
    And Belirtilen tarihler arasindaki hasta randevu listesinin gorunur oldugunu dogrula
    And Sayfayi kapat

  Scenario: Kullanici "patient id, start date, end date, status" bilgilerini gorebilmeli
    And ID,Start DateTime, End DateTime, Status kısımlarının ve burada bulunan bilgilerin gorunur olduğunu dogrula
    And sayfayi kapatir



