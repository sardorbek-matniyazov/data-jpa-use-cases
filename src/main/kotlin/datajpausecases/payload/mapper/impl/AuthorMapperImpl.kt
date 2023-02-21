package datajpausecases.payload.mapper.impl

import datajpausecases.model.Author
import datajpausecases.payload.DTO.AuthorDTO
import datajpausecases.payload.mapper.AuthorMapper
import org.springframework.stereotype.Component

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
@Component
class AuthorMapperImpl : AuthorMapper {
    override fun toAuthorDto(author: Author): AuthorDTO {
        return AuthorDTO(
            id = author.id!!,
            name = author.name,
            surname = author.surname,
            age = author.age,
            books = author.books.map { book -> BookMapperImpl().toBookDto(book) }.toSet()
        )
    }

    override fun toAuthorListDto(authors: List<Author>): List<AuthorDTO> {
        return authors.map { author -> toAuthorDto(author) }
    }
}