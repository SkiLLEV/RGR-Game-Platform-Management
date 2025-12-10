package project.lab3.controllers;

import project.lab3.service.GameService;
import project.lab3.service.PlatformService;
import project.lab3.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlatformController {
    private final PlatformService platformService;
    private final GameService gameService;
    private final ReviewService reviewService;

    public PlatformController(PlatformService platformService,
                              GameService gameService, ReviewService reviewService) {
        this.platformService = platformService;
        this.gameService = gameService;
        this.reviewService = reviewService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("platforms", platformService.getAllPlatforms());
        model.addAttribute("games", gameService.getAllGames());
        model.addAttribute("reviews", reviewService.getAllReviews()); // Передаємо відгуки на сторінку
        return "index";
    }

    // Платформи
    @PostMapping("/add")
    public String addPlatform(@RequestParam String name, @RequestParam String manufacturer) {
        platformService.addPlatform(name, manufacturer);
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String deletePlatform(@RequestParam int id) {
        platformService.deletePlatform(id);
        return "redirect:/";
    }

    // Ігри
    @PostMapping("/addGame")
    public String addGame(@RequestParam String title, @RequestParam double price,
                          @RequestParam int platformId) {
        gameService.addGame(title, price, platformId);
        return "redirect:/";
    }
    @PostMapping("/deleteGame")
    public String deleteGame(@RequestParam int id) {
        gameService.deleteGame(id);
        return "redirect:/";
    }

    // Відгуки
    @PostMapping("/addReview")
    public String addReview(@RequestParam String author,
                            @RequestParam String text, @RequestParam int gameId) {
        reviewService.addReview(author, text, gameId);
        return "redirect:/";
    }
    @PostMapping("/deleteReview")
    public String deleteReview(@RequestParam int id) {
        reviewService.deleteReview(id);
        return "redirect:/";
    }
}