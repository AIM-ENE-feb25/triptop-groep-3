package nl.han.se.solex.triptop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TriptopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriptopApplication.class, args);
//		BetalingController controller = new BetalingController();
//
//		// ⚡️ 1. Betaal via PayPal
//		BetalingInfo paypalInfo = new BetalingInfo(49.99, "Lidmaatschap");
//		Object paypalResult = controller.betaal(paypalInfo, BetaalType.PAYPAL);
//		System.out.println("=== PayPal Resultaat ===");
//		System.out.println(paypalResult);
//
//		// 📄 2. Betaal via Factuur
//		BetalingInfo factuurInfo = new BetalingInfo(129.95, "Consulting dienst");
//		Object factuurResult = controller.betaal(factuurInfo, BetaalType.FACTUUR);
//
//		if (factuurResult instanceof FactuurInfo fi) {
//			System.out.println("\n=== Factuur Info ===");
//			System.out.println("Factuurnummer: " + fi.getFactuurNummer());
//			System.out.println("Datum: " + fi.getDatum());
//			System.out.println("Rekeningnummer: " + fi.getRekeningNummer());
//			System.out.println("T.n.v.: " + fi.getTenNameVan());
//			System.out.println("Bedrag: €" + fi.getBedrag());
//			System.out.println("Omschrijving: " + fi.getOmschrijving());
//			System.out.println(factuurResult);
	}
}

