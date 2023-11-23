package com.aviva.wecompanytest.data.model


data class ApiResponse(
    val code: Int, // El código de estado HTTP
    val status: String, // Descripción del estado de la respuesta
    val etag: String, // Un identificador único para esta respuesta
    val data: DataContainer // El contenedor de datos real que contiene los resultados
)


data class DataContainer(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Character> // Lista de personajes
)

// Modelo para un personaje de Marvel
data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Image, // Una estructura de imagen para manejar las miniaturas
    // Puedes agregar más campos según los datos que quieras manejar
)

// Modelo para las imágenes
data class Image(
    val path: String, // El camino base de la imagen
    val extension: String // La extensión del archivo de imagen
) {
    // Puedes añadir una función para obtener la URL completa de la imagen
    fun getUrl(): String = "$path.$extension"
}