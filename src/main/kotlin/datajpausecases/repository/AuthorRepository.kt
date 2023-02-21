package datajpausecases.repository

import datajpausecases.model.Author
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
interface AuthorRepository: JpaRepository<Author, Long> {
}