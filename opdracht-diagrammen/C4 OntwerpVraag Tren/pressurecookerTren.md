- Hoe zorg je ervoor dat je bij een wijziging in de datastructuur van een externe service niet de hele applicatie hoeft aan te passen?

zelf:

stap 1

Component moet misschien client worden voor de verschillende componenten die praten met externe API’s? een client is vaak verantwoordelijk voor communicatie met externen.

| Component | Verantwoordelijkheid |
| --- | --- |
| Travel plans Repository | beheert reisplannen |
| Travel Service | verwerkt reisaanvragen |
| Car Rental/Travel Guide/Hotel/Dining Options/ Travel Methods/E-mail Component | Gebruikt externe API om data op te halen. De data is verschillend maar de essentie van deze componenten is hetzelfde |
| Travel API Mapper | verantwoordelijk voor het mappen van externe data naar interne modellen. |

stap 2

```java
public interface TravelService {
TravelPlan getTravelPlan(string userId)
```

```java
public interface TravelPlansRepository {
Optional<TravelPlan> findByUserId(String UserID);
void save(TravelPlan plan);
```

```java
public interface CarRentalClient {
    ExternalCarRentalResponse fetchCarOptions(String location);
}

public interface TravelGuideClient {
    ExternalActivityResponse fetchActivities(String destination);
}

public interface HotelClient {
    ExternalHotelResponse fetchHotels(String destination);
}

public interface DiningOptionsClient {
    ExternalDiningResponse fetchDiningOptions(String destination);
}

public interface TravelMethodsClient {
    ExternalTransportResponse fetchTransportOptions(String from, String to);
}

public interface EmailClient {
    void sendBookingConfirmation(TripConfirmation confirmation);
}
```

```java
public interface TravelApiMapper {
    CarRental mapToDomain(ExternalCarRentalResponse response);
    Hotel mapToDomain(ExternalHotelResponse response);
    Activity mapToDomain(ExternalActivityResponse response);
    DiningOption mapToDomain(ExternalDiningResponse response);
    TransportOption mapToDomain(ExternalTransportResponse response);
}
```

stap 3

zie repo voor duidelijke uitwerking

```java
1.  Gebruiker 
2.  → TravelController.getTravelPlan(userId)
3.  → TravelService.getTravelPlan(userId)
4.  → TravelPlansRepository.findByUserId(userId)

5.  (Geen plan gevonden → nieuwe data ophalen)

6.  → CarRentalClient.fetchCarOptions(location)
7.  → TravelApiMapper.mapToDomain(ExternalCarRentalResponse)

8.  → HotelClient.fetchHotels(destination)
9.  → TravelApiMapper.mapToDomain(ExternalHotelResponse)

10. → TravelGuideClient.fetchActivities(destination)
11. → TravelApiMapper.mapToDomain(ExternalActivityResponse)

12. → DiningOptionsClient.fetchDiningOptions(destination)
13. → TravelApiMapper.mapToDomain(ExternalDiningResponse)

14. → TravelMethodsClient.fetchTransportOptions(from, to)
15. → TravelApiMapper.mapToDomain(ExternalTransportResponse)

16. → TravelPlansRepository.save(TravelPlan)

17. → TravelService geeft TravelPlan terug aan TravelController
18. → TravelController stuurt TravelPlan naar de gebruiker
```

stap 4