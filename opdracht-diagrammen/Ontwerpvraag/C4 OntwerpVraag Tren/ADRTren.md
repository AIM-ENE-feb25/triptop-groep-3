## Context

In de applicatie **TripTop** communiceren we met meerdere externe services (zoals autoverhuur, hotels, activiteiten, vervoer en eetopties). Deze services leveren data met eigen, vaak veranderlijke datastructuren. Een wijziging in een response van zo’n externe service kan impact hebben op meerdere onderdelen van de applicatie.

We willen voorkomen dat een wijziging in een externe datastructuur leidt tot **wijzigingen in de businesslogica of presentatie-laag** van onze applicatie. De oplossing moet:

•	Aanpasbaar zijn bij verandering van een specifieke API

•	De rest van het systeem onaangetast laten

•	De code begrijpelijk en onderhoudbaar houden

## Considered Options

| Criteria | directe parsing van JSON in de services | Externe API Adapter/APiMapper | één centrale ApiGateway |
| --- | --- | --- | --- |
| snelheid (van verwerken data) | ++ | + | +/- |
| schaalbaarheid | ++ | + | — |
| Aanpasbaarheid | — | ++ | - |

## Decision

In de applicatie **TripTop** communiceren we met meerdere externe services (zoals autoverhuur, hotels, activiteiten, vervoer en eetopties). Deze services leveren data met eigen, vaak veranderlijke datastructuren. Een wijziging in een response van zo’n externe service kan impact hebben op meerdere onderdelen van de applicatie.

We willen voorkomen dat een wijziging in een externe datastructuur leidt tot **wijzigingen in de businesslogica of presentatie-laag** van onze applicatie. De oplossing moet:

•	Aanpasbaar zijn bij verandering van een specifieke API

•	De rest van het systeem onaangetast laten

•	De code begrijpelijk en onderhoudbaar houden

## Consequences

•	Wijzigingen in externe datastructuren vereisen **alleen aanpassing in de betreffende client/mapper**

•	De rest van de applicatie (services, controller, repository) blijft **stabiel**

•	We kunnen eenvoudig nieuwe externe APIs integreren door **nieuwe client + mapping toe te voegen**

•	Door duidelijk onderscheid tussen domeinmodellen en externe modellen, blijft **code begrijpelijk en testbaar**