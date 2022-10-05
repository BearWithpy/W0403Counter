package kr.ac.kumoh.s20180488.w0403counter

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.runtime.*

import kr.ac.kumoh.s20180488.w0403counter.ui.theme.W0403CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Column() {
                    Counter()
                    Counter()
                }
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    W0403CounterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}

@Composable
fun Counter() {
    var count by remember {
        mutableStateOf(0)
    }
//    var (count, setCount) = remember {
//        mutableStateOf(0)
//    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =Arrangement.Center,
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = "$count",
            fontSize = 150.sp,
            modifier = Modifier.padding(50.dp)
        )
        Row{
            Button(
                modifier = Modifier
                    .weight(1f)
                    
                ,
                onClick = {
                    count++
                    Log.i("Counter value: ", count.toString())
                }
            ) {
                Text(text = "증가", fontSize = 30.sp)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                modifier = Modifier
                    .weight(1f)
                ,
                onClick = {
                    if (count > 0) count--
                    Log.i("Counter value: ", count.toString())
                }
            ) {
                Text(text = "감소", fontSize = 30.sp)
            }

        }


    }


}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    W0403CounterTheme {
        MyApp {
            Counter()
        }
    }
}