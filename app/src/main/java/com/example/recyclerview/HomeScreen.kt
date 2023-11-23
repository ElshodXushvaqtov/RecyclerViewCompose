package com.example.recyclerview

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.recyclerview.module.ItemData
import com.example.recyclerview.navigation.Screens

@Composable
fun HomeScreen(navController: NavHostController) {
    val itemList = remember { itemsList() }

    LazyVerticalGrid(

        GridCells.Fixed(2)

    ) {

        items(itemList) {
            Item(it, navController)
        }

    }

}

@Composable
fun Item(itemData: ItemData, navController: NavHostController) {
    var isClicked by remember {
        mutableStateOf(false)
    }

    val painterResource: Painter = if (isClicked) {
        painterResource(id = R.drawable.baseline_favorite_24)
    } else {
        painterResource(id = R.drawable.baseline_favorite_border_24)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Box(Modifier.clickable {

            navController.navigate(
                route = Screens.Details.getFullRoute(
                    id = itemData.id
                )
            )

        }) {

            Image(
                painter = painterResource(id = itemData.imageRes),
                contentDescription = null,
                Modifier
                    .width(180.dp)
            )
            IconButton(
                onClick = { isClicked = !isClicked },
                Modifier.align(Alignment.TopEnd)
            ) {

                Image(
                    painter = painterResource,
                    contentDescription = null
                )

            }
        }
        Text(text = itemData.description)
        Spacer(modifier = Modifier.height(15.dp))
        Row(horizontalArrangement = Arrangement.Center) {

            Text(text = "$${itemData.price}", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = itemData.price,
                textDecoration = TextDecoration.LineThrough,
                style = TextStyle(

                    color = Color(0xFF747474)

                )
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "20% OFF", style = TextStyle(

                    color = Color(0xFFFF6500)

                )
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(horizontalArrangement = Arrangement.Center) {

            Image(
                painterResource(id = R.drawable.star),
                contentDescription = null,
                modifier = Modifier
                    .height(22.dp)
                    .padding(end = 5.dp)
            )
            Text(text = "4.1")
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "(87)", style = TextStyle(

                    color = Color(0xFF747474)

                )
            )

        }

    }

}

fun itemsList(): MutableList<ItemData> {
    val itemList: MutableList<ItemData> = mutableListOf()
    itemList.add(ItemData(1, "1", "$10", R.drawable.img))
    itemList.add(ItemData(2, "2", "$20", R.drawable.img_1))
    itemList.add(ItemData(3, "3", "$30", R.drawable.img_2))
    itemList.add(ItemData(4, "4", "$40", R.drawable.img_3))
    itemList.add(ItemData(5, "5", "$50", R.drawable.img_4))
    itemList.add(ItemData(6, "6", "$60", R.drawable.img_5))
    itemList.add(ItemData(7, "7", "$70", R.drawable.img_6))
    itemList.add(ItemData(8, "8", "$80", R.drawable.img_7))
    itemList.add(ItemData(9, "9", "$90", R.drawable.img_8))
    itemList.add(ItemData(10, "10", "$100", R.drawable.img_9))

    return itemList
}

