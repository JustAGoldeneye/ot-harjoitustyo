# Pikmin 2D

## Viikoittaisia huomioita

Käytin tällä viikolla ajan pääosin kannettavien esineiden ja niiden kantamismahdollisuuden työstämiseen, mutta tämä osoittautui yllättävän aikaa vieväksi, joten en saanut tätä ominaisuutta valmiiksi.

## Nykyiset ominaisuudet

Pelaaja voi liikuttaa hahmoa, ja Pikmineitä voi kerätä koskemalla niihin. Pikmineitä voi käskeä kantamaan kannettavia esineitä.

Tämän lisäksi ohjelman importMapInfo-metodi pystyy lukemaan pelialueen tiedot maps-kansiossa olevasta tiedostosta. Tämä karttatiedostomuoto (.pkmp) tukee tällä hetkellä pelaajan, Pikminien ja kannettavien esineiden lisäämistä kartalle. Pelialueen koon voi myös valita.

### Pelin pelaaminen

W - Liiku eteenpäin

A - Käänny vasemmalle

D - Käänny oikealle

E - Käske Pikmin kantamaan esinettä, kun pelaajahahmo koskee esineeseen

## Dokumentaatio

* [Vaatimusmäärittely](https://github.com/JustAGoldeneye/ot-harjoitustyo/blob/master/Documentation/Vaatimusmaarittely.md)
* [Työaikakirjanpito](https://github.com/JustAGoldeneye/ot-harjoitustyo/blob/master/Documentation/Tyoaikakirjanpito.md)
* [Arkkitehtuurikuvaus](https://github.com/JustAGoldeneye/ot-harjoitustyo/blob/master/Documentation/arkkitehtuuri.md) (kesken)
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