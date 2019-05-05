# Pikmin 2D

## Ominaisuudet

Pelaaja voi liikuttaa hahmoa, ja Pikmineitä voi kerätä koskemalla niihin. Pikmineitä voi käskeä kantamaan kannettavia esineitä.

Tämän lisäksi ohjelman importMapInfo-metodi pystyy lukemaan pelialueen tiedot maps-kansiossa olevasta tiedostosta. Tämä karttatiedostomuoto (.pkmp) tukee tällä hetkellä pelaajan, Pikminien ja kannettavien esineiden lisäämistä kartalle. Pelialueen koon voi myös valita tätä kautta. Pelin voi myös tallentaa.

### Pelin pelaaminen

W - Liiku eteenpäin

A - Käänny vasemmalle

D - Käänny oikealle

Enter - Käske Pikmin kantamaan esinettä, kun pelaajahahmo koskee esineeseen

P - Tallenna esineiden ja Pikminien määrä

O - Säätää kokonäytön tilaa

P - Sulkee pelin

I - Tyhjentää tallennustiedoston ja sulkee pelin

## Dokumentaatio

* [Vaatimusmäärittely](https://github.com/JustAGoldeneye/ot-harjoitustyo/blob/master/Documentation/Vaatimusmaarittely.md)
* [Työaikakirjanpito](https://github.com/JustAGoldeneye/ot-harjoitustyo/blob/master/Documentation/Tyoaikakirjanpito.md)
* [Arkkitehtuurikuvaus](https://github.com/JustAGoldeneye/ot-harjoitustyo/blob/master/Documentation/arkkitehtuuri.md)
* [Käyttöohje](https://github.com/JustAGoldeneye/ot-harjoitustyo/blob/master/Documentation/Kayttoohje.md)

## Komentorivikomennot

### Projektitieodoston suorittaminen

`mvn compile exec:java -Dexec.mainClass=game.Main`

### Testaus

Testien suorittaminen

`mvn test`

Testikattavuusraportin luominen

`mvn jacoco:report`

Kattavuusraportti luodaan sijaintiin *target/site/jacoco/index.html*

### Jar

`mvn package`

jar-tiedoston luodaan sijaintiin *Pikmin2D-1.0-SNAPSHOT*

### Javadoc

`mvn javadoc:javadoc`

jabadoc luodaan sijaintiin *target/site/apidocs/index.html*

### Checkstyle

`mvn jxr:jxr checkstyle:checkstyle`

checkstyle-raportti luodaan sijaintiin *target/site/checkstyle.html*