## Status
<!-- Kies één: Proposed / Under discussion / Accepted / Rejected -->
Proposed

## Context

Voor TripTop, een Reisplanningsapplicatie in constructie,
worden verschillende externe APIs aangeroepen voor het ophalen van reisinformatie voor gebruikers. 
Echter komt het wel eens voor dat de externe APIS onbeschikbaar zijn waardoor deze informatie onbeschikbaar is.
Daarom moet er een keuze gemaakt worden in hoe het systeem hierop reageert.

## Considered Options

| Criteria / Forces  | In-Memory Cache | Foutmelding | Couchbase Cache | Redis | 
|--------------------|----------------|-------------|-----------------|-------|
| Snelheid           | +              | ++          | +               | +     |
| Leercurve          | 0              | ++          | 0               | -     | 
| Waardevolle output | +              | --          | ++              | ++    |
| integreerbaar      | +              | ++          | ++              | 0     |


Legenda:
- `++` = sterke positieve score
- `+`  = positief
- `0`  = neutraal
- `—`  = negatief
- `-`  = sterk negatief

## Decision

Ondanks dat een simpele foutmelding het meeste pluspunten scoort, valt deze optie al snel af omdat de voornaamste eis de waardevolle output is. 
Omdat er gebruikt word gemaakt van CouchBase als database is het gebruik van de cache binnen deze database makkelijk te integreren, en dus de uiteindelijke keuze. 

## Consequences

Door te kiezen voor Couchbase cache:

- Is integratie een minder groot probleem doordat dit in het bestaande ontwerp makkelijk kan worden toegevoegd
- Kan een waardevolle output teruggegeven worden aan gebruikers door zoekresultaten op te slaan
