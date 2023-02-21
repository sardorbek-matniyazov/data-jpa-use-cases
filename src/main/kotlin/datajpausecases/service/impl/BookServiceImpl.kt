package datajpausecases.service.impl

import datajpausecases.payload.OwnResponse
import datajpausecases.payload.mapper.BookMapper
import datajpausecases.payload.request.BookRequest
import datajpausecases.repository.AuthorRepository
import datajpausecases.repository.BookRepository
import datajpausecases.service.BookService
import datajpausecases.utils.exceptions.NotFoundException
import net.bytebuddy.TypeCache.Sort
import org.springframework.data.domain.Sort.by;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
@Service
class BookServiceImpl(
    val bookRepository: BookRepository,
    val authorRepository: AuthorRepository,
    val bookMapper: BookMapper
) : BookService {
    override fun getAllBooks(): OwnResponse = OwnResponse.onSuccess().addData(
        "books", bookRepository.findAll().map { bookMapper.toBookDto(it) }
    )

    override fun getAllBooksByAuthor(authorId: Long): OwnResponse = OwnResponse.onSuccess().addData(
        "book", bookRepository.findByAuthorId(
            authorId,
            by(Direction.DESC, "id")
        ).map { bookMapper.toBookDto( it ) }
    )

    override fun getBookById(id: Long): OwnResponse = OwnResponse.onSuccess().addData(
        "book", bookMapper.toBookDto(bookRepository.findById(id).orElseThrow { throw NotFoundException("Book not found") })
    )

    override fun createBook(bookRequest: BookRequest): OwnResponse = authorRepository.findById(bookRequest.authorId)
        .map { author ->
            bookRepository.save(bookRequest.toBook(author))
        }.map { book ->
            OwnResponse.onSuccess().addData("book", bookMapper.toBookDto(book))
        }.orElseThrow { throw NotFoundException("Author not found") }
}