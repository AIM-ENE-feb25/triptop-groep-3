## Status
Under discussion
## Context

Voor Triptop, een Reisplanningsapplicatie in constructie, moeten we een database kiezen die schaalbaar en flexibel is, gezien de verschillende bouwstenen en de integratie met externe services. De database moet in staat zijn om dynamisch gegevens op te slaan, zoals reisopties en gebruikersinformatie, en deze efficiënt beheren. De keuze moet ook de integratie van diverse APIs en het omgaan met veranderende datastructuren ondersteunen, zonder de applicatie ingrijpend aan te passen. Hierbij is het belangrijk dat de database de nodige beveiliging biedt voor gevoelige informatie, zoals betalings- en gebruikersdata.
## Considered Options

| Forces | MongoDB | Cassandra | neo4J | Redis | Couchbase | MySQL |
| --- | --- | --- | --- | --- | --- |-------|
| snelheid | + | ++ | - | ++ | + | -     |
| leercurve | + | — | — | + | — | ++    |
| functionaliteit | ++ | + | ++ | - | + | ++    |
| schaalbaarheid | + | ++ | - | - | + | -     |
| ervaring | 0 | 0 | 0 | — | — | ++    |

## Decision

Omdat functionaliteit zwaar meeweegt, en ervaring minder meeweegt, is bij ons de overweging gekomen tussen MySQL & MongoDB.
De keuze is gevallen op MongoDB, omdat deze de meeste voordelen heeft.

## Consequences

Het gebruiken van MongoDB geeft TripTop de mogelijkheid om flink op te schalen wanneer het bedrijf daar klaar voor is.
Je krijgt document


