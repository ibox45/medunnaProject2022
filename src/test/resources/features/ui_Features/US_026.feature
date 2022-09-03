Feature: İletişim Mesajı (Contact messages)

  Scenario:Herhangi bir kullanıcı, bilgi almak için "Contact portal" üzerinden istek gönderebilmeli ve
  "Name, Email, Subject, Message" bölümlerine data girebilmeli ve mesajını gönderebilmeli.
    Given Kullanıcı Medunna Url'e gider.
    Then Kullanıcı Anasayfada bulunan Contact butonuna tıklar.
    And Kullanıcı Name,Email,Subject,Message bilgilerini girer
    And Kullanıcı Send butonuna tıklar.
    And sayfayi kapatir

  Scenario:Kullanıcı "Name, Email, Subject, Message" bölümlerine data girebilmeli ve mesajını gönderebilmeli.

    Given Hasta Medunna Url'e gider.
    Then Hasta sag uste bulunan account-menu 'yu tıklar.
    Then Hasta Sign in butonuna tıklar ve giriş yapar
    And Hasta Contact butonuna tıklar.
    And Hasta Name,Email,Subject,Message bilgilerini girer
    And Hasta Send butonuna tıklar.





