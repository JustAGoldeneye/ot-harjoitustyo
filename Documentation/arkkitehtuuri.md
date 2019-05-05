# Arkkitehtuurikuvaus

## Rakenne

Kuavassa näkyvä ohjelman rakenne on aikaisemmasta vaiheesta projektia, mutta se on silti hyvä kuvaus ohjelman rakenteesta. Karttatiedostojen lukeminen kuuluu vieläkin gameArealle, koska tätä ominaisuutta olisi vaikea enää tässä vaiheessa siirtöö DAO:lle; valtava osa ohjelmasta olisi tehtävä anakin osittain uusiksi. Pelifysiikat ja -grafiikat hallinoiva JavaFX on erotettu muista pelilogikka hallinnoivista luokista.
![Arkkitehtuuriluonnos](https://github.com/JustAGoldeneye/ot-harjoitustyo/blob/master/Documentation/Pikmin_2D_arkkitehtuurisuunnitelma.png "Arkkitehtuuriluonnos") 

## Sovelluslogiikka

Sovelluslogiikan keskiössä on GameArea luokka, joka säilöö pelialueen tiedot. Pelilogiikkaoliot (domain) ovat JavaFX-oloidoiden (ui) alaisina

Pikminin lisääminen pelaajalta kannettavaan esineeseen:
![Sekevenssikavio](https://github.com/JustAGoldeneye/ot-harjoitustyo/blob/master/Documentation/Sekvenssikaavio.png "Sekvenssikaavio")

## Tiedostot

Karttatiedostojen lukemisesta vastaa gameArea ja tallennustiedostojen lukemisesta ja muokkaamisesta SaveControl