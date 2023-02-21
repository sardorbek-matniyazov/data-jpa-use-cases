package datajpausecases.payload.mapper

import org.mapstruct.Mapper
import datajpausecases.payload.DTO.BookDTO
import datajpausecases.model.Book

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
@Mapper(componentModel = "spring", uses = [AuthorMapper::class])
interface BookMapper {
    fun toBookDto(book: Book): BookDTO
    fun toBookListDto(books: List<Book>): List<BookDTO>
}