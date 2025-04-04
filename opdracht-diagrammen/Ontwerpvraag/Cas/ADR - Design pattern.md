# ADR - Design pattern

## Status
Closed
## Context
Het systeem heeft verschillende externe services die via een gemeenschappelijk adapter moeten worden aangesproken. Deze externe services kunnen variëren van betalingssysteemintegraties tot communicatie-API's en data-aanroepen. Het is belangrijk dat de interne logica van het systeem niet hoeft te worden aangepast wanneer nieuwe externe services worden toegevoegd of bestaande services worden gewijzigd. Dit maakt de implementatie van een schaalbare en onderhoudbare oplossing noodzakelijk, waarbij de communicatie met deze externe services flexibel kan worden toegevoegd zonder de bestaande werking van het systeem te verstoren.
## Considered Options

| Forces            | Adapter | Facade | State | Strategy | Factory | 
|-------------------|---------|--------|-------|----------|---------|
| Onderhoudbaarheid | ++      | ++     | -     | ++       | ++      |
| Testbaarheid      | +       | -      | --    | ++       | -       |
| Flexibiliteit     | ++      | 0      | -     | +        | 0       |

## Decision
Na het evalueren van verschillende design patterns is gekozen voor het Adapter Pattern. Dit biedt de beste balans tussen onderhoudbaarheid, flexibiliteit en testbaarheid, terwijl het eenvoudig maakt om nieuwe externe services toe te voegen zonder de interne logica te verstoren.

## Consequences
Het gebruik van het Adapter Pattern maakt de code flexibel voor toekomstige uitbreidingen en vergemakkelijkt de testbaarheid door het mocken van externe services. Het zorgt ervoor dat de backend-architectuur robuust blijft, zelfs als de externe systemen veranderen of nieuwe systemen moeten worden geïntegreerd.


