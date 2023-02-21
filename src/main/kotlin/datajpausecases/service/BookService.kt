package datajpausecases.service

import datajpausecases.payload.OwnResponse
import datajpausecases.payload.request.BookRequest

interface BookService {
    fun getAllBooks(): OwnResponse
    fun getAllBooksByAuthor(authorId: Long): OwnResponse
    fun getBookById(id: Long): OwnResponse
    fun createBook(bookRequest: BookRequest): OwnResponse
}
