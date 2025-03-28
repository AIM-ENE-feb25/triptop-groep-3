## Status
<!-- Kies één: Proposed / Under discussion / Accepted / Rejected -->
Rejected

## Context

Voor Triptop, waarin we te maken hebben met externe APIs die verouderde beveiligingsprotocollen gebruiken, moeten we een strategie bepalen om veilig met deze APIs te interfacen. Deze externe APIs ondersteunen mogelijk geen moderne protocollen zoals OAuth 2.0, TLS 1.2+, of andere best practices voor beveiliging.

De oplossing moet:
- De risico's van onveilige API-interacties minimaliseren
- Integratie met de externe APIs behouden zonder bedrijfsprocessen te verstoren
- Flexibel en schaalbaar

## Considered Options

| Criteria / Forces          | API Gateway met beveiligingslaag | Proxy | VPN/Private Network | 
|----------------------------|----------------------------------|-------|---------------------|
| Beveiliging                | -                                | -     | -                   |
| Implementatiecomplexiteit  | +                                | 0     | -                   |
| Onderhoudbaarheid          | +                                | ++    | -                   |
| Impact op prestaties       | 0                                | 0     | -                   |
| Schaalbaarheid             | ++                               | +     | --                  |

Legenda:
- `++` = sterke positieve score
- `+`  = positief
- `0`  = neutraal
- `—`  = negatief
- `-`  = sterk negatief

## Decision

Omdat alle opties geen veiligheid kunnen garanderen wanneer een externen api veroudere beveiligingsprotocollen gebruikt hebben wij er voor gekozen om hier niet verder mee te gaan werken.

## Consequences

Dit betekend dat wanneer er verouderde api's zijn we deze niet kunnen gebruiken.