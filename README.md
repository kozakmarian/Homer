# Homer

Častokrát sa potýkame s jednoduchými otázkami ako napr. čo bude na večeru, alebo či sme v obchode kúpili všetko čo sme mali a pod. Tieto problémy riešime To-Do listami, paperikmi, SMS-kami. Kiež by existovala platforma pre komplexné riešenie praktických problémov každodenného života. Veru že existuje *(alebo skôr bude existovať)*.

Predstavujeme ** Homer** -- modulárny systém pre správu domácností. Homer má *(v základnej verzii)* na starosti všetko od obsahu chladničky a špajze *(vrátane evidencie trvanlivosti potravín)*, cez vyhľadávanie receptov, až po zostavovanie nákupných zoznamov. Jedná sa o otvorenú platformu postavenú na jednoduchosti pre užívateľov a rozšíriteľnosti pre vývojárov.

Členovia tímu: Veronika Piková a Michal Pavúk

Aplikácia bude bežať na desktopoch na pozadí (daemon), pričom po rozkliknutí, sa užívateľovi zobrazí Swing rozhranie pre správu artiklov, receptov a zoznamov. Hlavný dôvod behu na pozadí je periodická kontrola stavu artiklov.

Dáta budú uložené v MySQL databáze, konfigurácia pomocou XML, logy v textovej podobe. Funkcionalita Homeru je delená do **modulov**. Každý modul je samostatná manažovateľná funkčná jednotka operujúca nad vlastnou sadou tabuliek v databáze, s prístupom k spoločným entitám a metódam špecifickými pre moduly. Cieľom modulov je poskytnýť vyššie spomínanú rozšíriteľnosť.

Popis entít *(zatiaľ len priebežný/môže sa zmeniť)*:
 - **Modul** - predstavuje súhrn informácií o Homer module
  - id
  - názov
  - prefix - pre identifikáciu tabuliek v DB, ktoré patria modulu
  - verzia - pre prípadné zmeny v tabuľkách modulu a kontrolu aktualizácií
  - dátum inštalácie
  - stav - nenainštalovaný/neaktívny/aktívny
 - **Artikel** - predstavuje konkrétny produkt *(napr. potravinu)*
  - id
  - názov
  - EAN - pre prípadné neskoršie "párovanie" s produktami obchoných reťazcov
  - dátum trvanlivosti/relevantnosti
  - stav - chýba/v zásobe/po dátume spotreby/...
  - množstvo
  - merná jednotka
 - **Recept**
  - id
  - názov
  - popis
  - ingrediencie
  - postup
  - url - ak je recept stiahnutý z internetu
  - stav - napr. v obľubených, alebo chybný recept
 - **Zoznam** - nákupný zoznam, skladá sa z položiek
  - id
  - názov
  - zoznam položiek *(pozri nižšie)*
  - dátum vytvorenia
  - stav - nakúpený/nenakúpený/nekompletný
 - **Položka** - jedna položka nákupného zoznamu
  - id
  - id artiklu
  - mnnožstvo
  - merná jednotka
  - stav - kúpený/nekúpený/...
 - **Notifikácia** - v databáze budú uložené uplynulé aj nadchádzajúce udalosti
  - id
  - dátum a čas - kedy sa má zobraziť notifikácia/resp. bola zobrazená
  - stav - zobrazená/nezobrazená

Ako bolo vyššie spomenuté cieľom projektu nie je ponúknuť čo najväčšie množstvo funkcionality, ale vytvoriť solídny základ pre vývoj prepojených riešení pre domácnosti. Domnievame sa, že najmä so súčasným rozvojom IoT a Smart Home automatizáciou vzniká potreba jednotného systému pre manažment potravín. Java je pre úlohu takéhoto charakteru vhodná nakoľko má veľmi dobrú podporu naprieč zariadeniami. To sa budeme pri vývoji pridŕžať a použijeme JDK 1.7 *(aj napriek ukončenia podpory pre túto verziu od spoločnosti Oracle)*.

Pokiaľ to časové dôvody budú umožnovať, radi by sme do aplikácie zakomponovali aj funkcionalitu veľmi jednoduchého webového serveru, ktorý by poskytoval CRUD funkcionalitu. Najmä z dôvodu integrácie s inými službami.