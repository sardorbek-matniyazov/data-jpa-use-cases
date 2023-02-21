package datajpausecases.service.impl

import datajpausecases.payload.OwnResponse
import datajpausecases.payload.mapper.AuthorMapper
import datajpausecases.payload.request.AuthorRequest
import datajpausecases.repository.AuthorRepository
import datajpausecases.service.AuthorService
import datajpausecases.utils.exceptions.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.by;
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    @Autowired val authorRepository: AuthorRepository,
    @Autowired val authorMapper: AuthorMapper
) : AuthorService {
    override fun getAllAuthors(): OwnResponse =
        OwnResponse.onSuccess().addData(
            "authors", authorRepository.findAll(by(Direction.DESC, "id")).map { authorMapper.toAuthorDto(it) }
        )

    override fun getAuthorById(id: Long): OwnResponse =
        OwnResponse.onSuccess().addData(
            "author", authorMapper.toAuthorDto(
                authorRepository.findById(id).orElseThrow { NotFoundException("Author not found") }
            )
        )

    override fun createAuthor(authorRequest: AuthorRequest) = OwnResponse.onSuccess().addData(
        "author", authorMapper.toAuthorDto(
            authorRepository.save(authorRequest.toAuthor())
        )
    )
}