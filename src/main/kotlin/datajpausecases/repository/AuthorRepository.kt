package datajpausecases.repository

import datajpausecases.model.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
interface AuthorRepository: JpaRepository<Author, Long> {
    @Query(
        "select * from author a where a.author_name = ?1",
        nativeQuery = true
    )
    fun findByName(name: String): List<Author>
}