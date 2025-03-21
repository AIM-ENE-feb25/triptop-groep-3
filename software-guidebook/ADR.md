## Status

## Context

We willen erachter komen welke database we gaan gebruiken voor het project TripTop

## Considered Options

| Forces | MongoDB | Cassandra | neo4J | Redis | Couchbase | SQL |
| --- | --- | --- | --- | --- | --- | --- |
| snelheid | + | ++ | - | ++ | + | - |
| leercurve | + | — | — | + | — | ++ |
| functionaliteit | ++ | + | ++ | - | + | ++ |
| schaalbaarheid | + | ++ | ++ | - | + | - |
| ervaring | 0 | 0 | 0 | — | — | ++ |

## Decision

Omdat ervaring & functionaliteit zwaar meeweegt, is bij ons de overweging gekomen tussen SQL & MongoDB.

## Consequences

MongoDB: