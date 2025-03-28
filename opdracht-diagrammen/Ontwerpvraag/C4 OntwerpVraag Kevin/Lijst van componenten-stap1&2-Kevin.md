Title Hoe beheer je veilig de interactie met verouderde externe APIs die geen moderne beveiligingsprotocollen ondersteunen?

## Lijst van Componenten en hun verantwoordelijkheid
| **Componentnaam**     | **Type**          | **Technologie**                     | **Verantwoordelijkheid**                                                   |
|----------------------|------------------|-------------------------------------|---------------------------------------------------------------------------|
| **Backend**          | REST API         | Node.js / Spring Boot              | Verwerkt bedrijfslogica en beheert communicatie met externe diensten.    |
| **Security Proxy**   | Proxy Service    | Nginx / Envoy / Custom Middleware  | Beveiligt en filtert API-verzoeken naar verouderde externe services.     |
| **Booking API**      | Externe service  | Booking.com / Airbnb API           | Verwerkt accommodatieboekingen.                                          |
| **Transport API**    | Externe service  | NS / Deutsche Bahn / KLM API       | Biedt reisopties voor trein- en luchtvervoer.                             |
| **Car Rental API**   | Externe service  | Sixt / Hertz API                   | Verzorgt autoverhuur.                                                    |
| **Activities API**   | Externe service  | Tripadvisor / GetYourGuide API     | Biedt activiteiten en excursies.                                        |
| **Food API**         | Externe service  | Takeaway / Eet.nu API              | Faciliteert maaltijdbezorging en restaurantreserveringen.                |

De Identity Provider wordt niet meegenomen omdat deze veilig moet zijn. 


## Interfaces per component

### 1. Backend → Security Proxy
📌 **Interface:** `SecureIntegrationAPI`  
🔹 **Doel:** Backend communiceert via de Security Proxy met externe diensten.

| **Methode** | **Pad**                      | **Parameters (JSON body / query params)** | **Return (JSON)** |
|------------|------------------------------|--------------------------------|---------------------------------------------|
| `GET`      | `/secure/transport/search`   | `origin, destination, date`    | `{ trips: [{ id, price, duration }] }`     |
| `POST`     | `/secure/booking/create`     | `{ userId, tripId, payment }`  | `{ bookingId, status }`                    |
| `GET`      | `/secure/cars/search`        | `location, date`               | `{ cars: [{ id, type, pricePerDay }] }`    |
| `GET`      | `/secure/activities/search`  | `city, date`                   | `{ activities: [{ id, name, price }] }`    |
| `GET`      | `/secure/food/search`        | `city, cuisine`                | `{ restaurants: [{ id, name, rating }] }`  |

---

### 2. Security Proxy → Externe API’s
📌 **Interface:** `LegacyAPIAdapter`  
🔹 **Doel:** Transformeert en beveiligt API-verzoeken naar legacy systemen.

| **Methode** | **Pad**                | **Parameters**                | **Return** |
|------------|------------------------|------------------------------|--------------------------------------|
| `GET`      | `/ns/trips`            | `origin, destination, date` | `{ trains: [{ id, cost, time }] }`  |
| `POST`     | `/booking/create`      | `{ tripId, customerData }`   | `{ refNumber, confirmation }`       |
| `GET`      | `/cars/available`      | `location, date`             | `{ cars: [{ id, type, cost }] }`    |
| `GET`      | `/activities/options`  | `city, date`                 | `{ events: [{ id, title, price }] }` |
| `GET`      | `/food/restaurants`    | `city, cuisine`              | `{ places: [{ id, name, rating }] }` |

---