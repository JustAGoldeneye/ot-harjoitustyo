# Pikmin 2D

## Huomioita

Ohjelmani kaikki tämänhetkiset luokat tarvitsevat ainakin joitain javafx:n elementtejä, enkä onnistunut saamaan junit-testejä toimimaan javafx:n kanssa, joten preojektissa ei ole junit-testejä.

## Nykyiset ominaisuudet

Pelin tällä hetkellä käyttäjälle ainoa helposti näkyvä ominaisuus pelaajahahmon liikuttaminen. Tämän lisäksi ohjelman importMapInfo-metodi pystyy lukemaan pelialueen tiedot maps-kansiossa olevasta tiedostosta. Tähän tiedostoon on myöhemmin tarkoitus lisätä tiedot kaikista muistakin pelialueen objekteista.

### Pelin pelaaminen

W - Liiku eteenpäin

A - Käänny vasemmalle

D - Käänny oikealle

## Dokumentaatio

* [Vaatimusmäärittely](https://github.com/JustAGoldeneye/ot-harjoitustyo/blob/master/Documentation/Vaatimusmaarittely.md)
* [Työaikakirjanpito](https://github.com/JustAGoldeneye/ot-harjoitustyo/blob/master/Documentation/Tyoaikakirjanpito.md)

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