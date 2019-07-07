package de.hegmanns.tdd.task10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CurrencyDto {

	public BigDecimal getExchangeRate(String currencyFrom, String currencyTo) {
		
		// ok, equal currencies result in 1
		if (currencyFrom.equals(currencyTo)) {
			return BigDecimal.ONE;
		}
		// here is the lookup ... a little accidental
		// here we simulate half day change of exchange rate
		String fileName = buildNamingCheme(currencyFrom, currencyTo);
		ExchangeRate exchangeRate = loadExchangeRate(fileName).orElse(createRandomRate(currencyFrom, currencyTo));
		if (!isInTime(exchangeRate)) {
			exchangeRate = makeLittleDifference(exchangeRate);
		}
		deleteFile(fileName);
		serializeExchangeRate(exchangeRate);
		
		if (exchangeRate.getFrom().equals(currencyFrom)) {
			return exchangeRate.getExchangeRate();
		}else {
			return BigDecimal.ONE.divide(exchangeRate.getExchangeRate(), 4, RoundingMode.HALF_DOWN);
//			return BigDecimal.ONE.divide(exchangeRate.getExchangeRate(), RoundingMode.HALF_DOWN);
		}
	}
	
	// these methods here are only for simulate change of exchange rates
	
	private boolean isInTime(ExchangeRate rate) {
		return rate.getTime().isAfter(LocalDateTime.now().minusMinutes(1));
	}
	private String buildNamingCheme(String currencyFrom, String currencyTo) {
		return Stream.of(currencyFrom, currencyTo)
			.sorted().collect(Collectors.joining("_")) + ".dat";
	}
	
	private Optional<ExchangeRate> loadExchangeRate(String filename) {
		ExchangeRate rate = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(filename)))) {
			rate = (ExchangeRate)ois.readObject();
		}catch(Exception e) {
			
		}
		return Optional.ofNullable(rate);
	}
	
	private void serializeExchangeRate(ExchangeRate rate) {
		String fileName = buildNamingCheme(rate.getFrom(), rate.getTo());
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fileName)))){
			oos.writeObject(rate);
		} catch (IOException e) {
		}
	}
	
	private void deleteFile(String filename) {
		File file = new File(filename);
		if (file.exists() && file.isFile()) {
			file.delete();
		}
	}
	
	private ExchangeRate createRandomRate(String from, String to) {
		return new ExchangeRate(from, to, new BigDecimal(Math.random()*100));
	}
	
	private ExchangeRate makeLittleDifference(ExchangeRate currentEchangeRate) {
		return new ExchangeRate(currentEchangeRate, new BigDecimal(Math.random() - 0.5));
	}
}
