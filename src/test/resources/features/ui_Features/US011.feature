@us11
Feature: My Appointments Physician (Doctor) tarafindan duzenlenebilmeli

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

  Scenario: US_011-TC_001 Create or Edit an Appointment alani doktor tarafindan duzenlenebilmeli
    And ilk hasta icin Edit butonuna tikla
    And Create or Edit an Appointment yazisinin gorunur oldugunu dogrula
    And Status Anamnesis Treatment Diagnosis Prescription Aspirin Description kismlarini doldur
    And Save butonuna tiklayalim
    And ilk hastanin tum bilgilerinin gorunur oldugunu dogrula
    And Sayfayi kapat

  Scenario: US_011-TC_002 Bir randevu guncellendiginde hastanin Id Start DateTime End DateTime Status PhysicianPatient bilgileri gotuntulenebileli

    And ilk hasta icin Edit butonuna tikla
    And Create or Edit an Appointment yazisinin gorunur oldugunu dogrula
    And Status Anamnesis Treatment Diagnosis Prescription Aspirin Description kismlarini doldur
    And Save butonuna tiklayalim
    And Id Start DateTime End DateTime Status Physician Patient  bilgilerinin gorunur olgugunu dogrula
    And Sayfayi kapat


  Scenario: US_011TC_003 Doktor Anamnesis Treatment Diagnosis alanlarini bos birakmamali

    And ilk hasta icin Edit butonuna tikla
    And Create or Edit an Appointment yazisinin gorunur oldugunu dogrula
    And Anamnesis Treatment Diagnosis bolumunu temizle
    And Save butonuna tiklayalim
    And This field is required ifadelerinin goruldugunu dogrula
    And Sayfayi kapat


  Scenario: US_011TC_004 Prescription ve Description istege bagli olmali
    And ilk hasta icin Edit butonuna tikla
    And Create or Edit an Appointment yazisinin gorunur oldugunu dogrula
    Given Prescription Description bolumunu temizle
    And Save butonuna tiklayalim
    And Appointmentin gorunur oldugunu dogrula
    And Sayfayi kapat


  Scenario: US_011TC_005 Status doktor tarafindan PENDING COMPLETED veya CANCELLED olarak secilebilmeli

    And ucuncu hasta icin Edit butonuna tikla
    And Create or Edit an Appointment yazisinin gorunur oldugunu dogrula
    Given Status kismini tikla PENDING secimini yap
    And Save butonuna tiklayalim
    And Statusun PENDING oldugunu dogrula
    And ilk hasta icin Edit butonuna tikla
    And Status kismini tikla COMPLETED secimini yap
    And Save butonuna tiklayalim
    And Statusun COMPLETED oldugunu dogrula
    And ikinci hasta icin Edit butonuna tikla
    And Status kismini tikla CANCELLED secimini yap
    And Save butonuna tiklayalim
    And Statusun CANCELLED oldugunu dogrula
    And Sayfayi kapat

