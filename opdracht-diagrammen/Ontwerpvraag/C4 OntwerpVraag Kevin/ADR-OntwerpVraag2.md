## Status
<!-- Kies één: Proposed / Under discussion / Accepted / Rejected -->
Accepted

## Context

Voor Triptop, een modulair platform met verschillende bouwstenen, moeten we een flexibel en schaalbaar betalingssysteem integreren. De oplossing moet voldoen aan de volgende eisen:
- Ondersteuning van meerdere betalingsproviders en betaalmethodes
- Modulair en uitbreidbaar ontwerp

## Considered Options

| Criteria / Forces          | Ondersteun meerdere api's | Losse API voor verschillende betaalmethodes | Eigen betaalgateway | 
|----------------------------|---------------------------|---------------------------------------------|---------------------|
| Implementatiecomplexiteit  | +                         | 0                                           | --                  |
| Onderhoudbaarheid          | +                         | ++                                          | --                  |
| Impact op prestaties       | +                         | ++                                          | +                   |
| Schaalbaarheid             | ++                        | ++                                          | -                   |

Legenda:
- `++` = sterke positieve score
- `+`  = positief
- `0`  = neutraal
- `—`  = negatief
- `-`  = sterk negatief

## Decision

Gezien de prioriteit van schaalbaarheid en onderhoudbaarheid, kiezen we voor het implementeren van losse API's voor verschillende betaalmethodes.
Deze oplossing maakt het mogelijk om elke betaalmethode onafhankelijk te implementeren en te beheren, waardoor uitbreiden makkelijk wordt.
Hoewel de initiële implementatie meer werk is, biedt deze oplossing de flexibiliteit om nieuwe betaalmethodes eenvoudig toe te voegen.

## Consequences

Door te kiezen voor losse API's voor verschillende betaalmethodes, moeten we:

- Voor iedere betaalmethode afzonderlijke API-integraties implementeren, wat zorgt voor meer werk tijdens de initiële ontwikkeling.
- Een goede documentatie en duidelijke standaarden opzetten voor het onderhoud van de API's.