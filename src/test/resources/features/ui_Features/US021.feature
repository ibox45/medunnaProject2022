Feature: US021 Staff hastalar icin randevulari gorur

  Scenario: TC001 Staff randevulari guncelleyebilir

    Given kullanici "medunnaUrl" anasayfasina gider
    Then Account Menu simgesine tiklar
    And birinci sign in butonuna tikla
    And username kutusuna "patientUsername" girer
    And password kutusuna "password" girer
    And ikinci sign in butonuna tikla
    When Kullanici acilan sayfadaki MY PAGES(PATIENT) bolumune gelir
    And Make an Appointment'i tiklar
    And Kullanici gecerli Phone numarasini girer
    And Send an Appointment Request'e tiklanir
    And kullanici 2 sn bekler
    Then Account Menu simgesine tiklar
    And kullanici 2 sn bekler
    And Sign out butonuna tiklar
    And kullanici 2 sn bekler
    Then Account Menu simgesine tiklar
    And kullanici 2 sn bekler
    And birinci sign in butonuna tikla
    And username kutusuna "staffUsername" girer
    And password kutusuna "password" girer
    And ikinci sign in butonuna tikla
    And Personel My Pages dropdown menüsüne tıklar
    And kullanici 2 sn bekler
    And Açılan pencereden Search Patient sekmesine tıklar
    And Patient SSN kutusuna "patientSSNNo" gir
    And kullanici 5 sn bekler
    And Show Appointments butonuna tiklar
    And kullanici 5 sn bekler
    And Staff Edit butonuna tiklar
    And kullanici 2 sn bekler
    And Description kutusuna randevu guncellendi yazar
    And Save butonuna tiklar
    And Randevunun guncellendigini gosteren uyari mesajinin gorundugunu testeder
    And kullanici 2 sn bekler
    And kullanici sayfayi kapatir

  Scenario: TC002 Staff hasta durumunu (status) "UNAPPROVED, PENDING veya CANCELLED" yapabilmeli ancak "COMPLETED" yapamamali.

    Given kullanici "medunnaUrl" anasayfasina gider
    Then Account Menu simgesine tiklar
    And birinci sign in butonuna tikla
    And username kutusuna "staffUsername" girer
    And password kutusuna "password" girer
    And ikinci sign in butonuna tikla
    And Personel My Pages dropdown menüsüne tıklar
    And kullanici 2 sn bekler
    And Açılan pencereden Search Patient sekmesine tıklar
    And Patient SSN kutusuna "patientSSNNo" gir
    And kullanici 5 sn bekler
    And Show Appointments butonuna tiklar
    And kullanici 5 sn bekler
    And Staff Edit butonuna tiklar
    And kullanici 2 sn bekler
    And Status Dropdown Menusunde UNAPPROVED yazisinin tiklanabilir oldugunu test eder
    And Status Dropdown Menusunde PENDING yazisinin tiklanabilir oldugunu test eder
    And Status Dropdown Menusunde CANCELLED yazisinin tiklanabilir oldugunu test eder
    And Status Dropdown Menusunde COMPLETED yazisinin tiklanamaz oldugunu test eder
    And kullanici sayfayi kapatir

    @US021_TC003
  Scenario: TC003  Staff "Anamnesis (Hastalık Geçmişi)" kısmına data girememeli.

    Given kullanici "medunnaUrl" anasayfasina gider
    Then Account Menu simgesine tiklar
    And birinci sign in butonuna tikla
    And username kutusuna "staffUsername" girer
    And password kutusuna "password" girer
    And ikinci sign in butonuna tikla
    And Personel My Pages dropdown menüsüne tıklar
    And kullanici 2 sn bekler
    And Açılan pencereden Search Patient sekmesine tıklar
    And Patient SSN kutusuna "patientSSNNo" gir
    And kullanici 5 sn bekler
    And Show Appointments butonuna tiklar
    And kullanici 5 sn bekler
    And Staff Edit butonuna tiklar
    And kullanici 2 sn bekler
    And Anamnesis kutusuna data girilemedigini test eder
    And kullanici sayfayi kapatir

  @US021_TC004
  Scenario: TC004 Staff "Treatment ( Tedavi)"  kısmına data girememeli.

    Given kullanici "medunnaUrl" anasayfasina gider
    Then Account Menu simgesine tiklar
    And birinci sign in butonuna tikla
    And username kutusuna "staffUsername" girer
    And password kutusuna "password" girer
    And ikinci sign in butonuna tikla
    And Personel My Pages dropdown menüsüne tıklar
    And kullanici 2 sn bekler
    And Açılan pencereden Search Patient sekmesine tıklar
    And Patient SSN kutusuna "patientSSNNo" gir
    And kullanici 5 sn bekler
    And Show Appointments butonuna tiklar
    And kullanici 5 sn bekler
    And Staff Edit butonuna tiklar
    And kullanici 2 sn bekler
    And Treatment kutusuna data girilemedigini test eder

  @US021_TC005
  Scenario: TC005 Staff "Diagnosis(Teşhis)" kısmına data girememeli.

    Given kullanici "medunnaUrl" anasayfasina gider
    Then Account Menu simgesine tiklar
    And birinci sign in butonuna tikla
    And username kutusuna "staffUsername" girer
    And password kutusuna "password" girer
    And ikinci sign in butonuna tikla
    And Personel My Pages dropdown menüsüne tıklar
    And kullanici 2 sn bekler
    And Açılan pencereden Search Patient sekmesine tıklar
    And Patient SSN kutusuna "patientSSNNo" gir
    And kullanici 5 sn bekler
    And Show Appointments butonuna tiklar
    And kullanici 5 sn bekler
    And Staff Edit butonuna tiklar
    And kullanici 2 sn bekler
    And Diagnosis kutusuna data girilemedigini test eder





  Scenario: TC006  Hasta icin gerekli doktoru secebilmeli ve randevuyu olusturmali.

    Given kullanici "medunnaUrl" anasayfasina gider
    Then Account Menu simgesine tiklar
    And birinci sign in butonuna tikla
    And username kutusuna "staffUsername" girer
    And password kutusuna "password" girer
    And ikinci sign in butonuna tikla
    And Personel My Pages dropdown menüsüne tıklar
    And kullanici 2 sn bekler
    And Açılan pencereden Search Patient sekmesine tıklar
    And Patient SSN kutusuna "patientSSNNo" gir
    And kullanici 5 sn bekler
    And Show Appointments butonuna tiklar
    And kullanici 5 sn bekler
    And Staff Edit butonuna tiklar
    And kullanici 2 sn bekler
    And Staff doktoru secer
    And Save butonuna tiklar
    And Randevunun guncellendigini gosteren uyari mesajinin gorundugunu testeder
    And kullanici sayfayi kapatir



















