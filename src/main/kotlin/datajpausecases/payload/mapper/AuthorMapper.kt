package datajpausecases.payload.mapper

import datajpausecases.model.Author
import datajpausecases.payload.DTO.AuthorDTO
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = [BookMapper::class])
interface AuthorMapper {
    fun toAuthorDto(author: Author): AuthorDTO
    fun toAuthorListDto(authors: List<Author>): List<AuthorDTO>
}