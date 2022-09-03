@Mdn
Feature: US012 Doktor Test İsteyebilmeli

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
   And kullanici 1 sn bekler
   And Doktor Request A Test butonuna tıklar
   And kullanici 1 sn bekler

  Scenario:TC01 Doktor Test İsteyebileli
    And kullanici 1 sn bekler
   And sayfayi kapatir




  Scenario: TC02 Doktorun talep ettigi Test içeriğinde "Glucose, Urea, Creatinine, Sodium
  Potassium, Total protein, Albumin, Hemoglobin" seçenekleri olmalı

    And kullanici 3 sn bekler
    And Doktor Glucose,Urea,Creatinine,Sodium,Potasyum,Total protein,Albumin,Hemoglobin testlerine ait kutucukları isaretler
    And kullanici 3 sn bekler
    And Doktor Save butonuna tıklar
    And sayfayi kapatir
