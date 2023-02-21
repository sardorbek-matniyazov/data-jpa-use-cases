package datajpausecases.payload.request

import datajpausecases.model.Author
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
data class AuthorRequest(
    @field:NotBlank(message = "Name must not be empty")
    val name: String,
    @field:NotBlank(message = "Surname must not be empty")
    val surname: String,
    @field:NotNull(message = "Age must not be empty")
    val age: Int,
) {
    fun toAuthor() = Author(name, surname, age)
}
