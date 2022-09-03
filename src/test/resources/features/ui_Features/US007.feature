
Feature: US007 Patient login ile randevu olusturabilir

  Background:
    Given Hasta Kullanici "medunnaUrl" gider
    When Kullanici anasayfadaki account-menu ye tiklar
    And Kullanici sign in butonuna tiklar
    Then Kullanici gecerli isim girisi yapar
    And Kullanici gecerli sifre girisi yapar
    And Kullanici ikinci sign in butonuna tiklar
    When Kullanici acilan sayfadaki MY PAGES(PATIENT) bolumune gelir
    And Make an Appointment'i tiklar
    And Kullanici gecerli Phone numarasini girer
    Then 1 saniye




  @US007   @TC01
  Scenario: TC01 Kullanıcı geçerli tarih girmelidir. (güncel tarihi veya gelecekteki tarihleri seçebilmelidir)

    Given Appointment DateTime altindaki kutucuga gunun tarihi girilir
    Then 2 saniye
    And Send an Appointment Request'e tiklanir
    And Kullanici sayfayi kapatir

  @US007  @TC01
  Scenario: TC01-2 Kullanici geleckteki tarihi girebilmelidir

    Then Appointment DateTime altindaki kutucuga ileri bir tarih girilir
    Then 2 saniye
    And Send an Appointment Request'e tiklanir
    And Kullanici sayfayi kapatir


  @US007    @TC02
  Scenario: TC02 Tarih sırası gün/ay/yıl şeklinde olmalıdır.

    Then Appointment DateTime altindaki kutucuga ileri bir tarih girilir
    Then 2 saniye
    And Girilen tarihin gun.ay.yil formatinda oldugu test edilir
    And Send an Appointment Request'e tiklanir
    And Kullanici sayfayi kapatir
