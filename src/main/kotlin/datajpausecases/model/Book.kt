package datajpausecases.model

import javax.persistence.CascadeType.PERSIST
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
@Entity(name = "book")
data class Book(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long,
    val name: String,

    @ManyToOne(
        optional = false,
        targetEntity = Author::class,
        cascade = [PERSIST],
    )
    @JoinColumn(name = "author_fk", nullable = false)
    var author: Author
) {
}
