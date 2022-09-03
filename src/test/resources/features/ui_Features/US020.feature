Feature: US020 Admin; "User management" menusunden, kullanici Active eder ve gerekli rolleri olusturur.

  Background: Ortak Adim
    Given kullanici "medunnaUrl" anasayfasina gider
    Then Account Menu simgesine tiklar
    And birinci sign in butonuna tikla
    And username kutusuna "adminUsername" girer
    And password kutusuna "password" girer
    And ikinci sign in butonuna tikla
    And administration butonuna tiklar
    And usermanagement butonuna tiklar

  Scenario: TC001 Admin, kayitli kisilerin "firstname, lastname, email..." gibi bilgilerini gorebilmeli.

    And Herhangi view butonuna tiklar
    And Kayitli kisilerin bilgilerinin gorundugunu test eder
    And kullanici sayfayi kapatir

  Scenario: TC002 Admin kullanicilari aktive edebilir
    And Herhangi Deactivated butonuna tiklar
    And Kullanicinin aktive edildigini gosteren uyari mesajinin gorundugunu test eder
    And kullanici sayfayi kapatir

  Scenario: TC003 Admin kullanicilarin rollerini "ADMIN, USER, PATIENT, STAFF, PHYSICIAN" olarak atayabilir

    And Herhangi bir kullanici icin edit butonuna tiklar
    And Herhangi bir kullanici rolu secer
    And Save butonuna tiklar
    And Guncelleme yapilabildigini gosteren uyari mesajinin gorundugunu test eder
    And kullanici sayfayi kapatir

  Scenario Outline: TC004 Admin kullanıcıları silebilir.

    And Create a new user butonuna tiklar
    And Login kutusuna "<username>" girer
    And Firstname kutusuna "<firstname>" girer
    And Lastname kutusuna "<lastname>" girer
    And Your Email kutusuna "<email>" girer
    And SSN kutusuna bir "<SSN>" girer
    And Save butonuna tiklar
    And kullanici 3 sn bekler
    And Modified date yazisina tiklar
    And Listedeki ilk delete butonuna tiklar
    And kullanici 1 sn bekler
    And Acilan onaylama metninde delete butonuna tiklar
    And Kullanicinin silindigini gosteren uyari mesajinin gorundugunu test eder
    And kullanici sayfayi kapatir

    Examples:
    |username|firstname|lastname|email|SSN|
    |silinecekhesap|silinecek|hesap|silinecek@medunna.com|876-54-3210|








