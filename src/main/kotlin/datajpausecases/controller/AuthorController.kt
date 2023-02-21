package datajpausecases.controller

import datajpausecases.payload.OwnResponse
import datajpausecases.payload.request.AuthorRequest
import datajpausecases.service.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
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
@RequestMapping("/api/authors")
class AuthorController(
    @Autowired val authorService: AuthorService
) {
    @GetMapping
    fun getAllAuthors(): HttpEntity<Any> = authorService.getAllAuthors().handleResponse()

    @GetMapping("{id}")
    fun getAuthorById(@PathVariable id: Long): HttpEntity<Any> = authorService.getAuthorById(id).handleResponse()

    @PostMapping
    fun createAuthor(@RequestBody @Valid authorRequest: AuthorRequest): HttpEntity<Any> =
        authorService.createAuthor(authorRequest).handleResponse()
}