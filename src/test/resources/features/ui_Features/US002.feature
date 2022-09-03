Feature: US002 Kayit olmak için email and username bilgileri girilebilmelidir.


  Background: Ortak Adim
    Given kullanici "medunnaUrl" anasayfasina gider
    Then Account Menu simgesine tiklar
    And Register butonuna tiklar

  Scenario Outline: TC01 Gecerli bir username girilebilmeli

    And Username kutusuna gecerli bir "<username>" girer
    And Username kutusunun altinda Your username is invalid yazisinin gorunmedigini test eder
    And kullanici sayfayi kapatir
    Examples:
      | username |
      |team_57   |
      |ibox45    |


  Scenario Outline: TC02 Gecersiz bir username girilememeli

    And Username kutusuna gecersiz bir "<username>" girer
    And Username kutusunun altinda Your username is invalid yazisinin gorundugunu test eder
    And kullanici sayfayi kapatir
    Examples:
      | username |
      |team 57   |
      |ibra him  |


  Scenario: TC03 Username kutusu bos birakilamamali

    And Username kutusunu bos birakir
    And Username kutusunun altinda Your username is required yazisinin gorundugunu test eder
    And kullanici sayfayi kapatir

  Scenario Outline: TC04 Gecerli bir e-mail adresi girilebilmeli

    And E-mail kutusuna gecerli bir "<email>" girer
    And E-mail kutusunun altinda This field is invalid yazisinin gorunmedigini test eder
    And kullanici sayfayi kapatir
    Examples:
      | email |
      |team_57@medunna.com|


  Scenario Outline: TC05 Gecersiz bir e-mail girilememeli

    And E-mail kutusuna gecersiz bir "<email>" girer
    And E-mail kutusunun altinda This field is invalid yazisinin gorundugunu test eder
    And kullanici sayfayi kapatir

    Examples:
      | email |
      |team_57meduna.com|
      |team_57@medunacom|
      |team_57medunacom |

  Scenario: TC06 E-mail kutusu bos birakilamamali

    And E-mail kutusunu bos birakir
    And E-mail kutusunun altinda Your email is required yazisinin gorundugunu test eder
    And kullanici sayfayi kapatir