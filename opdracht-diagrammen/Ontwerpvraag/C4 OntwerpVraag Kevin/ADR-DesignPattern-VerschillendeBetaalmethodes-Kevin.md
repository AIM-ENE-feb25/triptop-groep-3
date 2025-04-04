## Status
<!-- Kies één: Proposed / Under discussion / Accepted / Rejected -->
Under discussion

## Context

Voor Triptop, een modulair platform met verschillende bouwstenen, moeten we een flexibel en schaalbaar betalingssysteem integreren. De oplossing moet voldoen aan de volgende eisen:
- Het systeem moet eenvoudig uit te breiden zijn voor nieuwe betalingsmethoden.
- Het betalingssysteem moet eenvoudig te onderhouden en aan te passen zijn naarmate de eisen veranderen.
- Het moet een duidelijke en gestandaardiseerde interface bieden voor andere modules van het platform.

Er moet een design pattern gekozen worden om deze functie zo efficient mogelijk te integreren.


## Considered Options

| Forces                         | Adapter | Facade | State | Strategy | Factory |  
|--------------------------------|---------|--------|-------|----------|---------|  
| Onderhoudbaarheid              | +       | ++     | -     | 0        | 0       |  
| Complexiteit                   | +       | +      | -     | --       | ++      |  
| Flexibiliteit                  | +       | 0      | -     | +        | 0       |  
| Gebruiksvriendelijke Interface | +       | ++     | 0     | 0        | -       | 

## Decision

Omdat het platform flexibel moet zijn voor meerdere betaal methodes heb ik gekozen voor de facade pattern.
Dit zorgt ervoor dat nieuwe betaalmethodes makkelijk kunt aanroepen en alle logica achter de interface gebeurt waardoor je er ook makkelijk mee kunt werken als je niet goed weet hoe het betalingssysteem werkt.

## Consequences

Door te kiezen voor het **Facade pattern**:
- **Eenvoudige integratie**: Het systeem kan gemakkelijk nieuwe betaalmethoden integreren zonder dat andere delen van het platform worden aangepast.
- **Verborgen complexiteit**: De complexiteit van de verschillende betaalmethoden wordt afgeschermd voor andere modules, wat het systeem gemakkelijker te gebruiken en te onderhouden maakt.
- **Toekomstbestendigheid**: Het systeem kan eenvoudig worden uitgebreid naarmate nieuwe betaalmethoden ontstaan, zonder grote aanpassingen in de bestaande architectuur.