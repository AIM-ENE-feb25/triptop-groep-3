## Context

In de applicatie TripTop communiceren we met meerdere externe services.
Deze services leveren data met eigen, vaak veranderlijke datastructuren. 
Een wijziging in een response van zo’n externe service kan impact hebben op meerdere onderdelen van de applicatie.
We willen voorkomen dat een wijziging in een externe datastructuur leidt tot wijzigingen in de businesslogica of presentatie-laag van onze applicatie. 
De oplossing moet:

- Aanpasbaar zijn bij verandering van een specifieke API
- De rest van het systeem onaangetast laten
- De code begrijpelijk en onderhoudbaar houden

## Considered Options

| Criteria               | Adapter Pattern                   | Strategy Pattern                    | Facade Pattern                       |
|------------------------|-----------------------------------|-------------------------------------|--------------------------------------|
| Isoleert externe APIs  | ++                                | –                                   | +                                    |
| Open/Closed Principle  | ++                                | +                                   | –                                    |
| Herbruikbaarheid       | +                                 | ++                                  | –                                    |
| Complexiteit           | +                                 | –                                   | ++                                   |
| Specifiek voor datastructuren | ++                          | –                                   | ±                                    |

## Decision

We kiezen voor het Adapter Pattern.

Het Adapter Pattern zorgt ervoor dat we externe datastructuren kunnen omzetten naar interne domeinmodellen via een specifieke adapter per externe API.
Deze adapter vormt een brug tussen onze interne interface en de werkelijke externe datastructuur.

## Consequences

- Wijzigingen in externe datastructuren vereisen alleen aanpassing in de betreffende adapter
- De rest van de applicatie (services, controllers, repositories) blijft stabiel
- Nieuwe externe APIs zijn eenvoudig te integreren via een nieuwe adapter + interface
- De code blijft testbaar en begrijpelijk door een duidelijk onderscheid tussen externe en interne modellen
