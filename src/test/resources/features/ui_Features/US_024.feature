Feature: My Appointments (Randevular) (Patient)

  Background:
    Given Hasta Medunna Url'e gider.
    And Hasta sag uste bulunan account-menu 'yu tıklar.
    And Hasta Sign in butonuna tıklar ve giriş yapar
    And Hasta My Pages butonuna tıklar.
    And Hasta My Appointments butonuna tıklar.
    And Hasta tarih aralıgını secer


  Scenario:Hasta hesabına girdiğinde test sonuçlarını görebilmelidir. Test sonuçlarında " id, name for test,
  default max ve min value, test date and description" bölümleri görülmelidir.

    And Hasta Show Test butonuna tıklar.
    And Hasta View Results butonuna tıklar.
    And sayfayi kapatir


    Scenario:Hasta faturasinida görebilmelidir. (Show Invoice)
      And Hasta Show Invoice butonuna tıklar.
      And sayfayi kapatir
