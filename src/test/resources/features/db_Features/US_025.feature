Feature: DB ile randevu dogrulama

  Scenario:Kullanıcı DB ile randevularını dogrular
    Given Kullanici  db ye baglanir
    Then kullanici "appointment" table "id" satirindaki "240528" dogrular