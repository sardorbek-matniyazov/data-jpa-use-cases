package datajpausecases.utils.handler

import datajpausecases.payload.OwnResponse
import datajpausecases.utils.exceptions.NotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.function.Consumer

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 Feb 2023
 **/
@ControllerAdvice
class GlobalHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [NotFoundException::class])
    fun handleExists(e: NotFoundException): ResponseEntity<Any> {
        return OwnResponse.onNotFound().setMessage(e.message.toString()).handleResponse()
    }
    protected override fun handleMethodArgumentNotValid(
        methodArgumentNotValidException: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val messages = StringBuilder()
        methodArgumentNotValidException.bindingResult
            .allErrors.forEach(Consumer { it: ObjectError ->
                messages.append(it.defaultMessage).append(", ")
            })
        return OwnResponse.onFailed().setMessage(messages.substring(0, messages.length - 2)).handleResponse()
    }
}