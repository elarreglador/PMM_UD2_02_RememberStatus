package com.elarreglador.ud2_rememberstatus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elarreglador.ud2_material3theme.ui.theme.WonderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WonderTheme {
                InteractiveWidgetsDemo()
            }
        }
    }
}

@Composable
fun InteractiveWidgetsDemo() {
    var isSwitched by remember { mutableStateOf(false) }
    var isChecked by remember { mutableStateOf(false) }

    var isSwitchedSaveable by rememberSaveable { mutableStateOf(false) }
    var isCheckedSaveable by rememberSaveable { mutableStateOf(false) }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "rememberSaveable y remember",
                textAlign = TextAlign.Center
            )
        }
        item {
            Text(
                "     Las variables de estado y los witgets que las emplean pueden perder su valor " +
                        "actual si se vuelve a renderizar la vista, para evitarlo usaremos " +
                        "rememberSaveable en la declaracion de la variable estado"
            )
        }
        item {
            Text("     Puedes verificar funcionamiento activando estos widgets y girando el" +
                    " dispositivo, veras como las variables de estado se pierden con remember" +
                    " pero no con rememberSaveable")
            }

        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Switch(
                    checked = isSwitched,
                    onCheckedChange = { isSwitched = it }
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text("var isSwitched by remember { mutableStateOf(false) }")
            }
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it }
                )
                Text("var isChecked by remember { mutableStateOf(false) }")
            }
        }

        item {
            HorizontalDivider(thickness = 2.dp)
        }

        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Switch(
                    checked = isSwitchedSaveable,
                    onCheckedChange = { isSwitchedSaveable = it }
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text("var isSwitchedSaveable by rememberSaveable { mutableStateOf(false) }")
            }
        }

        item{
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isCheckedSaveable,
                    onCheckedChange = { isCheckedSaveable = it }
                )
                Text("var isCheckedSaveable by rememberSaveable { mutableStateOf(false) }")
            }
        }
    }
}


@Composable
@Preview
fun Previo(
){
    WonderTheme {
        InteractiveWidgetsDemo()
    }
}