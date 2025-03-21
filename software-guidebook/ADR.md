## Status

## Context

We willen erachter komen welke database we gaan gebruiken voor het project TripTop

## Considered Options

| Forces | MongoDB | Cassandra | neo4J | Redis | Couchbase | SQL |
| --- | --- | --- | --- | --- | --- | --- |
| snelheid | + | ++ | - | ++ | + | - |
| leercurve | + | — | — | + | — | ++ |
| functionaliteit | 0 | + | ++ | - | + | ++ |
| schaalbaarheid | + | ++ | ++ | - | + | - |
| ervaring | 0 | 0 | 0 | — | — | ++ |

## Decision

Omdat ervaring & functionaliteit zwaar meeweegt, is bij ons de overweging gekomen tussen SQL & MongoDB.

## Consequences

MongoDB:

We zullen een voor ons relatief nieuwe techniek moeten leren, en alle informatie wordt opgeslagen in een document in plaats van een tabel, wat voor TripTop niet handig is.

SQL:

Op de lange termijn, als TripTop internationaal wilt uitbreiden, kan het zijn dat de database opgesplitst moet worden en er alsnog gebruik gemaakt moet worden van een van de NoSQL databases.