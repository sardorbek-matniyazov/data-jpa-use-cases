package datajpausecases.payload.DTO

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
data class AuthorDTO(
    val id: Long,
    val name: String,
    val surname: String,
    val age: Int,
    val books: Set<BookDTO>,
) {
}
