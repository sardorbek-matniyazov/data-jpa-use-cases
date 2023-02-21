package datajpausecases.payload.mapper.impl

import datajpausecases.payload.DTO.BookDTO
import datajpausecases.payload.mapper.BookMapper
import datajpausecases.model.Book
import org.springframework.stereotype.Component

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
@Component
class BookMapperImpl: BookMapper {
    override fun toBookDto(book: Book): BookDTO = BookDTO(
            id = book.id,
            name = book.name,
            genre = book.genre,
            author = AuthorMapperImpl().toAuthorDto(book.author!!)
        )

    override fun toBookListDto(books: List<Book>): List<BookDTO> = books.map { book -> toBookDto(book) }
}