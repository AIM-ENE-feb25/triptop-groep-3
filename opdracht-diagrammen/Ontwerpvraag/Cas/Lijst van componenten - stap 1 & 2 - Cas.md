# Lijst van componenten en verantwoordelijkheden

**Onderzoeksvraag**:
Wie roept een specifieke externe service aan, gebeurt dat vanuit de front-end of vanuit de back-end? Welke redenen zijn er om voor de ene of de andere aanpak te kiezen? (Interoperability)


| **Componentnaam**        | **Verantwoordelijkheid**                                                               |
|--------------------------|----------------------------------------------------------------------------------------|
| **AuthController**       | Ontvangt API-verzoeken van de client en roept de AuthService aan.                      |
| **AuthService**          | Bevat de business logic voor authenticatie en roept de juiste adapter aan.             |
| **iAuthProviderAdapter** | Verzorgt de communicatie met externe authenticatiediensten (Google, Microsoft, etc.).  |

### **1. AuthController**

De AuthController is verantwoordelijk voor het ontvangen van HTTP-verzoeken van de client en het doorsturen naar de AuthService.

| **Methode**  | **Parameters**                    | **Returnwaarde** | **Beschrijving**                                                              |
|--------------|-----------------------------------|------------------|-------------------------------------------------------------------------------|
| newAuthKey() | email: String                     | AuthResponse     | Vraagt een nieuwe authenticatiesleutel aan en retourneert deze aan de client. |
| verify()     | secretCode: String, token: String | AuthResponse     | Verifieert een ingevoerde code en geeft aan of deze correct is.               |

### **2. AuthService**

De AuthService verwerkt de business logic en bepaalt welke externe service gebruikt moet worden.

| **Methode**             | **Parameters**                     | **Returnwaarde** | **Beschrijving**                                                     |
|-------------------------|------------------------------------|------------------|----------------------------------------------------------------------|
| addNewUser()            | email: String                      | AuthResponse     | Roept de adapter aan om een nieuwe authenticatiesleutel op te halen. |
| validateSecret()        | secretCode: String, token: String  | AuthResponse     | Roept de adapter aan om te controleren of de code klopt.             |


### **3. iAuthProviderAdapter**

De iAuthProviderAdapter is een interface die de structuur definieert voor alle externe authenticatieadapters (bijv. Google, Microsoft).

| **Methode**                | **Parameters**                      | **Returnwaarde** | **Beschrijving**                                              |
|----------------------------|-------------------------------------|------------------|---------------------------------------------------------------|
| callService()              | serviceId: String, payload: String  | String           | Roept de externe API aan en retourneert de response als JSON. |
| mapResponseToDomainModel() | response: String, serviceId: String | AuthResponse     | Zet de JSON-response om naar een AuthResponse object.         |

