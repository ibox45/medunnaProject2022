Feature: US_018

  Background:
    Given Kullanici "medunnaUrl" adresine gider
    Then Ana sayfada oldunduğu "WELCOME TO MEDUNNA" texti ile dogrulanir
    And Kullanici giris icin CONTACT tuşunun yanındaki kullanici giris butonuna tiklar
    And Admin acilan DDM menuden Sign In e tiklar
    And Admin kendi "userName" ve "password" girip Sign in butonuna tiklar
    And Admin sag ust kosede kendi adini gorerek basariyla giris yaptigini  gorur
    And Admin items&Titles menusu gorur
    And Admin items&Titles menusune tiklar
    And Admin acilan DDM'den Physician'a tiklar

  Scenario: TC_001 Admin, bütün doktorların bilgilerini görebilmelidir.

    And Admin edit'e  tiklar
    And Admin butun doktorlarin bilgilerini gorur
    And Admin tarayiciyi kapatir

  Scenario: TC_002 Admin, SSN kimliğine göre kayıtlı bir kişiyi seçebilir/arayabilir.
    And Admin Create a new Physician'a tiklar
    And Admin SSN Box'a kayitli bir kisinin SSN'nini girer
    And Admin Search User butonuna tiklar
    And Admin Use Search butonuna click yapar.
    And Admin sol ust kosede User found with search SSN popup'ini gorur
    And Admin sayfayi kapatir.

  Scenario: TC_003 Admin EDİT butonu üzerinden doktorların bilgilerini düzenleyebilir.(firstname, lastname, birthdate, specialty, profil fotoğrafı, exam fee,doktor seçme)
    And Admin edit'e  tiklar
    And Admin First Name alanina isim girer.
    And Admin Last Name alanina soyisim girer
    And Admin Birth Date alanindan dogum tarihi secer
    And Admin Phone alanina telefon bilgisi girer
    And Admin address alanina adres bilgisi girer.
    And Admin Gender alanina cinsiyet girer.
    And Admin Speciality alanina uzmanlik alani girer.
    And Admin Blood Group alanina kan grubu girer.
    And Admin Description alanina veri girer.
    And Admin Image alanından Dosya Seç'e basarak bir fotoğraf yükler.
    And Admin  Exam Fee alanina doktor ucreti girer.
    And Admin User alanindan kullanici secer.
    And Admin Country alanindan ulke secer.
    And Admin "city" alanindan sehir secer.
    And Admin Save butonuna tiklar.
    And Admin A Physician is updated mesajini goruntuler.
    And Admin tarayiciyi kapatir

  Scenario:TC_004 Admin mevcut dokorları silebilir.
    And Admin acilan sayfanın altındaki sayfa numalari yazisini gorutuleyerek doktorlar listesine gittigini dogrular
    And Admin silmek istedigi doktorun yanindaki "Delete" butonuna tiklar
    And Admin doktoru silindigine dair bir pop-up uyarisi alir
    And Admin tarayiciyi kapatir


