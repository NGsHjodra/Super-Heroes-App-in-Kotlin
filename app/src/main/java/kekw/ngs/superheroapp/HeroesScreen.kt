package kekw.ngs.superheroapp

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kekw.ngs.superheroapp.model.Hero

@Composable
fun HeroIcon(
    @DrawableRes heroIcon: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .clip(MaterialTheme.shapes.small)
    ) {
        Image(
            painter = painterResource(heroIcon),
            contentDescription = null
        )
    }

}

@Composable
fun HeroInfo(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Column (modifier = modifier){
        Text(
            text = stringResource(hero.nameRes),
            style = MaterialTheme.typography.displaySmall,
        )
        Text(
            text = stringResource(hero.descriptionRes),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}


@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
){
    Card(modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
                .size(dimensionResource(R.dimen.image_size))
        ) {
            HeroInfo(hero = hero, modifier = Modifier.weight(1f))
            Spacer(Modifier.width(dimensionResource(R.dimen.padding_medium)))
            HeroIcon(hero.imageRes)
        }
    }
}

