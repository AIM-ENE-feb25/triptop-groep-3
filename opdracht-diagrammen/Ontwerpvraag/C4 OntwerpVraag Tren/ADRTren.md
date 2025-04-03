## Context

In  TripTop communiceren we met meerdere externe services (zoals autoverhuur, hotels, activiteiten, vervoer en eetopties). Deze services leveren data met eigen, vaak veranderlijke datastructuren. Een wijziging in een response van zo’n externe service kan impact hebben op meerdere onderdelen van de applicatie.

We willen voorkomen dat een wijziging in een externe datastructuur leidt tot problemen in de applicatie.
De oplossing moet:

•	Aanpasbaar zijn bij verandering van een specifieke API

•	De rest van het systeem  (zoveel mogelijk) onaangetast laten

•	De code begrijpelijk en onderhoudbaar houden

## Considered Options

| Criteria | directe parsing van JSON in de services | API Adapter pattern | één centrale ApiGateway |
| --- | --- |---------------------|-------------------------|
| snelheid (van verwerken data) | ++ | +                   | +/-                     |
| schaalbaarheid | ++ | +                   | ++                      |
| Aanpasbaarheid | — | ++                  | -                       |

## Decision

We kiezen voor het API Adapter pattern.
Hiervoor is gekozen omdat de aanpasbaarheid van de applicatie voor ons het belangrijkst is,
omdat we met meerdere externe services werken die allemaal hun eigen datastructuren hebben.
Dit kan leiden tot veel aanpassingen in de applicatie als we dit niet goed aanpakken.

## Consequences

•	Wijzigingen in externe datastructuren vereisen alleen aanpassing in de betreffende client/mapper

•	De rest van de applicatie (services, controller, repository) blijft stabiel

•	We kunnen eenvoudig nieuwe externe APIs integreren door nieuwe client + mapping toe te voegen

