## Status

In progress

## Context

We willen erachter komen welke database we het best kunnen gebruiken voor het project Triptop.

## Considered Options

| Forces | MongoDB | Cassandra | neo4J | Redis | Couchbase | SQL |
| --- | --- | --- | --- | --- | --- | --- |
| snelheid | + | ++ | - | ++ | + | - |
| leercurve | + | — | — | + | — | ++ |
| functionaliteit | ++ | + | ++ | - | + | ++ |
| schaalbaarheid | + | ++ | ++ | - | + | - |
| ervaring | 0 | 0 | 0 | — | — | ++ |

## Decision

Omdat ervaring en functionaliteit zwaar meewegen, hebben we de keuze beperkt tot SQL en MongoDB.

## Consequences

Na de keuze voor MongoDB als database voor TripTop, zijn er verschillende gevolgen die deze beslissing met zich meebrengt.

Door te kiezen voor MongoDB profiteren we van meerdere voordelen die goed aansluiten bij de behoeften van TripTop:

- Flexibele datastructuur: Omdat MongoDB geen vast schema vereist, kunnen we reisdata met verschillende eigenschappen eenvoudig opslaan zonder complexe schema-aanpassingen. Dit maakt het mogelijk om nieuwe functionaliteiten toe te voegen zonder grote databasewijzigingen.
- Goede JSON-compatibiliteit: De database werkt direct met JSON, wat de integratie met onze webapplicatie en front-end vergemakkelijkt. Dit zorgt voor efficiënte communicatie tussen de back-end en de client.
- Snellere ontwikkeling: Doordat schema-wijzigingen niet nodig zijn, kunnen we sneller nieuwe features implementeren en itereren op basis van gebruikersfeedback.
- Horizontaal schaalbaar: MongoDB is ontworpen om goed te functioneren op meerdere servers, wat betekent dat de database eenvoudig kan meegroeien met een toenemend aantal gebruikers zonder prestatieverlies.
- Beter geschikt voor semi-gestructureerde data: Gegevens zoals reisplannen, beoordelingen en zoekfilters kunnen eenvoudig worden opgeslagen en opgehaald zonder dat we ingewikkelde relaties moeten definiëren.

Ondanks de voordelen, brengt de keuze voor MongoDB ook enkele beperkingen met zich mee die we in overweging moeten nemen:

- Minder relationele integriteit: MongoDB ondersteunt geen klassieke foreign keys zoals SQL, waardoor de consistentie tussen gerelateerde datasets niet automatisch wordt afgedwongen. Dit betekent dat we zelf verantwoordelijk zijn voor het handhaven van dataconsistentie in onze applicatie.
- Query-snelheid bij veel JOIN-achtige bevragingen: Hoewel MongoDB efficiënter is bij het ophalen van documenten, kan het trager zijn als er veel relaties tussen datasets nodig zijn. In SQL kunnen complexe queries met JOINs efficiënter uitgevoerd worden, terwijl MongoDB soms extra dataduplicatie of embedded documenten vereist om vergelijkbare prestaties te behalen.
- We moeten MongoDB nog leren: Aangezien ons team meer ervaring heeft met SQL en nog weinig kennis heeft van MongoDB, zal er tijd geïnvesteerd moeten worden in het leren van de basisprincipes, query's en best practices van deze database. Dit kan in het begin een leercurve met zich meebrengen.