package co.simplon.pigeongamer.pigeongamer.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.pigeongamer.pigeongamer.model.Historical;
import co.simplon.pigeongamer.pigeongamer.model.Supplier;
import co.simplon.pigeongamer.pigeongamer.repository.HistoricalRepository;
import co.simplon.pigeongamer.pigeongamer.repository.SupplierRepository;

@Service
public class HistoricalServiceImpl implements HistoricalService {

	@Autowired
	private HistoricalRepository historicalRepository;

	@Override
	public List<Historical> getAllHistorical() {
		return historicalRepository.findAll();
	}

	@Override /* NEW */
	public void saveHistorical(Historical historical) {
		this.historicalRepository.save(historical);
	}

	@Override
	public Historical getHistoricalById(long id_historical) {
		Optional<Historical> optional = historicalRepository.findById(id_historical);
		Historical historical = null;
		if (optional.isPresent()) {
			historical = optional.get();
		} else {
			throw new RuntimeException(" Product not found for id :: " + id_historical);
		}
		return historical;
	}

	@Override
	public void deleteHistoricalById(long id_historical) {
		this.historicalRepository.deleteById(id_historical);
	}

}
