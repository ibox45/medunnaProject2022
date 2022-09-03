Feature: US019 Admin olarak; Yeni Staff (Personel) Oluşturma / Güncelleme / Görüntüleme ve Silme yapılabilir.

@us019api
Scenario Outline: US019 API Admin API ile Staff bilgilerini Görüntüleme

  Given admin medunna "<staff>" endpointini olusturur
  And admin "<staff>" bilgileri  icin Get request gonderir ve response alir
  And admin Status Code 200 oldugunu dogrular
  And admin gelen json staff bilgilerini javaya donusturur
  And admin API ile gelen bilgilerin "<staff>" olduğunu goruntuler



  Examples:
  |staff|
  |212093|