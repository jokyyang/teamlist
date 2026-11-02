package com.example.teamlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.teamlist.data.Datasource
import com.example.teamlist.model.Team
import com.example.teamlist.ui.theme.TeamlistTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TeamlistTheme {
                TeamsApp()
            }
        }
    }
}

@Composable
fun TeamsApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        TeamList(
            teamList = Datasource().loadTeams(),
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun TeamList(teamList: List<Team>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(teamList) { team ->
            TeamCard(
                team = team,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
}

@Composable
fun TeamCard(team: Team, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(team.imageResourceId),
                contentDescription = stringResource(team.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(team.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamListPreview() {
    TeamlistTheme {
        TeamList(teamList = Datasource().loadTeams())
    }
}