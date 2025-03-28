## Status
<!-- Kies één: Proposed / Under discussion / Accepted / Rejected -->
Under discussion

## Context

Voor **[Projectnaam]**, een [korte beschrijving van het systeem], moet een database gekozen worden die voldoet aan de eisen van:

- schaalbaarheid en flexibiliteit,
- ondersteuning van dynamische datastructuren,
- eenvoudige integratie met externe services (zoals externe APIs),
- en het minimaliseren van aanpassingen aan de applicatie bij wijzigingen in datastructuren.

De database moet in staat zijn om gegevens zoals [gebruikersinformatie, reisopties, etc.] efficiënt op te slaan en te beheren.

## Considered Options

| Criteria / Forces     | MongoDB | Cassandra | neo4J | Redis | Couchbase | MySQL |
|------------------------|---------|-----------|-------|--------|------------|--------|
| Snelheid               | +       | +         | +     | +      | +          | 0      |
| Leercurve              | +       | —         | —     | +      | +          | ++     |
| Functionaliteit        | ++      | +         | +     | -      | ++         | ++     |
| Schaalbaarheid         | +       | +         | +     | +      | 0          | 0      |
| Teamervaring           | 0       | 0         | 0     | —      | —          | ++     |

## Decision

Omdat **functionaliteit** en **leercurve** zwaar meewegen in onze afweging, en **ervaring**, **schaalbaarheid** en **snelheid** minder zwaar, hebben we ons gefocust op **MySQL**, **MongoDB** en **Couchbase**.

De keuze is gevallen op **Couchbase**, omdat deze het beste scoort op de belangrijkste criteria:
- Flexibiliteit door document-based opslag
- Redelijke leercurve
- Krachtige ondersteuning voor schaalbaarheid en dynamische data

## Consequences

Door te kiezen voor Couchbase:

- Is **schaalbaarheid** eenvoudig als de applicatie of het gebruik groeit
- Kunnen **dynamische datastructuren** flexibel worden toegevoegd of aangepast zonder breaking changes in de applicatie
- Wordt het mogelijk om **sneller te ontwikkelen**, zonder complexe migraties bij dataverschuiving
- Is er een **kleinere kans op datamodel-lock-in**, wat toekomstbestendig is