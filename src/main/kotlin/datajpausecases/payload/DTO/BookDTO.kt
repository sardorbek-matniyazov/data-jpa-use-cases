package datajpausecases.payload.DTO

import com.fasterxml.jackson.databind.annotation.JsonSerialize

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
data class BookDTO(
    @JsonSerialize()
    val id: Long?,
    val name: String,
    val genre: String,
    val author: AuthorDTO
)
