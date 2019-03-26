# Vaatimusmäärittely

## Pelin idea
Pelin on tarkoitus olla yksinkertaistettu ylhäältä päin kuvattu 2D-versio Nintendon Pikmin-pelistä. Tarkoituksena ei ole olla suora kopio mistään sarjan pelistä, vaan kyseessä on erillinen peli joka käyttää sarjan tärkeimpiä pelimekaniikkoja ja lisää mukaan jotain omaakin. Jos pelisarja ei ole ennestään tuttu, suosittelen katsomaan jonkin aikaa [tätä gameplay-videota](https://www.youtube.com/watch?v=Avjo5OGyS2Q&t=983s) videota, pelin perusidean ymmärtämiseksi. Pelissä on tarkoittus hallinnoida näitä Pikmin-olioita pelaajahahmon kautta. Niitä voi käskeä keräämään kaikenlaisia esineitä takaisin avaruusalukselle ja taistelemaan vihollisia vastaan. Näiden ominaisuuksien toteuttaminen on tämän projektin keskiössä.

## Käyttäjät
Peliin ont tarkoitus lisätä myöhemmässä vaiheessa tarkoitus lisätä tiedosto, johon peli tallentaa pelin päivän lopussa edistymisen automaattisesti. Myös mahdollisuus useampaan tallennustiedostoon saatetaan lisätä. Kuitenkaan eroja käyttäjätyyppien välillä ei ole, jos debug-tilaa ei lasketa mukaan.


## Pelialueluonnos

Havainnollistus pelin kartasta debug-tilassa. Mustat nuolet kuvaavat esineen reittiä. Katso tarkempi selitys perusverison ominaisuuksista.

![Pelialueluonnos](https://github.com/JustAGoldeneye/ot-harjoitustyo/blob/master/Pikmin_2D/Documentation/Pikmin_2D_pelialuesuunnitelma.png "Pelialueluonnos")

(Sipulilla viitataan Pikminien avaruusalukseen, jota käytetään myös uusien Pikminien kasvattamiseen.)

## Perusversion ominaisuudet

* Yksinketainen path-finding -järjestelmä
  * Tarvitaan, jotta Pikminit voisivat tuoda esineitä takaisin avaruusalukselle ja sipulille.
  * Toeutetaan lisäämällä alueen karttaan näkymättömiä suorkulmioita, jollaiseen liikkuessaan esinettä kantava Pikmin-ryhmä alkaa seurata suorakulmioon määriteltyä suuntaa. Tarkoituksena on luoda näkymätön reittien verkosto, jota käyttämällä Pikminit löytävät aina perille alukseen tai sipuliin.
    * Jos Pikmnit eivät ole suorakulmion kohdalla, kävelevät ne suoraan alusta tai sipulia kohti.
    * Myös alkuperäinen Pikmin-peli käyttää hyvin samantapaista menetelmää.
    * Pikminien ei ikinä tarvitse liikkua seuraamatta pelaajaa muualle kuin alusta kohti, joten monimutkaisempaa path-finding -algoritmia ei tarvita.
* Ohjaus
  * Pelaaja voi käskeä Pikmineitä seuraamaan häntä kävelemällä niiden läheltä.
  * Pelaaja voi heittää Pikmineitä esineisiin
  * Kun esineellä on sen painoon nähden tarpeeksi Pikmineitä, kantavat Pikminit esineen takaisin avaruusalukseen tai sipuliin.
* Pikminien hallinta
  * Mahdollisuus kasvattaa uusia Pikmineitä kantamalla ravinnepellettejä ja viholliseten ruhoja takaisin
   * Mahdollisuus säilöä Pikminejä sipuliin.
  * Jokin rajoitus yhtä aikaa sipulista ulkona olevien Pikminien määrälle
* Käyttöliittymä
  * Pelin aikainen näkymä
    * Pikmnieen määrä seuraamassa johtajaa
    * Pikmnien määrä ulkona
* Grafiikat
  * Yksinkertaiset
  * Eri asiat pitää pystyä erottamaan toisistaan.
* Debug-tila
  * Tekee path-finding-järjsetelmän käyttämistä suorakulmioista näkyviä.
    * Pathfinding-järjestelmän on luultavasti monimutkaisin yksittäinen osa ja sen testaamiseen ei olisi muuten helppoa tapaa.

## Jatkokehhitysideat
* Pelaaja voi ksäkeä kauempanan olevia Pikmineitä liittymään joukkoonsa.
* Pelaaja voi jättää nykyisen Pikmin-joukkonsa jonnekin.
* Pikminien hallinta
  * Pikmineitä on useampaa tyyppiä.
    * Eri tyypeillä on hieman erilaisia ominaisuuksia kuten taisteluvoima, kantokyky ja tulen sieto.
* Taistelu
  * Pelissä on vihollisia, joita vastaan Pikminit voivat taitstella
  * Pelaaja voi käskeä Pikminejä hyökkäämään viholliseen.
  * Pikminit ja pelaaja voivat kuolla
  * Pelimekaaniikallisesti yksinkertainen
* Pelaajaa seuraava kamera
* Pelaajaa seuraavat Pikminit näkyvät kävelemässä pelaajan perässä.
* Käyttöliittymä
  * Tallennustiedoston valinta
  * Alueenavalintanäyttö
  * Pelin aikainen näkymä
    * Päivän eteneminen
* Aikarajat
  * Peli on jaoteltu päiviin, joilla on aikaraja.
  * Peli keskeytyy päivän päätyttyä ja päivän eteneminen tallennetaann.
  * Raja pävien määrälle, jonka pelaaja saa korkeintaan käyttää pelin läpäisemiseen.
* Etenemisen tallentaminen
  * Pelaajan Pikminien määrä, kerätyt esineet ja muut pelin etenemiseen liiittyvät asiat.
  * Pelaajan Pikminien määrä, kerätyt esineet ja muut pelin etenemiseen liiittyvät asiat.
  * Vain päivän lopussa
  * Useampi tallennustiedosto
  * Mahdollisuus palata edellisiin päivien tallennustiedostoihin
* Enemmän peliä (Lennokkaammat ideat jotka kuitenkin halusin kirjata)
  * Lisää alueita,vihollisia, Pikmin-tyyppejä, esineitä jne.
  * Leaf -> Bud -> Flower -kehittyminen Pikmineille.
  * Taistelu
    * Laajemmat taistelumekaniikat
    * Pomotaistelut 
  * Pelin eteneminen
    * Tarina
    * Pelin voi läpäistä
    * Vaatimukset uusien alueiden aukaisemiselle
* Paremmat grafiikat