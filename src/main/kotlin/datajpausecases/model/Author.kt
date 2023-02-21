package datajpausecases.model

import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.OneToMany
import javax.persistence.GeneratedValue
import javax.persistence.CascadeType.ALL
import javax.persistence.FetchType.LAZY
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Table

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
@Entity(name = "author")
@Table(name = "author")
data class Author(
    @Column(name = "author_name", nullable = false)
    val name: String,
    @Column(name = "author_surname", nullable = false)
    val surname: String,
    @Column(name = "author_age", nullable = false)
    val age: Int,
) {
    @Id
    @Column(name = "author_id", nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null

    @OneToMany(
        fetch = LAZY,
        cascade = [ALL],
        orphanRemoval = true,
        mappedBy = "author"
    )
    val books: MutableSet<Book> = mutableSetOf()

    constructor(name: String, surname: String, age: Int, book: Book) : this(name, surname, age) {
        book.author = this
        this.books.add(book)
    }
}
