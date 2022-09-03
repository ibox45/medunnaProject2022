Feature: US019 Admin olarak; Yeni Staff (Personel) Oluşturma / Güncelleme / Görüntüleme ve Silme yapılabilir.

  @us019db 
  Scenario: US019 DB Admin DB ile staff bilgilerini dogrulamalı

    Given Admin database ile baglanti kurar
    * Admin query tanimlar
    * Admin staff ulasir ve kaydeder
    * Admin DB ile staff bilgilerini dogrular