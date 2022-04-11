package ru.tisbi.college.leaderboard;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/leaderboard")
public class LeaderboardController {

    
    public record RatingPosition(Integer place, String title) {}

    @GetMapping
    public String getLeaderboard(Model model) {
        model.addAttribute("leaderboard", List.of(
            new RatingPosition(1, "Туристы 191.2"),
            new RatingPosition(2, "Экономисты 202.1")
        ));
        return "leaderboard";
    }

}
