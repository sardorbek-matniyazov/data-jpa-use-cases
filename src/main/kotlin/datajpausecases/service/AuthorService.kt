package datajpausecases.service

import datajpausecases.payload.OwnResponse
import datajpausecases.payload.request.AuthorRequest

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
interface AuthorService {
    fun getAllAuthors(): OwnResponse
    fun getAuthorById(id: Long): OwnResponse
    fun createAuthor(authorRequest: AuthorRequest): OwnResponse
}