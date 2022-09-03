Feature: Test items Olustur Guncelle Sil

  Background:
    Given medunna sayfasina git
    Then Account-menuye tikla
    And Sing in tikla
    And Username kismina "username",  Password kismina  "password" gir
    And Sing in butonuna tikla
    And ItemTitles kismina tikla
    And TestItem kismina tikla Test Items yazisisin gorunur oldugunu dogrula

  @US17TC01
  Scenario:Admin yeni test ogeleri olusturabilir
    And Create a new Test Item butonuna tikla Create or edit a Test Item yazisinin gorunur oldugunu test et
    And Name Description Price Default Min Value Default Max Value alanlarini doldur
    And Item Save Butonuna tikla
    And Son sayfa ogesine tikla
    And Olusturulan degerlerin Test Items sayfasinda gorunur oldugunu dogrula
    And Sayfayi kapat

  @US17TC02
  Scenario: Admin Name Description price Default min value Default max value ve created date olusturabilmeli
    And Create a new Test Item butonuna tikla Create or edit a Test Item yazisinin gorunur oldugunu test et
    And Name,Description,Price,Default Min. Value ,Default Max. Value Created Date alanlarini doldur
    And Item Save Butonuna tikla
    And Son sayfa ogesine tikla
    And Olusturulan tarihin girilen tarihle ayni oldugunu dogrula
    And Sayfayi kapat

  @US17TC03
  Scenario: Admin Name Description price Default min value Default max value ve created date guncelleyebilmeli
    And Son sayfa ogesine tiklaa
    And Son sayfanin ilk test item ogesi icin edit butonuna tikla
    And Edit icin Name,Description,Price,Default Min. Value ,Default Max. Value Created Date alanlarini doldur
    And Edit icin Save butonuna tikla
    And Ogelerin degistirildigini dogrula
    And Sayfayi kapat

  @US17TC04
    Scenario: Admin test ogelerini goruntuleyebilir.
    And Ucuncu Test Itemi icin View butonuna tikla
    And Test Itemin goruntulenebilir oldugunu dogrula
    And Bilgilerin goruntulenebilir oldugunu dogrula
    And Sayfayi kapat

  @US17TC05
    Scenario: Admin test ogelerini silebilir.
    And Create a new Test Item butonuna tikla Create or edit a Test Item yazisinin gorunur oldugunu test et
    And silmek icin Name Description Price Default Min Value Default Max Value alanlarini doldur
    And Item Save Butonuna tikla
    And Son sayfa ogesine tikla
    And silinecek oge icin delete butonuna tiklar
    And ikinci delete butonuna tiklar
    And ItemTitles kismina tikla
    And TestItem kismina tikla Test Items yazisisin gorunur oldugunu dogrula
    And Son sayfa ogesine tikla
    And olusturulan ogelerin silingi dogrulayin
    And Sayfayi kapat