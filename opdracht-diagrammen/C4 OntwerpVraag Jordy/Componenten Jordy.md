Vraag:
Hoe ga je om met aanroepen van externe services die niet beschikbaar zijn 
en toch verwacht wordt dat er waardevolle output gegeven wordt?

Stap 1

| **Componentnaam**          | **Verantwoordelijkheid**                                                                                                     |
|----------------------------|------------------------------------------------------------------------------------------------------------------------------|
| **Travel Data Controller** | Handelt het resultaat van API requests af door data op te halen uit de cache of een melding terug te geven aan de front end. |
| **Travel Service**         | Doet API verzoeken versturen naar externe systemen met betrekking tot reisplannen en geeft deze terug aan de controller.     |
| **Location Service**       | Doet API verzoeken versturen naar externe systemen met betrekking tot reisadvies en geeft deze terug aan de controller.      |
| **CouchBase Database**     | Slaat gegevens op die nodig zijn voor caching en geeft deze terug aan de controller via een repo.                            |

Stap 2

Interface TravelControl

| **Methode**                    | **Parameters**    | **Returnwaarde** | **Beschrijving**               |
|--------------------------------| ----------------- | ---------------- |--------------------------------|
| RequestData(keyword, category) | keyword: string, category: string | serviceResponse | Verstuurt een API request door | 
| RequestCache(keyword, category) | keyword: string, category: string | travelData | Vraagt reisdata op uit de cache wanneer de API onbeschikbaar is |

Interface APIService: 

| **Methode**                    | **Parameters**    | **Returnwaarde** | **Beschrijving**                        |
|--------------------------------| ----------------- | ---------------- |-----------------------------------------|
| ReturnResult(response)         | response: object | serviceResponse | Bepaald het resultaat van de API request | 
| SendRequest(keyword, category) | keyword: string, category: string | serviceResponse | Stuurt verzoek naar externe API         | 


Interface DatabaseService: 

| **Methode**                      | **Parameters**                    | **Returnwaarde** | **Beschrijving**                                                          |
|----------------------------------|-----------------------------------|------------------|---------------------------------------------------------------------------|
| ReturnCollect(keyword, category) | keyword: string, category: string | travelData       | Haalt data op uit de cache op basis van gekozen trefwoord en/of categorie | 
| StoreCache(travelData)           | travelData: object                | bool             | Slaat data op in de cache en geeft aan of dit slaagt of faalt             | 
| CompareCache(travelData)         |  travelData: object               | bool | Controleert of de reisdata al bestaat in de cache | 

