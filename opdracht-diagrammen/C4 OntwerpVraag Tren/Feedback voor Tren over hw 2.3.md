
**Onderzoeksvraag**: 
Hoe zorg je ervoor dat je bij een wijziging in de datastructuur van een externe service niet de hele applicatie hoeft aan te passen?
# Stap 1

Je zegt:
'Component moet misschien client worden voor de verschillende componenten die praten met externe API’s? een client is vaak verantwoordelijk voor communicatie met externen.'

Ik snap niet helemaal waarom dit hier staat. Is dit antwoord op je onderzoeksvraag? Kan je dit beter toelichten of meer context geven door middel van een klein (lopend) verhaal.

| Component               | Verantwoordelijkheid   |
| ----------------------- | ---------------------- |
| Travel plans Repository | beheert reisplannen    |
| Travel Service          | verwerkt reisaanvragen |
Ik betwijfel of bovenstaande 2 componenten relevant zijn voor de onderzoeksvraag, omdat ze gericht zijn op de logica van reisplannen en reisaanvragen, terwijl de onderzoeksvraag draait om het omgaan met **wijzigingen in de datastructuur** (van een externe service).

# Stap 2
Ziet er volgens mij goed uit. Je zou per methode misschien nog een beschrijving kunnen toevoegen (ik weet niet of dit moet, maar het zou wel helpen om het sneller en beter te begrijpen).

# Stap 3
Ik weet dus niet of de repository relevent is in dit diagram. 

De client container is hier toch de externe API dan eigenlijk? Je kan deze dan beter grijs van kleur maken ipv de standaard blauw. 

# Stap 4
Dit was niet de opdracht. De opdracht luidt: 'De uitkomst is een class diagram met classes en functies (het code/class level van C4).'
Dit zie ik niet terug in je Class diagram. Neem meer voorbeeld aan mijn class diagram. Kijk even terug naar stap 2, hierin heb je wel functies enzo staan.

