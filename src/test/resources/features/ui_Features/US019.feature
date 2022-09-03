@allofthem
Feature:  US019 Admin olarak; Yeni Staff (Personel) Oluşturma / Güncelleme / Görüntüleme ve Silme yapılabilir.

  @us019tc01
  Scenario:  US019 TC01  Admin SSN kullanarak; kayıtlı kişiler arasında Staff arayabilir

    Given kullanıcı medunna sayfasına gider
    And kullanıcı, kullanıcı logosuna tıklar
    Then  kullanıcı sign in butonuna tıklar
    And kullanıcı (admin) username, password girer ve giriş yapar
    Then kullanıcı items & titles butonuna tıklar ve staff'ı seçer
    And kullanıcı create a new staff butonuna tıklar
    Then kullanıcı kayıtlı staff'ın ssn numarasını girer
    And kullanıcı önce use search butonuna sonra search user butonuna tıklar
    Then kullanıcı staff'ı görüntüler
    And kullanıcı sayfayı kapatır

  @us019tc02
  Scenario:  US019 TC02  Admin SSN kullanarak; kayıtlı kişiler arasında Staff arayabilir

    Given kullanıcı medunna sayfasına gider
    And kullanıcı, kullanıcı logosuna tıklar
    Then  kullanıcı sign in butonuna tıklar
    And kullanıcı (admin) username, password girer ve giriş yapar
    Then kullanıcı items & titles butonuna tıklar ve staff'ı seçer
    And kullanıcı create a new staff butonuna tıklar
    Then kullanıcı kayıtlı staff'ın ssn numarasını girer
    And kullanıcı önce use search butonuna sonra search user butonuna tıklar
    Then kullanıcı staff'ın tüm bilgilerini görüntüler
    And kullanıcı sayfayı kapatır



  @us019tc03
  Scenario:  US019 TC03  Admin SSN kullanarak; kayıtlı kişiler arasında Staff arayabilir

    Given kullanıcı medunna sayfasına gider
    And kullanıcı, kullanıcı logosuna tıklar
    Then  kullanıcı sign in butonuna tıklar
    And kullanıcı (admin) username, password girer ve giriş yapar
    Then kullanıcı items & titles butonuna tıklar ve staff'ı seçer
    Then kullanıcı stafflardan birini idye tıklayarak seçer
    And kullanıcı sayfayı kapatır


  @us019tc04
  Scenario:  US019 TC04  Admin SSN kullanarak; kayıtlı kişiler arasında Staff arayabilir

    Given kullanıcı medunna sayfasına gider
    And kullanıcı, kullanıcı logosuna tıklar
    Then  kullanıcı sign in butonuna tıklar
    And kullanıcı (admin) username, password girer ve giriş yapar
    Then kullanıcı items & titles butonuna tıklar ve staff'ı seçer
    Then kullanıcı stafflardan birinin edit butonuna tıklar ve düzenler
    And kullanıcı sayfayı kapatır



  @us019tc05
  Scenario:  US019 TC05  Admin SSN kullanarak; kayıtlı kişiler arasında Staff arayabilir

    Given kullanıcı medunna sayfasına gider
    And kullanıcı, kullanıcı logosuna tıklar
    Then  kullanıcı sign in butonuna tıklar
    And kullanıcı (admin) username, password girer ve giriş yapar
    Then kullanıcı items & titles butonuna tıklar ve staff'ı seçer
    Then kullanıcı stafflardan birinin delete butonuna tıklar ve siler
    And kullanıcı sayfayı kapatır






