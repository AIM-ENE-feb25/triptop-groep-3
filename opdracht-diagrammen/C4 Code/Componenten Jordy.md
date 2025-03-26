| **Componentnaam**          | **Verantwoordelijkheid**                                                                                                     |
|----------------------------|------------------------------------------------------------------------------------------------------------------------------|
| **Travel Data Controller** | Handelt het resultaat van API requests af door data op te halen uit de cache of een melding terug te geven aan de front end. |
| **Web Applicatie**         | Verstuurd API verzoeken naar backend en geeft het resultaat weer aan de gebruiker.                                           |
| **Travel Service**         | Doet API verzoeken versturen naar externe systemen met betrekking tot reisplannen en geeft deze terug aan de controller.     |
| **Location Service**       | Doet API verzoeken versturen naar externe systemen met betrekking tot reisadvies en geeft deze terug aan de controller.      |
| **CouchBase Database**     | Slaat gegevens op die nodig zijn voor caching en geeft deze terug aan de controller via een repo.                            |

