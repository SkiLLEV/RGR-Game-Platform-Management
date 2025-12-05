package project.lab3.service;

import project.lab3.models.Game;
import project.lab3.repository.GameRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameService {
    private final GameRepository repository;
    public GameService(GameRepository repository) {
        this.repository = repository;
    }
    public void addGame(String title, double price, int platformId) {
        repository.save(title, price, platformId);
    }
    public void deleteGame(int id) {
        repository.delete(id);
    }
    public List<Game> getAllGames() {
        return repository.findAll();
    }
}