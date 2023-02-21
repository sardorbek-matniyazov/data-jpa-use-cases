package datajpausecases.repository

import datajpausecases.model.Book
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
interface BookRepository: JpaRepository<Book, Long> {
    fun findByAuthorId(authorId: Long, sort: Sort): MutableList<Book>
}