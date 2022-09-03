@Mdn
Feature: US014 Doktor "Edit Inpatient" (Yatılı Tedavi) işlemleri yapabilmeli

Background:
    Given doktor "medunnaUrl" anasayfasina gider
    And  Kullanıcı sag ustde account-menu tıklar
    And Doktor Sign in butonuna tıklar
    And Username bolumune "Username" yazar
    And kullanici 1 sn bekler
    And Doktor password bolumune "Password" yazar
    And Sign in butonuna tıklar
    And Doktor My Pages butonuna tıklar
    And Doktor My Inpatients butonuna tıklar
    And Doktor tarih aralıgını secer
    And Doktor hasta adıyla aynı satırdaki  Edit butonuna tıklar

  Scenario:TC01 Doktor"ID, start and end dates, description, created date
  appointment id, status, room and patient" bilgilerini görüntülüyebilmeli
    And kullanici 2 sn bekler
    And sayfayi kapatir

  Scenario:TC02 "Status" doktor tarafından "UNAPPROVED, DISCHARGED, STILL STAYING veya CANCELLED" olarak güncellenebilmeli

    And kullanici 2 sn bekler
    And Doktor Status secenegini gunceller
    And kullanici 2 sn bekler
    And sayfayi kapatir

  Scenario: TC03 Doktor rezerve edilmiş odayı güncelleyebilmeli

    And kullanici 1 sn bekler
    And Doktor room bilgisini gunceller
    And kullanici 2 sn bekler
    And sayfayi kapatir