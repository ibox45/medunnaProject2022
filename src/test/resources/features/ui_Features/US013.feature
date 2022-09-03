@Mdn
Feature: US013 Doktor Test Results işlemleri yapabilmeli

  Background:

    Given doktor "medunnaUrl" anasayfasina gider
    And  Kullanıcı sag ustde account-menu tıklar
    And Doktor Sign in butonuna tıklar
    And Username bolumune "Username" yazar
    And kullanici 1 sn bekler
    And Doktor password bolumune "Password" yazar
    And Sign in butonuna tıklar
    And Doktor My Pages butonuna tıklar
    And Doktor My Appointments butonuna tıklar
    And Doktor tarih aralıgını secer
    And Doktor hasta adıyla aynı satırdaki  Edit butonuna tıklar

  Scenario:TC01 Doktor Test sonuçlarındaki "id, name(Urea, Sodium, Glucose etc..),
  default max value, default min value, test, description and the date" bilgilerini görebilmeli
    And kullanici 4 sn bekler
    And Doktor Show Test Result butonuna tıklar
    And kullanici 2 sn bekler
    And Doktor View Results butonuna tıklar
    And kullanici 2 sn bekler
    And sayfayi kapatir



  Scenario:TC02 Doktor "Request Impatient" (hastanin yatili tedavi gormesi) isteginde bulunabilmeli

    And kullanici 2 sn bekler
    And Doktor Request Inpatıent butonunu tıklar
    And kullanici 1 sn bekler
    And sayfayi kapatir