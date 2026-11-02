package com.example.teamlist.data

import com.example.teamlist.R
import com.example.teamlist.model.Team

class Datasource {
    fun loadTeams(): List<Team> {
        return listOf(
            Team(R.string.team1, R.drawable.team1),
            Team(R.string.team2, R.drawable.team2),
            Team(R.string.team3, R.drawable.team3),
            Team(R.string.team4, R.drawable.team4),
            Team(R.string.team5, R.drawable.team5),
            Team(R.string.team6, R.drawable.team6),
            Team(R.string.team7, R.drawable.team7),
            Team(R.string.team8, R.drawable.team8),
            Team(R.string.team9, R.drawable.team9),
            Team(R.string.team10, R.drawable.team10),
            Team(R.string.team11, R.drawable.team11),
            Team(R.string.team12, R.drawable.team12),
            Team(R.string.team13, R.drawable.team13),
            Team(R.string.team14, R.drawable.team14),
            Team(R.string.team15, R.drawable.team15),
            Team(R.string.team16, R.drawable.team16)
        )
    }
}