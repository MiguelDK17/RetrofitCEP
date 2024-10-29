package com.migueldev.retrofitcep

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class CepVisualTransformation: VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        //Remove qualquer traço para começar com apenas números
        val onlyDigits = text.text.filter { it.isDigit() }

        //Aplica a máscara de CEP
        val maskedText = buildString {
            for (i in onlyDigits.indices){
                if (i == 5) append('-') //Adiciona um traço ao atingir 5 caracteres na máscara
                append(onlyDigits[i])
            }
        }
        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int = offset + if (offset > 5) 1 else 0
            override fun transformedToOriginal(offset: Int): Int = if (offset > 5) 1 else 0

        }
        return TransformedText(AnnotatedString(maskedText), offsetMapping)
    }
}