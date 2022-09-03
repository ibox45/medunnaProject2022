Feature: My Appointments by Patient in the account  (Hasta Randevulari)

  Scenario:Patient can make a new appointment using their protal.(Hasta portali kullanarak yeni randevu alabilir
    Given Hasta Medunna Url'e gider.
    Then Hasta sag uste bulunan account-menu 'yu tıklar.
    Then YH Hasta Sign in butonuna tıklar ve giriş yapar
    And YH Hasta My Pages butonuna tıklar.
    And YH Hasta Make an Appointments butonuna tıklar.
    And YH Hasta " First name,lastname,SSN,email,Phone,A.DateTime " bilgilerini girer.
    And YH Hasta gecerli tarih girmelidir.
    And YH Hastanın girdigi tarihin sırası gün,ay,yıl şeklinde olmalıdır.
    And kullanici 1 sn bekler
    And YH Hasta Send an Appointment Request butonuna tıklar.
    And sayfayi kapatir

  Scenario:Pozitif Test (Hastalar (patients), hastahaneden randevu (Appointment) oluşturabilmelidir.)
  Hastalar randevu tarihi oluşturabilmelidir.
    Given Kullanıcı Medunna Url'e gider.
    Then Kullanıcı anasayfadaki Make an Appointment butonuna tıklar.
    And kullanici 2 sn bekler
    And Kullanıcı " First name,lastname,SSN,email,Phone,A.DateTime " bilgilerini girer.
    And kullanici 2 sn bekler
    And Kullanıcı Send an Appointment Request butonuna tıklar.
    And kullanici 2 sn bekler
    #Then Kullanıcı Medunna Url'e gider.
    And  Kullanıcı sag uste bulunan account-menu 'yu tıklar.
    And Kullanıcı Sign butonunu tıklar ve giris yapar.
    And KullanıcıMy Pages butonuna tıklar.
    And Kullanıcı My Appointments butonuna tıklar.
    And Kullanıcı randevusunun olustugunu gorur.
    And kullanici 2 sn bekler
    And sayfayi kapatir


  Scenario:Negatif Test ((Hastalar (patients), hastahaneden randevu (Appointment) oluşturabilmelidir.)
  Hastalar randevu tarihi oluşturabilmelidir.)
    Given Kullanıcı Medunna Url'e gider.
    Then Kullanıcı anasayfadaki Make an Appointment butonuna tıklar.
    And kullanici 1 sn bekler
    And Kullanıcı Firstname , lastname , SSN ,Phone  bos bırakamaz
    And kullanici 1 sn bekler
    And Kullanıcı Send an Appointment Request butonuna tıklar.
    And sayfayi kapatir













