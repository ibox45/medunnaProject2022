@US_009_Ui
Feature: US_009 Staff (Personel), hasta bilgilerini görebilmeli, düzenleyebilmeli ve silememelidir

  Scenario: TC_001 Staff (Personel), hasta bilgilerini görebilmeli
    Given Kullanıcı "medunnaUrl" sayfasına gider
    When Kullanıcı User ikonuna tıklar
    And Kullanıcı 1 saniye bekler
    Then Kullanıcı Sign in butonuna tıklar
    And Kullanıcı 1 saniye bekler
    And  Kullanıcı gecerli personelUsername ve personelPassword bilgilerini girer, Sign in butonuna tıklar
    And Kullanıcı 1 saniye bekler
    And Personel My Pages dropdown menüsüne tıklar
    And Kullanıcı 1 saniye bekler
    And Açılan pencereden Search Patient sekmesine tıklar
    And Patient SSN texboxa tıklar, "personelSSNNo" girer
    And View butonuna tıklar, hasta bilgilerini görür
    And Kullanıcı 1 saniye bekler
    And Sayfayı aşağıya kaydırır, edit butonuna tıklar

  Scenario Outline: TC_001 Staff (Personel), düzenleyebilmeli
    And Personel bütün hasta bilgilerini "<firstname>", "<lastname>", "<birthdate>", "<email>", "<phone>", "<gender>", "<bloodgroup>", "<address>", "<description>", "<user>", "<country>" and "<statecity>" düzenler
    And Save butonuna tıklar, hasta kayıt bilgilerinin düzenlendiğini görür

    Examples:
      | firstname | lastname |    birthdate     |            email          |   phone    | gender | bloodgroup |           address             | description |    user    | country| statecity |
      | Zehra     | Duru     | 21.03.2005 09:00 | zehraakgumus484@gmail.com | 5070070690 |  MALE  |     A+     | Pembe Panter mah. Tweety sok. |    sistit   | yang.wyman | Türkye |   Adana    |


  Scenario:TC_002 Staff (Personel), hasta bilgilerini silebilmeli
    Given Personel My Pages dropdown menüsüne tıklar
    And Kullanıcı 1 saniye bekler
    Then Açılan pencereden Search Patient sekmesine tıklar
    And Patient SSN texboxa tıklar, "personelSSNNo" girer
    And View butonuna tıklar, hasta bilgilerini görür
    And Kullanıcı 1 saniye bekler
    And Sayfayı aşağıya kaydırır, edit butonuna tıklar
    And Herhangi bir hasta bilgisini siler

  Scenario: TC_003  Staff (Personel), hastayı silememelidir.
    Given Personel My Pages dropdown menüsüne tıklar
    And Kullanıcı 1 saniye bekler
    Then Açılan pencereden Search Patient sekmesine tıklar
    And Patient SSN texboxa tıklar, "personelSSNNo" girer
    And View butonuna tıklar, hasta bilgilerini görür
    And Kullanıcı 1 saniye bekler
    And Sayfayı aşağıya kaydırır, edit butonuna tıklar
    And Hasta ID bilgisini silemediğini doğrular
