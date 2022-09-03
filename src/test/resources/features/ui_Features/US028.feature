  @US_028
  Feature:US_028 Admin olarak; Country oluşturma / Okuma ve Silme

    Background:Ortak Adımlar
      Given Admin "medunnaUrl" sayfasına gider
      When Kullanıcı User ikonuna tıklar
      And Kullanıcı sign in butonuna tıklar
      And Kullanıcı gecerli admin_Username ve password bilgilerini girer
      And İkinci Sign in butonuna tıklar
      Then Kullanici Items&Titles dropdown menüsüne tıklar

    Scenario:TC_01 Admin olarak; Country oluşturma ve okuma
      And Açılan pencereden Country sekmesine tıklar
      And Acılan sayfada Create a new Country butonuna tıklar
      And Name textbox ına tıklayıp ülke ismi girer
      And Created textbox ına tıklayıp tarih ve saat bilgisi girer
      And Save butonuna tıklar
      And Kayıt yapıldı yazısının göründüğünü test eder
      And Kullanici sayfayi kapatir

    Scenario:TC_03 Admin olarak olusturulan Country i silme
      And Açılan pencereden Country sekmesine tıklar
      And Kayıtlı Country e gelip Delete butonuna tıklar
      And Açılan penceredeki Delete butonuna tıklar
      And Country silindi yazısının göründüğünü test eder
      And Kullanici sayfayi kapatir

    Scenario:TC_02 Kullanıcı, Countrye göre ilgili State/City oluşturma
      And Açılan pencereden StateCity sekmesine tıklar
      And Acılan sayfada Create a new StateCity butonuna tıklar
      And Name textbox ına tıklayıp city ismi girer
      And Created textbox ına tıklayıp city icin tarih ve saat bilgisi girer
      And City için Save butonuna tıklar
      And City icin Kayıt yapılamadı yazısının göründüğünü test eder
      And Kullanici sayfayi kapatir




