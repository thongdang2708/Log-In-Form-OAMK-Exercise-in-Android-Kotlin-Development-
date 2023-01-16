package com.example.loginform

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginform.ui.theme.LoginFormTheme
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import com.example.loginform.ui.theme.Purple200
import java.time.format.TextStyle


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   LoginForm()
                }
            }
        }
    }
}

@Composable
fun LoginForm () {
    var username = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }

    var passwordVisible = remember {
        mutableStateOf(false)
    }



    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = "Login Form",
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
            style = androidx.compose.ui.text.TextStyle(fontWeight = FontWeight.Bold)
        )
        OutlinedTextField(value = username.value,
            onValueChange = {username.value = it},
            singleLine = true,
            label = { Text(text = "Username")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple200,
                unfocusedBorderColor = Color.Black
            ),
            trailingIcon = {
                androidx.compose.material.Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
            }
            )
        OutlinedTextField(
            value = password.value,
            onValueChange = {password.value = it},
            label = { Text(text = "Password")},
            singleLine = true,

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple200,
                unfocusedBorderColor = Color.Black
            ),
            trailingIcon = {
                val image = if (passwordVisible.value) R.drawable.ic_baseline_password_24 else R.drawable.ic_baseline_remove_red_eye_24

                val description = if (passwordVisible.value) "Hide password" else "Show password";

                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    androidx.compose.material.Icon(painter = painterResource(id = image), contentDescription = description)
                }
            },
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()

        )
        Button(onClick = {
              println(true)
        },
            modifier = Modifier.fillMaxWidth()
            ) {
            Text(text = "Submit")
        }

    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginFormTheme {
        LoginForm()
    }
}
