package datajpausecases.repository

import datajpausecases.model.Author
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManager
import javax.sql.DataSource

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 01 Mar 2023
 **/
@DataJpaTest(showSql = true)
class AuthorRepositoryTest {

    @Autowired
    private lateinit var entityManager: EntityManager
    @Autowired
    private lateinit var dataSource: DataSource
    @Autowired
    private lateinit var authorRepository: AuthorRepository
    @Test
    fun contextLoad() {
        assertNotNull(entityManager)
        assertNotNull(dataSource)
        assertNotNull(authorRepository)
    }

    @Test
    fun `should find author by name`() {
        // saving author
        val auth1 = createAuthor("Sardor", "Matniyazov", 20)
        val auth2 = createAuthor("Lebron", "James", 35)
        val auth3 = createAuthor("Kobe", "Bryant", 40)

        // finding author by name
        val author = authorRepository.findByName("Sardor")
        assertEquals(1, author.size)
    }

    @Test
    fun `multiple authors with same name`() {
        // saving author
        val auth1 = createAuthor("Sardor", "Matniyazov", 20)
        val auth2 = createAuthor("Lebron", "James", 35)
        val auth3 = createAuthor("Kobe", "Bryant", 40)
        val auth4 = createAuthor("Tom", "Hanks", 60)
        val auth5 = createAuthor("Tom", "Cruise", 50)

        // finding author by name
        val author = authorRepository.findByName("Tom")
        assertEquals(2, author.size)
        assertEquals("Tom", author[0].name)
        assertEquals("Hanks", author[0].surname)
    }

    private fun createAuthor(name: String, surname: String, age: Int) = authorRepository.save(Author(name, surname, age))

}