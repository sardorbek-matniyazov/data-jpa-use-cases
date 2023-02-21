package datajpausecases.controller

import datajpausecases.payload.request.BookRequest
import datajpausecases.service.BookService
import org.springframework.http.HttpEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
@RestController
@RequestMapping("/api/books")
class BookController(
    val bookService: BookService,
) {
    @GetMapping
    fun getAllBooks(): HttpEntity<Any> = bookService.getAllBooks().handleResponse()

    @GetMapping("author/{authorId}")
    fun getAllBooksByAuthor(@PathVariable authorId: Long): HttpEntity<Any> =
        bookService.getAllBooksByAuthor(authorId).handleResponse()

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Long): HttpEntity<Any> = bookService.getBookById(id).handleResponse()

    @PostMapping
    fun createBook(@RequestBody @Valid bookRequest: BookRequest): HttpEntity<Any> =
        bookService.createBook(bookRequest).handleResponse()
}