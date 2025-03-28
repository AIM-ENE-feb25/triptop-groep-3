# Lijst van componenten en verantwoordelijkheden

**Onderzoeksvraag**:
Wie roept een specifieke externe service aan, gebeurt dat vanuit de front-end of vanuit de back-end? Welke redenen zijn er om voor de ene of de andere aanpak te kiezen? (Interoperability)


| **Componentnaam**                     | **Verantwoordelijkheid**                                                                                                                                             |
| ------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Frontend**                          | Biedt de gebruikersinterface en verwerkt gebruikersinteracties. Kan API-aanroepen naar de backend doen en resultaten tonen.                                          |
| **Backend**                           | Ontvangt verzoeken van de frontend, verwerkt data en roept externe services aan. Biedt een beveiligde en consistente interface voor de frontend.                     |
| **External Service Adapter**          | Vat de communicatie met externe services samen (bijv. betalingsproviders, identity providers). Zorgt voor een stabiele interface, zelfs als externe APIs veranderen. |
| **Database Service**                  | Slaat gegevens op die nodig zijn voor caching, gebruikerssessies of boekingen. Zorgt voor dataconsistentie en efficiëntie.                                           |
| **Authentication & Security Service** | Beheert authenticatie en autorisatie. Zorgt voor veilige API-toegang en validatie van gebruikersrechten.                                                             |

### **1. User Interface (Frontend API)**

Biedt een interface voor de gebruiker om acties uit te voeren en gegevens op te halen.

**Interface: FrontendService**

| **Methode**               | **Parameters**    | **Returnwaarde** | **Beschrijving**                                          |
| ------------------------- | ----------------- | ---------------- | --------------------------------------------------------- |
| fetchAvailableServices()  | -                 | Service[]        | Haalt een lijst op van beschikbare externe services.      |
| requestService(serviceId) | serviceId: string | Response         | Vraagt een specifieke externe service aan via de backend. |
| getUserSession()          | -                 | SessionData      | Haalt de sessiegegevens van de gebruiker op.              |

### **2. API Gateway / Backend API**

Faciliteert communicatie tussen frontend en externe services via een consistente API.

**Interface: BackendAPI**

| **Methode**                              | **Parameters**                    | **Returnwaarde** | **Beschrijving**                                                      |
| ---------------------------------------- | --------------------------------- | ---------------- | --------------------------------------------------------------------- |
| getAvailableServices()                   | -                                 | Service[]        | Geeft een lijst van ondersteunde externe services.                    |
| processServiceRequest(serviceId, userId) | serviceId: string, userId: string | Response         | Verwerkt een serviceaanvraag en roept de juiste externe service aan.  |
| authenticateUser(token)                  | token: string                     | UserData         | Controleert en retourneert gebruikersgegevens als de token geldig is. |


### **3. External Service Adapter**

Encapsuleert de communicatie met externe services en maakt deze onafhankelijk van hun implementatie.

**Interface: ExternalServiceAdapter**

| **Methode**                        | **Parameters**                     | **Returnwaarde** | **Beschrijving**                                                  |
| ---------------------------------- | ---------------------------------- | ---------------- | ----------------------------------------------------------------- |
| callService(serviceId, payload)    | serviceId: string, payload: object | ServiceResponse  | Roept een externe service aan en retourneert het resultaat.       |
| mapResponseToDomainModel(response) | response: object                   | DomainModel      | Converteert de externe service respons naar een intern datamodel. |


### **4. Database Service**

Beheert persistente opslag van relevante gegevens zoals gebruikerssessies en service-aanvragen.

**Interface: DatabaseService**

| **Methode**                                   | **Parameters**                                    | **Returnwaarde** | **Beschrijving**                                                |
| --------------------------------------------- | ------------------------------------------------- | ---------------- | --------------------------------------------------------------- |
| saveServiceRequest(userId, serviceId, status) | userId: string, serviceId: string, status: string | boolean          | Slaat een serviceaanvraag op en geeft aan of dit succesvol was. |
| getUserSession(userId)                        | userId: string                                    | SessionData      | Haalt sessiegegevens van een gebruiker op.                      |
| updateServiceStatus(requestId, status)        | requestId: string, status: string                 | boolean          | Wijzigt de status van een serviceaanvraag.                      |

### **5. Authentication & Security Service**

Beheert authenticatie en autorisatie voor gebruikers en API-aanroepen.

**Interface: AuthService**

| **Methode**                      | **Parameters**                 | **Returnwaarde** | **Beschrijving**                                                    |
| -------------------------------- | ------------------------------ | ---------------- | ------------------------------------------------------------------- |
| validateToken(token)             | token: string                  | UserData         | Valideert een authenticatietoken en retourneert gebruikersgegevens. |
| checkPermissions(userId, action) | userId: string, action: string | boolean          | Controleert of de gebruiker de juiste rechten heeft voor een actie. |
