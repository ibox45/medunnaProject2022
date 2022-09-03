@UserPassword
Feature: User giriş yaptığında Password sekmesi düzenlenebilir olmalıdır

  Scenario Outline: User rolüyle şifre değiştirebilmelidir (Pozitif Seneryo)
    Given medunnaUrl sayfasina git
    When hesap menusune tikla
    Then birinci sign in butonuna tikla
    And Username kismina "<username>", Password kismina "<password>" gir
    And ikinci sign in butonuna tikla
    Then user giris yapildigini dogrula
    And login hesap menusune tıkla
    And password butonuna tıkla
    And şifre değiştirme sayfasına geldiğini doğrula
    And Current password textboxına "<password>" yazar
    And New password textboxına "<yeniSifre>" yazar
    And New password confirmation textboxına "<yeniSifre>" yazar
    And Kaydet butonuna tıklar
    And Password changed! başarı yazısının geldiğini doğrular
    Examples:
      | username    | password         | yeniSifre |
      | user_team57 | ortakKullan.2022 | güneşSen  |


  Scenario: User rolüyle şifre değiştirebilmelidir (Negatif Seneryo)
    Given Kullanıcı New password confirmation textboxını temizler
    When New password confirmation textboxına new password'den farklı bir şifre yazar
    And The password and its confirmation do not match! uyarısını görmelidir


  Scenario Outline: User rolüyle Şifreye 1 küçük harf ekleyerek Password strength seviyesinin değiştiği doğrulanmalıdır
    Given New password textboxını temizler
    When New password textbaxına "<password>" sifresini gönderir
    And  Password strength' in bir diş olduğunu doğrular
    And New password textbaxına "<add_character>" ekler
    And Password strength' in iki diş olduğunu doğrular
    Examples:
      | password | add_character |
      | 1234567  | c             |


  Scenario Outline: User rolüyle Şifreye 1 büyük harf ekleyerek Password strength seviyesinin değiştiği doğrulanmalıdır
    Given New password textboxını temizler
    When New password textbaxına "<password>" sifresini gönderir
    And  Password strength' in bir diş olduğunu doğrular
    And New password textbaxına "<add_character>" ekler
    And Password strength' in iki diş olduğunu doğrular
    Examples:
      | password | add_character |
      | 1234567  | C             |


  Scenario Outline: User rolüyle Şifreye 1 rakam ekleyerek Password strength seviyesinin değiştiği doğrulanmalıdır
    Given New password textboxını temizler
    When New password textbaxına "<password>" sifresini gönderir
    And  Password strength' in iki diş olduğunu doğrular
    And New password textbaxına "<add_character>" ekler
    And Password strength' in dört diş olduğunu doğrular
    Examples:
      | password | add_character |
      | gjhtABC  | 8             |


  Scenario Outline: User rolüyle Şifreye 1 özel karakter ekleyerek Password strength seviyesinin değiştiği doğrulanmalıdır
    Given New password textboxını temizler
    When New password textbaxına "<password>" sifresini gönderir
    And  Password strength' in dört diş olduğunu doğrular
    And New password textbaxına "<add_character>" ekler
    And Password strength' in beş diş olduğunu doğrular
    Examples:
      | password | add_character |
      | Zqwe9988 | ?             |


  Scenario Outline: User 10 adet türkçe'ye özgü karakter girdiğinde Password strength seviyesinin değiştiğini doğrular
    Given New password textboxını temizler
    When New password textbaxına "<password>" sifresini gönderir
    And  Password strength' in bir diş olduğunu doğrular
    Given New password textboxını temizler
    When New password textbaxına "<turkcePassword>" sifresini gönderir
    And  Password strength' in bir üç olduğunu doğrular
    Examples:
      | password   | turkcePassword |
      | aaaaaaaaaa | çççççççççç     |


  Scenario Outline: User olarak Password strength seviyesinin değişmesi için en az 7 karakter kullanılmalıdır (Negatif Senaryo)
    Given New password textboxını temizler
    When New password textbaxına "<password>" sifresini gönderir
    And  Password strength' in bir diş olduğunu doğrular
    Examples:
      | password |
      | a4Z.     |
      | 13Ob.    |
      | ah7?WL   |

  Scenario Outline: User olarak Password strength seviyesinin değişmesi için en az 7 karakter kullanılmalıdır (Pozitif Senaryo)
    Given New password textboxını temizler
    When New password textbaxına "<password>" sifresini gönderir
    And  Password strength' in bir diş olduğunu doğrular
    And New password textbaxına "<add_character>" ekler
    And Password strength' in iki diş olduğunu doğrular
    Examples:
      | password | add_character |
      | 123456   | ?             |


  Scenario Outline: User olarak Eski şifre yeni şifre olarak kayıt edilememelidir
    Given Current password textboxını temizler
    Given New password textboxını temizler
    Given New password confirmation textboxını temizler
    And Current password textboxına "<mevcutSifre>" yazar
    And New password textboxına "<mevcutSifre>" yazar
    And New password confirmation textboxına "<mevcutSifre>" yazar
    And Kaydet butonuna tıklar
    And Password not changed! hata yazısının geldiğini doğrular
    Examples:
      | mevcutSifre |
      | güneşSen    |


  Scenario Outline: User olarak kodun yeniden calisirken hata vermemesi icin sifreyi degistirme
    Given New password textboxını temizler
    Given New password confirmation textboxını temizler
    And New password textboxına "<eskiSifre>" yazar
    And New password confirmation textboxına "<eskiSifre>" yazar
    And Kaydet butonuna tıklar
    And Password changed! başarı yazısının geldiğini doğrular
    And Sayfayı kapatır
    Examples:
      | eskiSifre        |
      | ortakKullan.2022 |