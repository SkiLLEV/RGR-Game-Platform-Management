package project.lab3.service;

import project.lab3.models.Platform;
import project.lab3.repository.PlatformRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlatformService {
    private final PlatformRepository repository;

    public PlatformService(PlatformRepository repository) {
        this.repository = repository;
    }

    public void addPlatform(String name, String manufacturer) {
        repository.saveSecure(name, manufacturer);
    }

    public void deletePlatform(int id) {
        repository.delete(id);
    }

    public List<Platform> getAllPlatforms() {
        return repository.findAll();
    }
}