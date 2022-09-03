Feature: US001 Kayit olmak icin SSN, Firstname ve Lastname bilgileri girilebilmelidir

  Background: Ortak Adim
    Given kullanici "medunnaUrl" anasayfasina gider
    Then Account Menu simgesine tiklar
    And Register butonuna tiklar

  Scenario Outline: TC01 Kullanici "gecerli bir SSN" girebilmeli

    And SSN kutusuna gecerli bir "<ssn>" girer
    And SSN kutusunun altinda Your SSN is invalid yazisinin gorunmedigini test eder
    And kullanici sayfayi kapatir

    Examples:
      |ssn|
      |123-12-1234|

  Scenario Outline: TC02 Kullanıcı "geçersiz bir SSN" girememeli

    And SSN kutusuna gecersiz bir "<ssn>" girer
    And SSN kutusunun altinda Your SSN is invalid yazisinin gorundugunu test eder
    And kullanici sayfayi kapatir

    Examples:
      |ssn  |
      |000-00-0000|
      |666-12-1234|
      |912-12-1234|
      |000-12-1234|
      |123-00-1234|
      |123-12-0000|
      |123456789  |
      |A12@5789   |
      |123-12-12345|


  Scenario: TC03 SSN kutusu bos birakilamamali

    And SSN kutusunu bos birakir
    And SSN kutusunun altinda Your SSN is required yazisinin gorundugunu test eder
    And kullanici sayfayi kapatir

  Scenario Outline: TC04 Gecerli bir firstname girilebilmeli

    And First Name kutusuna gecerli bir "<firstname>" girer
    And First Name kutusunun altinda Your FirstName is required yazisinin gorunmedigini test eder
    And kullanici sayfayi kapatir


    Examples:
      | firstname |
      |b          |
      |5          |
      |?          |
      |isim       |
      |team_57    |

  Scenario: TC05 First Name kutusu bos birakilamamali

    And First Name kutusunu bos birakir
    And First Name kutusunun altinda Your FirstName is required yazisinin gorundugunu test eder
    And kullanici sayfayi kapatir

  Scenario Outline: TC06 Gecerli bir lastname girilebilmeli
    And Last Name kutusuna gecerli bir "<lastname>" girer
    And Last Name kutusunun altinda Your LastName is required yazisinin gorunmedigini test eder
    And kullanici sayfayi kapatir

    Examples:
      |lastname|
      |l       |
      |2       |
      |*       |
      |lastname|
      |team_57 |

  Scenario: TC07 Last Name kutusu bos birakilamamali

    And Last Name kutusunu bos birakir
    And Last Name kutusunun altinda Your LastName is required yazisinin gorundugunu test eder
    And kullanici sayfayi kapatir