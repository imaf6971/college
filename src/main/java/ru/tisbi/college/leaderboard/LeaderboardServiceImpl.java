package ru.tisbi.college.leaderboard;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LeaderboardServiceImpl implements LeaderboardService {

    @Override
    public List<GroupRanking> getLeaderboard() {
        return List.of(
            new GroupRanking(1, "Туристы 191.2"),
            new GroupRanking(2, "Экономисты 202.1")
        );
    }

}
