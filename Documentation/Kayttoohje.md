# Käyttöohje

## Ominaisuudet

Pelaaja voi liikuttaa hahmoa, ja Pikmineitä voi kerätä koskemalla niihin. Pikmineitä voi käskeä kantamaan kannettavia esineitä maalialueelle. Varsinaisia esteitä en vielä kerennyt lisätä.

Kartan tilan voi tallentaa.

Tämän lisäksi ohjelman importMapInfo-metodi pystyy lukemaan pelialueen tiedot maps-kansiossa olevasta tiedostosta. Tämä karttatiedostomuoto (.pkmp) tukee tällä hetkellä pelaajan, Pikminien ja kannettavien esineiden lisäämistä kartalle. Pelialueen koon voi myös valita tätä kautta.

## Pelin pelaaminen

W - Liiku eteenpäin

A - Käänny vasemmalle

D - Käänny oikealle

Enter - Käske Pikmin kantamaan esinettä, kun pelaajahahmo koskee esineeseen

P - Tallenna esineiden ja Pikminien määrä

O - Säätää kokonäytön tilaa

P - Sulkee pelin

I - Tyhjentää tallennustiedoston ja sulkee pelin

## Modattavuus

Pelaajaan on helppo muokata pelialuetta haluamakseen pkmp.tiedostojen avulla. [testmap1.pkmp](https://github.com/JustAGoldeneye/ot-harjoitustyo/blob/master/Pikmin2D/maps/testmap1.pkmp) sisältää dokumentaatiota tiedostomuodon käytöstä.
Pelissä on myös debug mode, mikä tekee näkymättömistä peliobjekteista näkyviä. Tällä hetkellä se voidaan kytkeä käyttöön manuaalisesti [Main](https://github.com/JustAGoldeneye/ot-harjoitustyo/blob/master/Pikmin2D/src/main/java/game/Main.java)-luokasta
