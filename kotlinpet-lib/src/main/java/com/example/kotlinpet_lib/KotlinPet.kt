package com.example.kotlinpet_lib

class MyClass {
}

// La función main es el punto de entrada: Kotlin empieza aquí.
fun main() {
    ejercicio1()
    ejercicio2()
    ejercicio3()
    ejercicio4()
    ejercicio5()
}

// ------------------------------------------------------------
// EJERCICIO 1: val, var, tipos explícitos e interpolación
// ------------------------------------------------------------
fun ejercicio1() {
    println("===== EJERCICIO 1 =====")

    // val = variable INMUTABLE (no se puede reasignar después)
    val nombre: String = "Max"       // texto
    val sexo: Char = 'M'             // un solo carácter, entre comillas simples

    // var = variable MUTABLE (su valor puede cambiar)
    var edad: Int = 3                // número entero
    var peso: Float = 12.5f          // decimal; la "f" indica que es Float
    var vacunado: Boolean = false    // verdadero o falso

    // Simulamos que la mascota cumplió un año y subió de peso
    edad = edad + 1                  // también se puede escribir edad++
    peso = 13.2f
    vacunado = true

    // Plantilla de interpolación: $variable inserta su valor dentro del texto
    println("Ficha -> Nombre: $nombre | Sexo: $sexo | Edad: $edad años | Peso: $peso kg | Vacunado: $vacunado")

    // nombre = "Rex"  // <- esto daría ERROR porque nombre es val
}

// ------------------------------------------------------------
// EJERCICIO 2: when, operadores de comparación y lógicos
// ------------------------------------------------------------
fun ejercicio2() {
    println("\n===== EJERCICIO 2 =====")

    val edad: Int = 9
    val esUrgencia: Boolean = false

    // when evalúa "edad" y elige la primera rama que coincida
    val categoria: String = when (edad) {
        in 0..1 -> "Cachorro"        // "in 0..1" significa de 0 a 1 (incluidos)
        in 2..7 -> "Adulto"          // de 2 a 7
        in 8..Int.MAX_VALUE -> "Senior"  // de 8 en adelante
        else -> "Edad no válida"     // cualquier otro caso (ej. negativos)
    }
    println("Categoría de la mascota: $categoria")

    // || significa "o": basta con que UNA condición sea verdadera
    // == compara si dos valores son iguales
    if (esUrgencia || categoria == "Senior") {
        println("Prioridad Alta")
    } else {
        println("Atención Regular")
    }
}

// ------------------------------------------------------------
// EJERCICIO 3: listas, bucle for y rangos
// ------------------------------------------------------------
fun ejercicio3() {
    println("\n===== EJERCICIO 3 =====")

    // listOf crea una lista INMUTABLE (no se pueden agregar ni quitar elementos)
    val mascotas = listOf("Max", "Luna", "Toby", "Mia")

    // Variable que lleva la cuenta del turno
    var turno = 1

    // for recorre cada elemento de la lista, uno por uno
    for (mascota in mascotas) {
        println("Turno $turno: $mascota")
        turno++                      // sumamos 1 para el siguiente paciente
    }

    // Cuenta regresiva con downTo (del 5 al 1, ambos incluidos)
    println("La clínica abre en:")
    for (minuto in 5 downTo 1) {
        println("$minuto minutos")
    }
    println("¡Clínica abierta!")

    // Otros rangos, como ejemplo:
    // 1..5        -> 1,2,3,4,5      (inclusivo)
    // 1 until 5   -> 1,2,3,4        (excluye el final)
    // 1..10 step 2 -> 1,3,5,7,9     (salta de 2 en 2)
}

// ------------------------------------------------------------
// EJERCICIO 4: tipos nulables, llamada segura y operador Elvis
// ------------------------------------------------------------
fun ejercicio4() {
    println("\n===== EJERCICIO 4 =====")

    // El "?" después de String permite que la variable valga null
    val contactoEmergencia: String? = null

    // ?. es la llamada segura: si es null NO falla, simplemente devuelve null
    val cantidadCaracteres: Int? = contactoEmergencia?.length
    println("Caracteres del contacto: $cantidadCaracteres")  // imprime null

    // ?: es el operador Elvis: si lo de la izquierda es null, usa lo de la derecha
    val contactoFinal: String = contactoEmergencia ?: "Sin contacto registrado"
    println("Contacto final: $contactoFinal")
}

// ------------------------------------------------------------
// EJERCICIO 5: lambdas y forEach con it
// ------------------------------------------------------------
fun ejercicio5() {
    println("\n===== EJERCICIO 5 =====")

    // Lista con los precios base: consulta, baño y desparasitación
    val precios = listOf(50000.0, 30000.0, 25000.0)

    // Lambda: función sin nombre guardada en una variable.
    // { valor: Double -> ... } recibe un Double y devuelve el resultado
    // de la última línea (precio + 10% de recargo nocturno).
    val recargoNocturno = { precio: Double -> precio * 1.10 }

    // forEach ejecuta el bloque para cada elemento de la lista.
    // "it" es el nombre implícito del elemento actual.
    precios.forEach {
        println("Precio original: $it | Precio nocturno: ${recargoNocturno(it)}")
    }
}