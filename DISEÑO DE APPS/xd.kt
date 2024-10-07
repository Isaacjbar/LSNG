// ===========================
// Variables y Tipos de Datos
// ===========================

// 'val' es para declarar una variable inmutable (similar a 'final' en Java).
// Esta variable no se puede reasignar una vez que tiene un valor.
val nombre: String = "Alan" // 'nombre' es el nombre de la variable, 'String' es el tipo, y "Alan" es el valor asignado.

// 'var' es para declarar una variable mutable, lo que significa que su valor puede cambiar.
var edad: Int = 25 // 'edad' es el nombre de la variable, 'Int' (entero) es el tipo, y 25 es el valor asignado.

// Las variables que pueden ser nulas deben tener el sufijo "?" después del tipo de dato.
// Esto permite que el valor de la variable sea nulo en algún momento, algo útil para evitar errores de NullPointerException.
var apellido: String? = null // 'apellido' es el nombre, 'String?' indica que puede ser nulo, y se inicializa como 'null'.

// ===========================
// Funciones en Kotlin
// ===========================

// Una función se declara con la palabra clave 'fun'.
// Entre paréntesis, van los parámetros que la función acepta.
// Después de los dos puntos (':'), va el tipo de dato que la función va a retornar.

// Aquí, la función 'suma' acepta dos parámetros 'a' y 'b' de tipo Int (entero) y devuelve un valor de tipo Int.
fun suma(a: Int, b: Int): Int { 
    // 'a' y 'b' son los nombres de los parámetros, ambos de tipo Int.
    return a + b // La función devuelve la suma de 'a' y 'b'.
}

// Las funciones también pueden ser expresiones lambda, es decir, funciones anónimas más concisas.
val resta = { a: Int, b: Int -> a - b } // 'a' y 'b' son parámetros de tipo Int, y se retorna la resta de ambos.

// Función que no retorna ningún valor (similar a 'void' en Java).
fun saludar(): Unit { // 'Unit' es el equivalente a 'void', y puede omitirse.
    println("Hola, bienvenido a Kotlin") // La función imprime un saludo.
}

// ===========================
// Estructuras de Control
// ===========================

// 'if' en Kotlin puede usarse de dos maneras:

// 1. Como expresión, asignando el resultado del if a una variable.
val max = if (a > b) a else b // Si 'a' es mayor que 'b', 'max' será 'a', de lo contrario, será 'b'.

// 2. Como en Java, sin necesidad de asignarlo a una variable. 
// Esto es equivalente al uso común de 'if' en Java.
if (a > b) {
    println("a es mayor que b")
} else {
    println("a es menor o igual a b")
}

// 'when' es similar a 'switch' en Java, pero más flexible.
fun evaluarNumero(x: Int) {
    when (x) { // 'x' es el valor que se evalúa
        1 -> println("x es 1") // Si 'x' es 1, se imprime "x es 1"
        2 -> println("x es 2") // Si 'x' es 2, se imprime "x es 2"
        else -> println("x no es 1 ni 2") // En cualquier otro caso, se imprime este mensaje.
    }
}

// ===========================
// Estructuras Iterativas
// ===========================

// Ciclo 'for' en Kotlin para iterar sobre un rango de valores.
// 'i' es el nombre de la variable, 'in 1..5' indica el rango de valores de 1 a 5.
for (i in 1..5) {
    println("Iteración número $i") // En cada iteración, imprime el valor de 'i'.
}

// Ciclo 'while', que ejecuta el bloque de código mientras la condición sea verdadera.
var i = 0
while (i < 5) { // Mientras 'i' sea menor que 5, el ciclo se ejecutará.
    println("Valor de i: $i") // Imprime el valor de 'i'.
    i++ // Incrementa 'i' en cada iteración.
}

// Ciclo 'do-while', que siempre se ejecuta al menos una vez, sin importar la condición inicial.
do {
    println("Ejecutado al menos una vez") // Este mensaje se imprime al menos una vez.
    i++
} while (i < 10) // Después de ejecutar, verifica si 'i' es menor que 10.


// ===========================
// Manejo de Excepciones con Try-Catch
// ===========================

fun dividirNumeros(a: Int, b: Int): Int {
    return try {
        a / b // Intenta dividir 'a' entre 'b'.
    } catch (e: ArithmeticException) { // Captura la excepción si 'b' es 0.
        println("Error: División por cero") 
        0 // Retorna 0 en caso de error.
    }
}

// Ejemplo de uso del manejo de excepciones
val resultadoDivision = dividirNumeros(10, 0) // Intento de dividir por cero.
println("Resultado de la división: $resultadoDivision") // Imprime el resultado.

// ===========================
// Clases y Programación Orientada a Objetos (POO)
// ===========================

// Clase simple con constructor primario.
// Aquí 'nombre' es una propiedad inmutable (val) y 'edad' es una propiedad mutable (var).
class Persona(val nombre: String, var edad: Int) {
    
    // Método dentro de la clase.
    fun presentarse() {
        println("Hola, soy $nombre y tengo $edad años.") // Utiliza las propiedades de la clase.
    }
}

// Herencia: la clase 'Empleado' hereda de 'Persona'.
// 'open' permite que la clase pueda ser heredada.
open class Persona(val nombre: String, var edad: Int) {
    open fun trabajar() { // 'open' permite que el método sea sobrescrito en clases derivadas.
        println("$nombre está trabajando")
    }
}

// Clase derivada (Empleado) que hereda de Persona.
class Empleado(nombre: String, edad: Int, val puesto: String) : Persona(nombre, edad) {
    
    // Sobrescritura de métodos con 'override'.
    override fun trabajar() {
        println("$nombre está trabajando como $puesto")
    }
}

// ===========================
// Abstracción e Interfaces
// ===========================

// Definición de una interfaz con métodos abstractos.
interface Vehiculo {
    fun arrancar() // Método abstracto para arrancar el vehículo.
    fun detener() // Método abstracto para detener el vehículo.
}

// Clase que implementa la interfaz 'Vehiculo'.
class Coche(val marca: String) : Vehiculo {
    
    // Implementación del método 'arrancar'.
    override fun arrancar() {
        println("$marca está arrancando")
    }
    
    // Implementación del método 'detener'.
    override fun detener() {
        println("$marca está detenido")
    }
}

// ===========================
// Polimorfismo
// ===========================

// Función que acepta cualquier tipo de Vehículo (polimorfismo).
fun manejarVehiculo(vehiculo: Vehiculo) {
    vehiculo.arrancar() // Llama al método arrancar del objeto pasado.
    vehiculo.detener() // Llama al método detener del objeto pasado.
}

// ===========================
// Ejemplo de uso del código
// ===========================
fun main() {
    // Variables
    val nombre: String = "Alan"
    var edad: Int = 25
    
    // Llamada a funciones
    val resultadoSuma = suma(10, 5)
    println("Resultado de la suma: $resultadoSuma")
    
    // Estructuras de control
    evaluarNumero(1)
    
    // Ciclos
    for (i in 1..5) {
        println("Iteración número $i")
    }
    
    // Creación de objetos
    val persona = Persona("Carlos", 30)
    persona.presentarse()
    
    // Herencia y polimorfismo
    val empleado = Empleado("Laura", 28, "Ingeniera")
    empleado.trabajar()

    // Interfaces y polimorfismo
    val coche = Coche("Toyota")
    manejarVehiculo(coche)

    // Excepciones
    val resultadoDivision = dividirNumeros(10, 0)
    println("Resultado de la división: $resultadoDivision")
}
