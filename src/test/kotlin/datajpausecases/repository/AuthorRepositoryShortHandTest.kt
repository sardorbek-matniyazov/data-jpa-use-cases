package datajpausecases.repository

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.jdbc.Sql

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 01 Mar 2023
 **/
@DataJpaTest(showSql = true)
class AuthorRepositoryShortHandTest {
    @Autowired
    private lateinit var authorRepository: AuthorRepository
    @Test
    @Sql("/scripts/INIT_DEFAULT_AUTHORS.sql")
    fun `should find author by name`() {
        // finding author by name
        val author = authorRepository.findByName("Lebron")
        assertEquals(1, author.size)
    }

    @Test
    @Sql("/scripts/INIT_DEFAULT_AUTHORS.sql")
    fun `multiple authors with same name`() {
        // finding author by name
        val author = authorRepository.findByName("John")
        assertEquals(2, author.size)
        assertEquals("Smith", author[0].surname)
        assertEquals("Doe", author[1].surname)
    }

}