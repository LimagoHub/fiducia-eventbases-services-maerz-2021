package de.fiducia.kreditantragservice.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import de.fiducia.kreditantragservice.models.KreditAntrag;
import de.fiducia.kreditantragservice.repositories.KreditAntragRepository;

@Service
@Transactional
public class KreditAntragServiceImpl implements KreditAntragService {
	
	private final KreditAntragRepository repo;

	public KreditAntragServiceImpl(KreditAntragRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public int positivScoreReceived(String id) {
		KreditAntrag antrag = repo.findById(id).orElseThrow(()->new RuntimeException("Ein Fehler ist aufgetreten!"));
		antrag.setScoringState("Ok");
		
		if(antrag.getCityCheckState().equals("OK")) {
			antrag.setApplicationState("Genehmigt");
			return 1;
		} 
		if(antrag.getCityCheckState().equals("Denied") ) {
			antrag.setApplicationState("Abgelehnt");
			return 2;
		}
		
		return 0;
	}

}
