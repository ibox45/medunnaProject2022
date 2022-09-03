Feature: US005 Hastalar (patients), hastahaneden randevu (Appointment) oluşturabilmelidir.


  @us005tc01  @all
  Scenario Outline: US005 TC001 Kullanıcının herhangi bir karakter içeren "First Name" yazması gerekir ve boş bırakılamaz

    Given kullanıcı "medunnaUrl" sayfasına gider
    And  kullanıcı anasayfadaki Make an Appointment butonuna tıklar
    Then kullanıcı bir "<FirstName>" yazar ve bu alanı boş bırakamaz
    And Your "<FirstName>" is required. yazısının olmadığı test edilir.
    Then kullanıcı sayfayı kapatır


    Examples:
      |FirstName|
      |arslan|



  @us005tc02  @all
  Scenario Outline: US005 TC002 Kullanıcı SSN numarası girer  (kayıtlı SSN) ve bu kısım boş bırakılamaz.

    Given kullanıcı "medunnaUrl" sayfasına gider
    And  kullanıcı anasayfadaki Make an Appointment butonuna tıklar
    Then kullanıcı kayıtlı "<SSN>" yazar ve bu alanı boş bırakamaz
    And Your SSN is invalid yazısının olmadığı test edilir.
    Then kullanıcı sayfayı kapatır


    Examples:
      |SSN|
      |646-12-1234|



  @us005tc03  @all
  Scenario Outline: US005 TC003 Kullanıcının herhangi bir karakter içeren "Last Name" yazması gerekir ve boş bırakılamaz

    Given kullanıcı "medunnaUrl" sayfasına gider
    And  kullanıcı anasayfadaki Make an Appointment butonuna tıklar
    Then kullanıcı LastName kısmına bir "<LastName>" yazar ve bu alanı boş bırakamaz
    And Last Name kısmının altında Your "<LastName>" is required. yazısının olmadığı  test edilir.
    Then kullanıcı sayfayı kapatır


    Examples:
      | LastName|
      |arslan|



  @us005tc04  @all
  Scenario Outline: US005 TC004 Kullanıcı "." ve "@" içeren e-mail adresi girmeli ve bualanı boş bırakamaz.

    Given kullanıcı "medunnaUrl" sayfasına gider
    And  kullanıcı anasayfadaki Make an Appointment butonuna tıklar
    Then kullanıcı email kısmına bir "<Email>" yazar ve bu alanı boş bırakamaz
    And Email kısmının altında Your "<Email>" is required. yazısının olmadığı  test edilir.
    Then kullanıcı sayfayı kapatır


    Examples:
      | Email|
      |alienesali11@outlook.com|



  @us005tc05  @all
  Scenario Outline: US005 TC005 Kullanıcı, 3. ve 6. rakamdan sonra "-" olan 10 rakamlı telefon numarasını girer ve bu alanı boş bırakamaz.

    Given kullanıcı "medunnaUrl" sayfasına gider
    And  kullanıcı anasayfadaki Make an Appointment butonuna tıklar
    Then kullanıcı telefon numarası kısmına bir 3. ve 6. rakamdan sonra "-" olan 10 rakamlı "<telefonnumarasi>" girer ve bu alanı boş bırakamaz
    And telefon numarasının altında Your "<telefonnumarasi>" is required. yazısının olmadığı  test edilir.
    And kullanıcı Send an Appointment Request butonuna tıklar
    Then kullanıcı sayfayı kapatır


    Examples:
      |telefonnumarasi|
      |564-273-9871|


  @us005tc06  @all
  Scenario Outline: US005 TC001 Kullanıcının herhangi bir karakter içeren "First Name" yazması gerekir ve boş bırakılamaz

    Given kullanıcı "medunnaUrl" sayfasına gider
    And  kullanıcı sayfanın sag ust kısmındaki kullanıcı logosuna tıklar
    Then  kullanıcı acilan menude Sign in butonuna tiklar
    And  kullanıcı username kısmına "<username>"  girer.
    Then  kullanıcı password kısmına "<password>" girer.
    And  kullanıcı sayfaya gidebilmek icin Sign in butonuna tıklar.
    Then  kullanıcı sayfanin sağ ust kismindaki My Pages butonuna tiklar.
    And kullanıcı My Appointments butonuna tıklar
    Then kullanıcı randevusunu oluşturduğunu görür
    And kullanıcı sayfayı kapatır


    Examples:
      |username|password|
      |arslan|Ae123456.|