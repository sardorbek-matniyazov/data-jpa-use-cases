package datajpausecases.payload.request

import datajpausecases.model.Author
import datajpausecases.model.Book
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class BookRequest(
    @field:NotBlank(message = "Name must not be blank")
    val name: String,
    @field:NotNull(message = "Genre must not be blank")
    val authorId: Long,
    @field:NotBlank(message = "Genre must not be blank")
    val genre: String,
) {
    fun toBook(author: Author) = Book(
        name = name,
        genre = genre,
        author = author
    )
}
